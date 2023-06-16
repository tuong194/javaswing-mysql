package ooad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class UserForm extends javax.swing.JFrame {

   
    public UserForm() {
        initComponents();
        setLocationRelativeTo(null);
        Show_User_Jtable();
    }

   
    public Connection getConection(){
        Connection con =null;
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/store","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<User> getUserList(){
        ArrayList<User> userList = new ArrayList<User>();
        Connection con = getConection();
        String query = "SELECT * FROM nhanvien";
        
        Statement st;
        ResultSet rs;
        
        try {
            st=con.createStatement();
            rs=st.executeQuery(query);
            User user;
            while(rs.next()){
                user = new User(rs.getString("ma_nv"), rs.getString("ten_nv"), rs.getString("gioi_tinh"), rs.getString("sdt"),  rs.getString("dia_chi"), rs.getString("ngay_sinh"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
    
    public void Show_User_Jtable(){
        ArrayList<User> list = getUserList();
        DefaultTableModel  model = (DefaultTableModel) jTable_User.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[6];
         for(int i=0;i<list.size(); i++){
            row[0] =list.get(i).getMaNV();
            row[1] =list.get(i).getTenNV();
            row[2] =list.get(i).getSex();
            row[3] =list.get(i).getPhone();
            row[4] =list.get(i).getDiaChi();
            row[5] =list.get(i).getDateBirthday();
            model.addRow(row);
        }
    }
    
    public void  showItem(int index){
        txtMaNV.setText(getUserList().get(index).getMaNV());
        txtTenNV.setText(getUserList().get(index).getTenNV());
        
        // gioi tinh
       //txtSex.setText(getUserList().get(index).getSex());
       cbbSex.setSelectedItem(getUserList().get(index).getSex());
        
        txtSDT.setText(getUserList().get(index).getPhone());
        txtAddress.setText(getUserList().get(index).getDiaChi());

        // ngay sinh
        try {
            Date addDate = null;
            addDate = new SimpleDateFormat("dd-MM-yyyy").parse((String)getUserList().get(index).getDateBirthday());
            txtBirthday.setDate(addDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_User = new javax.swing.JTable();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnThemNV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        cbbSex = new javax.swing.JComboBox<>();
        txtBirthday = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Giới tính");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên nhân viên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jTable_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã_NV", "Tên_NV", "Giới tính", "SĐT", "Ngày sinh", "Địa chỉ"
            }
        ));
        jTable_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_UserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_User);

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\back-Userform.png")); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 255));
        jLabel8.setText("Danh sách nhân viên");

        btnSuaNV.setText("Sửa");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnXoaNV.setText("Xóa");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        cbbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtBirthday.setDateFormatString("dd-MM-yyyy");

        jButton1.setText("Tìm kiếm tên nhân viên");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSDT)
                                        .addComponent(cbbSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(191, 191, 191))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        if(! txtMaNV.getText().equals("")){
            try {
                Connection con = getConection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM nhanvien WHERE ma_nv=?");

                String maNV = txtMaNV.getText();
                ps.setString(1, maNV);
                ps.executeUpdate();
                Show_User_Jtable();

                JOptionPane.showMessageDialog(null, "Xong");
            } catch (SQLException ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed

        if(txtMaNV.getText() != null && checkInputs()){
            String UpdateQuery=null;
            PreparedStatement ps =null;
            Connection con = getConection();
            try {
                UpdateQuery = "UPDATE nhanvien SET ten_nv=?, gioi_tinh=?, sdt=?,dia_chi=?, ngay_sinh=? WHERE ma_nv=?";
                ps= con.prepareStatement(UpdateQuery);
   
                ps.setString(1,txtTenNV.getText());

                String comboboxSex = String.valueOf(cbbSex.getSelectedItem());
                ps.setString(2, comboboxSex);

                ps.setString(3,txtSDT.getText());
                ps.setString(4, txtAddress.getText());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dateBirthday = dateFormat.format(txtBirthday.getDate());
                ps.setString(5,dateBirthday);
                
                ps.setString(6, txtMaNV.getText());

                ps.executeUpdate();
                Show_User_Jtable();

                JOptionPane.showMessageDialog(null, "Xong");

            } catch (SQLException ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
        }

    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        if (checkInputs() ){
            try {
                Connection con = getConection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO nhanvien(ma_nv, ten_nv, gioi_tinh, sdt, dia_chi, ngay_sinh) VALUES(?,?,?,?,?,?)");

                ps.setString(1, txtMaNV.getText());
                ps.setString(2,txtTenNV.getText());

                String comboboxSex = String.valueOf(cbbSex.getSelectedItem());
                ps.setString(3, comboboxSex);

 
                ps.setString(4,txtSDT.getText());
                
                ps.setString(5, txtAddress.getText());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dateBirthday = dateFormat.format(txtBirthday.getDate());
                ps.setString(6,dateBirthday);

                

                ps.executeUpdate();
                
                Show_User_Jtable();

                JOptionPane.showMessageDialog(null, "Xong");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                //Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vui long nhap du thong tin");
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setVisible(false);
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void jTable_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_UserMouseClicked
        int index = jTable_User.getSelectedRow();
        showItem(index);
    }//GEN-LAST:event_jTable_UserMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ArrayList<User> list = new ArrayList<User>();
        User user;
        Connection con = getConection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhanvien WHERE ten_nv LIKE '%"+txtTenNV.getText()+"%'");
            while (rs.next()) {                
                 user = new User(rs.getString("ma_nv"), rs.getString("ten_nv"), rs.getString("gioi_tinh"), rs.getString("sdt"),  rs.getString("dia_chi"), rs.getString("ngay_sinh"));
                list.add(user);
                
                DefaultTableModel model = (DefaultTableModel) jTable_User.getModel();
                model.setRowCount(0);
                
                Object[] row = new Object[6];
                 for(int i=0;i<list.size(); i++){
                    row[0] =list.get(i).getMaNV();
                    row[1] =list.get(i).getTenNV();
                    row[2] =list.get(i).getSex();
                    row[3] =list.get(i).getPhone();
                    row[4] =list.get(i).getDiaChi();
                    row[5] =list.get(i).getDateBirthday();
                    model.addRow(row);
        }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1MouseClicked

    
    public boolean checkInputs(){
        
        return !(txtMaNV.getText()== null ||
                txtTenNV.getText() == null ||           
                txtSDT.getText() == null ||
                txtBirthday.getDate() == null||
                txtAddress.getText() == null);
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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JComboBox<String> cbbSex;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_User;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
