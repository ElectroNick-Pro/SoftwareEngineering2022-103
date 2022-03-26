package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Fields.DoubleField;
import MainApp.models.Fields.ForeignKey;
import MainApp.models.Fields.StringField;
import MainApp.models.Models.BaseModel;

public class Food extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public DoubleField price = new DoubleField();
    public StringField name = new StringField();
    public StringField type = new StringField();
    public ForeignKey ticket = new ForeignKey(Ticket.class);
    public ForeignKey flight = new ForeignKey(Flight.class);
}
