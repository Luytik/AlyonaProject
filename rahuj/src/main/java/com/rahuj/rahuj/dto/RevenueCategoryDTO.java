package com.rahuj.rahuj.dto;

import com.rahuj.rahuj.models.RevenueCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RevenueCategoryDTO {
    private String revenueCategoryDTO;

    public static RevenueCategoryDTO of(RevenueCategory category){
        RevenueCategoryDTO categoryDTO = new RevenueCategoryDTO();
        categoryDTO.setRevenueCategoryDTO(category.getRevenueCategory());
        return categoryDTO;
    }
}
