package application.controllers;

import application.models.ProviderModel;
import application.views.ProvidersFormView;
import application.views.ProvidersView;
import database.QueriesProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utilities.PerformActions;

public class ProvidersController {

    ProvidersView view;
    PerformActions performActions = new PerformActions();

    public ProvidersController(ProvidersView view) {
        this.view = view;

        events();
        loadData();
        editProviderForm();
    }

    private void events() {
        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProvidersFormView providersForm = new ProvidersFormView();
                new AddProviderController(providersForm, view);
                performActions.changePanel(view.jPanel1, providersForm);
            }
        });
    }

    public void editProviderForm() {

        view.tblProvider.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent arg0) {
                ProvidersFormView providersForm = new ProvidersFormView();
                performActions.changePanel(view.jPanel1, providersForm);
                new EditProviderController(providersForm, view);

            }

        });

    }

    public void loadData() {
        QueriesProvider consult = new QueriesProvider();

        DefaultTableModel model = (DefaultTableModel) view.tblProvider.getModel();
        model.getDataVector().removeAllElements();
        ArrayList<ProviderModel> listaProvider = new ArrayList();
        listaProvider = consult.consulta();

        for (ProviderModel provider : listaProvider) {
            Object[] row = new Object[9];
            row[0] = provider.getId();
            row[1] = provider.getFirstName();
            row[2] = provider.getLastName();
            row[3] = provider.getAddress();
            row[4] = provider.getCity();
            row[5] = provider.getDepartment();
            row[6] = provider.getPhone();
            row[7] = provider.getEmail();
            row[8] = provider.getCreated_at();
            model.addRow(row);
        }
    }

}
