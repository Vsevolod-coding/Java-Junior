package org.example.homework.task_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Mike", 19, 5.2);
        Student student2 = new Student("Joe", 19, 3.8);
        students.add(student1);
        students.add(student2);

        MySerialization.saveStudentsToFile(MySerialization.FILE_JSON, students);
        MySerialization.saveStudentsToFile(MySerialization.FILE_XML, students);

        List<Student> studentsJSON = MySerialization.loadStudentsFromFile(MySerialization.FILE_JSON);
        List<Student> studentsXML = MySerialization.loadStudentsFromFile(MySerialization.FILE_XML);

        System.out.println("FROM JSON:");
        studentsJSON.forEach(System.out::println);
        System.out.println();
        System.out.println("FROM XML:");
        studentsXML.forEach(System.out::println);
    }
}
