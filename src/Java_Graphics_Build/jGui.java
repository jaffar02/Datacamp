package Java_Graphics_Build;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
public class jGui implements ActionListener{
	//Decelerations
	JButton button1 = new JButton("Next");	
	 JButton button3 = new JButton("About");
	 JFrame frame = new JFrame("Data Camp");
	
	public jGui() {
		initUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button3){
		JOptionPane.showMessageDialog(null, "Developer: Mr.Jaffar \nJava Version: JDK 16 \nApplication type: Single User \nDate of production: 20/7/2021 \nMade with Eclipse \n\n\nAll rights reserved", "About Us",JOptionPane.INFORMATION_MESSAGE);
	} 
	
		else if(e.getSource()==button1){
			frame.dispose();
			@SuppressWarnings("unused")
			AskLogin instance = new AskLogin();
		}
	}
	
	public void initUI() {		
		//Frame main
		frame.setLayout(new BorderLayout());
		frame.setBounds(380, 80, 600, 600);
		frame.setResizable(false);
		//Panels
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
		panel2.setBackground(Color.WHITE);	//Right
		panel3.setBackground(Color.WHITE); //Left
		panel4.setBackground(Color.WHITE);	//Bottom
		panel5.setBackground(Color.WHITE); //Center
		
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
		JLabel label3 = new JLabel();
		ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("Java_Graphics_Build/icons/Panel img.png"));
		label3.setIcon(image2);
		panel5.add(label3);
		
		//panel4 ------------->About button
		
		button3.setFocusable(false);
		button3.setFont(new Font("Serif",Font.PLAIN,25));
		button3.setBackground(Color.white);
		button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button3.addActionListener(this);
		panel4.add(button3);
		
		//Invisible button for spacing
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton Space = new JButton();
		Space.setVisible(true);
		Space.setPreferredSize(new Dimension(340,0));
		panel4.add(Space);
		
		//panel4 ------------->NEXT button
				
				button1.setFocusable(false);
				button1.setFont(new Font("Serif",Font.PLAIN,25));
				//Border border = BorderFactory.createLineBorder(Color.gray,1);
				button1.setBackground(Color.white);
				//button1.setBorder(border);
				ImageIcon image3 = new ImageIcon(ClassLoader.getSystemResource("Java_Graphics_Build/icons/Next button.png"));
				button1.setIcon(image3);
				button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				button1.setHorizontalTextPosition(JButton.LEFT);
				button1.addActionListener(this);
				panel4.add(button1);
			
		
                                
                                
                                
		//image icon
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Java_Graphics_Build/icons/myimg.png"));
		frame.setIconImage(image.getImage());
		
		//Events for About Button
		
		//main frame property
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		jGui start = new jGui();
	}
	

}
