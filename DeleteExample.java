package org.example.ontap.jdbc;

import java.sql.*;

public class DeleteExample {
    public static final InfoDatabase infoDb = new InfoDatabase();
    public static final String QUERY_DELETE = "DELETE FROM student WHERE id  = 14";
    public static final String QUERY_SELECT = "SELECT * FROM student";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(infoDb.DB_URL, infoDb.USER, infoDb.PASS);
            PreparedStatement p = conn.prepareStatement(QUERY_DELETE);
            System.out.println(p.executeUpdate());
            int checkResultDeleted = p.executeUpdate();
            if (checkResultDeleted == 0) {
                System.out.println("DELETE SUCCESS!");
            } else {
                System.out.println("DELETE FAILED!");
            }
            Statement stmt = conn.createStatement();
            stmt.executeQuery(QUERY_SELECT);
            ResultSet rs = stmt.executeQuery(QUERY_SELECT);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String clazz = rs.getString(3);
                String phone = rs.getString(4);
                System.out.println(id + " " + name + " " + clazz + " " + phone);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
