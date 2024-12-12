package org.example.task_2;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        final int num = 1;

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.forEach(string -> {
            string = string + (num + 1);
            System.out.println(string);
        });
    }
}
