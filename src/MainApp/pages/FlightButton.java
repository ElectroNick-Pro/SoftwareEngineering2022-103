package MainApp.pages;
import javax.swing.*;
import MainApp.pages.control.FlightInfo;


import java.awt.*;

public class FlightButton extends FlightInfoButton {
    ImageIcon image;
    JLabel picture, takeoff,arrive,flightNo,date,where;

    public FlightButton(FlightInfo flightInfo, String flightTakeoff,String flightArrive,String flightFlightNo,
    String flightDate,String flightWhere){
        var button = this;
        button.info = flightInfo;
        button.setPreferredSize(new Dimension(374, 70));
        button.setBackground(Color.WHITE);
        
        image = new ImageIcon(ClassLoader.getSystemResource("MainApp/pages/image/airplane.png"));// background picture
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));// setSize
        picture=new JLabel(image);

        takeoff = new JLabel(flightTakeoff);
        takeoff.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 23));

        arrive = new JLabel(flightArrive);
        arrive.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 23));

        flightNo = new JLabel(flightFlightNo);
        flightNo.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 12));

        date = new JLabel(flightDate);
        date.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 12));

        where = new JLabel(flightWhere);
        where.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12)); 
    }
    public void Layout(){
        GroupLayout layout = new GroupLayout(this);
        GroupLayout.SequentialGroup hSeqGp01 = layout.createSequentialGroup();
        hSeqGp01.addGap(15);
        hSeqGp01.addComponent(takeoff);
        hSeqGp01.addGap(60);
        hSeqGp01.addComponent(picture);
        hSeqGp01.addGap(55);
        hSeqGp01.addComponent(arrive);

        GroupLayout.SequentialGroup hSeqGp02 = layout.createSequentialGroup();
        hSeqGp02.addGap(15);
        hSeqGp02.addComponent(where);
        hSeqGp02.addGap(10);
        hSeqGp02.addComponent(flightNo);
        hSeqGp02.addGap(165);
        hSeqGp02.addComponent(date);

        GroupLayout.ParallelGroup hparallelGroup1 = layout.createParallelGroup();
        hparallelGroup1.addGap(50);
        hparallelGroup1.addGroup(hSeqGp01);
        hparallelGroup1.addGap(50);
        hparallelGroup1.addGroup(hSeqGp02);

        layout.setHorizontalGroup(hparallelGroup1);

        GroupLayout.ParallelGroup vparallelGroup1 = layout.createParallelGroup();
        vparallelGroup1.addComponent(where);
        vparallelGroup1.addComponent(flightNo);

        GroupLayout.SequentialGroup vSeqGp01 = layout.createSequentialGroup();
        vSeqGp01.addGap(8);
        vSeqGp01.addGroup(vparallelGroup1);
        vSeqGp01.addGap(10);
        vSeqGp01.addComponent(takeoff);

        GroupLayout.SequentialGroup vSeqGp02 = layout.createSequentialGroup();
        vSeqGp02.addGap(8);
        vSeqGp02.addComponent(date);
        vSeqGp02.addGap(10);
        vSeqGp02.addComponent(arrive);

        GroupLayout.SequentialGroup vSeqGp03 = layout.createSequentialGroup();
        vSeqGp03.addGap(25);
        vSeqGp03.addComponent(picture);

        GroupLayout.ParallelGroup vparallelGroup = layout.createParallelGroup();
        vparallelGroup.addGroup(vSeqGp01);
        vparallelGroup.addGroup(vSeqGp03);
        vparallelGroup.addGroup(vSeqGp02);

        layout.setVerticalGroup(vparallelGroup);

        setLayout(layout);
    }
}
