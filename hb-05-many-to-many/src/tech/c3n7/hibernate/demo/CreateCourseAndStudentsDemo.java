package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.*;

public class CreateCourseAndStudentsDemo {
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

            // create a course
            Course tempCourse = new Course("Pacman - Intermediate to Expert");

            // save the course
            System.out.println("\nSaving course.");
            session.save(tempCourse);
            System.out.println("Done saving course.\n");


            // add some students
            Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
            Student tempStudent2 = new Student("Jane", "Dean", "janedean@gmail.com");
            Student tempStudent3 = new Student("Joseph", "Jeannete", "jojean@gmail.com");

            // add students to course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);
            tempCourse.addStudent(tempStudent3);

            System.out.println("\nSaving students.");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            System.out.println("Done saving students.\n");

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
