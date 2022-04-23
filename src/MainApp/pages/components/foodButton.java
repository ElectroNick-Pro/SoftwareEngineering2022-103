package MainApp.pages.components;
import javax.swing.*;
import java.awt.*;

public class foodButton extends JButton{

    public int id;
    
    public foodButton(String name,String price, int id){
        this.id = id;
        this.setSize(200,200);
        this.setBorderPainted(false);
        this.setBackground(Color.WHITE);
        this.setOpaque(false);
        if(price.equals("$0.0"))
        {
            this.setText("<html><big>"+name+"</big><br>"+"    "+"<p align='center'><font style='italic'><font color='#0083FF'><font size='5'>FREE</font></font></font></p></html>");}
        else{
            String Value="<font color='#E22525'>"+price+"</font>"+"</html>";
            this.setText("<html><p align='center'><big>"+name+"</big></p>"+"<p align='center'><font size='5'>"+Value+"</font></p></html>");
        }
        this.setHorizontalTextPosition(0);
        this.setVerticalTextPosition(0);
    }
    public void setLocation(int x,int y,int width,int height){
        this.setBounds(x,y,width,height);
    }
}
