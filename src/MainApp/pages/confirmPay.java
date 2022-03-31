package MainApp.pages;
import java.awt.Color;
import java.awt.*;

import MainApp.pages.components.DemoScrollBarUI;
import MainApp.pages.components.RoundBorder;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
public class confirmPay extends JFrame{
    private JPanel contentPane;
    JLayeredPane pane = new JLayeredPane();
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
        public void run(){
            try{
                confirmPay frame = new confirmPay();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public confirmPay(){
    
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        pane = new JLayeredPane();

        JLabel label1 = new JLabel("Please check your information and pay the bill:");
        label1.setFont(new Font("Microsoft YaHei", Font.PLAIN,15));
        label1.setBounds(45,120,378,70);
        add(label1);
       

        JLabel label2 = new JLabel("Confirm and Pay");
        label2.setFont(new Font("Microsoft YaHei", Font.BOLD,35));
        label2.setBounds(45,90,323,49);
        add(label2);

    
        
        ImageIcon m =new ImageIcon("src/MainApp/pages/image/seat.png");
        m.setImage(m.getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        panel1.setBorder(new RoundBorder(Color.gray));
        panel1.setBounds(45,170,375,85);
        panel1.setBackground(Color.white);
        String mo="$10";
        JLabel label11 = new JLabel(mo);
        label11.setForeground(Color.red);
        label11.setBounds(278,30,75,25);
        label11.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel1.add(label11);
        String co="extra space";
        JLabel label12 = new JLabel(co);
        label12.setBounds(110,22,156,42);
        label12.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel1.add(label12);
        JLabel label13 = new JLabel(m);
        label13.setBounds(18,13,60,60);
        panel1.add(label13);
        add(panel1);

        ImageIcon m2 =new ImageIcon("src/MainApp/pages/image/seat.png");
        m2.setImage(m2.getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panel2 = new JPanel(null);
        panel2.setBackground(Color.white);
        panel2.setBorder(new RoundBorder(Color.gray));
        panel2.setBounds(45,260,375,85);
        String mo2="$20";
        JLabel label21 = new JLabel(mo2);
        label21.setForeground(Color.red);
        label21.setBounds(278,30,75,25);
        label21.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel2.add(label21);
        String co2="Food choice";
        JLabel label22 = new JLabel(co2);
        label22.setBounds(110,18,156,21);
        label22.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel2.add(label22);
        JLabel label23 = new JLabel(m2);
        label23.setBounds(20,18,50,50);
        panel2.add(label23);
        JButton btnf = new JButton("Click here to view the details");
        panel2.add(btnf);
        btnf.setBounds(80,44,186,28);
        btnf.setFont(new Font("Microsoft YaHei",Font.PLAIN,10));
        btnf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodchoice f=new foodchoice();
                f.setBackground(Color.WHITE);
                f.setVisible(true);
                f.setSize(519,540);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); }
            });
        add(panel2);

        ImageIcon m3 =new ImageIcon("src/MainApp/pages/image/pay.png");
        m3.setImage(m3.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JPanel panel3 = new JPanel(null);
        panel3.setBounds(45,350,375,85);
        panel3.setBackground(Color.white);
        panel3.setBorder(new RoundBorder(Color.gray));
        String mo3="$30";
        JLabel label31 = new JLabel(mo3);
        label31.setForeground(Color.red);
        label31.setBounds(278,30,75,25);
        label31.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel3.add(label31);
        String co3="Total";
        JLabel label32 = new JLabel(co3);
        label32.setBounds(158,30,62,21);
        label32.setFont(new Font("Microsoft YaHei",Font.PLAIN,25));
        panel3.add(label32);
        JLabel label33 = new JLabel(m3);
        label33.setBounds(20,18,50,50);
        panel3.add(label33);
        add(panel3);

        /*JButton btn = new JButton("Comfirm");
        btn.setBounds(45,400,425,38);
        btn.setFont(new Font("Microsoft YaHei", Font.BOLD,17));
        btn.setBackground(Color.BLUE);
        //btn.setForeground(Color.white);
        //btn.setBorder(BorderFactory.createRaisedBevelBorder());
        add(btn);
*/
        JPanel panelFlight = createFlight();
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

        JButton next = new JButton();
        next.setForeground(Color.blue);
        
        next.setText("Confirm");
        next.setBackground(Color.blue);
        next.setBounds(800,460,100,35);
        next.setFont(new Font("Microsoft YaHei UI",Font.BOLD,14));
        //next.setBorder(new RoundBorder(new Color(30, 144, 255)));
        next.setContentAreaFilled(true);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 credit frame = new credit();
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setSize(515,313);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(credit.HIDE_ON_CLOSE); 
          
            }
        });
        add(next);

        JButton back = new JButton();
        back.setBackground(Color.gray);
        back.setText("Back");
        //back.setForeground(Color.white);
        back.setFont(new Font("Microsoft YaHei UI",Font.BOLD,14));
        back.setBorder(new RoundBorder(Color.gray));
        back.setBounds(25,460,75,30);
        back.setContentAreaFilled(false);
        add(back);

        ImageIcon newImage = new ImageIcon("src/MainApp/pages/image/background.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
                    // newImage.setImage(newImage.getImage().getScaledInstance(430,350,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
                    picture.setIcon(newImage);
                    picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight()-35);
                    panelFlight.setBounds(500,80,415,355);
                
    }
    /*
    public  creditWindow(JPanel relativeWindow){
        JFrame newJFrame = new JFrame();
        newJFrame.setLocationRelativeTo(relativeWindow);

        newJFrame.setSize(250, 250);
        newJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // 窗口设置为不可改变大小
        newJFrame.setResizable(false);

        JPanel panel = new JPanel(null);

        // 在新窗口中显示一个标签
        JLabel label = new JLabel("Please enter your credit card number:");
        label.setFont(new Font(null, Font.PLAIN, 18));
        label.setBounds(46,80,436,35);
        panel.add(label);
        JLabel label2 = new JLabel("Please enter your password:");
        label.setFont(new Font(null, Font.PLAIN, 18));
        label.setBounds(46,137,436,35);
        panel.add(label2);

        String id;
        String password;
        int loginFlag = 0;
        boolean flag;
        JTextField

        JButton btn = new JButton("OK");
        panel.add(btn);
        label.setFont(new Font(null, Font.PLAIN, 15));
        label.setBounds(398,253,75,30);

        newJFrame.setContentPane(panel);
        newJFrame.setVisible(true);

    }
    */

    

    private static JPanel createFlight() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JLabel book = new JLabel("Booking ID");
        book.setFont(new Font("宋体",Font.ITALIC,15));

        JLabel bookID = new JLabel("13351112345");
        bookID.setFont(new Font("宋体",Font.ITALIC,15));

        JLabel date = new JLabel("Mar 22,2022");
        date.setFont(new Font("宋体",Font.ITALIC,15));

        JLabel where = new JLabel("Air China");
        where.setFont(new Font("宋体",Font.ITALIC,20));

        ImageIcon image = new ImageIcon("src/MainApp/pages/image/airplane.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel picture=new JLabel(image);

        JLabel takeoff = new JLabel("Beijing");
        takeoff.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel arrive = new JLabel("Shanghai");
        arrive.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel flightNo = new JLabel("KN2316");
        flightNo.setFont(new Font("宋体", Font.BOLD, 22));

        JLabel airport1 = new JLabel("Daxinng Airport");
        airport1.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel airport2 = new JLabel("Shuangliu Airport");
        airport2.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel startTime = new JLabel("16:00");
        startTime.setFont(new Font("宋体", Font.BOLD, 20));

        JLabel arriveTime = new JLabel("18:05");
        arriveTime.setFont(new Font("宋体", Font.BOLD, 20));

        JLabel time = new JLabel("2h15min");
        time.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel seat = new JLabel("economy seat");
        seat.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel food =new JLabel("food provided");
        food.setFont(new Font("宋体", Font.BOLD, 13));

        JLabel Terminal = new JLabel("Terminal");
        Terminal.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel TerminalNum = new JLabel("3");
        TerminalNum.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel GateNo = new JLabel("12");
        GateNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));

        JLabel Gate = new JLabel("Gate");
        Gate.setFont(new Font("宋体", Font.BOLD, 15));

        JLabel name = new JLabel("Xiping Yang");
        name.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel ID = new JLabel("130203200109110322");
        ID.setFont(new Font("宋体", Font.BOLD, 15));

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

        panel.setLayout(layout);
        return panel;
        
    }
    
}


