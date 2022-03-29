package MainApp.pages.foodGUI;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class ChooseFoodOrigin extends ChooseFoodtemplate{

/*Font Bigfont=new Font("Serief",Font.BOLD,40);
Font Middlefont=new Font("Serief",Font.PLAIN,20);
Font Smallfont=new Font("Serief",Font.BOLD+Font.ITALIC,10);
//constructer*/
public ChooseFoodOrigin(){

/*ImageIcon home=new ImageIcon("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/exit1.png"); 
JButton Home=new JButton(home);
Home.setBounds(40,40,40,40);
Home.setBorderPainted(false);
Home.setBackground(Color.WHITE);

ImageIcon help=new ImageIcon("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/help2.png");
JButton Help=new JButton(help);
Help.setBounds(880,40,40,40);
Help.setBorderPainted(false);
Help.setBackground(Color.WHITE);

JLabel Food=new JLabel("Choose Food");
Food.setBounds(45,105,300,50);
Food.setFont(Bigfont);
Food.setBackground(Color.WHITE);

JLabel Please=new JLabel("Please choose a type of food you prefer:");
Please.setFont(Middlefont);
Please.setBounds(45,156,500,34);
Please.setBackground(Color.WHITE);

JButton Back=new JButton("BACK");
Back.setBackground(new Color(191,191,191));
Back.setForeground(Color.WHITE);
Back.setFont(Smallfont);
Back.setBounds(25,490,75,30);

JButton Next=new JButton("NEXT");
Next.setBackground(new Color(0,131,255));
Next.setForeground(Color.WHITE);
Next.setFont(Smallfont);
Next.setBounds(860,490,75,30);
Next.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ChooseFoodExtra extrafood=new ChooseFoodExtra();
    extrafood.setVisible(true); }
	}
	);
JPanel whitepanel=new JPanel();
whitepanel.setSize(960, 540);
whitepanel.setBackground(Color.WHITE);

 
this.getLayeredPane().add(whitepanel,-1);
this.getLayeredPane().add(Home,0);
this.getLayeredPane().add(Help,0);
this.getLayeredPane().add(Food,0);
this.getLayeredPane().add(Please,0);
this.getLayeredPane().add(Back,0);
this.getLayeredPane().add(Next,0);
this.setBackground(Color.WHITE);
*/
JButton Next=new JButton("NEXT");
Next.setBackground(new Color(0,131,255));
Next.setForeground(Color.WHITE);
Next.setFont(Smallfont);
Next.setBounds(860,490,75,30);
Next.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	ChooseFoodExtra extrafood=new ChooseFoodExtra();
    extrafood.setVisible(true); }
	}
	);
    this.getLayeredPane().add(Next,0);
//框框
JPanel panel1=this.paintRect(45,200,0);
foodimage standard1=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Standard1.png");
standard1.set1();
this.getLayeredPane().add(panel1,Integer.valueOf(2));
this.getLayeredPane().add(standard1,Integer.valueOf(4));
JPanel panel2=this.paintRect(270,200,0);
foodimage vegan2=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Vegan2.png");
vegan2.set2();
this.getLayeredPane().add(panel2,Integer.valueOf(2));
this.getLayeredPane().add(vegan2,Integer.valueOf(4));
JPanel panel3=this.paintRect(495,200,1);
foodimage hum3=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Humbergur3.png");
hum3.set3();
this.getLayeredPane().add(panel3,Integer.valueOf(2));
this.getLayeredPane().add(hum3,Integer.valueOf(4));
JPanel panel4=this.paintRect(720,200,1);
foodimage beef4=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Beefsteak4.png");
beef4.set4();
this.getLayeredPane().add(panel4,Integer.valueOf(2));
this.getLayeredPane().add(beef4,Integer.valueOf(4));
JPanel panel5=this.paintRect(45,345,0);
foodimage halal5=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Halal5.png");
halal5.set5();
this.getLayeredPane().add(panel5,Integer.valueOf(2));
this.getLayeredPane().add(halal5,Integer.valueOf(4));
JPanel panel6=this.paintRect(270,345,0);
foodimage child6=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/child6.png");
child6.set6();
this.getLayeredPane().add(panel6,Integer.valueOf(2));
this.getLayeredPane().add(child6,Integer.valueOf(4));
JPanel panel7=this.paintRect(495,345,1);
    //panel7.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.PINK));
foodimage seafood7=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Seafood7.png");
this.getLayeredPane().add(panel7,Integer.valueOf(2));
this.getLayeredPane().add(seafood7,Integer.valueOf(4));
seafood7.set7();
JPanel panel8=this.paintRect(720,345,1);
foodimage lowsugar8=new foodimage("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Lowsugar8.png");
lowsugar8.set8();
this.getLayeredPane().add(panel8,Integer.valueOf(2));
this.getLayeredPane().add(lowsugar8,Integer.valueOf(4));
//按钮
newfoodButton Standard=new newfoodButton("Standard",0,null);
Standard.set1();
newfoodButton Vegan=new newfoodButton("Vegetarian",0,null);
Vegan.set2();
newfoodButton Humbergur=new newfoodButton("Humbergur",1,"$5");
Humbergur.set3();
newfoodButton BeefSteak=new newfoodButton("BeefSteak",1,"$12");
BeefSteak.set4();
newfoodButton Halal=new newfoodButton("Halal",0,null);
Halal.set5();
newfoodButton Children=new newfoodButton("Children",0,null);
Children.set6();
newfoodButton Seafood=new newfoodButton("Seafood",1,"$8");
Seafood.set7();
newfoodButton Lowsugar=new newfoodButton("Low Sugar",1,"$4");
Lowsugar.set8();
//JButton Lowsugar=new JButton("111",new ImageIcon("D:/Coursework/software-engineering2022-103/src/MainApp/pages/image/Seafood7.jpg"));
//Lowsugar.setBounds(721, 346, 193, 122);
this.getLayeredPane().add(Standard,Integer.valueOf(3));
this.getLayeredPane().add(Vegan,Integer.valueOf(3));
this.getLayeredPane().add(Humbergur,Integer.valueOf(3));
this.getLayeredPane().add(BeefSteak,Integer.valueOf(3));
this.getLayeredPane().add(Halal,Integer.valueOf(3));
this.getLayeredPane().add(Children,Integer.valueOf(3));
this.getLayeredPane().add(Seafood,Integer.valueOf(3));
this.getLayeredPane().add(Lowsugar,Integer.valueOf(3));

JPanel shadow3=shade(520,210);
this.getLayeredPane().add(shadow3,Integer.valueOf(1));
JPanel shadow4=shade(745,210);
this.getLayeredPane().add(shadow4,Integer.valueOf(1));
JPanel shadow7=shade(520,355);
this.getLayeredPane().add(shadow7,Integer.valueOf(1));
JPanel shadow8=shade(745,355);
this.getLayeredPane().add(shadow8,Integer.valueOf(1));
//this.setSize(960,540);
//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
/*//绘制框框（我抄）
public JPanel paintRect(int x,int y,int i){
    final Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 131, 255, 100),
			getWidth(), getHeight(), new Color(0, 131, 255, 200), true);
            JPanel panel=new JPanel(){
                public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(p);
				// 设置画笔颜色为白色
				g2d.setColor(new Color(255,255,255));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				
				// 设置画笔颜色为灰色
                if(i==0)
				{g2d.setColor(new Color(211,211,211));}
                else{
                    g2d.setColor(new Color(98,206,242));  
                }
				Shape shape = null;
				shape = new RoundRectangle2D.Double(0, 0, 194, 123, 6.5D, 6.5D);
				g2d.draw(shape);	
                }	
            };
            panel.setBackground(Color.WHITE);
            panel.setBounds(x,y,195,124);
            return panel;
}
//绘制阴影
public JPanel shade(int x,int y){
    final Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 131, 255, 100),
    getWidth(), getHeight(), new Color(0, 131, 255, 200), true);

    JPanel panel=new JPanel(){
       public void paintComponent(Graphics g){
            Graphics2D g2d=(Graphics2D)g;
            g2d.setPaint(p);
            for(int i=194;i>0;i--){
               
                double opacity=i;
                //System.out.println(opcity);
                //int opacity=50;
g2d.setColor(new Color(98,206,242,(int)opacity));
Shape shape = new RoundRectangle2D.Double(0, 0, 194-i, 122, 6.5D, 6.5D);
g2d.draw(shape);
                
        }
    }
};
    //panel.setOpaque(false);
    panel.setBackground(Color.WHITE);
panel.setBounds(x,y,194,122);
panel.setBorder(null);
    return panel;
} 
*/
public static void main(String[] args){
    ChooseFoodOrigin o=new ChooseFoodOrigin();
    o.setVisible(true);
}

}