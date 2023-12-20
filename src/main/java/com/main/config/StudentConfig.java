package com.main.config;

import com.main.model.request.StudentModel;
import com.main.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args -> {
            StudentModel Cindy = new StudentModel(
                        "Cindy",
                        "Cindy@gmail",
                        LocalDate.of(2007, Month.JANUARY,5)
            );
            StudentModel Anna = new StudentModel(
                    "Anna",
                    "Anna@gmail",
                    LocalDate.of(2020, Month.JANUARY,5)
            );
            StudentModel Joan = new StudentModel(
                    "Joan",
                    "Joan@gmail",
                    LocalDate.of(2010, Month.JANUARY,5)
            );
            studentRepo.saveAll(
                    List.of(Cindy,Anna,Joan)
            );

        };
    }
}
