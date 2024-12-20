package org.example.seminar_tasks.task_2;

public class Car {
    private final String model;
    private final String color;
    private final String releaseDate;

    public Car(String model, String color, String releaseDate) {
        this.model = model;
        this.color = color;
        this.releaseDate = releaseDate;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Cap{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
