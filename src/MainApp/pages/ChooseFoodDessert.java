package MainApp.pages;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class ChooseFoodDessert extends ChooseFoodtemplate{

//constructer
public ChooseFoodDessert(){


JPanel whitepanel=new JPanel();
whitepanel.setSize(960, 540);
whitepanel.setBackground(Color.WHITE);

this.Titleset("Choose Dessert");
 
//框框
JPanel panel1=this.paintRect(45,200,1);
foodimage Dou1=new foodimage("src/MainApp/pages/image/doughnut1.png");
Dou1.set1();
this.add(panel1,Integer.valueOf(2));
this.add(Dou1,Integer.valueOf(4));
JPanel panel2=this.paintRect(270,200,1);
foodimage Bread2=new foodimage("src/MainApp/pages/image/bread2.png");
Bread2.set2();
this.add(panel2,Integer.valueOf(2));
this.add(Bread2,Integer.valueOf(4));
JPanel panel3=this.paintRect(495,200,1);
foodimage Choco3=new foodimage("src/MainApp/pages/image/chocolate3.png");
Choco3.set3();
this.add(panel3,Integer.valueOf(2));
this.add(Choco3,Integer.valueOf(4));
JPanel panel4=this.paintRect(720,200,1);
foodimage Bis4=new foodimage("src/MainApp/pages/image/biscuit4.png");
Bis4.set4();
this.add(panel4,Integer.valueOf(2));
this.add(Bis4,Integer.valueOf(4));
JPanel panel5=this.paintRect(45,345,1);
foodimage Pud5=new foodimage("src/MainApp/pages/image/pudding5.png");
Pud5.set5();
this.add(panel5,Integer.valueOf(2));
this.add(Pud5,Integer.valueOf(4));
JPanel panel6=this.paintRect(270,345,1);
foodimage Lolli6=new foodimage("src/MainApp/pages/image/lollipop6.png");
Lolli6.set6();
this.add(panel6,Integer.valueOf(2));
this.add(Lolli6,Integer.valueOf(4));
JPanel panel7=this.paintRect(495,345,1);
    //panel7.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.PINK));
foodimage Rice7=new foodimage("src/MainApp/pages/image/rice ball7.png");
this.add(panel7,Integer.valueOf(2));
this.add(Rice7,Integer.valueOf(4));
Rice7.set7();
JPanel panel8=this.paintRect(720,345,1);
foodimage Sushi8=new foodimage("src/MainApp/pages/image/sushi8.png");
Sushi8.set8();
this.add(panel8,Integer.valueOf(2));
this.add(Sushi8,Integer.valueOf(4));
//按钮
newfoodButton Doughnut=new newfoodButton("Doughnut",1,"$2");
Doughnut.set1();
newfoodButton Bread=new newfoodButton("Bread",1,"$1");
Bread.set2();
newfoodButton Chocolate=new newfoodButton("Chocolate",1,"$6");
Chocolate.set3();
newfoodButton Biscuit=new newfoodButton("Biscuit",1,"$3.3");
Biscuit.set4();
newfoodButton Pudding=new newfoodButton("Pudding",1,"$2.5");
Pudding.set5();
newfoodButton Lollipop=new newfoodButton("Lollipop",1,"1.5");
Lollipop.set6();
newfoodButton Riceball=new newfoodButton("Rice Ball",1,"$5");
Riceball.set7();
newfoodButton Sushi=new newfoodButton("Sushi",1,"$7");
Sushi.set8();

this.add(Doughnut,Integer.valueOf(3));
this.add(Bread,Integer.valueOf(3));
this.add(Chocolate,Integer.valueOf(3));
this.add(Biscuit,Integer.valueOf(3));
this.add(Pudding,Integer.valueOf(3));
this.add(Lollipop,Integer.valueOf(3));
this.add(Riceball,Integer.valueOf(3));
this.add(Sushi,Integer.valueOf(3));

JPanel shadow1=shade(70,210);
this.add(shadow1,Integer.valueOf(1));
JPanel shadow2=shade(295,210);
this.add(shadow2,Integer.valueOf(1));
JPanel shadow3=shade(520,210);
this.add(shadow3,Integer.valueOf(1));
JPanel shadow4=shade(745,210);
this.add(shadow4,Integer.valueOf(1));
JPanel shadow5=shade(70,355);
this.add(shadow5,Integer.valueOf(1));
JPanel shadow6=shade(295,355);
this.add(shadow6,Integer.valueOf(1));
JPanel shadow7=shade(520,355);
this.add(shadow7,Integer.valueOf(1));
JPanel shadow8=shade(745,355);
this.add(shadow8,Integer.valueOf(1));
this.setSize(960,540);
}

public static void main(String[] args){
    ChooseFoodDessert o=new ChooseFoodDessert();
    o.setVisible(true);
}

}