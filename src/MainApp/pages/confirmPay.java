package MainApp.pages;

import java.awt.Color;
import java.awt.*;

import MainApp.GlobalData;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.components.*;
import MainApp.pages.control.FlightInfo;
import MainApp.models.Models;
import MainApp.models.Field.ForeignKey;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.*;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

class MyPayPanel extends JPanel {
    public Image image;

    public MyPayPanel(Image image) {
        super();
        setBackground(Color.WHITE);
        this.image = image;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class confirmPay extends JFrame {
    private Path path = Path.of("Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay");
    private JPanel contentPane;
    public FlightInfo info;
    JLayeredPane pane = new JLayeredPane();
    private Map<Integer, FlightInfo> flightInfoMap = FlightInfo
            .getInfoMap(((Customer) GlobalData.data.get("customer")).id);
    public Food food = (Food) GlobalData.data.get("food_choice");
    private Map<Integer, FoodPurchase> extraFoodMap;
    FoodPurchase[] all_food = new FoodPurchase[20];
    double[] food_price = new double[20];
    Double foodPrice = 0.0;

    private static final int DEFAULT_WIDTH = 965;
    private static final int DEFAULT_HEIGHT = 550;
    private static final int INFO_WIDTH = 420;
    private static final int INFO_HEIGHT = 250;

    public confirmPay() {
        Pages.bindPage(this.path, this);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        pane = new JLayeredPane();

        // flow chart

        JLabel label1 = new JLabel("Please check your information and pay the bill:");
        label1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
        label1.setBounds(45, 120, 378, 70);
        add(label1);

        JLabel label2 = new JLabel("Confirm and Pay");
        label2.setFont(new Font("Microsoft YaHei", Font.BOLD, 35));
        label2.setBounds(45, 90, 323, 49);
        add(label2);

        var flightInfo = (FlightInfo) GlobalData.data.get("flight");
        var seat = (Seat) GlobalData.data.get("seat");
        var ticket = flightInfo.ticket;
        String bookingID = (String) ticket.bookingId.getValue();
        var departureDt = (Date) flightInfo.interval.get(0).departureTime.getValue();
        String departureDate = new SimpleDateFormat("MMM dd,yyyy", Locale.UK).format(departureDt);
        String destCity = (String) flightInfo.interval.get(0).destCity.getValue();
        String departureCity = (String) flightInfo.interval.get(0).departureCity.getValue();
        String flightNo = (String) flightInfo.flight.flightNo.getValue();
        String departureAirport = (String) flightInfo.interval.get(0).departureAirport.getValue();
        String destAirport = (String) flightInfo.interval.get(0).destAirport.getValue();
        String departureTime = new SimpleDateFormat("hh:mm", Locale.UK).format(departureDt);
        var destDt = (Date) flightInfo.interval.get(0).destTime.getValue();
        String destTime = new SimpleDateFormat("hh:mm", Locale.UK).format(destDt);
        var timeDelta = Duration.between(departureDt.toInstant(), destDt.toInstant());
        String timeDeltaStr = "" + timeDelta.toHours() + "h" + timeDelta.toMinutes() % 60 + "min";
        String terminal = (String) flightInfo.interval.get(0).terminal.getValue();
        String gate = (String) flightInfo.interval.get(0).gate.getValue();
        String firstname = (String) ((Customer) GlobalData.data.get("customer")).firstname.getValue();
        String surname = (String) ((Customer) GlobalData.data.get("customer")).surname.getValue();
        String name = firstname + " " + surname;
        String ID = (String) ((Customer) GlobalData.data.get("customer")).customerId.getValue();
        String seatClass = (String) seat.seatClass.getValue();
        String seatType = (String) seat.type.getValue();
        String seatno = (String) seat.seatNo.getValue();
        Double seatprice = (Double) seat.price.getValue();
        JPanel panelFlight = createFlight(bookingID, departureDate, departureCity, destCity,
                flightNo, departureAirport, destAirport, departureTime, destTime, timeDeltaStr,
                seatClass, "food provided", terminal, gate, name, ID, seatno);
        panelFlight.setBorder(new RoundBorder(Color.gray));
        add(panelFlight);
        

        var extraFoodMap = (HashMap<Integer, FoodPurchase>)GlobalData.data.get("foodInfo");
        int i = 0;
        for(var entry: extraFoodMap.entrySet()){
            var tuple = entry.getValue();
            var foodId = tuple.food.getValue();
            var count = tuple.count.getValue();
            if(foodId != null){
                all_food[i] = new FoodPurchase();
                all_food[i].food.setValue(foodId);
                all_food[i].ticket.setValue(ticket.id);
                all_food[i].count.setValue(count);
                try {
                    var food = (Food)Food.getById(Food.class, (Integer)foodId);
                    food_price[i] = (Double)food.price.getValue();
                    foodPrice = foodPrice + food_price[i] * (Integer)count;
                } catch (ObjectNotFoundException e1) {
                    e1.printStackTrace();
                }
                i ++;
            }
        }
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/travel.png"));// ?????????????????? .png .jpg .gif ???????????????????????????
        // image.setImage(image.getImage().getScaledInstance(960,0,Image.SCALE_DEFAULT));//????????????????????????????????????20*20
        JLabel picture = new JLabel(image);
        // picture.setBounds(544,34,350,523);
        picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight() - 35); // ???????????????????????????????????????
        // contentPane = (JPanel)this.getContentPane(); //????????????????????????????????????
        contentPane.add(picture, JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false); // ?????????????????????????????????
        this.getLayeredPane().setLayout(null); // ??????????????????????????????
        this.getLayeredPane().add(picture, new Integer(Integer.MIN_VALUE));
        this.getLayeredPane().setBackground(Color.WHITE);

        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        add(top);
        top.setVisible(true);

        JButton next = new JButton();
        next.setBackground(new Color(0, 131, 255));
        next.setForeground(Color.white);
        next.setBounds(800, 460, 100, 35);
        next.setText("Next");
        next.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        next.setBorder(new RoundBorder(new Color(30, 144, 255)));
        next.setContentAreaFilled(true);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(foodPrice == 0){
                    new confirmPrint();
                    try {
                        Pages.displayPage(Path.of("Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Print"));
                        ((Seat)GlobalData.data.get("seat")).save();
                        var extraFoodMap = (HashMap<Integer, FoodPurchase>)GlobalData.data.get("foodInfo");
                        for(var entry: extraFoodMap.entrySet()){
                            var tuple = entry.getValue();
                            tuple.ticket.setValue(((Ticket)GlobalData.data.get("ticket")).id);
                            tuple.save();
                        }
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    credit frame = new credit();
                    frame.setBackground(Color.WHITE);
                    frame.setSize(515, 313);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
                
            }
        });
        add(next);

        JButton back = new JButton();
        back.setBackground(Color.gray);
        back.setText("Back");
        // back.setForeground(Color.white);
        back.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        back.setBorder(new RoundBorder(Color.gray));
        back.setBounds(25, 460, 100, 35);
        back.setContentAreaFilled(false);
        add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    try {
                        Pages.goBack();
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        ImageIcon newImage = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/background.png"));// ?????????????????? .png .jpg .gif ???????????????????????????
        // newImage.setImage(newImage.getImage().getScaledInstance(430,350,Image.SCALE_DEFAULT));//????????????????????????????????????20*20
        picture.setIcon(newImage);
        picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight() - 35);
        panelFlight.setBounds(500, 80, 415, 355);
        ImageIcon m = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/seat.png"));
        m.setImage(m.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));// ????????????????????????????????????20*20
        JPanel panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        panel1.setBorder(new RoundBorder(Color.gray));
        panel1.setBounds(45, 170, 375, 85);
        panel1.setBackground(Color.white);
        String mo = "$" + seatprice;

        JLabel label11 = new JLabel(mo);

        label11.setForeground(Color.red);
        label11.setBounds(300, 30, 75, 25);
        label11.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        panel1.add(label11);
        String co_1 = "";
        String co_2 = "";
        if(seatClass.equals("Normal")){
            co_1 = "Economy Class";
        }else if(seatClass.equals("First")){
            co_1 = "First Class";
        }
        if(seatType.equals("Normal") || seatType.equals("Window") ||seatType.equals("Aisle")){
            co_2 = seatType + " Seat";
        }else if(seatType.equals("Extra")){
            co_2 = "A Seat with Extra Space";
        }
        JLabel label12 = new JLabel(co_1, JLabel.CENTER);
        JLabel label122 = new JLabel(co_2, JLabel.CENTER);
        label12.setBounds(94, 15, 190, 32);
        label122.setBounds(95, 50, 190, 21);
        label12.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        label122.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
        panel1.add(label12);
        panel1.add(label122);
        JLabel label13 = new JLabel(m);
        label13.setBounds(20, 13, 60, 60);
        panel1.add(label13);
        add(panel1);

        ImageIcon m2 = new ImageIcon(ClassLoader.getSystemResource((String)food.image.getValue()));
        m2.setImage(m2.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));// ????????????????????????????????????20*20
        JPanel panel2 = new JPanel(null);
        panel2.setBackground(Color.white);
        panel2.setBorder(new RoundBorder(Color.gray));
        panel2.setBounds(45, 260, 375, 85);
        
        String mo2 = "$" + foodPrice;
        JLabel label21 = new JLabel(mo2);
        JLabel label212 = new JLabel("Click to see details", JLabel.CENTER);
        label21.setForeground(Color.red);
        label21.setBounds(300, 30, 75, 25);
        label212.setBounds(94, 50, 186, 21);
        label21.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        label212.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
        panel2.add(label21);
        String co2;
        JLabel label22;
        int length = 0;
        for(int j = 0 ; j < all_food.length; j ++){
            if(all_food[j] != null){
                length ++;
            }
        }
        if(length > 1){
            co2 = "Food";
            label22 = new JLabel(co2, JLabel.CENTER);
            label22.setBounds(110, 19, 157, 32);
            label22.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
            panel2.add(label22);
            panel2.add(label212);
            panel2.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) { 
                    if(e.getSource() == panel2) { //"food" panel
                        foodchoice f = new foodchoice();
                        f.setBackground(Color.WHITE);
                        f.setVisible(true);
                        f.setSize(519, 540);
                        f.setLocationRelativeTo(null);
                        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                }
                public void mousePressed(java.awt.event.MouseEvent e) {}
                public void mouseReleased(java.awt.event.MouseEvent e) {}
                public void mouseEntered(java.awt.event.MouseEvent e) {}
                public void mouseExited(java.awt.event.MouseEvent e) {}
            });
        }else{
            co2 = (String) food.name.getValue();
            label22 = new JLabel(co2, JLabel.CENTER);
            label22.setBounds(110, 27, 157, 35);
            label22.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
            panel2.add(label22);
        }
        
        JLabel label23 = new JLabel(m2);
        label23.setBounds(20, 18, 50, 50);
        panel2.add(label23);
        add(panel2);

        ImageIcon m3 = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/pay.png"));
        m3.setImage(m3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));// ????????????????????????????????????20*20
        JPanel panel3 = new JPanel(null);
        panel3.setBounds(45, 350, 375, 85);
        panel3.setBackground(Color.white);
        panel3.setBorder(new RoundBorder(Color.gray));
        var total_price = seatprice + foodPrice;
        String mo3 = "$" + total_price;
        JLabel label31 = new JLabel(mo3);
        label31.setForeground(Color.red);
        label31.setBounds(300, 30, 75, 25);
        label31.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        panel3.add(label31);
        JLabel label32 = new JLabel("Total", JLabel.CENTER);
        label32.setBounds(157, 32, 65, 21);
        label32.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        panel3.add(label32);
        JLabel label33 = new JLabel(m3);
        label33.setBounds(20, 18, 50, 50);
        panel3.add(label33);
        add(panel3);
    }

    private static JPanel createFlight(String flightbookID, String flightDate, String flightTakeoff,
            String flightArrive,
            String flightFlightNo, String flightAirport1, String flightAirport2, String flightStartTime,
            String flightArriveTime,
            String fightTime, String flightSeat, String flightFood, String FlightTerminalNum, String flightGateNo,
            String flightName,
            String fligthNameID, String seatno) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JLabel book = new JLabel("Booking ID");
        book.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 15));

        JLabel bookID = new JLabel(flightbookID);
        bookID.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 15));

        JLabel date = new JLabel(flightDate);
        date.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 15));

        JLabel where = new JLabel("Air China");
        where.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 20));
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/airplane.png"));//
        image.setImage(image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));//
        JLabel picture = new JLabel(image);

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

        JLabel food = new JLabel(flightFood);
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
        JLabel seatN = new JLabel(seatno);
        seatN.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        seatN.setForeground(new Color(0, 131, 255));

        /*
         * JLabel seattype = new JLabel("economy class");
         * seattype.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
         * seattype.setForeground(new Color(0,131,255));
         * 
         * JLabel seatno = new JLabel("12C");
         * seatno.setFont(new Font("Microsoft YaHei UI", Font.BOLD,20));
         * seatno.setForeground(new Color(0,131,255));
         */

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
        vSeqGP01.addGap(0);
        vSeqGP01.addComponent(book);
        vSeqGP01.addGap(10);
        vSeqGP01.addComponent(where);
        vSeqGP01.addGap(10);
        vSeqGP01.addComponent(takeoff);
        vSeqGP01.addGap(10);
        vSeqGP01.addComponent(airport1);
        vSeqGP01.addGap(20);
        vSeqGP01.addComponent(startTime);
        vSeqGP01.addGap(15);
        vSeqGP01.addComponent(food);
        // vSeqGP01.addGap(8);
        // vSeqGP01.addComponent(food);

        GroupLayout.SequentialGroup vSeqGP02 = layout.createSequentialGroup();
        vSeqGP02.addGap(0);
        vSeqGP02.addComponent(bookID);
        vSeqGP02.addGap(10);
        vSeqGP02.addComponent(flightNo);
        vSeqGP02.addGap(5);
        vSeqGP02.addComponent(picture);
        vSeqGP02.addGap(35);
        vSeqGP02.addComponent(time);
        vSeqGP02.addGap(10);
        vSeqGP02.addComponent(TerminalNum);
        vSeqGP02.addGap(0);
        vSeqGP02.addComponent(Terminal);

        GroupLayout.SequentialGroup vSeqGP03 = layout.createSequentialGroup();
        vSeqGP03.addGap(0);
        vSeqGP03.addComponent(date);
        vSeqGP03.addGap(50);
        vSeqGP03.addComponent(arrive);
        vSeqGP03.addGap(10);
        vSeqGP03.addComponent(airport2);
        vSeqGP03.addGap(15);
        vSeqGP03.addComponent(arriveTime);
        vSeqGP03.addGap(10);
        vSeqGP03.addComponent(GateNo);
        vSeqGP03.addGap(3);
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
