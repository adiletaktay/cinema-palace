package com.cinema_palace.service.implementation;

import com.cinema_palace.model.UserAccount;
import com.cinema_palace.repository.UserAccountRepo;
import com.cinema_palace.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepo userAccountRepository;

    public UserAccount userRegister(UserAccount newUser) {
        return userAccountRepository.save(newUser);
    }

    public boolean emailExists(String email) {
        Optional<UserAccount> userEmail = userAccountRepository.findByEmail(email);
        return userEmail.isPresent();
    }

    public boolean userAuthentication(String email, String password) {
        Optional<UserAccount> userAccount = userAccountRepository.findByEmail(email);
        String correctPassword = userAccount.get().getPassword();
        return correctPassword.equals(password);
    }
}