package ru.dmitrii.jdbctemplate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.dmitrii.jdbctemplate.models.User;
import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM user_tes", new BeanPropertyRowMapper<>(User.class));
    }

    public User show(int Id) {
        return (User) jdbcTemplate.queryForObject("SELECT * FROM user_tes WHERE id=?",new Object[]{Id},new UserMapper());
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO user_tes (first_name, adress) VALUES(?, ?)", user.getFirst_name(),
                user.getAdress());
    }

    public void update(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE user_tes SET first_name=?, adress=? WHERE id=?", updatedUser.getFirst_name(),
                 updatedUser.getAdress(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM user_tes WHERE id=?", id);
    }
}
