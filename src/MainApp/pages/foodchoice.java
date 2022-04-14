package MainApp.pages;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.models.Model.Exception.*;
import MainApp.models.Model.UserModel.*;
import MainApp.pages.components.*;
import MainApp.pages.control.FlightInfo;

public class foodchoice extends JFrame {
    public Food foodPackage = (Food) GlobalData.data.get("food_choice");
    // private Map<Integer, FoodPurchase> extraFoodMap;
    FoodPurchase[] extra_food = new FoodPurchase[20];
    double[] extra_food_price = new double[20];
    Double basicFoodPrice = (Double) foodPackage.price.getValue();
    Double extraFoodPrice = 0.0;

    
    public static void main(String[] args) {
        GlobalData.init(args);
        Models.init();
        var frame = new foodchoice();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
    }

    @SuppressWarnings("unchecked")
    public foodchoice() {
        super();
        var foodChoice = this;
        foodChoice.getContentPane().setBackground(Color.WHITE);
        foodChoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        foodChoice.setSize(530,540);

        var flightInfo = (FlightInfo) GlobalData.data.get("flight");
        var ticket = flightInfo.ticket;
        var extraFoodMap = (HashMap<Integer, FoodPurchase>)GlobalData.data.get("foodInfo");
        int i = 0;
        for(var entry: extraFoodMap.entrySet()){
            var tuple = entry.getValue();
            var foodId = tuple.food.getValue();
            var count = tuple.count.getValue();
            if(foodId != null){
                extra_food[i] = new FoodPurchase();
                extra_food[i].food.setValue(foodId);
                extra_food[i].ticket.setValue(ticket.id);
                extra_food[i].count.setValue(count);
                try {
                    var food = (Food)Food.getById(Food.class, (Integer)foodId);
                    extra_food_price[i] = (Double)food.price.getValue();
                    extraFoodPrice = extraFoodPrice + extra_food_price[i] * (Integer)count;
                } catch (ObjectNotFoundException e1) {
                    e1.printStackTrace();
                }
                i++;
            }
        }
        
        foodPackage.save();
        double food_price = basicFoodPrice + extraFoodPrice;

        /***
         * title
         */
        JPanel panel;
        panel = new JPanel(null);
        panel.setLayout(null);
        setContentPane(panel);
        panel.setBackground(Color.WHITE);
        this.setContentPane(panel);
        JLabel label = new JLabel("Details of extra food choice");
        label.setBounds(26, 25, 360, 42);
        label.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        panel.add(label);

        JPanel panelin = new JPanel(null);
        panelin.setBackground(Color.white);
        JScrollPane food = new JScrollPane(panelin);
        panelin.setBorder(BorderFactory.createCompoundBorder(panelin.getBorder(), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        food.setBounds(26, 75, 465, 303);
        food.setBackground(Color.white);
        food.getVerticalScrollBar().setUI(new DemoScrollBarUI());

        add(food);

        var layout = new GridLayout(0,1);
        layout.setVgap(20);
        panelin.setLayout(layout);
        var foodPanels = new ArrayList<FoodBlockPanel>();
        panelin.setBounds(26, 75, 465, Integer.MAX_VALUE);

        try {
            for(int j = 0; j < extra_food.length; j ++){
                if(extra_food[j] != null){
                    var fp = (FoodPurchase)extra_food[j];
                    var fpanel = new FoodBlockPanel(fp);      
                    foodPanels.add(fpanel);
                    panelin.add(fpanel);
                }
            }
            panelin.add(new FoodBlockPanel());
            panelin.add(new FoodBlockPanel());
            panelin.add(new FoodBlockPanel());
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        ImageIcon m3 = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/pay.png"));
        m3.setImage(m3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));// 这里设置图片大小，目前是20*20
        JPanel panel3 = new JPanel(null);
        panel3.setBounds(26, 387, 467, 85);
        panel3.setBackground(Color.white);
        panel3.setBorder(new RoundBorder(Color.gray));
        String mo3 = "$"+food_price;
        JLabel label31 = new JLabel(mo3, JLabel.CENTER);
        label31.setForeground(Color.red);
        label31.setBounds(365, 30, 96, 25);
        label31.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        panel3.add(label31);
        String co3 = "Total of Extra Food";
        JLabel label32 = new JLabel(co3, JLabel.CENTER);
        label32.setBounds(82, 25, 276, 32);
        label32.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
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
    public FoodBlockPanel() {
        this.setPreferredSize(new Dimension(431, 85));
        this.setLayout(null);
        this.setOpaque(false);
    }
    public FoodBlockPanel(FoodPurchase fp) throws ObjectNotFoundException {
        super();
        
        // Get data
        foodPurchase = fp;
        food = (Food)foodPurchase.food.getReferred();

        // Set layout
        JPanel panela = this;
        panela.setPreferredSize(new Dimension(431, 85));
        panela.setLayout(null);
        panela.setBackground(Color.white);
        panela.setBorder(new RoundBorder(Color.gray));

        ImageIcon ma = new ImageIcon(ClassLoader.getSystemResource((String)food.image.getValue()));
        ma.setImage(ma.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));// 这里设置图片大小，目前是20*20
        JLabel labela3 = new JLabel(ma);

        String moa = ((Double)food.price.getValue()).toString();
        JLabel labela1 = new JLabel("$"+moa, JLabel.CENTER);
        labela1.setForeground(Color.red);
        labela1.setBounds(279, 30, 75, 25);
        labela1.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        
        String coa = (String)food.name.getValue();
        JLabel labela2 = new JLabel(coa, JLabel.CENTER);
        labela2.setBounds(85, 25, 193, 32);
        labela2.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        
        String an = ((Integer)foodPurchase.count.getValue()).toString();
        JLabel labelan = new JLabel("× "+an);
        labelan.setForeground(new Color(0, 131, 255));
        labelan.setBounds(356, 30, 75, 25);
        labelan.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        
        labela3.setBounds(15, 12, 60, 60);

        panela.add(labela3);
        panela.add(labela2);
        panela.add(labela1);
        panela.add(labelan);
    }
}