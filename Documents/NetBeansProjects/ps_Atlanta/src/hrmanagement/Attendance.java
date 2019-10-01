/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrmanagement;



import database.DBConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Haran
 */
public class Attendance extends javax.swing.JFrame {
    private Thread th;
    private Connection con;
    private Statement st;
    private String uType;
    private PreparedStatement ps;
    private ResultSet rs,rs1;
    private boolean morning=false;
    private  boolean evening=false;
      private DefaultTableModel model;
    int dates;
    String id;
    /**
     * Creates new form Attendance
     */
    
    public void setType(String name){
        this.uType=name;
    }
    public Attendance() {
        
        initComponents();
   
        attendence_emp_error.setText("");
        la_text.setText("");
        try{
        con=DBConnection.ConnectionDB();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Database not Connected");
        }
        
        //Lamda function
        th=new Thread(()->{
        
            while(true){
                
                 DateFormat time = new SimpleDateFormat("HH:mm:ss");//Time Format
        
                 Date timeformat = new Date();//get current time
                 la_time.setText(time.format(timeformat));//set current time to simple time format
                 
                 DateFormat date = new SimpleDateFormat("yyyy/MM/dd");//Date format
                 Date dateformat=new Date();//get current Date
                 la_Date.setText(date.format(dateformat));//set current Date to simple Date Format
                 
                 
                  DateFormat date1 = new SimpleDateFormat("dd");
                   Date dateformat1=new Date();
                  dates=Integer.parseInt(date1.format(dateformat));
                  
                  int timesystem=Integer.parseInt(la_time.getText().substring(0,2));//get hours
                  //if time between 1AM to 12PM
                    if(timesystem>=1 && timesystem<=12)
                    {
                        morning=true;
                        evening=false;

                        txt_username.setEnabled(true);
                        txt_password.setEnabled(true);
                        bt_login.setEnabled(true);
                        bt_cancel.setEnabled(true);
                    }
        
                    //if the time between 1AM to 11PM
                    else if(timesystem>=13 && timesystem<=23)
                    {
                        morning=false;
                        evening=true;

                        txt_username.setEnabled(true);
                        txt_password.setEnabled(true);

                        bt_login.setEnabled(true);
                        bt_cancel.setEnabled(true);
                    }
                    //if the day end
                    else
                    {
                        txt_username.setEnabled(false);
                        txt_password.setEnabled(false);

                        bt_login.setEnabled(false);
                        bt_cancel.setEnabled(false);

                        la_text.setText("Not allowed to login");
                    }    
            }
        
        
        
        });
         th.start();
         String sql = "SELECT * FROM daily_attendance";
 

        try
        {
            
            st = con.createStatement();
            rs = st.executeQuery(sql);
 
            int rows=0;
            while(rs.next())
            {
                rows++;
                String idd = rs.getString(1);
                id="DA"+(Integer.parseInt(idd.substring(2,9))+1);
            }
            if(rows<1)
            {
                id="DA1111111";
            }
        }
        catch(SQLException ex)
        {
            id="DA1111111";
        }
        finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        la_Date = new javax.swing.JLabel();
        la_time = new javax.swing.JLabel();
        la_text = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        bt_login = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendence_table = new javax.swing.JTable();
        employee_id_search = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        attendence_emp_error = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("UserName");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Password");

        la_Date.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        la_Date.setText("Date");

        la_time.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        la_time.setText("Time");

        la_text.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        la_text.setText("Text");

        bt_login.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        bt_login.setText("Login");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        bt_cancel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        bt_cancel.setText("Cancel");

        attendence_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(attendence_table);

        employee_id_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employee_id_searchKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Employee_id");

        attendence_emp_error.setForeground(new java.awt.Color(255, 0, 0));
        attendence_emp_error.setText("Error");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(la_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_login)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_cancel)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(la_time))
                    .addComponent(la_text)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employee_id_search, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attendence_emp_error, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(137, 137, 137)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel3)
                            .addComponent(employee_id_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attendence_emp_error)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(la_Date)
                            .addComponent(la_time))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addComponent(la_text)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_cancel)
                            .addComponent(bt_login))
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Employee Attendence");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        if(txt_username.getText().isEmpty() || txt_password.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Input Your UserName or Password");
        }
        else
        {
            boolean login=false;
            String sql1 = "SELECT * FROM login_employee";
            try
            {
               st = con.createStatement();
               rs = st.executeQuery(sql1);

                int count = 0;

                while (rs.next())
                {
                    if(txt_username.getText().equals(rs.getString(2)) && txt_password.getText().equals(rs.getString(3)))
                    {
                        login=true;
                        st.close();
                        rs.close();
                        break;
                    }
                    else
                    {
                        login=false;
                    }
                }
                
                if(login)
                {
                    int rows1=0;
                    String sql3 = "SELECT * FROM `daily_attendance` WHERE `Employeeid`='"+txt_username.getText()+"'";

                    try
                    {
                        st= con.createStatement();
                        rs = st.executeQuery(sql3);


                        
                        while(rs.next())
                        {
                            rows1++;
                        }
                    }
                    catch(SQLException ex)
                    {
                        
                    }
                    finally{
                        st.close();
                        rs.close();
                    }
                    
                    
                    int rowsInserted=0;
                    if(morning ==true && evening ==false )
                    {
                        if(rows1<1)
                        {
                            la_text.setText("Login Successfuly");
                            try
                            {
                                double day=0;
                                if(Integer.parseInt(la_time.getText().substring(0,2))>9)
                                {
                                
                                    day=0.5;
                                }
                                else
                                {
                                    day=1;
                                }
                                String sql = "INSERT INTO `daily_attendance` (`id`,`EnteredTime`,`LeavedTime`,`Day`,`Employeeid`) VALUES (?, ?, ?, ?, ?)";
                                ps = con.prepareStatement(sql);
                                ps.setString(1,id);
                                ps.setString(2,la_time.getText().toString());
                                ps.setString(3,"");
                                ps.setDouble(4,day);
                                ps.setString(5,txt_username.getText());

                
                                rowsInserted = ps.executeUpdate();
                
                        
                            }
                            catch(SQLException ex)
                            {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                            finally{
                                ps.close();
                            }
                            if (rowsInserted > 0)
                            {
                                JOptionPane.showMessageDialog(null,"Login successfully! Welcome ");
                                    
                                String sql2 = "SELECT * FROM daily_attendance";

                                try
                                {

                                    st = con.createStatement();
                                    rs = st.executeQuery(sql2);
                                   


                                    int rows=0;
                                    while(rs.next())
                                    {
                                        rows++;
                                        String idd = rs.getString(1);
                                       
                                        id="DA"+(Integer.parseInt(idd.substring(2,9))+1);
                                    }
                                    if(rows<0)
                                    {
                                        id="DA1111111";
                                    }
                                }
                                catch(SQLException ex)
                                {
                                    id="DA1111111";
                                }
                                finally{
                                    rs.close();
                                    st.close();
                                }
                                 try
                                {

                                    st = con.createStatement();
                                    rs = st.executeQuery(sql2);
                                    attendenceTableShow(rs);



                                }
                                catch(SQLException ex)
                                {

                                }
                                finally{
                                    rs.close();
                                    st.close();
                                }
                          
                            }
                            txt_username.setText("");
                            txt_password.setText("");
                        
                            la_text.setText("");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You are not allowed to login");
                            txt_username.setText("");
                            txt_password.setText("");
                            
                            la_text.setText("");
                        }
                    }
                    else if(morning==false && evening==true )
                    {
                        if(rows1>0)
                        {
                            la_text.setText("Good Evening");
                            String sql = "UPDATE  `daily_attendance` set `LeavedTime`=? WHERE `Employeeid`='"+txt_username.getText().toString()+"'";

                            ps = con.prepareStatement(sql);
                            ps.setString(1, la_time.getText().toString());
                    
                            int rowsupdate = ps.executeUpdate();
                            ps.close();
                            if (rowsupdate > 0)
                            {
                                JOptionPane.showMessageDialog(null,"Login Successfuly");
                            
                                try
                                {

                                    st = con.createStatement();
                                   rs = st.executeQuery("select * from daily_attendance");


                                    int rows=0;
                                    while(rs.next())
                                    {
                                        rows++;
                                        String idd = rs.getString(1);
                                        id="DA"+(Integer.parseInt(idd.substring(2,9))+1);
                                    }
                                    if(rows<1)
                                    {
                                        id="DA1111111";
                                    }
                                }
                                catch(SQLException ex)
                                {
                                    id="DA1111111";
                                }
                                finally{
                                    st.close();
                                    rs.close();
                                }
                            }
                            txt_username.setText("");
                            txt_password.setText("");
                            la_text.setText("");
                        }
                        else
                        {
                            txt_username.setText("");
                            txt_password.setText("");
                            
                            la_text.setText("");
                            JOptionPane.showMessageDialog(null, "You are not allowed to login");
                        }
                    }
                    else
                    {
                        txt_username.setText("");
                        txt_password.setText("");    
                        la_text.setText("");
                        
                        JOptionPane.showMessageDialog(null, "You are not allowd to loggin");
                    }
                        
                    //JOptionPane.showMessageDialog(null,""+time);
                }
                else
                {
                    la_text.setText("");
                    txt_username.setText("");
                    txt_password.setText("");
                    JOptionPane.showMessageDialog(null, "Check your username and password");
                }
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_bt_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        OverView view=new OverView();
        view.setType(uType);
        view.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void attendenceTableShow(ResultSet rs){
         attendence_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
         model=(DefaultTableModel)attendence_table.getModel();//currently add
    }
    private void employee_id_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_id_searchKeyReleased
       if(employee_id_search.getText().isEmpty()){
           
            attendence_emp_error.setText("sum fields are empty");
       }
       else{
             try{
                        boolean isAvailable=false;
                         String sql5 = "SELECT * FROM `daily_attendance` WHERE `Employeeid`='"+employee_id_search.getText()+"'";
                         boolean isTrue=false;         
                         st= con.createStatement();
                         rs = st.executeQuery(sql5);
                          attendence_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                          model=(DefaultTableModel)attendence_table.getModel();//currently add
                          
                          ResultSet rs1=st.executeQuery(sql5);
                         while(rs1.next()){
                             isAvailable=true;
                         }
                          if(!isAvailable){
                              
                               attendence_emp_error.setText("No records are found");
                          }
                          else{
                               attendence_emp_error.setText("");
                          }
                          
                     
                        
                    
                }
                catch(Exception e){
                        
                    JOptionPane.showMessageDialog(null, e);
                }
             finally{
                 try {
                     st.close();
                     rs.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
                            
       }
    }//GEN-LAST:event_employee_id_searchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attendence_emp_error;
    private javax.swing.JTable attendence_table;
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_login;
    private javax.swing.JTextField employee_id_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel la_Date;
    private javax.swing.JLabel la_text;
    private javax.swing.JLabel la_time;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
