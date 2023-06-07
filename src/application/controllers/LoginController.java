package application.controllers;

import application.models.UsersModel;
import application.views.LoginView;
import database.Queries;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import utilities.Validations;

public class LoginController {

    UsersModel model;
    LoginView view;
    Validations validations = new Validations();
    Queries queries = new Queries();

    int failedAttempts = 4;

    public LoginController(UsersModel model, LoginView view) {
        this.model = model;
        this.view = view;

        start();
        events();
    }

    private void start() {
        view.setVisible(true);
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                boolean successfulEmailCredential = false;
                boolean successfulPasswordCredential = false;

                if (validations.validateEmptyField(view.jTextField1.getText())) {
                    view.jTextField1.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.jLabel4.setText("Ingresa tu dirección de correo electrónico*");
                    view.jLabel4.setVisible(true);
                } else {
                    if (validations.validateEmail(view.jTextField1.getText()) == false) {
                        view.jTextField1.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.jLabel4.setText("Ingresa una dirección de correo electrónico valida*");
                        view.jLabel4.setVisible(true);
                    } else {
                        view.jTextField1.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.jLabel4.setVisible(false);

                        model.setEmail(view.jTextField1.getText());

                        successfulEmailCredential = true;
                    }
                }

                if (validations.validateEmptyField(String.copyValueOf(view.jPasswordField1.getPassword()))) {
                    view.jPasswordField1.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.jLabel5.setText("Ingresa tu contraseña*");
                    view.jLabel5.setVisible(true);
                } else {
                    view.jPasswordField1.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.jLabel5.setVisible(false);

                    model.setPassword(view.jPasswordField1.getPassword());

                    successfulPasswordCredential = true;
                }

                if (successfulEmailCredential == true && successfulPasswordCredential == true) {
                    if (queries.authentication(model)) {
                        new DashboardController();

                        view.dispose();
                    } else {
                        failedAttempts--;

                        view.jLabel1.setText("La dirección de correo electrónico y/o la contraseña son incorrectas. Número de intentos: " + String.valueOf(failedAttempts).toString());

                        view.jPanel1.setVisible(true);

                        if (failedAttempts == 0) {
                            view.jLabel1.setText("ACCESO DENEGADO. NOTA: Para acceder de nuevo al sistema, cierre la ventana y vuelva a abrirla.");

                            for (Component component : view.jPanel2.getComponents()) {
                                if (!(component instanceof JLabel)) {
                                    component.setEnabled(false);
                                }
                            }
                        }
                    }
                }
            }
        });

        view.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new EmailRequestController();

                view.dispose();
            }
        });
    }

}
