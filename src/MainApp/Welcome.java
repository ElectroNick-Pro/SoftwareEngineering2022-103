package MainApp;

import javax.swing.JFrame;

import UIComponent.*;
import MainApp.GlobalData;

public class Welcome extends JFrame {
    public Welcome() {
        super();
        for(var e : GlobalData.data.entrySet()) {
            System.out.println(e.getKey() + ", " + e.getValue());
        }
        GlobalData.data.put("Welcome", "Hello");
    }
}
