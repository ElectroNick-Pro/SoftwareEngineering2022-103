package MainApp.models.Field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeField extends BaseField {
    
    private SimpleDateFormat tz;

    public DateTimeField(SimpleDateFormat tz) {
        this.tz = tz;
    }

    @Override
    public void save_field() {
        if(rawData == null) {
            csvForm = "";
            return;
        }
        csvForm = tz.format((Date)rawData);
    }

    @Override
    public void read_field() {
        if(csvForm.equals("")) {
            rawData = null;
            return;
        }
        try {
            rawData = tz.parse(csvForm);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
