package com.exampro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ExamproApplication {
    public static void main(String[] args) throws ParseException {
        SpringApplication.run(ExamproApplication.class, args);
    }
}
