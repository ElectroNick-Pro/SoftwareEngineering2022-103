package MainApp.pages.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

import MainApp.pages.Pages;

public class topPanel extends JPanel{
    public topPanel(){
        this(Pages.curPagePath);
    }

    public topPanel(Path path){
        super();
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        BreadCrumbPanel bread = new BreadCrumbPanel(path);
        bread.setBounds(80, 25, 800, 25);
        exitButton exit = new exitButton();
        exit.setBounds(40,20,40,40);
        helpButton help = new helpButton();
        help.setBounds(880,20,40,40);
        this.add(bread);
        this.add(exit);
        this.add(help);
    }
    public static void main(String[] args){
        JFrame frame = new JFrame();
        topPanel panel = new topPanel(Path.of("Retrieve/Flight Information"));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,540);
    }
    
}
