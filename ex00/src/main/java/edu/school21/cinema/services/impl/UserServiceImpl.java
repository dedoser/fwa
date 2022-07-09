package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.dao.UserDao;
import edu.school21.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder bCryptEncoder;

    @Override
    public boolean isUserAlreadyCreated(User user) {
        return userDao.find(user) != null;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
}