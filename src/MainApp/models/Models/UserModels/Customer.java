package MainApp.models.Models.UserModels;

import MainApp.models.Fields.StringField;
import MainApp.models.Models.BaseModel;

import java.nio.file.Path;
import java.util.*;

public class Customer extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public StringField firstname = new StringField();
    public StringField surname = new StringField();
    public StringField customerId = new StringField();
}
