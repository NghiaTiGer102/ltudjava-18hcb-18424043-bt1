
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javaapplication1.Entities.TaiKhoan;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    public DangNhap() {
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

        jButton1 = new javax.swing.JButton();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setText("Đăng nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTaiKhoan.setName("txtTaiKhoan"); // NOI18N

        jLabel1.setText("Mật khẩu");

        jLabel2.setText("Tài khoản");

        txtMatKhau.setName("txtMatKhau"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(txtMatKhau)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static  String  user = "";

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                    
        // Get Current Directory using getAbsolutePath()
        File file = new File("");
        String currentDirectory = file.getAbsolutePath();
        System.out.println("Current working directory : " + currentDirectory);
 
        File ff = new File(currentDirectory);
        if(!ff.exists())
        {
             JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        BufferedReader br = null;
        
        System.out.println(txtTaiKhoan.getText().toLowerCase());
        if(txtTaiKhoan.getText().toLowerCase().equalsIgnoreCase("giaovu"))
        {
            user = "giaovu";
            currentDirectory+="\\Data\\TaiKhoan\\GiaoVu.txt";
            
              ff = new File(currentDirectory);
        if(!ff.exists())
        {
             JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
            return;
        }
              try {   
            br = new BufferedReader(new FileReader(currentDirectory));       

            System.out.println("Đọc nội dung file sử dụng phương thức readLine()");

            String textInALine;
           
          List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
            
            while ((textInALine = br.readLine()) != null) {           
                
                TaiKhoan taikhoan = new TaiKhoan();
                String[] taiKhoanTemp = textInALine.split("\\|");
               taikhoan.setTaiKhoan(taiKhoanTemp[0]);  
               taikhoan.setMatKhau(taiKhoanTemp[1]);  
               listTaiKhoan.add(taikhoan);            
            }
            
            if(listTaiKhoan.size()>0)
            {
                if(listTaiKhoan.get(0).getTaiKhoan().toLowerCase().equalsIgnoreCase(txtTaiKhoan.getText().toString().toLowerCase())
                        &&Arrays.equals(txtMatKhau.getPassword(),listTaiKhoan.get(0).getMatKhau().toCharArray()))
                {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
                    FormGiaoDienChinh frm = new FormGiaoDienChinh();
                    frm.setVisible(true);
                      this.hide();
                } 
                else 
                {
                     JOptionPane.showMessageDialog(null, "Đăng nhập thất bại xin kiểm tra lại","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
                }                              
                
            } 
            else 
                {
                     JOptionPane.showMessageDialog(null, "Đăng nhập thất bại xin kiểm tra lại","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
        }
        else
        {
           
              currentDirectory+="\\Data\\TaiKhoan\\TaiKhoan.txt";
               ff = new File(currentDirectory);
        if(!ff.exists())
        {
             JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
            return;
        }
              try {   
            br = new BufferedReader(new FileReader(currentDirectory));       

            System.out.println("Đọc nội dung file sử dụng phương thức readLine()");

            String textInALine;
           
          List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
            
            while ((textInALine = br.readLine()) != null) {           
                
                TaiKhoan taikhoan = new TaiKhoan();
                String[] taiKhoanTemp = textInALine.split("\\|");
               taikhoan.setTaiKhoan(taiKhoanTemp[0]);  
               taikhoan.setMatKhau(taiKhoanTemp[1]);  
               listTaiKhoan.add(taikhoan);            
            }
            
            if(listTaiKhoan.size()>0)
            {
                
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setTaiKhoan(txtTaiKhoan.getText());
                taiKhoan.setMatKhau(txtMatKhau.getText().toString());
                user = txtTaiKhoan.getText();
                if(listTaiKhoan.stream().filter(o -> o.getTaiKhoan().equals(taiKhoan.getTaiKhoan()) &&o.getMatKhau().equals(taiKhoan.getMatKhau())).findFirst().isPresent())
                {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
                    FormDiemSinhVien frm = new FormDiemSinhVien();
                    frm.setVisible(true);
                    this.hide();
                    
                } 
                else 
                {
                     JOptionPane.showMessageDialog(null, "Đăng nhập thất bại xin kiểm tra lại","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
                }                              
                
            } 
            else 
                {
                     JOptionPane.showMessageDialog(null, "Đăng nhập thất bại xin kiểm tra lại","Thông báo" , JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }

        
        }
        

      
    
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
