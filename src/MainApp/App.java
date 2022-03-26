package MainApp;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.*;
import java.util.*;

import MainApp.models.Fields.BaseField;
import MainApp.models.Models.*;
public class App {

    private Map<String, BaseModel> modelInstances = new HashMap<>();
    public static void main(String[] args) {
        new App();
    }

    @SuppressWarnings("unchecked")
    public void init_model() {
        try {
            // Create files if not exists
            var dataDir = (String)GlobalData.config.get("dataDir");
            var dataDirFile = new File(dataDir);
            if(!dataDirFile.exists()) {
                dataDirFile.mkdir();
            }
            for(var clzName: (String[])GlobalData.config.get("userModels")) {
                var clz = Class.forName("MainApp.models.Models.UserModels." + clzName);
                var ins = clz.getConstructor().newInstance();
                modelInstances.put(clzName, (BaseModel)ins);
                // Collect the verboses
                var verboseMap = (Map<String, String>)clz.getField("verboseMap").get(null);
                var fields = clz.getFields();
                for(int i = 0; i < fields.length; i++) {
                    var _field = fields[i].get(ins);
                    if(_field instanceof BaseField) {
                        var field = (BaseField)_field;
                        if(field.verbose.equals("")) {
                            field.verbose = fields[i].getName();
                        }
                        verboseMap.put(field.verbose, fields[i].getName());
                    }
                }
                // Init files with the first line 
                var clzPath = Path.of(dataDir + "/" + clzName + ".csv");
                clz.getField("storagePath").set(null, clzPath);
                if(!clzPath.toFile().exists()) {
                    var line = new LinkedList<String>();
                    line.add("id");
                    line.addAll(verboseMap.keySet());
                    var lineStr = line.stream().reduce((a,b)->a+","+b).get();
                    Files.createFile(clzPath);
                    Files.write(clzPath, List.of(lineStr));
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public App() {
        GlobalData.init();
        init_model();
    }
}
