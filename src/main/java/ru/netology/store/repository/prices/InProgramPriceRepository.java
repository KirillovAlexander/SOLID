package ru.netology.store.repository.prices;

import ru.netology.nomenclature.entity.Nomenclature;

import java.util.HashMap;

public class InProgramPriceRepository implements PricesInfoRepository {

    private final int PRICE_NOT_ASSIGNED = -1; //Избегаем использования магических чисел

    protected HashMap<Nomenclature, Integer> prices;

    @Override
    public int getPrice(Nomenclature nomenclature) {
        Integer currentPrice = prices.get(nomenclature);
        if (!currentPrice.equals(null)) return currentPrice;
        return PRICE_NOT_ASSIGNED;
    }

    @Override
    public boolean setPrice(Nomenclature nomenclature, int price) {
        if (price > 0) {
            prices.put(nomenclature, price);
            return true;
        } else {
            return false;
        }
    }

    public InProgramPriceRepository(HashMap<Nomenclature, Integer> prices) {
        this.prices = prices;
    }
}
