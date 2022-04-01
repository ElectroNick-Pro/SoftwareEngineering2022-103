package MainApp.pages;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import MainApp.GlobalData;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.UserModel.Food;
import MainApp.pages.Exception.UnboundPageException;

class ChooseFoodDessert extends ChooseFoodtemplate{

String[] dessertchoice=new  String[]{"0","0","0"};

//constructer
public ChooseFoodDessert(){




this.Titleset("Choose Dessert");

JButton Back=new JButton("BACK");
Back.setBackground(new Color(191,191,191));
Back.setForeground(Color.WHITE);
Back.setFont(Smallfont);
Back.setBounds(25,490,75,30);
this.add(Back,Integer.valueOf(4));

JButton Next=new JButton("NEXT");
Next.setBackground(new Color(0,131,255));
Next.setForeground(Color.WHITE);
Next.setFont(Smallfont);
Next.setBounds(860,490,75,30);
Next.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	//Next 后面指向哪里？
 }
	}
	);
this.add(Next,Integer.valueOf(4));
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
foodimage Rice7=new foodimage("src/MainApp/pages/image/rice ball7.png");
this.add(panel7,Integer.valueOf(2));
this.add(Rice7,Integer.valueOf(4));
Rice7.set7();
JPanel panel8=this.paintRect(720,345,1);
foodimage Sushi8=new foodimage("src/MainApp/pages/image/sushi8.png");
Sushi8.set8();
this.add(panel8,Integer.valueOf(2));
this.add(Sushi8,Integer.valueOf(4));

//按钮*****************************************************
newfoodButton Doughnut=new newfoodButton("Doughnut",1,"$2");
Doughnut.set1();   
Doughnut.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(46,201,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Dought","2","dessert"};    
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Bread=new newfoodButton("Bread",1,"$1");
Bread.set2();
Bread.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(271,201,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Bread","1","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Chocolate=new newfoodButton("Chocolate",1,"$6");
Chocolate.set3();
Chocolate.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(496,201,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Chocolate","6","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Biscuit=new newfoodButton("Biscuit",1,"$3.3");
Biscuit.set4();
Biscuit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(721,201,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Biscuit","3.3","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Pudding=new newfoodButton("Pudding",1,"$2.5");
Pudding.set5();
Pudding.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(46,346,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Pudding","2.5","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Lollipop=new newfoodButton("Lollipop",1,"1.5");
Lollipop.set6();
Lollipop.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(271,346,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Lollipop","1.5","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Riceball=new newfoodButton("Rice Ball",1,"$5");
Riceball.set7();
Riceball.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(496,346,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Rice Ball","5","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);
newfoodButton Sushi=new newfoodButton("Sushi",1,"$7");
Sushi.set8();
Sushi.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
        ok.setVisible(false);
        ok.setBounds(721,346,50,50);
        ok.setVisible(true); 
    dessertchoice=new String[]{"Sushi","7","dessert"};      
    System.out.println(dessertchoice[0].toString());                                  
	}
}
	);

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

//选完了************************************************************************************
String[] dessertinfo=new String[]{"1","1",dessertchoice[0],dessertchoice[1],dessertchoice[2]};


this.setSize(960,540);
}

public static void main(String[] args){
    ChooseFoodDessert o=new ChooseFoodDessert();
    o.setVisible(true);
}

}