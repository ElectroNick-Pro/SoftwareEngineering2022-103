package MainApp.models.Field;

import java.security.MessageDigest;

import MainApp.GlobalData;
import MainApp.models.Model.Exception.ValidationException;

public class PasswordField extends BaseField {
    
    public PasswordField() {

    }

    public PasswordField(String verbose) {
        super(verbose);
    }

    private String encrypt(String msg) {
        var dig = (MessageDigest)GlobalData.config.get("digest");
        dig.update(msg.getBytes());
        var bytes = dig.digest();
        var str = new StringBuilder();
        for(var b : bytes) {
            str.append(String.format("%02x", b & 0xff));
        }
        return str.toString();
    }

    public void save_field() {
        if(rawData == null) {
            return;
        }
        csvForm = encrypt((String)rawData);
    }

    public void validate_data() throws ValidationException {
        
    }

    public void validate_csv() throws ValidationException {

    }

    public void read_field() {
        
    }

    public String getValue() {
        return rawData == null ? csvForm : (String)rawData;
    }

    public void setValue(Object newValue) {
        this.rawData = newValue;
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(rawData == null) {
            return csvForm.equals(encrypt(obj.toString()));
        }
        return ((String)rawData).equals(obj);
    }

}
