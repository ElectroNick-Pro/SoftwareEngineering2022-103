package MainApp.pages;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class setIcon {
    public setIcon(){

    }
    public void changeIconSize(URL file, JButton btn, int width, int height){
        ImageIcon icon = new ImageIcon(file);
        Image temp = icon.getImage().getScaledInstance(width,height, icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        btn.setIcon(icon);
    }
	
}
