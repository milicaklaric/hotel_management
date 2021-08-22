/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form;

import domen.GeneralDomainObject;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author MK
 */
public class FrmHome extends javax.swing.JFrame {

    /**
     * Creates new form frmHome
     */
    public FrmHome() {
        initComponents();
        //pnlAllReservations1.setVisible(false);
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
        btnCancelReservation = new javax.swing.JButton();
        btnNewReservation = new javax.swing.JButton();
        btnAllReservations = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(48, 50, 61));

        btnCancelReservation.setBackground(new java.awt.Color(155, 106, 108));
        btnCancelReservation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelReservation.setText("Cancel reservation");

        btnNewReservation.setBackground(new java.awt.Color(176, 147, 152));
        btnNewReservation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNewReservation.setText("Make new reservation");

        btnAllReservations.setBackground(new java.awt.Color(206, 223, 217));
        btnAllReservations.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAllReservations.setText("See all reservations");
        btnAllReservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllReservationsActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MK\\Documents\\GitHub\\hotel_management\\src\\main\\java\\sources\\hotel_logo1.png")); // NOI18N

        lblEmployee.setForeground(new java.awt.Color(206, 223, 217));
        lblEmployee.setText("Employee: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancelReservation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnNewReservation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAllReservations, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEmployee)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(btnAllReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(lblEmployee)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 540));

        jPanel2.setBackground(new java.awt.Color(235, 252, 251));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 50, 61)));

        btnClose.setBackground(new java.awt.Color(235, 252, 251));
        btnClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(48, 50, 61));
        btnClose.setText("x");
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setDefaultCapable(false);
        btnClose.setOpaque(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new java.awt.Color(235, 252, 251));
        btnMinimize.setForeground(new java.awt.Color(48, 50, 61));
        btnMinimize.setText("_");
        btnMinimize.setBorder(null);
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(546, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(515, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 600, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAllReservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllReservationsActionPerformed
        
    }//GEN-LAST:event_btnAllReservationsActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    public JLabel getlblEmployee() {
        return lblEmployee;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllReservations;
    private javax.swing.JButton btnCancelReservation;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnNewReservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEmployee;
    // End of variables declaration//GEN-END:variables

    public void btnAllReservationsAddListener(ActionListener actionListener) {
        btnAllReservations.addActionListener(actionListener);
    }
    
    public void btnNewReservationAddListener(ActionListener actionListener) {
        btnNewReservation.addActionListener(actionListener);
    }

    public void btnCancelReservation(ActionListener actionListener) {
        btnCancelReservation.addActionListener(actionListener);
    }
}
