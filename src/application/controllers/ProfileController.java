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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import utilities.ManipulateText;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import utilities.ValidationsProfile;

public class ProfileController {

    ProfileView view;
    DashboardView viewDash;
    LoginView viewLogin = new LoginView();
    UsersModel modelUsers = new UsersModel();
    ValidationsProfile validations = new ValidationsProfile();
    QueriesProfile consulta = new QueriesProfile();
    UsersModel upUser = new UsersModel();
    String citiesUser;
    ArrayList cities = new ArrayList();
    String departmentUser;
    ArrayList departments = new ArrayList();
    boolean firstName = false;
    boolean lastName = false;
    boolean address = false;
    boolean city = false;
    boolean department = false;
    boolean email = false;
    boolean phone = false;

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
                    setColorNormal(null, null, null, view.btnSavePersonal);
                    view.tbtEditPersonal.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/cancel-fff.png")));
                    view.tbtEditPersonal.setText("Cancelar");
                    setColorRed(null, null, view.tbtEditPersonal);
                } else {
                    setVisibleLblPersonal();
                    setColorNormal(view.txtFirstName, null, null, null);
                    setColorNormal(view.txtLastName, null, null, null);
                    setColorNormal(view.txtEmail, null, null, null);
                    setColorNormal(view.txtPhone, null, null, null);
                    view.btnSavePersonal.setEnabled(false);
                    deshabilitarPersonal();
                    view.tbtEditPersonal.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/edit-fff.png")));
                    view.tbtEditPersonal.setText("Editar");
                    setColorNormal(null, null, view.tbtEditPersonal, null);
                    setPersonal();
                }

            }
        });

        view.btnSavePersonal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setVisibleLblPersonal();
                setColorNormal(view.txtFirstName, null, null, null);
                setColorNormal(view.txtLastName, null, null, null);
                setColorNormal(view.txtEmail, null, null, null);
                setColorNormal(view.txtPhone, null, null, null);
                //validación de nombre
                if (view.txtFirstName.getText().length() > 40) {
                    setColorRed(view.txtPhone, null, null);
                    view.lblErrorPhone.setVisible(true);
                    view.lblErrorPhone.setText("El campo tiene no permite más de 40 carácteres.");
                } else if (validations.validateEmptyField(view.txtFirstName.getText())) {
                    setColorRed(view.txtFirstName, null, null);
                    view.lblErrorFirstName.setVisible(true);
                    view.lblErrorFirstName.setText("No se puede dejar el campo vacío.");
                } else if (!validations.validateString(view.txtFirstName.getText())) {
                    setColorRed(view.txtFirstName, null, null);
                    view.lblErrorFirstName.setVisible(true);
                    view.lblErrorFirstName.setText("El nombre tiene caracteres no permitidos (1-9,@,$,%,&,?");
                } else {
                    firstName = true;
                }
                    
                    
                //validación de apellido
                if (view.txtLastName.getText().length() > 40) {
                    setColorRed(view.txtPhone, null, null);
                    view.lblErrorPhone.setVisible(true);
                    view.lblErrorPhone.setText("El campo tiene no permite más de 40 carácteres.");
                } else if (validations.validateEmptyField(view.txtLastName.getText())) {
                    setColorRed(view.txtLastName, null, null);
                    view.lblErrorLastName.setVisible(true);
                    view.lblErrorLastName.setText("No se puede dejar el campo vacío.");

                } else if (!validations.validateString(view.txtLastName.getText())) {
                    setColorRed(view.txtLastName, null, null);
                    view.lblErrorLastName.setVisible(true);
                    view.lblErrorLastName.setText("El apellido tiene caracteres no permitidos (1-9,@,$,%,&,?");
                } else {
                    lastName = true;
                }                
                        
                //validación de email
                if (view.txtPhone.getText().length() > 95) {
                    setColorRed(view.txtPhone, null, null);
                    view.lblErrorPhone.setVisible(true);
                    view.lblErrorPhone.setText("El campo tiene no permite más de 95 carácteres.");
                } else if (validations.validateEmptyField(view.txtEmail.getText())) {
                    setColorRed(view.txtEmail, null, null);
                    view.lblErrorEmail.setVisible(true);
                    view.lblErrorEmail.setText("No se puede dejar el campo vacío.");
                } else if (!validations.validateEmail(view.txtEmail.getText())) {
                    setColorRed(view.txtEmail, null, null);
                    view.lblErrorEmail.setVisible(true);
                    view.lblErrorEmail.setText("Ingresa una dirección de correo electrónico válida.");
                } else {
                    email = true;
                }
                        
                //validación de teléfono
                if (view.txtPhone.getText().length() > 10) {
                    setColorRed(view.txtPhone, null, null);
                    view.lblErrorPhone.setVisible(true);
                    view.lblErrorPhone.setText("El campo tiene no permite más de 10 dígitos.");
                } else if (!validations.validatePhone(view.txtPhone.getText())) {
                    setColorRed(view.txtPhone, null, null);
                    view.lblErrorPhone.setVisible(true);
                    view.lblErrorPhone.setText("Ingresa un número de teléfono válido (solo dígitos).");
                } else {
                    phone = true;
                }
                //intento de guardado
                if (firstName && lastName && email && phone) {
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
                            view.tbtEditPersonal.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/edit-fff.png")));
                            view.tbtEditPersonal.setText("Editar");
                            view.tbtEditPersonal.setSelected(false);
                        }
                        setColorNormal(null, null, view.tbtEditPersonal, null);
                        setColorNormal(null, null, null, view.btnSavePersonal);
                        ManipulateText manipulateText = new ManipulateText();
                        String text = manipulateText.getFirstWord(newModelo.getFirstName()) + " " + manipulateText.getFirstWord(newModelo.getLastName());
                        viewDash.jButton3.setText(text);
                        if (text.length() > 12) {
                            viewDash.jButton3.setText(text.substring(0, 12) + "...");
                        }
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
                    setColorNormal(null, null, null, view.btnSaveAddress);
                    view.tbtEditAddress.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/cancel-fff.png")));
                    view.tbtEditAddress.setText("Cancelar");
                    setColorRed(null, null, view.tbtEditAddress);
                } else {
                    setVisibleLblAddress();
                    setColorNormal(view.txtAddress, null, null, null);
                    setColorNormal(null, view.cmbDepartment, null, null);
                    setColorNormal(null, view.cmbCity, null, null);
                    view.btnSaveAddress.setEnabled(false);
                    deshabilitarAddress();
                    view.tbtEditAddress.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/edit-fff.png")));
                    view.tbtEditAddress.setText("Editar");
                    setColorNormal(null, null, view.tbtEditAddress, null);
                    setAddress();
                }

            }
        });

        view.btnSaveAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setVisibleLblAddress();
                setColorNormal(view.txtAddress, null, null, null);
                setColorNormal(null, view.cmbDepartment, null, null);
                setColorNormal(null, view.cmbCity, null, null);
                //validación de dirección de residencia
                if (validations.validateEmptyField(view.txtAddress.getText())) {
                    setColorRed(view.txtAddress, null, null);
                    view.lblErrorAddress.setVisible(true);
                    view.lblErrorAddress.setText("No se puede dejar el campo vacío.");
                } else if (!validations.validateAddress(view.txtAddress.getText())) {
                    setColorRed(view.txtAddress, null, null);
                    view.lblErrorAddress.setVisible(true);
                    view.lblErrorAddress.setText("La dirección tiene un formato incorrecto.");
                } else {
                    address = true;
                }
                    
                //validación de departamento
                if (view.cmbDepartment.getSelectedIndex() < 1) {
                    setColorRed(null, view.cmbDepartment, null);
                    view.lblErrorDepartment.setVisible(true);
                    view.lblErrorDepartment.setText("Debes seleccionar un departamento.");
                } else {
                    department = true;
                }
                    
                //validación de ciudad
                if (view.cmbCity.getSelectedIndex() < 1) {
                    setColorRed(null, view.cmbCity, null);
                    view.lblErrorCity.setVisible(true);
                    view.lblErrorCity.setText("Debes seleccionar una ciudad");
                } else {
                    city = true;
                }
                        
                if (address && city && department) {
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
                            view.tbtEditAddress.setIcon(new ImageIcon(getClass().getResource("/main/assets/images/edit-fff.png")));
                            view.tbtEditAddress.setText("Editar");
                            view.tbtEditAddress.setSelected(false);
                        }
                        setColorNormal(null, null, null, view.btnSaveAddress);
                        setColorNormal(null, null, view.tbtEditAddress, null);
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
                        view.cmbCity.setModel(new DefaultComboBoxModel(new String[]{"Seleccione una ciudad"}));
                    }
                }
            }
        });
    }
    
    public void setColorRed (JTextField txt, JComboBox cmb, JToggleButton tbt) {
        if (txt != null) {
            txt.putClientProperty("FlatLaf.style",
                    "borderColor: #F51D24;"
            );
        } else if (cmb != null) {
            cmb.putClientProperty("FlatLaf.style",
                    "borderColor: #F51D24;"
            );
        } else {
            tbt.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #F51D24;"
                + "hoverBackground: darken(#F51D24,5%);"
            ); 
        }
    }
    
    public void setColorNormal (JTextField txt, JComboBox cmb, JToggleButton tbt, JButton btn) {
        if (txt != null) {
            txt.putClientProperty("FlatLaf.style",
                "borderColor: #F3F6FB;"
            );
        } else if (cmb != null) {
            cmb.putClientProperty("FlatLaf.style",
                "borderColor: #F3F6FB;"
            );
        } else if (tbt != null) {
            tbt.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
            );
        } else {
            btn.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
            );
        }
    }

    public void setVisibleLblPersonal () {
        view.lblErrorEmail.setVisible(false);
        view.lblErrorFirstName.setVisible(false);
        view.lblErrorLastName.setVisible(false);
        view.lblErrorPhone.setVisible(false);
    }
    
    public void setVisibleLblAddress () {
        view.lblErrorCity.setVisible(false);
        view.lblErrorDepartment.setVisible(false);
        view.lblErrorAddress.setVisible(false);
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
