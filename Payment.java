package businesscard;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class Payment extends JFrame
{
	GradientPanel p1;
	JPanel p2;
	JLabel l1,l2,title,l3,l4;
	JTextField tf1,tf2,tf3;
	JButton b1,b2;
	Font f1;
	Main main;
	RFID rfid;
	String id;
public Payment(Main ma,String sid){
	super("Payment Screen");
	main = ma;
	id = sid;
	p1 = new GradientPanel(600,200);
	p1.setLayout(null);
	
	f1 = new Font("Courier New",Font.BOLD,14);
	p2 = new TitlePanel(600,60);
	p2.setBackground(new Color(204, 110, 155));
	title = new JLabel("<HTML><BODY><CENTER>UNIVERSAL BUSINESS CARD USING RFID</CENTER></BODY></HTML>");
	title.setForeground(Color.white);
	title.setFont(new Font("Times New ROMAN",Font.PLAIN,17));
	p2.add(title);

	l3 = new JLabel("Payment Screen");
	l3.setFont(new Font("Courier New",Font.BOLD,13));
	l3.setBounds(250,20,200,30);
	p1.add(l3);

	l1 = new JLabel("Shopkeeper ID");
	l1.setFont(f1);
	l1.setBounds(150,60,200,30);
	p1.add(l1);
	tf1 = new JTextField();
	tf1.setText(id);
	tf1.setEditable(false);
	tf1.setFont(f1);

	tf1.setBounds(300,60,130,30);
	p1.add(tf1);
	
	l2 = new JLabel("Customer Card");
	l2.setFont(f1);
	l2.setBounds(150,110,200,30);
	p1.add(l2);
	tf2 = new JTextField();
	tf2.setFont(f1);
	tf2.setBounds(300,110,130,30);
	p1.add(tf2);
	
	l4 = new JLabel("Amount");
	l4.setFont(f1);
	l4.setBounds(150,160,200,30);
	p1.add(l4);
	tf3 = new JTextField(15);
	tf3.setFont(f1);
	tf3.setBounds(300,160,130,30);
	p1.add(tf3);

	
	b2 = new JButton("Logout");
	b2.setFont(f1);
	b2.setBounds(220,210,80,30);
	p1.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			rfid.close();
			setVisible(false);
			main.setVisible(true);
		}
	});

	getContentPane().add(p1,BorderLayout.CENTER);
	getContentPane().add(p2,BorderLayout.NORTH);

	rfid = new RFID(this);
	rfid.setPort("COM1");
	rfid.setRate(9600);
	rfid.initialize();
}
public void clear(){
	tf2.setText("");
	tf3.setText("");
}
}
