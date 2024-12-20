package org.example.homework;

import java.lang.reflect.Method;

/*
* Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
* */
public class Program {
    public static void main(String[] args) {
        Class<?> objClass = String.class;
        Method[] methods = objClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
