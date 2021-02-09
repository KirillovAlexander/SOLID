package ru.netology.payment.service;

import ru.netology.store.entity.Order;

public interface PaymentSystem {

    boolean pay(Order order);

    boolean refund(Order order);

}
