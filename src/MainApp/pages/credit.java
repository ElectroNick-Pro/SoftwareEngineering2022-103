package MainApp.pages;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import MainApp.GlobalData;
import MainApp.pages.components.RoundBorder;
import MainApp.models.Field.*;
import MainApp.models.Model.UserModel.*;

import javax.swing.*;

import java.awt.*;

public class credit extends JFrame implements ActionListener {

    /*
     * JFrame newJFrame = new JFrame();
     * 
     * newJFrame.setSize(250, 250);
     * newJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
     * 
     * // 窗口设置为不可改变大小
     * newJFrame.setResizable(false);
     * 
     * JPanel panel = new JPanel(null);
     * newFrame.add(panel);
     */
    // 在新窗口中显示一个标签
    JLabel label = new JLabel("Please enter your credit card number:");
    JLabel label2 = new JLabel("Please enter your password:");
    JButton btn = new JButton("OK");
    public Customer customer = (Customer) GlobalData.data.get("customer");
    public String id = (String)customer.creditId.getValue();
    public PasswordField password = (PasswordField)customer.password;
    // int cFlag = 0;
    // boolean flag;
    protected JFrame frame;
    static JTextField creditF = new JTextField(10);
    static JPasswordField passF = new JPasswordField(10);

    credit() {
        super();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        this.add(creditF);
        this.add(passF);
        creditF.setBounds(46, 80, 425, 42);
        creditF.setBorder(BorderFactory.createLineBorder(new Color(0, 131, 255)));
        passF.setBounds(46, 180, 425, 42);
        passF.setBorder(BorderFactory.createLineBorder(new Color(0, 131, 255)));
        panel.add(btn);
        btn.addActionListener(this); 
        
        btn.setFont(new Font(null, Font.PLAIN, 15));
        btn.setForeground(Color.white);
        btn.setBackground(new Color(0, 131, 255));
        btn.setBorder(new RoundBorder(new Color(30, 144, 255)));
        btn.setBounds(398, 240, 78, 30);
        this.add(label);
        label2.setBounds(46, 137, 436, 35);
        label2.setFont(new Font(null, Font.PLAIN, 18));
        this.add(label2);
        label.setFont(new Font(null, Font.PLAIN, 18));
        label.setBounds(46, 40, 436, 35);
        JButton qr = new JButton();
        qr.setFont(new Font(null, Font.PLAIN, 15));
        qr.setForeground(Color.white);
        qr.setBackground(new Color(0, 131, 255));
        qr.setBorder(new RoundBorder(new Color(30, 144, 255)));
        qr.setBounds(300, 240, 78, 30);
    qr.setText("QRcode");
    this.add(qr);
    qr.addActionListener(this);
    }
    public void actionPerformed2(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("QRcode")){
            code frame = new code();
            frame.setBackground(Color.WHITE);
            frame.setSize(515, 313);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            this.dispose();
        } 
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("OK")) {
            String creditText = creditF.getText();
            String passText = passF.getText();
            if (id.equals(creditText) && password.equals(passText)) {
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
            } else {
                creditF.setText("");
                passF.setText("");
                passF.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }
    }

    public static void main(String args[]) {
        final credit frame = new credit();
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(515, 313);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}