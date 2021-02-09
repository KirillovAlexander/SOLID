package ru.netology.nomenclature.repository;

import ru.netology.nomenclature.entity.Nomenclature;

import java.util.Iterator;
import java.util.List;

public class InProgramNomenclatureRepository implements NomenclatureRepository{
    protected List<Nomenclature> nomenclatures;

    @Override
    public boolean add(Nomenclature nomenclature) {
        return nomenclatures.add(nomenclature);
    }

    @Override
    public boolean remove(Nomenclature nomenclature) {
        return nomenclatures.remove(nomenclature);
    }

    public InProgramNomenclatureRepository(List<Nomenclature> nomenclatures) {
        this.nomenclatures = nomenclatures;
    }

    @Override
    public Nomenclature get(int index) {
        return nomenclatures.get(index);
    }

    @Override
    public Iterator<Nomenclature> iterator() {
        return new Iterator<Nomenclature>() {
            int currentPos = 0;
            @Override
            public boolean hasNext() {
                return (currentPos < nomenclatures.size());
            }

            @Override
            public Nomenclature next() {
                return nomenclatures.get(currentPos++);
            }

            @Override
            public void remove() { throw new RuntimeException("Not implemented"); }
        };
    }
}
