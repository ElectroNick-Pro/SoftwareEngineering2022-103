package MainApp.pages.components;

import javax.swing.*;

import MainApp.GlobalData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class originFood{
    private boolean isSelected = false;
    JPanel content = new JPanel();
    public boolean getSelected() {
        return isSelected;
    }
    public JPanel createPanel(String picture,String name,String price){
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

        foodButton btn = new foodButton(name,price);
        btn.setLocation(0,0,200,200);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel ok = (JLabel)GlobalData.data.get("okLabel");
                ok.setVisible(false);
                ok.setBounds(0,80,50,50);
                ok.setVisible(true);
                content.add(ok);
                isSelected = true;
                System.out.println(name);
            }
        });

        content.add(btn);

        return content; 
    }
}