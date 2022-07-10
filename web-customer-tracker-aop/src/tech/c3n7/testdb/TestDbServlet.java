package tech.c3n7.testdb;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

import java.io.IOException;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // setup connection variables
        String user = "test_user";
        String pass = "test_pass";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "org.mariadb.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to the database : " + jdbcUrl);

            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Connection successful");

            myConn.close();
        }catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }

        // get connection to database
    }
}
