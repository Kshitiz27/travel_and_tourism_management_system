package travelsystem;

import java.awt.Image;

import javax.swing.*;

public class Splash extends JFrame implements Runnable{
	
	Thread thread;
	private static final long serialVersionUID = 1L;

	Splash(){
//		setLocation(200, 50);
//		setSize(1000,500);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		setVisible(true);
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		try {
		Thread.sleep(7000);
		setVisible(false);
		}catch(Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) {
	
		Splash frame = new Splash();
		
		int x = 1;
		for(int i=1; i<=500; x+=7, i+=6) {
		frame.setLocation(650-(x+i)/2,(400-(i/2))-70);
		frame.setSize(x+i, i);
		try {
			Thread.sleep(5);
		} catch (Exception e) {
		
		}
		}
	}

}
