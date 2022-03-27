package MainApp.pages;

import java.util.*;
import javax.swing.JFrame;

public class Pages {

    public static List<JFrame> pageStack = new LinkedList<>();

    public static void newPage(JFrame page) {
        pageStack.add(page);
    }

    

}
