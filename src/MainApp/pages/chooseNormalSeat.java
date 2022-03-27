package MainApp.pages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.Font;
import java.awt.*;

public class chooseNormalSeat {
    public int width = 960;
    public int height = 540;

    public chooseNormalSeat(){
        /**
         * get the flightNo/InternalNo from globalData
         */
        JFrame f = new JFrame("Choose Seat");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0,0,width,height);

        // ImageIcon background=new ImageIcon("welcome.png");
        // JLabel label=new JLabel(background);
        // label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        // //获取窗口的第二层，将label放入
        // f.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        // //获取frame的顶层容器,并设置为透明
		// JPanel j=(JPanel)f.getContentPane();
		// j.setOpaque(false);


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
        JLabel chart = new JLabel("Check In>Choose Seat>Choose a meal plan>Confirm and Print>Have a Good Trip!");
        chart.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        // chart.setOpaque(false);
        /*
            人工服务
        */
        JButton service = new JButton();
        service.setContentAreaFilled(false);
        service.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setIcon serviceIcon = new setIcon();
        serviceIcon.changeIconSize("src/MainApp/pages/image/question.png", service, 40, 40);
        // service.setOpaque(false);

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

        /**
         * seat button
         */
        JButton normal = new JButton();
        normal.setContentAreaFilled(false);
        JLabel normal_text1 = new JLabel("A Normal", JLabel.CENTER);
        JLabel normal_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel normal_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel normal_num2 = new JLabel("10", JLabel.CENTER);
        normal_text1.setFont(new Font("Arial", Font.BOLD, 33));
        normal_text2.setFont(new Font("Arial", Font.BOLD, 33));
        normal_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num1.setForeground(new ColorUIResource(30,144,255));
        normal_num2.setForeground(new ColorUIResource(30,144,255));


        JButton window = new JButton();
        window.setContentAreaFilled(false);
        JLabel window_text1 = new JLabel("A Window", JLabel.CENTER);
        JLabel window_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel window_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel window_num2 = new JLabel("5", JLabel.CENTER);
        window_text1.setFont(new Font("Arial", Font.BOLD, 33));
        window_text2.setFont(new Font("Arial", Font.BOLD, 33));
        window_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num1.setForeground(new ColorUIResource(30,144,255));
        window_num2.setForeground(new ColorUIResource(30,144,255));

        JButton aside = new JButton();
        aside.setContentAreaFilled(false);
        JLabel aside_text1 = new JLabel("An Aside", JLabel.CENTER);
        JLabel aside_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel aside_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel aside_num2 = new JLabel("5", JLabel.CENTER);
        aside_text1.setFont(new Font("Arial", Font.BOLD, 33));
        aside_text2.setFont(new Font("Arial", Font.BOLD, 33));
        aside_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aside_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aside_num1.setForeground(new ColorUIResource(30,144,255));
        aside_num2.setForeground(new ColorUIResource(30,144,255));

        JButton extra = new JButton();
        extra.setContentAreaFilled(false);
        JLabel extra_text1 = new JLabel("A Seat with", JLabel.CENTER);
        JLabel extra_text2 = new JLabel("Extra Space", JLabel.CENTER);
        JLabel extra_money = new JLabel("$10", JLabel.CENTER);
        JLabel extra_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel extra_num2 = new JLabel("8", JLabel.CENTER);
        extra_text1.setFont(new Font("Arial", Font.BOLD, 32));
        extra_text2.setFont(new Font("Arial", Font.BOLD, 32));
        extra_money.setFont(new Font("Arial", Font.PLAIN, 20));
        extra_money.setForeground(new ColorUIResource(Color.red));
        extra_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num1.setForeground(new ColorUIResource(30,144,255));
        extra_num2.setForeground(new ColorUIResource(30,144,255));



        /**
         * back button
         * next button
         */
        JButton back = new JButton("back");
        JButton next = new JButton("next");

        exit.setBounds(40,40,40,40);
        chart.setBounds(120,51,420,17);
        service.setBounds(880, 40, 40, 40);
        title.setBounds(45,105,230,49);
        hint.setBounds(45,137,650,70);
        normal.setBounds(45,200,195,268);
        normal_text1.setBounds(66,249,152,42);
        normal_text2.setBounds(66,291,152,42);
        normal_num1.setBounds(95,366,94,24);
        normal_num2.setBounds(95,390,94,24);
        window.setBounds(270,200,195,268);
        window_text1.setBounds(285,249,165,42);
        window_text2.setBounds(285,291,165,42);
        window_num1.setBounds(320,366,94,24);
        window_num2.setBounds(320,390,94,24);
        aside.setBounds(495,200,195,268);
        aside_text1.setBounds(518,249,150,42);
        aside_text2.setBounds(518,291,150,42);
        aside_num1.setBounds(545,366,94,24);
        aside_num2.setBounds(545,390,94,24);
        extra.setBounds(720,200,195,268);
        extra_text1.setBounds(724,249,186,42);
        extra_text2.setBounds(724,291,186,42);
        extra_money.setBounds(803,324,34,42);
        extra_num1.setBounds(770,366,94,24);
        extra_num2.setBounds(770,390,94,24);



        back.setBounds(25,490,75,30);
        next.setBounds(860,490,75,30);

        f.add(exit);
        f.add(chart);
        f.add(service);
        f.add(title);
        f.add(hint);
        f.add(normal);
        f.add(normal_text1);
        f.add(normal_text2);
        f.add(normal_num1);
        f.add(normal_num2);
        f.add(window);
        f.add(window_text1);
        f.add(window_text2);
        f.add(window_num1);
        f.add(window_num2);
        f.add(aside);
        f.add(aside_text1);
        f.add(aside_text2);
        f.add(aside_num1);
        f.add(aside_num2);
        f.add(extra);
        f.add(extra_text1);
        f.add(extra_text2);
        f.add(extra_money);
        f.add(extra_num1);
        f.add(extra_num2);
        f.add(back);
        f.add(next); 

        f.setLocationRelativeTo(null); //窗口显示在屏幕中央
        f.setVisible(true);
    }
    public static void main(String[] args) {
        chooseNormalSeat seat = new chooseNormalSeat();
    }
}
