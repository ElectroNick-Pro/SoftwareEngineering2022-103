package MainApp.models.Fields;

import MainApp.models.Models.Exception.ValidationException;

public class BaseField {

    public Object rawData = null;
    public String csvForm = "";

    public String verbose = "";

    public BaseField() {
        
    }

    public BaseField(String verbose) {
        this.verbose = verbose;
    }

    public void save_field() {
        csvForm = rawData == null ? "" : rawData.toString();
    }

    public void validate_data() throws ValidationException {
        
    }

    public void validate_csv() throws ValidationException {

    }

    public void read_field() {
        rawData = csvForm.equals("") ? null : csvForm;
    }
}