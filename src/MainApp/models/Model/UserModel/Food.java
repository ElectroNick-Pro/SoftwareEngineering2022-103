package MainApp.models.Model.UserModel;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Field.DoubleField;
import MainApp.models.Field.ForeignKey;
import MainApp.models.Field.StringField;
import MainApp.models.Model.BaseModel;

public class Food extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public DoubleField price = new DoubleField();
    public StringField name = new StringField();
    public StringField type = new StringField();
    public ForeignKey flight = new ForeignKey(Flight.class);
    public StringField image = new StringField();
}
