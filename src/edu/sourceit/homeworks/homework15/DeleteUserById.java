package edu.sourceit.homeworks.homework15;

import edu.sourceit.homeworks.homework15.constants.JdbcConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static edu.sourceit.homeworks.homework15.constants.JdbcConstants.CONNECTION_URL;

public class DeleteUserById {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONNECTION_URL);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(JdbcConstants.DELETE_USER_SQL);
            stmt.setLong(1, 3);
            // stmt.execute(); // it works
            int updatedRows = stmt.executeUpdate();
            System.out.println(updatedRows + " were updated");

            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {}
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {}
            }
        }
    }
}
