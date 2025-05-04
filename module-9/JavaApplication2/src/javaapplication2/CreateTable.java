package javaapplication2;


import java.sql.*;

public class CreateTable {
    Connection con;
    Statement stmt;

    public CreateTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

       String url = "jdbc:mysql://localhost:3306/databasedb?allowPublicKeyRetrieval=true&useSSL=false";


         con = DriverManager.getConnection(url, "student1", "pass");

            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            System.exit(0);
        }

        try {
            stmt.executeUpdate("DROP TABLE address");
            System.out.println("Table address dropped.");
        } catch (SQLException e) {
            System.out.println("Table address does not exist or could not be dropped: " + e.getMessage());
        }

        try {
            stmt.executeUpdate("CREATE TABLE address(ID int PRIMARY KEY, LASTNAME varchar(40), " +
                    "FIRSTNAME varchar(40), STREET varchar(40), CITY varchar(40), STATE varchar(40), ZIP varchar(40))");
            System.out.println("Table address created.");
        } catch (SQLException e) {
            System.out.println("Table address creation failed: " + e.getMessage());
        }

        try {
            stmt.close();
            con.close();
            System.out.println("Database connections closed.");
        } catch (SQLException e) {
            System.out.println("Connection close failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CreateTable();
    }
}
