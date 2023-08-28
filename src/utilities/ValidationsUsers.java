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
          if (data4 == null || data4.trim().isEmpty()) {
              return true; // Aceptar valores vacíos
          }

          Pattern pattern = Pattern.compile("^\\d+$");
          Matcher matcher = pattern.matcher(data4);

          if (matcher.find()) {
              return true;
          } else {
              return false;
          }
      }

        public boolean isTextLengthValid(String data6, int maxLength) {
        return data6.length() <= maxLength;
    }

        public boolean addressCheck(String data5) {
          Pattern pattern = Pattern.compile("^(?:(?:Calle|Carrera|Avenida|Transversal|Diagonal|Manzana|Kilómetro|Vereda|Vía|Autopista|Pasaje|Peaje|Circular|Glorieta|Anillo|Callejón|Lote|CALLE|calle|carrera|CARRERA|AVENIDA|avenida|cll|cl|CLL|CL|AV|Av|av|cra|CRA|DIAGONAL|diagonal|diag|dg|DG|AK|ak|Ak|ac|AC|Ac|ap|Ap|AP|TV|Tv|tv|Transv|TRANSVERSAL|transversal|manzana|MANZANA|KILOMETRO|kilometro|km|Km|KM|VEREDA|vereda|VIA|via|aut|autopista|AUT|AUTOPISTA|PASAJE|pasaje|glorieta|GLORIETA|PEAJE|peaje|circular|CIRCULAR|ANILLO|anillo|callejon|CALLEJON|lote)\\s*\\d+[A-Za-z]?[-\\s#]?\\w*(?:\\d+[-]?\\d*)?(?:[-\\s]?[A-Za-z0-9]+\\s*)?)?\\s*$");
          Matcher matcher = pattern.matcher(data5);

          return matcher.matches();
      }

}
