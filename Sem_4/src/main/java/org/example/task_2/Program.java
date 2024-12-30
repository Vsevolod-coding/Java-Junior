package org.example.task_2;

import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    /*
    * Настройте Hibernate, связав его с вашей базой данных.
    * Создайте класс Student в Java, аннотируя его как сущность Hibernate.
    * Используя Hibernate, реализуйте вставку, чтение, обновление и удаление данных в таблице students.
    * Обратите внимание на использование сессий и транзакций в Hibernate
    * */
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory())
        {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student student = Student.create();
            session.save(student);
            System.out.println("Obj student saved!");


            Student retrievedStudent = session.get(Student.class, student.getId());
            System.out.println("Obj student retrieved!");
            System.out.println("Retrieved student obj: " + retrievedStudent);

            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Obj student updated!");

            session.delete(retrievedStudent);
            System.out.println("Obj student deleted!");


            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
