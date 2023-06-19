/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controllers;

import application.models.ProviderModel;
import application.views.ProvidersFormView;
import application.views.ProvidersView;
import database.QueriesProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utilities.Validations;

public class AddProviderController {

    ProvidersFormView view;
    ProvidersView providersView;
    ProviderModel model = new ProviderModel();
    QueriesProvider consult = new QueriesProvider();
    Validations validaciones = new Validations();

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
                if (validaciones.validateEmptyField(view.txtFirstNameAdd.getText()) || validaciones.validateEmptyField(view.txtLastNameAdd.getText()) || validaciones.validateEmptyField(view.txtCityAdd.getText()) || validaciones.validateEmptyField(view.txtEmailAdd.getText()) || validaciones.validateEmptyField(view.txtAdressAdd.getText()) || validaciones.validateEmptyField(view.txtPhoneAdd.getText()) || validaciones.validateEmptyField(view.txtDepartmentAdd.getText())) {
                    JOptionPane.showMessageDialog(null, "campos vacios.");

                } else {

                    model.setFirstName(view.txtFirstNameAdd.getText());
                    model.setLastName(view.txtLastNameAdd.getText());
                    model.setAddress(view.txtAdressAdd.getText());
                    model.setCity(view.txtCityAdd.getText());
                    model.setPhone(view.txtPhoneAdd.getText());
                    model.setDepartment(view.txtDepartmentAdd.getText());
                    model.setEmail(view.txtEmailAdd.getText());
                    model.setState(1);

                    if (consult.registrar(model)) {
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
