package com.rahuj.rahuj.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.ConfirmationToken;
import com.rahuj.rahuj.repositories.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements UserDetailsService {

    private static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmaionTokenService confirmaionTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(Client client) {
        boolean clientExist = clientRepository.findByEmail(client.getEmail()).isPresent();

        if (clientExist) {
            throw new IllegalStateException("email alredy taken");
        }

        String encode = bCryptPasswordEncoder.encode(client.getPassword());
        client.setPassword(encode);

        clientRepository.save(client);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                client);
        confirmaionTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

}
