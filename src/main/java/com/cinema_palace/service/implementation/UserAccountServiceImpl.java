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

    public UserAccount userLogin(String email) {
        Optional<UserAccount> userAccount = userAccountRepository.findByEmail(email);
        return userAccount.orElse(null);
    }
}
