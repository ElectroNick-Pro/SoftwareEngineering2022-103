package MainApp.pages.components;

import java.nio.file.Path;

import javax.swing.*;
import java.awt.*;

import MainApp.pages.Pages;
import MainApp.pages.Exception.UnboundPageException;

import java.awt.event.*;

public class HrefButton extends JButton implements ActionListener, MouseListener {
    private Path path;
    public HrefButton(Path path) {
        super();
        this.path = path;
        this.setText(path.toString());
        this.addActionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this) {
            try {
                Pages.displayPage(path);
            } catch (UnboundPageException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    private Color defaultForeground;
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this) {
            defaultForeground = this.getForeground();
            this.setForeground(new Color(0x397AE3));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this) {
            this.setForeground(defaultForeground);
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
