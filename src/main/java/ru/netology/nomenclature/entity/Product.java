package ru.netology.nomenclature.entity;

public class Product extends Nomenclature {

    protected int weight;

    public Product(String shortName, String fullName, String code, String description, Vatrate vatrate, int weight) {
        super(shortName, fullName, code, description, vatrate);
        this.weight = weight;
    }
}
