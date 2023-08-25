package application.controllers;

import application.models.CityModel;
import application.models.DepartmentModel;
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
    DepartmentModel department = new DepartmentModel();
    ValidationsUsers validation = new ValidationsUsers();
    QueriesUsers queries = new QueriesUsers();

    public AddUserController(UsersFormView view) {
        this.view = view;
        events();
        loadRoles();
        hideButton();
        changetitle();
        loadDepartments();

        //moveButtonPosition();
    }

    public void events() {

        view.cmbDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepartmentModel department = new DepartmentModel();
                int selectedDepartmentId = view.cmbDepartment.getSelectedIndex();

                // Limpiar las ciudades existentes antes de agregar nuevas
                view.cmbCity.removeAllItems();

                if (selectedDepartmentId != 0) {
                    // Cargar ciudades solo si se selecciona un departamento válido
                    loadCitiesByDepartment(selectedDepartmentId);
                }
            }
        });

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean First_Name = false;
                boolean Last_Name = false;
                boolean Addres = false;
                boolean City = false;
                boolean Department = false;
                boolean Email = false;
                boolean Phone = false;
                boolean rol = false;

                //Inicia validacion de FirstName
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

                // termina validacion de FirstName
                //Inicia validacion de Lastname
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

                // termina validacion de LastName
                //Inicia validacion de Email
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
                        createPassword(modelo, users);

                        Email = true;

                    }
                }

                // termina validacion email 
                //Empieza validaciones de phone
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
                //Termina validacion de phone 

                //Inicia validacion de departamento
                //termina validaciones de departamento
                //Inicia validacion de City
                if (view.cmbDepartment.getSelectedItem().equals("Seleccione un departamento")) {
                    view.cmbDepartment.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    ); 
                    view.lblerrorDepartment.setText("Seleccione un departamento");
                    view.lblerrorDepartment.setVisible(true);
                    view.lblerrorCity.setText("Seleccione una ciudad");
                    view.lblerrorCity.setVisible(true);
                } else {
                    view.cmbDepartment.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );
                    view.lblerrorDepartment.setVisible(false);
                    view.lblerrorCity.setVisible(false);
                    String selectedCityName = view.cmbCity.getSelectedItem().toString();
                    int selectedIndexCity = getCityByName(selectedCityName);
                    users.setCity(selectedIndexCity);
                    Department = true;
                    City = true;
                }

                //Termina validacion de city
                //Inicia validacion de address
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

                //Termina validacion de Address
                //Inicia validacion de roles
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

                //Termina validacion de rol 
                if (First_Name == true && Last_Name == true && Addres == true && City == true && Department == true && Email == true && Phone == true && rol == true) {
                    UsersView usersView = new UsersView();
                    UsersController usersController = new UsersController(usersView);
                    String email = users.getEmail();
                    if (queries.showifmailexists(email)) {
                        JOptionPane.showMessageDialog(usersView, "El correo ya existe");
                    } else {
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

    public void changetitle() {
        view.lblTitle.setText("Agregar usuario");
    }

    public void hideButton() {
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

    private void loadDepartments() {
        ArrayList<DepartmentModel> departments = queries.consultDeparment();
        for (int i = 0; i < departments.size(); i++) {
            view.cmbDepartment.addItem(departments.get(i).getNameDepartment());
        }
    }

    private void loadCitiesByDepartment(int id) {
        ArrayList<CityModel> cities = queries.consultCitiesByDepartment(id);
        for (int i = 0; i < cities.size(); i++) {
            view.cmbCity.addItem(cities.get(i).getNameCity());
        }
    }

    public void clean() {
        view.txtFirstNameAdd.setText("");
        view.txtLastNameAdd.setText("");
        view.txtEmailAdd.setText("");
        view.cmbDepartment.setSelectedIndex(0);
        view.cmbCity.setSelectedIndex(0);
        view.txtAdressAdd.setText("");
        view.txtPhoneAdd.setText("");
        view.cmbRoles.setSelectedIndex(0);
    }

    private int getCityByName(String nameCity) {
        int selectedDepartmentId = view.cmbDepartment.getSelectedIndex();
        ArrayList<CityModel> cityList = queries.consultCitiesByDepartment(selectedDepartmentId);
        for (CityModel cities : cityList) {
            if (cities.getNameCity().equals(nameCity)) {
                return cities.getIdCity();
            }
        }
        return 0;
    }

}
