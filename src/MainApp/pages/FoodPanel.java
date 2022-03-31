package MainApp.pages;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class FoodPanel extends JFrame{

public FoodPanel(){


    this.setSize(960,540);

    JTabbedPane threechoice=new JTabbedPane(3);
    threechoice.addTab("Normal", new ChooseFoodOrigin());
    threechoice.addTab("Extra",new ChooseFoodExtra());
    threechoice.addTab("Dessert",new ChooseFoodDessert());
    threechoice.setBackground(Color.WHITE);
    this.add(threechoice);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args){
    FoodPanel f=new FoodPanel();
    f.setVisible(true);
}


}