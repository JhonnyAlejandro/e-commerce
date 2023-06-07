package database;

import application.models.UsersModel;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import utilities.Session;

public class Queries {

    public boolean authentication(UsersModel user) {
        ResultSet result;
        DatabaseConnection databaseConnection = new DatabaseConnection();

        String sql = "SELECT * FROM users WHERE email = '" + user.getEmail() + "' AND password = '" + String.valueOf(user.getPassword()) + "'";
        boolean authentication = false;

        try {
            result = databaseConnection.consult(sql);
            if (result.next()) {
                authentication = true;

                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));

                new Session(user);
            } else {
            }
        } catch (Exception exception) {
            System.out.println("Error in the comparison: " + exception);
        }

        databaseConnection.disconnect();

        return authentication;
    }

}
