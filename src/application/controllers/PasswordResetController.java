package application.controllers;

import application.views.PasswordResetView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Validations;

public class PasswordResetController {

    PasswordResetView view = new PasswordResetView();
    Validations validations = new Validations();

    public PasswordResetController() {
        start();
        events();
    }

    private void start() {
        view.setVisible(true);
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (validations.validateEmptyField(String.copyValueOf(view.jPasswordField1.getPassword()))) {
                    view.jPasswordField1.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.jLabel4.setText("Ingresa tu nueva contraseña*");
                    view.jLabel4.setVisible(true);
                } else {
                    view.jPasswordField1.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.jLabel4.setVisible(false);
                }

                if (validations.validateEmptyField(String.copyValueOf(view.jPasswordField2.getPassword()))) {
                    view.jPasswordField2.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                            + "showRevealButton: false;"
                    );

                    view.jLabel5.setText("Confirma tu nueva contraseña*");
                    view.jLabel5.setVisible(true);
                } else {
                    view.jPasswordField2.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );

                    view.jLabel5.setVisible(false);
                }
            }
        });
    }
}
