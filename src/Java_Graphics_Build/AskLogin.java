package Java_Graphics_Build;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AskLogin implements ActionListener{
	JButton CreateAccount  = new JButton("Create Account");
	JButton Login = new JButton("Login");
	JFrame frame= new JFrame();
 public AskLogin() {
	 
		frame.setBounds(380, 80, 600, 600);
		frame.setResizable(false);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		panel1.setPreferredSize(new Dimension(100,110));
		panel2.setPreferredSize(new Dimension(100,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,70));
		panel5.setPreferredSize(new Dimension(100,100));
		
		
		panel1.setBackground(Color.white); //Top
		panel2.setBackground(Color.white);	//Right
		panel3.setBackground(Color.white); //Left
		panel4.setBackground(Color.white);	//Bottom
		panel5.setBackground(Color.white); //Center
		
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.EAST);
		frame.add(panel3,BorderLayout.WEST);
		frame.add(panel4,BorderLayout.SOUTH);
		frame.add(panel5,BorderLayout.CENTER);
		
		//panel1
		panel1.setLayout(new FlowLayout());
		JLabel label1 = new JLabel();
		label1.setText("Data");
		label1.setFont(new Font("SansSerif",Font.BOLD,100));
		label1.setForeground(new Color(25,178,255));
		panel1.add(label1);
		
		JLabel label2 = new JLabel();
		label2.setText("Camp");
		label2.setFont(new Font("SansSerif",Font.BOLD,50));
		label2.setForeground(new Color(124,86,166));
		panel1.add(label2);
		
		//panel5
		panel5.setLayout(new BorderLayout());
		
		//Ineer pannels of panel5
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		
		panel6.setPreferredSize(new Dimension(30,80));
		panel7.setPreferredSize(new Dimension(30,50));
		panel8.setPreferredSize(new Dimension(30,50));
		panel9.setPreferredSize(new Dimension(30,50));
		panel10.setPreferredSize(new Dimension(30,50));
		
		
		panel6.setBackground(Color.white); //Top
		panel7.setBackground(Color.white);	//Right
		panel8.setBackground(Color.white); //Left
		panel9.setBackground(Color.white);	//Bottom
		panel10.setBackground(Color.white); //Center
		
		panel5.add(panel6,BorderLayout.NORTH);
		panel5.add(panel7,BorderLayout.EAST);
		panel5.add(panel8,BorderLayout.WEST);
		panel5.add(panel9,BorderLayout.SOUTH);
		panel5.add(panel10,BorderLayout.CENTER);
		
		//panel6
		panel6.setLayout(new FlowLayout(0,0,45));
		JLabel info = new JLabel("Please select an option ");
		info.setFont(new Font("Sans",Font.PLAIN,17));
		info.setPreferredSize(new Dimension(380,20));
		panel6.add(info);
		
		//panel10
		panel10.setLayout(new FlowLayout(50,90,15));
		CreateAccount.setFocusable(false);
		CreateAccount.setPreferredSize(new Dimension(130,40));
		CreateAccount.setBackground(Color.white);
		CreateAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
		CreateAccount.addActionListener(this);
		panel10.add(CreateAccount);
		
		Login.setPreferredSize(new Dimension(130,40));
		Login.setFocusable(false);
		Login.setBackground(Color.white);
		Login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Login.addActionListener(this);
		panel10.add(Login);
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Java_Graphics_Build/icons/myimg.png"));
		frame.setIconImage(image.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
 }
 public void actionPerformed(ActionEvent ev) {
	 if(ev.getSource()==CreateAccount) {
		 frame.dispose();
		 new CreateAccountPage();
	 }
	 else if(ev.getSource()==Login) {
		 frame.dispose();
		 new FormLogin();
	 }
 }
}
