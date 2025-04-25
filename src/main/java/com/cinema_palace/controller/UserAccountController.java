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

    @PostMapping("api/register")
    public ResponseEntity<UserAccount> userRegister(@RequestBody UserAccount newUser) {
        return new ResponseEntity<>(userAccountService.userRegister(newUser), HttpStatus.CREATED);
    }

    @GetMapping("api/verifyEmail/{email}")
    public boolean emailExists(@PathVariable String email) {
        return userAccountService.emailExists(email);
    }

    @GetMapping("api/authenticator/{email}/{password}")
    public ResponseEntity<Boolean> userAuthentication(@PathVariable("email") String email, @PathVariable("password") String password) {
        boolean validity = userAccountService.userAuthentication(email, password);
        return ResponseEntity.ok(validity);
    }
}