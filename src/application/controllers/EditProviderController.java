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
import utilities.PerformActions;
import utilities.Validations;

public class EditProviderController {

    ProvidersFormView view;
    ProvidersView providersView;
    ProviderModel model = new ProviderModel();
    QueriesProvider consult = new QueriesProvider();
    Validations validaciones = new Validations();

    public EditProviderController(ProvidersFormView view, ProvidersView providersView) {
        this.view = view;
        this.providersView = providersView;
        changetitle();
        hideButton();
        loadData();
        events();

    }

    private void loadData() {

        Object obj = providersView.tblProvider.getValueAt(providersView.tblProvider.getSelectedRow(), 0);
        int id = (int) obj;

        model = consult.buscar(id);

        view.txtFirstNameAdd.setText(model.getFirstName());
        view.txtLastNameAdd.setText(model.getLastName());
        view.txtDepartmentAdd.setText(model.getDepartment());
        view.txtCityAdd.setText(model.getCity());
        view.txtPhoneAdd.setText(model.getPhone());
        view.txtAdressAdd.setText(model.getAddress());
        view.txtEmailAdd.setText(model.getEmail());
    }

    private void events() {

        view.btnSave.addActionListener(new ActionListener() {
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

                    if (consult.modificar(model)) {

                        JOptionPane.showMessageDialog(null, "proveedor actualizado");

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

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Object obj = providersView.tblProvider.getValueAt(providersView.tblProvider.getSelectedRow(), 0);
                int id = (int) obj;
                model.setId(id);
                model.setState(0);

                if (consult.eliminar(model)) {
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
        view.lblTitle.setText("Editar Proveedor");
    }

    private void hideButton() {
        view.btnAdd.setVisible(false);
    }

}
