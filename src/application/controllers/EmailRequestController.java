package application.controllers;

import application.views.EmailRequestView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Validations;

public class EmailRequestController {

    EmailRequestView view = new EmailRequestView();
    Validations validations = new Validations();

    public EmailRequestController() {
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

                        new VerificationCodeController();

                        view.dispose();
                    }
                }
            }
        });

        view.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Hola");
            }
        });
    }

}
