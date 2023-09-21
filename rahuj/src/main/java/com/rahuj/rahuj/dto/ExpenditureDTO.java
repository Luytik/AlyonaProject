package com.rahuj.rahuj.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.Expenditure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ExpenditureDTO {
    private String date;
    private ExpenditureCategoryDTO expenditureCategoryDTO;
    //private Client client;
    private Double money;
    private String description;

    public static ExpenditureDTO of(Expenditure expenditure) {
        ExpenditureDTO expenditureDTO = new ExpenditureDTO();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = expenditure.getDate();
        expenditureDTO.setDate(dateFormat.format(date));
        expenditureDTO.setDescription(expenditure.getDescription());
        expenditureDTO.setMoney(expenditure.getMoney());
        ExpenditureCategoryDTO expenditureCategoryDTO = 
                ExpenditureCategoryDTO.of(expenditure.getExpenditureCategory());
        expenditureDTO.setExpenditureCategoryDTO(expenditureCategoryDTO);
        return expenditureDTO;
    }

    public static Expenditure from(ExpenditureDTO expenditureDTO){
        Expenditure expenditure = new Expenditure();
        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(expenditureDTO.getDate());
            expenditure.setDate(date);
        } catch (Exception e) {

        }
        expenditure.setDescription(expenditureDTO.getDescription());
        expenditure.setMoney(expenditureDTO.getMoney());
        return expenditure;
    }
}
