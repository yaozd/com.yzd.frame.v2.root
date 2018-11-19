package com.yzd.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class ApplicationWeb {
    /**
     * Used when run as JAR
     */
    public static void main(String[] args) {

        SpringApplication.run(ApplicationWeb.class, args);
    }

}
