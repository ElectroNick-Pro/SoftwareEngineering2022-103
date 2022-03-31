package MainApp.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResourceTest {
    public static void main(String[] args) {
        var frame = new JFrame();
        var url = ClassLoader.getSystemClassLoader().getResource("MainApp/image/apple.png");
        var label = new JLabel(new ImageIcon(url));
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
