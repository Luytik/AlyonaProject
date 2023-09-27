package com.rahuj.rahuj.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.rahuj.rahuj.dto.ExpenditureCategoryDTO;
import com.rahuj.rahuj.models.ExpenditureCategory;
import com.rahuj.rahuj.repositories.ExpenditureCategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenditureCategoryService {

    private final ExpenditureCategoryRepository repository;

    public ExpenditureCategoryService(ExpenditureCategoryRepository rep){
        repository = rep;
    }

    @Transactional
    public void addNewCategory(String name) throws Exception{
        ExpenditureCategory category = new ExpenditureCategory(name);
        repository.save(category);
    }

    @Transactional
    public void addNewCategory(ExpenditureCategory category) throws Exception{
        repository.save(category);
    }

    @Transactional
    public void deleteCategory(ExpenditureCategory category){
        repository.delete(category);
    }

    @Transactional
    public List<ExpenditureCategoryDTO> getAllExpCategoriesAsDto(){
        List<ExpenditureCategoryDTO> listCategoryDTOs = new ArrayList<>();

        for(ExpenditureCategory cat : repository.findAll()){
            listCategoryDTOs.add(ExpenditureCategoryDTO.of(cat));
        }

        return listCategoryDTOs;

    }
}
