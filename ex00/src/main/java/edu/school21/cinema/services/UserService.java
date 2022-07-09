package edu.school21.cinema.services;

import edu.school21.cinema.models.User;

public interface UserService {
    boolean isUserAlreadyCreated(User user);

    void save(User user);
}
