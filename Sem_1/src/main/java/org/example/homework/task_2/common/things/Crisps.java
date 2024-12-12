package org.example.homework.task_2.common.things;

import org.example.homework.task_2.common.interfaces.Snack;

public class Crisps implements Snack {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чипсы";
    }
}
