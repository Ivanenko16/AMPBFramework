package db;

import configuration.db.JdbcDriverSetUp;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TestDbSimple {

    JdbcDriverSetUp jdbcDriverSetUp =  new JdbcDriverSetUp() ;

    @Test()
    public void checkSalary() throws SQLException {
        jdbcDriverSetUp.dbDriverSetUp();
        Connection connectionDb = jdbcDriverSetUp.getConnection();
        Assert.assertNotNull(connectionDb);

        Statement statement = connectionDb.createStatement();
        ResultSet resultSet = statement
                .executeQuery("Select user.username, salary.amount from user join salary on user.position = salary.position");
        List<Integer> listSalary = new ArrayList<>();
        while (resultSet.next()) {
            int salary = resultSet.getInt(2);
            listSalary.add(salary);
        }
        int theBiggestSalary = listSalary.stream()
                .mapToInt(v -> v)
                .max()
                .orElseThrow(NoSuchElementException::new);
        Assert.assertTrue("Salary more than expected", 6500 > theBiggestSalary);
    }

}
