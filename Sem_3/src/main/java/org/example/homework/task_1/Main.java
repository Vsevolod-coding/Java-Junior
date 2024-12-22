package org.example.homework.task_1;

import java.io.*;

public class Main {
    private static final String FILE_NAME = "Students.ser";

    public static void main(String[] args) {
        Student student1 = new Student("Mike", 19, 5.2);

        serObj(student1);
        System.out.println(deserObj(FILE_NAME));
    }

    private static void serObj(Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Student deserObj(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
