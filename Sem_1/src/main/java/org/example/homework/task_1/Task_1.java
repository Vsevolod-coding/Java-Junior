package org.example.homework.task_1;

// Напишите программу, которая использует Stream API для обработки списка чисел.
// Программа должна вывести на экран среднее значение всех четных чисел в списке.

import java.util.Arrays;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).average());
    }
}
