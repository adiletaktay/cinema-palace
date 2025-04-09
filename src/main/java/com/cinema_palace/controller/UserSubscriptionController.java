package com.cinema_palace.controller;

import com.cinema_palace.model.UserSubscription;
import com.cinema_palace.service.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserSubscriptionController {

    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @PostMapping("api/subscribe")
    public ResponseEntity<UserSubscription> planRegistration(@RequestBody UserSubscription newSubscriber) {
        return new ResponseEntity<UserSubscription>(userSubscriptionService.planRegistration(newSubscriber), HttpStatus.CREATED);
    }

    @GetMapping("api/subscribe/{email}")
    public boolean validateSubscription(@PathVariable String email) {
        return userSubscriptionService.validateSubscription(email);
    }
}
