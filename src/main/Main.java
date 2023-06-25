package main;

import application.controllers.LoginController;
import application.models.UsersModel;
import application.views.LoginView;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {

    public static void main(String[] args) {
//        FlatLaf.registerCustomDefaultsSource("main.assets.styles");
        FlatLightLaf.setup();

        UsersModel model = new UsersModel();
        LoginView view = new LoginView();
        LoginController controller = new LoginController(model, view);
    }

}
