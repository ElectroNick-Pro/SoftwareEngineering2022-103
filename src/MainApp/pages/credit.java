package MainApp.pages;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import MainApp.GlobalData;
import MainApp.pages.components.RoundBorder;

import MainApp.models.Model.UserModel.*;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.*;
public class credit extends JFrame implements ActionListener{
    
/*
    JFrame newJFrame = new JFrame();

    newJFrame.setSize(250, 250);
    newJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    // 窗口设置为不可改变大小
    newJFrame.setResizable(false);

    JPanel panel = new JPanel(null);
    newFrame.add(panel);
*/
    // 在新窗口中显示一个标签
    JLabel label = new JLabel("Please enter your credit card number:");
    JLabel label2 = new JLabel("Please enter your password:");
    JButton btn = new JButton("OK");
    
    public String id = (String)((Customer)GlobalData.data.get("customer")).creditId.getValue();
    public String password = (String)((Customer)GlobalData.data.get("customer")).password.getValue();
    //int cFlag = 0;
    //boolean flag;
    protected JFrame frame;
    static JTextField creditF = new JTextField(10);
    static JTextField passF = new JTextField(10);
    credit(){
        super();
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        this.add(creditF);
        this.add(passF);
        creditF.setBounds(46,80,425,42);
        creditF.setBorder(BorderFactory.createLineBorder(new Color(0,131,255)));
        passF.setBounds(46,180,425,42);
        passF.setBorder(BorderFactory.createLineBorder(new Color(0,131,255)));
        panel.add(btn);
        btn.addActionListener(this);
        btn.setFont(new Font(null, Font.PLAIN, 15));
        btn.setForeground(Color.white);
        btn.setBackground(new Color(0,131,255));
        btn.setBorder(new RoundBorder(new Color(30, 144, 255)));
        btn.setBounds(398,240,78,30);
        this.add(label);
        label2.setBounds(46,137,436,35);
        label2.setFont(new Font(null, Font.PLAIN, 18));
        this.add(label2);
        label.setFont(new Font(null, Font.PLAIN, 18));
        label.setBounds(46,40,436,35);}
        private String String(String string) {
        return string;
    }
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            if(cmd.equals("OK")){
                String creditText = creditF.getText().toString();
                String passText = passF.getText().toString();
                if(id.equals(creditText)&&password.equals(passText)){
                    this.setVisible(false);
                    OK frame = new OK();
                    frame.setSize(515,313);
                    frame.setBackground(Color.WHITE);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
            }else{
            creditF.setText("");
            passF.setText("");
            }
        }         
    }
    
    public static void main(String args[]){
        final credit frame = new credit();
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(515,313);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
}