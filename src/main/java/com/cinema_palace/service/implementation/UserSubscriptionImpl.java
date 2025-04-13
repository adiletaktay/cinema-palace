package com.cinema_palace.service.implementation;

import com.cinema_palace.model.UserSubscription;
import com.cinema_palace.repository.UserSubscriptionRepo;
import com.cinema_palace.service.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserSubscriptionImpl implements UserSubscriptionService {

    @Autowired
    private UserSubscriptionRepo userSubscriptionRepository;

    public UserSubscription planRegistration(UserSubscription newSubscriber) {
        LocalDateTime subscribeDate = LocalDateTime.now();
        LocalDateTime expireDate = subscribeDate.plusDays(30);

        Optional<UserSubscription> existingSubscriber = userSubscriptionRepository.findByEmail(newSubscriber.getEmail());
        if (existingSubscriber.isPresent()) {
            UserSubscription existing = existingSubscriber.get();
            existing.setStartDate(subscribeDate);
            existing.setExpDate(expireDate);
            existing.setPlan(newSubscriber.getPlan());
            return userSubscriptionRepository.save(existing);
        } else {
            newSubscriber.setStartDate(subscribeDate);
            newSubscriber.setExpDate(expireDate);
            return userSubscriptionRepository.save(newSubscriber);
        }
    }

    public boolean validateSubscription(String email) {
        LocalDateTime currentDate = LocalDateTime.now();
        Optional<UserSubscription> userSubscription = userSubscriptionRepository.findByEmail(email);
        return userSubscription.map(subscription -> subscription.getExpDate().isAfter(currentDate)).orElse(false);
    }
}
