package ru.netology.nomenclature.entity;

import java.util.Objects;

public abstract class Nomenclature {
    protected String shortName;
    protected String fullName;
    protected String code;
    protected String description;
    private final int id;
    protected VATRATE vatrate;
    private static int nextId = 0;

    public Nomenclature(String shortName, String fullName, String code, String description, VATRATE vatrate) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.code = code;
        this.description = description;
        this.vatrate = vatrate;
        this.id = getId();
    }

    private int getId() {
        return Nomenclature.nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nomenclature that = (Nomenclature) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                "Название ='" + shortName + '\'' +
                ", Полное название ='" + fullName + '\'' +
                ", Артикул ='" + code + '\'' +
                ", Описание ='" + description + '\'' +
                '}';
    }

    public String getShortName() {
        return shortName;
    }
}
