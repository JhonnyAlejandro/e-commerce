package application.controllers;

import application.views.PasswordResetView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.ValidationsProfile;
import application.models.UsersModel;
import application.views.LoginView;
import database.Queries;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordResetController {

    PasswordResetView view = new PasswordResetView();
    ValidationsProfile validations = new ValidationsProfile();
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
                char[] newPassChars = view.pwdNewPass.getPassword();
                char[] confirmPassChars = view.pwdConfirmPass.getPassword();

                String newPass = String.valueOf(newPassChars);
                String confirmPass = String.valueOf(confirmPassChars);

                if (validations.validateEmptyField(newPass)) {
                    view.pwdNewPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style", "borderColor: #F3F6FB;");
                    view.lblNewPassErrorMessage.setText("Ingresa tu nueva contraseña*");
                    view.lblConfirmPassErrorMenssage.setVisible(false);
                    view.lblNewPassErrorMessage.setVisible(true);
                    view.jPanel1.setVisible(false);
                } else if (validations.validateEmptyField(confirmPass)) {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.pwdNewPass.putClientProperty("FlatLaf.style", "borderColor:  #F3F6FB;");
                    view.lblConfirmPassErrorMenssage.setText("Confirma tu nueva contraseña*");
                    view.lblConfirmPassErrorMenssage.setVisible(true);
                    view.lblNewPassErrorMessage.setVisible(false);
                    view.jPanel1.setVisible(false);
                } else if (!newPass.equals(confirmPass)) {
                    view.lblCredentialsErrorMessage.setText("Las contraseñas no coinciden");
                    view.pwdNewPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.lblCredentialsErrorMessage.setVisible(true);
                    view.lblConfirmPassErrorMenssage.setVisible(false);
                    view.lblNewPassErrorMessage.setVisible(false);
                    view.jPanel1.setVisible(true);
                } else if (newPassChars.length <= 7) {
                    view.pwdNewPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.lblCredentialsErrorMessage.setText("Ingresa una contraseña de máximo 8 caracteres");
                    view.lblCredentialsErrorMessage.setVisible(true);
                    view.lblConfirmPassErrorMenssage.setVisible(false);
                    view.lblNewPassErrorMessage.setVisible(false);
                    view.jPanel1.setVisible(true);
                } else {
                    view.pwdNewPass.putClientProperty("FlatLaf.style", "borderColor: #F3F6FB;");
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style", "borderColor: #F3F6FB;");
                    view.lblNewPassErrorMessage.setVisible(false);
                    view.lblConfirmPassErrorMenssage.setVisible(false);
                    view.lblCredentialsErrorMessage.setVisible(false);

                    char[] pass = view.pwdConfirmPass.getPassword();
                    user.setPassword(pass);

                    String passConfirm = queries.getUser(user);
                    boolean confirm = queries.NewPass(user);

                    if (!BCrypt.checkpw(view.pwdConfirmPass.getText(), passConfirm)) {
                        if (confirm) {
                            LoginView viewLogin = new LoginView();
                            UsersModel user = new UsersModel();
                            LoginController controller = new LoginController(user, viewLogin);
                            view.dispose();
                        }
                    } else {
                        view.pwdNewPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                        view.pwdConfirmPass.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                        view.lblCredentialsErrorMessage.setText("Has usado esta contraseña recientemente");
                        view.lblCredentialsErrorMessage.setVisible(true);
                        view.jPanel1.setVisible(true);
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
        });

    }
}
