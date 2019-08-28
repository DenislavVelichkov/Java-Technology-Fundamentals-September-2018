package Data_Base_Basics;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username default (root): ");

        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;

        System.out.println("Enter password default (empty):");
        String password = sc.nextLine().trim();
        Properties props = new Properties();

        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement stmt = connection.prepareStatement
                ("SELECT  * FROM employees WHERE salary > ?");

        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));

        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            System.out.printf("%s %s",
                    result.getString("first_name"),
                    result.getString("last_name"));
        }
    }
}
