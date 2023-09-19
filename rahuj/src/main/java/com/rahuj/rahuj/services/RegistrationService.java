package com.rahuj.rahuj.services;

import org.springframework.stereotype.Service;

import com.rahuj.rahuj.models.Client;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final ClientService clientService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not found");
        }
        return clientService.signUpUser(
            new Client(
                 request.getLogin(),
                 request.getLogin(),
                 request.getPassword()
            )
        );
    };    
}
