package MainApp;

import java.util.*;
import javax.swing.*;

public class GlobalData {
    public static HashMap<String, Object> data = new HashMap<>();
    public static HashMap<String, Object> config = new HashMap<>();
    public static ArrayList<JFrame> pageStack = new ArrayList<>();
    static {
        config.put("dataDir", "data");
        var dataFiles = new ArrayList<String>();
        dataFiles.add("Ticket.csv");
        dataFiles.add("Flight.csv");
        config.put("fileList", dataFiles);
    }
    public static void newPage(JFrame page) {
        
    }
}