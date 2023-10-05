package travelsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class adduser extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel rusername,fusername,fname;
	JComboBox<Object> comboid;
	JTextField tnumber,tcountry,taddress,temail,tphone;
	JRadioButton rmale,rfemale;
	JButton add,back;
	
	adduser(String username){
		
		setBounds(400, 50, 600, 500);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(340, 50, 200, 400);
		add(image);
		
		rusername =  new JLabel("Username:");
		rusername.setBounds(30, 30, 70, 20);
		add(rusername);
		
		fusername = new JLabel();
		fusername.setBounds(110, 30, 150, 20);
		add(fusername);

		
		JLabel id =  new JLabel("ID: ");
		id.setBounds(30, 70, 70, 20);
		add(id);
		
		comboid = new JComboBox<Object>(new String[]{"Passport", "Pan Card", "Aadhar Card", "Ration Card"});
		comboid.setBounds(110,70,150,20);
		comboid.setBackground(Color.white);
		add(comboid);
		
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
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(110, 190, 60, 20);
		rmale.setBackground(Color.white);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(190, 190, 80, 20);
		rfemale.setBackground(Color.white);
		add(rfemale);
		
		JLabel country = new JLabel("Country:");
		country.setBounds(30, 230, 70, 20);
		add(country);
		
		tcountry = new JTextField();
		tcountry.setBounds(110, 230, 150, 20);
		add(tcountry);
		
		JLabel address = new JLabel("Address:");
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
		
		add = new JButton("ADD");
		add.setBounds(50, 390, 90, 30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setBorder(null);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("BACK");
		back.setBounds(170, 390, 90, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBorder(null);
		back.addActionListener(this);
		add(back);
		
		try {
			
			Conn c = new Conn();
			ResultSet rs =	c.s.executeQuery("select * from account where username ='"+username+"'");
			while(rs.next()) {
				fusername.setText(rs.getString("username"));
				fname.setText(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
		String rusername = fusername.getText();
		String id = (String) comboid.getSelectedItem();
		String number = tnumber.getText();
		String name = fname.getText();
		String gender = null;
		if(rmale.isSelected()) {
			gender="Male";
		}else {
			gender="Female";
		}
		String country = tcountry.getText();
		String address = taddress.getText();
		String phone = tphone.getText();
		String email = temail.getText();
		
		try {
			
			Conn c = new Conn();
			String query = "insert into customer values('"+rusername+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
			c.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Customer Added Succesfully!");
			setVisible(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
	
		new adduser("username");
	}

}
