package MainApp.models.Model.UserModel;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Field.ForeignKey;
import MainApp.models.Field.IntegerField;
import MainApp.models.Field.StringField;
import MainApp.models.Model.BaseModel;

public class Ticket extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey customer = new ForeignKey(Customer.class);
    public IntegerField luggageCnt = new IntegerField();
    public StringField counterNo = new StringField();
    public ForeignKey flight = new ForeignKey(Flight.class);
    public StringField bookingId = new StringField();
    public StringField seatClass = new StringField();
}
