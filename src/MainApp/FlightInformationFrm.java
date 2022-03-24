package MainApp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.*;


public class FlightInformationFrm extends JFrame
{
    private JPanel contentPane;
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
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 600;
    public FlightInformationFrm(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        JLabel label = new JLabel("Flight Information");
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));


        JLabel smallLabel = new JLabel("Please choose your flight:                             ");
        smallLabel.setFont(new Font("宋体", Font.BOLD, 15));
        //  contentPane.add(smallLabel);

        JPanel flightCheck = createFlight();
        flightCheck.setBorder(new RoundBorder(Color.GRAY)); 

        // contentPane.add(flightInfo);

        ImageIcon image = new ImageIcon("src/MainApp/image/travel.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(410,350,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel picture=new JLabel();
        picture.setIcon(image);
        // contentPane.add(picture);

        JButton flightInfo = createButton();
        flightInfo.setBorder(new RoundBorder(Color.GRAY));

        //
        GroupLayout layout = new GroupLayout(contentPane);
        GroupLayout.ParallelGroup hparallelGroup1 = layout.createParallelGroup();
        hparallelGroup1.addComponent(label);
        hparallelGroup1.addComponent(smallLabel);
        
        GroupLayout.ParallelGroup hparallelGroup2 = layout.createParallelGroup();
        hparallelGroup2.addComponent(picture);

        GroupLayout.ParallelGroup hparallelGroup3 = layout.createParallelGroup(Alignment.LEADING);
        hparallelGroup3.addComponent(flightInfo,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

        GroupLayout.ParallelGroup hparallelGroup4 = layout.createParallelGroup();
        hparallelGroup4.addGroup(hparallelGroup1);
        hparallelGroup4.addGroup(hparallelGroup3);

        GroupLayout.SequentialGroup hSeqGp01 = layout.createSequentialGroup();
        hSeqGp01.addGap(50);
        hSeqGp01.addGroup(hparallelGroup4);
        hSeqGp01.addGap(50);
        hSeqGp01.addGroup(hparallelGroup2);

        layout.setHorizontalGroup(hSeqGp01);
        

        GroupLayout.ParallelGroup vparallelGroup1 = layout.createParallelGroup();
        vparallelGroup1.addComponent(label);

        GroupLayout.ParallelGroup vparallelGroup2 = layout.createParallelGroup();
        vparallelGroup2.addComponent(smallLabel);

        GroupLayout.ParallelGroup vparallelGroup3 = layout.createParallelGroup();
        vparallelGroup3.addComponent(flightInfo,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

        GroupLayout.SequentialGroup vSeqGp01 = layout.createSequentialGroup();
        vSeqGp01.addGap(70);
        vSeqGp01.addGroup(vparallelGroup1);
        vSeqGp01.addGap(20);
        vSeqGp01.addGroup(vparallelGroup2);
        vSeqGp01.addGap(20);
        vSeqGp01.addGroup(vparallelGroup3);

        GroupLayout.SequentialGroup vSeqGp02 = layout.createSequentialGroup();
        vSeqGp02.addGap(100);
        vSeqGp02.addComponent(picture);

        GroupLayout.ParallelGroup vparallelGroup4 = layout.createParallelGroup();
        vparallelGroup4.addGroup(vSeqGp01);
        vparallelGroup4.addGroup(vSeqGp02);

        layout.setVerticalGroup(vparallelGroup4);


        contentPane.setLayout(layout);
        flightInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flightInfo.setBorder(new RoundBorder(new Color(83,180,248)));

                GroupLayout.SequentialGroup hSequential = layout.createSequentialGroup();
                hSequential.addGap(550);
                hSequential.addComponent(flightCheck,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

                layout.setHorizontalGroup(hSequential);

                GroupLayout.SequentialGroup vSequential = layout.createSequentialGroup();
                vSequential.addGap(60);
                vSequential.addComponent(flightCheck,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
                layout.setVerticalGroup(vSequential );

                smallLabel.setText("Please choose the flight and check the information:");
                // picture.setVisible(false);
                ImageIcon newImage = new ImageIcon("src/MainApp/image/background.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
                image.setImage(newImage.getImage().getScaledInstance(410,350,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
                picture.setIcon(newImage);


            }
        });


    }
    // private static JPanel createPanel() {
    //     JPanel panel = new JPanel();
    //     panel.setPreferredSize(new Dimension(450, 110));
    //     panel.setBackground(Color.WHITE);
        
    //     return panel;
    // }
    private static JButton createButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(450, 110));
        button.setBackground(Color.WHITE);
        
        ImageIcon image = new ImageIcon("src/MainApp/image/airplane.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel picture=new JLabel(image);

        JLabel takeoff = new JLabel("Beijing");
        takeoff.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel arrive = new JLabel("Shanghai");
        arrive.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel flightNo = new JLabel("KN2316");
        flightNo.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel date = new JLabel("Mar 20,2022");
        date.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel where = new JLabel("Air China");
        where.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        //

        GroupLayout layout = new GroupLayout(button);
        GroupLayout.SequentialGroup hSeqGp01 = layout.createSequentialGroup();
        hSeqGp01.addGap(30);
        hSeqGp01.addComponent(takeoff);
        hSeqGp01.addGap(70);
        hSeqGp01.addComponent(picture);
        hSeqGp01.addGap(60);
        hSeqGp01.addComponent(arrive);

        GroupLayout.SequentialGroup hSeqGp02 = layout.createSequentialGroup();
        hSeqGp02.addGap(30);
        hSeqGp02.addComponent(where);
        hSeqGp02.addGap(10);
        hSeqGp02.addComponent(flightNo);
        hSeqGp02.addGap(170);
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
        vSeqGp01.addGap(20);
        vSeqGp01.addGroup(vparallelGroup1);
        vSeqGp01.addGap(10);
        vSeqGp01.addComponent(takeoff);

        GroupLayout.SequentialGroup vSeqGp02 = layout.createSequentialGroup();
        vSeqGp02.addGap(20);
        vSeqGp02.addComponent(date);
        vSeqGp02.addGap(10);
        vSeqGp02.addComponent(arrive);

        GroupLayout.SequentialGroup vSeqGp03 = layout.createSequentialGroup();
        vSeqGp03.addGap(40);
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
        panel.setPreferredSize(new Dimension(400, 400));
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
        flightNo.setFont(new Font("宋体", Font.BOLD, 20));

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
        name.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

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
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(book);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(where);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(takeoff);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(airport1);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(startTime);
        vSeqGP01.addGap(25);
        vSeqGP01.addComponent(seat);
        vSeqGP01.addGap(18);
        vSeqGP01.addComponent(food);

        GroupLayout.SequentialGroup vSeqGP02 = layout.createSequentialGroup();
        vSeqGP02.addGap(15);
        vSeqGP02.addComponent(bookID);
        vSeqGP02.addGap(15);
        vSeqGP02.addComponent(flightNo);
        vSeqGP02.addGap(15);
        vSeqGP02.addComponent(picture);
        vSeqGP02.addGap(40);
        vSeqGP02.addComponent(time);
        vSeqGP02.addGap(15);
        vSeqGP02.addComponent(TerminalNum);
        vSeqGP02.addGap(5);
        vSeqGP02.addComponent(Terminal);

        GroupLayout.SequentialGroup vSeqGP03 = layout.createSequentialGroup();
        vSeqGP03.addGap(20);
        vSeqGP03.addComponent(date);
        vSeqGP03.addGap(50);
        vSeqGP03.addComponent(arrive);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(airport2);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(arriveTime);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(GateNo);
        vSeqGP03.addGap(10);
        vSeqGP03.addComponent(Gate);
        
        GroupLayout.SequentialGroup vSeqGP04 = layout.createSequentialGroup();
        vSeqGP04.addComponent(name);
        vSeqGP04.addGap(10);
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
