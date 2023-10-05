package travelsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class Checkpkg extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Checkpkg(){
		setBounds(250,80,750,550);
		
		String[] package1 = {"GOLD PACKAGE","6 DAYS AND 5 NIGHTS","Rs.16000 (including G.S.T)","INDIA TOUR","LUXURY ROOMS TO STAY","OUTDOOR GAMES TO PLAY","package1.jpg"};
		String[] package2 = {"SILVER PACKAGE","4 DAYS AND 3 NIGHTS","Rs.14000 (including G.S.T)","EUROPE INDIA TOUR","LUXURY ROOMS TO STAY","OUTDOOR GAMES TO PLAY","package2.jpg"};
		String[] package3 = {"PLATINUM PACKAGE","2 DAYS AND 1 NIGHT","Rs.12000 (including G.S.T)","AFRICA INDIA TOUR","LUXURY ROOMS TO STAY","OUTDOOR GAMES TO PLAY","package3.jpg"};
		
		
		JTabbedPane tab = new JTabbedPane();
		

		JPanel p1 = crtpkg(package1);
		tab.addTab("Package 1", null, p1);;
		add(tab);
		
		JPanel p2 = crtpkg(package2);
		tab.addTab("Package 2", null, p2);;
		add(tab);
		
		JPanel p3 = crtpkg(package3);
		tab.addTab("Package 3", null, p3);;
		add(tab);
		
		
		
		
		
		
		setVisible(true);
	}
	
	public JPanel crtpkg(String[] pack) {
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.white);
		
		JLabel l1 =new JLabel(pack[0]);
		l1.setBounds(280, 2, 250, 20);
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l1.setForeground(Color.red);
		p1.add(l1);
		
		JLabel l2 =new JLabel(pack[1]);
		l2.setBounds(20, 120, 250, 20);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setForeground(Color.black);
		p1.add(l2);
		
		JLabel l3 =new JLabel(pack[2]);
		l3.setBounds(20, 160, 250, 20);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setForeground(Color.black);
		p1.add(l3);
		
		JLabel l4 =new JLabel(pack[3]);
		l4.setBounds(20, 200, 250, 20);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setForeground(Color.black);
		p1.add(l4);
		
		JLabel l5 =new JLabel(pack[4]);
		l5.setBounds(20, 240, 250, 20);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		l5.setForeground(Color.black);
		p1.add(l5);
		
		JLabel l6 =new JLabel(pack[5]);
		l6.setBounds(20, 280, 250, 20);
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		l6.setForeground(Color.black);
		p1.add(l6);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[6]));
		Image i2 = i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300, 45, 400, 400);
		p1.add(image);
		
		return p1;
		
	}
	
	public static void main(String[] args) {
		new Checkpkg();
	}

}
