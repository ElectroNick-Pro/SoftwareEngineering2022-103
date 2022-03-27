package MainApp;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.*;
import java.util.*;

import MainApp.models.Models;
import MainApp.models.Field.BaseField;
import MainApp.models.Model.*;
public class App {

    
    public static void main(String[] args) {
        new App();
    }

    public App() {
        GlobalData.init();
        Models.init();
    }
}
