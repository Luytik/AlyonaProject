package com.rahuj.rahuj.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahuj.rahuj.dto.ClientDTO;
import com.rahuj.rahuj.dto.RegistrationRequest;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.repositories.ClientRepository;
import com.rahuj.rahuj.services.ClientService;
import com.rahuj.rahuj.services.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AuthenticationManager authenticationManager;
    private final ClientService clientService;
    private final ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute ClientDTO clientDTO) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        clientDTO.getLogin(), clientDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication.getName());
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @PostMapping
    public ResponseEntity<?> sigup(@ModelAttribute RegistrationRequest registrationRequest){
        registrationService.register(registrationRequest);
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClientDTO();
    }

    @GetMapping("/test")
    public Client isAuth(@CurrentSecurityContext SecurityContext context){
        System.out.println("****************");
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("******************");
        return clientRepository.findByLogin(context.getAuthentication().getName());
    }
}
