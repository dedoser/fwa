package edu.school21.cinema.repositories.dao;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String insertQuery = "INSERT INTO user " +
                "(first_name, last_name, phone_number, password, email) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getEmail());
    }

    public User find(User user) {
        String selectQuery = "SELECT * FROM public.user WHERE " +
                "first_name = ? AND " +
                "last_name = ? AND " +
                "email = ? AND " +
                "phone_number = ?";
        return jdbcTemplate.queryForObject(selectQuery, new UserMapper());
    }
}
