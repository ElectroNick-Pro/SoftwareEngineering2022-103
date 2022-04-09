package MainApp.models.Model;

import java.io.IOException;
import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import MainApp.models.Field.BaseField;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;

/**
 * <p>The class that every model should extend. Provides methods to interact with database to get or save data</p>
 * <p>Usual process to get a model/models shall be like below: (take model {@link MainApp.models.Model.UserModel.Airline Airline} as example)</p>
 * <pre>
 * Airline airline = Airline.getById(1); // Get an instance of Airline with primary key id=1 from database
 * String name = airline.name.getValue(); // Get the value of the {@link MainApp.models.Field.StringField StringField} of the instance
 * Stream<BaseModel> airlines = Airline.getByProperty(Airline.class, "name", "AirOne"); // Get a stream of Airline whose name is "AirOne"
 * 
 * </pre>
 */
public class BaseModel {

    public static Path storagePath;
    public static Map<String, String> verboseMap;

    public int id = -1;
    

    public BaseModel() {
        
    }

    private static String[] splitLine(String str) {
        if(str.endsWith(",")) {
            str += "-";
            var res = str.split(",");
            return Arrays.copyOf(res, res.length - 1);
        } else {
            return str.split(",");
        }
    }

    @SuppressWarnings("unchecked")
    public void save() {

        try {
            var fields = this.getClass().getFields();
            for(int i = 0; i < fields.length; i++) {
                var _field = fields[i].get(this);
                if(_field instanceof BaseField) {
                    var field = (BaseField)_field;
                    field.getClass().getMethod("validate_data").invoke(field);
                    field.getClass().getMethod("save_field").invoke(field);
                }
            }

            var verMap = (Map<String, String>)this.getClass().getField("verboseMap").get(null);

            var path = (Path) this.getClass().getField("storagePath").get(null);
            var lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            var keyArr = splitLine(lines.get(0));
            int n = keyArr.length;
            var ln = new LinkedList<String>();
            for(int i = 1; i < n; i++) {
                var field = this.getClass().getField(verMap.get(keyArr[i])).get(this);
                ln.add((String) field.getClass().getField("csvForm").get(field));
            }
            this.id = this.id == -1 ? lines.size() : this.id;
            ln.addFirst(Integer.toString(this.id));
            var modifiedLine = ln.stream().reduce((a,b)->a+","+b).get();
            if(this.id == lines.size()) {
                lines.add(modifiedLine);
            } else {
                lines.set(this.id, modifiedLine);
            }
            Files.write(path, lines);
        } catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseModel> T getById(Class<T> clz, int id) 
    throws ObjectNotFoundException {
        try {
            T res = clz.getConstructor().newInstance();
            var path = (Path) clz.getField("storagePath").get(null);
            var lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            var keyArr = splitLine(lines.get(0));
            int n = keyArr.length;
            if(id >= lines.size()) {
                throw new ObjectNotFoundException();
            }
            var valArr = splitLine(lines.get(id));
            res.id = id;
            var verMap = (Map<String, String>)clz.getField("verboseMap").get(null);
            for(int i = 1; i < n; i++) {
                var field = clz.getField(verMap.get(keyArr[i])).get(res);
                field.getClass().getField("csvForm").set(field, valArr[i]);
                field.getClass().getMethod("read_field").invoke(field);
            }

            return res;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | NoSuchFieldException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseModel> Stream<T> queryByProperty(Class<T> clz, String key, Object value) 
    throws FieldNotFoundException {
        try {
            var resLs = new ArrayList<T>();
            var path = (Path) clz.getField("storagePath").get(null);
            var lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            var keyArr = splitLine(lines.get(0));
            int n = keyArr.length;
            String[] valArr = null;
            var verMap = (Map<String, String>)clz.getField("verboseMap").get(null);
            try {
                clz.getField(key);
            } catch (NoSuchFieldException e) {
                if(!verMap.containsKey(key)) {
                    throw new FieldNotFoundException();
                }
            }

            BaseModel tmp = clz.getConstructor().newInstance();
            var keyItem = clz.getField(verMap.getOrDefault(key, key)).get(tmp);
            var keyClz = keyItem.getClass();
            keyClz.getField("rawData").set(keyItem, value);
            keyClz.getMethod("validate_data").invoke(keyItem);
            keyClz.getMethod("save_field").invoke(keyItem);
            int idx = 0;
            for(idx = 0; idx < n; idx++) {
                if(keyArr[idx].equals(key)) {
                    break;
                }
            }
            if(idx == n) {
                throw new FieldNotFoundException();
            }
            
            int m = lines.size();
            int ln = 1;
            for(ln = 1; ln < m; ln++) {
                valArr = splitLine(lines.get(ln));
                if(valArr[idx].equals(keyClz.getField("csvForm").get(keyItem))) {
                    T ins = clz.getConstructor().newInstance();
                    ins.id = ln;
                    for(int i = 1; i < n; i++) {
                        var field = clz.getField(verMap.get(keyArr[i])).get(ins);
                        field.getClass().getField("csvForm").set(field, valArr[i]);
                        field.getClass().getMethod("validate_csv").invoke(field);
                        field.getClass().getMethod("read_field").invoke(field);
                    }
                    resLs.add(ins);
                }
            }
            return resLs.stream();
        } catch (IOException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseModel> Stream<T> queryAll(Class<T> clz) 
    throws FieldNotFoundException {
        try {
            var resLs = new ArrayList<T>();
            var path = (Path) clz.getField("storagePath").get(null);
            var lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            var keyArr = splitLine(lines.get(0));
            int n = keyArr.length;
            String[] valArr = null;
            var verMap = (Map<String, String>)clz.getField("verboseMap").get(null);
            
            int m = lines.size();
            int ln = 1;
            for(ln = 1; ln < m; ln++) {
                valArr = splitLine(lines.get(ln));
                T ins = clz.getConstructor().newInstance();
                ins.id = ln;
                for(int i = 1; i < n; i++) {
                    var field = clz.getField(verMap.get(keyArr[i])).get(ins);
                    field.getClass().getField("csvForm").set(field, valArr[i]);
                    field.getClass().getMethod("validate_csv").invoke(field);
                    field.getClass().getMethod("read_field").invoke(field);
                }
                resLs.add(ins);
            }
            return resLs.stream();
        } catch (IOException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
