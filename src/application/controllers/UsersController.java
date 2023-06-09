package application.controllers;

import application.views.UserFormView;
import application.views.UsersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.PerformActions;

public class UsersController {

    UsersView view;
    PerformActions performActions = new PerformActions();

    public UsersController(UsersView view) {
        this.view = view;

        events();
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                UserFormView userForm = new UserFormView();

                performActions.changePanel(view.jPanel1, userForm);
            }
        });
    }

}
