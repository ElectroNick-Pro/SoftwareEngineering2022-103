package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Fields.DoubleField;
import MainApp.models.Fields.ForeignKey;
import MainApp.models.Fields.StringField;
import MainApp.models.Models.BaseModel;

public class Seat extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey interval = new ForeignKey(Interval.class);
    public StringField seatNo = new StringField();
    public StringField seatClass = new StringField();
    public DoubleField price = new DoubleField();
    public ForeignKey ticket = new ForeignKey(Ticket.class);
    public StringField type = new StringField();
}
