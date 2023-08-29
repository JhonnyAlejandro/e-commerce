package database;

import application.models.UsersModel;
import application.models.CityModel;
import application.models.DepartmentModel;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilities.Session;

public class QueriesProfile {

    public UsersModel getUser() {
        DatabaseConnection connect = new DatabaseConnection();
        UsersModel model = new UsersModel();
        CityModel city = new CityModel();

        String sql = "SELECT first_name, last_name, address , phone, email, city, cities.id AS city_id, cities.name AS  city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM users "
                + "INNER JOIN cities ON users.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE email = '" + Session.userModel.getEmail() + "'";
        ResultSet result;
        try {
            result = connect.consult(sql);
            if (result.next()) {
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setNameDepartment(result.getString("department_name"));
                city.setDepartmentId(result.getInt("department_id"));
                model.setFirstName(result.getString("first_name"));
                model.setLastName(result.getString("last_name"));
                model.setAddress(result.getString("address"));
                model.setCity(result.getInt("city"));
                model.setEmail(result.getString("email"));
                model.setPhone(result.getString("phone"));
                model.setCityModel(city);
            }
        } catch (Exception e) {
            System.out.println("Error in the comparison: " + e);
        }
        connect.disconnect();
        return model;
    }

//    public String[] getCities(int department) {
//        String[] cities = new String[0];
//        DatabaseConnection connect = new DatabaseConnection();
//        String sql = "SELECT cities.name AS city,\n" +
//                "(SELECT COUNT(*)\n" +
//                "FROM cities\n" +
//                "WHERE department = " + department + "\n" +
//                "AND cities.state = 1) AS valor\n" +
//                "FROM cities\n" +
//                "WHERE department = " + department + " \n" +
//                "AND state = 1;";
//        ResultSet result;
//        try {
//            result = connect.consult(sql);
//            int i = 0;
//            while (result.next()) {
//                if (i == 0) {
//                    cities = new String[result.getInt("valor") + 1];
//                    cities[i] = "Seleccione una ciudad";
//                }
//                cities[i + 1] = (result.getString("city"));
//                i++;
//            }
//        } catch (Exception e) {
//            System.out.println("Error in the comparison: " + e);
//        }
//        connect.disconnect();
//        return cities;
//    }
//    public ArrayList getDeparments() {
//        ArrayList department = new ArrayList();
//        DatabaseConnection connect = new DatabaseConnection();
//        String sql = "SELECT departments.name deparment\n" +
//                "FROM departments\n " +
//                "ORDER by deparment\n" +
//                "ASC";
//        ResultSet result;
//        try {
//            result = connect.consult(sql);
//            while (result.next()) {
//                department.add(result.getString("deparment"));
//            }
//        } catch (Exception e) {
//            System.out.println("Error in the comparison: " + e);
//        }
//        connect.disconnect();
//        return department;
//    }
//    public String getDeparmentUser() {
//        String department = "";
//        DatabaseConnection connect = new DatabaseConnection();
//        String sql = "SELECT departments.name AS department\n" +
//                "FROM departments\n" +
//                "INNER JOIN cities\n" +
//                "ON cities.department = departments.id\n" +
//                "INNER JOIN users\n" +
//                "ON users.city = cities.id\n" +
//                "WHERE email = '" + Session.userModel.getEmail() + "'";
//        ResultSet result;
//        try {
//            result = connect.consult(sql);
//            while (result.next()) {
//                department = (result.getString("department"));
//            }
//        } catch (Exception e) {
//            System.out.println("Error in the comparison: " + e);
//        }
//        connect.disconnect();
//        return department;
//    }
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
        String sql = "UPDATE users "
                + "SET address = '" + model.getAddress() + "', "
                + "city = '" + model.getCity() + "' "
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

    public ArrayList<DepartmentModel> getDeparments() {
        ArrayList<DepartmentModel> departmentList = new ArrayList();
        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT * FROM departments";
        ResultSet result;
        result = connection.consult(sql);
        try {
            while (result.next()) {
                DepartmentModel department = new DepartmentModel();
                department.setIdDepartment(result.getInt("id"));
                department.setNameDepartment(result.getString("name"));
                departmentList.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return departmentList;
    }

    public ArrayList<CityModel> getDeparmentUser(int departmentId) {
        ArrayList<CityModel> cityList = new ArrayList();
        DatabaseConnection connection = new DatabaseConnection();

        String sql = "SELECT * FROM cities WHERE department =' " + departmentId + "'";

        ResultSet result;
        result = connection.consult(sql);

        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("id"));
                city.setNameCity(result.getString("name"));
                city.setStateCity(result.getInt("state"));
                city.setDepartmentId(result.getInt("department")); // Assuming you have this setter in CityModel
                cityList.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.disconnect();
        return cityList;
    }
}
