package Java_Graphics_Build;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class CreateAccountPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton Back = new JButton("Back");
	JButton proceedCreation = new JButton("Create Account");
	JCheckBox checkit = new JCheckBox();
	JPasswordField enterPass = new JPasswordField();
	JTextField enterName = new JTextField();
	public JTextField enterUserName = new JTextField();
	JCheckBox showpass = new JCheckBox();
	
	
	public CreateAccountPage() {
		frame.setBounds(380, 80, 600, 600);
		frame.setResizable(false);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		panel1.setPreferredSize(new Dimension(100,150));
		panel2.setPreferredSize(new Dimension(10,100));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,70));
		panel5.setPreferredSize(new Dimension(100,100));
		
		
		panel1.setBackground(Color.white); //Top
		panel2.setBackground(Color.white);	//Right
		panel3.setBackground(Color.white); //Left
		panel4.setBackground(Color.WHITE);	//Bottom
		panel5.setBackground(Color.WHITE); //Center
		
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.EAST);
		frame.add(panel3,BorderLayout.WEST);
		frame.add(panel4,BorderLayout.SOUTH);
		frame.add(panel5,BorderLayout.CENTER);
		
		panel5.setLayout(new BorderLayout());
		
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		
		panel6.setPreferredSize(new Dimension(30,130));
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
		
		panel6.setLayout(new FlowLayout(FlowLayout.LEADING));;
		
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
				
				//Full name
		JLabel name = new JLabel("Enter full name: ");
				name.setFont(new Font("SansSerif",Font.BOLD,13));
				panel6.add(name);
				
		//name field
				enterName.setPreferredSize(new Dimension(260,25));
				panel6.add(enterName);
				
				//User name
				JLabel Username = new JLabel("Enter username: ");
				Username.setFont(new Font("SansSerif",Font.BOLD,13));
				panel6.add(Username);
				
	//username field
		enterUserName.setPreferredSize(new Dimension(260,25));
				panel6.add(enterUserName);
				
				//Password
		JLabel pass = new JLabel("Create Password: ");
				pass.setFont(new Font("SansSerif",Font.BOLD,13));
				panel6.add(pass);
				
		//passwordfield
		enterPass.setPreferredSize(new Dimension(170,25));
				panel6.add(enterPass);
		//show password
		showpass.setText("Show Password");
		showpass.setBackground(Color.white);
		showpass.addActionListener(this);
		panel6.add(showpass);
				//checkbox
		checkit.setText("You hereby accpet user terms and condition.");
		checkit.addActionListener(this);
		
		panel6.add(checkit);
		
			//CreateAccount button
		proceedCreation.setPreferredSize(new Dimension(130,30));
		proceedCreation.setBackground(Color.white);
		proceedCreation.setEnabled(false);
		proceedCreation.addActionListener(this);
		panel10.add(proceedCreation);
		
		//Back button
		Back.setFont(new Font("SansSerif",Font.PLAIN,15));
		Back.setBackground(Color.white);
		Back.addActionListener(this);
		Back.setFocusable(false);
		panel4.setLayout(new FlowLayout(FlowLayout.LEADING,40,20));
		panel4.add(Back);
		
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
		else if(ev.getSource()==checkit) {
			if(checkit.isSelected()) {
				proceedCreation.setEnabled(true);
			}
			else {
				proceedCreation.setEnabled(false);
			}
		}
		
		else if(ev.getSource()==proceedCreation) {
			String getPass = String.valueOf(enterPass.getPassword());
			if(enterName.getText().equals("")||enterUserName.getText().equals("")||getPass.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter all fields!!","Error",JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysetup","root","jaffar02");
					String delEntries = "DELETE from createaccount";
					PreparedStatement DelEnt = con.prepareStatement(delEntries);
					DelEnt.executeUpdate();
					String sql = "insert into createaccount values (?,?,?)";
					PreparedStatement pstmnt = con.prepareStatement(sql);
					pstmnt.setString(1, enterName.getText());
					pstmnt.setString(2, enterUserName.getText());
					pstmnt.setString(3, getPass);
					pstmnt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Account created successfully","Info", JOptionPane.INFORMATION_MESSAGE);
					con.close();
					frame.dispose();
					new AskLogin();
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
	}
}
