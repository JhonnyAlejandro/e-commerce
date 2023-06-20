package application.controllers;

import application.models.UsersModel;
import application.views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import application.views.ProfileView;
import application.views.DashboardView;
import database.QueriesProfile;
import utilities.Session;
import utilities.Validations;

public class ProfileController {

    ProfileView view;
    DashboardView viewDash;
    LoginView viewLogin = new LoginView();
    UsersModel modelUsers = new UsersModel();
    Validations validations = new Validations();
    QueriesProfile consulta = new QueriesProfile();
    UsersModel upUser = new UsersModel();

    public ProfileController(DashboardView viewDash,ProfileView view) {
        this.view = view;
        this.viewDash = viewDash;
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
        
        view.tbtEditPersonal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (view.tbtEditPersonal.isSelected())
                {
                    habilitarPersonal();
                    view.btnSavePersonal.setEnabled(true);
                    view.tbtEditPersonal.setText("Cancelar");
                }
                else
                {
                    view.btnSavePersonal.setEnabled(false);
                    deshabilitarPersonal();
                    view.tbtEditPersonal.setText("Editar");
                }

            }
        });
        
        view.btnSavePersonal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(validations.validateEmptyField(view.txtFirstName.getText()) == true)
                {
                    view.lblErrorFirstName.setText("Error! Debes colocar tu/s nombre/s.");
                }
                else if(validations.validateEmptyField(view.txtLastName.getText()) == true)
                {
                    view.lblErrorLastName.setText("Error! Debes colocar tu/s apellido/s.");
                }
                else if(validations.validateEmptyField(view.txtEmail.getText()) == true)
                {
                    view.lblErrorEmail.setText("Error! Debes colocar un correo.");
                }
                else if(validations.validateEmail(view.txtEmail.getText()) == false)
                {
                    view.lblErrorEmail.setText("Error! Debes colocar un email válido.");
                }
                else if(validations.validateEmptyField(view.txtPhone.getText()) == true)
                {
                    view.lblErrorEmail.setText("Error! Debes colocar un teléfono.");
                }
                else
                {
                    UsersModel newModelo = new UsersModel();
                    newModelo.setFirstName(view.txtFirstName.getText());
                    newModelo.setLastName(view.txtLastName.getText());
                    newModelo.setPhone(view.txtPhone.getText());
                    newModelo.setEmail(view.txtEmail.getText());

                    if (consulta.updatePersonal(newModelo))
                    {
                        deshabilitarPersonal();
                        view.btnSavePersonal.setEnabled(false);
                        if(view.tbtEditPersonal.isSelected() == true)
                        {
                            view.btnSavePersonal.setEnabled(false);
                            setPersonal();
                            deshabilitarPersonal();
                            view.tbtEditPersonal.setText("Editar");
                            view.tbtEditPersonal.setSelected(false);
                        }
                    }
                    else
                    {
                        deshabilitarPersonal();
                        view.btnSavePersonal.setEnabled(false);
                    }
                }
            }
        });
        
        view.tbtEditAddress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (view.tbtEditAddress.isSelected())
                {
                    habilitarAddress();
                    view.btnSaveAddress.setEnabled(true);
                    view.tbtEditAddress.setText("Cancelar");
                }
                else
                {
                    view.btnSaveAddress.setEnabled(false);
                    deshabilitarAddress();
                    view.tbtEditAddress.setText("Editar");
                }

            }
        });
        
        view.btnSaveAddress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(validations.validateEmptyField(view.txtDepartment.getText()) == true)
                {
                    view.lblErrorDepartment.setText("Error! Debes un departamento.");
                }
                else if(validations.validateEmptyField(view.txtCity.getText()) == true)
                {
                    view.lblErrorCity.setText("Error! Debes colocar una ciudad.");
                }
                else if(validations.validateEmptyField(view.txtAddress.getText()) == true)
                {
                    view.lblErrorAddress.setText("Error! Debes colocar una dirección de residencia.");
                }
                else
                {
                    UsersModel newModelo = new UsersModel();
                    newModelo.setDepartment(view.txtDepartment.getText());
                    newModelo.setCity(view.txtCity.getText());
                    newModelo.setAddress(view.txtAddress.getText());

                    if (consulta.updateAddress(newModelo))
                    {
                        deshabilitarAddress();
                        view.btnSaveAddress.setEnabled(false);
                        if(view.tbtEditAddress.isSelected() == true)
                        {
                            view.btnSaveAddress.setEnabled(false);
                            setAddress();
                            deshabilitarAddress();
                            view.tbtEditAddress.setText("Editar");
                            view.tbtEditAddress.setSelected(false);
                        }
                    }
                    else
                    {
                        deshabilitarAddress();
                        view.btnSaveAddress.setEnabled(false);
                    }
                }
            }
        });
    }
    
    public void getUsers()
    {
        upUser = consulta.getUser();
    }
    
    public void deshabilitarPersonal()
    {
        view.txtFirstName.setEnabled(false);
        view.txtLastName.setEnabled(false);
        view.txtEmail.setEnabled(false);
        view.txtPhone.setEnabled(false);
       
    }
        
    public void habilitarPersonal()
    {
        view.txtFirstName.setEnabled(true);
        view.txtLastName.setEnabled(true);
        view.txtEmail.setEnabled(true);
        view.txtPhone.setEnabled(true);
        
    }
    
    public void deshabilitarAddress()
    {
        view.txtCity.setEnabled(false);
        view.txtDepartment.setEnabled(false);
        view.txtAddress.setEnabled(false);
    }
        
    public void habilitarAddress()
    {
        view.txtCity.setEnabled(true);
        view.txtDepartment.setEnabled(true);
        view.txtAddress.setEnabled(true);
    }
    
    public void setPersonal(){
        getUsers();
        view.txtFirstName.setText(upUser.getFirstName());
        view.txtLastName.setText(upUser.getLastName());
        view.txtEmail.setText(upUser.getEmail());
        view.txtPhone.setText(upUser.getPhone());
    }
    
    public void setAddress(){
        getUsers();
        view.txtAddress.setText(upUser.getAddress());
        view.txtCity.setText(upUser.getCity());
        view.txtDepartment.setText(upUser.getDepartment());
    }

}
