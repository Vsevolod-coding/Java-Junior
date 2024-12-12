package org.example.homework.task_2.common.things;

import org.example.homework.task_2.common.interfaces.HealthyFood;

public class Chicken implements HealthyFood {

    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
}
