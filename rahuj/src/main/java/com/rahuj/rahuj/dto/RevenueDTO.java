package com.rahuj.rahuj.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.rahuj.rahuj.models.Revenue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RevenueDTO {
    private String date;
    private RevenueCategoryDTO revenueCategoryDTO;
    // private Client client;
    private Double money;
    private String description;

    public static RevenueDTO of(Revenue revenue) {
        RevenueDTO revenueDTO = new RevenueDTO();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = revenue.getDate();
        revenueDTO.setDate(dateFormat.format(date));
        revenueDTO.setDescription(revenue.getDescription());
        revenueDTO.setMoney(revenue.getMoney());
        RevenueCategoryDTO revenueCategoryDTO = RevenueCategoryDTO.of(revenue.getRevenueCategory());
        revenueDTO.setRevenueCategoryDTO(revenueCategoryDTO);
        return revenueDTO;
    }

    public static Revenue from(RevenueDTO revenueDTO) {
        Revenue revenue = new Revenue();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(revenueDTO.getDate());
            revenue.setDate(date);
        } catch (Exception e) {

        }
        revenue.setDescription(revenueDTO.getDescription());
        revenue.setMoney(revenueDTO.getMoney());
        return revenue;
    }
}
