package ru.netology.store.repository.prices;

import ru.netology.nomenclature.entity.Nomenclature;

public interface PricesInfoRepository {

    int getPrice(Nomenclature nomenclature);

    boolean setPrice(Nomenclature nomenclature, int price);

}
