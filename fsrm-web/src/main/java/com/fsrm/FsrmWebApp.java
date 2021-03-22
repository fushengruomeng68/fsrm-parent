package com.fsrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class FsrmWebApp {

    public static void main(String[] args) {
        SpringApplication.run(FsrmWebApp.class, args);

    }

}
