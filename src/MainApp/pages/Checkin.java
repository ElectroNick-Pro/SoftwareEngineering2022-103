
package MainApp.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class Checkin extends JFrame implements ActionListener{
    public Container container;
    public JTextField bookingIDField;
    public JButton button1,button2,button3;
    public JPanel bookingID;
    public Checkin(){
		this.setTitle("Check-In Kiosk");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container = this.getContentPane();
        container.setLayout(null);

		// exit
        JButton exit = new JButton();
        exit.setContentAreaFilled(false);
        exit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		setIcon exitIcon = new setIcon();
        exitIcon.changeIconSize("src/MainApp/image/exit.png", exit, 40, 40);
        exit.setBounds(40,40,40,40);
        container.add(exit);

        // flow chart
        JPanel flowChart = new JPanel();
        flowChart.setLayout(null);
        flowChart.setLocation(120, 51);
        container.add(flowChart);

        JLabel flowChartCheckin = new JLabel("Check in");
        flowChartCheckin.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,15));
        flowChart.add(flowChartCheckin);

        // help
        // JButton help = new JButton();
        // help.setContentAreaFilled(false);
        // help.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		// setIcon helpIcon = new setIcon();
        // helpIcon.changeIconSize("src/MainApp/image/help.png", help, 40, 40);
        // help.setBounds(880,40,40,40);
        // container.add(help);

        // Set title of the frame.
		JLabel title = new JLabel("Check in");
		title.setFont(new Font("Microsoft YaHei UI",Font.BOLD,50));
		title.setBounds(45,105,215,70);
		container.add(title);



    }
    public void actionPerformed(ActionEvent event){
    }
    public static void main(String[] args){
		Checkin frame = new Checkin();
		frame.pack();
		frame.setVisible(true);
        frame.setSize(960,540);
	}
}
