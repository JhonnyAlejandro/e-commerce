package application.controllers;

import application.models.CityModel;
import application.models.UsersModel;
import application.views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import application.views.ProfileView;
import application.views.DashboardView;
import database.QueriesProfile;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import utilities.ManipulateText;
import utilities.Session;
//import utilities.Session;
import utilities.Validations;

public class ProfileController {

    ProfileView view;
    DashboardView viewDash;
    LoginView viewLogin = new LoginView();
    UsersModel modelUsers = new UsersModel();
    Validations validations = new Validations();
    QueriesProfile consulta = new QueriesProfile();
    UsersModel upUser = new UsersModel();
    String citiesUser;
    ArrayList cities = new ArrayList();
    String departmentUser;
    ArrayList departments = new ArrayList();

    public ProfileController(DashboardView viewDash, ProfileView view) {
        this.view = view;
        this.viewDash = viewDash;

        view.jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        view.jScrollPane1.getVerticalScrollBar().setBlockIncrement(40);
        
        events();
        setPersonal();
        setAddress();
    }

    public void events() {

        view.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences prefs = Preferences.userNodeForPackage(LoginController.class);
                prefs.remove("rememberPassword");
                prefs.remove("email");
                prefs.remove("password");
                System.out.println(".actionPerformed()");
                viewDash.dispose();
                new LoginController(modelUsers, viewLogin);

            }
        });

        view.tbtEditPersonal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (view.tbtEditPersonal.isSelected()) {
                    habilitarPersonal();
                    view.btnSavePersonal.setEnabled(true);
                    view.tbtEditPersonal.setText("Cancelar");
                    view.tbtEditPersonal.putClientProperty("FlatLaf.style",
                        "foreground: #FFF;"
                        + "background: #F51D24;"
                        + "hoverBackground: darken(#F51D24,5%);"
                    );
                } else {
                    view.btnSavePersonal.setEnabled(false);
                    deshabilitarPersonal();
                    view.tbtEditPersonal.setText("Editar");
                    view.tbtEditPersonal.putClientProperty("FlatLaf.style",
                        "foreground: #FFF;"
                        + "background: #1D90F5;"
                        + "hoverBackground: darken(#1D90F5,5%);"
                    );
                    setPersonal();
                }

            }
        });

        view.btnSavePersonal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (validations.validateEmptyField(view.txtFirstName.getText()) == true) {
                    view.lblErrorFirstName.setText("Error! Debes colocar tu/s nombre/s.");
                } else if (validations.validateEmptyField(view.txtLastName.getText()) == true) {
                    view.lblErrorLastName.setText("Error! Debes colocar tu/s apellido/s.");
                } else if (validations.validateEmptyField(view.txtEmail.getText()) == true) {
                    view.lblErrorEmail.setText("Error! Debes colocar un correo.");
                } else if (validations.validateEmail(view.txtEmail.getText()) == false) {
                    view.lblErrorEmail.setText("Error! Debes colocar un email válido.");
                } else if (validations.validateEmptyField(view.txtPhone.getText()) == true) {
                    view.lblErrorEmail.setText("Error! Debes colocar un teléfono.");
                } else {
                    UsersModel newModelo = new UsersModel();
                    newModelo.setFirstName(view.txtFirstName.getText());
                    newModelo.setLastName(view.txtLastName.getText());
                    newModelo.setPhone(view.txtPhone.getText());
                    newModelo.setEmail(view.txtEmail.getText());

                    if (consulta.updatePersonal(newModelo)) {
                        deshabilitarPersonal();
                        view.btnSavePersonal.setEnabled(false);
                        if (view.tbtEditPersonal.isSelected() == true) {
                            view.btnSavePersonal.setEnabled(false);
                            setPersonal();
                            deshabilitarPersonal();
                            view.tbtEditPersonal.setText("Editar");
                            view.tbtEditPersonal.setSelected(false);
                        }
                        view.tbtEditPersonal.putClientProperty("FlatLaf.style",
                            "foreground: #FFF;"
                            + "background: #1D90F5;"
                            + "hoverBackground: darken(#1D90F5,5%);"
                        );
//                        DashboardView view = new DashboardView();
//                        ManipulateText manipulateText = new ManipulateText();
//                        String text = manipulateText.getFirstWord(Session.userModel.getFirstName()) + " " + manipulateText.getFirstWord(Session.userModel.getLastName());
//                        view.jButton3.setText(text);
//                        if (text.length() > 12) {
//                            view.jButton3.setText(text.substring(0, 12) + "...");
//                        }
                    } else {
                        deshabilitarPersonal();
                        view.btnSavePersonal.setEnabled(false);
                    }
                }
            }
        });

        view.tbtEditAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (view.tbtEditAddress.isSelected()) {
                    habilitarAddress();
                    view.btnSaveAddress.setEnabled(true);
                    view.tbtEditAddress.setText("Cancelar");
                    view.tbtEditAddress.putClientProperty("FlatLaf.style",
                        "foreground: #FFF;"
                        + "background: #F51D24;"
                        + "hoverBackground: darken(#F51D24,5%);"
                    );
                } else {
                    view.btnSaveAddress.setEnabled(false);
                    deshabilitarAddress();
                    view.tbtEditAddress.setText("Editar");
                    view.tbtEditAddress.putClientProperty("FlatLaf.style",
                        "foreground: #FFF;"
                        + "background: #1D90F5;"
                        + "hoverBackground: darken(#1D90F5,5%);"
                    );
                    setAddress();
                }

            }
        });

        view.btnSaveAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (validations.validateEmptyField(view.txtAddress.getText()) == true) {
                    view.lblErrorAddress.setText("Error! Debes colocar una dirección de residencia.");
                } else {
                    UsersModel newModelo = new UsersModel();
                    CityModel cityModel = new CityModel();
                    cityModel.setNameCity(view.cmbCity.getSelectedItem().toString());
                    newModelo.setCityModel(cityModel);
                    newModelo.setAddress(view.txtAddress.getText());
                    if (consulta.updateAddress(newModelo)) {
                        deshabilitarAddress();
                        view.btnSaveAddress.setEnabled(false);
                        if (view.tbtEditAddress.isSelected() == true) {
                            view.btnSaveAddress.setEnabled(false);
                            setAddress();
                            deshabilitarAddress();
                            view.tbtEditAddress.setText("Editar");
                            view.tbtEditAddress.setSelected(false);
                        }
                        view.tbtEditAddress.putClientProperty("FlatLaf.style",
                            "foreground: #FFF;"
                            + "background: #1D90F5;"
                            + "hoverBackground: darken(#1D90F5,5%);"
                        );
                    } else {
                        deshabilitarAddress();
                        view.btnSaveAddress.setEnabled(false);
                    }
                }
            }
        });
        
        view.cmbDepartment.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    if (view.cmbDepartment.getSelectedIndex() > 0) {
                        view.cmbCity.setModel(new DefaultComboBoxModel(consulta.getCities(view.cmbDepartment.getSelectedIndex())));
                    } else {
                        System.out.println(view.cmbDepartment.getSelectedIndex());
                        view.cmbCity.setModel(new DefaultComboBoxModel(new String[]{"Seleccionar país"}));
                    }
                }
            }
        });
    }

    public void deshabilitarPersonal() {
        view.txtFirstName.setEnabled(false);
        view.txtLastName.setEnabled(false);
        view.txtEmail.setEnabled(false);
        view.txtPhone.setEnabled(false);
    }

    public void habilitarPersonal() {
        view.txtFirstName.setEnabled(true);
        view.txtLastName.setEnabled(true);
        view.txtEmail.setEnabled(true);
        view.txtPhone.setEnabled(true);
    }

    public void deshabilitarAddress() {
        view.cmbCity.setEnabled(false);
        view.cmbDepartment.setEnabled(false);
        view.txtAddress.setEnabled(false);
    }

    public void habilitarAddress() {
        view.cmbCity.setEnabled(true);
        view.cmbDepartment.setEnabled(true);
        view.txtAddress.setEnabled(true);
    }

    public void setPersonal() {
        upUser = consulta.getUser();
        view.txtFirstName.setText(upUser.getFirstName());
        view.txtLastName.setText(upUser.getLastName());
        view.txtEmail.setText(upUser.getEmail());
        view.txtPhone.setText(upUser.getPhone());
    }

    public void setAddress() {
        upUser = consulta.getUser();
        departmentUser = consulta.getDeparmentUser();
        if (departments.isEmpty()) {
            departments = consulta.getDeparments();
            for (int i = 0; i < departments.size(); i++) {
                view.cmbDepartment.addItem(departments.get(i).toString());
            }
        }
        view.txtAddress.setText(upUser.getAddress());
        if (upUser.getCityModel().getNameCity().isEmpty() || upUser.getCityModel().getNameCity() == null) {
            //
        } else {
            view.cmbDepartment.setSelectedItem(departmentUser);
            view.cmbCity.setSelectedItem(upUser.getCityModel().getNameCity());
        }
    }
}
