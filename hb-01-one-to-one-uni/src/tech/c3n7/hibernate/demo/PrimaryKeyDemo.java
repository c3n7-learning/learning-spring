package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create 3 student objects");
            Student tempStudent1 = new Student("Ann", "Mumo", "annmumo@gmail.com");
            Student tempStudent2 = new Student("Jane", "Johnson", "janedoe@gmail.com");
            Student tempStudent3 = new Student("Jean", "Luc", "jeanluc@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("Done.");
        } finally {
            factory.close();
        }
    }
}
