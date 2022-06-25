package tech.c3n7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.c3n7.hibernate.demo.entity.Student;

import javax.persistence.TypedQuery;
import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // query students
//            List<Student> theStudents = session.createQuery("from Student").getResultList();
            TypedQuery<Student> q = session.createQuery("from Student", Student.class);

            List<Student> theStudents = q.getResultList();

            // display the students
            printStudents(theStudents);

            // lastName = 'Doe'
            q = session.createQuery("from Student s where s.lastName='Luc'", Student.class);
            theStudents = q.getResultList();

            // display the students
            System.out.println("\n\nStudents with last name of Luc");
            printStudents(theStudents);


            q = session.createQuery("from Student s where s.lastName='Luc'"
                    +" OR s.firstName='Jane' ", Student.class);
            theStudents = q.getResultList();

            // display the students
            System.out.println("\n\nStudents with last name of Luc or first name of Jane");
            printStudents(theStudents);


            q = session.createQuery("from Student s where s.email LIKE '%gmail.com' ", Student.class);
            theStudents = q.getResultList();

            // display the students
            System.out.println("\n\nStudents whose email ends with gmail.com");
            printStudents(theStudents);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    public static void printStudents(List<Student> theStudents) {
        for(Student student: theStudents) {
            System.out.println(student);
        }
    }
}
