package MainApp.pages.components;

import java.awt.Color;
import java.nio.file.Path;
import java.util.*;

import javax.swing.*;

import MainApp.pages.Pages;

public class BreadCrumbPanel extends JPanel {
    private LinkedList<HrefButton> crumbs = new LinkedList<>();
    public Path totalPath = Path.of("Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay");
    public BreadCrumbPanel() {
        this(Pages.curPagePath);
    }
    public BreadCrumbPanel(Path path) {
        super();
        this.setBackground(Color.WHITE);

        int n = totalPath.getNameCount();
        int k = path.getNameCount();
        for(int i = 1; i <= n; i++) {
            var btn = new HrefButton(totalPath.subpath(0, i));
            this.add(btn);
            if(i < n) {
                var label = new JLabel(">");
                label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                if(i>k){
                    label.setForeground(Color.GRAY);
                }
                this.add(label);
            }
            if(i>k){
                btn.setEnabled(false);
            }
            crumbs.add(btn);
        }
    }

    public LinkedList<HrefButton> getBtnList(){
        return crumbs;
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


// class BreadCrumbBtn extends HrefButton {
    
//     public BreadCrumbBtn(Path path) {
//         super(path);
//         this.setOpaque(false);
//         this.setBorder(BorderFactory.createEmptyBorder());
//         this.setBackground(Color.WHITE);
//         this.setText(path.getName(path.getNameCount()-1).toString());
//     }
// }