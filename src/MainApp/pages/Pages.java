package MainApp.pages;

import java.nio.file.Path;
import java.util.*;

import javax.swing.JFrame;

import MainApp.GlobalData;
import MainApp.pages.Exception.UnboundPageException;


public class Pages {

    public static List<Path> pagePathStack = new ArrayList<>();
    public static Path curPagePath = null;
    public static Map<Path, JFrame> pagePathMap = new HashMap<>();

    public static void bindPage(Path path, JFrame page) {
        pagePathMap.put(path, page);
    }

    public static void displayPage(Path path) throws UnboundPageException {
        if(pagePathMap.getOrDefault(path, null) == null) {
            throw new UnboundPageException();
        }
        if(!pagePathStack.contains(path)) {
            pagePathStack.add(path);
        }
        if(curPagePath != null) {
            var page = pagePathMap.get(curPagePath);
            page.setVisible(false);
        }
        curPagePath = path;
        pagePathMap.get(curPagePath).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pagePathMap.get(curPagePath).setLocationRelativeTo(null); 
        pagePathMap.get(curPagePath).setBounds(100, 100, 965, 550);
        pagePathMap.get(curPagePath).setVisible(true);
    }

    public static void goBack() throws UnboundPageException {
        int idx = pagePathStack.indexOf(curPagePath);
        if(idx <= 0) {
            return;
        }
        displayPage(pagePathStack.get(idx - 1));
    }

    @SuppressWarnings("unchecked")
    public static void init() {
        try {
            var pagePaths = (HashMap<Path, JFrame>)GlobalData.config.get("pagePaths");
            pagePathMap.putAll(pagePaths);
            displayPage((Path)GlobalData.config.get("welcomePage"));
        } catch (UnboundPageException e) {
            e.printStackTrace();
        }
    }

}
