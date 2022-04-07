package MainApp.pages;
import java.awt.Color;
import java.awt.*;

import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;
import MainApp.GlobalData;

import MainApp.pages.control.FlightInfo;
import MainApp.models.Model.UserModel.*;
import javax.swing.*;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
class MyPrintPanel extends JPanel {
    public Image image;
    public MyPrintPanel(Image image) {
        super();
        setBackground(Color.WHITE);
        this.image = image;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
}
public class confirmPrint extends JFrame{
    private Path path = Path.of("Retrieve/Flight Information/Choose Seat/Choose Food/Confirm and Pay/Print");
    private JPanel contentPane;
    JLayeredPane pane = new JLayeredPane();
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
        public void run(){
            try{
                confirmPrint frame = new confirmPrint();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        });
    }
    private static final int DEFAULT_WIDTH = 960;
    private static final int DEFAULT_HEIGHT = 540; 
    private static final int INFO_WIDTH = 420;
    private static final int INFO_HEIGHT = 250;
    public confirmPrint(){
        Pages.bindPage(this.path, this);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        pane = new JLayeredPane();

        // flow chart

        JLabel label1 = new JLabel("Please sacn your ID document:");
        label1.setFont(new Font("Microsoft YaHei", Font.PLAIN,18));
        label1.setBounds(45,100,341,191);

        JLabel label2 = new JLabel("Confirm and Print");
        label2.setFont(new Font("Microsoft YaHei", Font.BOLD,35));
        label2.setBounds(45,85,323,49);

    
        
        ImageIcon m =new ImageIcon("src/MainApp/pages/image/scanIDcard.png");
        m.setImage(m.getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel label3 = new JLabel(m);
        label3.setBounds(85,190,300,250);

        JButton btn = new JButton("Check in");
        btn.setBounds(45,400,425,38);
        btn.setFont(new Font("Microsoft YaHei", Font.BOLD,17));
        btn.setBackground(new Color(0,131,255));
        btn.setForeground(Color.white);
        btn.setBorder(new RoundBorder(new Color(30, 144, 255)));

        var flightInfo = (FlightInfo)GlobalData.data.get("flight");
        var seat = (Seat)GlobalData.data.get("seat");
var ticket = flightInfo.ticket;

String bookingID =(String)ticket.bookingId.getValue();
                    var departureDt = (Date)flightInfo.interval.get(0).departureTime.getValue();
                    String departureDate = new SimpleDateFormat("MMM dd,yyyy", Locale.US).format(departureDt);
                    String destCity = (String)flightInfo.interval.get(0).destCity.getValue();
                    String departureCity = (String)flightInfo.interval.get(0).departureCity.getValue();
                    String flightNo = (String)flightInfo.flight.flightNo.getValue();
                    String departureAirport = (String)flightInfo.interval.get(0).departureAirport.getValue();
                    String destAirport = (String)flightInfo.interval.get(0).destAirport.getValue();
                    String departureTime = new SimpleDateFormat("hh:mm").format(departureDt);
                    var destDt = (Date)flightInfo.interval.get(0).destTime.getValue();
                    String destTime = new SimpleDateFormat("hh:mm").format(destDt);
                    var timeDelta = Duration.between(departureDt.toInstant(), destDt.toInstant());
                    String timeDeltaStr = "" + timeDelta.toHours() + "h" + timeDelta.toMinutes() % 60 + "min";
                    String terminal = (String)flightInfo.interval.get(0).terminal.getValue();
                    String gate = (String)flightInfo.interval.get(0).gate.getValue();
                    String firstname = (String)((Customer)GlobalData.data.get("customer")).firstname.getValue();
                    String surname = (String)((Customer)GlobalData.data.get("customer")).surname.getValue();
                    String name = firstname+ " " + surname;
                    String ID =(String)((Customer)GlobalData.data.get("customer")).customerId.getValue();
                    String seatClass = (String)seat.seatClass.getValue() + " class";
                    String seatno = (String)seat.seatNo.getValue();
        JPanel panelFlight = createFlight(bookingID,departureDate,departureCity,destCity,
        flightNo,departureAirport,destAirport,departureTime,destTime,timeDeltaStr,
        seatClass,"food provided",terminal,gate,name,ID,seatno);
        panelFlight.setBorder(new RoundBorder(Color.gray));
        add(panelFlight);
        
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
        
        
        add(label1);
        add(label2);
        add(label3);
        add(btn);
        

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

        ImageIcon newImage = new ImageIcon("src/MainApp/pages/image/background.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
            // newImage.setImage(newImage.getImage().getScaledInstance(430,350,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
            picture.setIcon(newImage);
            picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()-35);
            panelFlight.setBounds(500,80,415,370);
                
    }

    private static JPanel createFlight(String flightbookID, String flightDate,String flightTakeoff,String flightArrive,
    String flightFlightNo,String flightAirport1,String flightAirport2, String flightStartTime,String flightArriveTime,
    String fightTime, String flightSeat,String flightFood,String FlightTerminalNum, String flightGateNo,String flightName,
    String fligthNameID,String seatno) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JLabel book = new JLabel("Booking ID");
        book.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));

        JLabel bookID = new JLabel(flightbookID);
        bookID.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));

        JLabel date = new JLabel(flightDate);
        date.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));

        JLabel where = new JLabel("Air China");
        where.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,20));
        ImageIcon image = new ImageIcon("D:/Git/software-engineering2022-103/src/MainApp/pages/image/airplane.png");//
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));//
        JLabel picture=new JLabel(image);

        JLabel takeoff = new JLabel(flightTakeoff);
        takeoff.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel arrive = new JLabel(flightArrive);
        arrive.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel flightNo = new JLabel(flightFlightNo);
        flightNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        JLabel airport1 = new JLabel(flightAirport1);
        airport1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        JLabel airport2 = new JLabel(flightAirport2);
        airport2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        JLabel startTime = new JLabel(flightStartTime);
        startTime.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        JLabel arriveTime = new JLabel(flightArriveTime);
        arriveTime.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        JLabel time = new JLabel(fightTime);
        time.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));


        JLabel seat = new JLabel(flightSeat);
        seat.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        JLabel food =new JLabel(flightFood);
        food.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        JLabel Terminal = new JLabel("Terminal");
        Terminal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        JLabel TerminalNum = new JLabel(FlightTerminalNum);
        TerminalNum.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel GateNo = new JLabel(flightGateNo);
        GateNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel Gate = new JLabel("Gate");
        Gate.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        JLabel name = new JLabel(flightName);
        name.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        JLabel ID = new JLabel(fligthNameID);
        ID.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        /*JLabel seattype = new JLabel("economy class");
        seattype.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        seattype.setForeground(new Color(0,131,255));*/

    
        JLabel seatN = new JLabel(seatno);
        seatN.setFont(new Font("Microsoft YaHei UI", Font.BOLD,20));
        seatN.setForeground(new Color(0,131,255));

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
        hSeqGp02.addGap(100);
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
        hSeqGp06.addComponent(food);
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
        hSeqGp08.addGap(80);
        hSeqGp08.addComponent(seat);

        GroupLayout.SequentialGroup hSeqGp09 = layout.createSequentialGroup();
        hSeqGp09.addGap(25);
        hSeqGp09.addComponent(ID);
        hSeqGp09.addGap(50);
        hSeqGp09.addComponent(seatN);

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
        vSeqGP01.addComponent(food);
        //vSeqGP01.addGap(8);
        //vSeqGP01.addComponent(food);

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
        vSeqGP03.addGap(55);
        vSeqGP03.addComponent(arrive);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(airport2);
        vSeqGP03.addGap(20);
        vSeqGP03.addComponent(arriveTime);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(GateNo);
        vSeqGP03.addGap(8);
        vSeqGP03.addComponent(Gate);
        
        GroupLayout.SequentialGroup vSeqGP04 = layout.createSequentialGroup();
        vSeqGP04.addComponent(name);
        vSeqGP04.addGap(2);
        vSeqGP04.addComponent(ID);

        GroupLayout.SequentialGroup vSeqGP05 = layout.createSequentialGroup();
        vSeqGP05.addComponent(seat);
        vSeqGP05.addGap(2);
        vSeqGP05.addComponent(seatN);

        GroupLayout.ParallelGroup vParallelGroup = layout.createParallelGroup();
        vParallelGroup.addGroup(vSeqGP01);
        vParallelGroup.addGroup(vSeqGP02);
        vParallelGroup.addGroup(vSeqGP03);
        GroupLayout.ParallelGroup vParallelGroup2 = layout.createParallelGroup();
        vParallelGroup2.addGroup(vSeqGP04);
        vParallelGroup2.addGroup(vSeqGP05);
        
        
        GroupLayout.SequentialGroup vSeqGP = layout.createSequentialGroup();
        vSeqGP.addGap(20);
        vSeqGP.addGroup(vParallelGroup);
        vSeqGP.addGap(20);
        vSeqGP.addGroup(vParallelGroup2);
       

        layout.setVerticalGroup(vSeqGP);

        panel.setLayout(layout);
        return panel;
        
    }
    
}


