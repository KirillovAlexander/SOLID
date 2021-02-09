package ru.netology;

import ru.netology.nomenclature.entity.Nomenclature;
import ru.netology.nomenclature.entity.Product;
import ru.netology.nomenclature.entity.Service;
import ru.netology.nomenclature.entity.VATRATE;
import ru.netology.nomenclature.repository.InProgramNomenclatureRepository;
import ru.netology.payment.service.InProgramPayment;
import ru.netology.payment.service.PaymentSystem;
import ru.netology.store.entity.Basket;
import ru.netology.store.entity.BasketElement;
import ru.netology.store.entity.Order;
import ru.netology.store.entity.Store;
import ru.netology.store.repository.prices.InProgramPriceRepository;
import ru.netology.store.repository.rests.InProgramRestRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = initStore();
        Basket basket = new Basket();
        store.printNomenclatures();
        while (true) {
            printMenu();
            String input = getInput("Ваш выбор: ");
            if (input.equals("0")) break;
            else process(input, store, basket);
        }
    }

    private static Store initStore() {
        Nomenclature product1 = createProduct("Молоко 3л.",
                "Молоко пастеризованное, 3 литра",
                "МЛК3Л",
                "Предназначено для употребления внутрь.",
                VATRATE.VAT_20,
                3);
        Nomenclature product2 = createProduct("Молоко 1л.",
                "Молоко пастеризованное, 1 литр",
                "МЛК1Л",
                "Предназначено для употребления внутрь.",
                VATRATE.VAT_20,
                1);
        Nomenclature product3 = createProduct("Соленые огурцы 1кг.",
                "Соленые огурцы, 1 килограмм",
                "ОГРЧК",
                "Предназначено для употребления внутрь. Не смешивать с молоком!",
                VATRATE.VAT_20,
                1);
        Nomenclature service1 = createService("Доставка",
                "Доставка продуктов",
                "ДСТВК",
                "Услуги по доставке заказанных продуктов.",
                VATRATE.VAT_20,
                "Курьер");

        List<Nomenclature> nomenclatures = new ArrayList<>();
        nomenclatures.add(product1);
        nomenclatures.add(product2);
        nomenclatures.add(product3);
        nomenclatures.add(service1);

        HashMap<Nomenclature, Integer> prices = new HashMap<>();
        prices.put(product1, 100);
        prices.put(product2, 40);
        prices.put(product3, 600);
        prices.put(service1, 1500);

        HashMap<Nomenclature, Integer> rests = new HashMap<>();
        rests.put(product1, 15);
        rests.put(product2, 30);
        rests.put(product3, 5);

        return new Store(new InProgramNomenclatureRepository(nomenclatures),
                new InProgramPriceRepository(prices),
                new InProgramRestRepository(rests));

    }

    private static Nomenclature createProduct(String shortName, String fullName, String code, String description, VATRATE vatrate, int weight) {
        return new Product(shortName, fullName, code, description, vatrate, weight);
    }

    private static Nomenclature createService(String shortName, String fullName, String code, String description, VATRATE vatrate, String responsible) {
        return new Service(shortName, fullName, code, description, vatrate, responsible);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("Введите '1' чтобы просмотреть список товаров;");
        System.out.println("Введите '2' чтобы купить товар;");
        System.out.println("Введите '3' чтобы просмотреть корзину;");
        System.out.println("Введите '0' выйти.");
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    //DRY
    private static String getInput(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static void process(String command, Store store, Basket basket) {
        switch (command) {
            case "1": {
                store.printNomenclatures();
                break;
            }
            case "2": {
                addNomenclatureToBasket(store, basket);
                break;
            }
            case "3": {
                System.out.println(basket);
                checkout(store, basket);
                break;
            }
            default: {
            }
        }
    }

    private static void addNomenclatureToBasket(Store store, Basket basket) {
        String nomenclatureIndexAsString = getInput("Введите номер товара для покупки: ");
        String amountAsString = getInput("Введите количество: ");
        try {
            int i = Integer.parseInt(nomenclatureIndexAsString);
            int a = Integer.parseInt(amountAsString);
        } catch (Exception e) {
            return;
        }
        int index = Integer.parseInt(nomenclatureIndexAsString);
        int amount = Integer.parseInt(amountAsString);
        Nomenclature nomenclature = store.getNomenclature(index - 1);

        if (null != nomenclature) {
            BasketElement basketElement = new BasketElement(nomenclature,
                    store.getPrice(nomenclature),
                    amount,
                    0);
            basket.add(basketElement);
        }
    }

    private static void checkout(Store store, Basket basket) {
        if (!basket.isEmpty()) {
            String input = getInput("Введите '0' чтобы оформить заказ или '1' чтобы продолжить совершать покупки: ");
            if (input.equals("0")) {
                Order order = new Order(basket, store);
                PaymentSystem paymentSystem = new InProgramPayment();
                paymentSystem.pay(order);
            }
        }
    }
}
