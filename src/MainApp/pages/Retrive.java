
package MainApp.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import MainApp.pages.components.RoundBorder;

import MainApp.GlobalData;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.UserModel.Customer;
import MainApp.pages.Exception.UnboundPageException;
public class Retrive extends JFrame implements ActionListener{
    private Path path = Path.of("page1");
    public Container container;
    public JTextField bookingIdField, surnameField, customerIdField;
    public JButton button1,button2,button3;
    public JPanel panel1, panel2, panel3;
    public Retrive(){
        Pages.bindPage(this.path, this);
		this.setTitle("Check-In Kiosk");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.white);

		// exit
        ImageIcon exitIcon = new ImageIcon("src/MainApp/pages/image/exit.png");
        exitIcon.setImage(exitIcon.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        JLabel exit = new JLabel(exitIcon);
        exit .setBackground(Color.white);
        exit.setBounds(40,40,40,40);
        container.add(exit);

        // flow chart
        JPanel flowChart = new JPanel();
        flowChart.setLayout(null);
        flowChart.setBounds(100, 51,765,25);
        flowChart.setBackground(Color.WHITE);

        JLabel retrive = new JLabel("Retrive>");
        retrive.setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        retrive.setBounds(0,0,70,35);
        flowChart.add(retrive);

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

        container.add(flowChart);

        // question
        ImageIcon questionIcon = new ImageIcon("src/MainApp/image/question.png");
        questionIcon.setImage(questionIcon.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        JLabel question = new JLabel(questionIcon);
        question .setBackground(Color.white);
        question.setBounds(880,40,40,40);
        container.add(question);

        // title - Retrive
		JLabel title = new JLabel("Retrive",JLabel.LEFT);
		title.setFont(new Font("Microsoft YaHei UI",Font.BOLD,50));
		title.setBounds(45,105,190,70);
		container.add(title);

        // button - Retrive
        JButton btnRetrive = new JButton("Retrive");
        btnRetrive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnRetrive) {
                    var surname = surnameField.getText();
                    var customerId = customerIdField.getText();
                    var bookingId = bookingIdField.getText();
                    Customer customer = null;
                    try {
                        if(panel1.isVisible()) {
                            var customers = Customer.queryByProperty(Customer.class, "bookingId", bookingId).toArray();
                            if(customers.length == 0) {
                                return;
                            }
                            customer = (Customer)customers[0];
                        }
                        else{
                            
                        }
                        if(panel2.isVisible()) {
                            var customers = Customer.queryByProperty(Customer.class, "customerId", customerId)
                            .filter((x)->{
                                return x.surname.getValue().equals(surname);
                            }).toArray();
                            if(customers.length == 0) {
                                return;
                            }
                            customer = (Customer)customers[0];
                        }
                        if(panel3.isVisible()) {
                            return;
                        }
                    } catch (FieldNotFoundException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    GlobalData.data.put("customer", customer);
                    try {
                        new FlightInformationFrm();
                        Pages.displayPage(Path.of("page1/page2"));
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                        return;
                    }
                }
            }
        });
        btnRetrive.setBounds(45,390,425,38);
        btnRetrive.setBorder(new RoundBorder(new Color(0, 131, 255)));
        btnRetrive.setBackground(new Color(0, 131, 255));
        container.add(btnRetrive);

        // part1 - Booking ID
        panel1 = new JPanel();
        panel1.setBounds(45,215,425,134);
        panel1.setLayout(null); // Absolute Layout
        JLabel label1 = new JLabel("Please enter your booking ID:");
        label1.setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
        label1.setBounds(0,0,425,70); // relative location
        JTextField field1 = new JTextField();
        bookingIdField = field1;
        field1.setBounds(0,95,425,38);

        panel1.add(label1);
        panel1.add(field1);
        panel1.setBackground(Color.white);
        container.add(panel1);
        panel1.setVisible(true);

        // part2 - Surname and ID
        panel2 = new JPanel();
        panel2.setBounds(45,170,425,193);
        panel2.setLayout(null);
        JLabel label2_1 = new JLabel("Please enter your surname:");
        label2_1.setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
        label2_1.setBounds(0,0,425,70);

        JTextField field2_1 = new JTextField();
        surnameField = field2_1;
        field2_1.setBounds(0,63,425,38);
        JLabel label2_2 = new JLabel("Please enter your ID number:");
        label2_2.setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
        label2_2.setBounds(0,90,425,70);
        JTextField field2_2 = new JTextField();
        customerIdField = field2_2;
        field2_2.setBounds(0,155,425,38);

        panel2.add(label2_1);
        panel2.add(field2_1);
        panel2.add(label2_2);
        panel2.add(field2_2);
        panel2.setBackground(Color.WHITE);
        container.add(panel2);
        panel2.setVisible(false);

        // part3 - Scan ID
        panel3 = new JPanel();
        panel3.setBounds(45,170,341,191);
        panel3.setLayout(null);
        JLabel label3 = new JLabel("Please scan your ID document:");
        label3.setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
        label3.setBounds(0,0,341,70);
        ImageIcon scanIcon = new ImageIcon("src/MainApp/pages/image/scanIDcard.png");
        scanIcon.setImage(scanIcon.getImage().getScaledInstance(276,126,Image.SCALE_DEFAULT));
        JLabel scan = new JLabel(scanIcon);
        scan.setBackground(Color.white);
        scan.setBounds(65,65,276,126);
        panel3.add(scan);
        panel3.add(label3);
        container.add(panel3);
        panel3.setBackground(Color.WHITE);
        panel3.setVisible(false);

        // button - Booking ID
        JButton btnBookingID = new JButton("Booking ID");
        btnBookingID.setBackground(Color.white);
        btnBookingID.setBorder(new RoundBorder(new Color(121, 121, 121)));
        btnBookingID.setContentAreaFilled(false);
        btnBookingID.setBounds(45,455,125,38);
        btnBookingID.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                panel2.setVisible(false);
                panel3.setVisible(false);
				panel1.setVisible(true);
            }
        });
        container.add(btnBookingID);

        // button - Surname and ID
        JButton btnSurnameID = new JButton("Surname and ID");
        btnSurnameID.setBounds(195,455,165,38);
        btnSurnameID.setBorder(new RoundBorder(new Color(121, 121, 121)));
        btnSurnameID.setContentAreaFilled(false);
        btnSurnameID.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                panel1.setVisible(false);
                panel3.setVisible(false);
				panel2.setVisible(true);
            }
        });
        container.add(btnSurnameID);

        // button - Scan ID
        JButton btnScanID = new JButton("Scan ID");
        btnScanID.setBounds(385,455,85,38);
        btnScanID.setBorder(new RoundBorder(new Color(121, 121, 121)));
        btnScanID.setContentAreaFilled(false);
        btnScanID.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                panel2.setVisible(false);
                panel1.setVisible(false);
				panel3.setVisible(true);
            }
        });
        container.add(btnScanID);

        // background picture
        ImageIcon backgroundIcon = new ImageIcon("src/MainApp/image/departing.png");
        backgroundIcon.setImage(backgroundIcon.getImage().getScaledInstance(350,524,Image.SCALE_DEFAULT));
        JLabel background = new JLabel(backgroundIcon);
        background.setBackground(Color.white);
        background.setBounds(540,45,350,524);
        container.add(background);
    }
    public void actionPerformed(ActionEvent event){

    }

    public static void main(String[] args){
		Retrive frame = new Retrive();
		frame.pack();
		frame.setVisible(true);
        frame.setSize(965,550);
        frame.setLocationRelativeTo(null); 
	}
}
