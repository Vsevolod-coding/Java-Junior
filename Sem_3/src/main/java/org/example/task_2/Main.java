package org.example.task_2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.task_2.ToDoListApp.*;

public class Main {
    public static void main(String[] args) {
        List<ToDo> tasks;

        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            tasks = loadTasksFromFile(FILE_JSON);
        } else
            tasks = prepareTasks();
        ToDoListApp.saveTaskToFile(FILE_JSON, tasks);
        ToDoListApp.saveTaskToFile(FILE_BIN, tasks);
        ToDoListApp.saveTaskToFile(FILE_XML, tasks);

        displayTasks(tasks);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:" + System.lineSeparator()
                    + "1) Добавить новую задачу" + System.lineSeparator()
                    + "2) Отметить задачу как 'Выполнена'" + System.lineSeparator()
                    + "3) Выйти" + System.lineSeparator());
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    ToDoListApp.addNewTask(scanner, tasks);
                    break;
                case "2":
                    ToDoListApp.markTaskAsDone(scanner, tasks);
                    break;
                case "3":
                    ToDoListApp.saveTaskToFile(FILE_JSON, tasks);
                    ToDoListApp.saveTaskToFile(FILE_BIN, tasks);
                    ToDoListApp.saveTaskToFile(FILE_XML, tasks);
                    System.out.println("Список задач сохранен.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
            }
            displayTasks(tasks);
        }
    }

    private static List<ToDo> prepareTasks () {
        ArrayList<ToDo> tasks = new ArrayList<>();
        tasks.add(new ToDo("Зарядить ноутбук"));
        tasks.add(new ToDo("Сходить в магазин за продуктами"));
        tasks.add(new ToDo("Сделать ДЗ"));
        tasks.add(new ToDo("Полить цветы"));
        return tasks;
    }
}
