package com.rahuj.rahuj.services;

import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.repositories.ClientRepository;

@Service
public class ClientDetail implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByLogin(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not exists by Username");
        }

        Set<GrantedAuthority> authorities = client.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(username, client.getPassword(), authorities);
    }

    @Transactional
    public void signUpClient(Client client){
        clientRepository.save(client);
    }

    @Transactional
    public void signInClient(String login){
        clientRepository.updateIsLogginedByUsername(login, true);
    }

    @Transactional
    public void logoutClient(String login){
        clientRepository.updateIsLogginedByUsername(login, false);
    }

    @Transactional
    public boolean isUserLogginedIn(String login){
        return clientRepository.findIsLogginedInByLogin(login);
    }

    @Transactional
    public boolean isExistClient(String login){
        return clientRepository.existsByLogin(login);
    }

}
