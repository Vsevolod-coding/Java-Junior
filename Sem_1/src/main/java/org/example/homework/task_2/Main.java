package org.example.homework.task_2;

import org.example.homework.task_2.common.interfaces.*;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static UMarket market = new UMarket();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин U-Market");

        startApp();
    }

    private static void startApp() {
        while (true) {
            System.out.println(showMenu());
            if (scanner.hasNextLine()) {
                int no = scanner.nextInt();
                scanner.nextLine();

                switch (no) {
                    case 0 -> {
                        System.out.println("Завершение работы приложения.");
                        System.exit(0);
                    }
                    case 1 -> {
                        System.out.println("Список товаров:");
                        market.printThings(Thing.class);
                    }
                    case 2 -> createCart(Snack.class, market);
                    case 3 -> createCart(SemiFinishedFood.class, market);
                    case 4 -> createCart(HealthyFood.class, market);
                    case 5 -> createCart(Food.class, market);
                    default -> System.out.println("Пункт меню не существует.\nПожалуйста, повторите попытку ввода.");
                }
            } else {
                System.out.println("Некорректный пункт меню.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
    }

    private static <T extends Food> void createCart(Class<T> clazz, UMarket market) {
        Cart<T> cart = new Cart<>(clazz, market);

        while (true) {
            System.out.println("Список доступных товаров:");
            System.out.println("[0] Завершение формирования корзины + балансировка.");
            market.printThings(clazz);
            System.out.println("Укажите номер товара для добавления :");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                if (no == 0) {
                    cart.cartBalancing();
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodStuff();
                    return;
                } else {
                    T thing = market.getThingsByIndex(clazz, no);
                    if (thing == null) {
                        System.out.println("Некорректный номер товара.\nПожалуйста, повторите попытку ввода.");
                        continue;
                    }
                    cart.getFoodStuff().add(thing);
                    System.out.println("Товар успешно добавлен в корзину.");
                    System.out.println("Ваша корзина содержит продукты:");
                    cart.printFoodStuff();
                }
            } else {
                System.out.println("Некорректный пункт меню.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }
        }
    }

    private static String showMenu() {
        return """

                ========================================================================
                0 - Завершение работы приложения
                1 - Отобразить полный список товаров
                2 - Сформировать онлайн корзину из снеков
                3 - Сформировать онлайн корзину из полуфабрикатов
                4 - Сформировать онлайн корзину из продуктов для приготовления
                5 - Сформировать онлайн корзину из любых продовольственных товаров
                Выберите пункт меню:\s""";
    }
}
