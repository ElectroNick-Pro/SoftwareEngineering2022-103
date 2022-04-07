package MainApp.models.Model.UserModel;

import java.nio.file.Path;
import java.util.*;

import MainApp.models.Field.*;
import MainApp.models.Model.BaseModel;

public class Airline extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public StringField name = new StringField();
}