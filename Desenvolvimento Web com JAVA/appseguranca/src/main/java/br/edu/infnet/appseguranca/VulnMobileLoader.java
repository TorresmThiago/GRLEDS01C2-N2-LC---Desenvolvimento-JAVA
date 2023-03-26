package br.edu.infnet.appseguranca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.service.VulnMobileService;

@Component
public class VulnMobileLoader implements ApplicationRunner {

    @Autowired
    VulnMobileService vulnMobileService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String arq = "vulnMobile.txt";

        try {
            FileReader fileR = new FileReader(arq);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;

            Usuario usuario = new Usuario();
            usuario.setId(1);

            Aplicacao aplicacao = new Aplicacao();
            aplicacao.setId(1);

            while (linha != null) {

                campos = linha.split(";");
                linha = leitura.readLine();

                VulnMobile vulnMobile = new VulnMobile(0, campos[0], campos[1], campos[2],
                        Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), campos[5], campos[6],
                        campos[7], Integer.parseInt(campos[8]));

                vulnMobile.setUsuario(usuario);
                vulnMobile.setAplicacao(aplicacao);
                vulnMobileService.incluir(vulnMobile);
            }

            leitura.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }

}
