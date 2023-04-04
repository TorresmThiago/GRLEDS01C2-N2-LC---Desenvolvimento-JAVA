package br.edu.infnet.appseguranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appseguranca.model.domain.EmailReputation;
import br.edu.infnet.appseguranca.model.service.EmailReputationService;

@Controller
public class EmailReputationController {

    @Autowired
    private EmailReputationService emailReputationService;

    @PostMapping("/emailReputation")
    public String checkEmailReputation(Model model, @RequestParam String emailToCheck) {
        EmailReputation emailReputation = emailReputationService.checkEmailReputation(emailToCheck);
        model.addAttribute("emailReputation", emailReputation);
        return "usuario/cadastro";
    }

}
