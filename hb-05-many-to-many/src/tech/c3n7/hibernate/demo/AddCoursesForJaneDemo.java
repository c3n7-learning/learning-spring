package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.*;

public class AddCoursesForJaneDemo {
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

            System.out.println("Loaded student: " + theStudent);
            System.out.println("Current course(s): " + theStudent.getCourses());

            // create more courses
            Course tempCourse1 = new Course("DVORAK - How to type faster");
            Course tempCourse2 = new Course("Krita: a tool for gentlemen, ladies, and scholars");

            // add jane to those courses
            tempCourse1.addStudent(theStudent);
            tempCourse2.addStudent(theStudent);

            // save the courses
            System.out.println("\nSaving courses");
            session.save(tempCourse1);
            session.save(tempCourse2);
            System.out.println("Done saving courses\n");

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
