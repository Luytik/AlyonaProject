package com.rahuj.rahuj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rahuj.rahuj.dto.RevenueDTO;
import com.rahuj.rahuj.models.Revenue;
import com.rahuj.rahuj.models.RevenueCategory;
import com.rahuj.rahuj.repositories.RevenueCategoryRepository;
import com.rahuj.rahuj.repositories.RevenueRepository;

import javax.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RevenueService {
    private final RevenueRepository revenueRepository;
    private final RevenueCategoryRepository revenueCategoryRepository;
    private final RevenueCategoryService revenueCategoryService;

    @Transactional
    public void saveRevenue(RevenueDTO revenueDTO) throws Exception {
        Revenue revenue = RevenueDTO.from(revenueDTO);
        // щіт
        String category = revenueDTO.getRevenueCategoryDTO().getRevenueCategoryDTO();
        if (revenueCategoryRepository.existsByRevenueCategory(category)) {
            var revCategory = revenueCategoryRepository.findByRevenueCategory(category);
            revenue.setRevenueCategory(revCategory.get());
        } else {
            RevenueCategory newRevenueCategory = new RevenueCategory(category);
            revenueCategoryService.addNewCategory(newRevenueCategory);
            revenue.setRevenueCategory(newRevenueCategory);
        }
        revenueRepository.save(revenue);
    }

    @Transactional
    public List<RevenueDTO> getAllRevCategoriesAsDTO(){
        List<RevenueDTO> revenueDTOList = new ArrayList<>();
        for(Revenue revenue : revenueRepository.findAll()){
            revenueDTOList.add(RevenueDTO.of(revenue));
        }
        return revenueDTOList;
    }

}
