package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public boolean validateEmptyField(String data) {
        if (data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateEmail(String data) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }

}
