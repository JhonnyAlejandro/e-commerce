package database;

import application.models.RolesModel;
import application.models.UsersModel;
import application.models.UsersModel;
import configuration.Configuration;
import configuration.DatabaseConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.mindrot.jbcrypt.BCrypt;

public class QueriesUsers {

    public boolean success;

    public UsersModel search(int id) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        UsersModel users = null;

        try {
            String selectSql = "SELECT * FROM users WHERE id = " + id;
            ResultSet result = databaseConnection.consult(selectSql);

            if (result.next()) {
                users = new UsersModel();
                users.setIdUsers(result.getInt("id"));
                users.setFirstName(result.getString("first_name"));
                users.setLastName(result.getString("last_name"));
                users.setAddress(result.getString("address"));
                users.setCity(result.getString("city"));
                users.setDepartment(result.getString("department"));
                users.setEmail(result.getString("email"));
                users.setPhone(result.getString("phone"));
                users.setRol(result.getInt("roles_id"));
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

        return users;
    }

    public boolean insertUser(UsersModel user) {

        DatabaseConnection connection = new DatabaseConnection();
        System.out.println("bandera 1");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String pass = String.valueOf(user.getPassword());

        String pwHash = BCrypt.hashpw(pass, BCrypt.gensalt());

        String sql = "INSERT INTO users (first_name, last_name, address, city, department, phone, email,password, state, created_at, updated_at,roles_id) "
                + "VALUES ('" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getAddress() + "', '"
                + user.getCity() + "', '" + user.getDepartment() + "', '" + user.getPhone() + "', '" + user.getEmail()
                + "', '" + pwHash + "','" + 1 + "','" + timestamp + "','" + timestamp + "','" + user.getRol() + "')";

        boolean insert = false;

        try {

            if (connection.execute(sql)) {
                insert = true;
                System.out.println("bandera 2");
            }
        } catch (Exception e) {
            System.err.println("Error al insertar el registro (UsersController): " + e);
        } finally {
            connection.disconnect();
        }

        return insert;
    }

    public boolean updateUser(UsersModel user) {

        DatabaseConnection connection = new DatabaseConnection();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        boolean modify = false;

        String sql;

        if (user.getPassword() == null) {

            sql = "UPDATE users SET "
                    + "first_name = '" + user.getFirstName() + "', "
                    + "last_name = '" + user.getLastName() + "', "
                    + "address = '" + user.getAddress() + "', "
                    + "city = '" + user.getCity() + "', "
                    + "department = '" + user.getDepartment() + "', "
                    + "phone = '" + user.getPhone() + "', "
                    + "email = '" + user.getEmail() + "', "
                    + "updated_at = '" + timestamp + "', "
                    + "roles_id = '" + user.getRol() + "' "
                    + "WHERE id = " + user.getIdUsers();
            System.out.println("hola bb");

        } else {
            String pass = String.valueOf(user.getPassword());
            String pwHash = BCrypt.hashpw(pass, BCrypt.gensalt());

            sql = "UPDATE users SET "
                    + "first_name = '" + user.getFirstName() + "', "
                    + "last_name = '" + user.getLastName() + "', "
                    + "address = '" + user.getAddress() + "', "
                    + "city = '" + user.getCity() + "', "
                    + "department = '" + user.getDepartment() + "', "
                    + "phone = '" + user.getPhone() + "', "
                    + "password = '" + pwHash + "', "
                    + "email = '" + user.getEmail() + "', "
                    + " updated_at = '" + timestamp + "', "
                    + " roles_id = '" + user.getRol() + "' "
                    + "WHERE id = " + user.getIdUsers();

            System.out.println("adios bb");
        }

        try {

            if (connection.execute(sql)) {
                modify = true;
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el registro (UsersController): " + e);
        }

        connection.disconnect();
        return modify;
    }

    public boolean deleteUser(UsersModel user) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        boolean successOperacion = false;

        try {
            String sql = "UPDATE users SET " + "state = '" + user.getState()
                    + "' ," + " updated_at = '" + timestamp + "' " + "WHERE id = " + user.getIdUsers();

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

    public ArrayList<UsersModel> consultUsers() {
        ArrayList<UsersModel> usersList = new ArrayList();
        RolesModel roles = new RolesModel();
        DatabaseConnection connection = new DatabaseConnection();
        //String sql1 = "SELECT * FROM users WHERE state = 1";
        String sql = "SELECT users.*, roles.name FROM users INNER JOIN roles ON users.roles_id = roles.id WHERE users.state = 1";

        ResultSet result;
        result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                user.setRol(result.getInt("roles_id"));
                user.setNameRol(result.getString("name"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

    public ArrayList<UsersModel> consultUsersLastWeek() {
        ArrayList<UsersModel> usersList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();

        String sql = "SELECT users.*, roles.name, users.created_at AS user_created_at FROM users INNER JOIN roles ON users.roles_id = roles.id WHERE users.state = 1 AND users.created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                user.setRol(result.getInt("roles_id"));
                user.setNameRol(result.getString("name"));
                usersList.add(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

    public ArrayList<UsersModel> consultUsersLastMonth() {
        ArrayList<UsersModel> usersList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT users.*, roles.name, users.created_at AS user_created_at FROM users INNER JOIN roles ON users.roles_id = roles.id WHERE users.state = 1 AND DATE(users.created_at) >=  DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                user.setRol(result.getInt("roles_id"));
                user.setNameRol(result.getString("name"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

    public ArrayList<UsersModel> consultUsersLast6Months() {
        ArrayList<UsersModel> usersList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT users.*, roles.name, users.created_at AS user_created_at FROM users INNER JOIN roles ON users.roles_id = roles.id WHERE users.state = 1  AND DATE(users.created_at) >=  DATE_SUB(CURDATE(), INTERVAL 6 MONTH)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                user.setRol(result.getInt("roles_id"));
                user.setNameRol(result.getString("name"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

    public ArrayList<UsersModel> consultUsersLastYear() {
        ArrayList<UsersModel> usersList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT users.*, roles.name, users.created_at AS user_created_at FROM users INNER JOIN roles ON users.roles_id = roles.id WHERE users.state = 1  AND DATE(users.created_at) >=  DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";
        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                user.setRol(result.getInt("roles_id"));
                user.setNameRol(result.getString("name"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

    public ArrayList<UsersModel> consultUsersMoreThanYear() {
        ArrayList<UsersModel> usersList = new ArrayList<>();

        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT users.*, roles.name, users.created_at AS user_created_at FROM users INNER JOIN roles ON users.roles_id = roles.id WHERE users.state = 1   AND users.created_at <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";

        ResultSet result = connection.consult(sql);
        try {
            while (result.next()) {
                UsersModel user = new UsersModel();
                user.setIdUsers(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setAddress(result.getString("address"));
                user.setCity(result.getString("city"));
                user.setDepartment(result.getString("department"));
                user.setEmail(result.getString("email"));
                user.setPhone(result.getString("phone"));
                user.setRol(result.getInt("roles_id"));
                user.setNameRol(result.getString("name"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return usersList;
    }

    public ArrayList<RolesModel> consultRoles() {
        ArrayList<RolesModel> rolesList = new ArrayList();
        DatabaseConnection connection = new DatabaseConnection();
        String sql = "SELECT * FROM roles";
        ResultSet result;
        result = connection.consult(sql);
        try {
            while (result.next()) {
                RolesModel roles = new RolesModel();
                roles.setIdRoles(result.getInt("id"));
                roles.setNameRol(result.getString("name"));
                rolesList.add(roles);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return rolesList;
    }
}
