package org.example.task_2;

import java.io.Serializable;

public class ToDoV1 implements Serializable {
    private String title;
    private boolean isDone;

    public String getTitle() {
        return title;
    }

    public ToDoV1() {}

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
