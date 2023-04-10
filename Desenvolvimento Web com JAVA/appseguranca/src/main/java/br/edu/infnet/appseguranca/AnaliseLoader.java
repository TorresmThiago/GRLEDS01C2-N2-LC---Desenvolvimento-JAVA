package br.edu.infnet.appseguranca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Usuario;
import br.edu.infnet.appseguranca.model.service.AnaliseService;

@Order(2)
@Component
public class AnaliseLoader implements ApplicationRunner {

    @Autowired
    AnaliseService analiseService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String arq = "analise.txt";
        Usuario usuario = new Usuario();
        usuario.setId(1);

        try {
            FileReader fileR = new FileReader(arq);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;

            while (linha != null) {

                campos = linha.split(";");
                linha = leitura.readLine();

                Analise analise = new Analise(campos[0], campos[1], campos[2], campos[3], Integer.parseInt(campos[4]),
                        campos[5], campos[6], campos[7]);
                analise.setUsuario(usuario);
                analiseService.incluir(analise);
            }

            leitura.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }

}
