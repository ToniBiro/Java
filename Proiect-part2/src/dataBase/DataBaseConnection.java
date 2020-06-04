package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {

    private static final String MYSQL_JDBC_DRIVER = "localhost.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/sys";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static volatile DataBaseConnection instance;
    private Connection connection;

    public static Connection getDatabaseConnection() {
        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    instance = new DataBaseConnection();
                }
            }
        }
        return instance.connection;
    }

    private DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Could not connect to database: " + e.getMessage());
        }
        System.out.println("MySql connection available");
    }
}