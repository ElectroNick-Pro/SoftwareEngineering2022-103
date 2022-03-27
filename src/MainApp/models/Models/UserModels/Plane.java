package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Fields.*;
import MainApp.models.Models.BaseModel;

public class Plane extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey airline = new ForeignKey(Airline.class);
    public StringField type = new StringField();
}