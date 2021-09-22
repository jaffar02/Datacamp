package Java_Graphics_Build;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class Workspace extends javax.swing.JFrame implements ActionListener{
    public Workspace() throws SQLException, ClassNotFoundException {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                     
    private void initComponents() throws SQLException, ClassNotFoundException {
            Object[] column = {"Names", "Class", "ID", "Marks Obtained", "Total Marks"};
            
    
    
    
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        enterName = new javax.swing.JTextField();
        classLabel = new javax.swing.JLabel();
        enterClass = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        enterID = new javax.swing.JTextField();
        marksObtainedLabel = new javax.swing.JLabel();
        enterMarksObtained = new javax.swing.JTextField();
        totalMarksLabel = new javax.swing.JLabel();
        enterTotal = new javax.swing.JTextField();
        AddRecordButton = new javax.swing.JButton();
        DelRecordButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Logout = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataCamp wokrspace");
        setIconImages(null);
        setLocation(new java.awt.Point(240, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        nameLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        nameLabel.setText("Name: ");

        classLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        classLabel.setText("Class:");

        idLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        idLabel.setText("ID:");

        marksObtainedLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        marksObtainedLabel.setText("Marks obtained:");

        totalMarksLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        totalMarksLabel.setText("Total Marks:");

        
         //table properties
        jTable1.setModel(model);
        model.setColumnIdentifiers(column);
        jTable1.setRowHeight(30);
        jTable1.setAutoCreateRowSorter(true);
        JScrollPane pane = new JScrollPane();
        pane.setForeground(Color.white);
        
        pane.setBounds(10, 10, 10, 10);
          jPanel3.add(pane);
        
          
           try {   
                     fetchRecord();
                 } catch (SQLException ex) {
                     System.out.println("Database empty!! Enter some data."+ ex);
                 }
        //sql setup
        Class.forName("com.mysql.jdbc.Driver");
        
        AddRecordButton.setText("Add Record");
        AddRecordButton.setBackground(Color.white);
        AddRecordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddRecordButton.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ev){
        
            int CLASS = Integer.parseInt(enterClass.getText());
            int ID = Integer.parseInt(enterID.getText());
            int Omarks = Integer.parseInt(enterMarksObtained.getText());
            int Tmarks = Integer.parseInt(enterTotal.getText());
            String gname = enterName.getText();
                
        data[0] =  enterName.getText();
        data[1] =  CLASS;
        data[2] =  ID;
        data[3] =  Omarks;
        data[4] =  Tmarks;
       model.addRow(data);
       String Query = "insert into studData1 values (?,?,?,?,?)";
                 try {
                    
                    
                     PreparedStatement pstmnt = con.prepareStatement(Query);
                     
                     pstmnt.setString(1, gname);
                     pstmnt.setInt(2, CLASS);
                      pstmnt.setInt(3, ID);
                       pstmnt.setInt(4, Omarks);
                        pstmnt.setInt(5, Tmarks);
                       
                    
                     pstmnt.executeUpdate();
                 } catch (SQLException ex) {
                     Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }    
        });
        
        

        DelRecordButton.setText("Delete Record");
        DelRecordButton.setBackground(Color.white);
        DelRecordButton.setPreferredSize(new java.awt.Dimension(89, 23));
        DelRecordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelRecordButton.addActionListener(this); 

        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(classLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterClass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(idLabel)
                        .addGap(18, 18, 18)
                        .addComponent(enterID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(marksObtainedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterMarksObtained))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           // .addComponent(SaveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(totalMarksLabel)
                                .addGap(0, 8, Short.MAX_VALUE))
                            .addComponent(AddRecordButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                //.addComponent(LoadButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(DelRecordButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(enterName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(classLabel)
                    .addComponent(enterClass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(enterID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterMarksObtained, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marksObtainedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalMarksLabel)
                    .addComponent(enterTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   
                ))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 128, 44));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Record System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Logout.setText("Logout");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenu1.add(Logout);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exit.setText("Exit");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addActionListener((java.awt.event.ActionEvent evt) -> {
            exitActionPerformed(evt);
            });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        
                JPanel north = new JPanel();
                frame1.setBounds(300,40,300,300);
                north.setBackground(Color.white);
                JPanel centre = new JPanel();
                centre.setBackground(Color.white);
                centre.setPreferredSize(new Dimension(100,50));
                frame1.add(north, BorderLayout.NORTH);
                frame1.add(centre, BorderLayout.CENTER);
                JLabel msg = new JLabel("Enter the ID of student to remove");
                north.add(msg);
                delID.setPreferredSize(new Dimension(50,30));
                centre.add(delID);
                enter.addActionListener(this);
                
                centre.add(enter);
                frame1.pack();
                frame1.setVisible(false);
        
                
            
               
        
        
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Java_Graphics_Build/icons/myimg.png"));
        this.setIconImage(image.getImage());
        this.setResizable(false);
        pack();
    }            

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
                    System.exit(0);
    }                                    

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {                                       
        dispose();    
        new AskLogin();
    }                                      

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Workspace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workspace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workspace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workspace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    */
    public void fetchRecord() throws SQLException{
         //Fetch old databse content
    String FetchQuery = "select * from studData1";
    PreparedStatement fetchData = con.prepareStatement(FetchQuery);
    ResultSet rset;
        rset = fetchData.executeQuery(FetchQuery);
        
    while(rset.next()){
    
        data[0] = rset.getString(1);
        data[1] = rset.getInt(2);
        data[2] = rset.getInt(3);
        data[3] = rset.getInt(4);
        data[4] = rset.getInt(5);
        model.addRow(data);
    }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddRecordButton;
    private javax.swing.JButton DelRecordButton;
   
    private javax.swing.JMenuItem Logout;
    Object[] data = new Object[5];
    private javax.swing.JLabel classLabel;
    private javax.swing.JTextField enterClass;
    private javax.swing.JTextField enterID;
    private javax.swing.JTextField enterMarksObtained;
    private javax.swing.JTextField enterName;
    private javax.swing.JTextField enterTotal;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel idLabel;
    int getID;
    JButton enter = new JButton("Enter");
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    JTextField delID = new JTextField();
    int getSelectedRow1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    DefaultTableModel model = new DefaultTableModel();
    private javax.swing.JLabel marksObtainedLabel;
    private javax.swing.JLabel nameLabel;
    JFrame frame1 = new JFrame("Input");
    //Just fetchdata 
    String tabName;
    int tabClass, tabID, tabMOB, tabTM;
            //
     
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysetup","root","jaffar02");
    private javax.swing.JLabel totalMarksLabel;
    // End of variables declaration                 
    
    
    
        

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==DelRecordButton){
            int getSelectedRow1 = jTable1.getSelectedRow();
           int rowcheck =  jTable1.getRowCount();
            if(rowcheck<=0){
              JOptionPane.showMessageDialog(null, "Nothing to delete!!", "Error", JOptionPane.ERROR_MESSAGE);  
            }
            else{
            frame1.setVisible(true);
            }
            } 
        else if(e.getSource()==enter){      
                        frame1.dispose();
                       
                       if(delID.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter value please");
                       }
                       else{
                    String check = "select * from studData1 where id = "+Integer.parseInt(delID.getText())+"";
                            try {
                                Statement st = con.createStatement();
                                ResultSet rst = st.executeQuery(check);
                                if(rst.next()){
                                    if(getSelectedRow1>=0){
                 model.removeRow(getSelectedRow1+1);
                 
                }
                 else{
                    JOptionPane.showMessageDialog(null, "Nothing to delete!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Entered data is wrong","Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
                            }
                
                int id = Integer.parseInt(delID.getText());
                String delQuery = "delete from studData1 where id = "+id+"";
                try {
                        PreparedStatement st = con.prepareStatement(delQuery);
                        st.executeUpdate();
                
                    } catch (SQLException ex) {
                        Logger.getLogger(Workspace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        getID = Integer.parseInt(delID.getText());
        }
        }
    }
}
