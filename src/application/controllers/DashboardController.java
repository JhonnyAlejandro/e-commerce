package application.controllers;

import application.views.DashboardView;
import application.views.HomeView;
import application.views.ProfileView;
import application.views.ProvidersView;
import application.views.UsersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import utilities.ManipulateText;
import utilities.PerformActions;
import utilities.Session;
import java.io.File;

public class DashboardController {

    DashboardView view = new DashboardView();
    HomeView home = new HomeView();
    ManipulateText manipulateText = new ManipulateText();
    PerformActions performActions = new PerformActions();

    private JButton originalButton;

    public DashboardController() {
        view.jLabel2.setText("Hola " + manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName()));
        
        String text = manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName());
        view.jButton3.setText(text);
        
        if (text.length() > 12) {
            view.jButton3.setText(text.substring(0, 12) + "...");
        }
        
        start();
        events();
    }

    private void start() {
        performActions.changePanel(view.jPanel3, home);

        view.setVisible(true);
    }

    private void changeButtonColor(JButton buttonPressed, String button) {
        if (originalButton != null) {
            originalButton.putClientProperty("FlatLaf.style",
                    "foreground: #646675;"
                    + "background: #FFF;"
                    + "hoverBackground: darken(#FFF,5%);"
            );
            originalButton.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/" + originalButton.getClientProperty("icon") + "-b8c0cb.png")));
        }

        buttonPressed.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
        );
        buttonPressed.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/" + button + "-fff.png")));

        originalButton = buttonPressed;
    }

    private void events() {

        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                UsersView users = new UsersView();

                view.jButton1.putClientProperty("icon", "users");

                view.jLabel3.setText("Usuarios");

                performActions.changePanel(view.jPanel3, users);

                changeButtonColor(view.jButton1, "users");

                new UsersController(users);
            }
        });

        view.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ProvidersView providers = new ProvidersView();

                view.jButton2.putClientProperty("icon", "providers");

                view.jLabel3.setText("Proveedores");

                performActions.changePanel(view.jPanel3, providers);

                changeButtonColor(view.jButton2, "providers");

                new ProvidersController(providers);
            }
        });
        
        view.btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                view.btnHelp.putClientProperty("icon", "help");

                changeButtonColor(view.btnHelp, "help");
                
                File chmFile = new File("src/utilities/Help-workshop.chm");
                
                try {
                    if (chmFile.exists()) {
                        Process process = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + chmFile.getAbsolutePath());
                        process.waitFor();
                    } else {
                        System.out.println("No se encontró el taller de ayuda");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        view.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProfileView profile = new ProfileView();
                new ProfileController(view, profile);

                view.jButton3.putClientProperty("icon", "profile");

                view.jLabel3.setText("Perfil");

                performActions.changePanel(view.jPanel3, profile);

                changeButtonColor(view.jButton3, "profile");
            }
        });
    }

}
