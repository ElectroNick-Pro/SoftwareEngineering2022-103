package MainApp;

import java.util.*;
import javax.swing.*;

public class GlobalData {
    public static HashMap<String, Object> data;
    public static HashMap<String, Object> config;
    public static ArrayList<JFrame> pageStack;
    static {
        data = new HashMap<>();
        config = new HashMap<>();
        pageStack = new ArrayList<>();

        config.put("dataDir", "data");
        var dataFiles = new ArrayList<String>();
        dataFiles.add("Ticket.csv");
        dataFiles.add("Flight.csv");
        config.put("fileList", dataFiles);
    }
}