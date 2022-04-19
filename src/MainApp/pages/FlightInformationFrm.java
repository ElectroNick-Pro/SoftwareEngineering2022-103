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
import junit.framework.Test;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


import javax.swing.JLayeredPane;
import java.util.*;

import java.awt.*;
//测试的时间在175行
//现在的时间是112行
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
    /***************** */
    public int isCheckin;
    public int timeValue;
    public int timeIndex;

    public FlightInfo info;
    public FlightInfoButton() {
        super();
    }
}

public class FlightInformationFrm extends JFrame
{
    private Path path = Path.of("Retrieve/Flight Information");//啥？的路径
    private JPanel contentPane;
    private FlightInfoPanel rightPanel = null;
    public FlightInfo passData = new FlightInfo();
    private int flag = (Integer)GlobalData.data.get("flag");
    private Map<Integer, FlightInfo> flightInfoMap;
    private int judgeFlage = 0;
    private int nowchoice=0;
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
        if(flag == 2){//如果flag=2,从数据库中获取customerID
            flightInfoMap = FlightInfo.getInfoMap(((Customer)GlobalData.data.get("customer")).id);
        }
        else if(flag == 1){//如果flag=1,从数据库获取ticketID
            Ticket ticket = (Ticket)GlobalData.data.get("ticket");
            flightInfoMap = FlightInfo.getTicketInfoMap((ticket).id);
            Customer customer;
            try {
                customer = (Customer)ticket.customer.getReferred();//寻找和ticketID符合的customer
                GlobalData.data.put("customer",customer);//把customerID放在globaldata,后来使用
            } catch (ObjectNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        var tz_day = new SimpleDateFormat("MMM dd,yyyy", Locale.UK);
        tz_day.setTimeZone(((SimpleDateFormat)GlobalData.config.get("timezone")).getTimeZone());//日期
        var tz_time = new SimpleDateFormat("HH:mm", Locale.UK);
        tz_time.setTimeZone(((SimpleDateFormat)GlobalData.config.get("timezone")).getTimeZone());//时间
        GlobalData.data.put("dateformat", tz_day);
        GlobalData.data.put("timeformat", tz_time);

//*********************这里是现在的时间，先不用，没法测试 */
/*var now_time=new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.UK);
now_time.setTimeZone(((SimpleDateFormat)GlobalData.config.get("timezone")).getTimeZone());
String nowtime=now_time.format(new Date());
System.out.println(nowtime);*/

        int NUM = flightInfoMap.size();
        Pages.bindPage(this.path, this);//？
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
        // GlobalData.data.put("curPath",this.path);
        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        contentPane.add(top);
        top.setVisible(true);

        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.white);
        var flightInfo = new FlightButton[100];
        int i_map = 0;

        //******************************** */
        int[] timeValue=new int[100];

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

            //这里是测试的时间******************************************************
            String testtime="2022-04-08 12:00:00";
            String flighttime=(String)interval.departureTime.csvForm;
            System.out.println(flighttime);
            timeValue[i_map]=strtotime(testtime, flighttime);
            flightInfo[i_map].timeValue=strtotime(testtime, flighttime);
            int IsCheckin =(int)tuple.ticket.isCheckin.getValue();
            flightInfo[i_map].isCheckin=IsCheckin;
            if(testtime.compareTo(flighttime)>0){
                flightInfo[i_map].setBackground(Color.GRAY);
            }
            else{}
            i_map++; 
        }
        int[] timeIndex=TimeCmp(timeValue, i_map);
        for(int i=0;i<i_map;i++){
            flightInfo[i].timeIndex=timeIndex[i];
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

        //将按钮按时间次序重新排序********************************************
        GroupLayout.SequentialGroup vSeqGpInfo = layout1.createSequentialGroup();
        for(int i = 0; i <NUM;i++){
            vSeqGpInfo.addGap(11);
            for(int j=0;j<NUM;j++){
                if(i==timeIndex[j])
            vSeqGpInfo.addComponent(flightInfo[j],GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
            }
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
                    //************* */
                    nowchoice=number;

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
                    //System.out.println(departureTime);
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
                    int ticketid=(int)flightInfo[number].info.ticket.id;
                    
                    if(rightPanel!=null) {
                        rightPanel.setVisible(false);
                    }
            if(flightInfo[number].isCheckin==0){
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
                else{//是Checkin过的票
                    System.out.println("Now the ticketid is: "+ticketid);
                    try{
                    try{                  
                    var foodstream=FoodPurchase.queryByProperty(FoodPurchase.class, "Ticket_id", ticketid);
                    var foodbuy=foodstream.toArray();
                    var foodid1=((FoodPurchase)foodbuy[0]).food.getReferred().id;
                    System.out.println("foodid is:"+foodid1);
                    var food2=Food.getById(Food.class, foodid1).name;
                    System.out.println(food2.getValue().toString());
                   //获取座位，不知道为什么报错，一会再说
                   
                   var seatstream=Ticket.getById(Ticket.class, ticketid);
                   var seatbuy=seatstream.seatClass.getValue().toString();
                    /*var seatbuy=seatstream.toArray();
                    String seatname=(String)((Ticket)seatbuy[0]).seatClass.getValue().toString();*/
                    System.out.println(seatbuy);

                    JPanel flightChecked = confirmPrint.createFlight(bookingID,departureDate,departureCity,destCity,
                    flightNo,departureAirport,destAirport,departureTime,destTime,timeDeltaStr,
                    seatClass,food2.getValue().toString(),terminal,gate,name,ID,seatbuy);

                    flightChecked.setBorder(new RoundBorder(Color.GRAY)); 
                    flightChecked.setBounds(500,80,415,355);
                    flightChecked.setVisible(true);
                    System.out.println(number+" "+destAirport);
                    rightPanel = flightChecked;
                    add(flightChecked);
                }catch(ObjectNotFoundException e2){
                    e2.printStackTrace();
                }

                }catch(FieldNotFoundException f){
                    f.printStackTrace();
               }
    
                }
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
                    String seatclass = (String)passData.ticket.seatClass.getValue();;
                    if((String) GlobalData.data.get("seatClass") == null){
                    // qxt
                    //get the class of seat the customer have chosen
                    //if he chose a normal seat before, ask if he want to upgrade
                    //************************************************************************* */
                    if(flightInfo[nowchoice].timeValue<0){//判断是否出行过
                    //没出行过
                    if(flightInfo[nowchoice].isCheckin==0){//判断是否checkin了
                    if(timeIndex[nowchoice]==0)//判断是否是最近的一张,是
                    {

                    GlobalData.data.put("ticket", passData.ticket);
                    String seatclass = (String)passData.ticket.seatClass.getValue();
                    if(seatclass.equals("First")){
                        GlobalData.data.put("seatClass",seatclass);
                    }else{
                        seatclass = (String)GlobalData.data.get("seatClass");
                    }
                    if((Boolean) GlobalData.data.get("changeSeatClass") == null){
                        GlobalData.data.put("changeSeatClass", false);
                    }
                    if((Boolean) GlobalData.data.get("haveAskToUpgrade") == null){
                        GlobalData.data.put("haveAskToUpgrade", false);
                    }
                    GlobalData.data.put("ticket", passData.ticket);
                    GlobalData.data.put("flight",passData);
                    
                    if(seatclass.equals("First")){
                        new ChooseSeat();
                        try {
                            Pages.displayPage(path.resolve(Path.of("Choose Seat")));
                        } catch (UnboundPageException e1) {
                            e1.printStackTrace();
                        }
                    }else if(seatclass.equals("Normal")){
                            new ChooseSeat();
                            try {
                                Pages.displayPage(path.resolve(Path.of("Choose Seat")));
                            } catch (UnboundPageException e1) {
                                e1.printStackTrace();
                            }
                    }
                }else{
                    //没checkin但不是最近的一张
                    JOptionPane.showMessageDialog(null, "There is earlier tickted waited.","Another ticket!",JOptionPane.INFORMATION_MESSAGE);

                }
            }else{
//已经checkin过了,没出行
JOptionPane.showMessageDialog(null, "Please ask for manual service","You have CHECK IN!",JOptionPane.INFORMATION_MESSAGE);

            }
            }
                else{
                    //System.out.println("Nope");
//出行过了
JOptionPane.showMessageDialog(null, "Expired!","This ticket is out of date!",JOptionPane.INFORMATION_MESSAGE);
 
                }
                }
                }
            }
        }
    });
    
    //********************************************** */
    private int[] TimeCmp(int[] timevalue,int imap){
        int[] timeIndex=new int[100];
        int expired=0;
        for(int i=0;i<imap;i++){
            if(timevalue[i]<0){
        expired++;//过期的排在第几个
            }
        }
        System.out.println("The value of expired is:"+expired);
        for(int j=0;j<imap;j++){
            if(timevalue[j]<0)//先比没过期的 
            {
                int whetherbig=0;
            for(int k=0;k<imap;k++){
             if(timevalue[k]<0)
             {   if(j!=k)
                {
                    if(timevalue[j]<=timevalue[k]){
                        whetherbig++;
                    }
                    }
                }
                timeIndex[j]=whetherbig;
            }
             
            }
        }
         for(int jd=0;jd<imap;jd++){
                if(timevalue[jd]>0)//再比过期的
                {
                    int whetherbig=expired;
                for(int kd=0;kd<imap;kd++){
                 if(timevalue[kd]>0) {
                        if(jd!=kd){
                        if(timevalue[jd]>=timevalue[kd]){
                            whetherbig++;}
                        }
                    }
                    timeIndex[jd]=whetherbig;
                }
                
                }
                for(int f=0;f<imap;f++)//这就测试的,没用
            {
                System.out.println("The index is:"+timeIndex[f]);}
        }
        return timeIndex;
            }
        //***************************************** */
        private int strtotime(String str1,String str2){
            char[] fir=str1.toLowerCase().toCharArray();
            char[] sec=str2.toLowerCase().toCharArray();
            int value=0;
            for(int i=0;i<str1.length();i++){
                if(fir[i]-0>47&&fir[i]<58){
                    //int m=(fir[i]-0-48)-(sec[i]-0-48);
                   // System.out.println("minus="+m);
                   value+=((fir[i]-0-48)-(sec[i]-0-48))*(Math.pow((int)10, (int)(10-i)));
                   //System.out.println("Value="+value);
                   //System.out.println("Now i= "+i);
                }
            }
           // System.out.println("The length is :"+str1.length());
           System.out.println("The value is :"+value);
        
            return value;
        }
}