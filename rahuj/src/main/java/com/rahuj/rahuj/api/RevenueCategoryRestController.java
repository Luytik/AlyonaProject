package com.rahuj.rahuj.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<RevenueCategoryDTO> getAll(){
        return revenueCategoryService.getAllRevCategoriesAsDTO();
    }

    @PostMapping
    public void addNew(@ModelAttribute RevenueCategoryDTO categoryDTO){
        revenueCategoryService.addCategory(categoryDTO.getRevenueCategoryDTO());
    }
}
