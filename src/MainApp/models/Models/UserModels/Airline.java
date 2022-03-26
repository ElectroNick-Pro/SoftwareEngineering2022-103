package MainApp.models.Models.UserModels;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Fields.*;
import MainApp.models.Models.BaseModel;

public class Airline extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public StringField name = new StringField();
}