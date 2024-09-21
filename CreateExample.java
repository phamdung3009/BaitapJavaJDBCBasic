package org.example.ontap.jdbc;

import java.sql.*;

public class CreateExample {
    public static InfoDatabase infoDatabase = new InfoDatabase();
    static String QUERY_CREATE = "INSERT INTO student (id,name_st,clazz,phone) VALUES (10, 'NguyenVanA', 'JavaScript', '0989059556')";
    static String QUERY_SELECT = "select * from student";
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(infoDatabase.DB_URL, infoDatabase.USER, infoDatabase.PASS);
            PreparedStatement p = con.prepareStatement(QUERY_CREATE);
            int checkResultUpdate = p.executeUpdate();
            if (checkResultUpdate > 0) {
                System.out.println("CREATE SUCCESS!");
            } else {
                System.out.println("CREATE FAILED!");
            }
            Statement stmt = con.createStatement();
            stmt.executeQuery(QUERY_SELECT);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String clazz = rs.getString(3);
                String phone = rs.getString(4);
                System.out.println(id + " " + name + " " + clazz + " " + phone);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
