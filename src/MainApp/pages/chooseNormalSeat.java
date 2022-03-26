package MainApp.pages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.Font;
import java.awt.*;

public class chooseNormalSeat {
    public chooseNormalSeat(){

        /*
            get the flightNo/InternalNo from globalData
        */

        JFrame f = new JFrame("Choose Seat");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setBounds(0,0,960,540);
        
        /*
            NORTH
        */
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,0));
        p1.setBorder(new EmptyBorder(10, 20, 0, 20));
        
        /*
            NORTH line 1
            "exit" button & flow chart & artificial service
        */

        JPanel p11 = new JPanel();
        p11.setLayout(new FlowLayout(0));
        /*
            "exit" button
        */
        JButton exit = new JButton();
        exit.setPreferredSize(new Dimension(40,40));
        exit.setContentAreaFilled(false);
        // exit.setBorderPainted(false);
        exit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setIcon exitIcon = new setIcon();
        exitIcon.changeIconSize("src/MainApp/pages/exit.png", exit, 40, 40);
        p11.add(exit);
        /*
            面包屑
        */
        JPanel chart = new JPanel();
        chart.setLayout(new FlowLayout(0));
        JLabel label = new JLabel("Check In > Choose Seat > Choose a meal plan > Confirm and Print > Have a Good Trip!");
        label.setPreferredSize(new Dimension(600,30));
        // label.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        chart.setBorder(new EmptyBorder(0, 30, 0, 0));
        chart.add(label);
        p11.add(chart);

        /*
            人工
        */
        JPanel service = new JPanel();
        service.setLayout(new FlowLayout(2));
        JButton serviceBtn = new JButton();
        serviceBtn.setPreferredSize(new Dimension(40,40));
        serviceBtn.setContentAreaFilled(false);
        // serviceBtn.setBorderPainted(false);
        serviceBtn.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setIcon serviceIcon = new setIcon();
        serviceIcon.changeIconSize("src/MainApp/pages/service.png", serviceBtn, 40, 40);
        service.setBorder(new EmptyBorder(0, 100, 0, 0));
        service.add(serviceBtn);
        p11.add(service);
        p1.add(p11);
        
        /*
            NORTH part 2
            title
        */
        JPanel p12 = new JPanel();
        p12.setLayout(new FlowLayout(0));
        p12.setBorder(new EmptyBorder(0, 10, 0, 0));
        JLabel title = new JLabel("Choose Seat ");
        title.setFont(new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 35)); 
        p12.add(title);
        p1.add(p12);

        /*
            NORTH part 3
            title
        */
        JPanel p13 = new JPanel();
        p13.setLayout(new FlowLayout(0));
        p13.setBorder(new EmptyBorder(0, 20, 0, 0));
        JLabel hint = new JLabel("Please choose a type of seat that you prefer, the system will assign a seat of that type for you.");
        hint.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15)); 
        p13.add(hint);
        p1.add(p13);


        /*
            CENTER
        */
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 4, 30, 0));
        p2.setBorder(new EmptyBorder(10, 50, 10, 50));

        /*
            button 1: normal seat
        */
        JPanel normal = new JPanel();
        normal.setLayout(new GridLayout(4, 0));
        normal.setBorder(BorderFactory.createLineBorder(new ColorUIResource(220,220,220), 1));
        JLabel normal_text1 = new JLabel("A Normal");
        normal_text1.setHorizontalAlignment(JLabel.CENTER); //水平居中
        normal_text1.setVerticalAlignment(JLabel.BOTTOM); //垂直置底
        JLabel normal_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel normal_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel normal_num2 = new JLabel("10");
        normal_num2.setHorizontalAlignment(JLabel.CENTER);
        normal_num2.setVerticalAlignment(JLabel.TOP); 
        normal_text1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        normal_text2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        normal_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        normal_num1.setForeground(new ColorUIResource(30,144,255));
        normal_num2.setForeground(new ColorUIResource(30,144,255));
        normal.add(normal_text1);
        normal.add(normal_text2);
        normal.add(normal_num1);
        normal.add(normal_num2);

        /*
            button 2: window seat
        */
        JPanel window = new JPanel();
        window.setLayout(new GridLayout(4, 0));
        window.setBorder(BorderFactory.createLineBorder(new ColorUIResource(220,220,220), 1));
        JLabel window_text1 = new JLabel("A Window");
        window_text1.setHorizontalAlignment(JLabel.CENTER); //水平居中
        window_text1.setVerticalAlignment(JLabel.BOTTOM); //垂直置底
        JLabel window_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel window_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel window_num2 = new JLabel("5");
        window_num2.setHorizontalAlignment(JLabel.CENTER);
        window_num2.setVerticalAlignment(JLabel.TOP); 
        window_text1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        window_text2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        window_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        window_num1.setForeground(new ColorUIResource(30,144,255));
        window_num2.setForeground(new ColorUIResource(30,144,255));
        window.add(window_text1);
        window.add(window_text2);
        window.add(window_num1);
        window.add(window_num2);

        /*
            button 3: aside seat
        */
        JPanel aside = new JPanel();
        aside.setLayout(new GridLayout(4, 0));
        aside.setBorder(BorderFactory.createLineBorder(new ColorUIResource(220,220,220), 1));
        JLabel aside_text1 = new JLabel("An Aside");
        aside_text1.setHorizontalAlignment(JLabel.CENTER); //水平居中
        aside_text1.setVerticalAlignment(JLabel.BOTTOM); //垂直置底
        JLabel aside_text2 = new JLabel("Seat", JLabel.CENTER);
        JLabel aside_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel aside_num2 = new JLabel("5");
        aside_num2.setHorizontalAlignment(JLabel.CENTER);
        aside_num2.setVerticalAlignment(JLabel.TOP); 
        aside_text1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        aside_text2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        aside_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aside_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        aside_num1.setForeground(new ColorUIResource(30,144,255));
        aside_num2.setForeground(new ColorUIResource(30,144,255));
        aside.add(aside_text1);
        aside.add(aside_text2);
        aside.add(aside_num1);
        aside.add(aside_num2);

        /*
            button 4: extra space seat
        */
        JPanel extra = new JPanel();
        extra.setLayout(new GridLayout(4, 0));
        extra.setBorder(BorderFactory.createLineBorder(new ColorUIResource(220,220,220), 1));
        JLabel extra_text1 = new JLabel("A Seat with");
        extra_text1.setHorizontalAlignment(JLabel.CENTER); //水平居中
        extra_text1.setVerticalAlignment(JLabel.BOTTOM); //垂直置底
        JLabel extra_text2 = new JLabel("Extra Space", JLabel.CENTER);
        JLabel extra_num1 = new JLabel("Remaining", JLabel.CENTER);
        JLabel extra_num2 = new JLabel("8");
        extra_num2.setHorizontalAlignment(JLabel.CENTER);
        extra_num2.setVerticalAlignment(JLabel.TOP); 
        extra_text1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        extra_text2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
        extra_num1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
        extra_num1.setForeground(new ColorUIResource(30,144,255));
        extra_num2.setForeground(new ColorUIResource(30,144,255));
        extra.add(extra_text1);
        extra.add(extra_text2);
        extra.add(extra_num1);
        extra.add(extra_num2);

        p2.add(normal);
        p2.add(window);
        p2.add(aside);
        p2.add(extra);


        /*
            SOUTH
        */
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(0,2));
        p3.setBorder(new EmptyBorder(10, 20, 10, 20));
        // p3.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        /*
            "back" button
        */
        JPanel p31 = new JPanel();
        p31.setLayout(new FlowLayout(0));
        JButton back = new JButton("back");
        p31.add(back);
        /*
            "Next" button
        */
        JPanel p32 = new JPanel();
        p32.setLayout(new FlowLayout(2));
        JButton next = new JButton("next");
        p32.add(next);
        p3.add(p31);
        p3.add(p32);


        f.add(BorderLayout.NORTH, p1);
        f.add(BorderLayout.CENTER, p2);
        f.add(BorderLayout.SOUTH, p3);
        f.setLocationRelativeTo(null); //窗口显示在屏幕中央
        f.setVisible(true);
    }

    public static void main(String[] args) {
        chooseNormalSeat seat = new chooseNormalSeat();
    }
}
