package MainApp.pages;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;


class ChooseFoodtemplate extends JLayeredPane{

    Font Bigfont=new Font("Microsoft YaHei UI",Font.BOLD,40);
    Font Middlefont=new Font("Microsoft YaHei UI",Font.PLAIN,20);
    Font Smallfont=new Font("Microsoft YaHei UI",Font.BOLD,15);
    JLabel ok=new JLabel(new ImageIcon("src/MainApp/pages/image/success1.png"));
    JLabel Food1=new JLabel();
//constructer
public ChooseFoodtemplate(){

    ImageIcon home=new ImageIcon("src/MainApp/pages/image/exit1.png"); 
    JButton Home=new JButton(home);
    Home.setBounds(40,40,40,40);
    Home.setBorderPainted(false);
    Home.setBackground(Color.WHITE);
    Home.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            //dispose();
        }
    });

    Food1.setBounds(45,75,400,50);
    Food1.setFont(Bigfont);
    Food1.setBackground(Color.WHITE);

    JLabel Please=new JLabel("Please choose a type of food you prefer:");
    Please.setFont(Middlefont);
    Please.setBounds(45,126,500,34);
    Please.setBackground(Color.WHITE);

    JButton Back=new JButton("back");
    Back.setBackground(new Color(191,191,191));
    Back.setForeground(Color.WHITE);
    Back.setFont(Smallfont);
    Back.setBounds(25,490,75,30);

    /*JButton Next=new JButton("next");
    Next.setBackground(new Color(0,131,255));
    Next.setForeground(Color.WHITE);
    Next.setFont(Smallfont);
    Next.setBounds(860,490,75,30);
    Next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        ChooseFoodExtra extrafood=new ChooseFoodExtra();
        extrafood.setVisible(true); }
        }
        );*/
    JPanel whitepanel=new JPanel();
    whitepanel.setSize(960, 540);
    whitepanel.setBackground(Color.WHITE);

    
    this.add(whitepanel,-1);
    //this.add(Home,0);
    //this.add(Help,0);
    this.add(Food1,0);
    this.add(Please,0);
    //this.add(Back,0);
    //this.getLayeredPane().add(Next,0);
    ok.setVisible(false);
    //ok.setVisible(true);
    ok.setBounds(100,100,50,50);
    this.add(ok,Integer.valueOf(5));
    this.setBackground(Color.WHITE);
    this.setSize(960,540);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //绘制框框（我抄）
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
    public void Titleset(String Welcome){
        Food1.setText(Welcome);
    }
    public static void main(String[] args){
        ChooseFoodtemplate t=new ChooseFoodtemplate();
        t.setVisible(true);
    }
}