package MainApp.pages;

import javax.swing.*;

import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.UserModel.*;
import MainApp.pages.components.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.control.FlightInfo;
import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.App;

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
    public ExtraFoodFrm(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);

        JLabel title = new JLabel("Extra Food");
        title.setFont(new Font("Microsoft YaHei UI",Font.BOLD,35));
        title.setBounds(45,85,190,49);
        add(title);

        JLabel smallTitle = new JLabel("You can choose some extra food:"); 
        smallTitle.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
        smallTitle.setBounds(45,118,247,70);
        add(smallTitle);
 

        int getNum = 0;
        // FlightInfo flightinfo = (FlightInfo)GlobalData.data.get("flight");
        // int Id = flightinfo.flight.id;
        JPanel food = new JPanel();
        food.setPreferredSize(new Dimension(800, 480));
        food.setBackground(Color.white);
        foodPanel[] foodPane = null;
        foodPane = new foodPanel[getNum];
        JPanel[] foodJPanels = null;
        foodJPanels = new JPanel[getNum];
        try {
            var haveFood = Food.queryByProperty(Food.class, "Flight_id", 1).filter((x)->{
                return x.type.getValue() == "Extra";
            }).toArray(); //get all extra food on the plane
            getNum = haveFood.length;
            for(int i = 0; i < getNum; i++){
                var contain = (Food)haveFood[i];
                String name = (String)contain.name.getValue();
                String image = (String)contain.image.getValue();
                String price = (String)contain.price.getValue();
                foodPane[i] = new foodPanel();
                foodJPanels[i] = foodPane[i].createPanel(image, name, price);
            }
        } catch (FieldNotFoundException e1) {
            e1.printStackTrace();
        };

        GroupLayout layout1 = new GroupLayout(food);
        GroupLayout.SequentialGroup[] hSeqGP = null;
        // get the size parallel
        int size = 0;
        int remainder = getNum%4;
        if(remainder == 0){
            size = getNum/4;
        }else{
            size = getNum/4+1;
        }
        hSeqGP =new GroupLayout.SequentialGroup[size];
        //add components
        for(int i = 0 ; i < size;i++){
            if(i == size-1&&remainder != 0){
                hSeqGP[i] = layout1.createSequentialGroup();
                hSeqGP[i].addGap(20);
                for(int j = 0; j < remainder;j++){
                    hSeqGP[i].addComponent(foodJPanels[i*4+j]);
                }
            }
            else{
                hSeqGP[i] = layout1.createSequentialGroup();
                hSeqGP[i].addGap(20);
                for(int j = 0; j < 4;j++){
                    hSeqGP[i].addComponent(foodJPanels[i*4+j]);
                }
            }
        }
        GroupLayout.ParallelGroup hparallelGroupInfo = layout1.createParallelGroup();
        for(int i = 0; i < size;i++){
            hparallelGroupInfo.addGroup(hSeqGP[i]);
        }
        layout1.setHorizontalGroup(hparallelGroupInfo);
        //horizental
        GroupLayout.SequentialGroup[] vSeqGP = null;
        vSeqGP = new GroupLayout.SequentialGroup[4];
        for(int i = 0; i < 4;i++){
            if(i < remainder){
                vSeqGP[i] = layout1.createSequentialGroup();
                for(int j = 0; j < size + 1; j++)
                vSeqGP[i].addComponent(foodJPanels[j*4+i]);
            }else{
                for(int j = 0; j < size;j++){
                    vSeqGP[i].addComponent(foodJPanels[j*4+i]);
                }
            }
        }
        GroupLayout.ParallelGroup vparallelGP = layout1.createParallelGroup();
        vparallelGP.addGroup(vSeqGP[0]);
        vparallelGP.addGroup(vSeqGP[1]);
        vparallelGP.addGroup(vSeqGP[2]);
        vparallelGP.addGroup(vSeqGP[3]);
        layout1.setVerticalGroup(vparallelGP);
        food.setLayout(layout1);
        
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
        add(back);

        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int NUM = 13;
                Food[] foodMenu = null;
                foodMenu = new Food[NUM];
                foodMenu[0] = new Food();
                // foodMenu[0] = coffeePanel.getValue();

            }
        });
    }
    
}
