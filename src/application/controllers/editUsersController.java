package application.controllers;

import application.models.RecuperationModel;
import application.models.RolesModel;
import application.models.UsersModel;
import application.views.UsersFormView;
import application.views.UsersView;
import database.Queries;
import database.QueriesUsers;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
import javax.swing.table.DefaultTableModel;
import utilities.ValidationsUsers;
import utilities.PerformActions;

public class editUsersController {

    UsersFormView view;
    UsersView usersView;
    RecuperationModel modelo = new RecuperationModel();
    private Properties mProperties = new Properties();
    private Session mSession;
    private MimeMessage mCorreo;
    QueriesUsers queries = new QueriesUsers();
    ValidationsUsers validation = new ValidationsUsers();
    PerformActions repaint = new PerformActions();
    UsersModel users2 = new UsersModel();

    public editUsersController(UsersFormView view, UsersView usersView) {
        this.view = view;
        this.usersView = usersView;
        events();
        loadRoles();
        changetitle();
        hideButton();
        loadData();
        this.users2 = loadData();

    }

    private void events() {
        view.btnSaveChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Object obj = usersView.tblUsers.getValueAt(usersView.tblUsers.getSelectedRow(), 0);

                int id = (int) obj;

                boolean First_Name = false;
                boolean Last_Name = false;
                boolean Addres = false;
                boolean City = false;
                boolean Department = false;
                boolean Email = false;
                boolean Phone = false;
                boolean rol = false;

                UsersModel users = new UsersModel();
                users.setIdUsers(id);

                if (validation.checkEmpty(view.txtFirstNameAdd.getText())) {
                    view.txtFirstNameAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorName.setText("No se puede dejar el campo vacio");
                    view.lblerrorName.setVisible(true);

                    System.out.println("bandera 1");
                } else {
                    if (validation.stringCheck(view.txtFirstNameAdd.getText()) == false) {
                        view.txtFirstNameAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorName.setText("El nombre tiene caracteres no permitidos (1-9,@,$,%,&,?)");
                        view.lblerrorName.setVisible(true);

                    } else {
                        view.txtFirstNameAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblerrorName.setVisible(false);

                        users.setFirstName(view.txtFirstNameAdd.getText());

                        First_Name = true;

                    }
                }

                // termina if nombre 
                if (validation.checkEmpty(view.txtLastNameAdd.getText())) {
                    view.txtLastNameAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorLastName.setText("No puedes dejar el campo vacio");
                    view.lblerrorLastName.setVisible(true);

                    System.out.println("bandera 2");
                } else {
                    if (validation.stringCheck(view.txtLastNameAdd.getText()) == false) {
                        view.txtLastNameAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorLastName.setText("El apellido tiene caracteres no permitidos (1-9,@,$,%,&,?");
                        view.lblerrorLastName.setVisible(true);

                    } else {

                        view.txtLastNameAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblerrorLastName.setVisible(false);

                        users.setLastName(view.txtLastNameAdd.getText());

                        Last_Name = true;

                    }
                }

                // termina if de apellido 
                if (validation.checkEmpty(view.txtEmailAdd.getText())) {
                    view.txtEmailAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorEmail.setText("No se puede dejar el campo vacio");
                    view.lblerrorEmail.setVisible(true);
                } else {
                    if (validation.emailDomain(view.txtEmailAdd.getText()) == false) {
                        view.txtEmailAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorEmail.setText("Ingresa una dirección de correo electrónico valida");
                        view.lblerrorEmail.setVisible(true);
                    } else {
                        view.txtEmailAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblerrorEmail.setVisible(false);

                        users.setEmail(view.txtEmailAdd.getText());

                        Email = true;

                    }
                }

                // termina validacion email 
                if (validation.checkEmpty(view.txtPhoneAdd.getText())) {
                    view.txtPhoneAdd.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.lblerrorPhone.setText("No se puede dejar el campo vacio");
                    view.lblerrorPhone.setVisible(true);
                    System.out.println("bandera 4");
                } else {
                    if (!validation.phoneCheck(view.txtPhoneAdd.getText())) {
                        view.txtPhoneAdd.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                        view.lblerrorPhone.setText("Ingresa un número de teléfono válido (solo dígitos)");
                        view.lblerrorPhone.setVisible(true);
                    } else {
                        view.txtPhoneAdd.putClientProperty("FlatLaf.style", "borderColor: #F3F6FB;");
                        view.lblerrorPhone.setVisible(false);
                        users.setPhone(view.txtPhoneAdd.getText());
                        Phone = true;
                    }
                }

                //validaciones phone 
                if (validation.checkEmpty(view.txtDepartmentAdd.getText())) {
                    view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorDepartment.setText("No se puede dejar el campo vacio");
                    view.lblerrorDepartment.setVisible(true);

                    System.out.println("bandera 5");
                } else {
                    if (!validation.stringCheck(view.txtDepartmentAdd.getText())) {
                        view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorDepartment.setText("El departamento tiene caracteres no permitidos");
                        view.lblerrorDepartment.setVisible(true);
                    } else {

                        view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblerrorDepartment.setVisible(false);

                        users.setDepartment(view.txtDepartmentAdd.getText());

                        Department = true;

                    }
                }//termina validaciones de departamento

                if (validation.checkEmpty(view.txtCityAdd.getText())) {
                    view.txtCityAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorCity.setText("No se puede dejar el campo vacio");
                    view.lblerrorCity.setVisible(true);

                    System.out.println("bandera 6");
                } else {
                    if (!validation.stringCheck(view.txtCityAdd.getText())) {
                        view.txtCityAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorCity.setText("La ciudad tiene caracteres no permitidos");
                        view.lblerrorCity.setVisible(true);
                    } else {

                        view.txtCityAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblerrorCity.setVisible(false);

                        users.setCity(view.txtCityAdd.getText());

                        City = true;
                    }
                }

                //validacion ciudad
                if (validation.checkEmpty(view.txtAdressAdd.getText())) {
                    view.txtAdressAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorAdress.setText("No se puede dejar el campo vacio");
                    view.lblerrorAdress.setVisible(true);

                    System.out.println("bandera 7");
                } else {
                    if (!validation.addressCheck(view.txtAdressAdd.getText())) {
                        view.txtAdressAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorAdress.setText("La dirección tiene un formato incorrecto");
                        view.lblerrorAdress.setVisible(true);
                    } else {
                        view.txtAdressAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F3F6FB;"
                        );

                        view.lblerrorAdress.setVisible(false);

                        users.setAddress(view.txtAdressAdd.getText());

                        Addres = true;
                    }
                }

                if (view.cmbRoles.getSelectedItem().equals("Seleccione un rol")) {
                    view.cmbRoles.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorRol.setText("Seleccione una opcion valida");
                    view.lblerrorRol.setVisible(true);
                } else {
                    view.cmbRoles.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.lblerrorRol.setVisible(false);

                    users.setRol(view.cmbRoles.getSelectedIndex());

                    rol = true;
                }

                //validacion direccion 
                if (First_Name == true && Last_Name == true && Addres == true && City == true && Department == true && Email == true && Phone == true && rol == true) {

                    boolean correoExistente = false;

                    if (!users2.getEmail().equals(view.txtEmailAdd.getText())) {
                        if (queries.showifmailexists(view.txtEmailAdd.getText())) {
                            JOptionPane.showMessageDialog(usersView, "El correo ya existe");
                            correoExistente = true;
                        } else {
                            createPassword(modelo, users);

                        }
                    }

                    if (!correoExistente) {
                        if (queries.updateUser(users)) {
                            JOptionPane.showMessageDialog(view, "Se actualizó el usuario");
                            UsersView usersView2 = new UsersView();
                            UsersController usersController = new UsersController(usersView2);
                            usersController.loadTable();
                            repaint.changePanel(view, usersView2);
                        } else {
                            JOptionPane.showMessageDialog(view, "No se ha actualizado el usuario");
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

    private UsersModel loadData() {
        UsersModel users = new UsersModel();

        Object obj2 = usersView.tblUsers.getValueAt(usersView.tblUsers.getSelectedRow(), 0);
        int id = (int) obj2;

        users = queries.search(id);

        view.txtFirstNameAdd.setText(users.getFirstName());
        view.txtLastNameAdd.setText(users.getLastName());
        view.txtDepartmentAdd.setText(users.getDepartment());
        view.txtCityAdd.setText(users.getCity());
        view.txtPhoneAdd.setText(users.getPhone());
        view.txtAdressAdd.setText(users.getAddress());
        view.txtEmailAdd.setText(users.getEmail());
        view.cmbRoles.setSelectedIndex(users.getRol());
        return users;
    }

    public void changetitle() {
        view.lblTitle.setText("Editar usuario");
    }

    public void hideButton() {
        view.btnAdd.setVisible(false);
    }

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
}
