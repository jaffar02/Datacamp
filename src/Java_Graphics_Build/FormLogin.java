package Java_Graphics_Build;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FormLogin implements ActionListener{
	JButton Back = new JButton("Back");
	JButton loginButton = new JButton("Login");
	public JFrame frame = new JFrame();
	public JPasswordField enterPass = new JPasswordField();
	public JTextField enterUser = new JTextField();
	JCheckBox showpass = new JCheckBox();
	JLabel incorrect = new JLabel("username or password wrong!!");
	

	
	public FormLogin() {
		frame.setBounds(380, 80, 600, 600);
		frame.setResizable(false);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		panel1.setPreferredSize(new Dimension(100,150));
		panel2.setPreferredSize(new Dimension(100,100));
		panel3.setPreferredSize(new Dimension(90,100));
		panel4.setPreferredSize(new Dimension(100,70));
		panel5.setPreferredSize(new Dimension(100,100));
		
		
		panel1.setBackground(Color.white); //Top
		panel2.setBackground(Color.white);	//Right
		panel3.setBackground(Color.white); //Left
		panel4.setBackground(Color.white);	//Bottom
		panel5.setBackground(Color.white); //Center
		
		//Logo section
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
				
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.EAST);
		frame.add(panel3,BorderLayout.WEST);
		frame.add(panel4,BorderLayout.SOUTH);
		frame.add(panel5,BorderLayout.CENTER);
		
		//panel4
		Back.setFont(new Font("SansSerif",Font.PLAIN,15));
		Back.setBackground(Color.white);
		Back.addActionListener(this);
		Back.setFocusable(false);
		panel4.setLayout(new FlowLayout(FlowLayout.LEADING,40,20));
		panel4.add(Back);
		
		//panel5 properties
				panel5.setLayout(new BorderLayout());
				
				//Ineer pannels of panel5
				JPanel panel6 = new JPanel();
				JPanel panel7 = new JPanel();
				JPanel panel8 = new JPanel();
				JPanel panel9 = new JPanel();
				JPanel panel10 = new JPanel();
				
				panel6.setPreferredSize(new Dimension(30,130));
				panel7.setPreferredSize(new Dimension(135,50));
				panel8.setPreferredSize(new Dimension(135,50));
				panel9.setPreferredSize(new Dimension(30,180));
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
		//Username
		JLabel Username = new JLabel("Username: ");
		Username.setFont(new Font("SansSerif",Font.BOLD,13));
		panel6.add(Username);
		
		enterUser.setPreferredSize(new Dimension(260,25));
		panel6.add(enterUser);
		
		//Password
		JLabel password = new JLabel("Password: ");
		password.setFont(new Font("SansSerif",Font.BOLD,13));
		panel6.add(password);
		
		enterPass.setPreferredSize(new Dimension(170,25));
		panel6.add(enterPass);
		
		//Login Button
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.white);
		loginButton.addActionListener(this);
		//loginButton.setPreferredSize(new Dimension(50,30));
		panel5.add(loginButton);
	
		//Show pass
		showpass.setText("Show Password");
		showpass.setBackground(Color.white);
		showpass.addActionListener(this);
		panel6.add(showpass);
		
		//wrong pass or uname
		incorrect.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
		incorrect.setForeground(Color.red);
		
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Java_Graphics_Build/icons/myimg.png"));
		frame.setIconImage(image.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==Back) {
			frame.dispose();
			new AskLogin();
		}
		else if(ev.getSource()==showpass) {
			if(showpass.isSelected()) {
				enterPass.setEchoChar((char)0);
			}
			else {
				enterPass.setEchoChar('*');
			}
		}
		else if(ev.getSource()==loginButton) {
			String usrname = enterUser.getText(), pass = String.valueOf(enterPass.getPassword());
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysetup", "root", "jaffar02");
				String myQuery = "Select * from createaccount where Username = '"+usrname+"' and Password = '"+pass+"'";	//this is our query which wil be executed in mysql server
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(myQuery);
			if(rs.next()) { //rs.next() will increment the index to check other values
				frame.dispose();
				new Workspace().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Username or Password wrong!!", "Validation Error", JOptionPane.ERROR_MESSAGE);
			}
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Class Not Found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
