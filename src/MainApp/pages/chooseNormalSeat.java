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
import MainApp.pages.components.BreadCrumbPanel;
import MainApp.pages.Exception.UnboundPageException;
import MainApp.pages.components.RoundBorder;
import MainApp.pages.control.FlightInfo;
import java.nio.file.Path;


public class chooseNormalSeat extends JFrame{
    public int width = 965;
    public int height = 550;
    private boolean haveChosen = false;
    private int normalRest = 0;
    private int windowRest = 0;
    private int aisleRest = 0;
    private int extraRest = 0;
    private double extraMoney = 0.0;
    private Ticket ticket;
    private Seat seat;
    private int interval_id = 1;
    private FlightInfo flightinfo = (FlightInfo)GlobalData.data.get("flight");
    JFrame f = this;
    {
        ticket = flightinfo.ticket;
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
    private Path path = Path.of("page1/page2/page3");
    public chooseNormalSeat(){
        super("Choose seat");
        Pages.bindPage(this.path, this);
        myFrame();
        front(); //exit + mian bao xie + question service
        title_hint(); //title + hint
        bottom(); // back + next button
        buttonAction(); //4 buttons action 
        f.setLocationRelativeTo(null); 
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
        JLabel title = new JLabel("Choose Seat ");
        title.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));         
        /**
         * hint
         */
        JLabel hint = new JLabel("Please choose a type of seat that you prefer, and the system will assign a seat for you.");
        hint.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15)); 

        title.setBounds(40,80,230,49);
        hint.setBounds(40,112,650,70);
        f.add(title);
        f.add(hint);
    }
    private JButton normalSeat(JFrame f){
        JButton normal = new JButton();
        normal.setActionCommand("normalSeat");;
        normal.setContentAreaFilled(false);
        JLabel normal_text1 = new JLabel("A Normal", JLabel.CENTER);
        JLabel normal_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel normal_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel normal_num2 = new JLabel(normalRest+"", JLabel.CENTER);
        normal_text1.setFont(new Font("Arial", Font.BOLD, 33));
        normal_text2.setFont(new Font("Arial", Font.BOLD, 33));
        normal_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen){
            if(seat.type.getValue().equals("Normal")){
                normal.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
            }else{
                normal.setBorder(new RoundBorder(Color.GRAY));   
            }
        }else{
            normal.setBorder(new RoundBorder(Color.GRAY));   
        }
        if(normalRest > 0){
            normal_num1.setForeground(new ColorUIResource(30,144,255));
            normal_num2.setForeground(new ColorUIResource(30,144,255)); 
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Normal")){
                    normal.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    normal.setBorder(new RoundBorder(Color.GRAY));   
                }
            }else{
                normal.setBorder(new RoundBorder(Color.GRAY));   
            }
            normal_text1.setForeground(Color.GRAY);
            normal_text2.setForeground(Color.GRAY);
            normal_num1.setForeground(Color.GRAY);
            normal_num2.setForeground(Color.GRAY);
        }
        normal.setBounds(40,175,195,268);
        normal_text1.setBounds(61,224,152,42);
        normal_text2.setBounds(61,266,152,42);
        normal_num1.setBounds(90,341,94,24);
        normal_num2.setBounds(90,365,94,24);
        
        f.add(normal);
        f.add(normal_text1);
        f.add(normal_text2);
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
        JLabel window_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel window_num2 = new JLabel(windowRest+"", JLabel.CENTER);
        window_text1.setFont(new Font("Arial", Font.BOLD, 33));
        window_text2.setFont(new Font("Arial", Font.BOLD, 33));
        window_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen){
            if(seat.type.getValue().equals("Window")){
                window.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
            }else{
                window.setBorder(new RoundBorder(Color.GRAY));  
            }
        }else{
            window.setBorder(new RoundBorder(Color.GRAY));  
        }
        if(windowRest > 0){
            window_num1.setForeground(new ColorUIResource(30,144,255));
            window_num2.setForeground(new ColorUIResource(30,144,255));
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Window")){
                    window.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    window.setBorder(new RoundBorder(Color.GRAY));  
                }
            }else{
                window.setBorder(new RoundBorder(Color.GRAY));  
            }
            window_text1.setForeground(Color.GRAY);
            window_text2.setForeground(Color.GRAY);
            window_num1.setForeground(Color.GRAY);
            window_num2.setForeground(Color.GRAY);
        }
        window.setBounds(265,175,195,268);
        window_text1.setBounds(280,224,165,42);
        window_text2.setBounds(280,266,165,42);
        window_num1.setBounds(315,341,94,24);
        window_num2.setBounds(315,365,94,24);
        f.add(window);
        f.add(window_text1);
        f.add(window_text2);
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
        JLabel aisle_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel aisle_num2 = new JLabel(aisleRest+"", JLabel.CENTER);
        aisle_text1.setFont(new Font("Arial", Font.BOLD, 33));
        aisle_text2.setFont(new Font("Arial", Font.BOLD, 33));
        aisle_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aisle_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen){
            if(seat.type.getValue().equals("Aisle")){
                aisle.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
            }else{
                aisle.setBorder(new RoundBorder(Color.GRAY));  
            }
        }else{
            aisle.setBorder(new RoundBorder(Color.GRAY));  
        }        
        if(aisleRest > 0){
            aisle_num1.setForeground(new ColorUIResource(30,144,255));
            aisle_num2.setForeground(new ColorUIResource(30,144,255));
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Aisle")){
                    aisle.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    aisle.setBorder(new RoundBorder(Color.GRAY));  
                }
            }else{
                aisle.setBorder(new RoundBorder(Color.GRAY));  
            } 
            aisle_text1.setForeground(Color.GRAY);
            aisle_text2.setForeground(Color.GRAY);
            aisle_num1.setForeground(Color.GRAY);
            aisle_num2.setForeground(Color.GRAY);
        }
        aisle.setBounds(490,175,195,268);
        aisle_text1.setBounds(513,224,150,42);
        aisle_text2.setBounds(513,266,150,42);
        aisle_num1.setBounds(540,341,94,24);
        aisle_num2.setBounds(540,365,94,24);
        f.add(aisle);
        f.add(aisle_text1);
        f.add(aisle_text2);
        f.add(aisle_num1);
        f.add(aisle_num2);
        return aisle;
    }
    private JButton extraSeat(JFrame f){
        JButton extra = new JButton();
        extra.setActionCommand("extraSeat");
        extra.setContentAreaFilled(false);  
        JLabel extra_text1 = new JLabel("A Seat with", JLabel.CENTER);
        JLabel extra_text2 = new JLabel("Extra Space", JLabel.CENTER);
        JLabel extra_money = new JLabel("$"+extraMoney, JLabel.CENTER);
        JLabel extra_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel extra_num2 = new JLabel(extraRest+"", JLabel.CENTER);
        extra_text1.setFont(new Font("Arial", Font.BOLD, 32));
        extra_text2.setFont(new Font("Arial", Font.BOLD, 32));
        extra_money.setFont(new Font("Arial", Font.PLAIN, 17));
        extra_money.setForeground(new ColorUIResource(Color.red));
        extra_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(haveChosen){
            if(seat.type.getValue().equals("Extra")){
                extra.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
            }else{
                extra.setBorder(new RoundBorder(Color.GRAY));  
            }
        }else{
            extra.setBorder(new RoundBorder(Color.GRAY));   
        }        
        if(extraRest > 0){
            extra_num1.setForeground(new ColorUIResource(30,144,255));
            extra_num2.setForeground(new ColorUIResource(30,144,255));
        }else{
            if(haveChosen){
                if(seat.type.getValue().equals("Extra")){
                    extra.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
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
            if(buttonName.equals("normalSeat")){
                if(normalRest != 0){
                    int choice = JOptionPane.showConfirmDialog(null, "Choose a normal seat?", "Confirm",JOptionPane.YES_NO_OPTION);
                    if(choice == 0){
                        chooseSeat("Normal","Normal");
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "no normal seat left", "normal", JOptionPane.ERROR_MESSAGE);
                }
            }else if(buttonName.equals("windowSeat")){
                if(windowRest != 0){
                    int choice = JOptionPane.showConfirmDialog(null, "Choose a window seat?", "Confirm",JOptionPane.YES_NO_OPTION);
                    if(choice == 0){
                        chooseSeat("Window","Normal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "no seat left", "window", JOptionPane.ERROR_MESSAGE);
                }
            }else if(buttonName.equals("aisleSeat")){
                if(aisleRest != 0){
                    int choice = JOptionPane.showConfirmDialog(null, "Choose an aisle seat?", "Confirm",JOptionPane.YES_NO_OPTION);
                    if(choice == 0){
                        chooseSeat("Aisle","Normal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "no seat left", "aisle", JOptionPane.ERROR_MESSAGE);
                }
            }else if(buttonName.equals("extraSeat")){
                if(extraRest != 0){
                    int choice = JOptionPane.showConfirmDialog(null, "Choose a seat with extra space?\nYou need to pay extra money for it.", "Confirm",JOptionPane.YES_NO_OPTION);
                    if(choice == 0){
                        chooseSeat("Extra","Normal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "no seat left", "extra", JOptionPane.ERROR_MESSAGE);
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
            if(normalRest > 0){
                if(seat != null && seat.type.getValue().equals("Normal")){
                    normal.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    normal.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
            if(windowRest > 0){
                if(seat != null && seat.type.getValue().equals("Window")){
                    window.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    window.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
            if(aisleRest > 0){
                if(seat != null && seat.type.getValue().equals("Aisle")){
                    aisle.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    aisle.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
            if(extraRest > 0){
                if(seat != null && seat.type.getValue().equals("Extra")){
                    extra.setBorder(new RoundBorder(new ColorUIResource(30,144,255)));   
                }else{
                    extra.setBorder(new RoundBorder(Color.GRAY));   
                }
            }
        }

    }
    private void front(){
        /**
         * "exit" button
         */
        JButton exit = new JButton();
        exit.setContentAreaFilled(false);
        exit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setIcon exitIcon = new setIcon();
        exitIcon.changeIconSize("src/MainApp/pages/image/exit.png", exit, 40, 40);
        // exit.setOpaque(false);
        /*
            flow chart
        */
        // JLabel chart = new JLabel("Check In>Choose Seat>Choose a meal plan>Confirm and Print>Have a Good Trip!");
        // chart.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        JPanel flowChart = new JPanel();
        flowChart.setLayout(null);
        flowChart.setBounds(100, 25,765,25);
        flowChart.setBackground(Color.WHITE);

        JLabel retrieve = new JLabel("Retrieve>");
        retrieve.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        retrieve.setBounds(0,0,70,35);
        flowChart.add(retrieve);

        JLabel fInfo = new JLabel("Flight Information>");
        fInfo.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        fInfo.setBounds(70,0,160,35);
        flowChart.add(fInfo);

        JLabel chooseSeat = new JLabel("Choose Seat>");
        chooseSeat.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        chooseSeat.setBounds(230,0,110,35);
        flowChart.add(chooseSeat);

        JLabel chooseFood = new JLabel("Choose Food>");
        chooseFood.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        chooseFood.setBounds(340,0,115,35);
        flowChart.add(chooseFood);

        JLabel extraFood = new JLabel("Extra Food>");
        extraFood.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        extraFood.setBounds(455,0,100,35);
        flowChart.add(extraFood);

        JLabel confirmPay = new JLabel("Confirm and Pay>");
        confirmPay.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        confirmPay.setBounds(555,0,140,35);
        flowChart.add(confirmPay);

        JLabel checkin = new JLabel("Check in");
        checkin.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        checkin.setBounds(695,0,80,35);
        flowChart.add(checkin);

        // chart.setOpaque(false);
        /*
            artificial service
        */
        JButton service = new JButton();
        service.setContentAreaFilled(false);
        service.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setIcon serviceIcon = new setIcon();
        serviceIcon.changeIconSize("src/MainApp/pages/image/question.png", service, 40, 40);
        // service.setOpaque(false)

        exit.setBounds(35,20,40,40);
        service.setBounds(875, 20, 40, 40);
        f.add(exit);
        f.add(service);
        f.add(flowChart);
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
        next.setBackground(new Color(30, 144, 255));
        next.setBorder(new RoundBorder(new Color(30, 144, 255)));
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
                        if(seat != null){
                            setGlobalData();
                            new FoodFrame();
                            try {
                                Pages.displayPage(path.resolve(Path.of("page4")));
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
            var normalSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Normal");
            }).filter((x)->{
                return x.seatClass.getValue().equals("Normal");
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allNormalSeat = normalSeatStream.toArray();
            normalRest = allNormalSeat.length;
            var windowSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Window");
            }).filter((x)->{
                return x.seatClass.getValue().equals("Normal");
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allWindowSeat = windowSeatStream.toArray();
            windowRest = allWindowSeat.length;
            var aisleSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Aisle");
            }).filter((x)->{
                return x.seatClass.getValue().equals("Normal");
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allAisleSeat = aisleSeatStream.toArray();
            aisleRest = allAisleSeat.length;
            var extraSeatStream = Seat.queryByProperty(Seat.class, "Interval_id", interval_id).filter((x)->{
                return x.type.getValue().equals("Extra");
            }).filter((x)->{
                return x.seatClass.getValue().equals("Normal");
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var allExtraSeat = extraSeatStream.toArray();
            extraMoney = (Double)((Seat)allExtraSeat[0]).price.getValue();
            extraRest = allExtraSeat.length;

            //minus the seat stored in globalData
            if((Seat)GlobalData.data.get("seat") != null){
                Seat nowSeat = (Seat)GlobalData.data.get("seat");
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
        System.out.println(type);
        System.out.println(seatClass);
        try {
            var seatStream2 = Seat.queryByProperty(Seat.class, "Interval_id", 1).filter((x)->{
                return x.type.getValue().equals(type);
            }).filter((x)->{
                return x.seatClass.getValue().equals(seatClass);
            }).filter((x)->{
                return x.ticket.getValue() == null;
            });
            var pastSeatArray = seatStream2.toArray();
            if(pastSeatArray.length != 0){
                //if(!haveChosen){
                //user hasn't choose a seat, assign one for him
                seat = (Seat)pastSeatArray[0];
                seat.ticket.setValue(ticket.id);
                setGlobalData();
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
                f.setVisible(false);
                chooseNormalSeat newFrame = new chooseNormalSeat();
                newFrame.setVisible(true);
                //}
                // else{
                //     //user has already choose one, ask him, if he want to change, change one
                //     int choice = JOptionPane.showConfirmDialog(null, "You have already chosen a seat.\nWould you like to change one?", "Confirm",JOptionPane.YES_NO_OPTION);
                //     if(choice == 0){
                //         //edit the seat already chosen and assign a new seat
                //         Seat pastSeat = getChosenSeat();
                //         pastSeat.ticket.setValue(null);//将原来的座位的ticketId设成空
                //         pastSeat.save();
                //         var aSeat = (Seat)pastSeatArray[0];
                //         aSeat.ticket.setValue(ticket.id);
                //         aSeat.save();
                //         JOptionPane.showMessageDialog(null, "Select Successfully\nYour seat number is"+aSeat.seatNo, "Success", JOptionPane.PLAIN_MESSAGE);
                //         f.setVisible(false);
                //         chooseNormalSeat newFrame = new chooseNormalSeat();
                //         newFrame.setVisible(true);
                //     }
                // }
                
            }else{
                JOptionPane.showMessageDialog(null, "Sorry, there is no seat left.\nPlease choose again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FieldNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    private void setGlobalData(){
        // var seatStream = Seat.queryByProperty(Seat.class, "Ticket_id", ticket.id).toArray();
        // var seat = seatStream[0];
        System.out.println(seat.type.getValue());
        GlobalData.data.put("seat",seat);
    }
    public static void main(String[] args) {
        GlobalData.init(args);
        Models.init();
        chooseNormalSeat seat = new chooseNormalSeat();
        seat.setVisible(true);
    }
}
