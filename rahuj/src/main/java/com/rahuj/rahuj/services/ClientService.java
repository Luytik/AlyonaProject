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

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, email)));
    }

    @Transactional
    public String signUpClient(Client client) {
        boolean clientExist = clientRepository
                .findByEmail(client.getEmail()).isPresent();

        if (clientExist) {
            throw new IllegalStateException("email already taken");
        }

        String encodePassword = bCryptPasswordEncoder
                .encode(client.getPassword());

        client.setPassword(encodePassword);

        clientRepository.save(client);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
            token,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(15),
            client);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        // TODO: SEND Email
        return token;
    }
        public int enableClient(String email){
                return clientRepository.enableClient(email);
        }

        public boolean isClientExist(String email){
              return clientRepository.isClientExist(email);
        }
}
