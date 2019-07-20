/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.Entities.SinhVien;



/**
 *
 * @author Asus
 */
public class formDanhSachSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form formDanhSachSinhVien
     */
    public formDanhSachSinhVien() {
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

        btnInportCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInportCSV.setText("Import CSV");
        btnInportCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInportCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(btnInportCSV)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(btnInportCSV)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInportCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInportCSVActionPerformed
        // TODO add your handling code here:
          FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        
         dialog.setFile("*.CSV");
      
    dialog.setMode(FileDialog.LOAD);
    dialog.setVisible(true);
    String file = dialog.getFile();
    System.out.println(file + " chosen.");
     System.out.println(dialog.getDirectory() + " chosen.");
     
     String fileCSV = dialog.getDirectory()+file;
     
     String  lopHoc = "";
     
      List<SinhVien> listSinhVien = new ArrayList<SinhVien>();
        Path pathToFile = Paths.get(fileCSV);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) 
        {

            // read the first line from the text file
            String line = br.readLine();                                         
            while (line != null) 
            {
                if(lopHoc  == "")
                {
                String[] attributes = line.split("\\,");
                lopHoc = attributes[0];
                 line = br.readLine();
                 continue;
                }
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                SinhVien sv = new SinhVien();
                 sv = sv.ThemSinhVien(attributes);

                // adding book into ArrayList
                listSinhVien.add(sv);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
            
            
            // loop until all lines are read
            

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
         try {
      File fileghi = new File("");
        String currentDirectory = fileghi.getAbsolutePath();
        currentDirectory +="\\Data\\DuLieu\\DanhSachSinhVien\\" + lopHoc+".txt";
     //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
     File f = new File(currentDirectory);
     FileWriter fw = new FileWriter(f);
     //Bước 2: Ghi dữ liệu
     
    listSinhVien.forEach((element) -> {
        String dulieusinhvien = element.getmSSV()+"|"+element.getHoTen()+"|"+element.getGioiTinh()+"|"+element.getcMND()+"\n";
          try {
              fw.write(dulieusinhvien);
          } catch (IOException ex) {
              Logger.getLogger(formDanhSachSinhVien.class.getName()).log(Level.SEVERE, null, ex);
          }
        });

    
    
     //Bước 3: Đóng luồng
     fw.close();
   } catch (IOException ex) {
     System.out.println("Loi ghi file: " + ex);
 }

        
    
    }//GEN-LAST:event_btnInportCSVActionPerformed

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
            java.util.logging.Logger.getLogger(formDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDanhSachSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInportCSV;
    // End of variables declaration//GEN-END:variables
}