package MainApp.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class OK extends JFrame {
    

    public OK(){
        JFrame successF = new JFrame();
        successF.setSize(480,185);
        successF.setBackground(Color.WHITE);
        successF.setLocationRelativeTo(null);
        successF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        successF.setResizable(false);
        JPanel panel = new JPanel(null);
        JLabel label = new JLabel("You Have Paid Successfully!");
        label.setBounds(140,44,290,50);
        label.setFont(new Font("Microsoft YaHei", Font.PLAIN,21));
        ImageIcon m =new ImageIcon("src/MainApp/pages/image/success.png");
        m.setImage(m.getImage().getScaledInstance(50,50,1));//这里设置图片大小，目前是20*20
        JLabel label2 = new JLabel(m);
        label2.setBounds(25,30,75,75);
        JButton btn = new JButton("OK");
        btn.setBounds(355,95,75,30);
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmPrint f =new confirmPrint();
f.setVisible(true);
successF.setVisible(false);

            }
        });
        panel.add(label);
        panel.add(label2);
        successF.setContentPane(panel);
        successF.setVisible(true);
    }
    public static void main(String args[]){
        final OK frame = new OK();
        //frame.setBackground(Color.WHITE);
        //frame.setVisible(true);
       // frame.setSize(515,313);
       // frame.setLocationRelativeTo(null);
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }


}
