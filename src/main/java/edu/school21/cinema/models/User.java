package edu.school21.cinema.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String email;
}
