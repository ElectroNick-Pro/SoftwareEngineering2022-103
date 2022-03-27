package MainApp.models.Field;

public class IntegerField extends BaseField {

    public IntegerField() {

    }
    public IntegerField(String verbose) {
        super(verbose);
    }

    @Override
    public void save_field() {
        if(rawData == null) {
            csvForm = "";
            return;
        }
        csvForm = ((Integer)rawData).toString();
    }
    
    @Override
    public void read_field() {
        rawData = csvForm.equals("") ? null : Integer.parseInt(csvForm);
    }
}
