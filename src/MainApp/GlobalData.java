package MainApp;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class GlobalData {
    public static HashMap<String, Object> data = new HashMap<>();
    public static HashMap<String, Object> config = new HashMap<>();
    public static ArrayList<JFrame> pageStack = new ArrayList<>();
    public static void init() {
        config.put("dataDir", "D:/Courses/ebu6304SoftwareEngineering/CourseWork/software-engineering2022-103/data");
        var tz = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tz.setTimeZone(TimeZone.getTimeZone("UTC"));
        config.put("timezone", tz);
        var userModels = new String[] {
            "Airline", "Customer", "Flight", "Food", "Interval", "Plane", "Seat", "Ticket"
        };
        config.put("userModels", userModels);
    }
    public static void newPage(JFrame page) {
        
    }
}