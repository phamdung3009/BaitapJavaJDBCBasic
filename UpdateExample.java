package org.example.ontap.jdbc;

import java.sql.*;

public class UpdateExample {
    public static void main(String[] args) {
        InfoDatabase infoDb = new InfoDatabase();
        String QUERY_UPDATE = "UPDATE student SET name_st = 'Minh', clazz = 'Git', phone = '0989059555' WHERE id = 5";
        try {
            Connection con = DriverManager.getConnection(infoDb.DB_URL, infoDb.USER, infoDb.PASS);
            PreparedStatement p = con.prepareStatement(QUERY_UPDATE);
            // p.executeQuery(); executeQuery() chỉ được sử dụng cho các câu lệnh SQL truy vấn SELECT
            int checkResultUpdate = p.executeUpdate(); // kiểm tra kết quả update success = 1 fail = 0;
            System.out.println(p.executeUpdate());
            if (checkResultUpdate > 0) {
                System.out.println("UPDATE SUCCESS!");
            } else {
                System.out.println("UPDATE FAILED!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
