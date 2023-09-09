package com.rahuj.rahuj.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rahuj.rahuj.models.ExpenditureCategory;
import com.rahuj.rahuj.services.ExpenditureCategoryService;
import com.rahuj.rahuj.services.RevenueCategoryService;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner runner(final ExpenditureCategoryService expenditureCategoryService,
                                    final RevenueCategoryService revenueCategoryService){
        return new CommandLineRunner() {
            @Override
            public void run(String...strings) throws Exception {
                //Add few expenditure categories
                expenditureCategoryService.addCategory("Комунальні платежі");
                expenditureCategoryService.addCategory("Покупка");
                expenditureCategoryService.addCategory("Оплата за інтернет");

                revenueCategoryService.addCategory("Заробітня плата");
                revenueCategoryService.addCategory("Продаж");
                revenueCategoryService.addCategory("Послуги");

            }
        };
    }

}
