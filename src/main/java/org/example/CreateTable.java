package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public void createTable() {
        String jdbcURL = "jdbc:h2:./test;AUTO_SERVER=TRUE";
        System.out.println("Connected to H2 in-memory database.");

        //language = sql;
        String sql = """
           create table if not exists students (
           ID IDENTITY not null primary key,
           name varchar(50),
           age INT
          )
         """;

        try (Connection connection = DriverManager.getConnection(jdbcURL);
             Statement statement = connection.createStatement();
        ){
            statement.execute(sql);


        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
