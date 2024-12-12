package org.example.homework.task_2.common.things;

import org.example.homework.task_2.common.interfaces.SemiFinishedFood;

/**
 * Замороженные вареники с ягодами
 */
public class DumplingsBerries implements SemiFinishedFood {
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
        return "Замороженные вареники с ягодами";
    }
}
