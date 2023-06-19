package application.controllers;

import application.models.RecuperationModel;
import application.models.UsersModel;
import application.views.EmailRequestView;
import application.views.LoginView;
import database.Queries;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
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
        
        Preferences prefs = Preferences.userNodeForPackage(LoginController.class);
        boolean rememberPassword = prefs.getBoolean("rememberPassword", false);

        view.chkAutofill.setSelected(rememberPassword);
        String email = prefs.get("email", "");
        String password = prefs.get("password", "");
        view.txtEmail.setText(email);
        view.pwdPassword.setText(password);
        checkEnable();
        start();
        events();
        statusCheckboxd();
    }

    private void start() {
        view.setVisible(true);
    }

    private void events() {
        view.btnAccess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                boolean successfulEmailCredential = false;
                boolean successfulPasswordCredential = false;

                if (validations.validateEmptyField(view.txtEmail.getText())) {
                    view.txtEmail.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblEmailErrorMessage.setText("Ingresa tu dirección de correo electrónico*");
                    view.lblEmailErrorMessage.setVisible(true);
                } else {
                    if (validations.validateEmail(view.txtEmail.getText()) == false) {
                        view.txtEmail.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblEmailErrorMessage.setText("Ingresa una dirección de correo electrónico valida*");
                        view.lblEmailErrorMessage.setVisible(true);
                    } else {
                        view.txtEmail.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblEmailErrorMessage.setVisible(false);

                        model.setEmail(view.txtEmail.getText());

                        successfulEmailCredential = true;
                    }
                }

                if (validations.validateEmptyField(String.copyValueOf(view.pwdPassword.getPassword()))) {
                    view.pwdPassword.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblPasswordErrorMessage.setText("Ingresa tu contraseña*");
                    view.lblPasswordErrorMessage.setVisible(true);
                } else {
                    view.pwdPassword.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.lblPasswordErrorMessage.setVisible(false);

                    model.setPassword(view.pwdPassword.getPassword());

                    successfulPasswordCredential = true;
                }

                if (successfulEmailCredential == true && successfulPasswordCredential == true) {
                    if (queries.authentication(model,view)) {
                        checkEnable();
                        new DashboardController();
                        view.dispose();
                    } else {
                        failedAttempts--;

                        view.lblCredentialsErrorMessage.setText("La dirección de correo electrónico y/o la contraseña son incorrectas. Número de intentos: " + String.valueOf(failedAttempts).toString());

                        view.jPanel1.setVisible(true);

                        if (failedAttempts == 0) {
                            view.lblCredentialsErrorMessage.setText("ACCESO DENEGADO. NOTA: Para acceder de nuevo al sistema, cierre la ventana y vuelva a abrirla.");

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

        view.btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                new EmailRequestController();

                view.dispose();
            }
        });
    }
    
    
    public void statusCheckboxd() { 
    boolean status = view.chkAutofill.isSelected();
        if (!validations.validateEmptyField(view.txtEmail.getText()) && !validations.validateEmptyField(view.pwdPassword.getText())) {
            if (status) {
                view.btnAccess.doClick();
            }
        }
    }

    public void checkEnable() {
        
        Preferences prefs = Preferences.userNodeForPackage(LoginController.class);
        boolean rememberPassword = view.chkAutofill.isSelected();
        prefs.putBoolean("rememberPassword", rememberPassword);

        if (rememberPassword) {
            String username = view.txtEmail.getText();
            String password = String.valueOf(view.pwdPassword.getPassword());
            prefs.put("email", username);
            prefs.put("password", password);

        } else {
            clearRememberedPassword();
        }
    }

    public void clearRememberedPassword() {
        Preferences prefs = Preferences.userNodeForPackage(LoginController.class);
        prefs.remove("email");
        prefs.remove("password");
    }
    

}
