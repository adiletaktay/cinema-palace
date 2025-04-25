package com.cinema_palace.service;

import com.cinema_palace.model.Card;
import com.cinema_palace.model.PaymentWrapper;

public interface PaymentService {
    boolean cardValidation(Card cardDetails);
    boolean proceedPayment(PaymentWrapper newPayment);
}