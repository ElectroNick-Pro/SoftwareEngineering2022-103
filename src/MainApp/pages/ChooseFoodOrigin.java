package MainApp.pages;

import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;

import MainApp.GlobalData;
import MainApp.models.Models;
import MainApp.models.Model.Exception.FieldNotFoundException;
import MainApp.models.Model.Exception.ObjectNotFoundException;
import MainApp.models.Model.UserModel.Flight;
import MainApp.models.Model.UserModel.Food;
import MainApp.models.Model.UserModel.Ticket;
import MainApp.pages.components.RoundBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class ChooseFoodOrigin extends ChooseFoodtemplate {

	String[] originchoice = new String[] { "0", "0", "0" };

	// constructer**************************************************
	public ChooseFoodOrigin() {

		this.Titleset("Choose Food");
		ImageIcon home = new ImageIcon("src/MainApp/pages/image/exit1.png");
		JButton Home = new JButton(home);
		Home.setBounds(40, 20, 40, 40);
		Home.setBorderPainted(false);
		Home.setBackground(Color.WHITE);
		this.add(Home, Integer.valueOf(4));

		ImageIcon help = new ImageIcon("src/MainApp/pages/image/help2.png");
		JButton Help = new JButton(help);
		Help.setBounds(880, 20, 40, 40);
		Help.setBorderPainted(false);
		Help.setBackground(Color.WHITE);
		this.add(Help);
		this.add(Help, Integer.valueOf(4));
		// 框框

		JPanel panel1 = this.paintRect(45, 170, 0);
		foodimage standard1 = new foodimage("src/MainApp/pages/image/Standard1.png");
		standard1.set1();
		this.add(panel1, Integer.valueOf(2));
		this.add(standard1, Integer.valueOf(4));

		JPanel panel2 = this.paintRect(270, 170, 0);
		foodimage vegan2 = new foodimage("src/MainApp/pages/image/Vegan2.png");
		vegan2.set2();
		this.add(panel2, Integer.valueOf(2));
		this.add(vegan2, Integer.valueOf(4));

		JPanel panel3 = this.paintRect(495, 170, 1);
		foodimage hum3 = new foodimage("src/MainApp/pages/image/Humbergur3.png");
		hum3.set3();
		this.add(panel3, Integer.valueOf(2));
		this.add(hum3, Integer.valueOf(4));

		JPanel panel4 = this.paintRect(720, 170, 1);
		foodimage beef4 = new foodimage("src/MainApp/pages/image/Beefsteak4.png");
		beef4.set4();
		this.add(panel4, Integer.valueOf(2));
		this.add(beef4, Integer.valueOf(4));

		JPanel panel5 = this.paintRect(45, 315, 0);
		foodimage halal5 = new foodimage("src/MainApp/pages/image/Halal5.png");
		halal5.set5();
		this.add(panel5, Integer.valueOf(2));
		this.add(halal5, Integer.valueOf(4));

		JPanel panel6 = this.paintRect(270, 315, 0);
		foodimage child6 = new foodimage("src/MainApp/pages/image/child6.png");
		child6.set6();
		this.add(panel6, Integer.valueOf(2));
		this.add(child6, Integer.valueOf(4));

		JPanel panel7 = this.paintRect(495, 345, 1);
		foodimage seafood7 = new foodimage("src/MainApp/pages/image/Seafood7.png");
		this.add(panel7, Integer.valueOf(2));
		this.add(seafood7, Integer.valueOf(4));
		seafood7.set7();

		JPanel panel8 = this.paintRect(720, 315, 1);
		foodimage lowsugar8 = new foodimage("src/MainApp/pages/image/Lowsugar8.png");
		lowsugar8.set8();
		this.add(panel8, Integer.valueOf(2));
		this.add(lowsugar8, Integer.valueOf(4));

		// 按钮***************************************
		newfoodButton Standard = new newfoodButton("Standard", 0, null);
		Standard.set1();
		Standard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(46, 201, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Standard", "0", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});

		newfoodButton Vegan = new newfoodButton("Vegetarian", 0, null);
		Vegan.set2();
		Vegan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(271, 201, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Vegan", "0", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});
		newfoodButton Humbergur = new newfoodButton("Hamburger", 1, "$5");
		Humbergur.set3();
		Humbergur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(496, 201, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Humbergur", "5", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});
		newfoodButton BeefSteak = new newfoodButton("BeefSteak", 1, "$12");
		BeefSteak.set4();
		BeefSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(721, 201, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "BeefSteak", "12", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});
		newfoodButton Halal = new newfoodButton("Halal", 0, null);
		Halal.set5();
		Halal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(46, 346, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Halal", "0", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});
		newfoodButton Children = new newfoodButton("Children", 0, null);
		Children.set6();
		Children.set6();
		Children.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(271, 346, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Children", "0", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});
		newfoodButton Seafood = new newfoodButton("Seafood", 1, "$8");
		Seafood.set7();
		Seafood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(496, 346, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Seafood", "8", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});
		newfoodButton Lowsugar = new newfoodButton("Low Sugar", 1, "$4");
		Lowsugar.set8();
		Lowsugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				ok.setBounds(721, 346, 50, 50);
				ok.setVisible(true);
				originchoice = new String[] { "Low Sugar", "4", "origin" };
				System.out.println(originchoice[0].toString());
			}
		});

		this.add(Standard, Integer.valueOf(4));
		this.add(Vegan, Integer.valueOf(4));
		this.add(Humbergur, Integer.valueOf(4));
		this.add(BeefSteak, Integer.valueOf(4));
		this.add(Halal, Integer.valueOf(4));
		this.add(Children, Integer.valueOf(4));
		this.add(Seafood, Integer.valueOf(4));
		this.add(Lowsugar, Integer.valueOf(4));

		JPanel shadow3 = shade(520, 210);
		this.add(shadow3, Integer.valueOf(1));
		JPanel shadow4 = shade(745, 210);
		this.add(shadow4, Integer.valueOf(1));
		JPanel shadow7 = shade(520, 355);
		this.add(shadow7, Integer.valueOf(1));
		JPanel shadow8 = shade(745, 355);
		this.add(shadow8, Integer.valueOf(1));

		
		Home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Home) {
					
					try {
						var ticket = (Ticket)GlobalData.data.get("ticket");
						var flight = (Flight)ticket.flight.getReferred();
						var food = MainApp.models.Model.UserModel.Food
									.queryByProperty(MainApp.models.Model.UserModel.Food.class, "name", originchoice[0])
									.filter((x)->{
										return x.flight.getValue().equals(flight.id);
									}).findFirst().get();
						GlobalData.data.put("food_choice", food);
						System.out.println();
					} catch (ObjectNotFoundException | FieldNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		
		try {
			GlobalData.init();
			Models.init();
			GlobalData.data.put("ticket", Ticket.getById(Ticket.class, 1));
			var f = new ChooseFoodOrigin();
			var frame = new JFrame();
			frame.add(f);
			frame.pack();
			frame.setVisible(true);
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}