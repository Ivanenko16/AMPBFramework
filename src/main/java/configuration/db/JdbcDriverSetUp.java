package configuration.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class JdbcDriverSetUp {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(JdbcDriverSetUp.class));
    private Connection connection;

    public void dbDriverSetUp() {
        LOGGER.info("---------MySQL JDBC Connection---------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException exception) {
            LOGGER.info("MySQL JDBC Driver location is missing");
            exception.printStackTrace();
            return;
        }

        LOGGER.info("MySQL JDBC Driver Registered");

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "Password");
        } catch (SQLException sqlException) {
            LOGGER.info("Connection is Failed!, Check output console");
            sqlException.printStackTrace();
            return;
        }

        if (connection != null) {
            LOGGER.info("You made it, take control your database now!");
        } else {
            LOGGER.info("Failed to make connection!");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
