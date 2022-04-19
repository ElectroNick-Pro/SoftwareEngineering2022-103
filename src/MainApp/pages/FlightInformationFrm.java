package MainApp.pages;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.w3c.dom.events.MouseEvent;

import MainApp.GlobalData;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.*;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.components.*;
import MainApp.pages.control.FlightInfo;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import javax.swing.JLayeredPane;
import java.util.*;

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

class FlightInfoButton extends JButton {
    public FlightInfo info;
    public FlightInfoButton() {
        super();
    }
}

public class FlightInformationFrm extends JFrame
{
    private Path path = Path.of("Retrieve/Flight Information");
    private JPanel contentPane;
    private FlightInfoPanel rightPanel = null;
    public FlightInfo passData = new FlightInfo();
    private int flag = (Integer)GlobalData.data.get("flag");
    private Map<Integer, FlightInfo> flightInfoMap;
    private int judgeFlage = 0;
    JLayeredPane pane = new JLayeredPane();
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightInformationFrm frame = new FlightInformationFrm();
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
    private static final int INFO_WIDTH = 420;
    private static final int INFO_HEIGHT = 250;
    public FlightInformationFrm(){
        if(flag == 2){
            flightInfoMap = FlightInfo.getInfoMap(((Customer)GlobalData.data.get("customer")).id);
        }
        else if(flag == 1){
            Ticket ticket = (Ticket)GlobalData.data.get("ticket");
            flightInfoMap = FlightInfo.getTicketInfoMap((ticket).id);
            Customer customer;
            try {
                customer = (Customer)ticket.customer.getReferred();
                GlobalData.data.put("customer",customer);
            } catch (ObjectNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        var tz_day = new SimpleDateFormat("MMM dd,yyyy", Locale.UK);
        tz_day.setTimeZone(((SimpleDateFormat)GlobalData.config.get("timezone")).getTimeZone());
        var tz_time = new SimpleDateFormat("HH:mm", Locale.UK);
        tz_time.setTimeZone(((SimpleDateFormat)GlobalData.config.get("timezone")).getTimeZone());
        GlobalData.data.put("dateformat", tz_day);
        GlobalData.data.put("timeformat", tz_time);

        int NUM = flightInfoMap.size();
        Pages.bindPage(this.path, this);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        // pane = new JLayeredPane();

        JLabel label = new JLabel("Flight Information");
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
        label.setBounds(45,85,523,49);
        add(label);

        JLabel smallLabel = new JLabel("Please choose your flight:                         ");
        smallLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        smallLabel.setBounds(47,117,509,70);
        add(smallLabel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/travel.png"));
        // image.setImage(image.getImage().getScaledInstance(960,0,Image.SCALE_DEFAULT));
        JLabel picture=new JLabel(image);
        //picture.setBounds(544,34,350,523);
        picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()-35);   
		// contentPane = (JPanel)this.getContentPane(); 	
        contentPane.add(picture,JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false);		
		this.getLayeredPane().setLayout(null);		
		this.getLayeredPane().add(picture, new Integer(Integer.MIN_VALUE));
        this.getLayeredPane().setBackground(Color.WHITE);

        // top panel
        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        contentPane.add(top);
        top.setVisible(true);

        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.white);
        var flightInfo = new FlightButton[100];
        int i_map = 0;
        for(var entry: flightInfoMap.entrySet()){
            var tuple = entry.getValue();
            var interval = tuple.interval.get(0);
            String departureCity = (String)interval.departureCity.getValue();
            String destCity = (String)interval.destCity.getValue();
            String flightNo = (String)tuple.flight.flightNo.getValue();
            var departureDt = (Date)interval.departureTime.getValue();
            String departureDate = ((SimpleDateFormat)GlobalData.data.get("dateformat")).format(departureDt);
            String airline = (String)tuple.airline.name.getValue();
            System.out.println(departureCity);
            flightInfo[i_map]=new FlightButton(tuple, departureCity,destCity,flightNo,departureDate,airline);  
            flightInfo[i_map].Layout();
            flightInfo[i_map].setBorder(new RoundBorder(Color.GRAY));
            i_map++; 
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
                        Pages.goBack();
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
                    if(e.getSource() != flightInfo[number]) {
                        return;
                    }
                    for(int j = 0; j < NUM;j++){
                        flightInfo[j].setBorder(new RoundBorder(Color.GRAY));
                    }
                    judgeFlage = 1;
                    flightInfo[number].setBorder(new RoundBorder(new Color(83,180,248)));
                    smallLabel.setText("Please choose the flight and check the information:");
                    ImageIcon newImage = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/background.png"));// 这是背景图片 .png .jpg .gif 等格式的图片都可以
                    picture.setIcon(newImage);
                    picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()-35);
                    passData = flightInfo[number].info;
                    String bookingID =(String)flightInfo[number].info.ticket.bookingId.getValue();
                    var departureDt = (Date)flightInfo[number].info.interval.get(0).departureTime.getValue();
                    String departureDate = ((SimpleDateFormat)GlobalData.data.get("dateformat")).format(departureDt);
                    String departureCity = (String)flightInfo[number].info.interval.get(0).departureCity.getValue();
                    String destCity = (String)flightInfo[number].info.interval.get(0).destCity.getValue();
                    String flightNo = (String)flightInfo[number].info.flight.flightNo.getValue();
                    String departureAirport = (String)flightInfo[number].info.interval.get(0).departureAirport.getValue();
                    String destAirport = (String)flightInfo[number].info.interval.get(0).destAirport.getValue();
                    String departureTime = ((SimpleDateFormat)GlobalData.data.get("timeformat")).format(departureDt);
                    var destDt = (Date)flightInfo[number].info.interval.get(0).destTime.getValue();
                    String destTime = ((SimpleDateFormat)GlobalData.data.get("timeformat")).format(destDt);
                    var timeDelta = Duration.between(departureDt.toInstant(), destDt.toInstant());
                    String timeDeltaStr = "" + timeDelta.toHours() + "h" + timeDelta.toMinutes() % 60 + "min";
                    String terminal = (String)flightInfo[number].info.interval.get(0).terminal.getValue();
                    String gate = (String)flightInfo[number].info.interval.get(0).gate.getValue();
                    String firstname = (String)((Customer)GlobalData.data.get("customer")).firstname.getValue();
                    String surname = (String)((Customer)GlobalData.data.get("customer")).surname.getValue();
                    String name = firstname+ " " + surname;
                    String ID =(String)((Customer)GlobalData.data.get("customer")).customerId.getValue();
                    String seatClass = (String)flightInfo[number].info.ticket.seatClass.getValue() + " class";
                    if(rightPanel!=null) {
                        rightPanel.setVisible(false);
                    }
                    FlightInfoPanel flightCheck = new FlightInfoPanel(bookingID,departureDate,departureCity,destCity,
                    flightNo,departureAirport,destAirport,departureTime,destTime,timeDeltaStr,
                    seatClass,"food provided",terminal,gate,name,ID);
                    flightCheck.Layout();
                    flightCheck.setBorder(new RoundBorder(Color.GRAY)); 
                    flightCheck.setBounds(500,80,415,355);
                    flightCheck.setVisible(true);
                    System.out.println(number+" "+destAirport);
                    rightPanel = flightCheck;
                    add(flightCheck);
                }
            });
        }
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(judgeFlage == 0){
                    JOptionPane.showMessageDialog(null, "Please choose a flight to check in", "notice", JOptionPane.ERROR_MESSAGE);
                }
                else{
                if(e.getSource() == next) {
                    // qxt
                    //get the class of seat the customer have chosen
                    //if he chose a normal seat before, ask if he want to upgrade
                    GlobalData.data.put("ticket", passData.ticket);
                    String seatclass = (String)passData.ticket.seatClass.getValue();
                    if(seatclass.equals("First")){
                        GlobalData.data.put("seatClass",seatclass);
                        GlobalData.data.put("flight",passData);
                        GlobalData.data.put("changeSeatClass", false);
                        new ChooseSeat("First", false);
                        try {
                            Pages.displayPage(path.resolve(Path.of("Choose Seat")));
                        } catch (UnboundPageException e1) {
                            e1.printStackTrace();
                        }
                    }else if(seatclass.equals("Normal")){
                        int choice = JOptionPane.showConfirmDialog(null, "Would you like to upgrade?", "Upgrade",JOptionPane.YES_NO_OPTION);
                        if(choice == JOptionPane.YES_OPTION){ //upgrade
                            GlobalData.data.put("seatClass","First");
                            GlobalData.data.put("flight",passData);
                            GlobalData.data.put("changeSeatClass", true);
                            new ChooseSeat("First", true);
                            try {
                                Pages.displayPage(path.resolve(Path.of("Choose Seat")));
                            } catch (UnboundPageException e1) {
                                e1.printStackTrace();
                            }
                        }else if(choice == JOptionPane.NO_OPTION){ //keep normal seat
                            GlobalData.data.put("seatClass",seatclass);
                            GlobalData.data.put("flight",passData);
                            GlobalData.data.put("changeSeatClass", false);
                            new ChooseSeat("Normal", false);
                            try {
                                Pages.displayPage(path.resolve(Path.of("Choose Seat")));
                            } catch (UnboundPageException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
                }
            }
        });
    }
}