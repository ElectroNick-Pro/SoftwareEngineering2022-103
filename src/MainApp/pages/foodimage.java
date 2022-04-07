package MainApp.pages;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

class foodimage extends JLabel{

public foodimage(URL location){
    //this.setBounds(x,y,50,50);
    this.setSize(50,50);
    this.setBackground(Color.WHITE);
    ImageIcon image=new ImageIcon(location);
    this.setIcon(image);
    this.setOpaque(false);
}

public void set1(){
this.setBounds(115, 153, 50, 50);
}

public void set2(){
    this.setBounds(337, 153, 50, 50);
    }

    public void set3(){
        this.setBounds(563, 153, 50, 50);
        }

        public void set4(){
            this.setBounds(788, 153, 50, 50);
            }

            public void set5(){
                this.setBounds(115, 300, 50, 50);
                }

                public void set6(){
                    this.setBounds(337, 300, 50, 50);
                    }

                    public void set7(){
                        this.setBounds(563, 300, 50, 50);
                        }

                        public void set8(){
                            this.setBounds(788, 300, 50, 50);
                            }
}