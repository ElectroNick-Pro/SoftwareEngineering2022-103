package MainApp.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import MainApp.pages.components.RoundBorder;
import java.nio.file.Path;
import MainApp.pages.Exception.UnboundPageException;

public class OK extends JFrame {
    

    public OK(){
        JFrame successF = this;
        successF.setSize(480,185);
        successF.setBackground(Color.WHITE);
        successF.setLocationRelativeTo(null);
        successF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successF.setResizable(false);
        JPanel panel = new JPanel(null);
        JLabel label = new JLabel("You Have Paid Successfully!");
        label.setBounds(140,44,290,50);
        label.setFont(new Font("Microsoft YaHei", Font.PLAIN,21));
        ImageIcon m =new ImageIcon(ClassLoader.getSystemClassLoader().getResource("MainApp/pages/image/success.png"));
        m.setImage(m.getImage().getScaledInstance(50,50,1));
        JLabel label2 = new JLabel(m);
        label2.setBounds(25,30,75,75);
        JButton btn = new JButton("OK");
        btn.setBounds(355,95,75,30);
        btn.setBackground(new Color(30, 144, 255));
        btn.setForeground(Color.WHITE);
        btn.setBorder(new RoundBorder(new Color(30, 144, 255)));
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn) {
                    dispose();
                }
            }
        });
        panel.add(label);
        panel.add(label2);
        successF.setContentPane(panel);
        successF.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                new confirmPrint();
                try {
                    Pages.displayPage(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Print"));
                } catch (UnboundPageException e1) {
                    e1.printStackTrace();
                }
            }
            
        });
        successF.setVisible(true);
    }
    public static void main(String args[]){
        final OK frame = new OK();
    //     frame.setBackground(Color.WHITE);
    //     frame.setVisible(true);
    //    frame.setSize(515,313);
    //    frame.setLocationRelativeTo(null);
    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
