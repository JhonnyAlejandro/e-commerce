package application.controllers;

import application.views.ProvidersFormView;
import application.views.ProvidersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.PerformActions;

public class ProvidersController {

    ProvidersView view;
    PerformActions performActions = new PerformActions();

    public ProvidersController(ProvidersView view) {
        this.view = view;

        events();
    }

    private void events() {
        view.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProvidersFormView providersForm = new ProvidersFormView();

                performActions.changePanel(view.jPanel1, providersForm);
            }
        });
    }

}
