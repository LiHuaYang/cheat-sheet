package com.ariclee.mybatis.org;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = {
    SceneEnum.class
})
public class EnumValueTypeHandler<E extends LabelAndValue> extends BaseTypeHandler<E> {

    private Class<E> type;

    private final E[] enums;

    public EnumValueTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        //获取非空的枚举的int值并设置到statement中
//        ps.setInt(i, Integer.valueOf(parameter.getValue()));
        ps.setString(i, parameter.getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        }
        else {
            try {
                return getEnumByValue(value);
            } catch (Exception ex) {
                throw new IllegalArgumentException(
                        "Cannot convert " + value + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

    protected E getEnumByValue(String value) {
        for (E e : enums) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String i = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            try {
                return getEnumByValue(i);
            } catch (Exception ex) {
                throw new IllegalArgumentException(
                        "Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String i = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            try {
                return getEnumByValue(i);
            } catch (Exception ex) {
                throw new IllegalArgumentException(
                        "Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
            }
        }
    }
}
