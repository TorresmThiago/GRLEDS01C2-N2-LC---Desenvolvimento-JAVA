package br.edu.infnet.appseguranca.controller;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.service.AplicacaoService;
import br.edu.infnet.appseguranca.model.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AplicacaoService aplicacaoService;

    @Autowired
    private AmazonS3 amazonS3;

    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista(Model model) {
        Collection<Usuario> usuarios = usuarioService.obterLista();

        for (Usuario usuario : usuarios) {
            usuario.setAplicacoes((List<Aplicacao>) aplicacaoService.obterLista(usuario.getId()));
        }

        model.addAttribute("usuarios", usuarios);
        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir", consumes = { "multipart/form-data" })
    public String incluir(Usuario usuario, MultipartFile foto) {

        String randomFileName = UUID.randomUUID().toString() + ".jpg";
        PutObjectRequest putObjectRequest;
        try {
            putObjectRequest = new PutObjectRequest("at-dr4-bucket", randomFileName,
                    foto.getInputStream(), null);
            amazonS3.putObject(putObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        usuario.setEndFoto(randomFileName);
        usuarioService.incluir(usuario);

        return "redirect:/usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        usuarioService.excluir(id);
        return "redirect:/usuario/lista";
    }
}
