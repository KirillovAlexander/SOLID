package ru.netology.store.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    protected String manager;
    protected Date date;
    protected List<BasketElement> orderElements = new ArrayList<>();

    public Order(Basket basket, Store store) {
        for (BasketElement basketElement:
             basket) {
            orderElements.add(basketElement);
            store.restInfoRepository.remove(basketElement.getNomenclature(), basketElement.getAmount());
        }
        basket.clearBasket();
        this.manager = "Admin";
        this.date = new Date();
    }
}
