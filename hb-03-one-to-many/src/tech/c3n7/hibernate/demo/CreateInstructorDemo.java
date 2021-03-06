package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Course;
import tech.c3n7.hibernate.demo.entity.Instructor;
import tech.c3n7.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor =
                    new Instructor("Gunnar", "Gunnarson", "gunnar.gunnarson@gunnars.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://www.gunnars.com", "Shooting Stuff"
            );

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            // save the instructor (this will ALSO save the details object because of CascadeType.ALL)
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

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
