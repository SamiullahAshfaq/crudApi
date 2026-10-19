package com.example.crudApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Task("Setup an SQLite databse", true));
                repository.save(new Task("Connect CRUD endpoints", false));
                repository.save(new Task("Verify data persistance", true));
            }
        };
    }
}
