package application.controllers;

import application.models.UsersModel;
import application.views.UsersFormView;

import database.QueriesUsers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import application.models.RecuperationModel;
import application.models.RolesModel;
import application.views.UsersView;
import java.util.concurrent.ThreadLocalRandom;
import utilities.ValidationsUsers;

public class AddUserController {

    RecuperationModel modelo = new RecuperationModel();
    private Properties mProperties = new Properties();
    private Session mSession;
    private MimeMessage mCorreo;
    UsersFormView view;
    UsersModel users = new UsersModel();
    ValidationsUsers validation = new ValidationsUsers();
    QueriesUsers queries = new QueriesUsers();

    public AddUserController(UsersFormView view) {
        this.view = view;
        events();
        loadRoles();
        hideButton();
        changetitle();
        //moveButtonPosition();
    }

    private void events() {

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                boolean emptyFirtsName = validation.checkEmpty(view.txtFirstNameAdd.getText());

                if (emptyFirtsName) {
                    view.lblerrorName.setVisible(emptyFirtsName);
                    view.lblerrorName.setText("No puedes dejar el campo vacio");
                    view.lblerrorLastName.setVisible(false);
                    view.lblerrorEmail.setVisible(false);
                    view.lblerrorPhone.setVisible(false);
                    view.lblerrorDepartment.setVisible(false);
                    view.lblerrorAdress.setVisible(false);
                    view.lblerrorCity.setVisible(false);
                    //view.lblerrorRol.setVisible(false);
                } else {
                    boolean emptyLastName = validation.checkEmpty(view.txtLastNameAdd.getText());
                    if (emptyLastName) {
                        view.lblerrorLastName.setVisible(emptyLastName);
                        view.lblerrorLastName.setText("No puedes dejar el campo vacio");
                        view.lblerrorName.setVisible(false);
                        view.lblerrorEmail.setVisible(false);
                        view.lblerrorPhone.setVisible(false);
                        view.lblerrorDepartment.setVisible(false);
                        view.lblerrorAdress.setVisible(false);
                        view.lblerrorCity.setVisible(false);
                        //view.lblerrorRol.setVisible(false);
                    } else {
                        boolean emptyEmail = validation.checkEmpty(view.txtEmailAdd.getText());
                        if (emptyEmail) {
                            view.lblerrorEmail.setVisible(emptyEmail);
                            view.lblerrorEmail.setText("No puedes dejar el campo vacio");
                            view.lblerrorLastName.setVisible(false);
                            view.lblerrorName.setVisible(false);
                            view.lblerrorPhone.setVisible(false);
                            view.lblerrorDepartment.setVisible(false);
                            view.lblerrorAdress.setVisible(false);
                            view.lblerrorCity.setVisible(false);
                            //view.lblerrorRol.setVisible(false);
                        } else {
                            boolean emptyAddress = validation.checkEmpty(view.txtAdressAdd.getText());
                            if (emptyAddress) {
                                view.lblerrorAdress.setVisible(emptyAddress);
                                view.lblerrorAdress.setText("No puedes dejar el campo vacio");
                                view.lblerrorLastName.setVisible(false);
                                view.lblerrorEmail.setVisible(false);
                                view.lblerrorPhone.setVisible(false);
                                view.lblerrorDepartment.setVisible(false);
                                view.lblerrorName.setVisible(false);
                                view.lblerrorCity.setVisible(false);
                                //view.lblerrorRol.setVisible(false);
                            } else {
                                boolean emptyDepartment = validation.checkEmpty(view.txtDepartmentAdd.getText());
                                if (emptyDepartment) {
                                    view.lblerrorDepartment.setVisible(emptyDepartment);
                                    view.lblerrorDepartment.setText("No puedes dejar el campo vacio");
                                    view.lblerrorLastName.setVisible(false);
                                    view.lblerrorEmail.setVisible(false);
                                    view.lblerrorPhone.setVisible(false);
                                    view.lblerrorName.setVisible(false);
                                    view.lblerrorAdress.setVisible(false);
                                    view.lblerrorCity.setVisible(false);
                                    //view.lblerrorRol.setVisible(false);
                                } else {
                                    boolean emptyCity = validation.checkEmpty(view.txtCityAdd.getText());
                                    if (emptyCity) {
                                        view.lblerrorCity.setVisible(emptyCity);
                                        view.lblerrorCity.setText("No puedes dejar el campo vacio");
                                        view.lblerrorLastName.setVisible(false);
                                        view.lblerrorEmail.setVisible(false);
                                        view.lblerrorPhone.setVisible(false);
                                        view.lblerrorDepartment.setVisible(false);
                                        view.lblerrorAdress.setVisible(false);
                                        view.lblerrorName.setVisible(false);
                                        //view.lblerrorRol.setVisible(false);
                                    } else {
                                        boolean emptyPhone = validation.checkEmpty(view.txtPhoneAdd.getText());
                                        if (emptyPhone) {
                                            view.lblerrorPhone.setVisible(emptyPhone);
                                            view.lblerrorPhone.setText("No puedes dejar el campo vacio");
                                            view.lblerrorLastName.setVisible(false);
                                            view.lblerrorEmail.setVisible(false);
                                            view.lblerrorName.setVisible(false);
                                            view.lblerrorDepartment.setVisible(false);
                                            view.lblerrorAdress.setVisible(false);
                                            view.lblerrorCity.setVisible(false);
                                            //view.lblerrorRol.setVisible(false);
                                        } else {
                                            boolean nameCorrect = validation.stringCheck(view.txtFirstNameAdd.getText());
                                            if (!nameCorrect) {
                                                view.lblerrorName.setVisible(!nameCorrect);
                                                view.lblerrorName.setText("El nombre tiene caracteres no permitidos (1-9,@,$,%,&,?)");
                                                view.lblerrorLastName.setVisible(false);
                                                view.lblerrorEmail.setVisible(false);
                                                view.lblerrorPhone.setVisible(false);
                                                view.lblerrorDepartment.setVisible(false);
                                                view.lblerrorAdress.setVisible(false);
                                                view.lblerrorCity.setVisible(false);
                                                //view.lblerrorRol.setVisible(false);
                                            } else {
                                                boolean lastNameCorrect = validation.stringCheck(view.txtLastNameAdd.getText());
                                                if (!lastNameCorrect) {
                                                    view.lblerrorLastName.setVisible(!lastNameCorrect);
                                                    view.lblerrorLastName.setText("El apellido tiene caracteres no permitidos (1-9,@,$,%,&,?)");
                                                    view.lblerrorName.setVisible(false);
                                                    view.lblerrorEmail.setVisible(false);
                                                    view.lblerrorPhone.setVisible(false);
                                                    view.lblerrorDepartment.setVisible(false);
                                                    view.lblerrorAdress.setVisible(false);
                                                    view.lblerrorCity.setVisible(false);
                                                    //view.lblerrorRol.setVisible(false);
                                                } else {
                                                    boolean departmentCorrect = validation.stringCheck(view.txtDepartmentAdd.getText());
                                                    if (!departmentCorrect) {
                                                        view.lblerrorDepartment.setVisible(!departmentCorrect);
                                                        view.lblerrorDepartment.setText("El departamento tiene caracteres no permitidos (1-9,@,$,%,&,?)");
                                                        view.lblerrorLastName.setVisible(false);
                                                        view.lblerrorEmail.setVisible(false);
                                                        view.lblerrorPhone.setVisible(false);
                                                        view.lblerrorName.setVisible(false);
                                                        view.lblerrorAdress.setVisible(false);
                                                        view.lblerrorCity.setVisible(false);
                                                        //view.lblerrorRol.setVisible(false);
                                                    } else {
                                                        boolean cityCorrect = validation.stringCheck(view.txtCityAdd.getText());
                                                        if (!cityCorrect) {
                                                            view.lblerrorCity.setVisible(!cityCorrect);
                                                            view.lblerrorCity.setText("La ciudad tiene caracteres no permitidos (1-9,@,$,%,&,?)");
                                                            view.lblerrorLastName.setVisible(false);
                                                            view.lblerrorEmail.setVisible(false);
                                                            view.lblerrorPhone.setVisible(false);
                                                            view.lblerrorDepartment.setVisible(false);
                                                            view.lblerrorAdress.setVisible(false);
                                                            view.lblerrorName.setVisible(false);
                                                            //view.lblerrorRol.setVisible(false);
                                                        } else {
                                                            boolean phoneCorrect = validation.phoneCheck(view.txtPhoneAdd.getText());
                                                            if (!phoneCorrect) {
                                                                view.lblerrorPhone.setVisible(!phoneCorrect);
                                                                view.lblerrorPhone.setText("el numero de celular tiene caracteres no permitidos (a-z,#,$,%,&,/,-)");
                                                                view.lblerrorLastName.setVisible(false);
                                                                view.lblerrorEmail.setVisible(false);
                                                                view.lblerrorName.setVisible(false);
                                                                view.lblerrorDepartment.setVisible(false);
                                                                view.lblerrorAdress.setVisible(false);
                                                                view.lblerrorCity.setVisible(false);
                                                                //view.lblerrorRol.setVisible(false);
                                                            } else {
                                                                boolean domainCorrect = validation.emailDomain(view.txtEmailAdd.getText());
                                                                if (!domainCorrect) {
                                                                    view.lblerrorEmail.setVisible(!domainCorrect);
                                                                    view.lblerrorEmail.setText("El correo electronico no tiene el dominio correcto");
                                                                    view.lblerrorLastName.setVisible(false);
                                                                    view.lblerrorName.setVisible(false);
                                                                    view.lblerrorPhone.setVisible(false);
                                                                    view.lblerrorDepartment.setVisible(false);
                                                                    view.lblerrorAdress.setVisible(false);
                                                                    view.lblerrorCity.setVisible(false);
                                                                    //view.lblerrorRol.setVisible(false);
                                                                } else {
                                                                    boolean addressCorrect = validation.addressCheck(view.txtAdressAdd.getText());
                                                                    if (!addressCorrect) {
                                                                        view.lblerrorAdress.setVisible(!addressCorrect);
                                                                        view.lblerrorAdress.setText("la direccion tiene caracteres no permitidos");
                                                                        view.lblerrorLastName.setVisible(false);
                                                                        view.lblerrorEmail.setVisible(false);
                                                                        view.lblerrorPhone.setVisible(false);
                                                                        view.lblerrorDepartment.setVisible(false);
                                                                        view.lblerrorName.setVisible(false);
                                                                        view.lblerrorCity.setVisible(false);
                                                                        //view.lblerrorRol.setVisible(false);
                                                                    } else {
                                                                        if (view.cmbRoles.getSelectedItem().equals("Seleccione un rol:")) {
                                                                            //view.lblerrorRol.setVisible(true);
                                                                            //view.lblerrorRol.setText("Seleccione una opcion valida");
                                                                            view.lblerrorLastName.setVisible(false);
                                                                            view.lblerrorEmail.setVisible(false);
                                                                            view.lblerrorPhone.setVisible(false);
                                                                            view.lblerrorDepartment.setVisible(false);
                                                                            view.lblerrorName.setVisible(false);
                                                                            view.lblerrorCity.setVisible(false);
                                                                            view.lblerrorAdress.setVisible(false);
                                                                        } else {
                                                                            UsersView usersView = new UsersView();
                                                                            UsersController usersController = new UsersController(usersView);

                                                                            users.setFirstName(view.txtFirstNameAdd.getText());
                                                                            users.setLastName(view.txtLastNameAdd.getText());
                                                                            users.setAddress(view.txtAdressAdd.getText());
                                                                            users.setCity(view.txtCityAdd.getText());
                                                                            users.setEmail(view.txtEmailAdd.getText());
                                                                            users.setPhone(view.txtPhoneAdd.getText());
                                                                            users.setDepartment(view.txtDepartmentAdd.getText());
                                                                            users.setRol(view.cmbRoles.getSelectedIndex());
                                                                            createPassword(modelo, users);

                                                                            if (queries.insertUser(users)) {
                                                                                JOptionPane.showMessageDialog(view, "Se creo el usuario");
                                                                                usersController.loadTable();
                                                                                clean();
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(view, "No se ha podido crear el usuario");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        });

        view.btnAddCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                UsersView usersView = new UsersView();
                UsersController usersController = new UsersController(usersView);
                usersView.setBounds(0, 0, 800, 700);
                view.removeAll();
                view.add(usersView);
                view.repaint();
                view.revalidate();

            }
        });
    }
    
    public void changetitle(){
        view.lblTitle.setText("Agregar uisuario");
    }
    
    public void hideButton(){
        view.btnSaveChange.setVisible(false);
    }
    
//    public void moveButtonPosition(){
//        view.btnAddCancel.setBounds(900, 900, 1000, 1000);
//    }

    public void createPassword(RecuperationModel modelo, UsersModel users) {

        String temporaryPassword = generationCode();

        //envio de codigo por correo
        modelo.setEmailTo(users.getEmail());
        modelo.setContent(temporaryPassword);

        char[] pass = temporaryPassword.toCharArray();
        users.setPassword(pass);
        modelo.setSubject("Contraseña temporal");

        System.out.println("hola");
        // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println(users.getEmail());
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", users.getEmail());
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        System.out.println("holaw");
        mSession = Session.getDefaultInstance(mProperties);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(modelo.getEmailFrom()));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(users.getEmail()));
            mCorreo.setSubject(modelo.getSubject());
            mCorreo.setText("<h1>Hola, esta es la contraseña temporal para ingresar al sistema, apenas ingreses realiza el cambio de contraseña. </h1>" + "<h1>" + modelo.getContent() + "</h1>", "ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(modelo.getEmailFrom(), modelo.getPasswordFrom());
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

        } catch (NoSuchProviderException ex) {
            Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(RecuperationModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generationCode() {
        int codigo = ThreadLocalRandom.current().nextInt(1000, 10000);
        return String.valueOf(codigo);
    }

    public void loadRoles() {

        ArrayList<RolesModel> rolesList = new ArrayList<RolesModel>();
        rolesList = queries.consultRoles();

        for (int i = 0; i < rolesList.size(); i++) {
            view.cmbRoles.addItem(rolesList.get(i).getNameRol());
        }
    }

    public void clean() {
        view.txtFirstNameAdd.setText("");
        view.txtLastNameAdd.setText("");
        view.txtEmailAdd.setText("");
        view.txtDepartmentAdd.setText("");
        view.txtCityAdd.setText("");
        view.txtAdressAdd.setText("");
        view.txtPhoneAdd.setText("");
        view.cmbRoles.setSelectedIndex(0);
    }
}
