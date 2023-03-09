package br.edu.infnet.appseguranca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.service.AplicacaoService;

@Component
public class AplicacaoLoader implements ApplicationRunner {

    @Autowired
    AplicacaoService aplicacaoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String arq = "aplicacao.txt";

        try {
            FileReader fileR = new FileReader(arq);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;

            while (linha != null) {

                campos = linha.split(";");
                linha = leitura.readLine();

                Aplicacao aplicacao = new Aplicacao(campos[0], campos[1], campos[2], campos[3]);
                aplicacaoService.incluir(aplicacao);
            }

            leitura.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }

}