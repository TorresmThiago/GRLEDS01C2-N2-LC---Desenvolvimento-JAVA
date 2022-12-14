package br.edu.infnet.appseguranca.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appseguranca.model.domain.Analise;
import br.edu.infnet.appseguranca.model.domain.Aplicacao;
import br.edu.infnet.appseguranca.model.domain.VulnAPI;
import br.edu.infnet.appseguranca.model.domain.VulnMobile;
import br.edu.infnet.appseguranca.model.domain.VulnWeb;
import br.edu.infnet.appseguranca.model.domain.Vulnerabilidade;
import br.edu.infnet.appseguranca.model.exceptions.*;

public class ArquivoTeste {

    public static void main(String[] args) throws Exception {

        String arq = "analise.txt";

        try {
            FileReader fileR = new FileReader(arq);
            BufferedReader leitura = new BufferedReader(fileR);

            FileWriter fileW = new FileWriter("out_" + arq);
            BufferedWriter escrita = new BufferedWriter(fileW);

            String linha = leitura.readLine();
            String[] campos = null;

            List<Vulnerabilidade> vulnerabilidades = new ArrayList<Vulnerabilidade>();
            Analise analise = null;
            Aplicacao aplicacao = null;

            while (linha != null) {

                campos = linha.split(";");

                switch (campos[0].toUpperCase()) {
                    case "N":
                        try {
                            analise = new Analise(Integer.parseInt(campos[1]), campos[2], campos[3], campos[4],
                                    campos[5], Integer.parseInt(campos[6]), campos[7], campos[8], campos[9]);

                            analise.setAplicacao(aplicacao);
                        } catch (Exception e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;

                    case "P":
                        try {
                            aplicacao = new Aplicacao(analise, Integer.parseInt(campos[1]), campos[2], campos[3],
                                    campos[4], campos[5]);
                        } catch (Exception e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;

                    case "W":
                        try {
                            String[] urlAfetada = campos[9].split("||");
                            VulnWeb vulnWeb = new VulnWeb(Integer.parseInt(campos[1]), campos[2], campos[3], campos[4],
                                    Integer.parseInt(campos[5]), Integer.parseInt(campos[6]), campos[7], campos[8],
                                    urlAfetada, Boolean.valueOf(campos[10]), campos[11]);
                            vulnerabilidades.add(vulnWeb);
                        } catch (VulnWebInvalidaException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;

                    case "M":
                        try {
                            String[] pacotesAfetados = campos[10].split("||");
                            VulnMobile vulnMobile = new VulnMobile(Integer.parseInt(campos[1]), campos[2], campos[3],
                                    campos[4], Integer.parseInt(campos[5]), Integer.parseInt(campos[6]), campos[7],
                                    campos[8], campos[9], pacotesAfetados);
                            vulnerabilidades.add(vulnMobile);
                        } catch (VulnMobileInvalidaException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;

                    case "A":
                        try {
                            VulnAPI vulnAPI = new VulnAPI(Integer.parseInt(campos[1]), campos[2], campos[3], campos[4],
                                    Integer.parseInt(campos[5]), Integer.parseInt(campos[6]), campos[7], campos[8],
                                    campos[9], campos[10], campos[11]);
                            vulnerabilidades.add(vulnAPI);
                        } catch (VulnAPIInvalidaException e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Registro inválido!!!");
                        break;
                }
                linha = leitura.readLine();
            }

            analise.setAplicacao(aplicacao);

            Vulnerabilidade[] vulns = new Vulnerabilidade[vulnerabilidades.size()];
            vulns = vulnerabilidades.toArray(vulns);
            aplicacao.setVulnerabilidades(vulns);

            escrita.write(analise.obterLinha());

            escrita.close();
            leitura.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

    }
}
