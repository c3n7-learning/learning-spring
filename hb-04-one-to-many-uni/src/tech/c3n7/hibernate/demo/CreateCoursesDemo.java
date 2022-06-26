package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Course;
import tech.c3n7.hibernate.demo.entity.Instructor;
import tech.c3n7.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {
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

            Course tempCourse1 = new Course("Air Guitar - Ultimate Guide");
            Course tempCourse2 = new Course("Writing - A to Z");

            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // save courses
            session.save(tempCourse1);
            session.save(tempCourse2);

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
