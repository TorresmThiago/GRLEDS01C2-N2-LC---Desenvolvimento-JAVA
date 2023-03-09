package br.edu.infnet.appseguranca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.service.VulnAPIService;

@Component
public class VulnAPILoader implements ApplicationRunner {

    @Autowired
    VulnAPIService vulnAPIService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String arq = "vulnAPI.txt";

        try {
            FileReader fileR = new FileReader(arq);
            BufferedReader leitura = new BufferedReader(fileR);

            String linha = leitura.readLine();
            String[] campos = null;

            while (linha != null) {

                campos = linha.split(";");
                linha = leitura.readLine();

                VulnAPI vulnAPI = new VulnAPI(0, campos[0], campos[1], campos[2],
                        Integer.parseInt(campos[3]), Integer.parseInt(campos[4]), campos[5], campos[6],
                        campos[7], campos[8], campos[9]);
                vulnAPIService.incluir(vulnAPI);
            }

            leitura.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }

}
