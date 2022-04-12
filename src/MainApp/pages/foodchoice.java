package MainApp.pages;

import java.awt.*;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;

import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;
public class foodchoice extends JFrame {
    private String type;
    public foodchoice(String btnType){
        super();
        type = btnType;
        JPanel panel;
        JLayeredPane pane = new JLayeredPane();
        panel = new JPanel(null);
        panel.setLayout(null);
        setContentPane(panel);
        pane = new JLayeredPane();
        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        JLabel label = new JLabel("Details of the food choice");
        label.setBounds(44,18,341,42);
        label.setFont(new Font("Microsoft YaHei", Font.BOLD,25));
        panel.add(label);


        JPanel panelin = new JPanel(null);
        panelin.setBackground(Color.white);
        //panelin.setBounds(42,75,458,303);
        JScrollPane food = new JScrollPane(panelin);
        food.setBounds(34,75,466,303);
        food.setBackground(Color.white);
        food.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
        
        add(food);
        
        ImageIcon ma =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seafood.png"));
        ma.setImage(ma.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panela = new JPanel(null);
        panela.setBounds(15,14,430,85);
        panela.setBackground(Color.white);
        panela.setBorder(new RoundBorder(Color.gray));
        String moa="$10";
        JLabel labela1 = new JLabel(moa);
        labela1.setForeground(Color.red);
        labela1.setBounds(277,30,75,25);
        labela1.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panela.add(labela1);
        String coa="Beefsteak";
        JLabel labela2 = new JLabel(coa);
        labela2.setBounds(122,30,123,21);
        labela2.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panela.add(labela2);
        String an = "1";
        JLabel labelan = new JLabel(an);
        labelan.setForeground(new Color(0,131,255));
        labelan.setBounds(356,30,123,24);
        labelan.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panela.add(labelan);
        JLabel labela3 = new JLabel(ma);
        labela3.setBounds(20,18,50,50);
        panela.add(labela3);
        panelin.add(panela);


        ImageIcon mb =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seafood.png"));
        mb.setImage(mb.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panelb = new JPanel(null);
        panelb.setSize(430,85);
        panelb.setBackground(Color.white);
        panelb.setBorder(new RoundBorder(Color.gray));
        String mob="$2";
        JLabel labelb1 = new JLabel(mob);
        labelb1.setForeground(Color.red);
        labelb1.setBounds(277,30,75,25);
        labelb1.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panelb.add(labelb1);
        String cob="Coffee";
        JLabel labelb2 = new JLabel(cob);
        labelb2.setBounds(122,30,123,21);
        labelb2.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panelb.add(labelb2);
        String bn = "1";
        JLabel labelbn = new JLabel(bn);
        labelbn.setBounds(356,30,123,24);
        labelbn.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        labelbn.setForeground(new Color(0,131,255));
        panelb.add(labelbn);
        JLabel labelb3 = new JLabel(mb);
        labelb3.setBounds(20,18,50,50);
        panelb.add(labelb3);
        panelin.add(panelb);

        ImageIcon mc =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seafood.png"));
        mc.setImage(mc.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panelc = new JPanel(null);
        panelc.setSize(430,85);
        panelc.setBackground(Color.white);
        panelc.setBorder(new RoundBorder(Color.gray));
        String moc="$5";
        JLabel labelc1 = new JLabel(moc);
        labelc1.setForeground(Color.red);
        labelc1.setBounds(277,30,75,25);
        labelc1.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panelc.add(labelc1);
        String coc="RiceBall";
        JLabel labelc2 = new JLabel(coc);
        labelc2.setBounds(122,30,123,21);
        labelc2.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panelc.add(labelc2);
        String cn = "2";
        JLabel labelcn = new JLabel(cn);
        labelcn.setBounds(356,30,123,24);
        labelcn.setForeground(new Color(0,131,255));
        labelcn.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panelc.add(labelcn);
        JLabel labelc3 = new JLabel(mc);
        labelc3.setBounds(20,18,50,50);
        panelc.add(labelc3);
        panelin.add(panelc);
        GroupLayout layout1 = new GroupLayout(panelin);
        GroupLayout.ParallelGroup hparallelGroup = layout1.createParallelGroup().addComponent(panela).addComponent(panelb).addComponent(panelc);
        layout1.setHorizontalGroup(hparallelGroup);
        GroupLayout.SequentialGroup vSeqGroup = layout1.createSequentialGroup().addComponent(panela).addComponent(panelb).addComponent(panelc);
        layout1.setVerticalGroup(vSeqGroup);
       
        panelin.setLayout(layout1);

        ImageIcon m3 =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/pay.png"));
        m3.setImage(m3.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panel3 = new JPanel(null);
        panel3.setBounds(38,387,460,90);
        panel3.setBackground(Color.white);
        panel3.setBorder(new RoundBorder(Color.gray));
        String mo3="$30";
        JLabel label31 = new JLabel(mo3);
        label31.setForeground(Color.red);
        label31.setBounds(278,30,75,25);
        label31.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel3.add(label31);
        String co3="Total";
        JLabel label32 = new JLabel(co3);
        label32.setBounds(158,30,62,21);
        label32.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel3.add(label32);
        JLabel label33 = new JLabel(m3);
        label33.setBounds(20,18,50,50);
        panel3.add(label33);
        panel.add(panel3);
    }
}
