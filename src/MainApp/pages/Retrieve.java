package MainApp.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import MainApp.pages.components.*;
import MainApp.GlobalData;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.UserModel.Customer;
import MainApp.models.Model.UserModel.Ticket;
import MainApp.pages.Exception.UnboundPageException;

public class Retrieve extends JFrame implements ActionListener{
    private Path path = Path.of("/Retrieve");
    public Container container;
    public static JTextField bookingIdField, surnameField, customerIdField;
    public JButton button1,button2,button3;
    public JPanel panel1, panel2, panel3;
    public Retrieve(){
        Pages.bindPage(this.path, this);
		this.setTitle("Check-In Kiosk");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setSize(965,550);

		container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.white);
        // top panel
        topPanel top = new topPanel(this.path);
        top.setBounds(0,0,940,70);
        container.add(top);
        top.setVisible(true);

        // title - Retrieve
		JLabel title = new JLabel("Retrieve",JLabel.LEFT);
		title.setFont(new Font("Microsoft YaHei UI",Font.BOLD,50));
		title.setBounds(45,85,250,70);
		container.add(title);

        // button - Retrieve
        JButton btnRetrieve = new JButton("Retrieve");
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnRetrieve) {
                    var surname = surnameField.getText();
                    var customerId = customerIdField.getText();
                    var bookingId = bookingIdField.getText();
                    Customer customer = null;
                    Ticket ticket = null;
                    try {
                        if(panel1.isVisible()) {
                            if(bookingId.equals("")){
                                JOptionPane.showMessageDialog(null, "Please enter your bookingID.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }else{
                                var tickets = Ticket.queryByProperty(Ticket.class, "bookingId", bookingId).toArray();
                                if(tickets.length == 0){
                                    JOptionPane.showMessageDialog(null, "This bookingID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                ticket = (Ticket)tickets[0];
                                GlobalData.data.put("ticket",ticket);
                                GlobalData.data.put("flag",1);
                            }
                        }
                        if(panel2.isVisible()) {
                            if(surname.equals("") || customerId.equals("")){
                                JOptionPane.showMessageDialog(null,"Please enter your surname and ID number.","Error",JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            else{
                                var customers = Customer.queryByProperty(Customer.class, "customerId", customerId).toArray();
                                if(customers.length == 0) {
                                    JOptionPane.showMessageDialog(null, "The ID number you entered does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                } else {
                                    customer = (Customer)customers[0];
                                    if(!customer.surname.equals(surname)) {
                                        JOptionPane.showMessageDialog(null, "Your surname and ID number does not match!", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    } else {
                                        var ticketCnt = Ticket.queryByProperty(Ticket.class, "Customer_id", customer.id).count();
                                        if(ticketCnt == 0) {
                                            JOptionPane.showMessageDialog(null, "You have not booked any ticket yet!", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                    }
                                }
                                
                                GlobalData.data.put("customer", customer);
                                GlobalData.data.put("flag",2);                                
                            }
                        }
                        if(panel3.isVisible()) {
                            var customers = Customer.queryByProperty(Customer.class, "customerId", "123456789012345678").toArray();
                            if(customers.length == 0) {
                                return;
                            }
                            customer = (Customer)customers[0];
                            GlobalData.data.put("customer", customer);
                            GlobalData.data.put("flag",2);
                        }
                    } catch (FieldNotFoundException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    try {
                        new FlightInformationFrm();
                        Pages.displayPage(path.resolve(Path.of("Flight Information")));
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                        return;
                    }
                }
            }
        });
        btnRetrieve.setBounds(45,370,425,38);
        btnRetrieve.setBorder(new RoundBorder(new Color(0, 131, 255)));
        btnRetrieve.setForeground(Color.WHITE);
        btnRetrieve.setBackground(new Color(0, 131, 255));
        container.add(btnRetrieve);

        // part1 - Booking ID
        panel1 = new JPanel();
        panel1.setBounds(45,195,425,134);
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
        panel2.setBounds(45,150,425,193);
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
        panel3.setBounds(45,150,341,191);
        panel3.setLayout(null);
        JLabel label3 = new JLabel("Please scan your ID document:");
        label3.setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
        label3.setBounds(0,0,341,70);
        ImageIcon scanIcon = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("MainApp/pages/image/scanIDcard.png"));
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
        btnBookingID.setBounds(45,435,125,38);
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
        btnSurnameID.setBounds(195,435,165,38);
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
        btnScanID.setBounds(385,435,85,38);
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
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("MainApp/pages/image/departing.png"));
        backgroundIcon.setImage(backgroundIcon.getImage().getScaledInstance(350,524,Image.SCALE_DEFAULT));
        JLabel background = new JLabel(backgroundIcon);
        background.setBackground(Color.white);
        background.setBounds(540,25,350,524);
        container.add(background);
    }
    public void actionPerformed(ActionEvent event){

    }

    public static void main(String[] args){
		Retrieve frame = new Retrieve();
		frame.pack();
		frame.setVisible(true);
        frame.setSize(965,550);
        frame.setLocationRelativeTo(null); 
	}
}
