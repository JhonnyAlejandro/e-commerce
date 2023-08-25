package database;

import application.models.UsersModel;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import utilities.Session;

public class QueriesProfile
{
    public UsersModel getUser() {
        DatabaseConnection connect = new DatabaseConnection();
        UsersModel model = new UsersModel();
        String sql = "SELECT first_name, last_name, phone, email, department, city, address FROM users WHERE email = '" + Session.userModel.getEmail()+ "'";
        ResultSet result;
        try {
            result = connect.consult(sql);
            if (result.next()) {
                model.setFirstName(result.getString("first_name"));
                model.setLastName(result.getString("last_name"));
                model.setPhone(result.getString("phone"));
                model.setEmail(result.getString("email"));
                model.setCity(result.getInt("city"));
                model.setAddress(result.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return model;
    }
    
    public boolean updatePersonal(UsersModel model) {
        boolean band = false;
        DatabaseConnection connect = new DatabaseConnection();
        String sql = "UPDATE users SET "
            + "first_name = '" + model.getFirstName() + "', "
            + "last_name = '" + model.getLastName() + "', "
            + "phone = '" + model.getPhone() + "', "
            + "email = '" + model.getEmail() + "' "
            + "WHERE email = '" + Session.userModel.getEmail() + "'";
        try {
            if (connect.execute(sql)) {
                band = true;
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return band;
    }
    
    public boolean updateAddress(UsersModel model) {
        boolean band = false;
        DatabaseConnection connect = new DatabaseConnection();
        String sql = "UPDATE users SET "
            + "city = '" + model.getCity() + "', "
            + "address = '" + model.getAddress() + "' "
            + "WHERE email = '" + Session.userModel.getEmail() + "'";
        try {
            if (connect.execute(sql)) {
                band = true;
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return band;
    }
    
}