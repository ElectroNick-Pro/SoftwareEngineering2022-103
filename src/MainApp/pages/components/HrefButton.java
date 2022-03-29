package MainApp.pages.components;

import java.nio.file.Path;

import javax.swing.*;
import java.awt.event.*;

public class HrefButton extends JButton implements ActionListener {
    private Path path;
    public HrefButton(Path path) {
        super();
        this.path = path;
        this.setText(path.toString());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this) {
            
        }
    }

    public static void main(String[] args) {
        var href = new HrefButton(Path.of("/Page"));
        var frame = new JFrame();
        frame.add(href);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
