package ru.netology.store.repository.rests;

import ru.netology.nomenclature.entity.Nomenclature;

public interface RestInfoRepository {

    int getRestByNomenclature(Nomenclature nomenclature);

    void add(Nomenclature nomenclature, int amount);

    boolean remove(Nomenclature nomenclature, int amount);

}
