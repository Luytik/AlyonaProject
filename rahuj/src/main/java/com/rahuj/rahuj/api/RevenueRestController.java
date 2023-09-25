package com.rahuj.rahuj.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahuj.rahuj.dto.ExpenditureDTO;
import com.rahuj.rahuj.dto.RevenueDTO;
import com.rahuj.rahuj.services.ConstsFormatDate;
import com.rahuj.rahuj.services.RevenueService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/revenue/")
public class RevenueRestController {

    private final RevenueService revenueService;

    @PostMapping
    public ResponseEntity<?> addRevenue(@ModelAttribute RevenueDTO revenueDTO) {
        if (isApplicableToSave(revenueDTO)) {
            try {
                revenueService.saveRevenue(revenueDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            } else 
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public List<RevenueDTO> getAllRevCategoriesAsDto() {
        return revenueService.getAllRevCategoriesAsDTO();
    }

    private boolean isApplicableToSave(RevenueDTO revenueDTO) {
        if (!ConstsFormatDate.isDateCorrect(revenueDTO.getDate()))
            return false;
        if (revenueDTO.getRevenueCategoryDTO() == null)
            return false;
        if (!(revenueDTO.getMoney() instanceof Double))
            return false;
        if (revenueDTO.getMoney() == null)
            return false;
        return true;
    }
}
