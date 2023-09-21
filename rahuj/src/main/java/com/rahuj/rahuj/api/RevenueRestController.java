package com.rahuj.rahuj.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahuj.rahuj.dto.RevenueDTO;
import com.rahuj.rahuj.services.RevenueService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/revenue/")
public class RevenueRestController {
    
    private final RevenueService revenueService;

    @PostMapping
    public ResponseEntity<?> addRevenue(@ModelAttribute RevenueDTO revenueDTO){
        try{
            revenueService.saveRevenue(revenueDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<RevenueDTO> getAllRevCategoriesAsDto(){
        return revenueService.getAllRevCategoriesAsDTO();
    }
}
