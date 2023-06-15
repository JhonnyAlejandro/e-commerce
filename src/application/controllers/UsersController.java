package application.controllers;

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
