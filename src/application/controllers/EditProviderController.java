/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controllers;

import application.models.CityModel;
import application.models.DepartmentModel;
import application.models.ProviderModel;
import application.views.ProvidersFormView;
import application.views.ProvidersView;
import database.QueriesProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilities.PerformActions;
import utilities.ValidationsProvider;

public class EditProviderController {

    ProvidersFormView view;
    ProvidersView providersView;
    ProviderModel model = new ProviderModel();
    QueriesProvider queries = new QueriesProvider();
    ValidationsProvider validation = new ValidationsProvider();

    public EditProviderController(ProvidersFormView view, ProvidersView providersView) {
        this.view = view;
        this.providersView = providersView;
        events();
        changetitle();  //tener en cuenta el orden por que si tiene importancia //
        hideButton();
        loadDepartments();
        loadData();

        this.model = loadData();

    }

    private ProviderModel loadData() {
        ProviderModel model = new ProviderModel();
        Object obj = providersView.tblProvider.getValueAt(providersView.tblProvider.getSelectedRow(), 0);
        int id = (int) obj;

        model = queries.buscar(id);

        view.txtFirstNameAdd.setText(model.getFirstName());
        view.txtLastNameAdd.setText(model.getLastName());
        view.txtPhoneAdd.setText(model.getPhone());
        view.txtAdressAdd.setText(model.getAddress());
        view.txtEmailAdd.setText(model.getEmail());
        view.cmbDepartment.setSelectedIndex(model.getCityModel().getDepartmentId());
        view.cmbCity.setSelectedItem(model.getCityModel().getNameCity());

        return model;

    }

    private void events() {

        view.cmbDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
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

        view.txtPhoneAdd.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!validation.isTextLengthValid(view.txtPhoneAdd.getText(), 9)) {
                    evt.consume(); // Consume el evento solo si la longitud excede 10
                }
            }
        });

        view.btnSave.addActionListener(new ActionListener() {
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

                        model.setFirstName(view.txtFirstNameAdd.getText());

                        First_Name = true;

                    }
                }

                // termina validacion de FirstName
                // Empieza validacion de LastName
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
                }
                // termina validacion de LastName

                // Empieza validacion de email 
                if (validation.emailDomain(view.txtEmailAdd.getText()) == false) {
                    view.txtEmailAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorEmail.setText("Ingresa una dirección de correo electrónico válida");
                    view.lblerrorEmail.setVisible(true);
                } else {
                    view.txtEmailAdd.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.lblerrorEmail.setVisible(false);

                    model.setEmail(view.txtEmailAdd.getText());

                    Email = true;
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
                    model.setPhone(view.txtPhoneAdd.getText());
                    Phone = true;
                }
                //Termina validacion de phone 

                //Inicia validacion de City 
                if (view.cmbDepartment.getSelectedItem().equals("Seleccione un departamento")) {
                    view.cmbDepartment.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );
                    view.cmbCity.putClientProperty("FlatLaf.style",
                            "borderColor: #F51D24;"
                    );

                    view.lblerrorDepartment.setText("Ingresa el departamento correctamente");
                    view.lblerrorDepartment.setVisible(true);
                    view.lblerrorCity.setText("Seleccione una ciudad");
                    view.lblerrorCity.setVisible(true);

                    System.out.println("bandera 5");
                } else {

                    view.cmbDepartment.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );
                    view.cmbCity.putClientProperty("FlatLaf.style",
                            "borderColor: #F3F6FB;"
                    );

                    view.lblerrorDepartment.setVisible(false);
                    view.lblerrorCity.setVisible(false);
                    String selectedCityName = view.cmbCity.getSelectedItem().toString();
                    int selectedIndexCity = getCityByName(selectedCityName);
                    model.setCity(selectedIndexCity);
                    Department = true;
                    City = true;
                    System.out.println("aqui" + model.getLastName());

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
                    model.setAddress(view.txtAdressAdd.getText());
                    Addres = true;

                }
                //T

                if (First_Name == true && Last_Name == true && Addres == true && City == true && Department == true && Email == true && Phone == true) {

                    if (queries.modificar(model)) {

                        JOptionPane.showMessageDialog(null, "error al guardar");

                    } else {

                        JOptionPane.showMessageDialog(null, "proveedor actualizado");

                        ProvidersView providersView = new ProvidersView();
                        new ProvidersController(providersView);
                        providersView.setBounds(0, 0, 800, 700);

                        view.removeAll();
                        view.add(providersView);
                        view.repaint();
                        view.revalidate();

                    }
                }
            }

        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Object[] opciones = {"Sí", "No"};
                Object obj = providersView.tblProvider.getValueAt(providersView.tblProvider.getSelectedRow(), 0);
                int id = (int) obj;
                model.setId(id);
                model.setState(0);

                if (queries.relationship(model) == true) {
                    if (JOptionPane.showOptionDialog(null, "Este proveedor ya está asociado a un producto, ¿está seguro que desea eliminarlo?", null, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]) == JOptionPane.YES_OPTION) {
                        System.out.println("Si");
                        deleteProvider();
                    } else {
                        System.out.println("No");
                    }
                } else if (JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar este proveedor?", null, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]) == JOptionPane.YES_OPTION) {
                    System.out.println("Si");
                    deleteProvider();
                } else {
                    System.out.println("No");
                }

            }
        }
        );

        view.btnCancel.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0
            ) {

                ProvidersView providersView = new ProvidersView();
                new ProvidersController(providersView);
                providersView.setBounds(0, 0, 800, 700);
                view.removeAll();
                view.add(providersView);
                view.repaint();
                view.revalidate();

            }
        }
        );

    }

    private void deleteProvider() {
        if (queries.eliminar(model)) {
            JOptionPane.showMessageDialog(null, "proveedor eliminado");
            ProvidersView providersView = new ProvidersView();
            new ProvidersController(providersView);
            providersView.setBounds(0, 0, 800, 700);
            view.removeAll();
            view.add(providersView);
            view.repaint();
            view.revalidate();

        } else {
            JOptionPane.showMessageDialog(null, "error al eliminar");
        }
    }

    private void changetitle() {
        view.lblTitle.setText("Editar Proveedor");
    }

    private void hideButton() {
        view.btnAdd.setVisible(false);
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
