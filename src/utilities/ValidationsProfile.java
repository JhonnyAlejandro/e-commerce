package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsProfile {

    public boolean validateEmptyField(String data) {
        if (data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateEmail(String data) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validatePhone(String data) {
        if (data == null || data.trim().isEmpty()) {
            return true; // Aceptar valores vacíos
        }
        
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateAddress(String data) {
        Pattern pattern = Pattern.compile("^(?:(?:Calle|Carrera|Avenida|Transversal|Diagonal|Manzana|Kilómetro|Vereda|Vía|Autopista|Pasaje|Peaje|Circular|Glorieta|Anillo|Callejón|Lote|CALLE|calle|carrera|CARRERA|AVENIDA|avenida|cll|cl|CLL|CL|AV|Av|av|cra|CRA|DIAGONAL|diagonal|diag|dg|DG|AK|ak|Ak|ac|AC|Ac|ap|Ap|AP|TV|Tv|tv|Transv|TRANSVERSAL|transversal|manzana|MANZANA|KILOMETRO|kilometro|km|Km|KM|VEREDA|vereda|VIA|via|aut|autopista|AUT|AUTOPISTA|PASAJE|pasaje|glorieta|GLORIETA|PEAJE|peaje|circular|CIRCULAR|ANILLO|anillo|callejon|CALLEJON|lote)\\s*\\d+[A-Za-z]?[-\\s#]?\\w*(?:\\d+[-]?\\d*)?(?:[-\\s]?[A-Za-z0-9]+\\s*)?)?\\s*$");
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }
    
    public boolean validateString(String data) {
        Pattern pattern = Pattern.compile("^[A-Za-zñÑ\\s]+$");
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isTextLengthValid(String data, int maxLength) {
        return data.length() <= maxLength;
    }
}
