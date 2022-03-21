package MainApp;
import UIComponent.*;

import javax.swing.*;
import MainApp.GlobalData;
import MainApp.Welcome;

public class App {
    public static void main(String[] args) {
        new UIStyle();
        GlobalData.init();
        Welcome jf = new Welcome();
        jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
        jf.setUndecorated(true);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setVisible(true);
        for(var e : GlobalData.data.entrySet()) {
            System.out.println(e.getKey() + ", " + e.getValue());
        }
    }
    public int add(int a, int b) {
        return a + b;
    }
}