package tech.c3n7.springdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/web_customer_tracker?useSSL=false";
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
