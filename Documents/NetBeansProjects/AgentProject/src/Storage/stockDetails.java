/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Database.DBconnection;
import home.HomeOverView;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.products;
import net.proteanit.sql.DbUtils;
import product.home;

/**
 *
 * @author Haran
 */
public class stockDetails extends javax.swing.JFrame {
    private final Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private boolean check_empty=false;
    private DefaultTableModel model,model2;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String current_id;
    private String stock_product_id;
    private ArrayList<products> my_pr_list;
    private DefaultTableModel model1;
    private String current_stocks_pr_id_val;
    private static String get_product_name;
     private int Xloc,Yloc;
    /**
     * Creates new form stockDetails
     */
    public stockDetails() {
        
        con=DBconnection.connectDB();
        initComponents();
        this.setOpacity(0.97f);
        jTabbedPane1.setBackground(Color.WHITE);
         Date date=new Date();
          stockdate.setMaxSelectableDate(date);
          stockdate.setMinSelectableDate(date);
        btn_cancel.setVisible(false);
        btn_delete.setVisible(false);
        btn_finished.setVisible(false);
        name_error.setText("");
        count_error.setText("");
        date_error.setText("");
        combo_pname.removeAllItems();
        update_productname.setEnabled(false);
        btn_change.setVisible(false);
        lbl_result.setText("");
//        btn_change.setBackground(Color.red);
//         btn_change.setForeground(Color.WHITE);
         
        stock_table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        stock_table.getTableHeader().setOpaque(false);
        stock_table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        stock_table.getTableHeader().setForeground(Color.BLACK);
        stock_table.setRowHeight(25);
         
         full_stock_view_table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        full_stock_view_table.getTableHeader().setOpaque(false);
        full_stock_view_table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        full_stock_view_table.getTableHeader().setForeground(Color.BLACK);
        full_stock_view_table.setRowHeight(25);
         
         
        setCombo();
        display();
         enableFinishedButton();
         display_full_model();
    }
    private void display_full_model(){
          String sql = "SELECT * FROM stocks";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
           finally{
               
                full_stock_view_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                model2=(DefaultTableModel) full_stock_view_table.getModel();//currently 
               
                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
    }
    private void set_current_stock_details(){
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
           
           stock_table.setModel(model1);
    }
    
  private void setCombo(){
        String sql="select  * from products where id !=ALL(select pid from stocks where check_val = ?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,"0");
            rs=ps.executeQuery();
            while(rs.next()){
                combo_pname.addItem(rs.getString(2));
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
        jPanel1 = new javax.swing.JPanel();
        combo_pname = new javax.swing.JComboBox<>();
        txt_count = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stock_table = new javax.swing.JTable();
        count_error = new javax.swing.JLabel();
        name_error = new javax.swing.JLabel();
        stockdate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        date_error = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel4 = new javax.swing.JPanel();
        btn_submit = new javax.swing.JPanel();
        lbl_add = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JPanel();
        lbl_cancel = new javax.swing.JLabel();
        btn_productdetails = new javax.swing.JPanel();
        lbl_pro = new javax.swing.JLabel();
        btn_delete = new javax.swing.JPanel();
        lbl_delete = new javax.swing.JLabel();
        btn_stockdetails = new javax.swing.JPanel();
        lbl_stock_details = new javax.swing.JLabel();
        btn_finished = new javax.swing.JPanel();
        lbl_finished = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        full_stock_view_table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        update_productname = new javax.swing.JTextField();
        update_productcount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_current_ids = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_available_stocks = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_productname = new javax.swing.JTextField();
        lbl_result = new javax.swing.JLabel();
        btn_change = new javax.swing.JPanel();
        lbl_change = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        exit_on_close = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();

        setUndecorated(true);

        jTabbedPane1.setBackground(new java.awt.Color(51, 153, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_count.setBorder(null);
        txt_count.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_countKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Product Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Stock Count");

        stock_table.setModel(new javax.swing.table.DefaultTableModel(
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
        stock_table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        stock_table.setRowHeight(25);
        stock_table.setSelectionBackground(new java.awt.Color(255, 51, 51));
        stock_table.setShowVerticalLines(false);
        stock_table.getTableHeader().setReorderingAllowed(false);
        stock_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stock_tableMouseClicked(evt);
            }
        });
        stock_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stock_tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(stock_table);

        count_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        count_error.setForeground(new java.awt.Color(255, 0, 0));
        count_error.setText("Error");

        name_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name_error.setForeground(new java.awt.Color(255, 0, 0));
        name_error.setText("Error");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date");

        date_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        date_error.setForeground(new java.awt.Color(255, 0, 0));
        date_error.setText("Error");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_submit.setBackground(new java.awt.Color(255, 255, 255));
        btn_submit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_submitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_submitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_submitMouseExited(evt);
            }
        });

        lbl_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_add.setText("         Add");

        javax.swing.GroupLayout btn_submitLayout = new javax.swing.GroupLayout(btn_submit);
        btn_submit.setLayout(btn_submitLayout);
        btn_submitLayout.setHorizontalGroup(
            btn_submitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        btn_submitLayout.setVerticalGroup(
            btn_submitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lbl_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cancel.setText("         Cancel");

        javax.swing.GroupLayout btn_cancelLayout = new javax.swing.GroupLayout(btn_cancel);
        btn_cancel.setLayout(btn_cancelLayout);
        btn_cancelLayout.setHorizontalGroup(
            btn_cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_cancelLayout.setVerticalGroup(
            btn_cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        btn_productdetails.setBackground(new java.awt.Color(255, 255, 255));
        btn_productdetails.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_productdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_productdetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_productdetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_productdetailsMouseExited(evt);
            }
        });

        lbl_pro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_pro.setText("   product details");

        javax.swing.GroupLayout btn_productdetailsLayout = new javax.swing.GroupLayout(btn_productdetails);
        btn_productdetails.setLayout(btn_productdetailsLayout);
        btn_productdetailsLayout.setHorizontalGroup(
            btn_productdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_pro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );
        btn_productdetailsLayout.setVerticalGroup(
            btn_productdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_pro, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

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

        lbl_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_delete.setText("         Delete");

        javax.swing.GroupLayout btn_deleteLayout = new javax.swing.GroupLayout(btn_delete);
        btn_delete.setLayout(btn_deleteLayout);
        btn_deleteLayout.setHorizontalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_deleteLayout.setVerticalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        btn_stockdetails.setBackground(new java.awt.Color(255, 255, 255));
        btn_stockdetails.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_stockdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_stockdetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_stockdetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_stockdetailsMouseExited(evt);
            }
        });

        lbl_stock_details.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_stock_details.setText("    Stock Details");

        javax.swing.GroupLayout btn_stockdetailsLayout = new javax.swing.GroupLayout(btn_stockdetails);
        btn_stockdetails.setLayout(btn_stockdetailsLayout);
        btn_stockdetailsLayout.setHorizontalGroup(
            btn_stockdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock_details, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        btn_stockdetailsLayout.setVerticalGroup(
            btn_stockdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lbl_finished.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_finished.setText("      Finished");

        javax.swing.GroupLayout btn_finishedLayout = new javax.swing.GroupLayout(btn_finished);
        btn_finished.setLayout(btn_finishedLayout);
        btn_finishedLayout.setHorizontalGroup(
            btn_finishedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_finishedLayout.createSequentialGroup()
                .addComponent(lbl_finished, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_finishedLayout.setVerticalGroup(
            btn_finishedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_finished, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_finished, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_stockdetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_productdetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_productdetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_stockdetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_finished, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(combo_pname, 0, 250, Short.MAX_VALUE)
                            .addComponent(txt_count))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(name_error, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_error, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockdate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(count_error, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addComponent(jSeparator2)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(combo_pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(name_error)
                        .addComponent(jLabel3))
                    .addComponent(stockdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(count_error)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(date_error)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        full_stock_view_table.setModel(new javax.swing.table.DefaultTableModel(
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
        full_stock_view_table.setGridColor(new java.awt.Color(204, 204, 204));
        full_stock_view_table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        full_stock_view_table.setRowHeight(25);
        full_stock_view_table.setSelectionBackground(new java.awt.Color(255, 51, 51));
        full_stock_view_table.setShowVerticalLines(false);
        full_stock_view_table.getTableHeader().setReorderingAllowed(false);
        full_stock_view_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                full_stock_view_tableMouseClicked(evt);
            }
        });
        full_stock_view_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                full_stock_view_tableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(full_stock_view_table);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ProductName");

        update_productname.setBorder(null);

        update_productcount.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Count");

        txt_current_ids.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_current_ids.setText("Stock-Id");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Available_In_stocks");

        txt_available_stocks.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Search_product");

        txt_productname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_productnameKeyReleased(evt);
            }
        });

        lbl_result.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_result.setForeground(new java.awt.Color(0, 153, 51));
        lbl_result.setText("Results");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txt_productname, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_result, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txt_productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_result)
                .addGap(74, 74, 74))
        );

        btn_change.setBackground(new java.awt.Color(255, 255, 255));
        btn_change.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_changeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_changeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_changeMouseExited(evt);
            }
        });

        lbl_change.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_change.setText("                Change");

        javax.swing.GroupLayout btn_changeLayout = new javax.swing.GroupLayout(btn_change);
        btn_change.setLayout(btn_changeLayout);
        btn_changeLayout.setHorizontalGroup(
            btn_changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_change, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_changeLayout.setVerticalGroup(
            btn_changeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_change, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_current_ids, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(update_productcount, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(update_productname)
                                    .addComponent(jSeparator4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_change, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator5)
                                    .addComponent(txt_available_stocks, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_current_ids)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(update_productname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(update_productcount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_available_stocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("stock_update", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Stock Details");

        exit_on_close.setBackground(new java.awt.Color(255, 255, 255));
        exit_on_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_on_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_on_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_on_closeMouseExited(evt);
            }
        });

        lbl_close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_close.setText(" X");

        javax.swing.GroupLayout exit_on_closeLayout = new javax.swing.GroupLayout(exit_on_close);
        exit_on_close.setLayout(exit_on_closeLayout);
        exit_on_closeLayout.setHorizontalGroup(
            exit_on_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exit_on_closeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exit_on_closeLayout.setVerticalGroup(
            exit_on_closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_close)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exit_on_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(exit_on_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stock_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stock_tableMouseClicked
        txt_count.setText(String.valueOf(model.getValueAt(stock_table.getSelectedRow(),3)));
        combo_pname.removeAllItems();
        combo_pname.addItem(String.valueOf(model.getValueAt(stock_table.getSelectedRow(),2)));
        Date dateValue3=null;
        SimpleDateFormat date3 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dateValue3 = date3.parse(String.valueOf(model.getValueAt(stock_table.getSelectedRow(),4)));
            stockdate.setDate(dateValue3);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        btn_submit.setVisible(false);
       
        btn_cancel.setVisible(true);
        btn_delete.setVisible(true);
        current_id=String.valueOf(model.getValueAt(stock_table.getSelectedRow(),0));
    }//GEN-LAST:event_stock_tableMouseClicked

    private void txt_countKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_countKeyReleased
        String value=txt_count.getText();
        try{
            Integer.parseInt(value);
        }
        catch(NumberFormatException e){
            txt_count.setText("");
            JOptionPane.showMessageDialog(null,"Field should include only integer numbers");
        }
    }//GEN-LAST:event_txt_countKeyReleased
    private void AddRemainingProducts(ArrayList<String> lists){
        for(String value:lists){
           String pr_id= getRemainingProductsId(value);
             String sql="insert into stocks(pid,product_name,available,date) values(?,?,?,?)";

            try{
                ps=con.prepareStatement(sql);
                ps.setString(1,pr_id);
                ps.setString(2,value);
                ps.setDouble(3,0);
                ps.setString(4,formatter.format(stockdate.getDate()));
                ps.execute();
                
            }

            catch(HeadlessException | NumberFormatException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    private ArrayList<products> update_current_product_details(){
        ArrayList<products> pr_list=new ArrayList<>();
        String sql="select * from stocks where check_val=0";
        try{
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                products pr=new products();
                pr.setProduct_id(rs.getString(2));
                pr.setProduct_name(rs.getString(3));
                pr.setCount(rs.getString(4));
                
                pr_list.add(pr);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        my_pr_list=pr_list;
        return pr_list;
    }
    private ArrayList<products> update_current_products_details(ArrayList<products> pr_list){
        ArrayList<products> new_pr_list=new ArrayList<>();
      String sql="SELECT * FROM `current_stocks` WHERE update_value=(select max(update_value) from current_stocks)";
      try{
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()){
             for(products pr:pr_list){
                 if(rs.getString(2).equals(pr.getProduct_id())){
                     products new_pr=new products();
                     new_pr.setId(rs.getString(1));
                     new_pr.setProduct_id(rs.getString(2));
                     new_pr.setProduct_name(rs.getString(3));
                     new_pr.setCount(String.valueOf(Integer.parseInt(rs.getString(4))+Integer.parseInt(pr.getCount())));
                     new_pr_list.add(new_pr);
                 }
             }
         }
      }
      catch(Exception e){
          e.printStackTrace();
      }
      finally{
         
            try {
                 ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
     
       
       return new_pr_list;
    }
    private String get_update_value(){
        String value="";
        String sql="select max(update_value) from current_stocks";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                value=rs.getString(1);
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
       return value; 
    }
    private void insert_current_products(ArrayList<products> pr_list){
        ArrayList<products> new_pr_list=new ArrayList<>();
         String sql2="SELECT * FROM `stocks` WHERE  pid != All(select pid from current_stocks WHERE update_value=(select max(update_value) from current_stocks)) and check_val=0";
       try{
         ps=con.prepareStatement(sql2);
         rs=ps.executeQuery();
         while(rs.next()){
             for(products pr:my_pr_list){
                 if(rs.getString(2).equals(pr.getProduct_id())){
                     products new_pr=new products();
                     new_pr.setProduct_id(rs.getString(2));
                     new_pr.setProduct_name(rs.getString(3));
                     new_pr.setCount(String.valueOf(Integer.parseInt(rs.getString(4))));
                     new_pr_list.add(new_pr);
                 }
             }
         }
      }
      catch(Exception e){
          e.printStackTrace();
      }
      finally{
         
            try {
                 ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
       
       
          
          String update_val=get_update_value();
          if(update_val==null){
               update_val="0";
               String sql4="insert into current_stocks(pid,product_name,available,update_value) values(?,?,?,?)";
      //          JOptionPane.showMessageDialog(null, update_val);
              for(products pro:pr_list){
                      try{
                          ps=con.prepareStatement(sql4);
                          ps.setString(1,pro.getProduct_id());
                          ps.setString(2,pro.getProduct_name());
                          ps.setString(3,pro.getCount());
                          ps.setString(4,update_val);
                          ps.execute();

                      }

                      catch(HeadlessException | NumberFormatException | SQLException e){
                          JOptionPane.showMessageDialog(null, e);
                      }
                      finally{
                          try {
                              ps.close();
                          } catch (SQLException ex) {
                              Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      }
                }
            }
            else{
                
      //          JOptionPane.showMessageDialog(null, update_val);
              for(products pro:pr_list){
                    String sql4="update  current_stocks set pid=?,product_name=?,available=?,update_value=? where id='"+pro.getId()+"'";
                      try{
                          ps=con.prepareStatement(sql4);
                          ps.setString(1,pro.getProduct_id());
                          ps.setString(2,pro.getProduct_name());
                          ps.setString(3,pro.getCount());
                          ps.setString(4,update_val);
                          ps.execute();

                      }

                      catch(HeadlessException | NumberFormatException | SQLException e){
                          JOptionPane.showMessageDialog(null, e);
                      }
                      finally{
                          try {
                              ps.close();
                          } catch (SQLException ex) {
                              Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      }
                }
            }
          String sql="insert into current_stocks(pid,product_name,available,update_value) values(?,?,?,?)";
//          JOptionPane.showMessageDialog(null, update_val);
        for(products pro:new_pr_list){
                try{
                    ps=con.prepareStatement(sql);
                    ps.setString(1,pro.getProduct_id());
                    ps.setString(2,pro.getProduct_name());
                    ps.setString(3,pro.getCount());
                    ps.setString(4,update_val);
                    ps.execute();
                    
                }

                catch(HeadlessException | NumberFormatException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                }
                finally{
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }  
    }
    private void txt_productnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_productnameKeyReleased
       
        try {
            String sql="select * from stocks where product_name like '"+txt_productname.getText()+"%'";
            st=con.createStatement();
            rs=st.executeQuery(sql);
          
             full_stock_view_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                model2=(DefaultTableModel) full_stock_view_table.getModel();//currently add
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
          try {
            String sql1="select * from stocks where product_name like '"+txt_productname.getText()+"%'";
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
    }//GEN-LAST:event_txt_productnameKeyReleased
    private void display_get_current_stock_table(){
          
        try {
            String sql="select * from stocks where product_name like '"+txt_productname.getText()+"%'";
            st=con.createStatement();
            rs=st.executeQuery(sql);
          
             full_stock_view_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                model2=(DefaultTableModel) full_stock_view_table.getModel();//currently add
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
    
    private void full_stock_view_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_full_stock_view_tableMouseClicked
         btn_change.setVisible(true);
        update_productname.setText(String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),2)));
         update_productcount.setText(String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),3)));
         txt_current_ids.setText(String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),0)));
         stock_product_id=String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),3));
         current_stocks_pr_id_val=String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),1));
         set_available_stocks_details();
    }//GEN-LAST:event_full_stock_view_tableMouseClicked

    private void stock_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stock_tableKeyPressed
       
    }//GEN-LAST:event_stock_tableKeyPressed

    private void full_stock_view_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_full_stock_view_tableKeyReleased
          if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
             btn_change.setVisible(true);
             update_productname.setText(String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),2)));
             update_productcount.setText(String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),3)));
             txt_current_ids.setText(String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),0)));
             stock_product_id=String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),3));
             current_stocks_pr_id_val=String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),1));
             set_available_stocks_details();
        }
    }//GEN-LAST:event_full_stock_view_tableKeyReleased

    private void exit_on_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_on_closeMouseEntered
        lbl_close.setForeground(Color.WHITE);
        exit_on_close.setBackground(Color.BLACK);
    }//GEN-LAST:event_exit_on_closeMouseEntered

    private void exit_on_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_on_closeMouseExited
         lbl_close.setForeground(Color.BLACK);
         exit_on_close.setBackground(Color.WHITE);
    }//GEN-LAST:event_exit_on_closeMouseExited

    private void exit_on_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_on_closeMouseClicked
           this.processWindowEvent(
                        new WindowEvent(
                                this, WindowEvent.WINDOW_CLOSING));
           HomeOverView hm=new HomeOverView();
           hm.setVisible(true);
    }//GEN-LAST:event_exit_on_closeMouseClicked

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int X=evt.getXOnScreen();
       int Y=evt.getYOnScreen();
        setLocation(X-Xloc, Y-Yloc);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
         Xloc=evt.getX();
         Yloc=evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void btn_submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_submitMouseClicked
          boolean isCorrect= check_details();
        if(isCorrect){
            String pr_id=getProductId();
            String sql="insert into stocks(pid,product_name,available,date) values(?,?,?,?)";

            try{
                ps=con.prepareStatement(sql);
                ps.setString(1,pr_id);
                ps.setString(2,combo_pname.getSelectedItem().toString());
                ps.setDouble(3,Integer.parseInt(txt_count.getText()));
                ps.setString(4,formatter.format(stockdate.getDate()));
                ps.execute();
                JOptionPane.showMessageDialog(null, "Sucessfully Added");
            }

            catch(HeadlessException | NumberFormatException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            txt_count.setText("");
//            stockdate.setDate(null);
            combo_pname.removeAllItems();
            setCombo();
            display();
            enableFinishedButton();
            display_full_model();
        }

    }//GEN-LAST:event_btn_submitMouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
         btn_submit.setVisible(true);
        btn_cancel.setVisible(false);
        btn_delete.setVisible(false);
        combo_pname.removeAllItems();
        setCombo();
        txt_count.setText("");
        stockdate.setDate(null);
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_productdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productdetailsMouseClicked
         display();
    }//GEN-LAST:event_btn_productdetailsMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        String sql="delete from stocks where id='"+current_id+"'";
        try {
            ps=con.prepareStatement(sql);
            int rowdeleted=ps.executeUpdate();

            if(rowdeleted > 0){
                JOptionPane.showMessageDialog(null,"sucessfully deleted");
            }
            else{
                JOptionPane.showMessageDialog(null,"cannot delete");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        combo_pname.removeAllItems();
        setCombo();
        display();
        txt_count.setText("");
        stockdate.setDate(null);
        display_full_model();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_stockdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockdetailsMouseClicked
        set_current_stock_details();
        btn_delete.setVisible(false);
    }//GEN-LAST:event_btn_stockdetailsMouseClicked

    private void btn_finishedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finishedMouseClicked
           int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Finished all details?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(stockdate.getDate()!=null){
                ArrayList<String> lists=new ArrayList<>();
                lists= setRemainingProducts();
                AddRemainingProducts(lists);
               
                insert_current_products(update_current_products_details( update_current_product_details()));
                String ch_value="0";
                String sql="update stocks set check_val=? where check_val='"+ch_value+"'";
                try{
                     ps= con.prepareStatement(sql);
                     ps.setString(1,"1");
                     int rowsAffected=ps.executeUpdate();

                     if(rowsAffected > 0){
                       JOptionPane.showMessageDialog(null,"Update sucessfully!!!");
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"The work is already done!!!");
                     }
                }
                catch(HeadlessException | SQLException e){
                    Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, e);
                }
                finally{
                      try {
                          ps.close();
                      } catch (SQLException ex) {
                          Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }

              set_current_stock_details();
              combo_pname.removeAllItems();
              setCombo();
              enableFinishedButton();
              btn_delete.setVisible(false);
              display_full_model();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Date is null!!!");
            }
        }
    }//GEN-LAST:event_btn_finishedMouseClicked

    private void btn_submitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_submitMouseEntered
       lbl_add.setForeground(Color.WHITE);
       btn_submit.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_submitMouseEntered

    private void btn_submitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_submitMouseExited
          lbl_add.setForeground(Color.BLACK);
        btn_submit.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_submitMouseExited

    private void btn_stockdetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockdetailsMouseEntered
         lbl_stock_details.setForeground(Color.WHITE);
       btn_stockdetails.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_stockdetailsMouseEntered

    private void btn_stockdetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockdetailsMouseExited
          lbl_stock_details.setForeground(Color.BLACK);
        btn_stockdetails.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_stockdetailsMouseExited

    private void btn_productdetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productdetailsMouseEntered
         lbl_pro.setForeground(Color.WHITE);
         btn_productdetails.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_productdetailsMouseEntered

    private void btn_productdetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productdetailsMouseExited
           lbl_pro.setForeground(Color.BLACK);
           btn_productdetails.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_productdetailsMouseExited

    private void btn_finishedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finishedMouseEntered
       lbl_finished.setForeground(Color.WHITE);
         btn_finished.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_finishedMouseEntered

    private void btn_finishedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finishedMouseExited
        lbl_finished.setForeground(Color.BLACK);
           btn_finished.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_finishedMouseExited

    private void btn_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseEntered
        lbl_delete.setForeground(Color.WHITE);
         btn_delete.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_deleteMouseEntered

    private void btn_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseExited
         lbl_delete.setForeground(Color.BLACK);
           btn_delete.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_deleteMouseExited

    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseEntered
       lbl_cancel.setForeground(Color.WHITE);
         btn_cancel.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_cancelMouseEntered

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
         lbl_cancel.setForeground(Color.BLACK);
           btn_cancel.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_changeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_changeMouseClicked
         String total;
        String sql="update stocks set available=? where id='"+txt_current_ids.getText()+"'";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,update_productcount.getText());
            ps.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
          String sql1="update current_stocks set available=? where pid='"+current_stocks_pr_id_val+"'";
        try {
             ps=con.prepareStatement(sql1);
             ps.setString(1,String.valueOf(Integer.parseInt(txt_available_stocks.getText())+Integer.parseInt(update_productcount.getText())- Integer.parseInt(stock_product_id)));
             ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(stockDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(txt_productname.getText().isEmpty()){
             display_full_model();
        }
        else{
            display_get_current_stock_table();
        }
         
         display();
         txt_available_stocks.setText(String.valueOf(Integer.parseInt(txt_available_stocks.getText())+Integer.parseInt(update_productcount.getText())- Integer.parseInt(stock_product_id)));
        stock_product_id=update_productcount.getText();
    }//GEN-LAST:event_btn_changeMouseClicked

    private void btn_changeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_changeMouseEntered
        lbl_change.setForeground(Color.WHITE);
         btn_change.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_changeMouseEntered

    private void btn_changeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_changeMouseExited
         lbl_change.setForeground(Color.BLACK);
           btn_change.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_changeMouseExited
    private void set_available_stocks_details(){
          String sql1="select * from current_stocks  where pid=?";
        try {
            ps=con.prepareStatement(sql1);
            ps.setString(1,String.valueOf(model2.getValueAt(full_stock_view_table.getSelectedRow(),1)));
            rs=ps.executeQuery();
            while(rs.next()){
                 txt_available_stocks.setText(rs.getString(4));
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
    }
    private ArrayList<String> setRemainingProducts(){
        ArrayList<String> lists=new ArrayList<>();
          String sql="select  * from products where id !=ALL(select pid from stocks where check_val = ?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1,"0");
            rs=ps.executeQuery();
            while(rs.next()){
                
                lists.add(rs.getString(2));
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
        return lists;
    }
    private boolean check_details() {
        boolean isCorrect=true;
        if(txt_count.getText().isEmpty()){
            count_error.setText("Field is empty");
            isCorrect=false;
        }
        else{
              count_error.setText("");
        }
        if(stockdate.getDate()==null){
            date_error.setText("Date is required");
            isCorrect=false;
        }
        else{
            date_error.setText("");
            
        }
        return  isCorrect;
    }
    private String getRemainingProductsId(String name){
         String pid=null;
        String sql="select  * from products";
        try{
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               if(name.equals(rs.getString(2))){
                  pid=rs.getString(1);
               }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return pid;
    }
    private String getProductId() {
        String pid=null;
        String sql="select  * from products";
        try{
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               if(combo_pname.getSelectedItem().toString().equals(rs.getString(2))){
                  pid=rs.getString(1);
               }
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        finally{
            try {
                st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return pid;
    }
    private void enableFinishedButton(){
         String sql = "SELECT * FROM stocks where check_val=0";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
               int size =0;
                if (rs != null) 
                {
                  rs.last();    // moves cursor to the last row
                  size = rs.getRow(); // get row id 
                }
               if(size > 0){
                   btn_finished.setVisible(true);
               }
               else{
                   btn_finished.setVisible(false);
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
     private void display(){
           String sql = "SELECT * FROM stocks where check_val=0";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
           finally{
               
                stock_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                model=(DefaultTableModel)stock_table.getModel();//currently add
                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
          
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
            java.util.logging.Logger.getLogger(stockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stockDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_cancel;
    private javax.swing.JPanel btn_change;
    private javax.swing.JPanel btn_delete;
    private javax.swing.JPanel btn_finished;
    private javax.swing.JPanel btn_productdetails;
    private javax.swing.JPanel btn_stockdetails;
    private javax.swing.JPanel btn_submit;
    private javax.swing.JComboBox<String> combo_pname;
    private javax.swing.JLabel count_error;
    private javax.swing.JLabel date_error;
    private javax.swing.JPanel exit_on_close;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTable full_stock_view_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_add;
    private javax.swing.JLabel lbl_cancel;
    private javax.swing.JLabel lbl_change;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_delete;
    private javax.swing.JLabel lbl_finished;
    private javax.swing.JLabel lbl_pro;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JLabel lbl_stock_details;
    private javax.swing.JLabel name_error;
    private javax.swing.JTable stock_table;
    private com.toedter.calendar.JDateChooser stockdate;
    private javax.swing.JTextField txt_available_stocks;
    private javax.swing.JTextField txt_count;
    private javax.swing.JLabel txt_current_ids;
    private javax.swing.JTextField txt_productname;
    private javax.swing.JTextField update_productcount;
    private javax.swing.JTextField update_productname;
    // End of variables declaration//GEN-END:variables

    

   
}
