/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package judge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Avishek
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private Connection conn = null ;
    private PreparedStatement pst = null ;
    private ResultSet rs = null ;
    public Login() 
    {
        initComponents();
        //jTextField2.setVisible(false);
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(204, 255, 102));
        jButton1.setFont(new java.awt.Font("Superclarendon", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(150, 290, 89, 29);

        jButton2.setFont(new java.awt.Font("Superclarendon", 1, 13)); // NOI18N
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(260, 290, 106, 29);

        jLabel1.setText("Username");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 170, 62, 16);

        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 210, 59, 16);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(240, 160, 110, 26);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(240, 200, 110, 26);

        jTextField2.setEditable(false);
        jTextField2.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.background"));
        jTextField2.setForeground(new java.awt.Color(255, 0, 0));
        jTextField2.setAlignmentX(50.0F);
        jTextField2.setAlignmentY(50.0F);
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(130, 240, 240, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/judge/Screen Shot 2016-09-26 at 18.03.48.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 40, 500, 510);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/judge/Screen Shot 2016-09-26 at 19.35.54.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 90, 90);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/judge/Screen Shot 2016-09-26 at 19.36.07.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 50, 230, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/judge/Screen Shot 2016-09-26 at 19.51.03.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 0, 410, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/judge/Screen Shot 2016-09-26 at 19.51.03.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(310, 40, 190, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        conn = MySqlConnect.connection();
        String Sql = "Select * from login where username=? and password=?";
        try
        {
            pst = conn.prepareStatement(Sql);
            pst.setString(1,jTextField1.getText());
            pst.setString(2,jPasswordField1.getText());
            rs = pst.executeQuery();
            if( rs.next() )
            {
                this.setVisible(false);
                this.dispose();

                MainPage p = new MainPage();
                p.set(jTextField1.getText());
                p.setVisible(true);
            }
            else
            {
                //jTextField2.setVisible(true);
                jTextField2.setText("Check your Username and Password!");
                //System.out.println("Wrogng!!");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception!!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        registerPage p = new registerPage();
        p.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new Login().setVisible(true);
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
