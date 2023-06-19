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
    QueriesProvider queries = new QueriesProvider();
    PerformActions performActions = new PerformActions();

    public ProvidersController(ProvidersView view) {
        this.view = view;

        events();
        loadData();
        editProviderForm();
        filterListener();
    }
    
     private void filterListener() {
        view.cbmFilters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilter(); // Método para aplicar el filtro
            }
        });
    
     }
        
        private void applyFilter() {
        String filterOption = (String) view.cbmFilters.getSelectedItem();
        ArrayList<ProviderModel> filteredProvidersList = null;

        switch (filterOption) {
            case "Todos":
                filteredProvidersList = queries.consulta();
                break;
            case "Hoy":
                filteredProvidersList = queries.consultProvidersOneDay();
                break;
            case "Ultima semana":
                filteredProvidersList = queries.consultProviderLastWeek();
                break;
            case "Ultimo mes":
                filteredProvidersList = queries.consultProviderLastMonth();
                break;
            case "Ultimos 6 meses":
                filteredProvidersList = queries.consultProviderLast6Months();
                break;
            case "Ultimo año":
                filteredProvidersList = queries.consultProviderLastYear();
                break;
            case "Mas de un año":
                filteredProvidersList = queries.consultProviderMoreThanYear();
                break;
            default:
                filteredProvidersList = new ArrayList<ProviderModel>();
                break;
        }
          updateTable(filteredProvidersList);
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
    
    private void updateTable(ArrayList<ProviderModel> providerList) {
        DefaultTableModel model = (DefaultTableModel) view.tblProvider.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (ProviderModel provider : providerList) {
            Object[] row = new Object[8];
            // Rellenar los datos del usuario en la fila
           row[0] = provider.getId();
            row[1] = provider.getFirstName();
            row[2] = provider.getLastName();
            row[3] = provider.getAddress();
            row[4] = provider.getCity();
            row[5] = provider.getDepartment();
            row[6] = provider.getPhone();
            row[7] = provider.getEmail();
          

            model.addRow(row); // Agregar la fila a la tabla
        }
    }

    public void loadData() {
        QueriesProvider consult = new QueriesProvider();

        DefaultTableModel model = (DefaultTableModel) view.tblProvider.getModel();
        model.getDataVector().removeAllElements();
        ArrayList<ProviderModel> listaProvider = new ArrayList();
        listaProvider = consult.consulta();

        for (ProviderModel provider : listaProvider) {
            Object[] row = new Object[8];
            row[0] = provider.getId();
            row[1] = provider.getFirstName();
            row[2] = provider.getLastName();
            row[3] = provider.getAddress();
            row[4] = provider.getCity();
            row[5] = provider.getDepartment();
            row[6] = provider.getPhone();
            row[7] = provider.getEmail();
         
            model.addRow(row);
        }
    }

}
