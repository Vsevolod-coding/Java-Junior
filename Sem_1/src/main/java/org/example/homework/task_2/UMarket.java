package org.example.homework.task_2;

import org.example.homework.task_2.common.interfaces.Food;
import org.example.homework.task_2.common.interfaces.Thing;
import org.example.homework.task_2.common.things.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Магазин UMarket
 * */

public class UMarket {

    private final Collection<Thing> things;

    public UMarket() {
        things = new ArrayList<>();
        initThings();
    }

    public <T extends Thing> T getThingsByIndex(Class<T> clazz, int index) {
//        int count = 1;
//        for (var thing : things) {
//            if (clazz.isAssignableFrom(thing.getClass())) {
//                if (index == count++)
//                    return (T)thing;
//            }
//        }
//        return null;
        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
//                .filter(thing -> index == counter.getAndIncrement())
                .filter(_ -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public <T extends Thing> Collection<T> getThings(Class<T> clazz) {
//        Collection<T> list = new ArrayList<>();
//        for (var thing : things) {
//            if (clazz.isAssignableFrom(thing.getClass())) {
//                list.add((T)thing);
//            }
//        }
//        return list;
        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .toList();
    }

    public <T extends Thing> void printThings(Class<T> clazz)  {
//        int index = 1;
//        for (var thing : things) {
//            if (clazz.isInstance(thing)) {
//                if (Food.class.isAssignableFrom(thing.getClass())) {
//                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
//                            index++, thing.getName(),
//                            ((Food)thing).getProteins() ? "Да" : "Нет",
//                            ((Food)thing).getFats() ? "Да" : "Нет",
//                            ((Food)thing).getCarbohydrates() ? "Да" : "Нет"
//                    );
//                } else {
//                    System.out.printf("[%d] %s\n", index++, thing.getName());
//                }
//            }
//        }
        int[] index = {1};
        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    if (Food.class.isAssignableFrom(thing.getClass())) {
                        Food foodThing = (Food) thing;
                        System.out.printf("[%d] %s (Белки: %s, Жиры: %s, Углеводы: %s)\n",
                                index[0]++, thing.getName(),
                                foodThing.getProteins() ? "Да" : "Нет",
                                foodThing.getFats() ? "Да" : "Нет",
                                foodThing.getCarbohydrates() ? "Да" : "Нет"
                        );
                    } else {
                        System.out.printf("[%d] %s\n", index[0]++, thing.getName());
                    }
                });
    }

    private void initThings() {
        things.add(new Pen());
        things.add(new NoteBook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingsBerries());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());
        things.add(new Bread());
    }

}
