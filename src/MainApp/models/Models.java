package MainApp.models;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import MainApp.GlobalData;
import MainApp.models.Field.BaseField;
import MainApp.models.Model.BaseModel;

public class Models {

    public static Map<String, BaseModel> modelInstances = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static void init() {
        try {
            // Create files if not exists
            var dataDir = (Path)GlobalData.config.get("dataDir");
            var dataDirFile = dataDir.toFile();
            if(!dataDirFile.exists()) {
                dataDirFile.mkdir();
            }
            for(var clzName: (LinkedList<String>)GlobalData.config.get("userModels")) {
                var clz = Class.forName("MainApp.models.Model.UserModel." + clzName);
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
                var clzPath = dataDir.resolve(Path.of(clzName + ".csv"));
                clz.getField("storagePath").set(null, clzPath);
                if(!clzPath.toFile().exists()) {
                    var line = new LinkedList<String>();
                    line.add("id");
                    var ls = new ArrayList<>(verboseMap.keySet());
                    ls.sort((x,y)->{
                        int m = x.length(), n = y.length();
                        int i = 0;
                        for(; i < m && i < n; i++) {
                            char xc = x.charAt(i), yc = y.charAt(i);
                            if(xc != yc) {
                                return xc - yc;
                            }
                        }
                        return m - n;
                    });
                    line.addAll(ls);
                    var lineStr = line.stream().reduce((a,b)->a+","+b).get();
                    Files.createFile(clzPath);
                    Files.write(clzPath, List.of(lineStr));
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
