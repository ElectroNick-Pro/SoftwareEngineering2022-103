package MainApp.pages;

import javax.swing.*;

import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.*;
import MainApp.pages.components.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.*;
import MainApp.pages.Exception.UnboundPageException;
import java.nio.file.Path;

public class ExtraFoodFrm extends JFrame{
    private JPanel contentPane;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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

        JPanel food = new JPanel();
        food.setPreferredSize(new Dimension(800, 480));
        food.setBackground(Color.white);
        foodPanel coffeePanel = new foodPanel();
        JPanel coffee =coffeePanel.createPanel("MainApp/pages/image/coffee1.png","Coffee","$2");
        foodPanel colaPanel = new foodPanel();
        JPanel cola = colaPanel.createPanel("MainApp/pages/image/cola2.png","Cola","$3");
        foodPanel beerPanel = new foodPanel();
        JPanel beer = beerPanel.createPanel("MainApp/pages/image/beer3.png","Beer","$2");
        foodPanel juicePanel = new foodPanel();
        JPanel juice = juicePanel.createPanel("MainApp/pages/image/juice4.png","Juice","$2");
        foodPanel waterMelonPanel = new foodPanel();
        JPanel watermelon = waterMelonPanel.createPanel("MainApp/pages/image/WM5.png","watermelon","$2");
        foodPanel applePanel = new foodPanel();
        JPanel apple = applePanel.createPanel("MainApp/pages/image/apple6.png","Apple","$2");
        foodPanel hotdogPanel = new foodPanel();
        JPanel hotdog = hotdogPanel.createPanel("MainApp/pages/image/hotdog7.png","Hotdog","$2");
        foodPanel friesPanel = new foodPanel();
        JPanel fries = friesPanel.createPanel("MainApp/pages/image/French fries8.png","French fries","$2");
        foodPanel doughnutPanel = new foodPanel();
        JPanel doughnut = doughnutPanel.createPanel("MainApp/pages/image/doughnut1.png","Pudding","$2");
        foodPanel breadPanel = new foodPanel();
        JPanel bread = breadPanel.createPanel("MainApp/pages/image/bread2.png","Bread","$2");
        foodPanel chocolatePanel = new foodPanel();
        JPanel chocolate = chocolatePanel.createPanel("MainApp/pages/image/chocolate3.png","Chocolates","$2");
        foodPanel biscuitPanel = new foodPanel();
        JPanel biscuit =biscuitPanel.createPanel("MainApp/pages/image/biscuit4.png","Biscuit","$2");
        
        GroupLayout layout1 = new GroupLayout(food);
        GroupLayout.SequentialGroup hSeqGpInfo1 = layout1.createSequentialGroup();
        hSeqGpInfo1.addGap(20);
        hSeqGpInfo1.addComponent(coffee);
        hSeqGpInfo1.addComponent(cola);
        hSeqGpInfo1.addComponent(beer);
        hSeqGpInfo1.addComponent(juice);
        GroupLayout.SequentialGroup hSeqGpInfo2 = layout1.createSequentialGroup();
        hSeqGpInfo2.addGap(20);
        hSeqGpInfo2.addComponent(watermelon);
        hSeqGpInfo2.addComponent(apple);
        hSeqGpInfo2.addComponent(hotdog);
        hSeqGpInfo2.addComponent(fries);
        GroupLayout.SequentialGroup hSeqGpInfo3 = layout1.createSequentialGroup();
        hSeqGpInfo3.addGap(20);
        hSeqGpInfo3.addComponent(doughnut);
        hSeqGpInfo3.addComponent(bread);
        hSeqGpInfo3.addComponent(chocolate);
        hSeqGpInfo3.addComponent(biscuit);
        GroupLayout.ParallelGroup hparallelGroupInfo = layout1.createParallelGroup();
        hparallelGroupInfo.addGroup(hSeqGpInfo1);
        hparallelGroupInfo.addGroup(hSeqGpInfo2);
        hparallelGroupInfo.addGroup(hSeqGpInfo3);
        layout1.setHorizontalGroup(hparallelGroupInfo);

        GroupLayout.SequentialGroup vSeqGP1 = layout1.createSequentialGroup();
        vSeqGP1.addComponent(coffee);
        vSeqGP1.addGap(20);
        vSeqGP1.addComponent(watermelon);
        vSeqGP1.addGap(20);
        vSeqGP1.addComponent(doughnut);
        GroupLayout.SequentialGroup vSeqGP2 = layout1.createSequentialGroup();
        vSeqGP2.addComponent(cola);
        vSeqGP2.addComponent(apple);
        vSeqGP2.addComponent(bread);
        GroupLayout.SequentialGroup vSeqGP3 = layout1.createSequentialGroup();
        vSeqGP3.addComponent(beer);
        vSeqGP3.addComponent(hotdog);
        vSeqGP3.addComponent(chocolate);
        GroupLayout.SequentialGroup vSeqGP4 = layout1.createSequentialGroup();
        vSeqGP4.addComponent(juice);
        vSeqGP4.addComponent(fries);
        vSeqGP4.addComponent(biscuit);
        GroupLayout.ParallelGroup vparallelGP = layout1.createParallelGroup();
        vparallelGP.addGroup(vSeqGP1);
        vparallelGP.addGroup(vSeqGP2);
        vparallelGP.addGroup(vSeqGP3);
        vparallelGP.addGroup(vSeqGP4);
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
