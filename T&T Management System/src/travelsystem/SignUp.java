package travelsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	JTextField tusername,tname,tpswd,ta;
	JButton create,back;
	Choice c;

	SignUp(){
		setBounds(200, 130, 900, 360);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JPanel p1 =  new JPanel();
		p1.setBackground(new Color(133,193,233));
		p1.setBounds(0, 0, 500, 400);
		p1.setLayout(null);
		add(p1);
	
		
		JLabel username = new JLabel("Username:");
		username.setBounds(50, 20, 125, 25);
		username.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(username);
		
		tusername = new JTextField();
		tusername.setBounds(190, 20, 190, 25);
		tusername.setBorder(null);
		p1.add(tusername);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(50, 60, 125, 25);
		name.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(name);
		
		tname = new JTextField();
		tname.setBounds(190, 60, 190, 25);
		tname.setBorder(null);
		p1.add(tname);
		
		JLabel pswd = new JLabel("Password:");
		pswd.setBounds(50, 100, 125, 25);
		pswd.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(pswd);
		
		tpswd = new JTextField();
		tpswd.setBounds(190, 100, 190, 25);
		tpswd.setBorder(null);
		p1.add(tpswd);
		
		JLabel security = new JLabel("Security Question:");
		security.setBounds(50, 140, 135, 25);
		security.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(security);
		
		c = new Choice();
		c.add("Favorite Player?");
		c.add("Favourite Character?");
		c.add("Childhood Name?");
		c.setBounds(190, 140, 190, 25);
		p1.add(c);
		
		JLabel answer = new JLabel("Answer:");
		answer.setBounds(50, 180, 125, 25);
		answer.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(answer);
		
		ta = new JTextField();
		ta.setBounds(190, 180, 190, 25);
		p1.add(ta);
		
		create = new JButton("CREATE");
		create.setBackground(new Color(133,193,233));
		create.setBounds(90, 230, 100, 35);
		create.setForeground(Color.WHITE);
		create.addActionListener(this);
		p1.add(create);
		
		back = new JButton("BACK");
		back.setBackground(new Color(133,193,233));
		back.setBounds(220, 230, 100, 35);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		p1.add(back);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(500, 0, 500, 400);
		add(p2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(110, 60, 200, 180);
		p2.add(image);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource()==create) {
			String username = tusername.getText();
			String name = tname.getText();
			String password = tpswd.getText();
			String security = c.getSelectedItem();
			String answer = ta.getText();
			
			String query = "insert into account values('"+username+"' , '"+name+"' , '"+password+"' , '"+security+"' , '"+answer+"')";
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully!");
				setVisible(false);
				new Login();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==back) {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] args) {
		new SignUp();
	}
}
