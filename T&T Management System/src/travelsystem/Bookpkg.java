package travelsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Bookpkg extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	
	Choice selectpkg;
	JLabel spkg,ftprice,fusername,fid,fnumber,fphn;
	JTextField ttp;
	JButton checkprice,bookpackage,back;
	String username;
	Bookpkg(String username){
		this.username=username;
		setBounds(300, 100, 700, 400);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel tusername = new JLabel("Username");
		tusername.setBounds(30, 30, 120, 20);
		add(tusername);
		
		fusername = new JLabel();
		fusername.setBounds(170, 30, 150, 20);
		add(fusername);
		
		spkg = new JLabel("Select Package");
		spkg.setBounds(30, 70, 120, 20);
		add(spkg);
		
		selectpkg = new Choice();
		selectpkg.setBounds(170,70,150,20);
		selectpkg.setBackground(Color.black);
		selectpkg.setForeground(Color.white);
		selectpkg.setFont(new Font("Tahoma",Font.BOLD,12));
		selectpkg.add("GOLD PACKAGE");
		selectpkg.add("SILVER PACKAGE");
		selectpkg.add("PLATINUM PACKAGE");
		add(selectpkg);
		
		JLabel tp = new JLabel("Total Person");
		tp.setBounds(30, 110, 120, 20);
		add(tp);
		
		ttp = new JTextField();
		ttp.setBounds(170, 110, 150, 20);
		add(ttp);
		
		JLabel id = new JLabel("ID");
		id.setBounds(30, 150, 120, 20);
		add(id);
		
		fid = new JLabel();
		fid.setBounds(170, 150, 150, 20);
		add(fid);
		
		JLabel number = new JLabel("ID Number");
		number.setBounds(30, 190, 120, 20);
		add(number);
		
		fnumber = new JLabel();
		fnumber.setBounds(170, 190, 150, 20);
		add(fnumber);
		
		JLabel phn = new JLabel("Phone");
		phn.setBounds(30, 230, 120, 20);
		add(phn);
		
		fphn = new JLabel();
		fphn.setBounds(170, 230, 150, 20);
		add(fphn);
		
		JLabel tprice = new JLabel("Total Price");
		tprice.setBounds(30, 270, 120, 20);
		add(tprice);
		
		ftprice = new JLabel();
		ftprice.setBounds(170, 270, 150, 20);
		add(ftprice);
		
		checkprice = new JButton("CHECK PRICE");
		checkprice.setBounds(30, 310, 120, 30);
		checkprice.setBackground(Color.black);
		checkprice.setForeground(Color.white);
		checkprice.setFont(new Font("Tahoma",Font.BOLD,10));
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookpackage = new JButton("BOOK PACKAGE");
		bookpackage.setBounds(170, 310, 120, 30);
		bookpackage.setBackground(Color.black);
		bookpackage.setForeground(Color.white);
		bookpackage.setFont(new Font("Tahoma",Font.BOLD,10));
		bookpackage.addActionListener(this);
		add(bookpackage);
		
		back = new JButton("BACK");
		back.setBounds(310, 310, 120, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("Tahoma",Font.BOLD,10));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i2 =i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250, 30, 500, 250);
		add(image);
		
		
		
		
		try {
			
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'";
			ResultSet rs =c.s.executeQuery(query);
			while(rs.next()) {
				fusername.setText(rs.getString("username"));
				fid.setText(rs.getString("id"));
				fnumber.setText(rs.getString("id_number"));
				fphn.setText(rs.getString("phone"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==checkprice) {
			
			String pack = selectpkg.getSelectedItem();
			int cost = 0;
			if(pack.equals("GOLD PACKAGE")) {
				cost+=20000;
			}
			else if(pack.equals("SILVER PACKAGE")) {
				cost+=12000;
			}
			else {
				cost+=18000;
			}
			int persons = Integer.parseInt(ttp.getText());
			cost*=persons;
			ftprice.setText("Rs. "+cost);
			
		}else if(ae.getSource()==bookpackage) {
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookpackage value('"+fusername.getText()+"', '"+selectpkg.getSelectedItem()+"', '"+ttp.getText()+"', '"+fid.getText()+"', '"+fnumber.getText()+"', '"+fphn.getText()+"', '"+ttp.getText()+"')");
			
			JOptionPane.showMessageDialog(null, "Your package has been booked successfully!");
			setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Bookpkg("kshitiz");
	}

}
