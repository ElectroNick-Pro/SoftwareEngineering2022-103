package MainApp.models.Model.UserModel;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import MainApp.GlobalData;
import MainApp.models.Field.DateTimeField;
import MainApp.models.Field.ForeignKey;
import MainApp.models.Field.StringField;
import MainApp.models.Model.BaseModel;

public class Interval extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey flight = new ForeignKey(Flight.class);
    public StringField departureCity = new StringField();
    public StringField departureAirport = new StringField();
    public DateTimeField departureTime = new DateTimeField((SimpleDateFormat) GlobalData.config.get("timezone"));
    public StringField destCity = new StringField();
    public StringField destAirport = new StringField();
    public DateTimeField destTime = new DateTimeField((SimpleDateFormat) GlobalData.config.get("timezone"));
    public StringField gate = new StringField();
    public StringField terminal = new StringField();
}
