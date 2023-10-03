package com.rahuj.rahuj.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.rahuj.rahuj.dto.ExpenditureDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.Expenditure;
import com.rahuj.rahuj.models.ExpenditureCategory;
import com.rahuj.rahuj.repositories.ClientRepository;
import com.rahuj.rahuj.repositories.ExpenditureCategoryRepository;
import com.rahuj.rahuj.repositories.ExpenditureRepository;

import javax.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final ExpenditureCategoryRepository expenditureCategoryRepository;
    private final ExpenditureCategoryService expenditureCategoryService;
    private final ClientRepository clientRepository;

    @Transactional
    public void saveExpenditure(ExpenditureDTO expenditureDTO, String clientLogin) throws Exception {

        Expenditure expenditure = ExpenditureDTO.from(expenditureDTO);
        Client client = clientRepository.findByLogin(clientLogin);
        expenditure.setClient(client);
        // щіт
        String category = expenditureDTO.getExpenditureCategoryDTO().getExpenditureCategoryDTO();

        if (expenditureCategoryRepository.existsByExpenditureCategory(category)) {
            var expCategory = expenditureCategoryRepository.findByExpenditureCategory(category);
            expenditure.setExpenditureCategory(expCategory.get());
        } else {
            ExpenditureCategory newExpenditureCategory = new ExpenditureCategory(category);
            expenditureCategoryService.addNewCategory(newExpenditureCategory, clientLogin);
            expenditure.setExpenditureCategory(newExpenditureCategory);
        }
        expenditureRepository.save(expenditure);
    }

    @Transactional
    public List<ExpenditureDTO> getAllExpCategoriesAsDto() {
        List<ExpenditureDTO> expenditureDTOList = new ArrayList<>();
        for (Expenditure expenditure : expenditureRepository.findAll()) {
            expenditureDTOList.add(ExpenditureDTO.of(expenditure));
        }
        return expenditureDTOList;
    }

    @Transactional
    public List<ExpenditureDTO> getEpenditureDTOsByClient(String clientLogin) {
        Client client = clientRepository.findByLogin(clientLogin);
        System.out.println("*******************************");
        System.out.println(client.getEmail());
        System.out.println("*******************************");
        List<ExpenditureDTO> expenditureDTOList = new ArrayList<>();
        ArrayList<Expenditure> expenditureList = expenditureRepository.findAllByClientId(client.getId());
        System.out.println("*******************************");
        System.out.println(expenditureList.size());
        System.out.println("*******************************");
        for (Expenditure e : expenditureList) {
            expenditureDTOList.add(ExpenditureDTO.of(e));
        }

        return expenditureDTOList;
    }
}
