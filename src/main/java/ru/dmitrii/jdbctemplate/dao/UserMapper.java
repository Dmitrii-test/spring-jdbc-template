package ru.dmitrii.jdbctemplate.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.dmitrii.jdbctemplate.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirst_name(rs.getString("first_name"));
        user.setAdress(rs.getString("adress"));
        return user;

    }
}
