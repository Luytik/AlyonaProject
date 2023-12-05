package com.rahuj.rahuj.dto;

import com.rahuj.rahuj.models.Client;

import lombok.Data;

@Data
public class ClientDTO {
    private String login;
    private String email;
    private String password;

    public static Client of(ClientDTO clientDTO){
        Client client = new Client();
        client.setLogin(clientDTO.getLogin());
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());
        return client;
    }
}
