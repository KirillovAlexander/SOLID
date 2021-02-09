package ru.netology.store.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket implements Iterable<BasketElement> {
    protected List<BasketElement> basketElements;

    public Basket() {
        basketElements = new ArrayList<>();
    }

    public void add(BasketElement newBasketElement) {
        for (BasketElement basketElement : basketElements) {
            if (basketElement.getNomenclature().equals(newBasketElement.getNomenclature())) {
                basketElement.addAmount(newBasketElement.getAmount());
                return;
            }
        }
        basketElements.add(newBasketElement);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (BasketElement basketElement:
             basketElements) {
            s.append(basketElement).append("\n");
        }
        return s.toString();
    }

    public void clearBasket() {
        basketElements.clear();
    }

    public boolean isEmpty() {
        return basketElements.isEmpty();
    }

    @Override
    public Iterator<BasketElement> iterator() {
        return new Iterator<BasketElement>() {
            int currentPos = 0;
            @Override
            public boolean hasNext() {
                return currentPos < basketElements.size();
            }

            @Override
            public BasketElement next() { return basketElements.get(currentPos++); }

            @Override
            public void remove() { throw new RuntimeException("Not implemented"); }
        };
    }
}
