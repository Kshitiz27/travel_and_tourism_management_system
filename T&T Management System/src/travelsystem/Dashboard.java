package travelsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static String username;
	JButton addprsnldetail,viewdetail,updateprsnldetail,checkpkg,bookpkg,viewhotel,dest;

	Dashboard(String username){
		
		Dashboard.username = username;
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 1600, 80);
		p1.setBackground(new Color(80, 1, 120));
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(15, 2, 80, 80);
		p1.add(icon);
		
		JLabel head = new JLabel("Dashboard");
		head.setBounds(120, 0 , 180, 80);
		head.setBackground(new Color(80, 1, 120));
		head.setForeground(Color.white);
		head.setFont(new Font("Tahoma", Font.BOLD, 30));
		p1.add(head);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 200, 1000);
		p2.setBackground(new Color(80, 1, 120));
		p2.setLayout(null);
		add(p2);
		
		addprsnldetail = new JButton("Add Personal Detail");
		addprsnldetail.setBounds(0, 0, 200, 35);
		addprsnldetail.setBackground(new Color(80, 1, 120));
		addprsnldetail.setBorder(null);
		addprsnldetail.setForeground(Color.WHITE);
		addprsnldetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addprsnldetail.setMargin(new Insets(0, 0, 0, 60));
		addprsnldetail.addActionListener(this);
		p2.add(addprsnldetail);
		
		updateprsnldetail = new JButton("Update Personal Detail");
		updateprsnldetail.setBounds(0, 35, 200, 35);
		updateprsnldetail.setBackground(new Color(80, 1, 120));
		updateprsnldetail.setBorder(null);
		updateprsnldetail.setForeground(Color.WHITE);
		updateprsnldetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateprsnldetail.setMargin(new Insets(0, 0, 0, 60));
		p2.add(updateprsnldetail);
		
		viewdetail = new JButton("View Detail");
		viewdetail.setBounds(0, 70, 200, 35);
		viewdetail.setBackground(new Color(80, 1, 120));
		viewdetail.setBorder(null);
		viewdetail.setForeground(Color.WHITE);
		viewdetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewdetail.setMargin(new Insets(0, 0, 0, 60));
		viewdetail.addActionListener(this);
		p2.add(viewdetail);
		
		JButton dltprsnldetail = new JButton("Delete Personal Detail");
		dltprsnldetail.setBounds(0, 105, 200, 35);
		dltprsnldetail.setBackground(new Color(80, 1, 120));
		dltprsnldetail.setBorder(null);
		dltprsnldetail.setForeground(Color.WHITE);
		dltprsnldetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dltprsnldetail.setMargin(new Insets(0, 0, 0, 60));
		p2.add(dltprsnldetail);
		
		checkpkg = new JButton("Check Package");
		checkpkg.setBounds(0, 140, 200, 35);
		checkpkg.setBackground(new Color(80, 1, 120));
		checkpkg.setBorder(null);
		checkpkg.setForeground(Color.WHITE);
		checkpkg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		checkpkg.setMargin(new Insets(0, 0, 0, 60));
		checkpkg.addActionListener(this);
		p2.add(checkpkg);
		
		bookpkg = new JButton("Book Package");
		bookpkg.setBounds(0, 175, 200, 35);
		bookpkg.setBackground(new Color(80, 1, 120));
		bookpkg.setBorder(null);
		bookpkg.setForeground(Color.WHITE);
		bookpkg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bookpkg.setMargin(new Insets(0, 0, 0, 60));
		bookpkg.addActionListener(this);
		p2.add(bookpkg);
		
		JButton viewpkg = new JButton("View Package");
		viewpkg.setBounds(0, 210, 200, 35);
		viewpkg.setBackground(new Color(80, 1, 120));
		viewpkg.setBorder(null);
		viewpkg.setForeground(Color.WHITE);
		viewpkg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewpkg.setMargin(new Insets(0, 0, 0, 60));
		p2.add(viewpkg);
		
		viewhotel = new JButton("View Hotels");
		viewhotel.setBounds(0, 245, 200, 35);
		viewhotel.setBackground(new Color(80, 1, 120));
		viewhotel.setBorder(null);
		viewhotel.setForeground(Color.WHITE);
		viewhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		viewhotel.setMargin(new Insets(0, 0, 0, 60));
		p2.add(viewhotel);
		
		JButton bookhotel = new JButton("Book Package");
		bookhotel.setBounds(0, 280, 200, 35);
		bookhotel.setBackground(new Color(80, 1, 120));
		bookhotel.setBorder(null);
		bookhotel.setForeground(Color.WHITE);
		bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bookhotel.setMargin(new Insets(0, 0, 0, 60));
		p2.add(bookhotel);
		
		JButton vbookedhotel = new JButton("View Booked Hotel");
		vbookedhotel.setBounds(0, 315, 200, 35);
		vbookedhotel.setBackground(new Color(80, 1, 120));
		vbookedhotel.setBorder(null);
		vbookedhotel.setForeground(Color.WHITE);
		vbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vbookedhotel.setMargin(new Insets(0, 0, 0, 60));
		p2.add(vbookedhotel);
		
		dest = new JButton("Destination");
		dest.setBounds(0, 350, 200, 35);
		dest.setBackground(new Color(80, 1, 120));
		dest.setBorder(null);
		dest.setForeground(Color.WHITE);
		dest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dest.setMargin(new Insets(0, 0, 0, 60));
		p2.add(dest);
		
		JButton payments = new JButton("Payments");
		payments.setBounds(0, 385, 200, 35);
		payments.setBackground(new Color(80, 1, 120));
		payments.setBorder(null);
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		payments.setMargin(new Insets(0, 0, 0, 60));
		p2.add(payments);
		
		JButton calc = new JButton("Calculator");
		calc.setBounds(0, 420, 200, 35);
		calc.setBackground(new Color(80, 1, 120));
		calc.setBorder(null);
		calc.setForeground(Color.WHITE);
		calc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		calc.setMargin(new Insets(0, 0, 0, 60));
		p2.add(calc);
		
		JButton notepad = new JButton("Notepad");
		notepad.setBounds(0, 455, 200, 35);
		notepad.setBackground(new Color(80, 1, 120));
		notepad.setBorder(null);
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		notepad.setMargin(new Insets(0, 0, 0, 60));
		p2.add(notepad);
		
		JButton about = new JButton("About");
		about.setBounds(0, 490, 200, 35);
		about.setBackground(new Color(80, 1, 120));
		about.setBorder(null);
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma", Font.PLAIN, 16));
		about.setMargin(new Insets(0, 0, 0, 60));
		p2.add(about);
		
		ImageIcon hi1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image hi2 = hi1.getImage().getScaledInstance(1600, 1200, Image.SCALE_DEFAULT);
		ImageIcon hi3 = new ImageIcon(hi2);
		JLabel img = new JLabel(hi3);
		img.setBounds(0, 0, 1300, 1000);
		add(img);
		
		JLabel txt = new JLabel("Travel & Tourism Management System");
		txt.setForeground(Color.black);
		txt.setBounds(250, 100, 400, 30);
		txt.setFont(new Font("Tahoma", Font.BOLD, 20));
		img.add(txt);
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addprsnldetail) {
			new adduser(username);
		}
		else if(ae.getSource()== viewdetail) {
			new ViewCustomer(username);
		}
		else if(ae.getSource()==updateprsnldetail) {
			new UpdateCustomer(username);
		}
		else if(ae.getSource()==checkpkg) {
			new Checkpkg();
		}
		else if(ae.getSource()==bookpkg) {
			new Bookpkg(username);
		}
		else if(ae.getSource()==viewhotel) {
			new Viewhotel();
		}
		else if(ae.getSource()==dest) {
			new Destination();
		}
	}
	
	public static void main(String[] args) {
		new Dashboard("username");
	}
	
}
