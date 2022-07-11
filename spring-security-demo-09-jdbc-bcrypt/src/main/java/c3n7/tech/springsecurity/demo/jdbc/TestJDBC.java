package c3n7.tech.springsecurity.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/spring_security_demo_plaintext?useSSL=false";
//        String jdbcUrl = "jdbc:mariadb://localhost:3306/hb_student_tracker?useSSL=false";
        String uu = "test_user";
        String ss = "test_pass";
        try {
            System.out.println("Connecting to database " +jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, uu, ss);
            System.out.println("Connection successful");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
