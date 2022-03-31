package MainApp.pages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.util.stream.Stream;
import java.awt.Font;
import java.awt.*;
import MainApp.models.Field.ForeignKey;
import MainApp.models.Model.UserModel.Interval;
import MainApp.models.Model.UserModel.Seat;
import MainApp.pages.components.RoundBorder;

public class chooseNormalSeat {
    public int width = 960;
    public int height = 540;
    private int normalRest = 10;
    private int windowRest = 8;
    private int asideRest = 0;
    private int extraRest = 3;

    JFrame f = new JFrame("Choose Seat");
    private JButton normal = normalSeat(f);
    private JButton window = windowSeat(f);
    private JButton aside = asideSeat(f);
    private JButton extra = extraSeat(f);
    
    Stream<Seat> seat;

    public chooseNormalSeat(){
        // seat = ForeignKey.getReferring(Seat.class, "Interval_id", 1);
        myFrame();
        front(); //exit + mian bao xie + question service
        title_hint(); //title + hint
        bottom(); // back + next button
        buttonAction(); //4 buttons action 
        f.setLocationRelativeTo(null); //窗口显示在屏幕中央
        f.setVisible(true);
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
        normal.setBorder(new RoundBorder(Color.GRAY));   
        JLabel normal_text1 = new JLabel("A Normal", JLabel.CENTER);
        JLabel normal_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel normal_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel normal_num2 = new JLabel(normalRest+"", JLabel.CENTER);
        normal_text1.setFont(new Font("Arial", Font.BOLD, 33));
        normal_text2.setFont(new Font("Arial", Font.BOLD, 33));
        normal_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(normalRest > 0){
            normal_num1.setForeground(new ColorUIResource(30,144,255));
            normal_num2.setForeground(new ColorUIResource(30,144,255)); 
        }else{
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
        window.setBorder(new RoundBorder(Color.GRAY));   
        JLabel window_text1 = new JLabel("A Window", JLabel.CENTER);
        JLabel window_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel window_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel window_num2 = new JLabel(windowRest+"", JLabel.CENTER);
        window_text1.setFont(new Font("Arial", Font.BOLD, 33));
        window_text2.setFont(new Font("Arial", Font.BOLD, 33));
        window_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(windowRest > 0){
            window_num1.setForeground(new ColorUIResource(30,144,255));
            window_num2.setForeground(new ColorUIResource(30,144,255));
        }else{
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
    private JButton asideSeat(JFrame f){
        JButton aside = new JButton();
        aside.setActionCommand("asideSeat");
        aside.setContentAreaFilled(false);
        aside.setBorder(new RoundBorder(Color.GRAY));   
        JLabel aside_text1 = new JLabel("An Aside", JLabel.CENTER);
        JLabel aside_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel aside_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel aside_num2 = new JLabel(asideRest+"", JLabel.CENTER);
        aside_text1.setFont(new Font("Arial", Font.BOLD, 33));
        aside_text2.setFont(new Font("Arial", Font.BOLD, 33));
        aside_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aside_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(asideRest > 0){
            aside_num1.setForeground(new ColorUIResource(30,144,255));
            aside_num2.setForeground(new ColorUIResource(30,144,255));
        }else{
            aside_text1.setForeground(Color.GRAY);
            aside_text2.setForeground(Color.GRAY);
            aside_num1.setForeground(Color.GRAY);
            aside_num2.setForeground(Color.GRAY);
        }
        aside.setBounds(490,175,195,268);
        aside_text1.setBounds(513,224,150,42);
        aside_text2.setBounds(513,266,150,42);
        aside_num1.setBounds(540,341,94,24);
        aside_num2.setBounds(540,365,94,24);
        f.add(aside);
        f.add(aside_text1);
        f.add(aside_text2);
        f.add(aside_num1);
        f.add(aside_num2);
        return aside;
    }
    private JButton extraSeat(JFrame f){
        JButton extra = new JButton();
        extra.setActionCommand("extraSeat");
        extra.setContentAreaFilled(false);
        extra.setBorder(new RoundBorder(Color.GRAY));   
        JLabel extra_text1 = new JLabel("A Seat with", JLabel.CENTER);
        JLabel extra_text2 = new JLabel("Extra Space", JLabel.CENTER);
        JLabel extra_money = new JLabel("$10", JLabel.CENTER);
        JLabel extra_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel extra_num2 = new JLabel(extraRest+"", JLabel.CENTER);
        extra_text1.setFont(new Font("Arial", Font.BOLD, 32));
        extra_text2.setFont(new Font("Arial", Font.BOLD, 32));
        extra_money.setFont(new Font("Arial", Font.PLAIN, 20));
        extra_money.setForeground(new ColorUIResource(Color.red));
        extra_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        if(extraRest > 0){
            extra_num1.setForeground(new ColorUIResource(30,144,255));
            extra_num2.setForeground(new ColorUIResource(30,144,255));
        }else{
            extra_text1.setForeground(Color.GRAY);
            extra_text2.setForeground(Color.GRAY);
            extra_money.setForeground(Color.GRAY);
            extra_num1.setForeground(Color.GRAY);
            extra_num2.setForeground(Color.GRAY);
        }
        extra.setBounds(715,175,195,268);
        extra_text1.setBounds(719,224,186,42);
        extra_text2.setBounds(719,266,186,42);
        extra_money.setBounds(798,299,34,42);
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
                    JOptionPane.showMessageDialog(null, "分配一个normal seat", "normal", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "当前类型已无座位", "normal", JOptionPane.ERROR_MESSAGE);
                }
            }else if(buttonName.equals("windowSeat")){
                if(windowRest != 0){
                    JOptionPane.showMessageDialog(null, "分配一个window seat", "window", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "当前类型已无座位", "window", JOptionPane.ERROR_MESSAGE);
                }
            }else if(buttonName.equals("asideSeat")){
                if(asideRest != 0){
                    JOptionPane.showMessageDialog(null, "分配一个aside seat", "aside", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "当前类型已无座位", "aside", JOptionPane.ERROR_MESSAGE);
                }
            }else if(buttonName.equals("extraSeat")){
                if(extraRest != 0){
                    JOptionPane.showMessageDialog(null, "分配一个extra seat", "extra", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "当前类型已无座位", "extra", JOptionPane.ERROR_MESSAGE);
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
                if(asideRest > 0){
                    aside.setBorder(UIManager.getBorder("Button.border"));
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
                normal.setBorder(new RoundBorder(Color.GRAY)); 
            }
            if(windowRest > 0){
                window.setBorder(new RoundBorder(Color.GRAY)); 
            }
            if(asideRest > 0){
                aside.setBorder(new RoundBorder(Color.GRAY)); 
            }
            if(extraRest > 0){
                extra.setBorder(new RoundBorder(Color.GRAY));
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
            面包屑
        */
        // JLabel chart = new JLabel("Check In>Choose Seat>Choose a meal plan>Confirm and Print>Have a Good Trip!");
        // chart.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        JLabel label1 = new JLabel("Check In > ");
        JLabel label2 = new JLabel("Choose Seat > ");
        JLabel label3 = new JLabel("Choose Food > ");
        JLabel label4 = new JLabel("Confirm and Print");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        // chart.setOpaque(false);
        /*
            人工服务
        */
        JButton service = new JButton();
        service.setContentAreaFilled(false);
        service.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setIcon serviceIcon = new setIcon();
        serviceIcon.changeIconSize("src/MainApp/pages/image/question.png", service, 40, 40);
        // service.setOpaque(false)

        exit.setBounds(35,20,40,40);
        label1.setBounds(115,30,85,17);
        label2.setBounds(200,30,117,17);
        label3.setBounds(315,30,193,17);
        label4.setBounds(435,30,258,17);
        service.setBounds(875, 20, 40, 40);
        f.add(exit);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(service);
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
        aside.addActionListener(myListener);
        aside.addMouseListener(myListener2);
        extra.addActionListener(myListener);
        extra.addMouseListener(myListener2);
    }
    // private  laodSeat(){

    // }
    public static void main(String[] args) {
        chooseNormalSeat seat = new chooseNormalSeat();
    }
}
