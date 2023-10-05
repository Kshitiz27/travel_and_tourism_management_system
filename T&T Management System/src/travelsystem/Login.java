package travelsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JButton login,rpswd,SignUp;
	JTextField tusername,jtpassword;
	Login(){
		setLocation(200,150);
		setSize(900,400);
		setLayout(null);
		getContentPane().setBackground(Color.white);;
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131,193,233));
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);
		
		JPanel p2 = new JPanel();
		p2.setBounds(400, 30, 450, 300);
		p2.setLayout(null);
		add(p2);
		
		JLabel username =  new JLabel("Username:");
		username.setBounds(60, 20, 100, 25);
		username.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		p2.add(username);
		
		tusername = new JTextField();
		tusername.setBounds(60, 60, 300, 30);
		tusername.setBorder(null);
		p2.add(tusername);
		
		JLabel password =  new JLabel("Password:");
		password.setBounds(60, 110, 100, 25);
		password.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		p2.add(password);
		
		jtpassword = new JTextField();
		jtpassword.setBounds(60, 155, 300, 30);
		jtpassword.setBorder(null);
		p2.add(jtpassword);
		
		login  = new JButton("LOGIN");
		login.setBounds(60, 205, 130, 30);
		login.setBackground(new Color(131, 193, 233));
		login.setForeground(Color.black);
		login.setBorder(null);
		login.addActionListener(this);
		p2.add(login);
		
		SignUp  = new JButton("SIGN UP");
		SignUp.setBounds(230, 205, 130, 30);
		SignUp.setBackground(new Color(131, 193, 233));
		SignUp.setForeground(Color.black);
		SignUp.setBorder(null);
		SignUp.addActionListener(this);
		p2.add(SignUp);
		
		rpswd  = new JButton("FORGOT PASSWORD");
		rpswd.setBounds(150, 255, 130, 30);
		rpswd.setBackground(new Color(131, 193, 233));
		rpswd.setForeground(Color.black);
		rpswd.setBorder(null);
		rpswd.addActionListener(this);
		p2.add(rpswd);
		
		JLabel text = new JLabel("Trouble Logging in?");
		text.setBounds(300, 255, 130, 30);
		text.setForeground(Color.red);
		p2.add(text);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(100, 75, 200, 200);
		p1.add(image);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== login) {
			try {
				String username = tusername.getText();
				String password = jtpassword.getText();
				
				String query = "select * from account where username = '"+username+"' AND password = '"+password+"' ";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==SignUp) {
			try {
			setVisible(false);
			new SignUp();
			}catch (Exception e) {
				e.printStackTrace();
			}
			}
		else {
			try {
			setVisible(false);
			new ForgotPassword();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}





}
