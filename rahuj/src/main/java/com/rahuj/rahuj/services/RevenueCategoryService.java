package com.rahuj.rahuj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rahuj.rahuj.dto.RevenueCategoryDTO;
import com.rahuj.rahuj.models.RevenueCategory;
import com.rahuj.rahuj.repositories.RevenueCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class RevenueCategoryService {
        private final RevenueCategoryRepository repository;

    public RevenueCategoryService(RevenueCategoryRepository rep){
        repository = rep;
    }

    @Transactional
    public void addNewCategory(String name) throws Exception{
        RevenueCategory category = new RevenueCategory(name);
        repository.save(category);
    }

    @Transactional
    public void addNewCategory(RevenueCategory category) throws Exception{
        repository.save(category);
    }

    @Transactional
    public void deleteCategory(RevenueCategory category){
        repository.delete(category);
    }

    @Transactional
    public List<RevenueCategoryDTO> getAllRevCategoriesAsDTO(){
        List<RevenueCategoryDTO> listRevenueCategoryDTOs = new ArrayList<>();

        for(RevenueCategory cat : repository.findAll()){
            listRevenueCategoryDTOs.add(RevenueCategoryDTO.of(cat));
        }

        return listRevenueCategoryDTOs;
    }
}
