package MainApp.pages;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.components.BreadCrumbPanel;
import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;


public class FoodPanel extends JFrame{

public FoodPanel(){



  
JPanel J=new JPanel();
J.setPreferredSize(new Dimension(960,1620));
ChooseFoodOrigin o=new ChooseFoodOrigin();
ChooseFoodExtra e=new ChooseFoodExtra();
ChooseFoodDessert d=new ChooseFoodDessert();
J.setLayout(new GridLayout(3,1)); 
J.add(o,Integer.valueOf(4));
J.add(e,Integer.valueOf(4));
J.add(d,Integer.valueOf(4));
   JScrollPane three =new JScrollPane(J,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  //JScrollPane three =new JScrollPane(J);
    three.setBounds(0,0,900,500);
    three.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
    three.setPreferredSize(new Dimension(960,540));
    //this.add(three);
    this.setSize(960,540);
    this.getContentPane().add(three);
    //three.setViewportView(this);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args){
    FoodPanel f=new FoodPanel();
    f.setVisible(true);
}


}