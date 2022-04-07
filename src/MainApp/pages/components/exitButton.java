package MainApp.pages.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

import MainApp.pages.Pages;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.GlobalData;
import MainApp.pages.Retrieve;

public class exitButton extends JButton implements ActionListener{
    public exitButton(){
        super();
        ImageIcon exitIcon = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/exit.png"));
        exitIcon.setImage(exitIcon.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        this.setIcon(exitIcon);
        this.setBackground(Color.WHITE);
        this.setBorder(null);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit? If so, your choices will not be saved.", "Confirm", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            Retrieve.bookingIdField.setText("");
            // Global Data
            try {
                Pages.displayPage(Path.of("Retrieve"));
            } catch (UnboundPageException e1) {
                e1.printStackTrace();
            }   
        }
    }
}
