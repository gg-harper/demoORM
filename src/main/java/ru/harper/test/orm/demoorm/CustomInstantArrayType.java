package ru.harper.test.orm.demoorm;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;

public class CustomInstantArrayType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.ARRAY};
    }

    @Override
    public Class returnedClass() {
        return Timestamp[].class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return o == o1;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        Array array = resultSet.getArray(strings[0]);
        return array != null? array.getArray() : null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int index, SharedSessionContractImplementor sessionContractImplementor) throws HibernateException, SQLException {
        if (o != null && preparedStatement != null) {
            Array array = sessionContractImplementor.connection().createArrayOf("timestamp", (Timestamp[]) o);
            preparedStatement.setArray(index, array);
        } else {
            preparedStatement.setNull(index, sqlTypes()[0]);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return o;
    }
}
