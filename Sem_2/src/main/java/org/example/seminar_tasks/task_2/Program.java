package org.example.seminar_tasks.task_2;

import java.lang.reflect.Field;

/*
* Реализуйте обобщенный метод, который принимает объект и выводит в консоль значения всех его полей.
* Создайте класс "Саr" с различными полями (например, модель, цвет, год выпуска).
* Примените Reflection APІ для вывода значений полей созданного объекта класса "Car"
* с использованием ранее созданного метода.
* */
public class Program {

    public static void main(String[] args) {
        Car bmwM5 = new Car("BMW M5", "Black", "2020");

        printObjectInfo(bmwM5);
    }

    public static <T> void printObjectInfo(T obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + " : " + field.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
