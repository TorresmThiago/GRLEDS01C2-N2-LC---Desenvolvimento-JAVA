package br.edu.infnet.appseguranca.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appseguranca.model.domain.EmailReputation;

@FeignClient(name = "emailReputation", url = "https://emailrep.io")
public interface IEmailReputationClient {

    @GetMapping("/{email}")
    EmailReputation checkEmailReputation(@PathVariable String email);

}
