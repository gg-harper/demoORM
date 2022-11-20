package ru.harper.test.orm.demoorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "ru.harper.test.orm.demoorm")
public class DemoOrmApplication {

    public static void main(String[] args) throws InterruptedException {
       ConfigurableApplicationContext context = SpringApplication.run(DemoOrmApplication.class, args);
        System.out.println("Start...");
        App app = context.getBean(App.class);
        app.run();
    }
}
