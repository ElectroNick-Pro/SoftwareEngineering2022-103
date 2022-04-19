package MainApp.pages;
import javax.swing.*;

import java.awt.*;

public class FlightInfoPanel extends JPanel{
    ImageIcon image;
    JLabel book,bookID,date,where,takeoff,arrive,flightNo,airport1,airport2,startTime,arriveTime,time,seat,food,
    Terminal,TerminalNum,GateNo,Gate,name,ID,picture,seatClass,classNo,foodChoice;

    public FlightInfoPanel(String flightbookID, String flightDate,String flightTakeoff,String flightArrive,
    String flightFlightNo,String flightAirport1,String flightAirport2, String flightStartTime,String flightArriveTime,
    String fightTime, String flightSeat,String flightFood,String FlightTerminalNum, String flightGateNo,String flightName,
    String fligthNameID){
        var panel = this;
        panel.setOpaque(false);

        book = new JLabel("Booking ID");
        book.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));

        bookID = new JLabel(flightbookID);
        bookID.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));

        date = new JLabel(flightDate);
        date.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));

        where = new JLabel("Air China");
        where.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,20));

        image = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/airplane.png"));//
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));//
        picture=new JLabel(image);

        takeoff = new JLabel(flightTakeoff);
        takeoff.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        arrive = new JLabel(flightArrive);
        arrive.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        flightNo = new JLabel(flightFlightNo);
        flightNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        airport1 = new JLabel(flightAirport1);
        airport1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        airport2 = new JLabel(flightAirport2);
        airport2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        startTime = new JLabel(flightStartTime);
        startTime.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        arriveTime = new JLabel(flightArriveTime);
        arriveTime.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        time = new JLabel(fightTime);
        time.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        seat = new JLabel(flightSeat);
        seat.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        food =new JLabel(flightFood);
        food.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));

        Terminal = new JLabel("Terminal");
        Terminal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        TerminalNum = new JLabel(FlightTerminalNum);
        TerminalNum.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        GateNo = new JLabel(flightGateNo);
        GateNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        Gate = new JLabel("Gate");
        Gate.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

        name = new JLabel(flightName);
        name.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        ID = new JLabel(fligthNameID);
        ID.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
    }
    public JLabel getFlightClass(String flightClass){
        seatClass = new JLabel(flightClass);
        seatClass.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
        seatClass.setBackground(new Color(30, 144, 255));
        return seatClass;
    }
    public JLabel getFlightSeat(String seatNo){
        classNo = new JLabel(seatNo);
        classNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
        classNo.setBackground(new Color(30, 144, 255));
        return classNo;
    }
    public JLabel getFoodType(String foodType){
        foodChoice = new JLabel(foodType);
        foodChoice.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        foodChoice.setBackground(new Color(30, 144, 255));
        return foodChoice;
    }
    public void Visiable(){
        seat.setVisible(false);
        food.setVisible(false);
    }
    public void Layout(){
        GroupLayout layout = new GroupLayout(this);
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

        this.setLayout(layout);
    }
}
