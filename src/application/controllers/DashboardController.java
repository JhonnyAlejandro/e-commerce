package application.controllers;

import application.views.CalendarView;
import application.views.DashboardView;
import application.views.HomeView;
import application.views.ProfileView;
import application.views.ProvidersView;
import application.views.UsersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import utilities.ManipulateText;
import utilities.PerformActions;
import utilities.Session;

public class DashboardController {

    DashboardView view = new DashboardView();
    HomeView home = new HomeView();
    ManipulateText manipulateText = new ManipulateText();
    PerformActions performActions = new PerformActions();

    private JButton originalButton;

    public DashboardController() {
        view.jLabel2.setText("Hola " + manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName()));
        view.jButton5.setText("<html>" + manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName()) + "<br><span style='font-size: 8px;'>Rol</span></html>");

        start();
        events();
    }

    private void start() {
        performActions.changePanel(view.jPanel3, home);

        view.setVisible(true);
    }

    private void changeButtonColor(JButton buttonPressed) {
        if (originalButton != null) {
            originalButton.putClientProperty("FlatLaf.style",
                    "foreground: #646675;"
                    + "background: #FFF;"
                    + "hoverBackground: darken(#FFF,5%);"
            );
        }

        buttonPressed.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
        );

        originalButton = buttonPressed;
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                view.jLabel3.setText("Bienvenido de nuevo");

                performActions.changePanel(view.jPanel3, home);

                changeButtonColor(view.jButton1);
            }
        });

        view.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                CalendarView calendar = new CalendarView();

                view.jLabel3.setText("Calendario");

                performActions.changePanel(view.jPanel3, calendar);

                changeButtonColor(view.jButton2);
            }
        });

        view.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                UsersView users = new UsersView();

                view.jLabel3.setText("Usuarios");

                performActions.changePanel(view.jPanel3, users);

                changeButtonColor(view.jButton3);

                new UsersController(users);
            }
        });

        view.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ProvidersView providers = new ProvidersView();

                view.jLabel3.setText("Proveedores");

                performActions.changePanel(view.jPanel3, providers);

                changeButtonColor(view.jButton4);

                new ProvidersController(providers);
            }
        });

        view.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProfileView profile = new ProfileView();
                new ProfileController(view, profile);

                view.jLabel3.setText("Perfil");

                performActions.changePanel(view.jPanel3, profile);
            }
        });
    }

}
