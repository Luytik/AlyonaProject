package com.rahuj.rahuj.api;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahuj.rahuj.dto.ClientDTO;
import com.rahuj.rahuj.dto.LoginDto;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.services.ClientDetail;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthRestController {

    @Autowired
    private final AuthenticationManager authenticationManager;
    private final ClientDetail clientDetail;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@ModelAttribute LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        clientDetail.signInClient(loginDto.getLogin());
        return new ResponseEntity<>(SecurityContextHolder.getContext().getAuthentication().getName(), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> postMethodName(@ModelAttribute ClientDTO clientDTO) {
        if(!clientDetail.isExistClient(clientDTO.getLogin())){
            Client client = ClientDTO.of(clientDTO);
            client.setPassword(encoder.encode(clientDTO.getPassword()));
            clientDetail.signUpClient(client);
            return new ResponseEntity<>("Created", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something goes wrong", HttpStatus.CONFLICT);           
    }

    @PostMapping("/logout")
    public void logout(@RequestBody String login){
        clientDetail.logoutClient(login);
    }
    
    @CrossOrigin
    @GetMapping("/test")
    public String test() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
