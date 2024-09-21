package org.example.ontap.jdbc;

import java.sql.*;

public class SelectExample {
    public static void main(String args[]) {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ontap_database4", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", name_st: " + rs.getString("name_st"));
                System.out.print(", clazz: " + rs.getString("clazz"));
                System.out.println(", phone: " + rs.getString("phone"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
