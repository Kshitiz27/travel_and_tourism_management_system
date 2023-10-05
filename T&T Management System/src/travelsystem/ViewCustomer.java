package travelsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewCustomer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton back;

	ViewCustomer(String username) {
		
		setBounds(200, 100, 800, 500);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel rusername = new JLabel("Username:");
		rusername.setBounds(30, 40, 70, 20);
		add(rusername);
		
		JLabel fusername = new JLabel();
		fusername.setBounds(120, 40, 150, 20);
		add(fusername);
		
		JLabel id = new JLabel("Id:");
		id.setBounds(30, 80, 70, 20);
		add(id);
		
		JLabel fid = new JLabel();
		fid.setBounds(120, 80, 150, 20);
		add(fid);
		
		JLabel number = new JLabel("Id Number:");
		number.setBounds(30, 120, 70, 20);
		add(number);
		
		JLabel fnumber = new JLabel();
		fnumber.setBounds(120, 120, 150, 20);
		add(fnumber);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(30, 160, 70, 20);
		add(name);
		
		JLabel fname = new JLabel();
		fname.setBounds(120, 160, 150, 20);
		add(fname);
		
		JLabel gender = new JLabel("Gender:");
		gender.setBounds(30, 200, 70, 20);
		add(gender);
		
		JLabel fgender = new JLabel();
		fgender.setBounds(120, 200, 150, 20);
		add(fgender);
		
		

		JLabel country = new JLabel("Country:");
		country.setBounds(500, 40, 70, 20);
		add(country);
		
		JLabel fcountry = new JLabel();
		fcountry.setBounds(590, 40, 150, 20);
		add(fcountry);
		
		JLabel address = new JLabel("Address:");
		address.setBounds(500, 80, 70, 20);
		add(address);
		
		JLabel faddress = new JLabel();
		faddress.setBounds(590, 80, 150, 20);
		add(faddress);
		
		JLabel phone = new JLabel("Phone:");
		phone.setBounds(500, 120, 70, 20);
		add(phone);
		
		JLabel fphone = new JLabel();
		fphone.setBounds(590, 120, 150, 20);
		add(fphone);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(500, 160, 70, 20);
		add(email);
		
		JLabel femail = new JLabel();
		femail.setBounds(590, 160, 150, 20);
		add(femail);
		
		back = new JButton("BACK");
		back.setBounds(320, 230, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 290, 560, 200);
		add(image);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_SMOOTH);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(570, 290, 340, 200);
		add(image1);
		
		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				fusername.setText(rs.getString("username"));
				fid.setText(rs.getString("id"));
				fnumber.setText(rs.getString("id_number"));
				fname.setText(rs.getString("name"));
				fgender.setText(rs.getString("gender"));
				fcountry.setText(rs.getString("country"));
				faddress.setText(rs.getString("address"));
				fphone.setText(rs.getString("phone"));
				femail.setText(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new ViewCustomer("kshitiz");

	}

}
