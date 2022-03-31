package MainApp.pages.foodGUI;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class ChooseFoodExtra extends ChooseFoodtemplate{


//constructer
public ChooseFoodExtra(){


JButton Next=new JButton("NEXT");
Next.setBackground(new Color(0,131,255));
Next.setForeground(Color.WHITE);
Next.setFont(Smallfont);
Next.setBounds(860,490,75,30);
Next.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ChooseFoodDessert dessert=new ChooseFoodDessert();
    dessert.setVisible(true); }
	}
	);

JPanel whitepanel=new JPanel();
whitepanel.setSize(960, 540);
whitepanel.setBackground(Color.WHITE);

 
this.getLayeredPane().add(whitepanel,-1);

this.getLayeredPane().add(Next,Integer.valueOf(3));
this.setBackground(Color.WHITE);
//框框
JPanel panel1=this.paintRect(45,200,1);
foodimage Coffee1=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/coffee1.png");
Coffee1.set1();
this.getLayeredPane().add(panel1,Integer.valueOf(2));
this.getLayeredPane().add(Coffee1,Integer.valueOf(4));
JPanel panel2=this.paintRect(270,200,1);
foodimage Cola2=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/cola2.png");
Cola2.set2();
this.getLayeredPane().add(panel2,Integer.valueOf(2));
this.getLayeredPane().add(Cola2,Integer.valueOf(4));
JPanel panel3=this.paintRect(495,200,1);
foodimage Beer3=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/beer3.png");
Beer3.set3();
this.getLayeredPane().add(panel3,Integer.valueOf(2));
this.getLayeredPane().add(Beer3,Integer.valueOf(4));
JPanel panel4=this.paintRect(720,200,1);
foodimage Juice4=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/juice4.png");
Juice4.set4();
this.getLayeredPane().add(panel4,Integer.valueOf(2));
this.getLayeredPane().add(Juice4,Integer.valueOf(4));
JPanel panel5=this.paintRect(45,345,1);
foodimage WM5=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/WM5.png");
WM5.set5();
this.getLayeredPane().add(panel5,Integer.valueOf(2));
this.getLayeredPane().add(WM5,Integer.valueOf(4));
JPanel panel6=this.paintRect(270,345,1);
foodimage Apple6=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/apple6.png");
Apple6.set6();
this.getLayeredPane().add(panel6,Integer.valueOf(2));
this.getLayeredPane().add(Apple6,Integer.valueOf(4));
JPanel panel7=this.paintRect(495,345,1);
    //panel7.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.PINK));
foodimage Hotdog7=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/hotdog7.png");
this.getLayeredPane().add(panel7,Integer.valueOf(2));
this.getLayeredPane().add(Hotdog7,Integer.valueOf(4));
Hotdog7.set7();
JPanel panel8=this.paintRect(720,345,1);
foodimage French8=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/French fries8.png");
French8.set8();
this.getLayeredPane().add(panel8,Integer.valueOf(2));
this.getLayeredPane().add(French8,Integer.valueOf(4));
//按钮
newfoodButton Coffee=new newfoodButton("Coffee",1,"$2");
Coffee.set1();
newfoodButton Cola=new newfoodButton("Cola",1,"$3");
Cola.set2();
newfoodButton Beer=new newfoodButton("Beer",1,"$4");
Beer.set3();
newfoodButton Juice=new newfoodButton("Juice",1,"$2.5");
Juice.set4();
newfoodButton WM=new newfoodButton("WaterMelon",1,"$1.5");
WM.set5();
newfoodButton Apple=new newfoodButton("Apple",1,"2.5");
Apple.set6();
newfoodButton Hotdog=new newfoodButton("Hotdog",1,"$3");
Hotdog.set7();
newfoodButton French=new newfoodButton("French Fires",1,"$2.9");
French.set8();

this.getLayeredPane().add(Coffee,Integer.valueOf(3));
this.getLayeredPane().add(Cola,Integer.valueOf(3));
this.getLayeredPane().add(Beer,Integer.valueOf(3));
this.getLayeredPane().add(Juice,Integer.valueOf(3));
this.getLayeredPane().add(WM,Integer.valueOf(3));
this.getLayeredPane().add(Apple,Integer.valueOf(3));
this.getLayeredPane().add(Hotdog,Integer.valueOf(3));
this.getLayeredPane().add(French,Integer.valueOf(3));

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
    ChooseFoodExtra o=new ChooseFoodExtra();
    o.setVisible(true);
}

}