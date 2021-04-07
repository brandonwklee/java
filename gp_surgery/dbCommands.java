package gp_surgery;
import java.sql.*;

public class dbCommands {
    private static Connection connection;
    private static Statement statement;
    private static doctor doc;

    public static void connectToDb() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Pach1r1su";
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (
                SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public static void addData() throws SQLException {
        String staffQuery = "INSERT INTO staff_information VALUES (1, 'nurse', 'peepee', 'god', 35, 'dfsfsdfs', 34345, 1)";
        String patientQuery = "INSERT INTO patient_information VALUES (1, 'mr', 'brandon', 'lee', 24, '58 wakehurst road eastbourne', 45345345, 'peepee')";
        statement = connection.createStatement();
        statement.executeUpdate(staffQuery);
        statement.executeUpdate(patientQuery);
    }

    public static void retrieveData() throws SQLException {
        String getResults = "SELECT * FROM staff_information";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(getResults);
        while (rs.next()) {
            doc = new doctor(1, rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getInt(5), rs.getString(6), rs.getInt(7));
        }
        System.out.println(doc);
    }

    public static void createDB() throws SQLException {
        String createDatabase = "CREATE DATABASE IF NOT EXISTS gp_surgery";
        String useDatabase = "USE gp_surgery";
        String createStaffInformation =
                "CREATE TABLE IF NOT EXISTS staff_information (" +
                        "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                        "Title VARCHAR(255) NOT NULL, " +
                        "Forename VARCHAR(255) NOT NULL, " +
                        "Surname VARCHAR(255) NOT NULL," +
                        "Age INT NOT NULL, " +
                        "Address VARCHAR(255) NOT NULL, " +
                        "Phone_Number INT NOT NULL, " +
                        "Number_of_Patients INT NOT NULL)";

        String createPatientTable =
                "CREATE TABLE IF NOT EXISTS patient_information (" +
                        "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                        "Title VARCHAR(255) NOT NULL, " +
                        "Forename VARCHAR(255) NOT NULL, " +
                        "Surname VARCHAR(255) NOT NULL," +
                        "Age INT NOT NULL, " +
                        "Address VARCHAR(255) NOT NULL," +
                        "Phone_Number INT NOT NULL, " +
                        "Registered_Doctor_or_Nurse_id VARCHAR(255) NOT NULL)";
                        //"FOREIGN KEY (Registered_Doctor_or_Nurse_id) REFERENCES staff_information(id))";

        statement = connection.createStatement();
        statement.executeUpdate(createDatabase);
        statement.execute(useDatabase);
        statement.execute(createStaffInformation);
        statement.execute(createPatientTable);
    }
}