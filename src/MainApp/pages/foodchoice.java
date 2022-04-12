package MainApp.pages;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
import MainApp.models.Models;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.Food;
import MainApp.models.Model.UserModel.FoodPurchase;
import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;

public class foodchoice extends JFrame {
    public static void main(String[] args) {
        GlobalData.init(args);
        Models.init();
        var frame = new foodchoice();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public foodchoice() {
        super();
        type = btnType;
        JFrame foodChoice = new JFrame();

        /***
         * title
         */
        JPanel panel;
        panel = new JPanel(null);
        panel.setLayout(null);
        setContentPane(panel);
        
        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        JLabel label = new JLabel("Details of the food choice");
        label.setBounds(44, 18, 341, 42);
        label.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
        panel.add(label);

        JPanel panelin = new JPanel(null);
        panelin.setBackground(Color.white);
        // TODO - resolve the MAX_VALUE
        panelin.setBounds(42, 75, 458, Integer.MAX_VALUE);
        JScrollPane food = new JScrollPane(panelin);
        panelin.setBorder(BorderFactory.createCompoundBorder(panelin.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        food.setBounds(34, 75, 500, 303);
        food.setBackground(Color.white);
        food.getVerticalScrollBar().setUI(new DemoScrollBarUI());

        add(food);

        var layout = new GridLayout(0,1);
        layout.setVgap(20);
        panelin.setLayout(layout);
        var foodPanels = new ArrayList<FoodBlockPanel>();

        try {
            var foodPurchases = FoodPurchase.queryByProperty(FoodPurchase.class, "ticket", 1).toArray();
            for(var _fp: foodPurchases) {
                var fp = (FoodPurchase)_fp;
                var fpanel = new FoodBlockPanel(fp);
                foodPanels.add(fpanel);
                panelin.add(fpanel);
            }
        } catch (FieldNotFoundException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
        
        ImageIcon m3 = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/pay.png"));
        m3.setImage(m3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));// 这里设置图片大小，目前是20*20
        JPanel panel3 = new JPanel(null);
        panel3.setBounds(38, 387, 460, 90);
        panel3.setBackground(Color.white);
        panel3.setBorder(new RoundBorder(Color.gray));
        String mo3 = "$30";
        JLabel label31 = new JLabel(mo3);
        label31.setForeground(Color.red);
        label31.setBounds(278, 30, 75, 25);
        label31.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
        panel3.add(label31);
        String co3 = "Total";
        JLabel label32 = new JLabel(co3);
        label32.setBounds(158, 30, 62, 21);
        label32.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
        panel3.add(label32);
        JLabel label33 = new JLabel(m3);
        label33.setBounds(20, 18, 50, 50);
        panel3.add(label33);
        panel.add(panel3);
    }
}

class FoodBlockPanel extends JPanel {
    private FoodPurchase foodPurchase;
    private Food food;
    public FoodBlockPanel(FoodPurchase fp) throws ObjectNotFoundException {
        super();
        
        // Get data
        foodPurchase = fp;
        food = (Food)foodPurchase.food.getReferred();

        // Set layout
        ImageIcon ma = new ImageIcon(ClassLoader.getSystemResource((String)food.image.getValue()));
        ma.setImage(ma.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));// 这里设置图片大小，目前是20*20
        JPanel panela = this;
        panela.setPreferredSize(new Dimension(430, 85));
        panela.setBackground(Color.white);
        panela.setBorder(new RoundBorder(Color.gray));
        String moa = ((Double)food.price.getValue()).toString();
        JLabel labela1 = new JLabel(moa);
        labela1.setForeground(Color.red);
        labela1.setBounds(277, 30, 75, 25);
        labela1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
        panela.add(labela1);
        String coa = (String)food.name.getValue();
        JLabel labela2 = new JLabel(coa);
        labela2.setBounds(122, 30, 123, 21);
        labela2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
        panela.add(labela2);
        String an = ((Integer)foodPurchase.count.getValue()).toString();
        JLabel labelan = new JLabel(an);
        labelan.setForeground(new Color(0, 131, 255));
        labelan.setBounds(356, 30, 123, 24);
        labelan.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
        panela.add(labelan);
        JLabel labela3 = new JLabel(ma);
        labela3.setBounds(20, 18, 50, 50);
        panela.add(labela3);
    }
}