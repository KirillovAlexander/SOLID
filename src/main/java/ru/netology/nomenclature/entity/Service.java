package ru.netology.nomenclature.entity;

public class Service extends Nomenclature{

    protected String responsible;

    public Service(String shortName, String fullName, String code, String description, Vatrate vatrate, String responsible) {
        super(shortName, fullName, code, description, vatrate);
        this.responsible = responsible;
    }
}
