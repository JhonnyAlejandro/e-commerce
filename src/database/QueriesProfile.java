package database;

import application.models.UsersModel;
import application.models.CityModel;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.Session;

public class QueriesProfile
{
    public UsersModel getUser() {
        DatabaseConnection connect = new DatabaseConnection();
        UsersModel model = new UsersModel();
        CityModel cityModel = new CityModel();
        String sql = "SELECT first_name, last_name, phone, email, cities.name city, cities.id idCity, address\n" +
                "FROM users\n" +
                "INNER JOIN cities\n" +
                "ON cities.id = users.city\n" +
                "WHERE email = '" + Session.userModel.getEmail() + "'";
        ResultSet result;
        try {
            result = connect.consult(sql);
            if (result.next()) {
                model.setFirstName(result.getString("first_name"));
                model.setLastName(result.getString("last_name"));
                model.setPhone(result.getString("phone"));
                model.setEmail(result.getString("email"));
                model.setCity(result.getInt("idCity"));
                cityModel.setIdCity(result.getInt("idCity"));
                cityModel.setNameCity(result.getString("city"));
                model.setCityModel(cityModel);
                model.setAddress(result.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return model;
    }
    
    public String[] getCities(int department) {
        String[] cities = new String[0];
        DatabaseConnection connect = new DatabaseConnection();
        String sql = "SELECT cities.name AS city,\n" +
                "(SELECT COUNT(*)\n" +
                "FROM cities\n" +
                "WHERE department = " + department + "\n" +
                "AND cities.state = 1) AS valor\n" +
                "FROM cities\n" +
                "WHERE department = " + department + " \n" +
                "AND state = 1;";
        ResultSet result;
        try {
            result = connect.consult(sql);
            int i = 0;
            while (result.next()) {
                if (i == 0) {
                    cities = new String[result.getInt("valor") + 1];
                    cities[i] = "Seleccione una ciudad";
                }
                cities[i + 1] = (result.getString("city"));
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return cities;
    }
    
    public ArrayList getDeparments() {
        ArrayList department = new ArrayList();
        DatabaseConnection connect = new DatabaseConnection();
        String sql = "SELECT departments.name deparment\n" +
                "FROM departments\n " +
                "ORDER by deparment\n" +
                "ASC";
        ResultSet result;
        try {
            result = connect.consult(sql);
            while (result.next()) {
                department.add(result.getString("deparment"));
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return department;
    }
    
    public String getDeparmentUser() {
        String department = "";
        DatabaseConnection connect = new DatabaseConnection();
        String sql = "SELECT departments.name AS department\n" +
                "FROM departments\n" +
                "INNER JOIN cities\n" +
                "ON cities.department = departments.id\n" +
                "INNER JOIN users\n" +
                "ON users.city = cities.id\n" +
                "WHERE email = '" + Session.userModel.getEmail() + "'";
        ResultSet result;
        try {
            result = connect.consult(sql);
            while (result.next()) {
                department = (result.getString("department"));
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return department;
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
        String sql = "UPDATE users\n" +
                "SET city = (SELECT cities.id\n" +
                "FROM cities\n" +
                "WHERE cities.name = '" + model.getCityModel().getNameCity()+ "'),\n" +
                "address = '" + model.getAddress() + "' " +
                "WHERE email = '" + Session.userModel.getEmail() + "'";
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