package MainApp.pages.components;

import java.nio.file.Path;

import javax.swing.*;
import java.awt.*;

import MainApp.pages.Pages;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.GlobalData;

import java.awt.event.*;

public class HrefButton extends JButton implements ActionListener, MouseListener {
    private Path path;
    private String pathName;
    private Boolean state = true;
    public HrefButton(Path path) {
        super();
        this.path = path;
        this.pathName = path.toString();
        this.setText(path.toString());
        this.addActionListener(this);
        this.addMouseListener(this);
        this.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(Color.WHITE);
        this.setFocusPainted(false);
        this.setText(path.getName(path.getNameCount()-1).toString());
    }

    @Override
    public String toString(){
        return this.pathName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println((Pages.curPagePath).toString());

        // if(this.pathName.equals("Retrieve") && GlobalData.data.get("seat") != null && !((Pages.curPagePath).toString().equals("page1") || (Pages.curPagePath).toString().equals("Retrieve"))){
        //     int choice = JOptionPane.showConfirmDialog(null, "Do you want to go back to the Retrieve page? If so, your choices will not be saved.", "Confirm",JOptionPane.YES_NO_OPTION);
        //     if(choice != JOptionPane.YES_OPTION){
        //         this.state = false;
        //     }else{
        //         this.state = true;
        //     }
        // }
        if(Pages.curPagePath.equals(path) || Pages.curPagePath.toString().equals("page1")){
            state = false;
        }
        if(state){
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
            this.setForeground(new Color(0,131,255));
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
