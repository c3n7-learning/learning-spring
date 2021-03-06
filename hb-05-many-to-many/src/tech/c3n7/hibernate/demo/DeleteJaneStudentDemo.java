package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.*;

public class DeleteJaneStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            // get the student jane from the db
            int studentId = 2;
            Student theStudent = session.get(Student.class, studentId);

            System.out.println("\nLoaded student: " + theStudent);
            System.out.println("\nCurrent course(s): " + theStudent.getCourses());

            System.out.println("\nDeleting Student");
            session.delete(theStudent);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done.");
        } finally {
            // Clean up code
            session.close();

            factory.close();
        }
    }
}
