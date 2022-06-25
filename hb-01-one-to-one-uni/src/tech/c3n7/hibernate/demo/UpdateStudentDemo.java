package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting the student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Get complete: " + myStudent);

            System.out.println("Updating student");
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done.");



            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Updating emails");
            session.createQuery("update Student set email='foo@outlook.com'")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done.");
        } finally {
            factory.close();
        }
    }
}
