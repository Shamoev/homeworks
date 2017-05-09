package edu.sourceit.homeworks.homework15;

import edu.sourceit.homeworks.homework15.constants.JdbcConstants;
import edu.sourceit.homeworks.homework15.model.User;
import edu.sourceit.homeworks.homework15.model.UserRole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InsertUser {
    public static void main(String[] args) {
        User user = createRandomUser();
        try (Connection con = DriverManager.getConnection(JdbcConstants.CONNECTION_URL)) {
            PreparedStatement stmt = con.prepareStatement(JdbcConstants.INSERT_USER_SQL);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setLong(6, user.getUserRole().getId());
            // stmt.execute(); it works
            // con.commit(); error! autocommit is true
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

    private static User createRandomUser() {
        User result = new User();
        result.setName(createRandomString());
        result.setLastName(createRandomString());
        result.setLogin(createRandomString());
        result.setPassword(createRandomString());
        result.setEmail(createRandomString());
        UserRole userRole = new UserRole();
        userRole.setId(2);
        result.setUserRole(userRole);
        return result;
    }

    private static  String createRandomString() {
        Random random = new Random();
        int length = random.nextInt(3) + 5;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) + 32));
        }
        return String.valueOf(result);
    }
}
