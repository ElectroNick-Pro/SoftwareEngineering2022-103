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
import javax.swing.plaf.ColorUIResource;

import MainApp.GlobalData;
import MainApp.models.Model.UserModel.Food;
import MainApp.models.Model.UserModel.FoodPurchase;
import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;
public class foodchoice extends JFrame {
    private String type;
    public foodchoice(String btnType,Food foodPackage, FoodPurchase[] extra_food){
        super();
        type = btnType;
        JFrame foodChoice = new JFrame();

        /***
         * title
         */
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

        JPanel food = new JPanel();
        food.setBackground(Color.white);
        JScrollPane foodPane = new JScrollPane(food);
        foodPane.setBackground(Color.white);
        foodPane.setBounds(26,75,466,303);
        foodPane.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
        add(foodPane);

        int foodLength = extra_food.length + 1;
        JLabel foodShow = choiceLabel("food", "MainApp/pages/image/background.png", (String)foodPackage.name.getValue(), (Double)foodPackage.price.getValue(), 1);
        panel.add(foodShow);



        foodChoice.add(panel);
        foodChoice.setVisible(true);
        // for(int i = 0; i < foodLength; i ++){
            
        // }

        // JPanel panelin = new JPanel(null);
        // panelin.setBackground(Color.white);
        // //panelin.setBounds(42,75,458,303);
        // JScrollPane food = new JScrollPane(panelin);
        // food.setBounds(26,75,466,303);
        // food.setBackground(Color.white);
        // food.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
        
        // add(food);
        // 列表框
        // jList = new JList(city);
        // jList.setVisibleRowCount(3);
        // // 窗口滚动
        // jScrollPane = new JScrollPane(jList);
        // this.setLayout(new GridLayout(2, 1));
        // jPanel.add(jLabel);
        // jPanel.add(jComboBox);
        
        // ImageIcon ma =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seafood.png"));
        // ma.setImage(ma.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        // JPanel panela = new JPanel(null);
        // panela.setBounds(15,14,430,85);
        // panela.setBackground(Color.white);
        // panela.setBorder(new RoundBorder(Color.gray));
        // String moa="$10";
        // JLabel labela1 = new JLabel(moa);
        // labela1.setForeground(Color.red);
        // labela1.setBounds(277,30,75,25);
        // labela1.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panela.add(labela1);
        // String coa="Beefsteak";
        // JLabel labela2 = new JLabel(coa);
        // labela2.setBounds(122,30,123,21);
        // labela2.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panela.add(labela2);
        // String an = "1";
        // JLabel labelan = new JLabel(an);
        // labelan.setForeground(new Color(0,131,255));
        // labelan.setBounds(356,30,123,24);
        // labelan.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panela.add(labelan);
        // JLabel labela3 = new JLabel(ma);
        // labela3.setBounds(20,18,50,50);
        // panela.add(labela3);
        // panelin.add(panela);


        // ImageIcon mb =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seafood.png"));
        // mb.setImage(mb.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        // JPanel panelb = new JPanel(null);
        // panelb.setSize(430,85);
        // panelb.setBackground(Color.white);
        // panelb.setBorder(new RoundBorder(Color.gray));
        // String mob="$2";
        // JLabel labelb1 = new JLabel(mob);
        // labelb1.setForeground(Color.red);
        // labelb1.setBounds(277,30,75,25);
        // labelb1.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panelb.add(labelb1);
        // String cob="Coffee";
        // JLabel labelb2 = new JLabel(cob);
        // labelb2.setBounds(122,30,123,21);
        // labelb2.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panelb.add(labelb2);
        // String bn = "1";
        // JLabel labelbn = new JLabel(bn);
        // labelbn.setBounds(356,30,123,24);
        // labelbn.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // labelbn.setForeground(new Color(0,131,255));
        // panelb.add(labelbn);
        // JLabel labelb3 = new JLabel(mb);
        // labelb3.setBounds(20,18,50,50);
        // panelb.add(labelb3);
        // panelin.add(panelb);

        // ImageIcon mc =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seafood.png"));
        // mc.setImage(mc.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        // JPanel panelc = new JPanel(null);
        // panelc.setSize(430,85);
        // panelc.setBackground(Color.white);
        // panelc.setBorder(new RoundBorder(Color.gray));
        // String moc="$5";
        // JLabel labelc1 = new JLabel(moc);
        // labelc1.setForeground(Color.red);
        // labelc1.setBounds(277,30,75,25);
        // labelc1.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panelc.add(labelc1);
        // String coc="RiceBall";
        // JLabel labelc2 = new JLabel(coc);
        // labelc2.setBounds(122,30,123,21);
        // labelc2.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panelc.add(labelc2);
        // String cn = "2";
        // JLabel labelcn = new JLabel(cn);
        // labelcn.setBounds(356,30,123,24);
        // labelcn.setForeground(new Color(0,131,255));
        // labelcn.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panelc.add(labelcn);
        // JLabel labelc3 = new JLabel(mc);
        // labelc3.setBounds(20,18,50,50);
        // panelc.add(labelc3);
        // panelin.add(panelc);
        // GroupLayout layout1 = new GroupLayout(panelin);
        // GroupLayout.ParallelGroup hparallelGroup = layout1.createParallelGroup().addComponent(panela).addComponent(panelb).addComponent(panelc);
        // layout1.setHorizontalGroup(hparallelGroup);
        // GroupLayout.SequentialGroup vSeqGroup = layout1.createSequentialGroup().addComponent(panela).addComponent(panelb).addComponent(panelc);
        // layout1.setVerticalGroup(vSeqGroup);
       
        // panelin.setLayout(layout1);

        // ImageIcon m3 =new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/pay.png"));
        // m3.setImage(m3.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        // JPanel panel3 = new JPanel(null);
        // panel3.setBounds(38,387,460,90);
        // panel3.setBackground(Color.white);
        // panel3.setBorder(new RoundBorder(Color.gray));
        // String mo3="$30";
        // JLabel label31 = new JLabel(mo3);
        // label31.setForeground(Color.red);
        // label31.setBounds(278,30,75,25);
        // label31.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panel3.add(label31);
        // String co3="Total";
        // JLabel label32 = new JLabel(co3);
        // label32.setBounds(158,30,62,21);
        // label32.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        // panel3.add(label32);
        // JLabel label33 = new JLabel(m3);
        // label33.setBounds(20,18,50,50);
        // panel3.add(label33);
        // panel.add(panel3);
    }
    public JLabel choiceLabel(String type, String imagePath, String foodName, Double cost, int number){
        JLabel l = new JLabel();
        l.setBounds(16,14,431,85);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        icon.setImage(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        JLabel image = new JLabel(icon);
        image.setBounds(15, 12, 60, 60);

        //86,33,193,21
        JLabel name = new JLabel(foodName, JLabel.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 25));
        name.setBounds(86,33,193,21);

        //312,30
        JLabel money = new JLabel("$"+cost, JLabel.CENTER);
        money.setFont(new Font("Arial", Font.BOLD, 25));
        money.setForeground(new ColorUIResource(Color.red));
        money.setBounds(279,30,75,25);

        JLabel count = new JLabel("×"+number, JLabel.CENTER);
        count.setFont(new Font("Arial", Font.BOLD, 25));
        count.setForeground(new ColorUIResource(0,131,255));
        count.setBounds(356,30,75,25);

        l.add(image);
        l.add(name);
        l.add(money);
        l.add(count);
        return l;
    }
}
