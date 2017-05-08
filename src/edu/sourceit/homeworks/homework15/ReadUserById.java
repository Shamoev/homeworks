package edu.sourceit.homeworks.homework15;


import edu.sourceit.homeworks.homework15.model.User;
import edu.sourceit.homeworks.homework15.model.UserRole;

import java.sql.*;

import static edu.sourceit.homeworks.homework15.constants.JdbcConstants.CONNECTION_URL;
import static edu.sourceit.homeworks.homework15.constants.JdbcConstants.SELECT_USER_SQL;

public class ReadUserById {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(CONNECTION_URL)) {
            PreparedStatement stmt = con.prepareStatement(SELECT_USER_SQL);
            stmt.setLong(1, 2);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = readUser(rs);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

    public static User readUser(ResultSet rs) throws SQLException {
        User result = new User();
        result.setId(rs.getLong("ID"));
        result.setName(rs.getString("NAME"));
        result.setLastName(rs.getString("LASTNAME"));
        result.setLogin(rs.getString("LOGIN"));
        result.setPassword(rs.getString("PASSWORD"));
        result.setEmail(rs.getString("EMAIL"));
        UserRole userRole = new UserRole();
        userRole.setId(rs.getLong("USER_ROLE_ID"));
        userRole.setRole(rs.getString("ROLE"));
        result.setUserRole(userRole);
        return result;
    }
}
