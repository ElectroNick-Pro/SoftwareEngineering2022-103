package MainApp.pages;

import java.nio.file.Path;
import java.util.*;
import javax.swing.JFrame;

import MainApp.GlobalData;

public class Pages {

    public static List<JFrame> pageStack = new LinkedList<>();
    public static JFrame curPage = null;


    public static void newPage(JFrame page) {
        pageStack.add(page);
    }

    public static void displayPage(JFrame page) {
        if(!pageStack.contains(page)) {
            newPage(page);
        }
        if(curPage != null) {
            curPage.setVisible(false);
        }
        curPage = page;
        curPage.setVisible(true);
    }

    public static void init() {
        displayPage((JFrame)GlobalData.config.get("welcomePage"));
    }

}
