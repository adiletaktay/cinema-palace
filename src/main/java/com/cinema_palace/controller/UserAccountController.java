package com.cinema_palace.controller;

import com.cinema_palace.model.UserAccount;
import com.cinema_palace.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/api/register")
    public ResponseEntity<UserAccount> userRegister(@RequestBody UserAccount newUser) {
        return new ResponseEntity<UserAccount>(userAccountService.userRegister(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/api/login/{email}")
    public UserAccount userLogin(@PathVariable String email) {
        return userAccountService.userLogin(email);
    }
}
