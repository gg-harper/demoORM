package ru.harper.test.orm.demoorm;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

@Setter
@Getter
@Entity
@TypeDef(
        typeClass = CustomInstantArrayType.class,
        defaultForType = Instant[].class
)
public class TestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Instant instant;

    @Column(columnDefinition = "timestamp[]")
    @Type(type = "ru.harper.test.orm.demoorm.CustomInstantArrayType")
    private Timestamp[] time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestModel testModel = (TestModel) o;
        return Objects.equals(id, testModel.id) && Arrays.equals(time, testModel.time);
    }

    public TestModel(Long id, Timestamp[] time) {
        this.id = id;
        this.time = time;
    }

    public TestModel(){}

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(time);
        return result;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", instant=" + instant +
                ", time=" + Arrays.toString(time) +
                '}';
    }
}

