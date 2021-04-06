package doctor_journal;
import javax.swing.*;
import java.sql.*;

public class main {

    public static void main(String[] args) {
        patient person = new patient("asas", "sdsds", "sss", 20, "sdsds", 23333, 23333445, " sdsds");
        connectToDatabase();
    }

    static void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/patients";
        String username = "root";
        String password = "Pach1r1su";
        try  {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            String createTable = "CREATE TABLE IF NOT EXISTS patient_information ( " +
                    "id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255) NOT NULL, forename VARCHAR(255) NOT NULL, surname VARCHAR(255) NOT NULL, " +
                    "age INT NOT NULL, address VARCHAR(255) NOT NULL, " +
                    "phone INT NOT NULL, reg_date DATE NOT NULL, doctor VARCHAR(255) NOT NULL)";
            Statement statement = connection.createStatement();
            statement.execute(createTable);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
