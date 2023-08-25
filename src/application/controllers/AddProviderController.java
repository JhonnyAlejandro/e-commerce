package application.controllers;

import application.models.ProviderModel;
import application.views.ProvidersFormView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import application.views.ProvidersView;
import database.QueriesProvider;
import javax.swing.JOptionPane;
import utilities.ValidationsProvider;

public class AddProviderController {

    ProvidersView providersView;
    ProvidersFormView view;
    ProviderModel model = new ProviderModel();

    ValidationsProvider validation = new ValidationsProvider();
    QueriesProvider queries = new QueriesProvider();

    public AddProviderController(ProvidersFormView view, ProvidersView providersView) {
        this.view = view;
        this.providersView = providersView;
        changetitle();
        hideButton();
        events();

    }

    private void events() {

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

                if (validation.checkEmpty(view.txtFirstNameAdd.getText())) {
                    view.txtFirstNameAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorName.setText("Ingresa el nombre correctamente");
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

                        model.setFirstName(view.txtFirstNameAdd.getText());

                        First_Name = true;

                    }
                }  // termina if nombre 

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

                        model.setLastName(view.txtLastNameAdd.getText());

                        Last_Name = true;

                    }
                }// termina if de apellido 

                if (validation.checkEmpty(view.txtEmailAdd.getText())) {
                    view.txtEmailAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorEmail.setText("Ingresa tu dirección de correo electrónico*");
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

                        model.setEmail(view.txtEmailAdd.getText());

                        Email = true;

                    }
                }// termina validacion email 

                if (validation.checkEmpty(view.txtPhoneAdd.getText())) {
                    view.txtPhoneAdd.putClientProperty("FlatLaf.style", "borderColor: #F51D24;");
                    view.lblerrorPhone.setText("Ingresa el número de teléfono correctamente");
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
                        model.setPhone(view.txtPhoneAdd.getText());
                        Phone = true;
                    }
                }//validaciones phone 
                  
//
//                if (validation.checkEmpty(view.txtDepartmentAdd.getText())) {
//                    view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
//                            "borderColor: #F51D24;"
//                    );
//
//                    view.lblerrorDepartment.setText("Ingresa el departamento correctamente");
//                    view.lblerrorDepartment.setVisible(true);
//
//                    System.out.println("bandera 5");
//                } else {
//                    if (!validation.stringCheck(view.txtDepartmentAdd.getText())) {
//                        view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
//                                "borderColor: #F51D24;"
//                        );
//
//                        view.lblerrorDepartment.setText("El departamento tiene caracteres no permitidos");
//                        view.lblerrorDepartment.setVisible(true);
//                    } else {
//
//                        view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
//                                "borderColor: #F3F6FB;"
//                        );
//
//                        view.lblerrorDepartment.setVisible(false);
//
//                        model.setDepartment(view.txtDepartmentAdd.getText());
//
//                        Department = true;
//
//                    }
//                }//termina validaciones de departamento
//
//                if (validation.checkEmpty(view.txtCityAdd.getText())) {
//                    view.txtCityAdd.putClientProperty("FlatLaf.style",
//                            "borderColor: #F51D24;"
//                    );
//
//                    view.lblerrorCity.setText("Ingresa la ciudad correctamente");
//                    view.lblerrorCity.setVisible(true);
//
//                    System.out.println("bandera 6");
//                } else {
//                    if (!validation.stringCheck(view.txtCityAdd.getText())) {
//                        view.txtCityAdd.putClientProperty("FlatLaf.style",
//                                "borderColor: #F51D24;"
//                        );
//
//                        view.lblerrorCity.setText("La ciudad tiene caracteres no permitidos");
//                        view.lblerrorCity.setVisible(true);
//                    } else {
//
//                        view.txtCityAdd.putClientProperty("FlatLaf.style",
//                                "borderColor: #F3F6FB;"
//                        );
//
//                        view.lblerrorCity.setVisible(false);
//
//                        model.setCity(view.txtCityAdd.getText());
//
//                        City = true;
//                    }
//                }//validacion ciudad

                if (validation.checkEmpty(view.txtAdressAdd.getText())) {
                    view.txtAdressAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorAdress.setText("Ingresa la dirección correctamente");
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

                        model.setAddress(view.txtAdressAdd.getText());

                        Addres = true;
                    }
                }//validacion direccion 

                if (First_Name == true && Last_Name == true && Addres == true && City == true && Department == true && Email == true && Phone == true) {
                    if (queries.registrar(model)) {
                        
                        JOptionPane.showMessageDialog(null, "proveedor guardado");
                        ProvidersView providersView = new ProvidersView();
                        new ProvidersController(providersView);
                        providersView.setBounds(0, 0, 800, 700);
                        view.removeAll();
                        view.add(providersView);
                        view.repaint();
                        view.revalidate();

                    } else {
                        JOptionPane.showMessageDialog(null, "error al guardar");

                    }
                }
            }

        });
        view.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                ProvidersView providersView = new ProvidersView();
                new ProvidersController(providersView);
                providersView.setBounds(0, 0, 800, 700);
                view.removeAll();
                view.add(providersView);
                view.repaint();
                view.revalidate();

            }
        });

    }

    private void changetitle() {
        view.lblTitle.setText("Agregar Proveedor");
    }

    private void hideButton() {
        view.btnSave.setVisible(false);
        view.btnDelete.setVisible(false);
    }
}
