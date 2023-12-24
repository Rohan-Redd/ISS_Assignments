package jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JDBCUserInfo {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/forms";
        String user = "root";
        String password = "admin";

        // SQL query to execute for retrieving data before update
        String selectSqlBeforeUpdate = "SELECT * FROM forms.members";

        // SQL query to execute for updating email and password
        String updateSql = "UPDATE forms.members SET email = ?, password = ? WHERE name = 'Rohan'";

        // SQL query to execute for retrieving data after update
        String selectSqlAfterUpdate = "SELECT * FROM forms.members";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                // Display existing data before update
                displayData(connection, selectSqlBeforeUpdate);

                // Update the email and password for a particular member.
                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                    updateStatement.setString(1, "newemail@gmail.com");
                    updateStatement.setString(2, "newpassword");
                    int updateCount = updateStatement.executeUpdate();

                    System.out.println("Rows updated: " + updateCount);
                }

                // Display updated data
                displayData(connection, selectSqlAfterUpdate);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayData(Connection connection, String selectSql) throws SQLException {
        try (PreparedStatement selectStatement = connection.prepareStatement(selectSql);
             ResultSet resultSet = selectStatement.executeQuery()) {

            // Display data
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String passwordColumn = resultSet.getString("password");

                System.out.println("Name: " + name + ", Email: " + email + ", Password: " + passwordColumn);
            }
            System.out.println();
        }
    }
}
