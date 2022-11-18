package ru.harper.test.orm.demoorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.Instant;
import java.time.LocalDate;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOrmApplication.class, args);
        System.out.println(Instant.now().getEpochSecond());
    }

}
