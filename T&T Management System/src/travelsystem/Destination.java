package travelsystem;

import java.awt.*;

import javax.swing.*;

public class Destination extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	Thread n1;
	JLabel t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JLabel[] t = new JLabel[] {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10}; 
	JLabel caption;
	
	public void run() {
		String[] text = new String[] {"INDIA","INDIA","INDIA","INDIA","INDIA","INDIA","INDIA","INDIA","INDIA","INDIA",};
		try {
			for(int i=0; i<=8; i++) {
			caption.setText(text[i]);
			t[i].setVisible(true);
			Thread.sleep(2500);
			t[i].setVisible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Destination(){
		setBounds(300, 50, 700, 600);
		
		caption =  new JLabel();
		caption.setBounds(50, 450, 800, 100);
		caption.setFont(new Font("Tahoma", Font.BOLD, 40));
		caption.setForeground(Color.WHITE);
		add(caption);
		
		ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,i9=null,i10=null;
		ImageIcon[] img = new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};
		
		Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
		Image[] j = new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
		
		ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null,k9=null,k10=null;
		ImageIcon[] k = new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};
		
		for(int i=0; i<=8; i++) {
		img[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
		j[i]= img[i].getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
		k[i] = new ImageIcon(j[i]);
		t[i] = new JLabel(k[i]);
		t[i].setBounds(0, 0, 700, 600);
		add(t[i]);
		}
		
		n1= new Thread(this);
		n1.start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Destination();
	}
	
}
