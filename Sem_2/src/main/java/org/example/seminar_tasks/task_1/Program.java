package org.example.seminar_tasks.task_1;

/*
Получите информацию о классе "Person" с использованием Reflection API:
выведите на экран все поля и методы класса.
Создайте экземпляр классa "Person" с использованием Reflection API,
установите значения полей и вызовите методы.
Реализуйте обработку исключений для обеспечения корректного взаимодействия c Reflection API.
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        Person person1 = new Person("Seva", "123456789");
        Person person2 = new Person("Joe", "123456789");
        Person person3 = new Person("Mike", "123456789");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        Class<?> person = null;
        try {
            person = Class.forName(Person.class.getName());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());;
        }

        Constructor<?>[] constructors = null;
        if (person != null) {
            constructors = person.getConstructors();
            Arrays.stream(constructors[0].getParameters()).forEach(System.out::println);
        }

        Object vsevolod = null;
        try {
            if (constructors != null) {
                vsevolod = constructors[0].newInstance("Qwerty", "12343");
            }
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }

        Field[] fields = null;
        if (vsevolod != null) {
            fields = vsevolod.getClass().getDeclaredFields();
        }
        if (fields != null) {
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        }

        Method[] methods = person1.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

}