package edu.sourceit.homeworks.homework15;

import edu.sourceit.homeworks.homework15.model.User;
import edu.sourceit.homeworks.homework15.model.UserRole;

import java.sql.*;

import static edu.sourceit.homeworks.homework15.constants.JdbcConstants.CONNECTION_URL;
import static edu.sourceit.homeworks.homework15.constants.JdbcConstants.SELECT_ALL_USERS_SQL;

public class ReadAllUsers {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(CONNECTION_URL);
        ) {
            // 2nd method
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_USERS_SQL);
            ResultSet rs = stmt.executeQuery();

            // 1st method
            /*Statement stmt = con.createStatement();
            stmt.execute(SELECT_ALL_USERS_SQL);
            ResultSet rs = stmt.getResultSet();*/

            while (rs.next()) {
                User user = ReadUserById.readUser(rs);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
