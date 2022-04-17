package MainApp.pages;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import MainApp.GlobalData;
import MainApp.pages.components.RoundBorder;
import MainApp.models.Field.*;
import MainApp.models.Model.UserModel.*;

import javax.swing.*;
import javax.swing.ImageIcon;


import java.awt.*;

public class code extends JFrame implements ActionListener {
  
    JButton btn = new JButton("OK");
    public Customer customer = (Customer) GlobalData.data.get("customer");
    protected JFrame frame;
    code() {
        super();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        ImageIcon p =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/code.png"));
        p.setImage(p.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
        JLabel label = new JLabel(p);
        label.setBounds(40,20,150,150);
        this.add(label);
        
    panel.add(btn);
    btn.addActionListener(this); 
        
    btn.setFont(new Font(null, Font.PLAIN, 15));
    btn.setForeground(Color.white);
    btn.setBackground(new Color(0, 131, 255));
    btn.setBorder(new RoundBorder(new Color(30, 144, 255)));
    btn.setBounds(398, 240, 78, 30);
    
        }
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("OK")) {
                var ticket = (Ticket)GlobalData.data.get("ticket");
                ticket.isCheckin.setValue(1);
                ticket.save();
                ((Seat)GlobalData.data.get("seat")).save();
                var extraFoodMap = (HashMap<Integer, FoodPurchase>)GlobalData.data.get("foodInfo");
                for(var entry: extraFoodMap.entrySet()){
                        var tuple = entry.getValue();
                        tuple.ticket.setValue(((Ticket)GlobalData.data.get("ticket")).id);
                        tuple.save();
                    }
                     OK frame = new OK();
                    frame.setSize(480, 185);
                    frame.setBackground(Color.WHITE);
                    frame.setLocationRelativeTo(null);
                    this.dispose();
                
                }
            } 
    

    public static void main(String args[]) {
        final code frame = new code();
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(515, 313);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}