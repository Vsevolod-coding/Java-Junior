package org.example.task_1;

import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {
    private static final String dbName = "studentsDB";
    private static final String tableName = "students";
    private static final Random random = new Random();

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pwd = "qwerty_123_pwd";

        try (Connection connection = DriverManager.getConnection(url, user, pwd)) {
            // Create db
            createDatabase(connection);
            System.out.println("DATABASE created successfully");

            // Using current db
            useDatabase(connection);
            System.out.println("Using " + dbName);

            // Create table
            createTable(connection);
            System.out.println("Table created!");

            // Inserting some data
            int count = random.nextInt(5,11);
            for (int i = 0; i < count; i++) {
                insertData(connection,Student.create());
            }
            System.out.println("Data inserted successfully!");

            // Reading data
            Collection<Student> students = readData(connection);
            assert students != null;
            for (var student : students) {
                System.out.println(student);
            }
            System.out.println("Data read successfully!");

            // Updating data
            for (var student : students) {
                student.updateName();
                student.updateAge();
                updateData(connection, student);
            }
            System.out.println("Updating finished successfully!");

            // Deleting data
            for (int i = 0; i < students.size(); i++) {
                deleteData(connection, i);
            }
            System.out.println("Deleting data finished successfully!");

            // Finish working with DB
            System.out.println("Connection with database was closed!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createDatabase(Connection connection) {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName + ";";
        try (PreparedStatement statement  =connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getErrorCode() + " " + e.getMessage());
        }
    }

    private static void useDatabase(Connection connection) {
        String useDatabaseSQL = "USE " + dbName + ";";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void createTable(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Insert data into table students
     * @param connection Connection with DB
     * @param student Student
     * */
    private static void insertData(Connection connection, Student student) {
        String insertDataSQL = "INSERT INTO " + tableName + " (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Чтение данных из таблицы students
     * @param connection Соединение с БД
     * @return Коллекция студентов
     * */
    private static Collection<Student> readData(Connection connection) {
        ArrayList<Student> studentList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                studentList.add(new Student(id, name, age));
            }
            return studentList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Updating data
     * @param connection Connection with db
     * @param student student
     * */
    private static void updateData(Connection connection, Student student) {
        String updateDataSQL = "UPDATE " + tableName + " SET name=?, age=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Удаление записи из таблицы students по идентификатору
     * @param connection Соединение с БД
     * @param id идентификатор записи
     * */
    private static void deleteData(Connection connection, int id) {
        String deleteDataSQL = "DELETE FROM " + tableName + " WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}