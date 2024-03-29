/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javaapplication1.DangNhap;
import javaapplication1.Entities.DiemSV;
import javaapplication1.Entities.MonHoc;
import javaapplication1.Entities.SinhVien;
import javaapplication1.Extension.TxtFileNameFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class FormDiemSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form FormDiemSinhVien
     */
    String[] columnNames = { "STT","Môn Học", "Điểm GK","Điểm CK","Điểm khác","Điểm tổng" };
    public FormDiemSinhVien() {
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
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiemSV = new javax.swing.JTable();
        lbMSSV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbLopHoc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Điểm sinh viên");
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setText("Đổi mật khẩu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblDiemSV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDiemSV);

        scrollPane1.add(jScrollPane1);

        lbMSSV.setText("MSSV");

        jLabel2.setText("MSSV");

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Lớp");

        lbHoTen.setText("Họ Tên");

        lbLopHoc.setText("lớp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbHoTen)
                    .addComponent(lbMSSV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLopHoc, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(lbMSSV)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbHoTen))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLopHoc)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    Boolean KiemTraSinhVienCoDiemHayKhong(String url)
    {
        
          
     
     String fileCSV = url;
  
     
      File ff = new File(fileCSV);
        if(!ff.exists())
        {
            return false;
        }
     
     
        Path pathToFile = Paths.get(fileCSV);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) 
        {

            // read the first line from the text file
            String line = br.readLine(); 
            int stt=1;
            while (line != null) 
            {              
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split("\\|");          
                String tk = attributes[0 ];
              
                
                 if(tk.contains(DangNhap.user))
                {
                    return true;
                }
                
                line = br.readLine();
            }
            
            
            // loop until all lines are read
            

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return  false;
    }
    
    int LayThongTin(String lophoc)
    {
        
        try {
               File file = new File("");
        String currentDirectory = file.getAbsolutePath();
          List<SinhVien> listSinhVien = new ArrayList<SinhVien>();
        currentDirectory +="\\Data\\DuLieu\\DanhSachSinhVien\\" + lophoc+".txt";
       
           
        String lopHoc = lophoc.trim();
        
      
        
         File ff = new File(currentDirectory);
        if(!ff.exists())
        {
            return 1;
        }
        
         Path pathToFile = Paths.get(currentDirectory);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.UTF_8)) 
        {

            // read the first line from the text file
            String line = br.readLine(); 
            int stt=1;
            while (line != null) 
            {
             
                String[] attributes = line.split("\\|");
                
                if(attributes[0].contains(DangNhap.user))
                {
                  
                    lbHoTen.setText(attributes[1]);
                    lbLopHoc.setText(lopHoc);
                    
                    lbMSSV.setText(DangNhap.user);
                       return 1;
                }
              
              

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
            
            
            // loop until all lines are read
            

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        } catch (Exception e) {
        }
        
        return 0;
    }
    
    void HienThongTinSinhVien()
    {
         // TODO add your handling code here:
        File fileghi = new File("");
        String currentDirectory = fileghi.getAbsolutePath();
        currentDirectory +="\\Data\\Dulieu\\DanhSachSinhVien";
        File dir = new File(currentDirectory);
        File ff = new File(currentDirectory);
              if(!ff.exists())
              {
                  return;
              }
        File[] txtFiles = dir.listFiles(new TxtFileNameFilter());
        List<DiemSV> listDiemSV = new ArrayList<DiemSV>();
        for (File txtFile : txtFiles) {
             File f = new File(txtFile.getAbsolutePath());
            
            
             if(LayThongTin(f.getName().toString().replace(".txt", ""))==1)
             {                            
                 break;
             }
             
             
            
        }
    }
    
    void  HienDanhSachDiem()
    {
       
         // TODO add your handling code here:
        File fileghi = new File("");
        String currentDirectory = fileghi.getAbsolutePath();
        currentDirectory +="\\Data\\Dulieu\\DanhSachDiemSinhVien";
        File dir = new File(currentDirectory);
        File ff = new File(currentDirectory);
              if(!ff.exists())
              {
                  return;
              }
        File[] txtFiles = dir.listFiles(new TxtFileNameFilter());
        List<DiemSV> listDiemSV = new ArrayList<DiemSV>();
        for (File txtFile : txtFiles) {
             File f = new File(txtFile.getAbsolutePath());
            
             if(KiemTraSinhVienCoDiemHayKhong(f.getPath()))
            {
                String lophoc = f.getName().toString().replace(".txt", "");
               DiemSV diemsv =   LoadDuLieuDiemSinhVien(lophoc);
               listDiemSV.add(diemsv);
           
            }
             
             if(listDiemSV.size()>0)
             {
                 LoadDuLieuDiemSinhVien(columnNames,listDiemSV);
             }
             else
             {
                  TableModel tablemodel = new DefaultTableModel(null, columnNames);
                 tblDiemSV.setModel(tablemodel);
             }
             
            
        }
    }
    
    
    
    void LoadDuLieuDiemSinhVien(String[] columnNames,List<DiemSV> listDiemSV)
    {
        
         
        
        
        String[][] listDataDiemSinhVien = new String[listDiemSV.size()][6];
        for(int i =0;i<listDiemSV.size();i++)
        {
              listDataDiemSinhVien[i][0] = (i+1) + "";           
              listDataDiemSinhVien[i][1] =  listDiemSV.get(i).getMSSV();
              listDataDiemSinhVien[i][2] =  listDiemSV.get(i).getDiemGK();
              listDataDiemSinhVien[i][3] =  listDiemSV.get(i).getDiemCK();
              listDataDiemSinhVien[i][4] =  listDiemSV.get(i).getDiemKhac();
              double diemTong = (Double.parseDouble(listDiemSV.get(i).getDiemGK())+
                      Double.parseDouble(listDiemSV.get(i).getDiemCK())
                      +Double.parseDouble(listDiemSV.get(i).getDiemKhac()))/3.0; 
              
              
          
              double diemtongf =  diemTong*4;
              diemTong =   Math.ceil(diemtongf) /4.0;
              listDataDiemSinhVien[i][5] =  diemTong+"";
        }
        
        
        
        TableModel tablemodel = new DefaultTableModel(listDataDiemSinhVien, columnNames);
        tblDiemSV.setModel(tablemodel);
        
      
    
    }
    
    
    DiemSV LoadDuLieuDiemSinhVien(String lophoc)
    {       
        if(lophoc==null)
        {
            return null;
        }
         File file = new File("");
        String currentDirectory = file.getAbsolutePath();
          List<DiemSV> listDiemSinhVien = new ArrayList<DiemSV>();
        currentDirectory +="\\Data\\DuLieu\\DanhSachDiemSinhVien\\" + lophoc+".txt";
        Path pathToFile = Paths.get(currentDirectory);
        String lopHoc ="";
        File ff = new File(currentDirectory);
        DiemSV diemSV= new DiemSV();
              if(!ff.exists())
              {
                  return null;
              }
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) 
        {

            // read the first line from the text file
            String line = br.readLine();                                         
            while (line != null) 
            {
               
               String[] attributes = line.split("\\|");
                DiemSV diemsv = new DiemSV();
                if(diemsv.getMSSV()=="")
                    continue;
                 diemsv = diemsv.ThemDiemSV(attributes);
                // adding book into ArrayList
                listDiemSinhVien.add(diemsv);
                
                

                
               
                
                
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
            
            
            // loop until all lines are read
            

        } catch (IOException ioe) 
        {
            System.out.println("javaapplication1.formDanhSachSinhVien.formWindowOpened()");
            ioe.printStackTrace();
          
        }
        String[] atrributes = lophoc.split("\\-");
        for(DiemSV sv :listDiemSinhVien)
        {
            if(sv.getMSSV().contains(DangNhap.user))
            {
                diemSV.setMSSV(atrributes[1]);
                diemSV.setDiemGK(sv.getDiemGK());            
                diemSV.setDiemCK(sv.getDiemCK());
                diemSV.setDiemKhac(sv.getDiemKhac());
                diemSV.setDiemT(sv.getDiemT());
                return diemSV;
            }
        }
        
        return null;
       
    
    }
    
      
    
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       this.setLocationRelativeTo(null);
        HienDanhSachDiem();
        HienThongTinSinhVien();
        
               
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormDoiMatKhau frm = new FormDoiMatKhau();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        DangNhap frm = new DangNhap();
        frm.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FormDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDiemSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDiemSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbLopHoc;
    private javax.swing.JLabel lbMSSV;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tblDiemSV;
    // End of variables declaration//GEN-END:variables
}
