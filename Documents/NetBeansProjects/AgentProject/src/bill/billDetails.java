/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import Database.DBconnection;
import Storage.stockDetails;
import home.HomeOverView;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import model.bill;
import model.products;
import net.proteanit.sql.DbUtils;
import product.home;

/**
 *
 * @author Haran
 */
public class billDetails extends javax.swing.JFrame {
private final Connection con;
    private PreparedStatement ps;
    private ResultSet rs,rs1;
    private Statement st;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private DefaultTableModel model,model1,model2;
     private int Xloc,Yloc;
     private String bill_id;
     private String current_check_val;
     private String current_count_value;
     private String Customer_bill_id;
     
    /**
     * Creates new form billDetails
     */
    public billDetails() {
        initComponents();
        count_error.setText("");
        bill_error.setText("");
        date_error.setText("");
        this.setOpacity(0.95f);
        con=DBconnection.connectDB();
        combo_product.removeAllItems();
         setCombo();
            bill_table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        bill_table.getTableHeader().setOpaque(false);
         bill_table.getTableHeader().setBackground(Color.LIGHT_GRAY);
         bill_table.getTableHeader().setForeground(Color.BLACK);
         bill_table.setRowHeight(25);
         
               customer_bill_table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        customer_bill_table.getTableHeader().setOpaque(false);
         customer_bill_table.getTableHeader().setBackground(Color.LIGHT_GRAY);
         customer_bill_table.getTableHeader().setForeground(Color.BLACK);
         customer_bill_table.setRowHeight(25);
         
          display();
          display_customer_bill_table();
          btn_delete.setVisible(false);
          btn_cancel.setVisible(false);
          btn_bill_details.setVisible(false);
          btn_update.setVisible(false);
          lbl_result.setText("");
          btn_update.setVisible(false);
          lbl_bill_number_error.setText("");
          lbl_customerName_error.setText("");
          lbl_customer_paid_error.setText("");
          lbl_amount_error.setText("");
        
          btn_delete_bill_details.setVisible(false);
          btn_update_bill_details.setVisible(false);
          btn_cancel_bill_details.setVisible(false);
          
         
        
    }
    private void display(){
           String sql = "SELECT * FROM bill_details where check_val=0";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
           finally{
               
                bill_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                model=(DefaultTableModel)bill_table.getModel();//currently add
                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
    }
     private void setCombo(){
        String sql="SELECT * FROM  products where name!=All(select pname from bill_details where check_val=0)";
        try{
            ps=con.prepareStatement(sql);
           
            rs=ps.executeQuery();
            while(rs.next()){
                combo_product.addItem(rs.getString(2));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        finally{
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_delete = new javax.swing.JPanel();
        lbl_delete = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JPanel();
        lbl_cancel = new javax.swing.JLabel();
        btn_update = new javax.swing.JPanel();
        lbl_update = new javax.swing.JLabel();
        txt_billno_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_result = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_bill = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_count = new javax.swing.JTextField();
        combo_product = new javax.swing.JComboBox<>();
        txt_date = new com.toedter.calendar.JDateChooser();
        txt_billno = new javax.swing.JTextField();
        bill_error = new javax.swing.JLabel();
        date_error = new javax.swing.JLabel();
        count_error = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        btn_add = new javax.swing.JPanel();
        lbl_add = new javax.swing.JLabel();
        btn_bill_details = new javax.swing.JPanel();
        lbl_current_bill_details = new javax.swing.JLabel();
        btn_stock_details = new javax.swing.JPanel();
        lbl_stock_details = new javax.swing.JLabel();
        btn_add_bill = new javax.swing.JPanel();
        lbl_add_bill = new javax.swing.JLabel();
        btn_finished = new javax.swing.JPanel();
        lbl_finish = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bill_number1 = new javax.swing.JTextField();
        txt_customer_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lbl_bill_number_error = new javax.swing.JLabel();
        lbl_customerName_error = new javax.swing.JLabel();
        lbl_amount_error = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_customer_paid = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lbl_customer_paid_error = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btn_add_bill_details = new javax.swing.JPanel();
        lbl_add_bill_details = new javax.swing.JLabel();
        btn_update_bill_details = new javax.swing.JPanel();
        lbl_update_bill_details = new javax.swing.JLabel();
        btn_delete_bill_details = new javax.swing.JPanel();
        lbl_delete_bill_details = new javax.swing.JLabel();
        btn_cancel_bill_details = new javax.swing.JPanel();
        lbl_cancel_bill_details = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_customer_bill_search = new javax.swing.JTextField();
        lbl_customer_bill_results = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        customer_bill_table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_close = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        lbl_home = new javax.swing.JLabel();
        panel_stock = new javax.swing.JPanel();
        lbl_stock = new javax.swing.JLabel();
        panel_free = new javax.swing.JPanel();
        lbl_free = new javax.swing.JLabel();
        panel_exit = new javax.swing.JPanel();
        lbl_exit = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(5);
        setUndecorated(true);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        bill_table.setModel(new javax.swing.table.DefaultTableModel(
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
        bill_table.setRowHeight(25);
        bill_table.setSelectionBackground(new java.awt.Color(255, 51, 51));
        bill_table.getTableHeader().setReorderingAllowed(false);
        bill_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bill_tableMouseClicked(evt);
            }
        });
        bill_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bill_tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(bill_table);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deleteMouseExited(evt);
            }
        });

        lbl_delete.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_delete.setText("      Delete");

        javax.swing.GroupLayout btn_deleteLayout = new javax.swing.GroupLayout(btn_delete);
        btn_delete.setLayout(btn_deleteLayout);
        btn_deleteLayout.setHorizontalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        btn_deleteLayout.setVerticalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        btn_cancel.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelMouseExited(evt);
            }
        });

        lbl_cancel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_cancel.setText("       Cancel");

        javax.swing.GroupLayout btn_cancelLayout = new javax.swing.GroupLayout(btn_cancel);
        btn_cancel.setLayout(btn_cancelLayout);
        btn_cancelLayout.setHorizontalGroup(
            btn_cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btn_cancelLayout.setVerticalGroup(
            btn_cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_updateMouseExited(evt);
            }
        });

        lbl_update.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_update.setText("               Update");

        javax.swing.GroupLayout btn_updateLayout = new javax.swing.GroupLayout(btn_update);
        btn_update.setLayout(btn_updateLayout);
        btn_updateLayout.setHorizontalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_update, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        btn_updateLayout.setVerticalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_update, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        txt_billno_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_billno_searchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("         Search Bill Number");

        lbl_result.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_result.setText("               Results");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_billno_search, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lbl_result, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_billno_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_result)
                .addGap(29, 29, 29))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_bill.setText("Bill_No");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Date");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Products");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("count");

        txt_count.setBorder(null);
        txt_count.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_countKeyReleased(evt);
            }
        });

        combo_product.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        txt_billno.setBorder(null);
        txt_billno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_billnoKeyReleased(evt);
            }
        });

        bill_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bill_error.setForeground(new java.awt.Color(255, 0, 0));
        bill_error.setText("Error");

        date_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        date_error.setForeground(new java.awt.Color(255, 0, 0));
        date_error.setText("Error");

        count_error.setBackground(new java.awt.Color(255, 255, 255));
        count_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        count_error.setForeground(new java.awt.Color(255, 0, 0));
        count_error.setText("Error");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(txt_count)
                            .addComponent(txt_date, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(txt_billno)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(combo_product, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_error, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(count_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bill_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_billno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_bill)
                    .addComponent(bill_error))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(count_error))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(combo_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(date_error)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_add.setBackground(new java.awt.Color(255, 255, 255));
        btn_add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addMouseExited(evt);
            }
        });

        lbl_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_add.setText("    Add");

        javax.swing.GroupLayout btn_addLayout = new javax.swing.GroupLayout(btn_add);
        btn_add.setLayout(btn_addLayout);
        btn_addLayout.setHorizontalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );
        btn_addLayout.setVerticalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        btn_bill_details.setBackground(new java.awt.Color(255, 255, 255));
        btn_bill_details.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_bill_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bill_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bill_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bill_detailsMouseExited(evt);
            }
        });

        lbl_current_bill_details.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_current_bill_details.setText(" current_bill_details");

        javax.swing.GroupLayout btn_bill_detailsLayout = new javax.swing.GroupLayout(btn_bill_details);
        btn_bill_details.setLayout(btn_bill_detailsLayout);
        btn_bill_detailsLayout.setHorizontalGroup(
            btn_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_current_bill_details, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
        btn_bill_detailsLayout.setVerticalGroup(
            btn_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_current_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btn_stock_details.setBackground(new java.awt.Color(255, 255, 255));
        btn_stock_details.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_stock_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_stock_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_stock_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_stock_detailsMouseExited(evt);
            }
        });

        lbl_stock_details.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_stock_details.setText("   Stock Details");

        javax.swing.GroupLayout btn_stock_detailsLayout = new javax.swing.GroupLayout(btn_stock_details);
        btn_stock_details.setLayout(btn_stock_detailsLayout);
        btn_stock_detailsLayout.setHorizontalGroup(
            btn_stock_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock_details, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        btn_stock_detailsLayout.setVerticalGroup(
            btn_stock_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_add_bill.setBackground(new java.awt.Color(255, 255, 255));
        btn_add_bill.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_add_bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add_billMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add_billMouseExited(evt);
            }
        });

        lbl_add_bill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_add_bill.setText("        Add Bill");

        javax.swing.GroupLayout btn_add_billLayout = new javax.swing.GroupLayout(btn_add_bill);
        btn_add_bill.setLayout(btn_add_billLayout);
        btn_add_billLayout.setHorizontalGroup(
            btn_add_billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add_bill, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        btn_add_billLayout.setVerticalGroup(
            btn_add_billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add_bill, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btn_finished.setBackground(new java.awt.Color(255, 255, 255));
        btn_finished.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_finished.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_finishedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_finishedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_finishedMouseExited(evt);
            }
        });

        lbl_finish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_finish.setText("  Finished");

        javax.swing.GroupLayout btn_finishedLayout = new javax.swing.GroupLayout(btn_finished);
        btn_finished.setLayout(btn_finishedLayout);
        btn_finishedLayout.setHorizontalGroup(
            btn_finishedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_finish, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );
        btn_finishedLayout.setVerticalGroup(
            btn_finishedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_finish, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_finished, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_bill_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_stock_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_add_bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_bill_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_finished, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_stock_details, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add_bill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bill Entry", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("Bill Number");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Customer Name");

        txt_bill_number1.setBorder(null);

        txt_customer_name.setBorder(null);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Amount");

        txt_amount.setBorder(null);

        lbl_bill_number_error.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_bill_number_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_bill_number_error.setText("Error");

        lbl_customerName_error.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_customerName_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_customerName_error.setText("Error");

        lbl_amount_error.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_amount_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_amount_error.setText("Error");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel11.setText("Customer Paid");

        txt_customer_paid.setBorder(null);

        lbl_customer_paid_error.setBackground(new java.awt.Color(255, 255, 255));
        lbl_customer_paid_error.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_customer_paid_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_customer_paid_error.setText("Error");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator4)
                            .addComponent(txt_bill_number1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator7)
                            .addComponent(jSeparator5)
                            .addComponent(txt_customer_name)
                            .addComponent(txt_amount)
                            .addComponent(jSeparator6)
                            .addComponent(txt_customer_paid, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_customerName_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_bill_number_error, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_amount_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(lbl_customer_paid_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_bill_number1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_bill_number_error))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txt_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_customerName_error))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_amount_error))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_customer_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_customer_paid_error)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_add_bill_details.setBackground(new java.awt.Color(255, 255, 255));
        btn_add_bill_details.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_add_bill_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_bill_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add_bill_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add_bill_detailsMouseExited(evt);
            }
        });

        lbl_add_bill_details.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_add_bill_details.setText("           Add");

        javax.swing.GroupLayout btn_add_bill_detailsLayout = new javax.swing.GroupLayout(btn_add_bill_details);
        btn_add_bill_details.setLayout(btn_add_bill_detailsLayout);
        btn_add_bill_detailsLayout.setHorizontalGroup(
            btn_add_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );
        btn_add_bill_detailsLayout.setVerticalGroup(
            btn_add_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        btn_update_bill_details.setBackground(new java.awt.Color(255, 255, 255));
        btn_update_bill_details.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_update_bill_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_bill_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_update_bill_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_update_bill_detailsMouseExited(evt);
            }
        });

        lbl_update_bill_details.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_update_bill_details.setText("          Update");

        javax.swing.GroupLayout btn_update_bill_detailsLayout = new javax.swing.GroupLayout(btn_update_bill_details);
        btn_update_bill_details.setLayout(btn_update_bill_detailsLayout);
        btn_update_bill_detailsLayout.setHorizontalGroup(
            btn_update_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_update_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        btn_update_bill_detailsLayout.setVerticalGroup(
            btn_update_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_update_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_delete_bill_details.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete_bill_details.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_delete_bill_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete_bill_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_delete_bill_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_delete_bill_detailsMouseExited(evt);
            }
        });

        lbl_delete_bill_details.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_delete_bill_details.setText("            Delete");

        javax.swing.GroupLayout btn_delete_bill_detailsLayout = new javax.swing.GroupLayout(btn_delete_bill_details);
        btn_delete_bill_details.setLayout(btn_delete_bill_detailsLayout);
        btn_delete_bill_detailsLayout.setHorizontalGroup(
            btn_delete_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        btn_delete_bill_detailsLayout.setVerticalGroup(
            btn_delete_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_cancel_bill_details.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancel_bill_details.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_cancel_bill_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel_bill_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancel_bill_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancel_bill_detailsMouseExited(evt);
            }
        });

        lbl_cancel_bill_details.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_cancel_bill_details.setText("          Cancel");

        javax.swing.GroupLayout btn_cancel_bill_detailsLayout = new javax.swing.GroupLayout(btn_cancel_bill_details);
        btn_cancel_bill_details.setLayout(btn_cancel_bill_detailsLayout);
        btn_cancel_bill_detailsLayout.setHorizontalGroup(
            btn_cancel_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        btn_cancel_bill_detailsLayout.setVerticalGroup(
            btn_cancel_bill_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add_bill_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btn_update_bill_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btn_delete_bill_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_cancel_bill_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cancel_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete_bill_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Search Bill Number");

        txt_customer_bill_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_customer_bill_searchKeyReleased(evt);
            }
        });

        lbl_customer_bill_results.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbl_customer_bill_results.setForeground(new java.awt.Color(0, 0, 204));
        lbl_customer_bill_results.setText("Results Found");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Bill Number");

        jTextField1.setEditable(false);

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel12.setText("Amount");

        jButton1.setText("Settle");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel8))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txt_customer_bill_search, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lbl_customer_bill_results)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txt_customer_bill_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_customer_bill_results)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customer_bill_table.setModel(new javax.swing.table.DefaultTableModel(
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
        customer_bill_table.setRowHeight(25);
        customer_bill_table.setSelectionBackground(new java.awt.Color(255, 51, 51));
        customer_bill_table.getTableHeader().setReorderingAllowed(false);
        customer_bill_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_bill_tableMouseClicked(evt);
            }
        });
        customer_bill_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customer_bill_tableKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(customer_bill_table);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bill ", jPanel7);

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        btn_close.setBackground(new java.awt.Color(255, 255, 255));
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });

        lbl_close.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_close.setText(" x");

        javax.swing.GroupLayout btn_closeLayout = new javax.swing.GroupLayout(btn_close);
        btn_close.setLayout(btn_closeLayout);
        btn_closeLayout.setHorizontalGroup(
            btn_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_close, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );
        btn_closeLayout.setVerticalGroup(
            btn_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_close, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bill Details");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_home.setBackground(new java.awt.Color(255, 255, 255));
        btn_home.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });

        lbl_home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_home.setText("      Home");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_home, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_home, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        panel_stock.setBackground(new java.awt.Color(255, 255, 255));
        panel_stock.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_stockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_stockMouseExited(evt);
            }
        });

        lbl_stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_stock.setText("      Stock");

        javax.swing.GroupLayout panel_stockLayout = new javax.swing.GroupLayout(panel_stock);
        panel_stock.setLayout(panel_stockLayout);
        panel_stockLayout.setHorizontalGroup(
            panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_stockLayout.setVerticalGroup(
            panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        panel_free.setBackground(new java.awt.Color(255, 255, 255));
        panel_free.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_free.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_freeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_freeMouseExited(evt);
            }
        });

        lbl_free.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_free.setText("       Free");

        javax.swing.GroupLayout panel_freeLayout = new javax.swing.GroupLayout(panel_free);
        panel_free.setLayout(panel_freeLayout);
        panel_freeLayout.setHorizontalGroup(
            panel_freeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_free, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_freeLayout.setVerticalGroup(
            panel_freeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_free, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        panel_exit.setBackground(new java.awt.Color(255, 255, 255));
        panel_exit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_exitMouseExited(evt);
            }
        });

        lbl_exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_exit.setText("        Exit");

        javax.swing.GroupLayout panel_exitLayout = new javax.swing.GroupLayout(panel_exit);
        panel_exit.setLayout(panel_exitLayout);
        panel_exitLayout.setHorizontalGroup(
            panel_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_exitLayout.setVerticalGroup(
            panel_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel_free, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_stock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(panel_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(panel_free, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(panel_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
         this.processWindowEvent(
                        new WindowEvent(
                                this, WindowEvent.WINDOW_CLOSING));
         HomeOverView hm=new HomeOverView();
           hm.setVisible(true);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
         lbl_close.setForeground(Color.WHITE);
         btn_close.setBackground(Color.BLACK);
          //System.out.println("MouseEntered");
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
         lbl_close.setForeground(Color.BLACK);
         btn_close.setBackground(Color.WHITE);
          System.out.println("MouseExisted");

    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
         lbl_home.setForeground(Color.WHITE);
         btn_home.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
       lbl_home.setForeground(Color.BLACK);
         btn_home.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_homeMouseExited

    private void panel_stockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_stockMouseEntered
        lbl_stock.setForeground(Color.WHITE);
         panel_stock.setBackground(Color.BLACK);
    }//GEN-LAST:event_panel_stockMouseEntered

    private void panel_stockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_stockMouseExited
        lbl_stock.setForeground(Color.BLACK);
         panel_stock.setBackground(Color.WHITE);
    }//GEN-LAST:event_panel_stockMouseExited

    private void panel_freeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_freeMouseEntered
        lbl_free.setForeground(Color.WHITE);
         panel_free.setBackground(Color.BLACK);
    }//GEN-LAST:event_panel_freeMouseEntered

    private void panel_freeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_freeMouseExited
        lbl_free.setForeground(Color.BLACK);
        panel_free.setBackground(Color.WHITE);
    }//GEN-LAST:event_panel_freeMouseExited

    private void panel_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_exitMouseEntered
        lbl_exit.setForeground(Color.WHITE);
         panel_exit.setBackground(Color.BLACK);
    }//GEN-LAST:event_panel_exitMouseEntered

    private void panel_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_exitMouseExited
        lbl_exit.setForeground(Color.BLACK);
        panel_exit.setBackground(Color.WHITE);
    }//GEN-LAST:event_panel_exitMouseExited

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
         int X=evt.getXOnScreen();
       int Y=evt.getYOnScreen();
        setLocation(X-Xloc, Y-Yloc);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        Xloc=evt.getX();
         Yloc=evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void btn_finishedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finishedMouseExited
        lbl_finish.setForeground(Color.BLACK);
        btn_finished.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_finishedMouseExited

    private void btn_finishedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finishedMouseEntered
        lbl_finish.setForeground(Color.WHITE);
        btn_finished.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_finishedMouseEntered

    private void btn_finishedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finishedMouseClicked
        update_stock_details(get_current_bill_details());

        String sql="update bill_details set check_val =1 where check_val=0";
        try {
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        txt_count.setText("");
        combo_product.removeAllItems();
        setCombo();
        display();
        txt_billno.setText("");
    }//GEN-LAST:event_btn_finishedMouseClicked

    private void btn_add_billMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_billMouseExited
        lbl_add_bill.setForeground(Color.BLACK);
        btn_add_bill.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_add_billMouseExited

    private void btn_add_billMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_billMouseEntered
        lbl_add_bill.setForeground(Color.WHITE);
        btn_add_bill.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_add_billMouseEntered

    private void btn_stock_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stock_detailsMouseExited
        lbl_stock_details.setForeground(Color.BLACK);
        btn_stock_details.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_stock_detailsMouseExited

    private void btn_stock_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stock_detailsMouseEntered
        lbl_stock_details.setForeground(Color.WHITE);
        btn_stock_details.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_stock_detailsMouseEntered

    private void btn_stock_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stock_detailsMouseClicked
        btn_bill_details.setVisible(true);
        btn_stock_details.setVisible(false);
        set_current_stock_details();
        combo_product.removeAllItems();
        setCombo();
        btn_delete.setVisible(false);
        btn_cancel.setVisible(false);
        btn_add.setVisible(true);
        btn_update.setVisible(false);
        txt_billno_search.setText("");
        txt_billno.setText("");
        txt_count.setText("");
        txt_date.setDate(null);
        lbl_result.setText("");
        getAvailableStock();
    }//GEN-LAST:event_btn_stock_detailsMouseClicked

    private void btn_bill_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bill_detailsMouseExited
        lbl_current_bill_details.setForeground(Color.BLACK);
        btn_bill_details.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_bill_detailsMouseExited

    private void btn_bill_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bill_detailsMouseEntered
        lbl_current_bill_details.setForeground(Color.WHITE);
        btn_bill_details.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_bill_detailsMouseEntered

    private void btn_bill_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bill_detailsMouseClicked
        btn_bill_details.setVisible(false);
        btn_stock_details.setVisible(true);
        combo_product.removeAllItems();
        setCombo();
        btn_delete.setVisible(false);
        btn_cancel.setVisible(false);
        btn_add.setVisible(true);
        btn_update.setVisible(false);
        txt_billno_search.setText("");
        txt_billno.setText("");
        txt_count.setText("");
        txt_date.setDate(null);
        lbl_result.setText("");
        getAvailableStock();
        display();
    }//GEN-LAST:event_btn_bill_detailsMouseClicked

    private void btn_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseExited
        lbl_add.setForeground(Color.BLACK);
        btn_add.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_addMouseExited

    private void btn_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseEntered
        lbl_add.setForeground(Color.WHITE);
        btn_add.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_addMouseEntered

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        if(check()){
            String sql="insert into bill_details(bill_no,pname,count,date) values(?,?,?,?)";
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1,txt_billno.getText());
                ps.setString(2,combo_product.getSelectedItem().toString());
                ps.setString(3,txt_count.getText());
                ps.setString(4,formatter.format(txt_date.getDate()));
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            txt_count.setText("");
            combo_product.removeAllItems();
            setCombo();
            display();
        }
    }//GEN-LAST:event_btn_addMouseClicked

    private void txt_billnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_billnoKeyReleased
        String value=txt_billno.getText();
        try{
            Double.parseDouble(value);
        }
        catch(NumberFormatException e){
            txt_billno.setText("");
            JOptionPane.showMessageDialog(null,"Field should include only numbers");
        }
    }//GEN-LAST:event_txt_billnoKeyReleased

    private void txt_countKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_countKeyReleased
        boolean ExceptionFound=false;
        boolean isExceed=false;
        int total=0;
        String value=txt_count.getText();
        try{
            Double.parseDouble(value);
        }
        catch(NumberFormatException e){
            ExceptionFound=true;
            txt_count.setText("");
            //JOptionPane.showMessageDialog(rootPane,"Field should include only numbers");
            count_error.setText("Field should include only numbers");
        }
        if(!ExceptionFound){
            String sql="select  * from current_stocks where product_name=?";
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1,combo_product.getSelectedItem().toString());
                rs=ps.executeQuery();
                while(rs.next()){
                    total=rs.getInt(4);
                }
                if(Integer.parseInt(txt_count.getText()) > total){
                    isExceed=true;
                    txt_count.setText("");
                    count_error.setText(combo_product.getSelectedItem().toString()+" has only "+total +" in stock");
                }
                else{
                    count_error.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    ps.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //        if(!isExceed){
            //
            //        }
    }//GEN-LAST:event_txt_countKeyReleased

    private void txt_billno_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_billno_searchKeyReleased
        btn_stock_details.setVisible(true);
        btn_bill_details.setVisible(false);
        display();
        view_current_records("1");
        try {
            String sql1="select * from bill_details where bill_no like '"+txt_billno_search.getText()+"%' and check_val=1";
            st=con.createStatement();
            rs=st.executeQuery(sql1);
            int size =0;

            if (rs != null)
            {

                rs.last();
                size = rs.getRow();
            }
            if(size == 0){
                lbl_result.setForeground(Color.red);
            }
            else{
                lbl_result.setForeground(Color.GREEN);
            }
            lbl_result.setText(String.valueOf(size)+" Results Found");

        } catch (SQLException ex) {
            Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_txt_billno_searchKeyReleased

    private void btn_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseExited
        lbl_update.setForeground(Color.BLACK);
        btn_update.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_updateMouseExited

    private void btn_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseEntered
        lbl_update.setForeground(Color.WHITE);
        btn_update.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_updateMouseEntered

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        if(check()){

            if(current_check_val.equals("0")){

                update_details();
                show_table("0");

            }
            else{
                update_details();

                try{
                    String sql="update current_stocks set available=available - '"+txt_count.getText()+"' + '"+current_count_value+"' where product_name='"+combo_product.getSelectedItem().toString()+"'";
                    st=con.createStatement();
                    st.execute(sql);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                finally{
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                show_table("1");
                current_count_value=txt_count.getText();

            }
        }
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
        lbl_cancel.setForeground(Color.BLACK);
        btn_cancel.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseEntered
        lbl_cancel.setForeground(Color.WHITE);
        btn_cancel.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_cancelMouseEntered

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        combo_product.removeAllItems();
        setCombo();
        btn_delete.setVisible(false);
        btn_cancel.setVisible(false);
        btn_add.setVisible(true);
        btn_update.setVisible(false);
        txt_billno_search.setText("");
        txt_billno.setText("");
        txt_count.setText("");
        txt_date.setDate(null);
        lbl_result.setText("");
        getAvailableStock();

        if(btn_stock_details.isVisible()){
            btn_stock_details.setVisible(true);
            btn_bill_details.setVisible(false);
            display();
        }
        else{
            display();
        }
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseExited
        lbl_delete.setForeground(Color.BLACK);
        btn_delete.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_deleteMouseExited

    private void btn_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseEntered
        lbl_delete.setForeground(Color.WHITE);
        btn_delete.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_deleteMouseEntered

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked

        if(current_check_val.equals("0")){
            deleteRecords("0");

        }
        else{
            try{
                String sql="update current_stocks set available=available + '"+txt_count.getText()+"' where product_name='"+combo_product.getSelectedItem().toString()+"'";
                st=con.createStatement();
                st.execute(sql);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            deleteRecords("1");

        }
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void bill_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_tableKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
            if(btn_stock_details.isVisible()){

                btn_update.setVisible(true);
                combo_product.removeAllItems();
                btn_cancel.setVisible(true);
                btn_delete.setVisible(true);
                btn_add.setVisible(false);

                bill_id=(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),0)));
                current_count_value=(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),3)));
                txt_billno.setText(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),1)));
                txt_count.setText(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),3)));
                Date dateValue3=null;
                SimpleDateFormat date3 = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    dateValue3 = date3.parse(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),4)));
                    txt_date.setDate(dateValue3);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                combo_product.addItem(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),2)));
                current_check_val=(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),5)));
                getAvailableStock();
            }
        }
    }//GEN-LAST:event_bill_tableKeyReleased

    private void bill_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_tableMouseClicked
        if(btn_stock_details.isVisible()){
            combo_product.removeAllItems();

            bill_id=(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),0)));
            txt_billno.setText(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),1)));
            Date dateValue3=null;
            SimpleDateFormat date3 = new SimpleDateFormat("dd/MM/yyyy");

            try {
                dateValue3 = date3.parse(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),4)));
                txt_date.setDate(dateValue3);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

            current_count_value=(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),3)));
            txt_count.setText(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),3)));
            combo_product.addItem(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),2)));
            btn_delete.setVisible(true);
            btn_cancel.setVisible(true);
            btn_add.setVisible(false);
            btn_update.setVisible(true);
            current_check_val=(String.valueOf(model.getValueAt(bill_table.getSelectedRow(),5)));
            getAvailableStock();
        }
    }//GEN-LAST:event_bill_tableMouseClicked

    private void btn_update_bill_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_bill_detailsMouseEntered
         lbl_update_bill_details.setForeground(Color.WHITE);
         btn_update_bill_details.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_update_bill_detailsMouseEntered

    private void btn_update_bill_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_bill_detailsMouseExited
          lbl_update_bill_details.setForeground(Color.BLACK);
         btn_update_bill_details.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_update_bill_detailsMouseExited

    private void btn_delete_bill_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete_bill_detailsMouseEntered
         lbl_delete_bill_details.setForeground(Color.WHITE);
         btn_delete_bill_details.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_delete_bill_detailsMouseEntered

    private void btn_delete_bill_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete_bill_detailsMouseExited
          lbl_delete_bill_details.setForeground(Color.BLACK);
         btn_delete_bill_details.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_delete_bill_detailsMouseExited

    private void btn_cancel_bill_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel_bill_detailsMouseEntered
         lbl_cancel_bill_details.setForeground(Color.WHITE);
         btn_cancel_bill_details.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_cancel_bill_detailsMouseEntered

    private void btn_cancel_bill_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel_bill_detailsMouseExited
         lbl_cancel_bill_details.setForeground(Color.BLACK);
         btn_cancel_bill_details.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_cancel_bill_detailsMouseExited
    private void display_customer_bill_table(){
            String sql = "SELECT * FROM customer_bill";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
           finally{
               
               customer_bill_table.setModel(DbUtils.resultSetToTableModel(rs));//show all bill details in a table
                model2=(DefaultTableModel)customer_bill_table.getModel();//currently add
                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
    }
    private boolean check_customer_details(){
       boolean isValidated=true;
        if(txt_bill_number1.getText().isEmpty()){
            lbl_bill_number_error.setText("Bill Number is Required");
            isValidated=false;
        }
        else{
            lbl_bill_number_error.setText("");
        }
        if(txt_customer_name.getText().isEmpty()){
            lbl_customerName_error.setText("Customer name is Required");
            isValidated=false;
        }
        else{
            lbl_customerName_error.setText("");
        }
        if(txt_customer_paid.getText().isEmpty()){
           lbl_customer_paid_error.setText(" Paid Amount is Required");
           isValidated=false;
        }
        else{
            lbl_customer_paid_error.setText("");
        }
        if(txt_amount.getText().isEmpty()){
            lbl_amount_error.setText("Amount is Required");
            isValidated=false;
        }
        else{
            lbl_amount_error.setText("");
        }
        return isValidated;
    }
    private void btn_add_bill_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_bill_detailsMouseClicked
        if(check_customer_details()){
                   try{
                        String sql="insert into customer_bill(id,name,price,paid) values(?,?,?,?)";
                        ps=con.prepareStatement(sql);
                        ps.setString(1, txt_bill_number1.getText());
                        ps.setString(2,txt_customer_name.getText());
                        ps.setString(3,txt_amount.getText());
                        ps.setString(4,txt_customer_paid.getText());
                        ps.execute();
                        JOptionPane.showMessageDialog(null,"Sucessfully Inserted");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,e);
                    }
                    finally{
                        try {
                            ps.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    txt_bill_number1.setText("");
                    txt_customer_name.setText("");
                    txt_customer_paid.setText("");
                    txt_amount.setText("");
                   display_customer_bill_table();
        }  
    }//GEN-LAST:event_btn_add_bill_detailsMouseClicked

    private void btn_add_bill_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_bill_detailsMouseEntered
        lbl_add_bill_details.setForeground(Color.WHITE);
        btn_add_bill_details.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_add_bill_detailsMouseEntered

    private void btn_add_bill_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_bill_detailsMouseExited
         lbl_add_bill_details.setForeground(Color.BLACK);
        btn_add_bill_details.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_add_bill_detailsMouseExited

    private void customer_bill_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_bill_tableMouseClicked
         lbl_bill_number_error.setText("");
         lbl_customerName_error.setText("");
         lbl_amount_error.setText("");
         lbl_customer_paid_error.setText("");
        txt_bill_number1.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),0)));
         txt_customer_name.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),1)));
         txt_amount.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),2)));
         txt_customer_paid.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),3)));
         Customer_bill_id=String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),0));
         btn_add_bill_details.setVisible(false);
         btn_delete_bill_details.setVisible(true);
         btn_update_bill_details.setVisible(true);
         btn_delete_bill_details.setVisible(true);
         btn_cancel_bill_details.setVisible(true);
    }//GEN-LAST:event_customer_bill_tableMouseClicked

    private void customer_bill_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customer_bill_tableKeyReleased
         if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
             lbl_bill_number_error.setText("");
            lbl_customerName_error.setText("");
            lbl_amount_error.setText("");
            lbl_customer_paid_error.setText("");
            txt_bill_number1.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),0)));
             txt_customer_name.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),1)));
             txt_amount.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),2)));
             txt_customer_paid.setText(String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),3)));
             Customer_bill_id=String.valueOf(model2.getValueAt(customer_bill_table.getSelectedRow(),0));
             btn_add_bill_details.setVisible(false);
             btn_delete_bill_details.setVisible(true);
             btn_update_bill_details.setVisible(true);
             btn_delete_bill_details.setVisible(true);
             btn_cancel_bill_details.setVisible(true);
         }
    }//GEN-LAST:event_customer_bill_tableKeyReleased

    private void btn_cancel_bill_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel_bill_detailsMouseClicked
             btn_add_bill_details.setVisible(true);
             btn_delete_bill_details.setVisible(false);
             btn_update_bill_details.setVisible(false);
             btn_delete_bill_details.setVisible(false);
             btn_cancel_bill_details.setVisible(false);
              txt_bill_number1.setText("");
                    txt_customer_name.setText("");
                    txt_customer_paid.setText("");
                    txt_amount.setText("");
    }//GEN-LAST:event_btn_cancel_bill_detailsMouseClicked

    private void btn_delete_bill_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete_bill_detailsMouseClicked
        // TODO add your handling code here:
         try{
               String sql="delete from customer_bill where id=?";
               ps=con.prepareStatement(sql);
               ps.setString(1, txt_bill_number1.getText());
               ps.executeUpdate();
              JOptionPane.showMessageDialog(null,"Deleted Successfully");
           }
           catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
           }
           finally{
              
               try {
                  ps.close();
                  display_customer_bill_table();
                  set_customer_bill_details();
                } 
               catch (SQLException ex) {
                  Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
               }

           }
    }//GEN-LAST:event_btn_delete_bill_detailsMouseClicked

    private void btn_update_bill_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_bill_detailsMouseClicked
        if(check_customer_details()){
            try{
                String sql="update customer_bill set id=?,name=?,price=?,paid=? where id='"+ Customer_bill_id+"'";
                ps=con.prepareStatement(sql);
                ps.setString(1,txt_bill_number1.getText());
                ps.setString(2,txt_customer_name.getText());
                ps.setString(3,txt_amount.getText());
                ps.setString(4,txt_customer_paid.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null,"Update Sucessfully");
            }
            catch(SQLException e1){
               JOptionPane.showMessageDialog(null, "Bill id already in use.."); 
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                display_customer_bill_table();
            }
        }
    }//GEN-LAST:event_btn_update_bill_detailsMouseClicked

    private void txt_customer_bill_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customer_bill_searchKeyReleased
             try{
                String sql="select * from customer_bill where id like '"+txt_customer_bill_search.getText()+"%'";
                st=con.createStatement();
                 rs=st.executeQuery(sql);
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
             }
            finally{
                 customer_bill_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                 model2=(DefaultTableModel)customer_bill_table.getModel();//currently add

                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        try {
            String sql1="select * from customer_bill where id like '"+txt_customer_bill_search.getText()+"%'";
            st=con.createStatement();
            rs=st.executeQuery(sql1);
            int size =0;

            if (rs != null)
            {

                rs.last();
                size = rs.getRow();
            }
            if(size == 0){
                lbl_customer_bill_results.setForeground(Color.red);
            }
            else{
                lbl_customer_bill_results.setForeground(Color.GREEN);
            }
            lbl_customer_bill_results.setText(String.valueOf(size)+" Results Found");

        } catch (SQLException ex) {
            Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_txt_customer_bill_searchKeyReleased
    private void set_customer_bill_details(){
           String sql = "SELECT * FROM customer_bill";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
               
               if(rs.next()){
                txt_bill_number1.setText(rs.getString(1));
                txt_customer_name.setText(rs.getString(2));
                txt_amount.setText(rs.getString(3));
                txt_customer_name.setText(rs.getString(4));
               }
               else{
                   
                   txt_bill_number1.setText("");
                   txt_customer_name.setText("");
                   txt_customer_paid.setText("");
                   txt_amount.setText("");
                   btn_update_bill_details.setVisible(false);
                   btn_delete_bill_details.setVisible(false);
                   btn_cancel_bill_details.setVisible(false);
                   btn_add_bill_details.setVisible(true);
               }
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
           finally{
               
             
                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
    }
    private void getAvailableStock(){
        int total=0;
         count_error.setForeground(Color.BLUE); 
         String sql="select  * from current_stocks where product_name=?";
            try {
                ps=con.prepareStatement(sql);
                ps.setString(1,combo_product.getSelectedItem().toString());
                rs=ps.executeQuery();
                while(rs.next()){
                    total=rs.getInt(4);
                }
                    
                 count_error.setText(combo_product.getSelectedItem().toString()+" has only "+total +" in stock");
                
            } catch (SQLException ex) {
                Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    ps.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }   
    private void view_current_records(String value){
            try{
             String sql="select * from bill_details where bill_no like '"+txt_billno_search.getText()+"%' and check_val='"+value+"'";
             st=con.createStatement();
              rs=st.executeQuery(sql);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                 bill_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                 model=(DefaultTableModel)bill_table.getModel();//currently add

                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    private void show_table(String value){
        try {
            String sql1="select * from bill_details where bill_no like '"+txt_billno_search.getText()+"%' and check_val='"+value+"'";
            st=con.createStatement();
            rs=st.executeQuery(sql1);
            int size =0;
             
            if (rs != null) 
            {
              
              rs.last();    
              size = rs.getRow(); 
            }
            if(size == 0){
                display();
            }
            else{
               view_current_records("1");
            }
                 
        } catch (SQLException ex) {
            Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
    }
    private void deleteRecords(String value){
        try{
               String sql="delete from bill_details where id=?";
               ps=con.prepareStatement(sql);
               ps.setString(1, bill_id);
               ps.executeUpdate();
              JOptionPane.showMessageDialog(null,"Deleted Successfully");
           }
           catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
           }
           finally{
              
               try {
                  ps.close();
                 show_table(value);
                } 
               catch (SQLException ex) {
                  Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
               }

           }
    }    private void update_details(){
          try{
            String sql="update bill_details set bill_no=?,count=?,date=? where id='"+bill_id+"'";
            ps=con.prepareStatement(sql);
            ps.setString(1, txt_billno.getText());
            ps.setString(2,txt_count.getText());
             ps.setString(3,formatter.format(txt_date.getDate()));
             ps.execute();
             JOptionPane.showMessageDialog(null,"Sucessfully Updated");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }    private boolean check(){
        boolean isCorrect=true;
        if(txt_count.getText().isEmpty()){
            isCorrect=false;
            count_error.setText("Field is Empty");
        }
        else{
            count_error.setText("");
        }
        if(txt_billno.getText().isEmpty()){
            isCorrect=false;
            bill_error.setText("bill number is Empty");
        }
        else{
            bill_error.setText("");
        }
        if(txt_date.getDate()==null){
             isCorrect=false;
            date_error.setText("Date is Empty");
        }
        else{
            date_error.setText("");
        }
        return isCorrect;
    }
    private ArrayList<products> get_current_bill_details(){
        ArrayList<products> bill_list=new ArrayList<>();
        
        String sql="SELECT b.*,c.available,c.pid FROM  bill_details b,current_stocks c where b.pname=c.product_name and b.check_val=0";
        
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                products p1=new products();
                p1.setProduct_id(rs.getString(7));
                p1.setProduct_name(rs.getString(3));
                p1.setCount(rs.getString(4));
                p1.setAvailable(rs.getString(6));
                bill_list.add(p1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bill_list;
    }
    private void update_stock_details(ArrayList<products> bill_list){
        String sql="update current_stocks set available=? where pid=?";
        bill_list.forEach(new Consumer<products>() {
            @Override
            public void accept(products p1) {
                try {
                    ps=con.prepareStatement(sql);
                    ps.setString(1, String.valueOf(Integer.parseInt(p1.getAvailable())-Integer.parseInt(p1.getCount())));
                    ps.setString(2,p1.getProduct_id());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally{               
                    try {
                        ps.close();
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(billDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
        
    }    private void set_current_stock_details(){
           model1= new DefaultTableModel(new String[]{"product_id", "product_name", "Instock"}, 0);
           String sql="select * from current_stocks";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                model1.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
               try {
                   ps.close();
                   rs.close();
               } catch (SQLException ex) {
                   Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
               }
            
        }
           
           bill_table.setModel(model1);
    }
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
            java.util.logging.Logger.getLogger(billDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new billDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bill_error;
    private javax.swing.JTable bill_table;
    private javax.swing.JPanel btn_add;
    private javax.swing.JPanel btn_add_bill;
    private javax.swing.JPanel btn_add_bill_details;
    private javax.swing.JPanel btn_bill_details;
    private javax.swing.JPanel btn_cancel;
    private javax.swing.JPanel btn_cancel_bill_details;
    private javax.swing.JPanel btn_close;
    private javax.swing.JPanel btn_delete;
    private javax.swing.JPanel btn_delete_bill_details;
    private javax.swing.JPanel btn_finished;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_stock_details;
    private javax.swing.JPanel btn_update;
    private javax.swing.JPanel btn_update_bill_details;
    private javax.swing.JComboBox<String> combo_product;
    private javax.swing.JLabel count_error;
    private javax.swing.JTable customer_bill_table;
    private javax.swing.JLabel date_error;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_add;
    private javax.swing.JLabel lbl_add_bill;
    private javax.swing.JLabel lbl_add_bill_details;
    private javax.swing.JLabel lbl_amount_error;
    private javax.swing.JLabel lbl_bill;
    private javax.swing.JLabel lbl_bill_number_error;
    private javax.swing.JLabel lbl_cancel;
    private javax.swing.JLabel lbl_cancel_bill_details;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_current_bill_details;
    private javax.swing.JLabel lbl_customerName_error;
    private javax.swing.JLabel lbl_customer_bill_results;
    private javax.swing.JLabel lbl_customer_paid_error;
    private javax.swing.JLabel lbl_delete;
    private javax.swing.JLabel lbl_delete_bill_details;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_finish;
    private javax.swing.JLabel lbl_free;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_stock_details;
    private javax.swing.JLabel lbl_update;
    private javax.swing.JLabel lbl_update_bill_details;
    private javax.swing.JPanel panel_exit;
    private javax.swing.JPanel panel_free;
    private javax.swing.JPanel panel_stock;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bill_number1;
    private javax.swing.JTextField txt_billno;
    private javax.swing.JTextField txt_billno_search;
    private javax.swing.JTextField txt_count;
    private javax.swing.JTextField txt_customer_bill_search;
    private javax.swing.JTextField txt_customer_name;
    private javax.swing.JTextField txt_customer_paid;
    private com.toedter.calendar.JDateChooser txt_date;
    // End of variables declaration//GEN-END:variables
}
