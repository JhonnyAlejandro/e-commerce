package application.controllers;

import application.views.VerificationCodeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Validations;

public class VerificationCodeController {

    VerificationCodeView view = new VerificationCodeView();
    Validations validations = new Validations();

    public VerificationCodeController() {
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
                if (validations.validateEmptyField(view.jTextField1.getText())) {
                    view.jTextField1.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.jLabel4.setText("Ingresa el código de verificación*");
                    view.jLabel4.setVisible(true);
                } else {
                    if (validations.validateEmail(view.jTextField1.getText()) == false) {
                        view.jTextField1.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.jLabel4.setVisible(false);

                        new PasswordResetController();

                        view.dispose();
                    }
                }
            }
        });
    }

}
