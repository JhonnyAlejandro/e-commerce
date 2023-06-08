package application.controllers;

import application.views.CalendarView;
import application.views.DashboardView;
import application.views.HomeView;
import application.views.ProfileView;
import application.views.ProvidersView;
import application.views.UsersView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import utilities.ManipulateText;
import utilities.Session;

public class DashboardController {

    DashboardView view = new DashboardView();
    ManipulateText manipulateText = new ManipulateText();

    public DashboardController() {
        view.jLabel2.setText("Hola " + manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName()));
        view.jButton5.setText("<html>" + manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName()) + "<br><span style='font-size: 8px;'>Rol</span></html>");

        start();
        events();
    }

    private void start() {
        view.setVisible(true);
    }

    private void changePanel(JPanel panel) {
        panel.setBounds(0, 0, 800, 600);

        view.jPanel3.removeAll();
        view.jPanel3.add(panel, BorderLayout.CENTER);
        view.jPanel3.revalidate();
        view.jPanel3.repaint();
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                HomeView home = new HomeView();

                view.jLabel3.setText("Bienvenido de nuevo");

                changePanel(home);
            }
        });

        view.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                CalendarView calendar = new CalendarView();

                view.jLabel3.setText("Calendario");

                changePanel(calendar);
            }
        });

        view.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                UsersView users = new UsersView();

                view.jLabel3.setText("Usuarios");

                changePanel(users);
            }
        });

        view.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ProvidersView providers = new ProvidersView();

                view.jLabel3.setText("Proveedores");

                changePanel(providers);
            }
        });

        view.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProfileView profile = new ProfileView();
                new ProfileController(view,profile);

                view.jLabel3.setText("Perfil");

                changePanel(profile);
            }
        });
    }

}
