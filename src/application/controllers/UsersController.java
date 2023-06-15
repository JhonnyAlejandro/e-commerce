package application.controllers;

import application.models.UsersModel;
import application.views.UsersFormView;
import application.views.UsersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.PerformActions;
import database.QueriesUsers;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class UsersController {

    UsersView view;
    QueriesUsers queries = new QueriesUsers();
    PerformActions performActions = new PerformActions();

    public UsersController(UsersView view) {
        this.view = view;

        events();
        loadTable();
        filterListener();
    }

    private void filterListener() {
        view.cbmFilters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilter(); // Método para aplicar el filtro
            }
        });
    }

    private void applyFilter() {
        String filterOption = (String) view.cbmFilters.getSelectedItem();
        ArrayList<UsersModel> filteredUsersList = null;

        switch (filterOption) {
            case "Todos":
                filteredUsersList = queries.consultUsers();
                break;
            case "Ultima semana":
                filteredUsersList = queries.consultUsersLastWeek();
                break;
            case "Ultimo mes":
                filteredUsersList = queries.consultUsersLastMonth();
                break;
            case "Ultimos 6 meses":
                filteredUsersList = queries.consultUsersLast6Months();
                break;
            case "Ultimo año":
                filteredUsersList = queries.consultUsersLastYear();
                break;
            case "Más de un año":
                filteredUsersList = queries.consultUsersMoreThanYear();
                break;
            default:
                filteredUsersList = new ArrayList<UsersModel>();
                break;
        }

        updateTable(filteredUsersList);
    }

    private void updateTable(ArrayList<UsersModel> usersList) {
        DefaultTableModel model = (DefaultTableModel) view.tblUsers.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (UsersModel user : usersList) {
            Object[] row = new Object[8];
            // Rellenar los datos del usuario en la fila
            row[0] = user.getIdUsers();
            row[1] = user.getFirstName();
            row[2] = user.getLastName();
            row[3] = user.getDepartment();
            row[4] = user.getCity();
            row[5] = user.getAddress();
            row[6] = user.getEmail();
            row[7] = user.getPhone();

            model.addRow(row); // Agregar la fila a la tabla
        }
    }

    public void loadTable() {

        DefaultTableModel model = (DefaultTableModel) view.tblUsers.getModel();
        model.getDataVector().removeAllElements();
        ArrayList<UsersModel> usersList = new ArrayList<UsersModel>();
        usersList = queries.consultUsers();
        System.out.println("bandera 20");

        for (UsersModel user : usersList) {
            Object[] row = new Object[9];

            row[0] = user.getIdUsers();
            row[1] = user.getFirstName();
            row[2] = user.getLastName();
            row[3] = user.getDepartment();
            row[4] = user.getCity();
            row[5] = user.getAddress();
            row[6] = user.getEmail();
            row[7] = user.getPhone();
            row[8] = user.getNameRol();
            System.out.println("bandera 21");
            //Falta una linea de codigo mas
            //view.tblUsers.setModel(model);
            model.addRow(row);

        }
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                UsersFormView userForm = new UsersFormView();
                AddUserController usersController = new AddUserController(userForm);
                performActions.changePanel(view.jPanel1, userForm);
            }
        });
    }

}
