package com.example.tp_spring_security;

import com.example.tp_spring_security.entities.AppRole;
import com.example.tp_spring_security.entities.AppUser;
import com.example.tp_spring_security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class TpSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpSpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.addNewRole(new AppRole(null, "USER"));
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRole(null, "BILLS_MANAGER"));

            // Utilisez HashSet à la place de ArrayList pour les rôles
            accountService.addNewUser(new AppUser(null, "user1", "1234", new HashSet<>()));
            accountService.addNewUser(new AppUser(null, "user2", "1234", new HashSet<>()));
            accountService.addNewUser(new AppUser(null, "admin", "1234", new HashSet<>()));

            accountService.addRoleToUser("user1", "USER");
            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("admin", "USER");
        };
    }
}
