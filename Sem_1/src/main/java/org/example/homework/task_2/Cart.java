package org.example.homework.task_2;

import org.example.homework.task_2.common.interfaces.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food> {
    private final UMarket market;
    private final ArrayList<T> foodstuff;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuff = new ArrayList<>();
    }

    public void cartBalancing() {
        boolean pfcError = false;

        if (foodstuff.stream().noneMatch(Food::getProteins)) {
            var thing = market.getThings(clazz).stream().filter(Food::getProteins).findFirst().orElse(null);
            if (thing != null) {
                foodstuff.add(thing);
            } else {
                pfcError = true;
            }
        }

        if (foodstuff.stream().noneMatch(Food::getFats)) {
            var thing = market.getThings(clazz).stream().filter(Food::getFats).findFirst().orElse(null);
            if (thing != null) {
                foodstuff.add(thing);
            } else {
                pfcError = true;
            }
        }

        if (foodstuff.stream().noneMatch(Food::getCarbohydrates)) {
            var thing = market.getThings(clazz).stream().filter(Food::getCarbohydrates).findFirst().orElse(null);
            if (thing != null) {
                foodstuff.add(thing);
            } else {
                pfcError = true;
            }
        }

        if (pfcError) {
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        } else {
            System.out.println("Корзина сбалансирована по БЖУ.");
        }
    }


    public void printFoodStuff() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuff.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s, Жиры %s, Углеводы %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    public Collection<T> getFoodStuff() {
        return foodstuff;
    }
}
