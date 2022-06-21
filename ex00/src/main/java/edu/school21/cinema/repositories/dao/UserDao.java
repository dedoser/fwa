package edu.school21.cinema.repositories.dao;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public User save(User user) {
        String insertQuery = "INSERT INTO public.user " +
                "(first_name, last_name, phone_number, password, email) " +
                "VALUES (%s, %s, %s, %s, %s)";
        String paramsQuery = String.format(insertQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getEmail());
        return jdbcTemplate.queryForObject(paramsQuery, new UserMapper());
    }

    public User find(User user) {
        String selectQuery = "SELECT * FROM public.user WHERE ";
    }
}
