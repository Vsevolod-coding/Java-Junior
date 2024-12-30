package org.example.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory())
        {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Course course = Course.create();
            session.save(course);
            System.out.println("Obj course saved!");

            Course retrievedCourse = session.get(Course.class, course.getId());
            System.out.println("Obj course retrieved!");
            System.out.println("Retrieved course obj: " + retrievedCourse);

            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            System.out.println("Obj course updated!");

            session.delete(retrievedCourse);
            System.out.println("Obj course deleted!");


            session.getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
