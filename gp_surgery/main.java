package gp_surgery;
import java.sql.*;

public class main {

    public static void main(String[] args) throws SQLException {
        dbCommands.connectToDb();
        dbCommands.createDB();
        dbCommands.addData();
        dbCommands.retrieveData();
        new clientGUI();
    }

}