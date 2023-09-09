package com.rahuj.rahuj.dto;

import com.rahuj.rahuj.models.ExpenditureCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExpenditureCategoryDTO {
    private String expenditureCategoryDTO;

    public static ExpenditureCategoryDTO of(ExpenditureCategory category){
        ExpenditureCategoryDTO categoryDTO = new ExpenditureCategoryDTO();
        categoryDTO.setExpenditureCategoryDTO(category.getExpenditureCategory());
        return categoryDTO;
    }
}
