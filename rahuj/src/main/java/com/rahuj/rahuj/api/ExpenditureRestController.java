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
import com.rahuj.rahuj.services.ExpenditureService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/expenditure/")
@AllArgsConstructor
public class ExpenditureRestController {
    
    private final ExpenditureService expenditureService;

    @PostMapping
    public ResponseEntity<?> addExpenditure(@ModelAttribute ExpenditureDTO expenditureDTO){
        try{
            expenditureService.saveExpenditure(expenditureDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<ExpenditureDTO> getAllExpCategoriesAsDto(){
        return expenditureService.getAllExpCategoriesAsDto();
    }
}
