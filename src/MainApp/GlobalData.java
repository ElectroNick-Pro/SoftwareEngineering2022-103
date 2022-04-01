package MainApp;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

import MainApp.pages.Retrive;

public class GlobalData {
    public static Map<String, Object> data = new HashMap<>();
    public static Map<String, Object> config = new HashMap<>();

    public static void init() {

        config.put("srcDir", "D:/Coursework/software-engineering2022-103");

        config.put("dataDir", (String)config.get("srcDir")+"data");

        var tz = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tz.setTimeZone(TimeZone.getTimeZone("UTC"));
        config.put("timezone", tz);

        var userModels = new String[] {
            "Airline", "Customer", "Flight", "Food", "Interval", "Plane", "Seat", "Ticket"
        };
        config.put("userModels", userModels);

        var pagePaths = new HashMap<Path, JFrame>();
        pagePaths.put(Path.of("page1"), new Retrive(){{
            setSize(960, 540);
        }});
        config.put("pagePaths", pagePaths);

        config.put("welcomePage", Path.of("page1"));
    }
}