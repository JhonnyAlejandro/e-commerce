package application.controllers;

import application.models.RecuperationModel;
import application.models.UsersModel;
import application.views.EmailRequestView;
import application.views.LoginView;
import database.Queries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import utilities.Validations;

public class EmailRequestController {

    
    Session mSession;
    MimeMessage mCorreo;
    Properties mProperties = new Properties();
    EmailRequestView view = new EmailRequestView();
    RecuperationModel model = new RecuperationModel();
    LoginView viewLogin = new LoginView();
    UsersModel modelUsers = new UsersModel();
    Validations validations = new Validations();
    Queries queries = new Queries();

    public EmailRequestController() {
        start();
        events();
    }

    private void start() {
        view.setVisible(true);
    }

    private void events() {
        view.btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
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
                                "borderColor: #F51D24;"
                        );
                        
                        view.lblEmailErrorMessage.setVisible(false);
                        modelUsers.setEmail(view.txtEmail.getText().trim());
                        
                        if (!validations.validateEmptyField(queries.getUser(modelUsers))) {
                            
                            //generacion de codigo aleatorio
                            String code = generationCode();

                            //envio de codigo por correo
                            model.setEmailTo(modelUsers.getEmail());
                            model.setContent(code);
                            model.setSubject("Correo de recuperacion de contraseña");

                            // Simple mail transfer protocol
                            mProperties.put("mail.smtp.host", "smtp.gmail.com");
                            mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                            mProperties.setProperty("mail.smtp.starttls.enable", "true");
                            mProperties.setProperty("mail.smtp.port", "587");
                            mProperties.setProperty("mail.smtp.user", model.getEmailFrom());
                            mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
                            mProperties.setProperty("mail.smtp.auth", "true");

                            mSession = Session.getDefaultInstance(mProperties);

                            try {
                                mCorreo = new MimeMessage(mSession);
                                mCorreo.setFrom(new InternetAddress(model.getEmailFrom()));
                                mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(model.getEmailTo()));
                                mCorreo.setSubject(model.getSubject());
                                mCorreo.setText("<h1>Hola, este es tu codigo para recuperar tu contraseña: </h1>" + "<h1>" + model.getContent() + "</h1>", "ISO-8859-1", "html");

                            } catch (AddressException ex) {
                                Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (MessagingException ex) {
                                Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            try {
                                Transport mTransport = mSession.getTransport("smtp");
                                mTransport.connect(model.getEmailFrom(), model.getPasswordFrom());
                                mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
                                mTransport.close();

                            } catch (NoSuchProviderException ex) {
                                Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (MessagingException ex) {
                                Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                            new VerificationCodeController(code,modelUsers);

                            view.dispose();

                        } else {
                            view.lblCredentialsErrorMessage.setText("correo no encotrado en la base de datos");
                            view.jPanel1.setVisible(true);
                          
                        }

                        
                    }
                }
            }
        });

        view.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new LoginController(modelUsers, viewLogin);
                view.dispose();
            }
        });
    }

    public static String generationCode() {
        int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
        return String.valueOf(codigo);
    }

}
