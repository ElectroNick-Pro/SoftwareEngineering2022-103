package MainApp.pages;

import javax.swing.*;

import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.*;
import MainApp.pages.components.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.*;
import MainApp.pages.Exception.UnboundPageException;
import java.nio.file.Path;
import MainApp.pages.control.FlightInfo;
import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.App;
import javax.swing.GroupLayout.Alignment;

public class ExtraFoodFrm extends JFrame{
    private JPanel contentPane;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    GlobalData.init(args);
                    Models.init();
					ExtraFoodFrm frame = new ExtraFoodFrm();
					frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
    }
    private static final int DEFAULT_WIDTH = 965;
    private static final int DEFAULT_HEIGHT = 550; 
    private Path path = Path.of("Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food");
    private int getNum = 0;
    private foodPanel[] foodPane = null;
    private JPanel[] foodJPanels = null;
    public ExtraFoodFrm(){
        Pages.bindPage(this.path, this);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);

        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        add(top);
        top.setVisible(true);

        JLabel title = new JLabel("Extra Food");
        title.setFont(new Font("Microsoft YaHei UI",Font.BOLD,35));
        title.setBounds(45,85,200,49);
        add(title);

        JLabel smallTitle = new JLabel("You can choose some extra food:"); 
        smallTitle.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
        smallTitle.setBounds(45,118,250,70);
        add(smallTitle);
 
        FlightInfo flightinfo = (FlightInfo)GlobalData.data.get("flight");
        int Id = flightinfo.flight.id;
        JPanel food = new JPanel();
        // food.setPreferredSize(new Dimension(800, 480));
        food.setLayout(null);
        food.setBackground(Color.white);
        Object[] _haveFood = null;
        JPanel foodInner = new JPanel();
        int size = 0;
        int remainder= 0;
        try {
            _haveFood = Food.queryByProperty(Food.class, "Flight_id", Id).filter((x)->{
                return x.type.getValue().equals("Extra");
            }).toArray(); //get all extra food on the plane
            getNum = _haveFood.length;
            remainder = getNum%4;
            if(remainder == 0){
                size = getNum/4;
            }else{
                size = getNum/4+1;
            }
            foodPane = new foodPanel[size*4];
            foodJPanels = new JPanel[size*4];
            System.out.println(getNum);
            for(int i = 0; i < getNum; i++){
                var contain = (Food)_haveFood[i];
                String name = (String)contain.name.getValue();
                String image = (String)contain.image.getValue();
                String price =String.valueOf((double)contain.price.getValue());
                System.out.println(name+" " +image+" "+price);
                foodPane[i] = new foodPanel();
                foodJPanels[i] = foodPane[i].createPanel(image, name, price);
            }
            for(int i = getNum;i < size*4;i++){
                foodJPanels[i] = new JPanel();
                foodJPanels[i].setSize(200,150);
                foodJPanels[i].setBackground(Color.white);
            }
        } catch (FieldNotFoundException e1) {
            e1.printStackTrace();
        };
        var haveFood = _haveFood;
        // get the size parallel
        food.setPreferredSize(new Dimension(20, 150*size));
        foodInner.setLayout(new GridLayout(size,4));
        // foodInner.setSize(new Dimension(20, 150*size));

        for(int i = 0 ; i < foodJPanels.length;i++){
            foodInner.add(foodJPanels[i]);
        }
        foodInner.setBounds(20,0,820,150*size);
        food.add(foodInner);
        
        JScrollPane info = new JScrollPane(food);
        info.setBackground(Color.white);
        info.setBounds(40,180,870,300);
        info.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
        add(info);

        JButton next = new JButton();
        next.setBackground(new Color(30, 144, 255));
        next.setText("Next");
        next.setForeground(Color.white);
        next.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        next.setBorder(new RoundBorder(new Color(30, 144, 255)));
        next.setBounds(830,480,75,30);
        add(next);

        JButton back = new JButton();
        back.setBackground(Color.gray);
        back.setText("Back");
        back.setForeground(Color.white);
        back.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        back.setBorder(new RoundBorder(Color.gray));
        back.setBounds(25,480,75,30);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == back) {
                    try {
                        Pages.goBack();
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        add(back);

        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                var tuples = new HashMap<Integer, FoodPurchase>();
                for(int i = 0; i < getNum;i++){
                    var info = new FoodPurchase();
                    if(foodPane[i].getValue() != 0){
                        info.food.setValue(((Food)haveFood[i]).id);
                        info.count.setValue(foodPane[i].getValue());
                        tuples.put((Integer)info.food.getValue(), info);
                    }
                    
                }
                // GlobalData.data.put("foodInfo",info); //这个我没拿到数据，所以改成了下面的
                if(GlobalData.data.containsKey("foodInfo")) {
                    ((HashMap<Integer, FoodPurchase>)GlobalData.data.get("foodInfo")).putAll(tuples);;
                } else {
                    GlobalData.data.put("foodInfo", tuples);
                }
                try{
                    new confirmPay();
                    Pages.displayPage(path.resolve(Path.of("Confirm and Pay")));
                }
                catch (UnboundPageException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    
}