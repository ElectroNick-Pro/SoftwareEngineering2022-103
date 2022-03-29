package MainApp.pages.foodGUI;
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

 
//框框
JPanel panel1=this.paintRect(45,200,1);
foodimage Dou1=new foodimage("");
Dou1.set1();
this.getLayeredPane().add(panel1,Integer.valueOf(2));
this.getLayeredPane().add(Dou1,Integer.valueOf(4));
JPanel panel2=this.paintRect(270,200,1);
foodimage Bread2=new foodimage("");
Bread2.set2();
this.getLayeredPane().add(panel2,Integer.valueOf(2));
this.getLayeredPane().add(Bread2,Integer.valueOf(4));
JPanel panel3=this.paintRect(495,200,1);
foodimage Choco3=new foodimage("");
Choco3.set3();
this.getLayeredPane().add(panel3,Integer.valueOf(2));
this.getLayeredPane().add(Choco3,Integer.valueOf(4));
JPanel panel4=this.paintRect(720,200,1);
foodimage Bis4=new foodimage("");
Bis4.set4();
this.getLayeredPane().add(panel4,Integer.valueOf(2));
this.getLayeredPane().add(Bis4,Integer.valueOf(4));
JPanel panel5=this.paintRect(45,345,1);
foodimage Pud5=new foodimage("");
Pud5.set5();
this.getLayeredPane().add(panel5,Integer.valueOf(2));
this.getLayeredPane().add(Pud5,Integer.valueOf(4));
JPanel panel6=this.paintRect(270,345,1);
foodimage Lolli6=new foodimage("");
Lolli6.set6();
this.getLayeredPane().add(panel6,Integer.valueOf(2));
this.getLayeredPane().add(Lolli6,Integer.valueOf(4));
JPanel panel7=this.paintRect(495,345,1);
    //panel7.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.PINK));
foodimage Rice7=new foodimage("");
this.getLayeredPane().add(panel7,Integer.valueOf(2));
this.getLayeredPane().add(Rice7,Integer.valueOf(4));
Rice7.set7();
JPanel panel8=this.paintRect(720,345,1);
foodimage Sushi8=new foodimage("");
Sushi8.set8();
this.getLayeredPane().add(panel8,Integer.valueOf(2));
this.getLayeredPane().add(Sushi8,Integer.valueOf(4));
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

this.getLayeredPane().add(Doughnut,Integer.valueOf(3));
this.getLayeredPane().add(Bread,Integer.valueOf(3));
this.getLayeredPane().add(Chocolate,Integer.valueOf(3));
this.getLayeredPane().add(Biscuit,Integer.valueOf(3));
this.getLayeredPane().add(Pudding,Integer.valueOf(3));
this.getLayeredPane().add(Lollipop,Integer.valueOf(3));
this.getLayeredPane().add(Riceball,Integer.valueOf(3));
this.getLayeredPane().add(Sushi,Integer.valueOf(3));

JPanel shadow1=shade(70,210);
this.getLayeredPane().add(shadow1,Integer.valueOf(1));
JPanel shadow2=shade(295,210);
this.getLayeredPane().add(shadow2,Integer.valueOf(1));
JPanel shadow3=shade(520,210);
this.getLayeredPane().add(shadow3,Integer.valueOf(1));
JPanel shadow4=shade(745,210);
this.getLayeredPane().add(shadow4,Integer.valueOf(1));
JPanel shadow5=shade(70,355);
this.getLayeredPane().add(shadow5,Integer.valueOf(1));
JPanel shadow6=shade(295,355);
this.getLayeredPane().add(shadow6,Integer.valueOf(1));
JPanel shadow7=shade(520,355);
this.getLayeredPane().add(shadow7,Integer.valueOf(1));
JPanel shadow8=shade(745,355);
this.getLayeredPane().add(shadow8,Integer.valueOf(1));
this.setSize(960,540);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args){
    ChooseFoodDessert o=new ChooseFoodDessert();
    o.setVisible(true);
}

}