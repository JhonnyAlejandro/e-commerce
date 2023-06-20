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
                boolean Last_name = false;
                boolean Addres = false;
                boolean City = false;
                boolean department = false;
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

                    }
                }

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

                    }
                }
                if (validation.stringCheck(view.txtEmailAdd.getText())) {
                    view.txtEmailAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorEmail.setText("Ingresa tu dirección de correo electrónico*");
                    view.lblerrorEmail.setVisible(true);
                } else {
                    if (validation.stringCheck(view.txtEmailAdd.getText()) == false) {
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

                    }
                }

                if (validation.checkEmpty(view.txtPhoneAdd.getText())) {
                    view.txtPhoneAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorPhone.setText("Ingresa el número de teléfono correctamente");
                    view.lblerrorPhone.setVisible(true);

                    System.out.println("bandera 4");
                } else {
                    if (!validation.phoneCheck(view.txtPhoneAdd.getText())) {
                        view.txtPhoneAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorPhone.setText("Ingresa un número de teléfono válido (solo dígitos)");
                        view.lblerrorPhone.setVisible(true);
                    }
                }

                if (validation.checkEmpty(view.txtDepartmentAdd.getText())) {
                    view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorDepartment.setText("Ingresa el departamento correctamente");
                    view.lblerrorDepartment.setVisible(true);

                    System.out.println("bandera 5");
                } else {
                    if (!validation.stringCheck(view.txtDepartmentAdd.getText())) {
                        view.txtDepartmentAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorDepartment.setText("El departamento tiene caracteres no permitidos");
                        view.lblerrorDepartment.setVisible(true);
                    }
                }

                if (validation.checkEmpty(view.txtCityAdd.getText())) {
                    view.txtCityAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorCity.setText("Ingresa la ciudad correctamente");
                    view.lblerrorCity.setVisible(true);

                    System.out.println("bandera 6");
                } else {
                    if (!validation.stringCheck(view.txtCityAdd.getText())) {
                        view.txtCityAdd.putClientProperty("FlatLaf.style",
                                "borderColor: #F51D24;"
                        );

                        view.lblerrorCity.setText("La ciudad tiene caracteres no permitidos");
                        view.lblerrorCity.setVisible(true);
                    }
                }

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
                    }
                }
                
//                   if (queries.registrar(model)) {
//                        JOptionPane.showMessageDialog(null, "proveedor guardado");
//                        ProvidersView providersView = new ProvidersView();
//                        new ProvidersController(providersView);
//                        providersView.setBounds(0, 0, 800, 700);
//                        view.removeAll();
//                        view.add(providersView);
//                        view.repaint();
//                        view.revalidate();
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "error al guardar");
//
//                    }

            }

        });

//        view.btnAdd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//
//                boolean emptyFirtsName = validation.checkEmpty(view.txtFirstNameAdd.getText());
//
//                if (emptyFirtsName) {
//                    view.lblerrorName.setVisible(emptyFirtsName);
//                    view.lblerrorName.setText("No puedes dejar el campo vacio");
//                    view.lblerrorLastName.setVisible(false);
//                    view.lblerrorEmail.setVisible(false);
//                    view.lblerrorPhone.setVisible(false);
//                    view.lblerrorDepartment.setVisible(false);
//                    view.lblerrorAdress.setVisible(false);
//                    view.lblerrorCity.setVisible(false);
//                    //view.lblerrorRol.setVisible(false);
//                } else {
//                    boolean emptyLastName = validation.checkEmpty(view.txtLastNameAdd.getText());
//                    if (emptyLastName) {
//                        view.lblerrorLastName.setVisible(emptyLastName);
//                        view.lblerrorLastName.setText("No puedes dejar el campo vacio");
//                        view.lblerrorName.setVisible(false);
//                        view.lblerrorEmail.setVisible(false);
//                        view.lblerrorPhone.setVisible(false);
//                        view.lblerrorDepartment.setVisible(false);
//                        view.lblerrorAdress.setVisible(false);
//                        view.lblerrorCity.setVisible(false);
//                        //view.lblerrorRol.setVisible(false);
//                    } else {
//                        boolean emptyEmail = validation.checkEmpty(view.txtEmailAdd.getText());
//                        if (emptyEmail) {
//                            view.lblerrorEmail.setVisible(emptyEmail);
//                            view.lblerrorEmail.setText("No puedes dejar el campo vacio");
//                            view.lblerrorLastName.setVisible(false);
//                            view.lblerrorName.setVisible(false);
//                            view.lblerrorPhone.setVisible(false);
//                            view.lblerrorDepartment.setVisible(false);
//                            view.lblerrorAdress.setVisible(false);
//                            view.lblerrorCity.setVisible(false);
//                            //view.lblerrorRol.setVisible(false);
//                        } else {
//                            boolean emptyAddress = validation.checkEmpty(view.txtAdressAdd.getText());
//                            if (emptyAddress) {
//                                view.lblerrorAdress.setVisible(emptyAddress);
//                                view.lblerrorAdress.setText("No puedes dejar el campo vacio");
//                                view.lblerrorLastName.setVisible(false);
//                                view.lblerrorEmail.setVisible(false);
//                                view.lblerrorPhone.setVisible(false);
//                                view.lblerrorDepartment.setVisible(false);
//                                view.lblerrorName.setVisible(false);
//                                view.lblerrorCity.setVisible(false);
//                                //view.lblerrorRol.setVisible(false);
//                            } else {
//                                boolean emptyDepartment = validation.checkEmpty(view.txtDepartmentAdd.getText());
//                                if (emptyDepartment) {
//                                    view.lblerrorDepartment.setVisible(emptyDepartment);
//                                    view.lblerrorDepartment.setText("No puedes dejar el campo vacio");
//                                    view.lblerrorLastName.setVisible(false);
//                                    view.lblerrorEmail.setVisible(false);
//                                    view.lblerrorPhone.setVisible(false);
//                                    view.lblerrorName.setVisible(false);
//                                    view.lblerrorAdress.setVisible(false);
//                                    view.lblerrorCity.setVisible(false);
//                                    //view.lblerrorRol.setVisible(false);
//                                } else {
//                                    boolean emptyCity = validation.checkEmpty(view.txtDeparmentAdds.getText());
//                                    if (emptyCity) {
//                                        view.lblerrorCity.setVisible(emptyCity);
//                                        view.lblerrorCity.setText("No puedes dejar el campo vacio");
//                                        view.lblerrorLastName.setVisible(false);
//                                        view.lblerrorEmail.setVisible(false);
//                                        view.lblerrorPhone.setVisible(false);
//                                        view.lblerrorDepartment.setVisible(false);
//                                        view.lblerrorAdress.setVisible(false);
//                                        view.lblerrorName.setVisible(false);
//                                        //view.lblerrorRol.setVisible(false);
//                                    } else {
//                                        boolean emptyPhone = validation.checkEmpty(view.txtPhoneAdd.getText());
//                                        if (emptyPhone) {
//                                            view.lblerrorPhone.setVisible(emptyPhone);
//                                            view.lblerrorPhone.setText("No puedes dejar el campo vacio");
//                                            view.lblerrorLastName.setVisible(false);
//                                            view.lblerrorEmail.setVisible(false);
//                                            view.lblerrorName.setVisible(false);
//                                            view.lblerrorDepartment.setVisible(false);
//                                            view.lblerrorAdress.setVisible(false);
//                                            view.lblerrorCity.setVisible(false);
//                                            //view.lblerrorRol.setVisible(false);
//                                        } else {
//                                            boolean nameCorrect = validation.stringCheck(view.txtFirstNameAdd.getText());
//                                            if (!nameCorrect) {
//                                                view.lblerrorName.setVisible(!nameCorrect);
//                                                view.lblerrorName.setText("El nombre tiene caracteres no permitidos (1-9,@,$,%,&,?)");
//                                                view.lblerrorLastName.setVisible(false);
//                                                view.lblerrorEmail.setVisible(false);
//                                                view.lblerrorPhone.setVisible(false);
//                                                view.lblerrorDepartment.setVisible(false);
//                                                view.lblerrorAdress.setVisible(false);
//                                                view.lblerrorCity.setVisible(false);
//                                                //view.lblerrorRol.setVisible(false);
//                                            } else {
//                                                boolean lastNameCorrect = validation.stringCheck(view.txtLastNameAdd.getText());
//                                                if (!lastNameCorrect) {
//                                                    view.lblerrorLastName.setVisible(!lastNameCorrect);
//                                                    view.lblerrorLastName.setText("El apellido tiene caracteres no permitidos (1-9,@,$,%,&,?)");
//                                                    view.lblerrorName.setVisible(false);
//                                                    view.lblerrorEmail.setVisible(false);
//                                                    view.lblerrorPhone.setVisible(false);
//                                                    view.lblerrorDepartment.setVisible(false);
//                                                    view.lblerrorAdress.setVisible(false);
//                                                    view.lblerrorCity.setVisible(false);
//                                                    //view.lblerrorRol.setVisible(false);
//                                                } else {
//                                                    boolean departmentCorrect = validation.stringCheck(view.txtDepartmentAdd.getText());
//                                                    if (!departmentCorrect) {
//                                                        view.lblerrorDepartment.setVisible(!departmentCorrect);
//                                                        view.lblerrorDepartment.setText("El departamento tiene caracteres no permitidos (1-9,@,$,%,&,?)");
//                                                        view.lblerrorLastName.setVisible(false);
//                                                        view.lblerrorEmail.setVisible(false);
//                                                        view.lblerrorPhone.setVisible(false);
//                                                        view.lblerrorName.setVisible(false);
//                                                        view.lblerrorAdress.setVisible(false);
//                                                        view.lblerrorCity.setVisible(false);
//                                                        //view.lblerrorRol.setVisible(false);
//                                                    } else {
//                                                        boolean cityCorrect = validation.stringCheck(view.txtDeparmentAdds.getText());
//                                                        if (!cityCorrect) {
//                                                            view.lblerrorCity.setVisible(!cityCorrect);
//                                                            view.lblerrorCity.setText("La ciudad tiene caracteres no permitidos (1-9,@,$,%,&,?)");
//                                                            view.lblerrorLastName.setVisible(false);
//                                                            view.lblerrorEmail.setVisible(false);
//                                                            view.lblerrorPhone.setVisible(false);
//                                                            view.lblerrorDepartment.setVisible(false);
//                                                            view.lblerrorAdress.setVisible(false);
//                                                            view.lblerrorName.setVisible(false);
//                                                            //view.lblerrorRol.setVisible(false);
//                                                        } else {
//                                                            boolean phoneCorrect = validation.phoneCheck(view.txtPhoneAdd.getText());
//                                                            if (!phoneCorrect) {
//                                                                view.lblerrorPhone.setVisible(!phoneCorrect);
//                                                                view.lblerrorPhone.setText("el numero de celular tiene caracteres no permitidos (a-z,#,$,%,&,/,-)");
//                                                                view.lblerrorLastName.setVisible(false);
//                                                                view.lblerrorEmail.setVisible(false);
//                                                                view.lblerrorName.setVisible(false);
//                                                                view.lblerrorDepartment.setVisible(false);
//                                                                view.lblerrorAdress.setVisible(false);
//                                                                view.lblerrorCity.setVisible(false);
//                                                                //view.lblerrorRol.setVisible(false);
//                                                            } else {
//                                                                boolean domainCorrect = validation.emailDomain(view.txtEmailAdd.getText());
//                                                                if (!domainCorrect) {
//                                                                    view.lblerrorEmail.setVisible(!domainCorrect);
//                                                                    view.lblerrorEmail.setText("El correo electronico no tiene el dominio correcto");
//                                                                    view.lblerrorLastName.setVisible(false);
//                                                                    view.lblerrorName.setVisible(false);
//                                                                    view.lblerrorPhone.setVisible(false);
//                                                                    view.lblerrorDepartment.setVisible(false);
//                                                                    view.lblerrorAdress.setVisible(false);
//                                                                    view.lblerrorCity.setVisible(false);
//                                                                    //view.lblerrorRol.setVisible(false);
//                                                                } else {
//                                                                    boolean addressCorrect = validation.addressCheck(view.txtAdressAdd.getText());
//                                                                    if (!addressCorrect) {
//                                                                        view.lblerrorAdress.setVisible(!addressCorrect);
//                                                                        view.lblerrorAdress.setText("la direccion tiene caracteres no permitidos");
//                                                                        view.lblerrorLastName.setVisible(false);
//                                                                        view.lblerrorEmail.setVisible(false);
//                                                                        view.lblerrorPhone.setVisible(false);
//                                                                        view.lblerrorDepartment.setVisible(false);
//                                                                        view.lblerrorName.setVisible(false);
//                                                                        view.lblerrorCity.setVisible(false);
//                                                                        //view.lblerrorRol.setVisible(false);
//                                                                    } else {
//
//                                                                        model.setFirstName(view.txtFirstNameAdd.getText());
//                                                                        model.setLastName(view.txtLastNameAdd.getText());
//                                                                        model.setAddress(view.txtAdressAdd.getText());
//                                                                        model.setCity(view.txtDeparmentAdds.getText());
//                                                                        model.setPhone(view.txtPhoneAdd.getText());
//                                                                        model.setDepartment(view.txtDepartmentAdd.getText());
//                                                                        model.setEmail(view.txtEmailAdd.getText());
//                                                                        model.setState(1);
//
//                                                                    }
//                                                                    if (queries.registrar(model)) {
//                                                                        
//                                                                        JOptionPane.showMessageDialog(null, "proveedor guardado");
//                                                                        ProvidersView providersView = new ProvidersView();
//                                                                        new ProvidersController(providersView);
//                                                                        providersView.setBounds(0, 0, 800, 700);
//                                                                        view.removeAll();
//                                                                        view.add(providersView);
//                                                                        view.repaint();
//                                                                        view.revalidate();
//
//                                                                    } else {
//                                                                       
//
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        });
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
