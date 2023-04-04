package br.edu.infnet.appseguranca.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appseguranca.clients.IEmailReputationClient;
import br.edu.infnet.appseguranca.model.domain.EmailReputation;

@Service
public class EmailReputationService {

    @Autowired
    private IEmailReputationClient emailReputationClient;

    public EmailReputation checkEmailReputation(String email) {
        return emailReputationClient.checkEmailReputation(email);
    }

}
