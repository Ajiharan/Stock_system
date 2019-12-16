/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import Database.DBconnection;
import com.jtattoo.plaf.DecorationHelper;
import home.HomeOverView;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Haran
 */
public class home extends javax.swing.JFrame {
    private final Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    private boolean check_empty=false;
    private DefaultTableModel model,model1;
     private int Xloc,Yloc;
    /**
     * Creates new form home
     */
    public home() {
        
        con=DBconnection.connectDB();
        initComponents();
        price_error.setText("");
        name_error.setText("");
        cat_error.setText("");
        btn_delete.setVisible(false);
        btn_update.setVisible(false);
        btn_cancel.setVisible(false);
        product_table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        product_table.getTableHeader().setOpaque(false);
         product_table.getTableHeader().setBackground(Color.LIGHT_GRAY);
          product_table.getTableHeader().setForeground(Color.BLACK);
          product_table.setRowHeight(25);
          
            product_search_table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
         product_search_table.getTableHeader().setOpaque(false);
          product_search_table.getTableHeader().setBackground(Color.LIGHT_GRAY);
          product_search_table.getTableHeader().setForeground(Color.BLACK);
           product_search_table.setRowHeight(25);
           jSeparator3.setForeground(Color.red);
           this.setOpacity(0.98f);
        display();
        setCombo();
        check_combo();
      
    }
    private void check_combo(){
          if(combo_category.getItemCount()<= 0){
            btn_add.setVisible(false);
            btn_clear.setVisible(false);
            cat_error.setText("Add some category");
        }
        else{
            
              btn_add.setVisible(true);
            cat_error.setText("");
        }    
    }
    public  void reset_combo(){
       combo_category.removeAllItems();
       setCombo();
       display();
       check_combo();
    }
    private void setCombo(){
        String sql="select  * from product_category";
        try{
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                combo_category.addItem(rs.getString(2));
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
    }
   
    private void display(){
           String sql = "SELECT * FROM products";
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql); 
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
           finally{
               
                product_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
                model=(DefaultTableModel)product_table.getModel();//currently add
                try {
                    st.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
           int rows=0;
           try{
               st=con.createStatement();
               rs=st.executeQuery(sql);
               while(rs.next()){
                   rows++;
                   String id=rs.getString(1);
                   pr_id.setText("PR-"+(Integer.parseInt(id.substring(3,8)) + 1));
               }
               if(rows < 1){
                   pr_id.setText("PR-11111");
               }            
           }
           catch(NumberFormatException | SQLException e){
                 pr_id.setText("PR-11111");
                JOptionPane.showMessageDialog(null, e);
           }
           finally{
             
                try {
                    rs.close();
                    st.close();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pr_id = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        scroll_pane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        name_error = new javax.swing.JLabel();
        price_error = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_search_table = new javax.swing.JTable();
        combo_category = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cat_error = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        close_panel1 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add_category = new javax.swing.JPanel();
        lbl_add_category = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JPanel();
        lbl_cancel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        stock_panal = new javax.swing.JPanel();
        lbl_stock = new javax.swing.JLabel();
        bill_panal = new javax.swing.JPanel();
        lbl_bill = new javax.swing.JLabel();
        free_panel = new javax.swing.JPanel();
        lbl_free = new javax.swing.JLabel();
        exit_panel = new javax.swing.JPanel();
        lbl_exit = new javax.swing.JLabel();
        home_panal = new javax.swing.JPanel();
        lbl_home = new javax.swing.JLabel();
        btn_update = new javax.swing.JPanel();
        lbl_update = new javax.swing.JLabel();
        btn_clear = new javax.swing.JPanel();
        lbl_clear = new javax.swing.JLabel();
        btn_delete = new javax.swing.JPanel();
        lbl_delete = new javax.swing.JLabel();
        btn_add = new javax.swing.JPanel();
        lbl_add = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setExtendedState(5);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("product_name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("product_price");

        pr_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pr_id.setText("product_id");

        txt_name.setBorder(null);

        txt_price.setBorder(null);
        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priceKeyReleased(evt);
            }
        });

        product_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        product_table.setModel(new javax.swing.table.DefaultTableModel(
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
        product_table.setRowHeight(25);
        product_table.setSelectionBackground(new java.awt.Color(255, 51, 51));
        product_table.getTableHeader().setReorderingAllowed(false);
        product_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tableMouseClicked(evt);
            }
        });
        product_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                product_tableKeyReleased(evt);
            }
        });
        scroll_pane1.setViewportView(product_table);

        name_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name_error.setForeground(new java.awt.Color(255, 0, 0));
        name_error.setText("Error");

        price_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        price_error.setForeground(new java.awt.Color(255, 0, 0));
        price_error.setText("Error");

        product_search_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        product_search_table.setModel(new javax.swing.table.DefaultTableModel(
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
        product_search_table.setSelectionBackground(new java.awt.Color(255, 51, 51));
        product_search_table.getTableHeader().setReorderingAllowed(false);
        product_search_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_search_tableMouseClicked(evt);
            }
        });
        product_search_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                product_search_tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(product_search_table);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Category");

        cat_error.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cat_error.setForeground(new java.awt.Color(255, 0, 0));
        cat_error.setText("Error");

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        close_panel1.setBackground(new java.awt.Color(255, 255, 255));
        close_panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_panel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_panel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_panel1MouseExited(evt);
            }
        });

        lbl_close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_close.setText("   X");

        javax.swing.GroupLayout close_panel1Layout = new javax.swing.GroupLayout(close_panel1);
        close_panel1.setLayout(close_panel1Layout);
        close_panel1Layout.setHorizontalGroup(
            close_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );
        close_panel1Layout.setVerticalGroup(
            close_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Products Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(558, 558, 558)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
                .addComponent(close_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(close_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_add_category.setBackground(new java.awt.Color(255, 255, 255));
        btn_add_category.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_add_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_categoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add_categoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add_categoryMouseExited(evt);
            }
        });

        lbl_add_category.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_add_category.setText("       Add Category");

        javax.swing.GroupLayout btn_add_categoryLayout = new javax.swing.GroupLayout(btn_add_category);
        btn_add_category.setLayout(btn_add_categoryLayout);
        btn_add_categoryLayout.setHorizontalGroup(
            btn_add_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add_category, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        btn_add_categoryLayout.setVerticalGroup(
            btn_add_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add_category, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lbl_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cancel.setText("         Cancel");

        javax.swing.GroupLayout btn_cancelLayout = new javax.swing.GroupLayout(btn_cancel);
        btn_cancel.setLayout(btn_cancelLayout);
        btn_cancelLayout.setHorizontalGroup(
            btn_cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
        btn_cancelLayout.setVerticalGroup(
            btn_cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        stock_panal.setBackground(new java.awt.Color(255, 255, 255));
        stock_panal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        stock_panal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stock_panalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stock_panalMouseExited(evt);
            }
        });

        lbl_stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_stock.setText("    Stock");

        javax.swing.GroupLayout stock_panalLayout = new javax.swing.GroupLayout(stock_panal);
        stock_panal.setLayout(stock_panalLayout);
        stock_panalLayout.setHorizontalGroup(
            stock_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        stock_panalLayout.setVerticalGroup(
            stock_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_stock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        bill_panal.setBackground(new java.awt.Color(255, 255, 255));
        bill_panal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bill_panal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bill_panalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bill_panalMouseExited(evt);
            }
        });

        lbl_bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_bill.setText("      Bill");

        javax.swing.GroupLayout bill_panalLayout = new javax.swing.GroupLayout(bill_panal);
        bill_panal.setLayout(bill_panalLayout);
        bill_panalLayout.setHorizontalGroup(
            bill_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_bill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bill_panalLayout.setVerticalGroup(
            bill_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_bill, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        free_panel.setBackground(new java.awt.Color(255, 255, 255));
        free_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        free_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                free_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                free_panelMouseExited(evt);
            }
        });

        lbl_free.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_free.setText("     Free");

        javax.swing.GroupLayout free_panelLayout = new javax.swing.GroupLayout(free_panel);
        free_panel.setLayout(free_panelLayout);
        free_panelLayout.setHorizontalGroup(
            free_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_free, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        free_panelLayout.setVerticalGroup(
            free_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_free, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        exit_panel.setBackground(new java.awt.Color(255, 255, 255));
        exit_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        exit_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_panelMouseExited(evt);
            }
        });

        lbl_exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_exit.setText("     Exit");

        javax.swing.GroupLayout exit_panelLayout = new javax.swing.GroupLayout(exit_panel);
        exit_panel.setLayout(exit_panelLayout);
        exit_panelLayout.setHorizontalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        exit_panelLayout.setVerticalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        home_panal.setBackground(new java.awt.Color(255, 255, 255));
        home_panal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        home_panal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_panalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_panalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_panalMouseExited(evt);
            }
        });

        lbl_home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_home.setText("    Home");

        javax.swing.GroupLayout home_panalLayout = new javax.swing.GroupLayout(home_panal);
        home_panal.setLayout(home_panalLayout);
        home_panalLayout.setHorizontalGroup(
            home_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_home, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );
        home_panalLayout.setVerticalGroup(
            home_panalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_home, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock_panal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(free_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bill_panal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home_panal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(home_panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(stock_panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bill_panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(free_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(exit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        lbl_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_update.setText("          update");

        javax.swing.GroupLayout btn_updateLayout = new javax.swing.GroupLayout(btn_update);
        btn_update.setLayout(btn_updateLayout);
        btn_updateLayout.setHorizontalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );
        btn_updateLayout.setVerticalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_update, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        btn_clear.setBackground(new java.awt.Color(255, 255, 255));
        btn_clear.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_clearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_clearMouseExited(evt);
            }
        });

        lbl_clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_clear.setText("          clear");

        javax.swing.GroupLayout btn_clearLayout = new javax.swing.GroupLayout(btn_clear);
        btn_clear.setLayout(btn_clearLayout);
        btn_clearLayout.setHorizontalGroup(
            btn_clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
        );
        btn_clearLayout.setVerticalGroup(
            btn_clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lbl_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_delete.setText("      Delete");

        javax.swing.GroupLayout btn_deleteLayout = new javax.swing.GroupLayout(btn_delete);
        btn_delete.setLayout(btn_deleteLayout);
        btn_deleteLayout.setHorizontalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );
        btn_deleteLayout.setVerticalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        lbl_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_add.setText("      Add");

        javax.swing.GroupLayout btn_addLayout = new javax.swing.GroupLayout(btn_add);
        btn_add.setLayout(btn_addLayout);
        btn_addLayout.setHorizontalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );
        btn_addLayout.setVerticalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search Products");

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel3)))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 0, 51));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(pr_id)
                            .addComponent(btn_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_category, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(price_error, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cat_error, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(name_error, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btn_add_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scroll_pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combo_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cat_error)
                                    .addComponent(jLabel4))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(price_error))
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pr_id)
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(name_error)
                                            .addComponent(jLabel1)))
                                    .addComponent(jSeparator4)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_add_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(scroll_pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1315, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean check_variables(){
           check_empty =false;
        if(txt_name.getText().isEmpty()){
            txt_name.setFocusable(true);
            name_error.setText("Name is Empty");
            check_empty=true;
        }
        else{
            name_error.setText("");
        }
       if(txt_price.getText().isEmpty()){
           price_error.setText("Price is Empty");
            check_empty=true;
        }
       else{
           price_error.setText("");
       }
       return check_empty;
    }
    private void get_search_results(){
          String sql="select * from products where id or name like '"+txt_search.getText()+"%'";
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             product_search_table.setModel(DbUtils.resultSetToTableModel(rs));//show all employee details in a table
             model1=(DefaultTableModel)product_search_table.getModel();//currently add
            try {
                 st.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }    
    }
    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

       get_search_results();
    }//GEN-LAST:event_txt_searchKeyReleased

    private void product_search_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_search_tableMouseClicked
         txt_name.setText(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),1)));
        txt_price.setText(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),2)));
        pr_id.setText(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),0)));
       
        combo_category.setSelectedItem(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),3)));
           btn_update.setVisible(true);
        btn_delete.setVisible(true);
        btn_cancel.setVisible(true);
        btn_add.setVisible(false);
    }//GEN-LAST:event_product_search_tableMouseClicked

    private void txt_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyReleased
        String value=txt_price.getText();
        try{
            Double.parseDouble(value);
        }
        catch(NumberFormatException e){
            txt_price.setText("");
            JOptionPane.showMessageDialog(null,"Field should include only numbers");
        }
        
    }//GEN-LAST:event_txt_priceKeyReleased

    private void product_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tableMouseClicked
        txt_name.setText(String.valueOf(model.getValueAt(product_table.getSelectedRow(),1)));
        txt_price.setText(String.valueOf(model.getValueAt(product_table.getSelectedRow(),2)));
        pr_id.setText(String.valueOf(model.getValueAt(product_table.getSelectedRow(),0)));
        combo_category.setSelectedItem(String.valueOf(model.getValueAt(product_table.getSelectedRow(),3)));

        btn_update.setVisible(true);
        btn_delete.setVisible(true);
        btn_cancel.setVisible(true);
        btn_add.setVisible(false);

    }//GEN-LAST:event_product_tableMouseClicked

    private void close_panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panel1MouseClicked
        this.processWindowEvent(
                        new WindowEvent(
                                this, WindowEvent.WINDOW_CLOSING));
         HomeOverView hm=new HomeOverView();
           hm.setVisible(true);
                                        
    }//GEN-LAST:event_close_panel1MouseClicked

    private void close_panel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panel1MouseEntered
       lbl_close.setForeground(Color.WHITE);
       close_panel1.setBackground(Color.BLACK);
    }//GEN-LAST:event_close_panel1MouseEntered

    private void close_panel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panel1MouseExited
        lbl_close.setForeground(Color.BLACK);
        close_panel1.setBackground(Color.WHITE);
    }//GEN-LAST:event_close_panel1MouseExited

    private void btn_add_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_categoryMouseClicked
         CategoryTable cat=new CategoryTable();
        cat.getHomeObject(this);
        cat.setVisible(true);
    }//GEN-LAST:event_btn_add_categoryMouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
          btn_update.setVisible(false);
        btn_delete.setVisible(false);
        txt_name.setText("");
        txt_price.setText("");
        btn_add.setVisible(true);
        btn_cancel.setVisible(false);
        display();
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
         if(!check_variables()){
            String sql="update products set name= ?,price= ?,category= ? where id='"+pr_id.getText()+"'";
            try {
                ps= con.prepareStatement(sql);
                ps.setString(1, txt_name.getText());
                ps.setString(2,txt_price.getText());
                ps.setString(3,combo_category.getSelectedItem().toString()
                );
                int rowsAffected=ps.executeUpdate();

                if(rowsAffected > 0){
                    JOptionPane.showMessageDialog(null,"Update sucessfully!!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }

            }

            display();
            get_search_results();
        }
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
          txt_name.setText("");
        txt_price.setText("");
    }//GEN-LAST:event_btn_clearMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
          String sql="delete from products where id='"+pr_id.getText()+"'";
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
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          try {
              ps.close();
          } catch (SQLException ex) {
              Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        display(); 
        get_search_results();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
         if(!check_variables()){
          add_details();
          txt_name.setText("");
          txt_price.setText("");
          get_search_results();
       }
         
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseEntered
        lbl_cancel.setForeground(Color.WHITE);
       btn_cancel.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_cancelMouseEntered

    private void btn_cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseExited
        lbl_cancel.setForeground(Color.BLACK);
        btn_cancel.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_cancelMouseExited

    private void btn_add_categoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_categoryMouseEntered
        lbl_add_category.setForeground(Color.WHITE);
      btn_add_category.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_add_categoryMouseEntered

    private void btn_add_categoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_categoryMouseExited
        lbl_add_category.setForeground(Color.BLACK);
       btn_add_category.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_add_categoryMouseExited

    private void btn_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseEntered
          lbl_update.setForeground(Color.WHITE);
            btn_update.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_updateMouseEntered

    private void btn_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseExited
          lbl_update.setForeground(Color.BLACK);
         btn_update.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_updateMouseExited

    private void btn_clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseEntered
             lbl_clear.setForeground(Color.WHITE);
              btn_clear.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_clearMouseEntered

    private void btn_clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseExited
          lbl_clear.setForeground(Color.BLACK);
            btn_clear.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_clearMouseExited

    private void btn_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseEntered
          lbl_delete.setForeground(Color.WHITE);
              btn_delete.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_deleteMouseEntered

    private void btn_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseExited
        lbl_delete.setForeground(Color.BLACK);
            btn_delete.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_deleteMouseExited

    private void btn_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseEntered
        lbl_add.setForeground(Color.WHITE);
              btn_add.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_addMouseEntered

    private void btn_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseExited
         lbl_add.setForeground(Color.BLACK);
            btn_add.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_addMouseExited
   
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
       int X=evt.getXOnScreen();
       int Y=evt.getYOnScreen();
        setLocation(X-Xloc, Y-Yloc);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
         Xloc=evt.getX();
         Yloc=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void product_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_product_tableKeyReleased
         if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
               txt_name.setText(String.valueOf(model.getValueAt(product_table.getSelectedRow(),1)));
                txt_price.setText(String.valueOf(model.getValueAt(product_table.getSelectedRow(),2)));
                pr_id.setText(String.valueOf(model.getValueAt(product_table.getSelectedRow(),0)));
                combo_category.setSelectedItem(String.valueOf(model.getValueAt(product_table.getSelectedRow(),3)));

                btn_update.setVisible(true);
                btn_delete.setVisible(true);
                btn_cancel.setVisible(true);
                btn_add.setVisible(false);
         }
    }//GEN-LAST:event_product_tableKeyReleased

    private void product_search_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_product_search_tableKeyReleased
       if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
            txt_name.setText(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),1)));
            txt_price.setText(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),2)));
            pr_id.setText(String.valueOf(model1.getValueAt(product_search_table.getSelectedRow(),0)));

            combo_category.setSelectedItem(String.valueOf(model.getValueAt(product_search_table.getSelectedRow(),3)));
               btn_update.setVisible(true);
            btn_delete.setVisible(true);
            btn_cancel.setVisible(true);
            btn_add.setVisible(false);
       }
    }//GEN-LAST:event_product_search_tableKeyReleased

    private void stock_panalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stock_panalMouseEntered
         lbl_stock.setForeground(Color.WHITE);
            stock_panal.setBackground(Color.BLACK);
    }//GEN-LAST:event_stock_panalMouseEntered

    private void stock_panalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stock_panalMouseExited
       lbl_stock.setForeground(Color.BLACK);
            stock_panal.setBackground(Color.WHITE);
    }//GEN-LAST:event_stock_panalMouseExited

    private void bill_panalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_panalMouseEntered
       lbl_bill.setForeground(Color.WHITE);
            bill_panal.setBackground(Color.BLACK);
    }//GEN-LAST:event_bill_panalMouseEntered

    private void bill_panalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_panalMouseExited
        lbl_bill.setForeground(Color.BLACK);
            bill_panal.setBackground(Color.WHITE);
    }//GEN-LAST:event_bill_panalMouseExited

    private void free_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_free_panelMouseEntered
         lbl_free.setForeground(Color.WHITE);
            free_panel.setBackground(Color.BLACK);
    }//GEN-LAST:event_free_panelMouseEntered

    private void free_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_free_panelMouseExited
         lbl_free.setForeground(Color.BLACK);
            free_panel.setBackground(Color.WHITE);
    }//GEN-LAST:event_free_panelMouseExited

    private void exit_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_panelMouseEntered
        lbl_exit.setForeground(Color.WHITE);
            exit_panel.setBackground(Color.BLACK);
    }//GEN-LAST:event_exit_panelMouseEntered

    private void exit_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_panelMouseExited
         lbl_exit.setForeground(Color.BLACK);
           exit_panel.setBackground(Color.WHITE);
    }//GEN-LAST:event_exit_panelMouseExited

    private void home_panalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panalMouseEntered
         lbl_home.setForeground(Color.WHITE);
            home_panal.setBackground(Color.BLACK);
    }//GEN-LAST:event_home_panalMouseEntered

    private void home_panalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panalMouseExited
        lbl_home.setForeground(Color.BLACK);
           home_panal.setBackground(Color.WHITE);
    }//GEN-LAST:event_home_panalMouseExited

    private void home_panalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panalMouseClicked
       this.setVisible(false);
       HomeOverView hv=new HomeOverView();
       hv.setVisible(true);
    }//GEN-LAST:event_home_panalMouseClicked
    private void add_details() {
          String sql="insert into products(id,name,price,category) values(?,?,?,?)";
          
          try{
              ps=con.prepareStatement(sql);
              ps.setString(1,pr_id.getText());
              ps.setString(2,txt_name.getText());
              ps.setDouble(3,Double.parseDouble(txt_price.getText()));
              ps.setString(4,combo_category.getSelectedItem().toString());
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
            display();
       
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
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                      UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                      DecorationHelper.decorateWindows(false);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bill_panal;
    private javax.swing.JPanel btn_add;
    private javax.swing.JPanel btn_add_category;
    private javax.swing.JPanel btn_cancel;
    private javax.swing.JPanel btn_clear;
    private javax.swing.JPanel btn_delete;
    private javax.swing.JPanel btn_update;
    private javax.swing.JLabel cat_error;
    private javax.swing.JPanel close_panel1;
    private javax.swing.JComboBox<String> combo_category;
    private javax.swing.JPanel exit_panel;
    private javax.swing.JPanel free_panel;
    private javax.swing.JPanel home_panal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_add;
    private javax.swing.JLabel lbl_add_category;
    private javax.swing.JLabel lbl_bill;
    private javax.swing.JLabel lbl_cancel;
    private javax.swing.JLabel lbl_clear;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_delete;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_free;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JLabel lbl_update;
    private javax.swing.JLabel name_error;
    private javax.swing.JLabel pr_id;
    private javax.swing.JLabel price_error;
    private javax.swing.JTable product_search_table;
    private javax.swing.JTable product_table;
    private javax.swing.JScrollPane scroll_pane1;
    private javax.swing.JPanel stock_panal;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables

  
}
