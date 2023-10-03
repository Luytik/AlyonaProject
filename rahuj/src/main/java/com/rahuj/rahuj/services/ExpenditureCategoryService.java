package com.rahuj.rahuj.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.rahuj.rahuj.dto.ExpenditureCategoryDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.ExpenditureCategory;
import com.rahuj.rahuj.repositories.ClientRepository;
import com.rahuj.rahuj.repositories.ExpenditureCategoryRepository;

import lombok.AllArgsConstructor;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ExpenditureCategoryService {

    private final ExpenditureCategoryRepository repository;
    private final ClientRepository clientRepository;

    @Transactional
    public void addNewCategory(ExpenditureCategory category, String clientLogin) throws Exception{
        Client client = clientRepository.findByLogin(clientLogin);
        category.setClient(client);
        repository.save(category);
    }

    @Transactional
    public List<ExpenditureCategoryDTO> getAllExpCategoriesAsDtoByClient(String clientLogin){
        Client client = clientRepository.findByLogin(clientLogin);
        List<ExpenditureCategoryDTO> listCategoryDTOs = new ArrayList<>();
        for(ExpenditureCategory cat : repository.findAllByClient(client)){
            listCategoryDTOs.add(ExpenditureCategoryDTO.of(cat));
        }        
        return listCategoryDTOs;
    }
}
