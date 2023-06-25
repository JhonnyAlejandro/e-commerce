package database;

import application.controllers.PasswordResetController;
import application.models.UsersModel;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;
import utilities.Session;
import application.views.LoginView;

public class Queries {

    public boolean authentication(UsersModel user, LoginView view) {
        ResultSet result;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        

        String pass = String.valueOf(user.getPassword());

        String sql = "SELECT * FROM users WHERE email = '" + user.getEmail() + "' AND state = '1'";

        boolean authentication = false;

        try {
            result = databaseConnection.consult(sql);
            if (result.next()) {

                if (BCrypt.checkpw(pass, result.getString("password"))) {
                    if (pass.length() == 4) {
                        user.setEmail(result.getString("email"));
                        new PasswordResetController(user);
                        view.dispose();

                    } else {
                        authentication = true;

                        user.setFirstName(result.getString("first_name"));
                        user.setLastName(result.getString("last_name"));
                        

                        new Session(user);
                    }
                }
            } else {
            }
        } catch (Exception exception) {
            System.out.println("Error in the comparison: " + exception);
        }

        databaseConnection.disconnect();

        return authentication;
    }

    public String getUser(UsersModel user) {
        DatabaseConnection connect = new DatabaseConnection();
        String sql = "SELECT * FROM users WHERE email = '" + user.getEmail() + "'";
        ResultSet result;
        String confirm = "";
        try {
            result = connect.consult(sql);
            if (result.next()) {
                confirm = result.getString("password");
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return confirm;
    }

    public boolean NewPass(UsersModel user) {
        
        String pass = String.valueOf(user.getPassword());

        String pwHash = BCrypt.hashpw(pass, BCrypt.gensalt());

        DatabaseConnection connect = new DatabaseConnection();
        String sql = "UPDATE users SET password = '" + pwHash + "' WHERE email = '" + user.getEmail() + "'";

        boolean confirm = false;
        try {
            if (connect.execute(sql)) {
                confirm = true;
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return confirm;
    }

}
