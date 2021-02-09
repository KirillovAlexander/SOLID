package ru.netology.store.entity;

import ru.netology.nomenclature.entity.Nomenclature;
import ru.netology.nomenclature.entity.Service;
import ru.netology.nomenclature.repository.NomenclatureRepository;
import ru.netology.store.repository.prices.PricesInfoRepository;
import ru.netology.store.repository.rests.RestInfoRepository;

public class Store {
    protected NomenclatureRepository nomenclatureRepository;
    protected PricesInfoRepository pricesInfoRepository;
    protected RestInfoRepository restInfoRepository;

    public Store(NomenclatureRepository nomenclatureRepository, PricesInfoRepository pricesInfoRepository, RestInfoRepository restInfoRepository) {
        this.nomenclatureRepository = nomenclatureRepository;
        this.pricesInfoRepository = pricesInfoRepository;
        this.restInfoRepository = restInfoRepository;
    }

    public void printNomenclatures() {
        int i = 1;
        for (Object obj:
             nomenclatureRepository) {
            Nomenclature nom = (Nomenclature) obj;

            System.out.println("" + (i++) +". " + nom +
                    "; Цена: " + pricesInfoRepository.getPrice(nom)
                    + getRest(nom));
        }
    }

    private String getRest(Nomenclature nom) {
        if (nom.getClass().equals(Service.class)) return "";
        else return "; Остаток : " + restInfoRepository.getRestByNomenclature(nom);
    }

    public Nomenclature getNomenclature(int index) {
        return nomenclatureRepository.get(index);
    }

    public int getPrice(Nomenclature nomenclature) {
        return pricesInfoRepository.getPrice(nomenclature);
    }
}
