package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Fields.ForeignKey;
import MainApp.models.Fields.StringField;
import MainApp.models.Models.BaseModel;

public class Flight extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey plane = new ForeignKey(Plane.class);
    public StringField flightNo = new StringField();
}
