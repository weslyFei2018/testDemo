package com.ihandy.adcaffe.testDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);

    }
}
