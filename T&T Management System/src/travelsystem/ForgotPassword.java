package travelsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JLabel username,name,security,answer,password;
	JTextField tusername,tname,tsecurity,tanswer,tpassword;
	JButton search, retrieval,back;

	ForgotPassword(){
		
		setBounds(200, 130, 900, 460);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 500, 450);
		p1.setBackground(new Color(133,193,233));
		p1.setLayout(null);
		add(p1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBounds(500, 0, 500, 450);
		p2.setLayout(null);
		add(p2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20,60,350,300);
		p2.add(image);
		
		username = new JLabel("Username:");
		username.setBounds(30, 20, 80, 30);
		username.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(username);
		
		tusername = new JTextField();
		tusername.setBounds(130, 20, 200, 30);
		p1.add(tusername);
		
		search = new JButton("Search");
		search.setBackground(Color.black);
		search.setForeground(Color.WHITE);
		search.setBounds(350, 20, 100, 30);
		search.addActionListener(this);
		p1.add(search);
		
		name = new JLabel("name:");
		name.setBounds(30, 70, 100, 30);
		name.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(name);
		
		tname = new JTextField();
		tname.setBounds(130, 70, 200, 30);
		p1.add(tname);
		
		security = new JLabel("Question:");
		security.setBounds(30, 120, 80, 30);
		security.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(security);
		
		tsecurity = new JTextField();
		tsecurity.setBounds(130, 120, 200, 30);
		p1.add(tsecurity);
		
		answer = new JLabel("Answer:");
		answer.setBounds(30, 170, 80, 30);
		answer.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(answer);
		
		tanswer = new JTextField();
		tanswer.setBounds(130, 170, 200, 30);
		p1.add(tanswer);
		
		retrieval = new JButton("Retrieval");
		retrieval.setBounds(350, 170, 100 ,30);
		retrieval.setBackground(Color.black);
		retrieval.setForeground(Color.white);
		retrieval.addActionListener(this);
		p1.add(retrieval);
		
		password = new JLabel("Password:");
		password.setBounds(30, 220, 80, 30);
		password.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(password);
		
		tpassword = new JTextField();
		tpassword.setBounds(130, 220, 200, 30);
		p1.add(tpassword);
		
		back = new JButton("Back");
		back.setBounds(190, 290, 80, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		p1.add(back);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
		try {
				String query = "select * from account where username = '"+tusername.getText()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tname.setText(rs.getString("name"));
					tsecurity.setText(rs.getString("security"));
				}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		else if(ae.getSource()==retrieval) {
		try {
				String query = "select * from account where answer = '"+tanswer.getText()+"' AND  username = '"+tusername.getText()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tpassword.setText(rs.getString("password"));
				}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		else {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] args) {
		new ForgotPassword();
		}
	
	
}
