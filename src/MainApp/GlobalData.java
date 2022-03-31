package MainApp;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

public class GlobalData {
    public static Map<String, Object> data = new HashMap<>();
    public static Map<String, Object> config = new HashMap<>();

    public static void init() {

        config.put("srcDir", "D:/Courses/ebu6304SoftwareEngineering/CourseWork/software-engineering2022-103/");

        config.put("dataDir", (String)config.get("srcDir")+"data");

        var tz = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tz.setTimeZone(TimeZone.getTimeZone("UTC"));
        config.put("timezone", tz);

        var userModels = new String[] {
            "Airline", "Customer", "Flight", "Food", "Interval", "Plane", "Seat", "Ticket"
        };
        config.put("userModels", userModels);

        var pagePaths = new HashMap<Path, JFrame>();
        pagePaths.put(Path.of("frame1"), new JFrame());
        pagePaths.put(Path.of("frame2"), new JFrame());
        config.put("pagePaths", pagePaths);

        config.put("welcomePage", Path.of("frame1"));
    }
}