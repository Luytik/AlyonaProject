package com.rahuj.rahuj.services;

import org.springframework.stereotype.Service;

import com.rahuj.rahuj.models.ConfirmationToken;
import com.rahuj.rahuj.repositories.ConfirmationTokenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmaionTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
}
