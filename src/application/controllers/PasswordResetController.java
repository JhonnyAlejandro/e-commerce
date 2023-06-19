package application.controllers;

import application.views.PasswordResetView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Validations;
import application.models.UsersModel;
import application.views.LoginView;
import database.Queries;
import org.mindrot.jbcrypt.BCrypt;

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
                boolean successPassword = false;
                boolean successPasswordConfirm = false;
                boolean successPasswordEquals = false;
                boolean successPasswordlength = false;

                if (validations.validateEmptyField(String.copyValueOf(view.pwdNewPass.getPassword()))) {
                    view.pwdNewPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblNewPassErrorMessage.setText("Ingresa tu nueva contraseña*");
                    view.lblNewPassErrorMessage.setVisible(true);
                    view.jPanel1.setVisible(false);
                } else {
                    view.pwdNewPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );
                    successPassword = true;
                    view.lblNewPassErrorMessage.setVisible(false);
                }

                if (validations.validateEmptyField(String.copyValueOf(view.pwdConfirmPass.getPassword()))) {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                            + "showRevealButton: false;"
                    );

                    view.lblConfirmPassErrorMenssage.setText("Confirma tu nueva contraseña*");
                    view.lblConfirmPassErrorMenssage.setVisible(true);
                    view.jPanel1.setVisible(false);
                } else {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );
                    successPasswordConfirm = true;
                    view.lblConfirmPassErrorMenssage.setVisible(false);
                    view.jPanel1.setVisible(false);

                }

                if (!view.pwdNewPass.getText().equals(view.pwdConfirmPass.getText())) {
                    view.lblCredentialsErrorMessage.setText("Las contraseñas no coinciden");
                    view.lblCredentialsErrorMessage.setVisible(true);
                    view.jPanel1.setVisible(true);

                } else {
                    view.pwdConfirmPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );
                    view.pwdNewPass.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                            + "showRevealButton: false;"
                    );
                    successPasswordEquals = true;
                    view.lblCredentialsErrorMessage.setVisible(false);

                }
                
                

                if (successPassword == true && successPasswordConfirm == true && successPasswordEquals == true) {
                    
                    if (String.copyValueOf(view.pwdNewPass.getPassword()).length() <= 7) {
 
                        view.lblCredentialsErrorMessage.setText("Ingresa una contraseña de maximo 8 caracteres");
                        view.lblCredentialsErrorMessage.setVisible(true);
                        view.jPanel1.setVisible(true);  
                        
                    }else {
                        view.pwdNewPass.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );
  
                        view.lblNewPassErrorMessage.setVisible(false);
                        view.jPanel1.setVisible(false); 
                    
                    
                    
                    
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
                            view.lblCredentialsErrorMessage.setText("Has usado esta contraseña recientemente");
                            view.lblCredentialsErrorMessage.setVisible(true);
                            view.jPanel1.setVisible(true);

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
        });

    }
}
