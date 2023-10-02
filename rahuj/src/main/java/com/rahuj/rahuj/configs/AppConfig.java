package com.rahuj.rahuj.configs;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rahuj.rahuj.dto.ExpenditureDTO;
import com.rahuj.rahuj.dto.RevenueDTO;
import com.rahuj.rahuj.models.Client;
import com.rahuj.rahuj.models.Expenditure;
import com.rahuj.rahuj.models.ExpenditureCategory;
import com.rahuj.rahuj.models.Revenue;
import com.rahuj.rahuj.models.RevenueCategory;
import com.rahuj.rahuj.services.ClientService;
import com.rahuj.rahuj.services.ExpenditureCategoryService;
import com.rahuj.rahuj.services.ExpenditureService;
import com.rahuj.rahuj.services.RevenueCategoryService;
import com.rahuj.rahuj.services.RevenueService;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner runner(final ExpenditureCategoryService expenditureCategoryService,
                                    final RevenueCategoryService revenueCategoryService,
                                    final ExpenditureService expenditureService, 
                                    final RevenueService revenueService,
                                    final ClientService clientService){
        return new CommandLineRunner() {
            @Override
            public void run(String...strings) throws Exception {

                Client client = new Client("vadik", "lala@com.ua", "pass");
                clientService.signUpClient(client);

                //Add few expenditure categories
                ExpenditureCategory eCat1 = new ExpenditureCategory("Комунальні платежі");
                expenditureCategoryService.addNewCategory(eCat1);
                ExpenditureCategory eCat2 = new ExpenditureCategory("Покупка");
                expenditureCategoryService.addNewCategory(eCat2);
                ExpenditureCategory eCat3 = new ExpenditureCategory("Оплата за інтернет");
                expenditureCategoryService.addNewCategory(eCat3);
                //Adding few expenditures

                Expenditure expenditure1 = new Expenditure(new Date(), eCat1, client, 26.50, "Дуже багато тексту а може і не дуже багато тексту. В будь якому випадку цей текс існує");
                Expenditure expenditure2 = new Expenditure(new Date(), eCat2, client, 16645645645.50, "Дуже багато тексту а може і не дуже багато тексту. В будь якому випадку цей текс існує");
                Expenditure expenditure3 = new Expenditure(new Date(), eCat3, client, 88888888.50, "Дуже багато тексту а може і не дуже багато тексту. В будь якому випадку цей текс існує");
                ExpenditureDTO exDto1 = ExpenditureDTO.of(expenditure1);
                expenditureService.saveExpenditure(exDto1);
                ExpenditureDTO exDto2 = ExpenditureDTO.of(expenditure2);
                expenditureService.saveExpenditure(exDto2);
                ExpenditureDTO exDto3 = ExpenditureDTO.of(expenditure3);
                expenditureService.saveExpenditure(exDto3);

                //Add few revenue categories
                RevenueCategory rCat1 = new RevenueCategory("Заробітня плата");
                revenueCategoryService.addNewCategory(rCat1);
                RevenueCategory rCat2 = new RevenueCategory("Продаж");
                revenueCategoryService.addNewCategory(rCat2);
                RevenueCategory rCat3 = new RevenueCategory("Послуги");
                revenueCategoryService.addNewCategory(rCat3);

                Revenue revenue1 = new Revenue(new Date(), rCat1, client, 565656456.23, "Дуже багато тексту а може і не дуже багато тексту. В будь якому випадку цей текс існує");
                Revenue revenue2 = new Revenue(new Date(), rCat2, client, 65656456.23, "Дуже багато тексту а може і не дуже багато тексту. В будь якому випадку цей текс існує");
                Revenue revenue3 = new Revenue(new Date(), rCat3, client, 65656456.23, "Дуже багато тексту а може і не дуже багато тексту. В будь якому випадку цей текс існує");
                
                RevenueDTO revDto1 = RevenueDTO.of(revenue1);
                RevenueDTO revDto2 = RevenueDTO.of(revenue2);
                RevenueDTO revDto3 = RevenueDTO.of(revenue3);

                revenueService.saveRevenue(revDto1);
                revenueService.saveRevenue(revDto2);
                revenueService.saveRevenue(revDto3);


            }
        };
    }

}
