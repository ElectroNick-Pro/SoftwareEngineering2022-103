package MainApp.models.Model.UserModel;

import java.nio.file.Path;
import java.util.*;
import MainApp.models.Model.BaseModel;
import MainApp.models.Field.*;

public class FoodPurchase extends BaseModel {
    public static Path storagePath;
    public static Map<String, String> verboseMap = new HashMap<>();
    public ForeignKey ticket = new ForeignKey(Ticket.class);
    public ForeignKey food = new ForeignKey(Food.class);
    public IntegerField count = new IntegerField();
}
