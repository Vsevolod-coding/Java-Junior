package org.example.task_1;

/*Задача 1: Реализовать систему учета книг в библиотеке. У каждой книги есть название, автор и год издания.
          Необходимо создать список книг и выполнить следующие действия:
*/

public class Book {
    private final String title;
    private final String author;
    private final int issueYear;

    public Book(String title, String author, int issueYear) {
        this.title = title;
        this.author = author;
        if (issueYear > 1000 && issueYear < 2025) {
            this.issueYear = issueYear;
        } else {
            throw new IllegalArgumentException("Неверный год выпуска книги!");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIssueYear() {
        return issueYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Year of issue=" + issueYear +
                '}';
    }
}
