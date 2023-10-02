package com.rahuj.rahuj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.rahuj.rahuj.dto.ExpenditureDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.Expenditure;
import com.rahuj.rahuj.models.ExpenditureCategory;
import com.rahuj.rahuj.repositories.ExpenditureCategoryRepository;
import com.rahuj.rahuj.repositories.ExpenditureRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final ExpenditureCategoryRepository expenditureCategoryRepository;
    private final ExpenditureCategoryService expenditureCategoryService;

    @Transactional
    public void saveExpenditure(ExpenditureDTO expenditureDTO) throws Exception {
        Expenditure expenditure = ExpenditureDTO.from(expenditureDTO);

        // щіт
        String category = expenditureDTO.getExpenditureCategoryDTO().getExpenditureCategoryDTO();

        if (expenditureCategoryRepository.existsByExpenditureCategory(category)) {
            var expCategory = expenditureCategoryRepository.findByExpenditureCategory(category);
            expenditure.setExpenditureCategory(expCategory.get());
        } else {
            ExpenditureCategory newExpenditureCategory = new ExpenditureCategory(category);
            expenditureCategoryService.addNewCategory(newExpenditureCategory);
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
    public List<ExpenditureDTO> gExpenditureDTOsByClient(Client client) {
        List<ExpenditureDTO> expenditureDTOList = new ArrayList<>();
        List<Expenditure> expenditureList = expenditureRepository.findAllByClient(client);
        for (Expenditure e : expenditureList) {
            expenditureDTOList.add(ExpenditureDTO.of(e));
        }

        return expenditureDTOList;
    }
}
