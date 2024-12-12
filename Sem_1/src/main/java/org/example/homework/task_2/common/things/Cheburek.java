package org.example.homework.task_2.common.things;

import org.example.homework.task_2.common.interfaces.SemiFinishedFood;

public class Cheburek implements SemiFinishedFood {
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
        return "Чебурек";
    }
}
