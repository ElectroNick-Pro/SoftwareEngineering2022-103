package MainApp.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.UserModel.*;
import MainApp.pages.Exception.UnboundPageException;
import java.nio.file.Path;

import MainApp.pages.components.*;
import MainApp.pages.control.FlightInfo;

public class ChooseFood extends JFrame{
    private static final int DEFAULT_WIDTH = 965;
    private static final int DEFAULT_HEIGHT = 550; 
    private Path path = Path.of("Retrieve/Flight Information/Choose Seat/Choose Food");
    private JPanel contentPane;
    private int getNum = 0;
    private originFood[] foodPane = null;
    private JPanel[] foodJPanels = null;
    private JLabel ok = new JLabel(new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/success1.png")));
    Object[] haveFood = null;
    int size = 0;
    int remainder= 0;
    JPanel foodInner = new JPanel();
    
    public ChooseFood(){

        GlobalData.data.put("okLabel",ok);

        Pages.bindPage(this.path, this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);

        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        add(top);
        top.setVisible(true);

        JLabel title = new JLabel("Choose Food");
        title.setFont(new Font("Microsoft YaHei UI",Font.BOLD,35));
        title.setBounds(45,75,250,49);
        add(title);

        JLabel smallTitle = new JLabel("You can choose a type of food you perfer:"); 
        smallTitle.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
        smallTitle.setBounds(45,100,350,70);
        add(smallTitle);

        JPanel food = new JPanel();
        food.setLayout(null);
        food.setBackground(Color.white);

        FlightInfo flightinfo = (FlightInfo)GlobalData.data.get("flight");
        int Id = flightinfo.flight.id;
        
        try {
            haveFood = Food.queryByProperty(Food.class, "Flight_id", Id).filter((x)->{
                return x.type.getValue().equals("Origin");
            }).toArray(); 
            getNum = haveFood.length;
            size = 0;
            remainder = getNum%4;
            if(remainder == 0){
                size = getNum/4;
            }else{
                size = getNum/4+1;
            }
            foodJPanels = new JPanel[size*4];
            foodPane = new originFood[size*4];
            for(int i = 0; i < getNum; i++){
                var contain = (Food)haveFood[i];
                String name = (String)contain.name.getValue();
                String image = (String)contain.image.getValue();
                String price =String.valueOf((double)contain.price.getValue());
                foodPane[i] = new originFood();
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

        food.setPreferredSize(new Dimension(20, 150*size));
        foodInner.setLayout(new GridLayout(size,4));
        for(int i = 0 ; i < foodJPanels.length;i++){
            foodInner.add(foodJPanels[i]);
        }
        foodInner.setBounds(20,0,820,150*size);
        food.add(foodInner);
        
        JScrollPane info = new JScrollPane(food);
        info.setBackground(Color.white);
        info.setBounds(40,170,870,300);
        info.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
        add(info);

        JButton Back = new JButton("back");
        Back.setBackground(new Color(191, 191, 191));
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        Back.setBounds(25, 480, 75, 30);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Back) {
                    try {
                        Pages.goBack();
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        add(Back);
        JButton Next = new JButton("next");
        Next.setBackground(new Color(0, 131, 255));
        Next.setForeground(Color.WHITE);
        Next.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        Next.setBorder(new RoundBorder(new Color(30, 144, 255)));
        Next.setBounds(860, 480, 75, 30);
        Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Next) {
                    Food foodChoice = null;
                    try {
                        for(int i = 0; i < getNum;i++){
                            if(foodPane[i].getSelected()){
                                foodChoice = (Food)haveFood[i];
                            }
                        }
                        if(foodChoice == null){
                            JOptionPane.showMessageDialog(null, "Please choose a type of food you perfer.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        GlobalData.data.put("food_choice",foodChoice);
                        // System.out.println(foodChoice.name.getValue());
                        new ExtraFoodFrm();
                        Pages.displayPage(path.resolve(Path.of("Extra Food")));
                    } 
                    catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        add(Next);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    GlobalData.init(args);
                    Models.init();
					ChooseFood frame = new ChooseFood();
					frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
    }
}
