package MainApp.pages.components;

import javax.swing.*;

import MainApp.GlobalData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class originFood{
    public int id = -1;
    JPanel content = new JPanel();
    JLabel ok = new JLabel(new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/success1.png")));
    public foodButton fBtn;
    public originFood(int id) {
        this.id = id;
    }
    public boolean getSelected() {
        return ok.isVisible();
    }
    public void setSelected(boolean isSelected) {
        ok.setVisible(isSelected);
    }
    public JPanel createPanel(String picture,String name,String price, int id){
        price = "$"+price;
        
        content.setLayout(null);
        content.setSize(200,150);
        content.setBackground(Color.white);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource(picture));
        JLabel pictures = new JLabel(image);
        pictures.setBounds(65,0,60,60);
        content.add(pictures);

        JLabel panel = new JLabel();
        int wigth = 195;
        int hight = 110;
        panel.setSize(wigth,hight);
        panel.setBorder(new RoundBorder(Color.GRAY));
        panel.setBackground(Color.white);
        panel.setBounds(0,35,wigth,hight);
        content.add(panel);

        ok.setBounds(0,80,50,50);
        content.add(ok);
        ok.setVisible(false);

        fBtn = new foodButton(name,price,id);
        fBtn.setLocation(0,0,200,200);

        content.add(fBtn);

        return content; 
    }
}