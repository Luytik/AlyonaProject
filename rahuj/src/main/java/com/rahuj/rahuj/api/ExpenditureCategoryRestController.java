package com.rahuj.rahuj.api;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<ExpenditureCategoryDTO> getAll(@RequestParam String login) {
        
        return expenditureCategoryService.getAllExpCategoriesAsDtoByClient(login);
    }

    @PostMapping
    public ResponseEntity<?> addNew(@ModelAttribute ExpenditureCategoryDTO categoryDTO, Principal principal){
        try{
            expenditureCategoryService.addNewCategory(ExpenditureCategoryDTO.from(categoryDTO), principal.getName());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
