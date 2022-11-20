package ru.harper.test.orm.demoorm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TestModelRepository extends JpaRepository<TestModel, Long> {

}
