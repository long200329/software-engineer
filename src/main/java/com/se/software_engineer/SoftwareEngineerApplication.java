package com.se.software_engineer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.se.software_engineer.mapper")
public class SoftwareEngineerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareEngineerApplication.class, args);
    }

}
