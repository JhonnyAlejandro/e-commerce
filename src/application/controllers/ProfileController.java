package application.controllers;

import application.models.UsersModel;
import application.views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import application.views.ProfileView;
import application.views.DashboardView;
import utilities.Validations;

public class ProfileController {

    ProfileView view;
    DashboardView viewDash;
    LoginView viewLogin = new LoginView();
    UsersModel modelUsers = new UsersModel();
    Validations validations = new Validations();

    public ProfileController(DashboardView viewDash,ProfileView view) {
        this.view = view;
        this.viewDash = viewDash;
        events();
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
                else if(validations.validateEmptyField(view.txtPhone.getText()) == true)
                {
                    view.lblErrorEmail.setText("Error! Debes un teléfono.");
                }
                else if(validations.validateEmail(view.txtEmail.getText()))
                {
//                    panPerfil.lblError.setText("Error! Debes colocar un departamento.");
                }
                UsersModel modelo = new UsersModel();
                modelo.setFirstName(view.txtFirstName.getText());
                modelo.setLastName(view.txtLastName.getText());
                modelo.setPhone(view.txtPhone.getText());
                modelo.setEmail(view.txtEmail.getText());
//                modelo.set(view.cmbRol.getSelectedItem().toString());

            }
        });
        
        view.tbtEditAddress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (view.tbtEditPersonal.isSelected())
                {
                    habilitarAddress();
                    view.btnSaveAddress.setEnabled(true);
                    view.tbtEditPersonal.setText("Cancelar");
                }
                else
                {
                    view.btnSaveAddress.setEnabled(false);
                    deshabilitarPersonal();
                    view.tbtEditPersonal.setText("Editar");
                }

            }
        });
        
        view.btnSaveAddress.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (view.tbtEditPersonal.isSelected())
                {
                    habilitarAddress();
                    view.btnSaveAddress.setEnabled(true);
                    view.tbtEditPersonal.setText("Cancelar");
                }
                else
                {
                    view.btnSaveAddress.setEnabled(false);
                    deshabilitarPersonal();
                    view.tbtEditPersonal.setText("Editar");
                }

            }
        });
    }
            
    public void deshabilitarPersonal()
    {
        view.txtFirstName.setEnabled(false);
        view.txtLastName.setEnabled(false);
        view.txtEmail.setEnabled(false);
        view.txtPhone.setEnabled(false);
        view.cmbRole.setEnabled(false);
    }
        
    public void habilitarPersonal()
    {
        view.txtFirstName.setEnabled(true);
        view.txtLastName.setEnabled(true);
        view.txtEmail.setEnabled(true);
        view.txtPhone.setEnabled(true);
        view.cmbRole.setEnabled(true);
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

}
