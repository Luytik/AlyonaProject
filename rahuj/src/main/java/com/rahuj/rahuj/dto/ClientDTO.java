package com.rahuj.rahuj.dto;

import com.rahuj.rahuj.models.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {
    private String login;
    private String password;

    public static ClientDTO of(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setLogin(client.getEmail());
        clientDTO.setPassword(client.getPassword());
        return clientDTO;
    }
}
