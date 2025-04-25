package com.cinema_palace.service;

import com.cinema_palace.model.UserAccount;

public interface UserAccountService {
    UserAccount userRegister(UserAccount newUser);
    boolean emailExists(String email);
    boolean userAuthentication(String email, String password);
}