package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Instructor;
import tech.c3n7.hibernate.demo.entity.InstructorDetail;
import tech.c3n7.hibernate.demo.entity.Student;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor tempInstructor =
                    new Instructor("Chad", "Darby", "chard@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://www.luv2code.com", "Luv 2 Code"
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
            factory.close();
        }
    }
}
