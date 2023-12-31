package com.rahuj.rahuj.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahuj.rahuj.dto.ExpenditureCategoryDTO;
import com.rahuj.rahuj.services.ExpenditureCategoryService;

@RestController
@RequestMapping("/api/categories/expenditureCategory")
public class ExpenditureCategoryRestController {

    private final ExpenditureCategoryService expenditureCategoryService;

    public ExpenditureCategoryRestController(ExpenditureCategoryService expenditureCategoryService) {
        this.expenditureCategoryService = expenditureCategoryService;
    }

    @GetMapping
    public List<ExpenditureCategoryDTO> getAll() {
        return expenditureCategoryService.getAllExpCategoriesAsDto();
    }

    @PostMapping
    public ResponseEntity<?> addNew(@ModelAttribute ExpenditureCategoryDTO categoryDTO){
        try{
            expenditureCategoryService.addNewCategory(categoryDTO.getExpenditureCategoryDTO());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
