package MainApp.pages;

import java.nio.file.Path;
import java.util.*;

import javax.swing.JFrame;

import MainApp.GlobalData;
import MainApp.pages.Exception.UnboundPageException;


public class Pages {

    public static List<Path> pagePathStack = new LinkedList<>();
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
        pagePathMap.get(curPagePath).setVisible(true);
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
