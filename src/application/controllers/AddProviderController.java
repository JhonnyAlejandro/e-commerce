package application.controllers;

import application.models.CityModel;
import application.models.DepartmentModel;
import application.models.ProviderModel;
import application.views.ProvidersFormView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import application.views.ProvidersView;
import database.QueriesProvider;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import utilities.ValidationsProvider;

public class AddProviderController {

    ProvidersView providersView;
    ProvidersFormView view;
    ProviderModel model = new ProviderModel();
    DepartmentModel department = new DepartmentModel();

    ValidationsProvider validation = new ValidationsProvider();
    QueriesProvider queries = new QueriesProvider();

    public AddProviderController(ProvidersFormView view, ProvidersView providersView) {
        this.view = view;
        this.providersView = providersView;
        changetitle();
        hideButton();
        loadDepartments();
        events();

    }

    private void events() {

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

        view.txtPhoneAdd.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (!validation.isTextLengthValid(view.txtPhoneAdd.getText(), 9)) {
                    evt.consume(); // Consume el evento solo si la longitud excede 10
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
                        System.out.println("aqui" + model.getFirstName());

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
                        System.out.println("aqui" + model.getFirstName());

                    }
                }// termina if de apellido 

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

                        model.setEmail(view.txtEmailAdd.getText());

                        Email = true;

                    }
                }

                //inicia validacion phone
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

                //termina validacion phone
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

                    view.lblerrorDepartment.setVisible(false);
                    view.lblerrorCity.setVisible(false);
                    String selectedCityName = view.cmbCity.getSelectedItem().toString();
                    int selectedIndexCity = getCityByName(selectedCityName);
                    model.setCity(selectedIndexCity);
                    Department = true;
                    City = true;
                    System.out.println("aqui" + model.getLastName());

                }//termina validaciones de departamento

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
                    System.out.println("aqui" + model.getAddress());

                }
                //validacion direccion 

                if (First_Name == true && Last_Name == true && Addres == true && City == true && Department == true && Email == true && Phone == true) {
                    if (queries.registrar(model)) {
                        System.out.println("aquiii");
                        JOptionPane.showMessageDialog(null, "proveedor guardado");
                        ProvidersView providersView = new ProvidersView();
                        ProvidersController providerController = new ProvidersController(providersView);
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

    public void clean() {
        view.txtFirstNameAdd.setText("");
        view.txtLastNameAdd.setText("");
        view.txtEmailAdd.setText("");
        view.cmbDepartment.setSelectedIndex(0);
        view.cmbCity.setSelectedIndex(0);
        view.txtAdressAdd.setText("");
        view.txtPhoneAdd.setText("");
    }

    private void hideButton() {
        view.btnSave.setVisible(false);
        view.btnDelete.setVisible(false);
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
