package org.example.task_1;
/*
  1. Обычный способ:
Найти все книги, написанные определенным автором (например, "John Doe").
Найти все книги, изданные после определенного года (например, 2010).
Найти все уникальные названия книг в библиотеке.
  2. Использование лямбда-выражений:
Те же самые задачи, но с использованием лямбда-выражений и Stream АРІ для более компактного и выразительного кода.*/

import java.util.ArrayList;

public class Library {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();

        //books

        Book book1 = new Book("Catcher in the rye", "Jerome David Salinger", 1951);
        Book book2 = new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943);
        Book book3 = new Book("Tom Sawyer", "Mark Twain", 1876);
        Book book4 = new Book("War and peace", "Leo Tolstoy", 1867);
        Book book5 = new Book("Banana fish are being caught well", "Jerome David Salinger", 1948);
        Book book6 = new Book("1984", "George Orwell", 1949);

        //add books
        library.add(book1);
        library.add(book1);
        library.add(book1);
        library.add(book1);
        library.add(book2);
        library.add(book2);
        library.add(book2);
        library.add(book3);
        library.add(book3);
        library.add(book4);
        library.add(book4);
        library.add(book5);
        library.add(book5);
        library.add(book6);

        library.stream().filter(book -> book.getAuthor().contains("Salinger")).forEach(System.out::println);
        System.out.println();
        library.stream().filter(book -> book.getIssueYear() > 1920).forEach(System.out::println);
        System.out.println();
//        library.stream().distinct().forEach(System.out::println);
        library.stream().map(Book::getTitle).distinct().forEach(System.out::println);
    }
}