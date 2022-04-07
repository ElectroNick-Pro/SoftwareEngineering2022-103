package MainApp.pages;

import javax.swing.*;
import MainApp.pages.components.*;

import java.awt.*;

public class Welcom extends JFrame{
    private JPanel contentPane;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcom frame = new Welcom();
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
    public Welcom(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/backgroudAirplane.png"));
        JLabel picture = new JLabel(image);
        picture.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        add(picture,JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false);
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(picture, new Integer(Integer.MIN_VALUE));

        JLabel welcome = new JLabel();
        welcome.setText("Check-In Kiosk");
        welcome.setFont(new Font("Microsoft YaHei UI",Font.BOLD,55));
        welcome.setBounds(257,72,445,86);
        add(welcome);

        JButton start = new JButton();
        start.setBackground(new Color(30, 144, 255));
        start.setText("Start");
        start.setForeground(Color.white);
        start.setFont(new Font("Microsoft YaHei UI",Font.BOLD,30));
        start.setBorder(new RoundBorder(new Color(30, 144, 255)));
        start.setBounds(391,426,177,40);
        add(start);
    }
}