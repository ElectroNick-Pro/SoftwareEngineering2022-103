package MainApp.pages.foodGUI;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class newfoodButton extends JButton{

//Font font=new Font("Serief",Font.BOLD,25);

    public newfoodButton(String name,int x,String value){
    this.setSize(100,100);
    this.setBorderPainted(false);
    this.setBackground(Color.WHITE);
    this.setOpaque(false);
    //this.setFont(font);
    //name="food<font color='#FF0000'>good</font>";
    if(x==0)
    {this.setText("<html><big>"+name+"</big><br>"+"    "+"<font style='italic'> <font color='#0083FF'><font size='5'>FREE</font></font></font></html>");}
    else{
        String Value="<font color='#FF0066'>"+value+"</font>"+"</html>";
        this.setText("<html><big>"+name+"</big><br>"+"<font size='5'>"+Value+"</font></html>");
    }
    this.setHorizontalTextPosition(0);
    this.setVerticalTextPosition(0);
    //ImageIcon image=new ImageIcon(location);
    //this.setIcon(image);

    }

    public void set1(){
        this.setBounds(46,201,193,122);
    }
    public void set2(){
        this.setBounds(271,201,193,122);
    }
    public void set3(){
        this.setBounds(496,201,193,122);
    }
    public void set4(){
        this.setBounds(721,201,193,122);
    }
    public void set5(){
        this.setBounds(46,346,193,122);
    }
    public void set6(){
        this.setBounds(271,346,193,122);
    }
    public void set7(){
        this.setBounds(496,346,193,122);
    }
    public void set8(){
        this.setBounds(721,346,193,122);
    }
}