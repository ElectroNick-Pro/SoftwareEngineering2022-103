package MainApp.pages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.util.stream.Stream;
import java.awt.Font;
import java.awt.*;
import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.models.Field.ForeignKey;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.Interval;
import MainApp.models.Model.UserModel.Seat;
import MainApp.models.Model.UserModel.Ticket;
import MainApp.pages.components.*;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.control.FlightInfo;
import java.nio.file.Path;
import java.util.LinkedList;

public class ChooseSeat extends JFrame{
    public int width = 965;
    public int height = 550;
    private String seatClass = "";
    private boolean haveChosen = false;
    private boolean havePaid = false;
    public boolean changeSeatClass = false;
    private int normalRest = 0;
    private int windowRest = 0;
    private int aisleRest = 0;
    private int extraRest = 0;
    private double normalMoney = 0.0;
    private double windowMoney = 0.0;
    private double aisleMoney = 0.0;
    private double extraMoney = 0.0;
    public double seatMoney = 0.0;
    private Ticket ticket;
    public Seat seat;
    private int interval_id = 1;
    private FlightInfo flightinfo = (FlightInfo)GlobalData.data.get("flight");
    public Boolean haveAskToUpgrade = (Boolean) GlobalData.data.get("haveAskToUpgrade");
    JFrame f = this;

    {
        ticket = flightinfo.ticket;
        seatClass = (String)GlobalData.data.get("seatClass");
        changeSeatClass = (boolean)GlobalData.data.get("changeSeatClass");
        getAllSeat();
        
        if((Seat)GlobalData.data.get("seat") != null){
            int intervalId = (Integer)((Seat)GlobalData.data.get("seat")).interval.getValue();
            if(intervalId == interval_id){
                seat = (Seat)GlobalData.data.get("seat");
                haveChosen = true;
            }else{
                seat = getChosenSeat();
            }
        }else{
            seat = getChosenSeat();
        }
    }
    private JButton normal = normalSeat(f);
    private JButton window = windowSeat(f);
    private JButton aisle = aisleSeat(f);
    private JButton extra = extraSeat(f);
    private Path path = Path.of("Retrieve/Flight Information/Choose Seat");
    public ChooseSeat(){
        super("Choose seat");
        Pages.bindPage(this.path, this);
        seatClass = (String)GlobalData.data.get("seatClass");
        
        // System.out.println("Line 71: " + changeSeatClass);
        
        if(seat != null){
            if(! seat.seatClass.equals(seatClass)){
                //the customer try to upgrade
                seat = null;
                haveChosen = false;
            }
        }
        myFrame();
        front(); //exit + mian bao xie + question service
        title_hint(); //title + hint
        bottom(); // back + next button
        buttonAction(); //4 buttons action 
        f.setLocationRelativeTo(null); 
        if(seatClass.equals("Normal") && !haveAskToUpgrade){
            
            upgrade();
        }
    }

    private void myFrame(){
        f.setLayout(null);
        f.getContentPane().setBackground(Color.WHITE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0,0,width,height);
    }
    private void title_hint(){
        /**
         * title
         */
        JLabel title1 = new JLabel("Choose Seat ");
        title1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35)); 
        String seatclass = "";
        if(seatClass.equals("First")){
            seatclass = "First Class Seats";
        }else if(seatClass.equals("Normal")){
            seatclass = "Economy Class Seats";
        }
        JLabel title2 = new JLabel(seatclass);
        title2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));         
        /**
         * hint
         */
        JLabel hint = new JLabel("Please choose a type of seat that you prefer, and the system will assign a seat for you.");
        hint.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15)); 

        title1.setBounds(40,80,230,49);
        title2.setBounds(289,88,270,40);
        hint.setBounds(40,112,650,70);
        f.add(title1);
        f.add(title2);
        f.add(hint);
    }
    private JButton normalSeat(JFrame f){
        JButton normal = new JButton();
        normal.setActionCommand("normalSeat");;
        normal.setContentAreaFilled(false);
        JLabel normal_text1 = new JLabel("A Normal", JLabel.CENTER);
        JLabel normal_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel normal_money = new JLabel("$"+normalMoney, JLabel.CENTER);
        JLabel normal_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel normal_num2 = new JLabel(normalRest+"", JLabel.CENTER);
        normal_text1.setFont(new Font("Arial", Font.BOLD, 33));
        normal_text2.setFont(new Font("Arial", Font.BOLD, 33));
        normal_money.setFont(new Font("Arial", Font.PLAIN, 17));
        normal_money.setForeground(new ColorUIResource(Color.red));
        normal_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen && !havePaid){
            if(seat.type.getValue().equals("Normal") && seat.seatClass.getValue().equals(seatClass)){
                normal.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
            }else{
                normal.setBorder(new RoundBorder(Color.GRAY));   
            }
        }else{
            normal.setBorder(new RoundBorder(Color.GRAY));   
        }
        if(normalRest > 0){
            normal_num1.setForeground(new ColorUIResource(0,131,255));
            normal_num2.setForeground(new ColorUIResource(0,131,255)); 
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Normal") && seat.seatClass.getValue().equals(seatClass)){
                    normal.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    normal.setBorder(new RoundBorder(Color.GRAY));   
                }
            }else{
                normal.setBorder(new RoundBorder(Color.GRAY));   
            }
            normal_text1.setForeground(Color.GRAY);
            normal_text2.setForeground(Color.GRAY);
            normal_money.setForeground(Color.GRAY);
            normal_num1.setForeground(Color.GRAY);
            normal_num2.setForeground(Color.GRAY);
        }
        normal.setBounds(40,175,195,268);
        normal_text1.setBounds(61,224,152,42);
        normal_text2.setBounds(61,266,152,42);
        normal_money.setBounds(105,299,60,42);
        normal_num1.setBounds(90,341,94,24);
        normal_num2.setBounds(90,365,94,24);
        
        f.add(normal);
        f.add(normal_text1);
        f.add(normal_text2);
        System.out.println("Line 174: " + changeSeatClass);
        if(changeSeatClass){
            f.add(normal_money);
        }
        f.add(normal_num1);
        f.add(normal_num2);
        return normal;
    }
    private JButton windowSeat(JFrame f){
        JButton window = new JButton();
        window.setActionCommand("windowSeat");
        window.setContentAreaFilled(false); 
        JLabel window_text1 = new JLabel("A Window", JLabel.CENTER);
        JLabel window_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel window_money = new JLabel("$"+windowMoney, JLabel.CENTER);
        JLabel window_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel window_num2 = new JLabel(windowRest+"", JLabel.CENTER);
        window_text1.setFont(new Font("Arial", Font.BOLD, 33));
        window_text2.setFont(new Font("Arial", Font.BOLD, 33));
        window_money.setFont(new Font("Arial", Font.PLAIN, 17));
        window_money.setForeground(new ColorUIResource(Color.red));
        window_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen && !havePaid){
            if(seat.type.getValue().equals("Window") && seat.seatClass.getValue().equals(seatClass)){
                window.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
            }else{
                window.setBorder(new RoundBorder(Color.GRAY));  
            }
        }else{
            window.setBorder(new RoundBorder(Color.GRAY));  
        }
        if(windowRest > 0){
            window_num1.setForeground(new ColorUIResource(0,131,255));
            window_num2.setForeground(new ColorUIResource(0,131,255));
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Window") && seat.seatClass.getValue().equals(seatClass)){
                    window.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    window.setBorder(new RoundBorder(Color.GRAY));  
                }
            }else{
                window.setBorder(new RoundBorder(Color.GRAY));  
            }
            window_text1.setForeground(Color.GRAY);
            window_text2.setForeground(Color.GRAY);
            window_money.setForeground(Color.GRAY);
            window_num1.setForeground(Color.GRAY);
            window_num2.setForeground(Color.GRAY);
        }
        window.setBounds(265,175,195,268);
        window_text1.setBounds(280,224,165,42);
        window_text2.setBounds(280,266,165,42);
        window_money.setBounds(330,299,60,42);
        window_num1.setBounds(315,341,94,24);
        window_num2.setBounds(315,365,94,24);
        f.add(window);
        f.add(window_text1);
        f.add(window_text2);
        if(changeSeatClass){
            f.add(window_money);
        }
        f.add(window_num1);
        f.add(window_num2);
        return window;
    }
    private JButton aisleSeat(JFrame f){
        JButton aisle = new JButton();
        aisle.setActionCommand("aisleSeat");
        aisle.setContentAreaFilled(false);  
        JLabel aisle_text1 = new JLabel("An Aisle", JLabel.CENTER);
        JLabel aisle_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel aisle_money = new JLabel("$"+aisleMoney, JLabel.CENTER);
        JLabel aisle_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel aisle_num2 = new JLabel(aisleRest+"", JLabel.CENTER);
        aisle_text1.setFont(new Font("Arial", Font.BOLD, 33));
        aisle_text2.setFont(new Font("Arial", Font.BOLD, 33));
        aisle_money.setFont(new Font("Arial", Font.PLAIN, 17));
        aisle_money.setForeground(new ColorUIResource(Color.red));
        aisle_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aisle_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen && !havePaid){
            if(seat.type.getValue().equals("Aisle") && seat.seatClass.getValue().equals(seatClass)){
                aisle.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
            }else{
                aisle.setBorder(new RoundBorder(Color.GRAY));  
            }
        }else{
            aisle.setBorder(new RoundBorder(Color.GRAY));  
        }        
        if(aisleRest > 0){
            aisle_num1.setForeground(new ColorUIResource(0,131,255));
            aisle_num2.setForeground(new ColorUIResource(0,131,255));
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Aisle") && seat.seatClass.getValue().equals(seatClass)){
                    aisle.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    aisle.setBorder(new RoundBorder(Color.GRAY));  
                }
            }else{
                aisle.setBorder(new RoundBorder(Color.GRAY));  
            } 
            aisle_text1.setForeground(Color.GRAY);
            aisle_text2.setForeground(Color.GRAY);
            aisle_money.setForeground(Color.GRAY);
            aisle_num1.setForeground(Color.GRAY);
            aisle_num2.setForeground(Color.GRAY);
        }
        aisle.setBounds(490,175,195,268);
        aisle_text1.setBounds(513,224,150,42);
        aisle_text2.setBounds(513,266,150,42);
        aisle_money.setBounds(555,299,60,42);
        aisle_num1.setBounds(540,341,94,24);
        aisle_num2.setBounds(540,365,94,24);
        f.add(aisle);
        f.add(aisle_text1);
        f.add(aisle_text2);
        if(changeSeatClass){
            f.add(aisle_money);
        }
        f.add(aisle_num1);
        f.add(aisle_num2);
        return aisle;
    }
    private JButton extraSeat(JFrame f){
        JButton extra = new JButton();
        extra.setActionCommand("extraSeat");
        extra.setContentAreaFilled(false);  
        double money = extraMoney;
        if(!changeSeatClass && seatClass.equals("First")){
            money = extraMoney - normalMoney;
        }
        JLabel extra_text1 = new JLabel("A Seat with", JLabel.CENTER);
        JLabel extra_text2 = new JLabel("Extra Space", JLabel.CENTER);
        JLabel extra_money = new JLabel("$"+money, JLabel.CENTER);
        JLabel extra_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel extra_num2 = new JLabel(extraRest+"", JLabel.CENTER);
        extra_text1.setFont(new Font("Arial", Font.BOLD, 32));
        extra_text2.setFont(new Font("Arial", Font.BOLD, 32));
        extra_money.setFont(new Font("Arial", Font.PLAIN, 17));
        extra_money.setForeground(new ColorUIResource(Color.red));
        extra_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen && !havePaid){
            if(seat.type.getValue().equals("Extra") && seat.seatClass.getValue().equals(seatClass)){
                extra.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
            }else{
                extra.setBorder(new RoundBorder(Color.GRAY));  
            }
        }else{
            extra.setBorder(new RoundBorder(Color.GRAY));   
        }        
        if(extraRest > 0){
            extra_num1.setForeground(new ColorUIResource(0,131,255));
            extra_num2.setForeground(new ColorUIResource(0,131,255));
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Extra") && seat.seatClass.getValue().equals(seatClass)){
                    extra.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    extra.setBorder(new RoundBorder(Color.GRAY));  
                }
            }else{
                extra.setBorder(new RoundBorder(Color.GRAY));   
            }
            extra_text1.setForeground(Color.GRAY);
            extra_text2.setForeground(Color.GRAY);
            extra_money.setForeground(Color.GRAY);
            extra_num1.setForeground(Color.GRAY);
            extra_num2.setForeground(Color.GRAY);
        }
        extra.setBounds(715,175,195,268);
        extra_text1.setBounds(719,224,186,42);
        extra_text2.setBounds(719,266,186,42);
        extra_money.setBounds(780,299,60,42);
        extra_num1.setBounds(765,341,94,24);
        extra_num2.setBounds(765,365,94,24);
        f.add(extra);
        f.add(extra_text1);
        f.add(extra_text2);
        f.add(extra_money);
        f.add(extra_num1);
        f.add(extra_num2);
        return extra;
    }
    private class seatActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonName = e.getActionCommand();
            if(havePaid){
                JOptionPane.showMessageDialog(null, "You have paid for your seat and food.\nYou can't choose seat again!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if(buttonName.equals("normalSeat")){
                    if(normalRest != 0){
                        chooseSeat("Normal",seatClass);
                    }else{
                        JOptionPane.showMessageDialog(null, "no normal seat left", "normal", JOptionPane.ERROR_MESSAGE);
                    }
                }else if(buttonName.equals("windowSeat")){
                    if(windowRest != 0){
                        chooseSeat("Window",seatClass);
                    }else{
                        JOptionPane.showMessageDialog(null, "no seat left", "window", JOptionPane.ERROR_MESSAGE);
                    }
                }else if(buttonName.equals("aisleSeat")){
                    if(aisleRest != 0){
                        chooseSeat("Aisle",seatClass);
                    }else{
                        JOptionPane.showMessageDialog(null, "no seat left", "aisle", JOptionPane.ERROR_MESSAGE);
                    }
                }else if(buttonName.equals("extraSeat")){
                    if(extraRest != 0){
                        int choice = JOptionPane.showConfirmDialog(null, "You need to pay extra money for a seat with more space.", "Confirm",JOptionPane.YES_NO_OPTION);
                        if(choice == JOptionPane.YES_OPTION){
                            chooseSeat("Extra",seatClass);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "no seat left", "extra", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    private class mouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            int x = e.getXOnScreen();
            // JOptionPane.showMessageDialog(null, x, "extra", JOptionPane.INFORMATION_MESSAGE);
            if(x >= 285 && x <= 480){
                if(normalRest > 0){
                    normal.setBorder(UIManager.getBorder("Button.border"));
                }
            }else if(x >= 509 && x <= 704){
                if(windowRest > 0){
                    window.setBorder(UIManager.getBorder("Button.border"));
                }
            }else if(x >= 735 && x <= 929){
                if(aisleRest > 0){
                    aisle.setBorder(UIManager.getBorder("Button.border"));
                }
            }else if(x >= 959 && x <= 1154){
                if(extraRest > 0){
                    extra.setBorder(UIManager.getBorder("Button.border"));
                }
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            seat = (Seat)GlobalData.data.get("seat");
            if(normalRest > 0){
                if(seat != null && seat.type.getValue().equals("Normal") && seat.seatClass.getValue().equals(seatClass)){
                    normal.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    normal.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
            if(windowRest > 0){
                if(seat != null && seat.type.getValue().equals("Window") && seat.seatClass.getValue().equals(seatClass)){
                    window.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    window.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
            if(aisleRest > 0){
                if(seat != null && seat.type.getValue().equals("Aisle") && seat.seatClass.getValue().equals(seatClass)){
                    aisle.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    aisle.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
            if(extraRest > 0){
                if(seat != null && seat.type.getValue().equals("Extra") && seat.seatClass.getValue().equals(seatClass)){
                    extra.setBorder(new RoundBorder(new ColorUIResource(0,131,255)));   
                }else{
                    extra.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
        }

    }
    private void front(){
        // top panel
        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        f.add(top);
        top.setVisible(true);
    }
    private void bottom(){
        /**
         * back button
         * next button
         */
        JButton back = new JButton("back");
        JButton next = new JButton("next");
        back.setBounds(20,465,75,30);
        next.setBounds(855,465,75,30);
        next.setBackground(new Color(0, 131, 255));
        next.setBorder(new RoundBorder(new Color(0, 131, 255)));
        back.setBackground(Color.gray);
        back.setBorder(new RoundBorder(Color.gray));
        back.addActionListener(
            new ActionListener(){
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
        next.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(e.getSource()==next) {
                        seat = (Seat)GlobalData.data.get("seat");
                        if(seat != null){
                            seatMoney = (double)seat.price.getValue();
                            if(!changeSeatClass && seatClass.equals("First")){
                                seatMoney = ((double)seat.price.getValue()) - normalMoney;
                            }
                            seat.price.setValue(seatMoney);
                            GlobalData.data.put("seat", seat);
                            new ChooseFood();
                            try {
                                Pages.displayPage(path.resolve(Path.of("Choose Food")));
                            } catch (UnboundPageException e1) {
                                e1.printStackTrace();
                            }
                            return;
                        }else{
                            JOptionPane.showMessageDialog(null, "Please choose a seat before proceeding to the next page", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        });
        f.add(back);
        f.add(next);
    }
    private void buttonAction(){
        seatActionListener myListener = new seatActionListener();
        mouseListener myListener2 = new mouseListener();
        normal.addActionListener(myListener);
        normal.addMouseListener(myListener2);
        window.addActionListener(myListener);
        window.addMouseListener(myListener2);
        aisle.addActionListener(myListener);
        aisle.addMouseListener(myListener2);
        extra.addActionListener(myListener);
        extra.addMouseListener(myListener2);
    }
    //init data for this page
    private void getAllSeat(){
        
        Interval interval = flightinfo.interval.get(0);
        interval_id = interval.id;
        try {
            //info for normal seat of this ticket's seat class
            var normalSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Normal");
            }).filter((x)->{
                return x.seatClass.getValue().equals(seatClass);
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allNormalSeat = normalSeatStream.toArray();
            normalMoney = (Double)((Seat)allNormalSeat[0]).price.getValue();
            normalRest = allNormalSeat.length;
            //info for window seat of this ticket's seat class
            var windowSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Window");
            }).filter((x)->{
                return x.seatClass.getValue().equals(seatClass);
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allWindowSeat = windowSeatStream.toArray();
            windowMoney = (Double)((Seat)allWindowSeat[0]).price.getValue();
            windowRest = allWindowSeat.length;
            //info for aisle seat of this ticket's seat class
            var aisleSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Aisle");
            }).filter((x)->{
                return x.seatClass.getValue().equals(seatClass);
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allAisleSeat = aisleSeatStream.toArray();
            aisleMoney = (Double)((Seat)allAisleSeat[0]).price.getValue();
            aisleRest = allAisleSeat.length;
            //info for extra space seat of this ticket's seat class
            var extraSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Extra");
            }).filter((x)->{
                return x.seatClass.getValue().equals(seatClass);
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allExtraSeat = extraSeatStream.toArray();
            extraMoney = (Double)((Seat)allExtraSeat[0]).price.getValue();
            extraRest = allExtraSeat.length;

            //minus the seat stored in globalData
            if((Seat)GlobalData.data.get("seat") != null){
                Seat nowSeat = (Seat)GlobalData.data.get("seat");
                if(nowSeat.seatClass.getValue().equals(seatClass)){
                    if(nowSeat.type.getValue().equals("Normal")){
                        normalRest --;
                    }else if(nowSeat.type.getValue().equals("Window")){
                        windowRest --;
                    }else if(nowSeat.type.getValue().equals("Aisle")){
                        aisleRest --;
                    }else if(nowSeat.type.getValue().equals("Extra")){
                        extraRest --;
                    }
                }
            }
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Seat getChosenSeat(){
        //check if the customer has already chosen a seat
        try {
            var seatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).toArray();
            for(int i = 0; i < seatStream.length; i ++){
                if(((Seat)seatStream[i]).ticket.getValue() != null){
                    if(((Seat)seatStream[i]).ticket.getValue().equals(ticket.id)){
                        seat = (Seat)seatStream[i];
                        havePaid = true;
                        haveChosen = true;
                        break;
                    }
                }
            }
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
        }
        return seat;
    }
    //assign a seat after user click the button
    private void chooseSeat(String type, String seatClass){
        try {
            var seatStream2 = Seat.queryByProperty(Seat.class, "Interval_id", 1).filter((x)->{
                return x.type.getValue().equals(type);
            }).filter((x)->{
                return x.seatClass.getValue().equals(seatClass);
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var seatArray = seatStream2.toArray();
            if(seatArray.length != 0){
                seat = (Seat)seatArray[0];
                seat.seatClass.setValue(seatClass);
                seat.ticket.setValue(ticket.id);
                GlobalData.data.put("seat",seat);
                if(type.equals("Normal")){
                    normalRest --;
                }else if(type.equals("Window")){
                    windowRest --;
                }else if(type.equals("Aisle")){
                    aisleRest --;
                }else if(type.equals("Extra")){
                    extraRest --;
                }
                JOptionPane.showMessageDialog(null, "Select Successfully!\nYour seat number is "+seat.seatNo.getValue(), "Success", JOptionPane.PLAIN_MESSAGE);
                seat = (Seat)GlobalData.data.get("seat");
                if(seat != null){
                    seatMoney = (double)seat.price.getValue();
                    if(!changeSeatClass && seatClass.equals("First")){
                        seatMoney = ((double)seat.price.getValue()) - normalMoney;
                    }
                    seat.price.setValue(seatMoney);
                    GlobalData.data.put("seat", seat);
                    new ChooseFood();
                    try {
                        Pages.displayPage(path.resolve(Path.of("Choose Food")));
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                    return;
                }

                // f.setVisible(false);
                // ChooseSeat newFrame = new ChooseSeat(seatClass, changeSeatClass);
                // newFrame.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Sorry, there is no seat left.\nPlease choose again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    //popup to ask if users of economy class want to upgrade 
    private void upgrade(){
        int choice = JOptionPane.showConfirmDialog(null, "Choose Seat Would you like to upgrade?", "Upgrade",JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){ //upgrade
            GlobalData.data.put("seatClass","First");
            GlobalData.data.put("changeSeatClass", true);
            GlobalData.data.put("haveAskToUpgrade", true);
            new ChooseSeat();
        }else if(choice == JOptionPane.NO_OPTION){ //keep normal seat
            GlobalData.data.put("seatClass","Normal");
            GlobalData.data.put("changeSeatClass", false);
            GlobalData.data.put("haveAskToUpgrade", true);
            new ChooseSeat();
        }

    }

}
