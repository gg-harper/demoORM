package ru.harper.test.orm.demoorm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Component
public class App {

    @Autowired
    private TestModelRepository testModelRepository;

    public void run() throws InterruptedException {
        Timestamp[] instants = new java.sql.Timestamp[] {};
        TestModel testModel = new TestModel();
        testModel.setTime(instants);
        testModel.setInstant(Instant.EPOCH);
        testModel = testModelRepository.save(testModel);
        System.out.println(testModel);
//        Thread.sleep(3000);
        TestModel testModel2 = testModelRepository.findById(testModel.getId()).get();
        System.out.println(testModel2);
    }
}
