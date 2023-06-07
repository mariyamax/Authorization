package authorization.data;

import authorization.models.User;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import authorization.utils.Logger;

public class CustomUserRepo {

    public static User getByUserName(String userName) {
        try {
            PreparedStatement getByName = DataBaseConnection.connect().prepareStatement("select * from users where user_name like '?'");
            getByName.setString(1, userName);
            getByName.getResultSet();
        } catch (SQLException | FileNotFoundException e) {
            Logger.error(e.getMessage());
            return new User();
        }
        return new User();
    }

    public static boolean save(User user) {
        int updatedRows = 0;
        try {
            PreparedStatement save = DataBaseConnection.connect().prepareStatement("insert into users(user_name, password) values ('?','?')");
            save.setString(1, user.getUsername());
            save.setString(2, user.getPassword());
            updatedRows = save.executeUpdate();
        } catch (SQLException | FileNotFoundException e) {
            Logger.error(e.getMessage());
            return false;
        }
        return updatedRows != 0;
    }
}
