package MainApp.pages;
import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import MainApp.pages.Exception.UnboundPageException;
import java.nio.file.Path;
import MainApp.pages.components.BreadCrumbPanel;
import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;


public class FoodPanel extends JFrame{
private Path path = Path.of("page1/page2/page3/page4");
    public FoodPanel(){
    Pages.bindPage(this.path, this);
    JButton Back=new JButton("back");
    Back.setBackground(new Color(191,191,191));
    Back.setForeground(Color.WHITE);
    Back.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
    Back.setBounds(25,460,75,30);
    JButton Next=new JButton("next");
    Next.setBackground(new Color(0,131,255));
    Next.setForeground(Color.WHITE);
    Next.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
    Next.setBorder(new RoundBorder(new Color(30, 144, 255)));
    Next.setBounds(860,460,75,30);
    Next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == Next) {
                new confirmPay();
                    try {
                    Pages.displayPage(Path.of("page1/page2/page3/page4/page5"));
                    } catch (UnboundPageException e1) {
                    e1.printStackTrace();
                    }
                }
            }
        }
    );
      
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
    
        this.getLayeredPane().add(Next,Integer.valueOf(4));
    
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        FoodPanel f=new FoodPanel();
        f.setVisible(true);
    }
    
}