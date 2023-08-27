/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import application.models.CityModel;
import application.models.DepartmentModel;
import application.models.ProviderModel;

import configuration.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

public class QueriesProvider {

    DatabaseConnection consulta = new DatabaseConnection();

    public ArrayList<ProviderModel> consulta() {
        ArrayList<ProviderModel> listaProvider = new ArrayList<>();

        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name , cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1";

        ResultSet result = consulta.consult(sql);

        try {
            while (result.next()) {

                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel mdlProvider = new ProviderModel();
                mdlProvider.setId(result.getInt("id"));
                mdlProvider.setFirstName(result.getString("first_name"));
                mdlProvider.setLastName(result.getString("Last_name"));
                mdlProvider.setAddress(result.getString("address"));
                mdlProvider.setCity(result.getInt("city"));
                mdlProvider.setPhone(result.getString("phone"));
                mdlProvider.setEmail(result.getString("email"));
                mdlProvider.setCityModel(city);
                listaProvider.add(mdlProvider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.disconnect();
        }

        return listaProvider;
    }

//    public boolean registrar(ProviderModel provider) {
//        System.out.println("Si llegie a registrar");
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//        boolean registrar = false;
//         String sql = "INSERT INTO users (first_name, last_name, address, city, phone, email, password, state, created_at, updated_at) "
//                + "VALUES ('" + provider.getFirstName() + "', '" + provider.getLastName() + "', '" + provider.getAddress() + "', '"
//                + provider.getCity() + "', '" + provider.getPhone() + "', '" + provider.getEmail()
//                + "', '" + "', " + 1 + ", '" + timestamp + "', '" + timestamp + "')";
//
//        try {
//            if (databaseConnection.execute(sql)) {
//                registrar = true;
//            }
//        } catch (Exception e) {
//            System.err.println("Failed to register user: " + e);
//        } finally {
//            databaseConnection.disconnect();
//        }
//        return registrar;
//    }
    public boolean registrar(ProviderModel provider) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        boolean registrar = false;
        String sql = "INSERT INTO providers (first_name, last_name, address, city, phone, email, state, created_at, updated_at) "
                + "VALUES ('" + provider.getFirstName() + "', '" + provider.getLastName() + "', '" + provider.getAddress() + "', '"
                + provider.getCity() + "', '" + provider.getPhone() + "', '" + provider.getEmail()
                + "', " + 1 + ", '" + timestamp + "', '" + timestamp + "')";

        try {
            if (databaseConnection.execute(sql)) {
                registrar = true;
            }
        } catch (Exception e) {
            System.err.println("Error al registrar proveedor: " + e);
        } finally {
            databaseConnection.disconnect();
        }
        return registrar;
    }

    public boolean modificar(ProviderModel provider) {

        DatabaseConnection connection = new DatabaseConnection();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        boolean modify = false;
        String sql;

        sql = "UPDATE providers SET "
                + "providers.first_name = '" + provider.getFirstName() + "', "
                + "providers.last_name = '" + provider.getLastName() + "', "
                + "providers.address = '" + provider.getAddress() + "', "
                + "providers.city = '" + provider.getCity() + "', "
                + "providers.phone = '" + provider.getPhone() + "', "
                + "providers.email = '" + provider.getEmail() + "', "
                + "providers.updated_at = '" + timestamp + "' "
                + "WHERE providers.id = " + provider.getId();

        try {
            if (connection.execute(sql)) {

            }
        } catch (Exception e) {
            System.out.println("Error al modificar el proovedor" + e);
        } finally {
            connection.disconnect();
        }

        return modify;

    }

    public boolean eliminar(ProviderModel provider) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        boolean successOperacion = false;

        try {
            String sql = "UPDATE providers SET " + "state = '" + provider.getState() + "' " + "WHERE id = " + provider.getId();

            if (databaseConnection.execute(sql)) {
                successOperacion = true;
            }
        } catch (Exception e) {
            System.err.println("Failed to delete provider: " + e);
        } finally {
            try {
                databaseConnection.disconnect();
            } catch (Exception e) {
                System.err.println("");
            }
        }

        return successOperacion;
    }

    public ProviderModel buscar(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ProviderModel provider = null;

        try {
            String selectSql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, departments.id AS department_id, departments.name AS department_name, cities.state AS city_state , departments.id AS department_id, departments.name AS department_name FROM providers "
                    + "INNER JOIN cities ON providers.city = cities.id "
                    + "INNER JOIN departments ON cities.department = departments.id "
                    + "WHERE providers.state = 1 AND providers.id = " + id;
            ResultSet resultSet = databaseConnection.consult(selectSql);

            if (resultSet.next()) {
                CityModel city = new CityModel();
                city.setIdCity(resultSet.getInt("id"));
                city.setNameCity(resultSet.getString("city_name"));
                city.setNameDepartment(resultSet.getString("department_name"));
                city.setDepartmentId(resultSet.getInt("department_id"));
                provider = new ProviderModel();
                provider.setId(resultSet.getInt("id"));
                provider.setFirstName(resultSet.getString("first_name"));
                provider.setLastName(resultSet.getString("last_name"));
                provider.setAddress(resultSet.getString("address"));
                provider.setCity(resultSet.getInt("city"));

                provider.setPhone(resultSet.getString("phone"));
                provider.setEmail(resultSet.getString("email"));
                provider.setCityModel(city);

            }
        } catch (SQLException e) {
            System.err.println("Failed to get provider by id: " + e);
        } finally {
            try {
                databaseConnection.disconnect();
            } catch (Exception e) {
                System.err.println("");
            }
        }

        return provider;
    }

    public ArrayList<ProviderModel> consultProviderLastWeek() {
        ArrayList<ProviderModel> providerList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();

//String sql = "SELECT * FROM providers WHERE providers.state = 1 AND providers.created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)";
        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1 AND providers.created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCityModel(city);
                providerList.add(provider);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }

    public ArrayList<ProviderModel> consultProviderLastMonth() {
        ArrayList<ProviderModel> providerList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        //String sql = "SELECT * FROM providers WHERE state = 1 AND DATE(providers.created_at) >=  DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";
        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1 AND DATE(providers.created_at) >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getInt("city"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCityModel(city);
                providerList.add(provider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }

    public ArrayList<ProviderModel> consultProviderLast6Months() {
        ArrayList<ProviderModel> providerList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        //String sql = "SELECT * FROM providers WHERE state = 1  AND DATE(created_at) >=  DATE_SUB(CURDATE(), INTERVAL 6 MONTH)";
        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1 AND DATE(providers.created_at) >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                   city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getInt("city"));
                //provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCityModel(city);
                providerList.add(provider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }

    public ArrayList<ProviderModel> consultProviderLastYear() {
        ArrayList<ProviderModel> providerList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        //String sql = "SELECT * FROM providers WHERE state = 1 AND DATE(created_at) >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";
        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1 AND DATE(providers.created_at) >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getInt("city"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCityModel(city);
                providerList.add(provider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }

    public ArrayList<ProviderModel> consultProviderMoreThanYear() {
        ArrayList<ProviderModel> providerList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        //String sql = "SELECT * FROM providers WHERE state = 1 AND created_at <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";
        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1 AND DATE(providers.created_at) >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getInt("city"));
                //provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCityModel(city);
                providerList.add(provider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }

    public ArrayList<ProviderModel> consultProvidersOneDay() {
        ArrayList<ProviderModel> providerList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
       
        //String sql = "SELECT * FROM providers WHERE state = 1 AND created_at >= DATE_SUB(NOW(), INTERVAL 1 DAY)";
        String sql = "SELECT providers.*, cities.id AS city_id, cities.name AS city_name, cities.state AS city_state, departments.id AS department_id, departments.name AS department_name "
                + "FROM providers "
                + "INNER JOIN cities ON providers.city = cities.id "
                + "INNER JOIN departments ON cities.department = departments.id "
                + "WHERE providers.state = 1 AND providers.created_at >= DATE_SUB(NOW(), INTERVAL 1 DAY)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                CityModel city = new CityModel();
                city.setIdCity(result.getInt("city_id"));
                city.setNameCity(result.getString("city_name"));
                city.setDepartmentId(result.getInt("department_id"));
                city.setNameDepartment(result.getString("department_name"));
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getInt("city"));

                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                provider.setCityModel(city);
                providerList.add(provider);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }

    public ArrayList<DepartmentModel> consultDeparment() {
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

    public ArrayList<CityModel> consultCitiesByDepartment(int departmentId) {
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

    public boolean showifmailexists(String email) {

        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT email FROM users WHERE email = '"
                + email + "'";

        ResultSet result;
        boolean show = false;
        try {
            result = connection.consult(sql);
            while (result.next()) {
                show = true;
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar el correo: " + e);
        }
        connection.disconnect();
        return show;
    }

}
