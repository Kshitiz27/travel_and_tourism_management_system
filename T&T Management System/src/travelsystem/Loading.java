package travelsystem;

import java.awt.*;

import javax.swing.*;

public class Loading extends JFrame implements Runnable{
	
	Thread t;
	
	JProgressBar bar;
	private static final long serialVersionUID = 1L;
	static String username;

	public void run() {
		for(int i = 1; i<=101; i++) {
			try {
				int max = bar.getMaximum();
				int val = bar.getValue();
				
				if(val<max) {
					bar.setValue(bar.getValue()+1);
				}
				else {
					setVisible(false);
					new Dashboard(username);
				}
				
				Thread.sleep(50);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	Loading(String username){
		Loading.username=username;
		t = new Thread(this);
		
		setBounds(200, 130, 900, 460);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head =  new JLabel("Travel & Tourism System Application");
		head.setBackground(Color.black);
		head.setBounds(240,20,600,60);
		head.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(head);
		
		bar = new JProgressBar();
		bar.setBounds(250,100,357,35);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel loading =  new JLabel("Loading...Please Wait !");
		loading.setBounds(350, 140, 500, 30);
		loading.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(loading);
		
		JLabel username1 = new JLabel("Welcome! " + username);
		username1.setBounds(50, 350, 400, 30);
		username1.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(username1);
		
		t.start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Loading(username);

	}

}
