package org.example;

import java.io.PrintStream;
import java.sql.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/shop";

    static final String USER = "root";
    static final String PASS = "";

    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );

        PrintStream p = new PrintStream(System.out);
        Scanner s = new Scanner(System.in);

        Connection connection = null;
        Statement statement = null;

        String sql;

        try {
            Class.forName(JDBC_DRIVER);
            p.println("Establishing Connection...");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
            sql = "SELECT id,age,first,last FROM employees";

            ResultSet rs = statement.executeQuery(sql);

            p.format("|%5s| |%5s| |%20s| |%20s|\n","ID","AGE","FIRST NAME","LAST NAME");
            while(rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                p.format("|%5s| |%5s| |%20s| |%20s|\n",id,age,first,last);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        s.close();
        p.close();


    }
}
