package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Fields.ForeignKey;
import MainApp.models.Fields.IntegerField;
import MainApp.models.Fields.StringField;
import MainApp.models.Models.BaseModel;

public class Ticket extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey customer = new ForeignKey(Customer.class);
    public IntegerField luggageCnt = new IntegerField();
    public StringField counterNo = new StringField();
    public ForeignKey flight = new ForeignKey(Flight.class);
}
