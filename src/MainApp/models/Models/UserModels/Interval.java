package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import MainApp.GlobalData;
import MainApp.models.Fields.DateTimeField;
import MainApp.models.Fields.ForeignKey;
import MainApp.models.Fields.StringField;
import MainApp.models.Models.BaseModel;

public class Interval extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey flight = new ForeignKey(Flight.class);
    public StringField departure = new StringField();
    public StringField destination = new StringField();
    public DateTimeField departureTime = new DateTimeField((SimpleDateFormat) GlobalData.config.get("timezone"));
    public DateTimeField destTime = new DateTimeField((SimpleDateFormat) GlobalData.config.get("timezone"));
    public StringField gate = new StringField();
}
