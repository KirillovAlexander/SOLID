package ru.netology.store.repository.rests;

import ru.netology.nomenclature.entity.Nomenclature;

import java.util.HashMap;

public class InProgramRestRepository implements RestInfoRepository{

    protected HashMap<Nomenclature, Integer> rests;

    @Override
    public int getRestByNomenclature(Nomenclature nomenclature) {
        Integer currentRest = rests.get(nomenclature);
        return null == currentRest ? 0 : currentRest;
    }

    @Override
    public void add(Nomenclature nomenclature, int amount) {
        Integer currentRest = rests.get(nomenclature);
        rests.put(nomenclature,
                currentRest.equals(null) ? amount : currentRest + amount);
    }

    @Override
    public boolean remove(Nomenclature nomenclature, int amount) {
        if (rests.containsKey(nomenclature)) {
            rests.put(nomenclature, rests.get(nomenclature) - amount);
            return true;
        } else {
            return false;
        }
    }

    public InProgramRestRepository(HashMap<Nomenclature, Integer> rests) {
        this.rests = rests;
    }
}
