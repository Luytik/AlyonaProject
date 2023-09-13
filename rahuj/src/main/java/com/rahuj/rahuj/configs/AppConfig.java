package com.rahuj.rahuj.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                expenditureCategoryService.addNewCategory("Комунальні платежі");
                expenditureCategoryService.addNewCategory("Покупка");
                expenditureCategoryService.addNewCategory("Оплата за інтернет");

                revenueCategoryService.addNewCategory("Заробітня плата");
                revenueCategoryService.addNewCategory("Продаж");
                revenueCategoryService.addNewCategory("Послуги");

            }
        };
    }

}
