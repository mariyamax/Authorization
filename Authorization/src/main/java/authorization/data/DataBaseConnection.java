package authorization.data;

import authorization.utils.Logger;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String CONNECTION_ERROR = "Can not connect with database";
    
    private static Connection connection;

    public static Connection connect() throws FileNotFoundException {
        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/authorization","root","Petroca9052");
            } catch (SQLException e) {
                Logger.error(CONNECTION_ERROR);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            Logger.error(e.getMessage());
        }
    }
}
