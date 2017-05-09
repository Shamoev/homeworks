package edu.sourceit.homeworks.homework15;


import edu.sourceit.homeworks.homework15.model.User;

import java.sql.*;

import static edu.sourceit.homeworks.homework15.constants.JdbcConstants.*;

public class UpdateUserById {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(CONNECTION_URL)) {
            PreparedStatement pstmt = con.prepareStatement(SELECT_USER_SQL);
            int id = 4;
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = ReadUserById.readUser(rs);
                user.setName("Alex");
                user.setPassword("987");
                pstmt = con.prepareStatement(UPDATE_USER_SQL);
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getLastName());
                pstmt.setString(3, user.getLogin());
                pstmt.setString(4, user.getPassword());
                pstmt.setString(5, user.getEmail());
                pstmt.setLong(6, user.getUserRole().getId());
                pstmt.setLong(7, user.getId());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
