package application.controllers;

import application.models.UsersModel;
import application.views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import application.views.ProfileView;
import application.views.DashboardView;

public class ProfileController {

    ProfileView view;
    DashboardView viewDash;
    LoginView viewLogin = new LoginView();
    UsersModel modelUsers = new UsersModel();

    public ProfileController(DashboardView viewDash,ProfileView view) {
        this.view = view;
        this.viewDash = viewDash;
        events();
    }

    public void events() {

        view.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences prefs = Preferences.userNodeForPackage(LoginController.class);
                prefs.remove("rememberPassword");
                prefs.remove("email");
                prefs.remove("password");
                System.out.println(".actionPerformed()");
                viewDash.dispose();
                new LoginController(modelUsers, viewLogin);

            }
        });

    }

}
