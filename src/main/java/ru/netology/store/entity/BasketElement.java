package ru.netology.store.entity;

import ru.netology.nomenclature.entity.Nomenclature;

public class BasketElement {
    protected Nomenclature nomenclature;
    protected int price;
    protected int amount;
    protected int discount;

    public BasketElement(Nomenclature nomenclature, int price, int amount, int discount) {
        this.nomenclature = nomenclature;
        this.price = price;
        this.amount = amount;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return nomenclature.getShortName() + ", Количество: " + amount + ", Цена: " + price + ", Сумма: " + amount * price;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int newAmount) {
        amount = amount + newAmount;
    }
}
