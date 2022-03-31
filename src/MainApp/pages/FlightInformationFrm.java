package MainApp.pages;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.AttributeSet.ColorAttribute;

import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.components.BreadCrumbPanel;
import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;

import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import javax.swing.JLayeredPane;


import java.awt.*;

class MyPanel extends JPanel {
    public Image image;
    public MyPanel(Image image) {
        super();
        setBackground(Color.WHITE);
        this.image = image;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class FlightInformationFrm extends JFrame
{
    private Path path = Path.of("page1/page2");
    private JPanel contentPane;
    JLayeredPane pane = new JLayeredPane();
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightInformationFrm frame = new FlightInformationFrm();
					frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
    }
    private static final int DEFAULT_WIDTH = 960;
    private static final int DEFAULT_HEIGHT = 540; 
    private static final int INFO_WIDTH = 420;
    private static final int INFO_HEIGHT = 250;
    private static final int NUM = 5;
    public FlightInformationFrm(){
        Pages.bindPage(this.path, this);

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        pane = new JLayeredPane();

        var bread = new BreadCrumbPanel(this.path);
        bread.setBounds(0, 0, 300, 50);
        this.add(bread);

        JLabel label = new JLabel("Flight Information");
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
        label.setBounds(45,85,323,49);
        add(label);

        JLabel smallLabel = new JLabel("Please choose your flight:                         ");
        smallLabel.setFont(new Font("宋体", Font.BOLD, 15));
        smallLabel.setBounds(47,117,509,70);
        add(smallLabel);

        JPanel flightCheck = createFlight();
        flightCheck.setBorder(new RoundBorder(Color.GRAY)); 

        ImageIcon image = new ImageIcon("src/MainApp/pages/image/travel.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        // image.setImage(image.getImage().getScaledInstance(960,0,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel picture=new JLabel(image);
        //picture.setBounds(544,34,350,523);
        picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()-35);   //把标签设置为和图片等高等宽
		// contentPane = (JPanel)this.getContentPane(); 	//把我的面板设置为内容面板	
        contentPane.add(picture,JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false);					//把我的面板设置为不可视
		this.getLayeredPane().setLayout(null);		//把分层面板的布局置空
		this.getLayeredPane().add(picture, new Integer(Integer.MIN_VALUE));
        this.getLayeredPane().setBackground(Color.WHITE);

        
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.white);
        JButton[] flightInfo = new JButton[10];
        for(int i=0;i<NUM;i++){
            flightInfo[i]=createButton();  
            flightInfo[i].setBorder(new RoundBorder(Color.GRAY));    
        }
        //grouplayout
        GroupLayout layout1 = new GroupLayout(panelInfo);
        GroupLayout.ParallelGroup hparallelGroupInfo = layout1.createParallelGroup(Alignment.LEADING);
        for(int i = 0; i < NUM;i++){
            hparallelGroupInfo.addComponent(flightInfo[i],GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        }
        GroupLayout.SequentialGroup hSeqGpInfo = layout1.createSequentialGroup();
        hSeqGpInfo.addGap(20);
        hSeqGpInfo.addGroup(hparallelGroupInfo);
        layout1.setHorizontalGroup(hSeqGpInfo);

        GroupLayout.SequentialGroup vSeqGpInfo = layout1.createSequentialGroup();
        for(int i = 0; i <NUM;i++){
            vSeqGpInfo.addGap(11);
            vSeqGpInfo.addComponent(flightInfo[i],GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        }
        layout1.setVerticalGroup(vSeqGpInfo);
        panelInfo.setLayout(layout1);
        JScrollPane info = new JScrollPane(panelInfo);
        info.setBackground(Color.white);
        info.setBounds(35,170,INFO_WIDTH,INFO_HEIGHT);
        info.getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
        add(info);

        ImageIcon questionIcon = new ImageIcon("src/MainApp/pages/image/question.png");
        questionIcon.setImage(questionIcon.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        JButton question = new JButton();
        question.setBackground(Color.WHITE);
        question.setBorder(new RoundBorder(Color.white));
        question.setIcon(questionIcon);
        question.setBounds(880,20,40,40);
        add(question);

        ImageIcon backHome = new ImageIcon("src/MainApp/pages/image/exit.png");
        backHome.setImage(backHome.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        JButton home = new JButton();
        home.setBackground(Color.WHITE);
        home.setBorder(new RoundBorder(Color.white));
        home.setIcon(backHome);
        home.setBounds(40,20,40,40);
        add(home);

        JButton next = new JButton();
        next.setBackground(new Color(30, 144, 255));
        next.setText("Next");
        next.setForeground(Color.white);
        next.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        next.setBorder(new RoundBorder(new Color(30, 144, 255)));
        next.setBounds(830,460,75,30);
        add(next);

        JButton back = new JButton();
        back.setBackground(Color.gray);
        back.setText("Back");
        back.setForeground(Color.white);
        back.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        back.setBorder(new RoundBorder(Color.gray));
        back.setBounds(25,460,75,30);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == back) {
                    try {
                        Pages.displayPage(Path.of("page1"));
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            
        });
        add(back);

        
        for(int i = 0 ; i < NUM;i++){
            int number = i;
            flightInfo[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for(int j = 0; j < NUM;j++){
                        flightInfo[j].setBorder(new RoundBorder(Color.GRAY));
                    }
                    flightInfo[number].setBorder(new RoundBorder(new Color(83,180,248)));
                    smallLabel.setText("Please choose the flight and check the information:");
                    ImageIcon newImage = new ImageIcon("src/MainApp/pages/image/background.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
                    // newImage.setImage(newImage.getImage().getScaledInstance(430,350,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
                    picture.setIcon(newImage);
                    picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()-35);
                    flightCheck.setBounds(500,80,415,355);
                    add(flightCheck);
                }
            });
        }

        

    }
    // private static JPanel createPanel() {
    //     JPanel panel = new JPanel();
    //     panel.setPreferredSize(new Dimension(450, 110));
    //     panel.setBackground(Color.WHITE);
        
    //     return panel;
    // }
    private static JButton createButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(374, 70));
        button.setBackground(Color.WHITE);
        
        ImageIcon image = new ImageIcon("src/MainApp/image/airplane.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel picture=new JLabel(image);

        JLabel takeoff = new JLabel("Beijing");
        takeoff.setFont(new Font("Arial", Font.BOLD, 23));

        JLabel arrive = new JLabel("Shanghai");
        arrive.setFont(new Font("Arial", Font.BOLD, 23));

        JLabel flightNo = new JLabel("KN2316");
        flightNo.setFont(new Font("Arial", Font.ITALIC, 12));

        JLabel date = new JLabel("Mar 20,2022");
        date.setFont(new Font("Arial", Font.ITALIC, 12));

        JLabel where = new JLabel("Air China");
        where.setFont(new Font("Arial", Font.BOLD, 12));

        //

        GroupLayout layout = new GroupLayout(button);
        GroupLayout.SequentialGroup hSeqGp01 = layout.createSequentialGroup();
        hSeqGp01.addGap(15);
        hSeqGp01.addComponent(takeoff);
        hSeqGp01.addGap(60);
        hSeqGp01.addComponent(picture);
        hSeqGp01.addGap(55);
        hSeqGp01.addComponent(arrive);

        GroupLayout.SequentialGroup hSeqGp02 = layout.createSequentialGroup();
        hSeqGp02.addGap(15);
        hSeqGp02.addComponent(where);
        hSeqGp02.addGap(10);
        hSeqGp02.addComponent(flightNo);
        hSeqGp02.addGap(165);
        hSeqGp02.addComponent(date);

        GroupLayout.ParallelGroup hparallelGroup1 = layout.createParallelGroup();
        hparallelGroup1.addGap(50);
        hparallelGroup1.addGroup(hSeqGp01);
        hparallelGroup1.addGap(50);
        hparallelGroup1.addGroup(hSeqGp02);

        layout.setHorizontalGroup(hparallelGroup1);

        GroupLayout.ParallelGroup vparallelGroup1 = layout.createParallelGroup();
        vparallelGroup1.addComponent(where);
        vparallelGroup1.addComponent(flightNo);

        GroupLayout.SequentialGroup vSeqGp01 = layout.createSequentialGroup();
        vSeqGp01.addGap(8);
        vSeqGp01.addGroup(vparallelGroup1);
        vSeqGp01.addGap(10);
        vSeqGp01.addComponent(takeoff);

        GroupLayout.SequentialGroup vSeqGp02 = layout.createSequentialGroup();
        vSeqGp02.addGap(8);
        vSeqGp02.addComponent(date);
        vSeqGp02.addGap(10);
        vSeqGp02.addComponent(arrive);

        GroupLayout.SequentialGroup vSeqGp03 = layout.createSequentialGroup();
        vSeqGp03.addGap(25);
        vSeqGp03.addComponent(picture);

        GroupLayout.ParallelGroup vparallelGroup = layout.createParallelGroup();
        vparallelGroup.addGroup(vSeqGp01);
        vparallelGroup.addGroup(vSeqGp03);
        vparallelGroup.addGroup(vSeqGp02);

        layout.setVerticalGroup(vparallelGroup);

        button.setLayout(layout);
        
        
        return button;
    }
    private static JPanel createFlight() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JLabel book = new JLabel("Booking ID");
        book.setFont(new Font("宋体",Font.ITALIC,15));

        JLabel bookID = new JLabel("13351112345");
        bookID.setFont(new Font("宋体",Font.ITALIC,15));

        JLabel date = new JLabel("Mar 22,2022");
        date.setFont(new Font("宋体",Font.ITALIC,15));

        JLabel where = new JLabel("Air China");
        where.setFont(new Font("宋体",Font.ITALIC,20));

        ImageIcon image = new ImageIcon("src/MainApp/image/airplane.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel picture=new JLabel(image);

        JLabel takeoff = new JLabel("Beijing");
        takeoff.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel arrive = new JLabel("Shanghai");
        arrive.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel flightNo = new JLabel("KN2316");
        flightNo.setFont(new Font("宋体", Font.BOLD, 22));

        JLabel airport1 = new JLabel("Daxinng Airport");
        airport1.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel airport2 = new JLabel("Shuangliu Airport");
        airport2.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel startTime = new JLabel("16:00");
        startTime.setFont(new Font("宋体", Font.BOLD, 20));

        JLabel arriveTime = new JLabel("18:05");
        arriveTime.setFont(new Font("宋体", Font.BOLD, 20));

        JLabel time = new JLabel("2h15min");
        time.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel seat = new JLabel("economy seat");
        seat.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel food =new JLabel("food provided");
        food.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel Terminal = new JLabel("Terminal");
        Terminal.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel TerminalNum = new JLabel("3");
        TerminalNum.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel GateNo = new JLabel("12");
        GateNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel Gate = new JLabel("Gate");
        Gate.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel name = new JLabel("Xiping Yang");
        name.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel ID = new JLabel("130203200109110322");
        ID.setFont(new Font("宋体", Font.BOLD, 15));

        GroupLayout layout = new GroupLayout(panel);

        GroupLayout.SequentialGroup hSeqGp01 = layout.createSequentialGroup();
        hSeqGp01.addGap(20);
        hSeqGp01.addComponent(book);
        hSeqGp01.addGap(15);
        hSeqGp01.addComponent(bookID);
        hSeqGp01.addGap(90);
        hSeqGp01.addComponent(date);

        GroupLayout.SequentialGroup hSeqGp02 = layout.createSequentialGroup();
        hSeqGp02.addGap(20);
        hSeqGp02.addComponent(where);
        hSeqGp02.addGap(20);
        hSeqGp02.addComponent(flightNo);

        GroupLayout.SequentialGroup hSeqGp03 = layout.createSequentialGroup();
        hSeqGp03.addGap(20);
        hSeqGp03.addComponent(takeoff);
        hSeqGp03.addGap(50);
        hSeqGp03.addComponent(picture);
        hSeqGp03.addGap(50);
        hSeqGp03.addComponent(arrive);

        GroupLayout.SequentialGroup hSeqGp04 = layout.createSequentialGroup();
        hSeqGp04.addGap(20);
        hSeqGp04.addComponent(airport1);
        hSeqGp04.addGap(130);
        hSeqGp04.addComponent(airport2);
        
        GroupLayout.SequentialGroup hSeqGp05 = layout.createSequentialGroup();
        hSeqGp05.addGap(40);
        hSeqGp05.addComponent(startTime);
        hSeqGp05.addGap(68);
        hSeqGp05.addComponent(time);
        hSeqGp05.addGap(75);
        hSeqGp05.addComponent(arriveTime);

        GroupLayout.SequentialGroup hSeqGp06 = layout.createSequentialGroup();
        hSeqGp06.addGap(30);
        hSeqGp06.addComponent(seat);
        hSeqGp06.addGap(70);
        hSeqGp06.addComponent(TerminalNum);
        hSeqGp06.addGap(105);
        hSeqGp06.addComponent(GateNo);

        GroupLayout.SequentialGroup hSeqGp07 = layout.createSequentialGroup();
        hSeqGp07.addGap(30);
        hSeqGp07.addComponent(food);
        hSeqGp07.addGap(40);
        hSeqGp07.addComponent(Terminal);
        hSeqGp07.addGap(83);
        hSeqGp07.addComponent(Gate);

        GroupLayout.SequentialGroup hSeqGp08 = layout.createSequentialGroup();
        hSeqGp08.addGap(25);
        hSeqGp08.addComponent(name);

        GroupLayout.SequentialGroup hSeqGp09 = layout.createSequentialGroup();
        hSeqGp09.addGap(25);
        hSeqGp09.addComponent(ID);

        GroupLayout.ParallelGroup hparallelGroup = layout.createParallelGroup();
        hparallelGroup.addGroup(hSeqGp01);
        hparallelGroup.addGroup(hSeqGp02);
        hparallelGroup.addGroup(hSeqGp03);
        hparallelGroup.addGroup(hSeqGp04);
        hparallelGroup.addGroup(hSeqGp05);
        hparallelGroup.addGroup(hSeqGp06);
        hparallelGroup.addGroup(hSeqGp07);
        hparallelGroup.addGroup(hSeqGp08);
        hparallelGroup.addGroup(hSeqGp09);

        layout.setHorizontalGroup(hparallelGroup);

        GroupLayout.SequentialGroup vSeqGP01 = layout.createSequentialGroup();
        vSeqGP01.addGap(5);
        vSeqGP01.addComponent(book);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(where);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(takeoff);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(airport1);
        vSeqGP01.addGap(25);
        vSeqGP01.addComponent(startTime);
        vSeqGP01.addGap(20);
        vSeqGP01.addComponent(seat);
        vSeqGP01.addGap(8);
        vSeqGP01.addComponent(food);

        GroupLayout.SequentialGroup vSeqGP02 = layout.createSequentialGroup();
        vSeqGP02.addGap(5);
        vSeqGP02.addComponent(bookID);
        vSeqGP02.addGap(15);
        vSeqGP02.addComponent(flightNo);
        vSeqGP02.addGap(10);
        vSeqGP02.addComponent(picture);
        vSeqGP02.addGap(40);
        vSeqGP02.addComponent(time);
        vSeqGP02.addGap(15);
        vSeqGP02.addComponent(TerminalNum);
        vSeqGP02.addGap(3);
        vSeqGP02.addComponent(Terminal);

        GroupLayout.SequentialGroup vSeqGP03 = layout.createSequentialGroup();
        vSeqGP03.addGap(5);
        vSeqGP03.addComponent(date);
        vSeqGP03.addGap(50);
        vSeqGP03.addComponent(arrive);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(airport2);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(arriveTime);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(GateNo);
        vSeqGP03.addGap(8);
        vSeqGP03.addComponent(Gate);
        
        GroupLayout.SequentialGroup vSeqGP04 = layout.createSequentialGroup();
        vSeqGP04.addComponent(name);
        vSeqGP04.addGap(2);
        vSeqGP04.addComponent(ID);

        GroupLayout.ParallelGroup vParallelGroup = layout.createParallelGroup();
        vParallelGroup.addGroup(vSeqGP01);
        vParallelGroup.addGroup(vSeqGP02);
        vParallelGroup.addGroup(vSeqGP03);
        
        GroupLayout.SequentialGroup vSeqGP = layout.createSequentialGroup();
        vSeqGP.addGap(20);
        vSeqGP.addGroup(vParallelGroup);
        vSeqGP.addGap(20);
        vSeqGP.addGroup(vSeqGP04);

        layout.setVerticalGroup(vSeqGP);

        panel.setLayout(layout);
        
        return panel;
    }
    
}
