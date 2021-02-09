package ru.netology.payment.service;

import ru.netology.store.entity.Order;

public class InProgramPayment implements PaymentSystem {
    @Override
    public boolean pay(Order order) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Спасибо что оплатили Ваш заказ! Мы уже сняли все деньги с Вашей карточки :)");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return true;
    }

    @Override
    public boolean refund(Order order) { throw new RuntimeException("Not implemented"); }
}
