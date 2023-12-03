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
import com.rahuj.rahuj.dto.RevenueCategoryDTO;

import com.rahuj.rahuj.services.RevenueCategoryService;

@RestController
@RequestMapping("/api/categories/revenueCategory")
public class RevenueCategoryRestController {
    private final RevenueCategoryService revenueCategoryService;

    public RevenueCategoryRestController(RevenueCategoryService revenueCategoryService){
        this.revenueCategoryService = revenueCategoryService;
    }

    @GetMapping
    public List<RevenueCategoryDTO> getAll(@RequestParam String login){
        return revenueCategoryService.getAllRevCategoriesAsDTOByClient(login);
    }

    @PostMapping
    public ResponseEntity<?> addNew(@ModelAttribute RevenueCategoryDTO categoryDTO, Principal principal){
        try {
            revenueCategoryService.addNewCategory(RevenueCategoryDTO.from(categoryDTO), principal.getName());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
