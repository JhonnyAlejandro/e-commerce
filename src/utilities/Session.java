package utilities;

import application.models.UsersModel;

public class Session {

    public static UsersModel userModel;

    public Session(UsersModel userModel) {
        this.userModel = userModel;
    }

}
