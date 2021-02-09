package ru.netology.nomenclature.repository;

import ru.netology.nomenclature.entity.Nomenclature;

import java.util.Iterator;

public interface NomenclatureRepository extends Iterable<Nomenclature> {

    boolean add(Nomenclature nomenclature);

    boolean remove(Nomenclature nomenclature);

    Nomenclature get(int index);

    @Override
    Iterator<Nomenclature> iterator();

}
