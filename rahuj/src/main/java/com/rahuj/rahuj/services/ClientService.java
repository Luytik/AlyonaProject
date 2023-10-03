package com.rahuj.rahuj.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rahuj.rahuj.dto.ClientDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.ConfirmationToken;
import com.rahuj.rahuj.repositories.ClientRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements UserDetailsService {

        private final ClientRepository clientRepository;
        private final BCryptPasswordEncoder bCryptPasswordEncoder;
        private final ConfirmationTokenService confirmationTokenService;

        @Override
        public UserDetails loadUserByUsername(String login)
                        throws UsernameNotFoundException {
                return clientRepository.findByLogin(login);
        }

        @Transactional
        public String signUpClient(Client client) {

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

        public int enableClient(String email) {
                return clientRepository.enableClient(email);
        }

        // public boolean isClientExist(String email) {
        //         return clientRepository.isClientExist(email);
        // }

        @Transactional
        public List<ClientDTO> getAllClientDTO(){
                List<ClientDTO> clientDTOlist = new ArrayList<>();
                for(Client c : clientRepository.findAll()){
                        clientDTOlist.add(ClientDTO.of(c));
                }
                return clientDTOlist;
        }
}
