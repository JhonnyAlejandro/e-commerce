/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import application.models.ProviderModel;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

public class QueriesProvider {
    
     DatabaseConnection consulta = new DatabaseConnection();
    
    public ArrayList<ProviderModel> listaProvider = new ArrayList();
    
    public ArrayList<ProviderModel> consulta(){
        String sql = "SELECT id, first_name, Last_name, address, city, department, phone, email, created_at \n" +
            "FROM providers where state = 1";
        ResultSet result = consulta.consult(sql);
        try 
        {
           
            
            while (result.next()) 
            {
                ProviderModel mdlProvider = new ProviderModel();
                mdlProvider.setId(result.getInt("id"));
                mdlProvider.setFirstName(result.getString("first_name"));
                mdlProvider.setLastName(result.getString("Last_name"));
                mdlProvider.setAddress(result.getString("address"));
                mdlProvider.setCity(result.getString("city"));
                mdlProvider.setDepartment(result.getString("department"));
                mdlProvider.setPhone(result.getString("phone"));
                mdlProvider.setEmail(result.getString("email"));
                listaProvider.add(mdlProvider);
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return listaProvider;
    }
    
   
    public boolean registrar(ProviderModel provider) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        boolean registrar = false;
        String sql = "INSERT INTO providers (first_name, last_name, address, city, department, phone, email, state, created_at, updated_at) "
                + "VALUES ('" + provider.getFirstName() + "', '" + provider.getLastName() + "', '" + provider.getAddress() + "', '"
                + provider.getCity() + "', '" + provider.getDepartment() + "', '" + provider.getPhone() + "', '" + provider.getEmail()
                + "', '" + 1 + "', '" + timestamp + "', '" + timestamp + "')";

        try {
            if (databaseConnection.execute(sql)) {
                registrar = true;
            }
        } catch (Exception e) {
            System.err.println("Failed to register user: " + e);
        } finally {
            databaseConnection.disconnect();
        }
        return registrar;
    }

    public boolean modificar(ProviderModel provider) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        boolean successModificar = false;

        try {
            String selectSql = "UPDATE providers SET "
                    + "first_name = '" + provider.getFirstName() + "', "
                    + "last_name = '" + provider.getLastName() + "', "
                    + "address = '" + provider.getAddress() + "', "
                    + "city = '" + provider.getCity() + "', "
                    + "department = '" + provider.getDepartment() + "', "
                    + "phone = '" + provider.getPhone() + "', "
                    + "email = '" + provider.getEmail() + "', "
                    + "created_at = '" + timestamp + "' "
                    + "WHERE id = " + provider.getId();

            if (databaseConnection.execute(selectSql)) {
                successModificar = true;
            }
        } catch (Exception e) {
            System.err.println("Failed to update provider: " + e);
        } finally {
            try {
                databaseConnection.disconnect();
            } catch (Exception e) {
                System.err.println("");
            }
        }

        return successModificar;
    }

    public boolean eliminar(ProviderModel  provider) {
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
    ProviderModel provider= null;

    try {
        String selectSql = "SELECT * FROM providers WHERE id = " + id;
        ResultSet resultSet = databaseConnection.consult(selectSql);

        if (resultSet.next()) {
            provider = new ProviderModel();
            provider.setId(resultSet.getInt("id"));
            provider.setFirstName(resultSet.getString("first_name"));
            provider.setLastName(resultSet.getString("last_name"));
            provider.setAddress(resultSet.getString("address"));
            provider.setCity(resultSet.getString("city"));
            provider.setDepartment(resultSet.getString("department"));
            provider.setPhone(resultSet.getString("phone"));
            provider.setEmail(resultSet.getString("email"));
            
            
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

        String sql = "SELECT * FROM providers WHERE providers.state = 1 AND providers.created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getString("city"));
                provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
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
        String sql = "SELECT * FROM providers WHERE state = 1 AND DATE(providers.created_at) >=  DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getString("city"));
                provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
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
        String sql = "SELECT * FROM providers WHERE state = 1  AND DATE(created_at) >=  DATE_SUB(CURDATE(), INTERVAL 6 MONTH)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getString("city"));
                provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
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
        String sql = "SELECT * FROM providers WHERE state = 1 AND DATE(created_at) >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getString("city"));
                provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
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
        String sql = "SELECT * FROM providers WHERE state = 1 AND created_at <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getString("city"));
                provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
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

        String sql = "SELECT * FROM providers WHERE state = 1 AND created_at >= DATE_SUB(NOW(), INTERVAL 1 DAY)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                ProviderModel provider = new ProviderModel();
                provider.setId(result.getInt("id"));
                provider.setFirstName(result.getString("first_name"));
                provider.setLastName(result.getString("last_name"));
                provider.setAddress(result.getString("address"));
                provider.setCity(result.getString("city"));
                provider.setDepartment(result.getString("department"));
                provider.setEmail(result.getString("email"));
                provider.setPhone(result.getString("phone"));
                providerList.add(provider);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return providerList;
    }
}
