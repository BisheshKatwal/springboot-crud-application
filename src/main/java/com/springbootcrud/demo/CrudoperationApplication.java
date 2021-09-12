package com.springbootcrud.demo;

import com.springbootcrud.demo.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
//@ComponentScan({"com.springbootcrud.demo.Service"})
//@EntityScan("com.springbootcrud.demo.entity")
@EnableJpaRepositories(basePackageClasses = StudentRepository.class)
@Configuration
public class CrudoperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudoperationApplication.class, args);
    }

}
