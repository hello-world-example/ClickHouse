package xyz.kail.demo.clickhouse.jdbc;

import java.sql.*;

public class HelloMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("ru.yandex.clickhouse.ClickHouseDriver");
        Connection connection = DriverManager.getConnection("jdbc:clickhouse://localhost:8123/default");
        PreparedStatement preparedStatement = connection.prepareStatement("select now() n");
        ResultSet resultSet = preparedStatement.executeQuery();
        for (;resultSet.next();){
            System.out.println(resultSet.getDate(1));
        }

    }

}
