/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import In_patient.inPatient_management;
import Inventory.inv_home;
import Lab_management.lab_home;
import Pharmacy.Main;
import com.jtattoo.plaf.DecorationHelper;
import hms.MainMenu;

import hrmanagement.OverView;
import java.awt.event.WindowEvent;
import maternity.MaternityGUI;
import opd.opdGUI;


import vehicle.management.system.Vehicle;

/**
 *
 * @author Haran
 */
public class Home_Main extends javax.swing.JFrame {
   private String uType;
    /**
     * Creates new form Home_Main
     */
    public Home_Main() {
        initComponents();  
       
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tra = new javax.swing.JButton();
        bf = new javax.swing.JButton();
        hr = new javax.swing.JButton();
        inp = new javax.swing.JButton();
        inv = new javax.swing.JButton();
        lab = new javax.swing.JButton();
        mat = new javax.swing.JButton();
        opd = new javax.swing.JButton();
        pha = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("OPD");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("IN PATIENT");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("MATERNITY");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LABORATORY");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PHARMACY");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("INVENTORY");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("BUSINESS AND FINANCE");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("TRANSPORT");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("HUMAN RESOURCES");

        tra.setBackground(new java.awt.Color(255, 255, 255));
        tra.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\amb3.png")); // NOI18N
        tra.setBorder(null);
        tra.setBorderPainted(false);
        tra.setContentAreaFilled(false);
        tra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traActionPerformed(evt);
            }
        });

        bf.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\finance.png")); // NOI18N
        bf.setBorder(null);
        bf.setBorderPainted(false);
        bf.setContentAreaFilled(false);
        bf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfActionPerformed(evt);
            }
        });

        hr.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\resourses1.png")); // NOI18N
        hr.setBorder(null);
        hr.setBorderPainted(false);
        hr.setContentAreaFilled(false);
        hr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrActionPerformed(evt);
            }
        });

        inp.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\Patients-icon1.png")); // NOI18N
        inp.setBorder(null);
        inp.setBorderPainted(false);
        inp.setContentAreaFilled(false);
        inp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpActionPerformed(evt);
            }
        });

        inv.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\inventory1.png")); // NOI18N
        inv.setBorder(null);
        inv.setBorderPainted(false);
        inv.setContentAreaFilled(false);
        inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invActionPerformed(evt);
            }
        });

        lab.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\Lab-icon1.png")); // NOI18N
        lab.setBorder(null);
        lab.setBorderPainted(false);
        lab.setContentAreaFilled(false);
        lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labActionPerformed(evt);
            }
        });

        mat.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\baby-drinking-icon.png")); // NOI18N
        mat.setBorder(null);
        mat.setBorderPainted(false);
        mat.setContentAreaFilled(false);
        mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matActionPerformed(evt);
            }
        });

        opd.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\opd3.png")); // NOI18N
        opd.setBorder(null);
        opd.setBorderPainted(false);
        opd.setContentAreaFilled(false);
        opd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opdActionPerformed(evt);
            }
        });

        pha.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\pharmacy1.png")); // NOI18N
        pha.setBorder(null);
        pha.setBorderPainted(false);
        pha.setContentAreaFilled(false);
        pha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inp)
                            .addComponent(mat))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tra)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(pha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(98, 98, 98)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(23, 23, 23))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(24, 24, 24))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hr))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bf)
                                    .addComponent(pha)
                                    .addComponent(tra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inp, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(opd, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(20, 20, 20)))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lab, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inv, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\logout1.png")); // NOI18N
        jButton1.setText("LOGOUT");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("ATLANTA HOSPITAL SYSTEM");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haran\\Documents\\NetBeansProjects\\ps_Atlanta\\src\\Home\\hos1.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(825, 410));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        HomeLogin log=new HomeLogin();
        log.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void hrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrActionPerformed
       this.dispose();
       OverView view = new OverView();
       view.setVisible(true);
       view.setType(uType);
    }//GEN-LAST:event_hrActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
      this.processWindowEvent(
                        new WindowEvent(
                                this, WindowEvent.WINDOW_CLOSING));
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void opdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opdActionPerformed
         this.dispose();
        opdGUI op = new opdGUI();
        op.setVisible(true);
    }//GEN-LAST:event_opdActionPerformed

    private void inpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpActionPerformed
         this.setVisible(false);
        inPatient_management Im=new inPatient_management();
        Im.setVisible(true);
    }//GEN-LAST:event_inpActionPerformed

    private void phaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phaActionPerformed
       Main pharmacy=new Main();
       this.setVisible(false);
       pharmacy.setVisible(true);
               
    }//GEN-LAST:event_phaActionPerformed

    private void traActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traActionPerformed
        this.dispose();
        Vehicle v = new Vehicle();
        v.setVisible(true);
    }//GEN-LAST:event_traActionPerformed

    private void matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matActionPerformed
        this.dispose();
        MaternityGUI ma = new MaternityGUI();
        ma.setVisible(true);
    }//GEN-LAST:event_matActionPerformed

    private void labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labActionPerformed
           // TODO add your handling code here:
        this.dispose();
        lab_home lh = new lab_home();
        lh.setVisible(true);
    }//GEN-LAST:event_labActionPerformed

    private void invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invActionPerformed
         this.dispose();
        inv_home ih = new inv_home();
        ih.setVisible(true);
    }//GEN-LAST:event_invActionPerformed

    private void bfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfActionPerformed
           this.dispose();
      MainMenu mm = new MainMenu();
      mm.setVisible(true);
    }//GEN-LAST:event_bfActionPerformed

    /**
     * @param args the command line arguments
     */
     public void setType(String type){
         this.uType=type;
        if(uType.equals("admin")){
             
        
        }
        else if(uType.equals("rep")){
            
             lab.setEnabled(false);
            inv.setEnabled(false);
            hr.setEnabled(false);
           // tra.setEnabled(false);
            pha.setEnabled(false);
                bf.setEnabled(false);
                
            
        }
        else if(uType.equals("hr")){
            opd.setEnabled(false);
            inp.setEnabled(false);
            mat.setEnabled(false);
             lab.setEnabled(false);
          
            pha.setEnabled(false);
                bf.setEnabled(false);
            
            
        }
        else if(uType.equals("phar")){
            opd.setEnabled(false);
            inp.setEnabled(false);
            mat.setEnabled(false);
             lab.setEnabled(false);
            inv.setEnabled(false);
            hr.setEnabled(false);
            tra.setEnabled(false);
            bf.setEnabled(false);
           
            
            
        }
        else if(uType.equals("lab_assist")){
            opd.setEnabled(false);
            inp.setEnabled(false);
            mat.setEnabled(false);
            // lab.setEnabled(false);
            inv.setEnabled(false);
            hr.setEnabled(false);
            tra.setEnabled(false);
            pha.setEnabled(false);
                bf.setEnabled(false);
            
        }
        else if(uType.equals("opd")){
           // opd.setEnabled(false);
            inp.setEnabled(false);
            mat.setEnabled(false);
             lab.setEnabled(false);
            inv.setEnabled(false);
            hr.setEnabled(false);
            tra.setEnabled(false);
            pha.setEnabled(false);
                bf.setEnabled(false);
        }
        else if (uType.equals("vcl")){
            opd.setEnabled(false);
            inp.setEnabled(false);
            mat.setEnabled(false);
             lab.setEnabled(false);
            inv.setEnabled(false);
            hr.setEnabled(false);
           // tra.setEnabled(false);
            pha.setEnabled(false);
                bf.setEnabled(false);
            
        }
        else{
        
        }
     }
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
            java.util.logging.Logger.getLogger(Home_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bf;
    private javax.swing.JButton hr;
    private javax.swing.JButton inp;
    private javax.swing.JButton inv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lab;
    private javax.swing.JButton mat;
    private javax.swing.JButton opd;
    private javax.swing.JButton pha;
    private javax.swing.JButton tra;
    // End of variables declaration//GEN-END:variables
}
