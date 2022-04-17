
package MainApp.pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.Path;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import MainApp.GlobalData;
import MainApp.models.Model.UserModel.Customer;
import MainApp.models.Model.UserModel.FoodPurchase;
import MainApp.models.Model.UserModel.Seat;
import MainApp.models.Model.UserModel.Ticket;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.components.RoundBorder;

public class nopay extends JFrame {
    
    public Customer customer = (Customer) GlobalData.data.get("customer");
    public nopay(){
        JFrame successF = this;
        successF.setSize(480,185);
        successF.setBackground(Color.WHITE);
        successF.setLocationRelativeTo(null);
        successF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successF.setResizable(false);
        JPanel panel = new JPanel(null);
        JLabel label = new JLabel("You have confirmed your bill successfully!");
        label.setBounds(100,44,290,50);
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
                    var ticket = (Ticket)GlobalData.data.get("ticket");
                ticket.isCheckin.setValue(1);
                ticket.save();
                ((Seat)GlobalData.data.get("seat")).save();
                var extraFoodMap = (HashMap<Integer, FoodPurchase>)GlobalData.data.get("foodInfo");
                for(var entry: extraFoodMap.entrySet()){
                    var tuple = entry.getValue();
                    tuple.ticket.setValue(((Ticket)GlobalData.data.get("ticket")).id);
                    tuple.save();
                    dispose();
                }
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
                    Pages.displayPage(Path.of("page1/page2/page3/page4/page5/page6"));
                } catch (UnboundPageException e1) {
                    e1.printStackTrace();
                }
            }
            
        });
        successF.setVisible(true);
    }
    public static void main(String args[]){
        final nopay frame = new nopay();
    //     frame.setBackground(Color.WHITE);
    //     frame.setVisible(true);
    //    frame.setSize(515,313);
    //    frame.setLocationRelativeTo(null);
    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
