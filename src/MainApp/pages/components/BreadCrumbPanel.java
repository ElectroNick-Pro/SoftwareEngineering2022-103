package MainApp.pages.components;

import java.util.List;

import javax.swing.*;

import MainApp.App;
import MainApp.pages.Pages;

public class BreadCrumbPanel extends JPanel {
    private List<BreadCrumbBtn> crumbs;
    public BreadCrumbPanel() {
        super();
        
        Pages.pageStack.forEach((x)->{
            var crumb = new BreadCrumbBtn();
            crumb.setText(x.getName());
            crumbs.add(crumb);
        });

        for(var crumb: crumbs) {
            this.add(crumb);
            var label = new JLabel(">");
            this.add(label);
        }
    }
    public static void main(String[] args) {
        new App();
        for(int i = 0; i < 5; i++) {
            var frame = new JFrame();
            frame.setName("frame" + i);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }
}


class BreadCrumbBtn extends JButton {
    
    public BreadCrumbBtn() {

    }
}