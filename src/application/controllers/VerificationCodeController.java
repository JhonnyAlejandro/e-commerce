package application.controllers;

import application.models.UsersModel;
import application.views.LoginView;
import application.views.VerificationCodeView;
import database.Queries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Validations;

public class VerificationCodeController {

    VerificationCodeView view = new VerificationCodeView();
    Validations validations = new Validations();
    Queries queries = new Queries();
    UsersModel modelUsers;
    String code;

    public VerificationCodeController(String code, UsersModel modelUsers) {
        this.code = code;
        this.modelUsers = modelUsers;
        start();
        events();
    }

    private void start() {
        view.setVisible(true);
    }

    private void events() {
        view.btnVerify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (validations.validateEmptyField(view.txtCode.getText())) {
                    view.txtCode.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblCodeError.setText("Ingresa el código de verificación*");
                    view.lblCodeError.setVisible(true);
                } else {
                    if (validations.validateEmail(view.txtCode.getText()) == false) {
                        view.txtCode.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );
                        view.lblCodeError.setVisible(false);

                        String codigo = view.txtCode.getText();

                        if (code.equals(codigo)) {
                            view.dispose();
                            new PasswordResetController(modelUsers);
                        } else {
                            view.lblCodeErrorMessage.setText("Codigo incorrecto");
                            view.jPanel1.setVisible(true);
                            view.txtCode.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );
                       }
                    }
                }
            }
        });

        view.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView viewLogin = new LoginView();
                UsersModel modelUsers = new UsersModel();

                new LoginController(modelUsers, viewLogin);
                view.dispose();

            }
        }
        );

    }

}
