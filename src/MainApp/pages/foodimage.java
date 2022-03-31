package MainApp.pages;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class foodimage extends JLabel{

public foodimage(String location){
    //this.setBounds(x,y,50,50);
    this.setSize(50,50);
    this.setBackground(Color.WHITE);
    ImageIcon image=new ImageIcon(location);
    this.setIcon(image);
    this.setOpaque(false);
}

public void set1(){
this.setBounds(115, 183, 50, 50);
}

public void set2(){
    this.setBounds(337, 183, 50, 50);
    }

    public void set3(){
        this.setBounds(563, 183, 50, 50);
        }

        public void set4(){
            this.setBounds(788, 183, 50, 50);
            }

            public void set5(){
                this.setBounds(115, 330, 50, 50);
                }

                public void set6(){
                    this.setBounds(337, 330, 50, 50);
                    }

                    public void set7(){
                        this.setBounds(563, 330, 50, 50);
                        }

                        public void set8(){
                            this.setBounds(788, 330, 50, 50);
                            }
}