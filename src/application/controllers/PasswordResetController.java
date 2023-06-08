package application.controllers;

import application.views.PasswordResetView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Validations;
import application.models.UsersModel;
import application.views.LoginView;
import database.Queries;

public class PasswordResetController {

    PasswordResetView view = new PasswordResetView();
    Validations validations = new Validations();
    UsersModel user;
    Queries queries = new Queries();

    public PasswordResetController(UsersModel user) {
        this.user = user;
        start();
        events();
    }

    private void start() {
        view.setVisible(true);
    }

    private void events() {
        view.btnRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (validations.validateEmptyField(String.copyValueOf(view.pwdNewPass.getPassword()))) {
                    view.pwdNewPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblNewPassErrorMessage.setText("Ingresa tu nueva contraseña*");
                    view.lblNewPassErrorMessage.setVisible(true);
                } else {
                    view.pwdNewPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.lblNewPassErrorMessage.setVisible(false);
                }

                if (validations.validateEmptyField(String.copyValueOf(view.pwdConfirmPass.getPassword()))) {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                            + "showRevealButton: false;"
                    );

                    view.lblConfirmPassErrorMenssage.setText("Confirma tu nueva contraseña*");
                    view.lblConfirmPassErrorMenssage.setVisible(true);
                } else {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );

                    view.lblConfirmPassErrorMenssage.setVisible(false);

                }
                if (!view.pwdNewPass.getText().equals(view.pwdConfirmPass.getText())) {
                    view.lblCredentialsErrorMessage.setText("Las contraseñas no coinciden");
                    view.lblCredentialsErrorMessage.setVisible(true);
                    view.jPanel1.setVisible(true);
                    view.pwdNewPass.putClientProperty("JComponent.outline", "error");
                    view.pwdConfirmPass.putClientProperty("JComponent.outline", "error");
                } else {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );
                    view.pwdNewPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );

                    view.lblCredentialsErrorMessage.setVisible(false);

                    char[] pass = view.pwdConfirmPass.getPassword();
                    user.setPassword(pass);
                    String passConfirm = queries.getUser(user);

                    boolean confirm = queries.NewPass(user);

                    if (!passConfirm.equals(view.pwdConfirmPass.getText())) {

                        if (confirm) {
                            LoginView viewLogin = new LoginView();
                            UsersModel user = new UsersModel();
                            LoginController controller = new LoginController(user, viewLogin);
                            view.dispose();

                        }

                    } else {
                        view.lblCredentialsErrorMessage.setText("Has usado esta contraseña recientemente");
                        view.lblCredentialsErrorMessage.setVisible(true);
                        view.jPanel1.setVisible(true);
                        view.pwdNewPass.putClientProperty("JComponent.outline", "error");
                        view.pwdConfirmPass.putClientProperty("JComponent.outline", "error");

                    }
                }
            }
        }
        );

        view.btnCancel.addActionListener(
                new ActionListener() {
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
