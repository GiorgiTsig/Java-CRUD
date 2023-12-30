package org.example;

import java.io.IOException;
import java.sql.*;


public class StudentDao {

      public void insertOperation(Student student) {
          String jdbcURL = "jdbc:h2:./test;AUTO_SERVER=TRUE";

          //language=sql
          String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";

          try (Connection connection = DriverManager.getConnection(jdbcURL);
              PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

              preparedStatement.setString(1, student.getName());
              preparedStatement.setInt(2, student.getAge());


              int rows = preparedStatement.executeUpdate();
            System.out.println("rowsAffected = " + insertSQL);
            if (rows > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateOperation(Integer id, String name) {
        String jdbcURL = "jdbc:h2:./test;AUTO_SERVER=TRUE";

        //language=sql
        String insertSQL = "UPDATE students SET name = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);


            int rows = preparedStatement.executeUpdate();
            System.out.println("rowsAffected = " + insertSQL);
            if (rows > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Failed to updated data.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void deleteOperation(Integer id, String name) {
        String jdbcURL = "jdbc:h2:./test;AUTO_SERVER=TRUE";

        //language=sql
        String insertSQL = "DELETE FROM students WHERE name = ? AND id = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);


            int rows = preparedStatement.executeUpdate();
            System.out.println("rowsAffected = " + insertSQL);
            if (rows > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("Failed to deleted data.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
