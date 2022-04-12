package MainApp.pages.components;

import javax.swing.*;
import java.awt.*;

public class foodPanel {
    JSpinner spinner;
    public JPanel createPanel(String picture,String name,String price){
        price = "$"+price;
        JPanel content = new JPanel();
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

        JLabel names = new JLabel(name);
        names.setFont(new Font("Microsoft YaHei UI",Font.BOLD,23));
        names.setBounds(0,55,195,40);
        names.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(names);

        JLabel prices = new JLabel(price);
        prices.setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
        prices.setForeground(Color.red);
        prices.setBounds(0,100,125,42);
        prices.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(prices);

        spinner = new JSpinner();
        spinner.setBounds(125,110,42,24);
        content.add(spinner);
        return content; //return the content
    }
    public int getValue(){
        int value = (int)this.spinner.getValue();
        return value;
    }
}