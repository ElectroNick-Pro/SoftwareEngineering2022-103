package MainApp.pages.components;

import java.awt.Color;
import java.nio.file.Path;
import java.util.*;

import javax.swing.*;

import MainApp.pages.Pages;

public class BreadCrumbPanel extends JPanel {
    private List<BreadCrumbBtn> crumbs = new LinkedList<>();
    public BreadCrumbPanel() {
        this(Pages.curPagePath);
    }
    public BreadCrumbPanel(Path path) {
        super();
        int n = path.getNameCount();
        for(int i = 1; i <= n; i++) {
            var btn = new BreadCrumbBtn(path.subpath(0, i));
            this.add(btn);
            if(i < n) {
                var label = new JLabel("/");
                label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                this.add(label);
            } else {
                btn.setEnabled(false);
            }
            crumbs.add(btn);
        }

    }
    public static void main(String[] args) {
        var panel = new BreadCrumbPanel(Path.of("path/path1/path2/path3"));
        var frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


class BreadCrumbBtn extends HrefButton {
    
    public BreadCrumbBtn(Path path) {
        super(path);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(new Color(0));
        this.setText("<html><u>"+path.getName(path.getNameCount()-1).toString()+"</u></html>");
    }
}