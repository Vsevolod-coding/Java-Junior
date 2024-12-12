package org.example.homework.task_2.common.things;

import org.example.homework.task_2.common.interfaces.Snack;

public class Bread implements Snack {

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Хлеб";
    }
}
