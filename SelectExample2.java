package org.example.ontap.jdbc;

import java.sql.*;

public class SelectExample2 {
    public static InfoDatabase infoDatabase = new InfoDatabase();

    public static Connection getConnection(String dbURL, String userName, String passWord) {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, passWord);
            System.out.println("Connected to the database successfully");
        } catch (Exception e) {
            System.out.println("connect failure!");
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection(infoDatabase.DB_URL, infoDatabase.USER, infoDatabase.PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name_st");
                String clazz = resultSet.getString("clazz");
                String phone = resultSet.getString("phone");
                System.out.println("ID: " + id + "\t" + "Name: " + name + "\t" + "Class: " + clazz + "\t" + "phone: " + phone);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
