package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Student;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create a new student object");
            Student tempStudent = new Student("Wood", "Person", "woodperson@furniture.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            session.getTransaction().commit();
            System.out.println("Saved Student. Generated id: " + tempStudent.getId());
            System.out.println("Done.");


            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting the student with id: "+ tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done.");
        } finally {
            factory.close();
        }
    }
}
