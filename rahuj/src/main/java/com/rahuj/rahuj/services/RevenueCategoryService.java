package com.rahuj.rahuj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rahuj.rahuj.dto.RevenueCategoryDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.RevenueCategory;
import com.rahuj.rahuj.repositories.ClientRepository;
import com.rahuj.rahuj.repositories.RevenueCategoryRepository;

import lombok.AllArgsConstructor;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class RevenueCategoryService {
        private final RevenueCategoryRepository repository;
        private final ClientRepository clientRepository;

    @Transactional
    public void addNewCategory(RevenueCategory category, String clientLogin) throws Exception{
        Client client = clientRepository.findByLogin(clientLogin);
        category.setClient(client);
        repository.save(category);
    }

    @Transactional
    public List<RevenueCategoryDTO> getAllRevCategoriesAsDTOByClient(String clientLogin){
        Client client = clientRepository.findByLogin(clientLogin);
        List<RevenueCategoryDTO> listRevenueCategoryDTOs = new ArrayList<>();

        for(RevenueCategory cat : repository.findAllByClient(client)){
            listRevenueCategoryDTOs.add(RevenueCategoryDTO.of(cat));
        }

        return listRevenueCategoryDTOs;
    }
}
