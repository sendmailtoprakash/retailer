package com.retailer.reward;

import com.retailer.reward.dao.RetailerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.retailer")
@SpringBootApplication
public class RetailerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailerApplication.class, args);
    }

}
