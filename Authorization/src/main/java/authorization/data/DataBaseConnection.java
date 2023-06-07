package authorization.data;

import authorization.utils.Logger;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String CONNECTION_ERROR = "Can not connect with database";
    private static final String URL_PATH = "dataBaseUrl";
    private static final String PASSWORD_PATH = "dataBasePassword";
    private static final String USER_PATH = "dataBaseUser";
    
    private static Connection connection;

    public static Connection connect() throws FileNotFoundException {
        if (connection == null){
            /*JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/DataBaseSettings.json"));
            JsonObject settings = (JsonObject) obj;
            String url = settings.get(URL_PATH).toString();
            String user = settings.get(USER_PATH).toString();;
            String password = settings.get(PASSWORD_PATH).toString();;*/
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
