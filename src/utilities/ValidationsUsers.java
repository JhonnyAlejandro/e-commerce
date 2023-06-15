package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsUsers {

    //el metodo que esta abajo es una expresion que verifica si esta vacio el dato. 
    public boolean checkEmpty(String data) {

        if (data == null || data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //el metodo que esta abajo es una expresion que verifica el dominio del correo electronico. 
    public boolean emailDomain(String data2) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(data2);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    //el metodo que esta abajo es una expresion que solo recibe letras, una -,' para el apellido,el nombre,el departamento y ciudad. 
    public boolean stringCheck(String data3) {

        Pattern pattern = Pattern.compile("^[A-Za-zñÑ\\s]+$");
        Matcher matcher = pattern.matcher(data3);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    // este metodo solo verifica que tenga numeros el celular.
    public boolean phoneCheck(String data4) {

        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(data4);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean addressCheck(String data5) {

        Pattern pattern = Pattern.compile("^[a-zA-Z\\s-]+$");
        Matcher matcher = pattern.matcher(data5);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

}
