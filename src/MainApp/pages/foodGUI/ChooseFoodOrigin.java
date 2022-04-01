package MainApp.pages.foodGUI;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class ChooseFoodOrigin extends ChooseFoodtemplate{


//constructer**************************************************
public ChooseFoodOrigin(){

	JButton Next=new JButton("NEXT");
	Next.setBackground(new Color(0,131,255));
	Next.setForeground(Color.WHITE);
	Next.setFont(Smallfont);
	Next.setBounds(860,490,75,30);
	Next.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		ChooseFoodExtra extrafood=new ChooseFoodExtra();
		extrafood.setVisible(true);
	}
		}
		);
		this.add(Next,0);

	this.Titleset("Choose Food");
//框框*****************************************

JPanel panel1=this.paintRect(45,200,0);
foodimage standard1=new foodimage("src/MainApp/pages/image/Standard1.png");
standard1.set1();
this.add(panel1,Integer.valueOf(2));
this.add(standard1,Integer.valueOf(4));

JPanel panel2=this.paintRect(270,200,0);
foodimage vegan2=new foodimage("src/MainApp/pages/image/Vegan2.png");
vegan2.set2();
this.add(panel2,Integer.valueOf(2));
this.add(vegan2,Integer.valueOf(4));

JPanel panel3=this.paintRect(495,200,1);
foodimage hum3=new foodimage("src/MainApp/pages/image/Humbergur3.png");
hum3.set3();
this.add(panel3,Integer.valueOf(2));
this.add(hum3,Integer.valueOf(4));

JPanel panel4=this.paintRect(720,200,1);
foodimage beef4=new foodimage("src/MainApp/pages/image/Beefsteak4.png");
beef4.set4();
this.add(panel4,Integer.valueOf(2));
this.add(beef4,Integer.valueOf(4));

JPanel panel5=this.paintRect(45,345,0);
foodimage halal5=new foodimage("src/MainApp/pages/image/Halal5.png");
halal5.set5();
this.add(panel5,Integer.valueOf(2));
this.add(halal5,Integer.valueOf(4));

JPanel panel6=this.paintRect(270,345,0);
foodimage child6=new foodimage("src/MainApp/pages/image/child6.png");
child6.set6();
this.add(panel6,Integer.valueOf(2));
this.add(child6,Integer.valueOf(4));

JPanel panel7=this.paintRect(495,345,1);
    //panel7.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.PINK));
foodimage seafood7=new foodimage("src/MainApp/pages/image/Seafood7.png");
this.add(panel7,Integer.valueOf(2));
this.add(seafood7,Integer.valueOf(4));
seafood7.set7();

JPanel panel8=this.paintRect(720,345,1);
foodimage lowsugar8=new foodimage("src/MainApp/pages/image/Lowsugar8.png");
lowsugar8.set8();
this.add(panel8,Integer.valueOf(2));
this.add(lowsugar8,Integer.valueOf(4));


//按钮*******************************
newfoodButton Standard=new newfoodButton("Standard",0,null);
Standard.set1();
Standard.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(46,201,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton Vegan=new newfoodButton("Vegetarian",0,null);
Vegan.set2();
Vegan.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(271,201,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton Humbergur=new newfoodButton("Humbergur",1,"$5");
Humbergur.set3();
Humbergur.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(496,201,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton BeefSteak=new newfoodButton("BeefSteak",1,"$12");
BeefSteak.set4();
BeefSteak.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(721,201,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton Halal=new newfoodButton("Halal",0,null);
Halal.set5();
Halal.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(46,346,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton Children=new newfoodButton("Children",0,null);
Children.set6();
Children.set6();
Children.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(271,346,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton Seafood=new newfoodButton("Seafood",1,"$8");
Seafood.set7();
Seafood.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(496,346,50,50);
    ok.setVisible(true); }
	}
	);
newfoodButton Lowsugar=new newfoodButton("Low Sugar",1,"$4");
Lowsugar.set8();
Lowsugar.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ok.setVisible(false);
    ok.setBounds(721,346,50,50);
    ok.setVisible(true); }
	}
	);
/*JLayeredPane choice=new JLayeredPane();
choice.setBackground(Color.WHITE);
choice.add(Lowsugar,Integer.valueOf(3));
choice.setSize(960,540);
this.add(choice,4);*/

/*this.getLayeredPane().add(Standard,Integer.valueOf(3));
this.getLayeredPane().add(Vegan,Integer.valueOf(3));
this.getLayeredPane().add(Humbergur,Integer.valueOf(3));
this.getLayeredPane().add(BeefSteak,Integer.valueOf(3));
this.getLayeredPane().add(Halal,Integer.valueOf(3));
this.getLayeredPane().add(Children,Integer.valueOf(3));
this.getLayeredPane().add(Seafood,Integer.valueOf(3));
this.getLayeredPane().add(Lowsugar,Integer.valueOf(3));*/
this.add(Standard,3);
this.add(Vegan,3);
this.add(Humbergur,3);
this.add(BeefSteak,3);
this.add(Halal,3);
this.add(Children,3);
this.add(Seafood,3);
this.add(Lowsugar,3);

JPanel shadow3=shade(520,210);
this.add(shadow3,Integer.valueOf(1));
JPanel shadow4=shade(745,210);
this.add(shadow4,Integer.valueOf(1));
JPanel shadow7=shade(520,355);
this.add(shadow7,Integer.valueOf(1));
JPanel shadow8=shade(745,355);
this.add(shadow8,Integer.valueOf(1));

}

public static void main(String[] args){
    ChooseFoodOrigin o=new ChooseFoodOrigin();
    o.setVisible(true);
}

}