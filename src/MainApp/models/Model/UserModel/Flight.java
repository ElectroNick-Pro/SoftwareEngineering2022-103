package MainApp.models.Model.UserModel;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Field.ForeignKey;
import MainApp.models.Field.StringField;
import MainApp.models.Model.BaseModel;

public class Flight extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey plane = new ForeignKey(Plane.class);
    public StringField flightNo = new StringField();
}
