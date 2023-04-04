package br.edu.infnet.appseguranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppsegurancaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppsegurancaApplication.class, args);
    }

}
