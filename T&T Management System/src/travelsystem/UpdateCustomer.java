package travelsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JLabel rusername,fusername,fname;
	JTextField tnumber,tcountry,taddress,temail,tphone,tgender,tid;
	JRadioButton rmale,rfemale;
	JButton update,back;
	String username;

	UpdateCustomer(String username){
		this.username=username;
		setBounds(400, 50, 600, 500);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(340, 30, 200, 400);
		add(image);
		
		JLabel head = new JLabel("UPDATE CUSTOMER DETAILS");
		head.setBounds(180, 5, 220, 20);
		head.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(head);
		
		rusername =  new JLabel("Username:");
		rusername.setBounds(30, 30, 70, 20);
		add(rusername);
		
		fusername = new JLabel();
		fusername.setBounds(110, 30, 150, 20);
		add(fusername);

		
		JLabel id =  new JLabel("ID: ");
		id.setBounds(30, 70, 70, 20);
		add(id);
		
		tid = new JTextField();
		tid.setBounds(110, 70, 150, 20);
		add(tid);
		
		JLabel number = new JLabel("ID Number:");
		number.setBounds(30, 110, 70, 20);
		add(number);
		
		tnumber = new JTextField();
		tnumber.setBounds(110, 110, 150, 20);
		add(tnumber);
		
		JLabel name =  new JLabel("Name:");
		name.setBounds(30, 150, 70, 20);
		add(name);
		
		fname = new JLabel();
		fname.setBounds(110, 150, 150, 20);
		add(fname);
		
		JLabel gender = new JLabel("Gender:");
		gender.setBounds(30, 190, 70, 20);
		add(gender);
		
		tgender = new JTextField();
		tgender.setBounds(110, 190, 150, 20);
		add(tgender);
		
		JLabel country = new JLabel("Country:");
		country.setBounds(30, 230, 70, 20);
		add(country);
		
		tcountry = new JTextField();
		tcountry.setBounds(110, 230, 150, 20);
		add(tcountry);
		
		JLabel address = new JLabel("address:");
		address.setBounds(30, 270, 70, 20);
		add(address);
		
		taddress = new JTextField();
		taddress.setBounds(110, 270, 150, 20);
		add(taddress);
		
		JLabel phone = new JLabel("Phone:");
		phone.setBounds(30, 310, 70, 20);
		add(phone);
		
		tphone = new JTextField();
		tphone.setBounds(110, 310, 150, 20);
		add(tphone);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(30, 350, 70, 20);
		add(email);
		
		temail = new JTextField();
		temail.setBounds(110, 350, 150, 20);
		add(temail);
		
		update = new JButton("UPDATE");
		update.setBounds(50, 390, 90, 30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setBorder(null);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("BACK");
		back.setBounds(170, 390, 90, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBorder(null);
		back.addActionListener(this);
		add(back);
		
		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				fusername.setText(rs.getString("username"));
				tid.setText(rs.getString("id"));
				tnumber.setText(rs.getString("id_number"));
				fname.setText(rs.getString("name"));
				tgender.setText(rs.getString("gender"));
				tcountry.setText(rs.getString("country"));
				taddress.setText(rs.getString("address"));
				tphone.setText(rs.getString("phone"));
				temail.setText(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==update) {
			try {
				Conn c = new Conn();
				String query1 =  "update customer set username = '"+fusername+"', id = '"+tid+"', id_number = '"+tnumber+"', name = '"+fname+"', gender = '"+tgender+"', country = '"+tcountry+"', address = '"+taddress+"', phone = '"+tphone+"', email = '"+temail+"'";
				c.s.executeUpdate(query1);
				JOptionPane.showMessageDialog(null, "Customer Details Updated Succesfully!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("kshitiz");

	}

}
