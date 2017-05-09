package edu.sourceit.homeworks.homework15.constants;

public class JdbcConstants {
    //public final static String CONNECTION_URL       = "jdbc:mysql://127.0.0.1:3306/SourceIt?user=root&password=2004";
    public final static String CONNECTION_URL       = "jdbc:mysql://127.0.0.1:3306/SourceIt?user=root&password=Parol2004";

    public final static String INSERT_USER_SQL      = "INSERT INTO USERS (NAME, LASTNAME, LOGIN, PASSWORD, EMAIL, " +
            "USER_ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";

    public final static String DELETE_USER_SQL      = "DELETE FROM USERS WHERE ID = ?";

    public final static String SELECT_ALL_USERS_SQL = "SELECT \n" +
            "    U.ID,\n" +
            "    U.NAME,\n" +
            "    U.LASTNAME,\n" +
            "    U.LOGIN,\n" +
            "    U.PASSWORD,\n" +
            "    U.EMAIL,\n" +
            "    U.USER_ROLE_ID,\n" +
            "    UR.ROLE\n" +
            "FROM\n" +
            "    USERS U\n" +
            "        JOIN\n" +
            "    USER_ROLES UR ON U.USER_ROLE_ID = UR.ID;";

    public final static String SELECT_USER_SQL = "SELECT \n" +
            "    U.ID,\n" +
            "    U.NAME,\n" +
            "    U.LASTNAME,\n" +
            "    U.LOGIN,\n" +
            "    U.PASSWORD,\n" +
            "    U.EMAIL,\n" +
            "    U.USER_ROLE_ID,\n" +
            "    UR.ROLE\n" +
            "FROM\n" +
            "    USERS U\n" +
            "        JOIN\n" +
            "    USER_ROLES UR ON U.USER_ROLE_ID = UR.ID\n" +
            "WHERE\n" +
            "    U.ID = ?;";

    public final static String UPDATE_USER_SQL = "UPDATE USERS \n" +
            "SET \n" +
            "    NAME = ?,\n" +
            "    LASTNAME = ?,\n" +
            "    LOGIN = ?,\n" +
            "    PASSWORD = ?,\n" +
            "    EMAIL = ?,\n" +
            "    USER_ROLE_ID = ?\n" +
            "WHERE\n" +
            "    ID = ?";

    private JdbcConstants() {}
}
