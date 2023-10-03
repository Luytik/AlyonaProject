package com.rahuj.rahuj.configs;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import com.rahuj.rahuj.models.Role;
import com.rahuj.rahuj.repositories.RoleRepository;
import com.rahuj.rahuj.services.ClientDetail;
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
                        final ClientDetail clientService,
                        final RoleRepository roleRepository,
                        final PasswordEncoder encoder) {
                return new CommandLineRunner() {
                        @Override
                        public void run(String... strings) throws Exception {
                                Role role = new Role("ROLE_USER");
                                Set<Role> roles = new HashSet<>();
                                roleRepository.save(role);
                                roles.add(role);
                                Client client1 = new Client("vadik", "v@com.ua", encoder.encode("pass"));
                                client1.setRoles(roles);
                                clientService.signUpClient(client1);

                                Client client2 = new Client("alyona", "a@com.ua", encoder.encode("pass"));
                                client2.setRoles(roles);
                                clientService.signUpClient(client2);

                                // Add few expenditure categories
                                ExpenditureCategory eCat1 = new ExpenditureCategory("Комунальні платежі");
                                expenditureCategoryService.addNewCategory(eCat1);
                                ExpenditureCategory eCat2 = new ExpenditureCategory("Покупка");
                                expenditureCategoryService.addNewCategory(eCat2);
                                ExpenditureCategory eCat3 = new ExpenditureCategory("Оплата за інтернет");
                                expenditureCategoryService.addNewCategory(eCat3);

                                // Adding few expenditures client 1
                                Expenditure expenditure1 = new Expenditure(new Date(), eCat1, client1, 26.50,
                                                "Клієнт1");
                                Expenditure expenditure2 = new Expenditure(new Date(), eCat2, client1, 16645645645.50,
                                                "Клієнт1");
                                Expenditure expenditure3 = new Expenditure(new Date(), eCat3, client1, 88888888.50,
                                                "Клієнт1");
                                ExpenditureDTO exDto1 = ExpenditureDTO.of(expenditure1);
                                expenditureService.saveExpenditure(exDto1);
                                ExpenditureDTO exDto2 = ExpenditureDTO.of(expenditure2);
                                expenditureService.saveExpenditure(exDto2);
                                ExpenditureDTO exDto3 = ExpenditureDTO.of(expenditure3);
                                expenditureService.saveExpenditure(exDto3);

                                // Adding few expenditures client 2
                                Expenditure expenditure4 = new Expenditure(new Date(), eCat1, client2, 26.50,
                                                "Клієнт2");
                                Expenditure expenditure5 = new Expenditure(new Date(), eCat2, client2, 16645645645.50,
                                                "Клієнт2");
                                Expenditure expenditure6 = new Expenditure(new Date(), eCat3, client2, 88888888.50,
                                                "Клієнт3");
                                ExpenditureDTO exDto4 = ExpenditureDTO.of(expenditure4);
                                expenditureService.saveExpenditure(exDto4);
                                ExpenditureDTO exDto5 = ExpenditureDTO.of(expenditure5);
                                expenditureService.saveExpenditure(exDto5);
                                ExpenditureDTO exDto6 = ExpenditureDTO.of(expenditure6);
                                expenditureService.saveExpenditure(exDto6);

                                // Add few revenue categories
                                RevenueCategory rCat1 = new RevenueCategory("Заробітня плата");
                                revenueCategoryService.addNewCategory(rCat1);
                                RevenueCategory rCat2 = new RevenueCategory("Продаж");
                                revenueCategoryService.addNewCategory(rCat2);
                                RevenueCategory rCat3 = new RevenueCategory("Послуги");
                                revenueCategoryService.addNewCategory(rCat3);

                                Revenue revenue1 = new Revenue(new Date(), rCat1, client1, 565656456.23,
                                                "Клієнт1");
                                Revenue revenue2 = new Revenue(new Date(), rCat2, client1, 65656456.23,
                                                "Клієнт1");
                                Revenue revenue3 = new Revenue(new Date(), rCat3, client1, 65656456.23,
                                                "Клієнт1");
                                Revenue revenue4 = new Revenue(new Date(), rCat1, client1, 565656456.23,
                                                "Клієнт2");
                                Revenue revenue5 = new Revenue(new Date(), rCat2, client1, 65656456.23,
                                                "Клієнт2");
                                Revenue revenue6 = new Revenue(new Date(), rCat3, client1, 65656456.23,
                                                "Клієнт2");

                                RevenueDTO revDto1 = RevenueDTO.of(revenue1);
                                RevenueDTO revDto2 = RevenueDTO.of(revenue2);
                                RevenueDTO revDto3 = RevenueDTO.of(revenue3);
                                RevenueDTO revDto4 = RevenueDTO.of(revenue4);
                                RevenueDTO revDto5 = RevenueDTO.of(revenue5);
                                RevenueDTO revDto6 = RevenueDTO.of(revenue6);

                                revenueService.saveRevenue(revDto1);
                                revenueService.saveRevenue(revDto2);
                                revenueService.saveRevenue(revDto3);
                                revenueService.saveRevenue(revDto4);
                                revenueService.saveRevenue(revDto5);
                                revenueService.saveRevenue(revDto6);

                        }
                };
        }

}
