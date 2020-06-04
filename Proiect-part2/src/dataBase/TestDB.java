package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {

    public static void main(String[] args) {

        Connection connection = DataBaseConnection.getDatabaseConnection();
    }

}
