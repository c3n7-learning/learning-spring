package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Course;
import tech.c3n7.hibernate.demo.entity.Instructor;
import tech.c3n7.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            // get the instructor from the db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("\n\tInstructor " + tempInstructor);
            System.out.println("\n\tCourses " + tempInstructor.getCourses());

            // commit the transaction
            session.getTransaction().commit();
            // Close the session
            session.close();

            System.out.println("\n\tThe Session is now closed!");
            System.out.println("\n\tCourses " + tempInstructor.getCourses());

            System.out.println("Done.");
        } finally {
            // Clean up code
            session.close();

            factory.close();
        }
    }
}
