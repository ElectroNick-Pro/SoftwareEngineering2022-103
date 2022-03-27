package MainApp.models.Fields;

public class DoubleField extends BaseField {

    public DoubleField() {

    }
    public DoubleField(String verbose) {
        super(verbose);
    }

    @Override
    public void save_field() {
        if(rawData == null) {
            csvForm = "";
            return;
        }
        csvForm = ((Double)rawData).toString();
    }
    
    @Override
    public void read_field() {
        rawData = csvForm.equals("") ? null : Double.parseDouble(csvForm);
    }
}
