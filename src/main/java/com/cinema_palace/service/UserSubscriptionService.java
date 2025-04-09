package com.cinema_palace.service;

import com.cinema_palace.model.UserSubscription;

public interface UserSubscriptionService {
    UserSubscription planRegistration(UserSubscription newSubscriber);
    boolean validateSubscription(String email);
}