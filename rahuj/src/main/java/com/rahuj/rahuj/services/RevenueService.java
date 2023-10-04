package com.rahuj.rahuj.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.rahuj.rahuj.dto.RevenueDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.Revenue;
import com.rahuj.rahuj.models.RevenueCategory;
import com.rahuj.rahuj.repositories.ClientRepository;
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
    private final ClientRepository clientRepository;

    @Transactional
    public void saveRevenue(RevenueDTO revenueDTO, String clientLogin) throws Exception {
        Client client = clientRepository.findByLogin(clientLogin);
        Revenue revenue = RevenueDTO.from(revenueDTO);
        revenue.setClient(client);
        // щіт
        String category = revenueDTO.getRevenueCategoryDTO().getRevenueCategoryDTO();
        if (revenueCategoryRepository.existsByRevenueCategory(category)) {
            var revCategory = revenueCategoryRepository.findByRevenueCategory(category);
            revenue.setRevenueCategory(revCategory.get());
        } else {
            RevenueCategory newRevenueCategory = new RevenueCategory(category);
            revenueCategoryService.addNewCategory(newRevenueCategory, clientLogin);
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
