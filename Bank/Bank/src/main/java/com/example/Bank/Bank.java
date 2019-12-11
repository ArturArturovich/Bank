package com.example.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.*"})
public class Bank {

    public static void main(String[] args) {
        SpringApplication.run(Bank.class, args);
    }
}
