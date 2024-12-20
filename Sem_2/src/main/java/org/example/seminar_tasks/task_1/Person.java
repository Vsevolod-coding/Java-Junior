package org.example.seminar_tasks.task_1;

public class Person {
    private static int count = 0;
    private final int id;
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.id = count++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
