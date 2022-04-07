package MainApp.pages.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class helpButton extends JButton implements ActionListener{
    public helpButton(){
        super();
        ImageIcon helpIcon = new ImageIcon("src/MainApp/image/question.png");
        helpIcon.setImage(helpIcon.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        this.setIcon(helpIcon);
        this.setBackground(Color.WHITE);
        this.setBorder(null);
        this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "We have called manual customer service for you. Please wait for a moment.", "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        helpButton btn = new helpButton();
        frame.setLayout(null);
        btn.setBounds(20,20,40,40);
        frame.add(btn);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(200,200);
    }
}
