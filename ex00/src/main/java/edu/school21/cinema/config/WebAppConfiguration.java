package edu.school21.cinema.config;

import edu.school21.cinema.repositories.dao.UserDao;
import edu.school21.cinema.services.UserService;
import edu.school21.cinema.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:../application.properties")
@RequiredArgsConstructor
public class WebAppConfiguration {

    private final DatabaseConfiguration databaseConfiguration;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseConfiguration.getUrl());
        dataSource.setUsername(databaseConfiguration.getUsername());
        dataSource.setPassword(databaseConfiguration.getPassword());
        dataSource.setDriverClassName(databaseConfiguration.getDriver());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDao userDao(JdbcTemplate jdbcTemplate) {
        return new UserDao(jdbcTemplate);
    }

    @Bean
    public UserService userService(PasswordEncoder passwordEncoder,
                                   UserDao userDao) {
        return new UserServiceImpl(userDao, passwordEncoder);
    }
}
