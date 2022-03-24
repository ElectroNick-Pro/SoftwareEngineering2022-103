package MainApp.pages;

import javax.swing.*;

import MainApp.GlobalData;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Welcome extends JFrame implements WindowListener {
    public HashMap<String, Component> componentMap = new HashMap<>();

    public Welcome() {
        super();
        addWindowListener(this);
        setTitle("Welcome");
        var label = new JLabel("Now init", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);
        componentMap.put("label", label);
        pack();
    }

    @SuppressWarnings("unchecked")
    private void init() throws IOException {
        System.out.println("Now init");
        var dataPathStr = (String) GlobalData.config.get("dataDir");
        var dataDir = new File(dataPathStr);
        dataDir.mkdir();
        for(var file: (ArrayList<String>) GlobalData.config.get("fileList")) {
            var path = Path.of(dataPathStr + "/" + file);
            if(!Files.exists(path)) {
                Files.createFile(path);
            }
        }
        ((JLabel)componentMap.get("label")).setText("Initialized! Welcome!");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if(e.getSource() == this) {
            try {
                init();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public void windowClosing(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}