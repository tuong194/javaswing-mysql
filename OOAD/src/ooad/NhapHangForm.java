package ooad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VM.TUONG
 */
public class NhapHangForm extends javax.swing.JFrame {

    /**
     * Creates new form NhapHangForm
     */
    public NhapHangForm() {
        initComponents();
        setLocationRelativeTo(null);
        show_jtable_Nhaphang();
    }
    
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store","root","");
        return conn;
    }

    public ArrayList<Nhaphang> getNhaphangList(){
        ArrayList<Nhaphang> nhaphangList = new ArrayList<Nhaphang>();
        Nhaphang nhaphang;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhaphang");
            while (rs.next()) {                
                nhaphang = new Nhaphang(rs.getInt("stt"),rs.getInt("ma_sp"), rs.getString("ten_sp"), rs.getFloat("gia_nhap"), rs.getInt("so_luong"), rs.getString("ngay_ve"));
                nhaphangList.add(nhaphang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nhaphangList;
    }
    
    public void show_jtable_Nhaphang(){
        ArrayList<Nhaphang> list = getNhaphangList();
        DefaultTableModel model = (DefaultTableModel) jtable_nhaphang.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[6];
        for(int i=0; i<list.size();i++){
            row[0] = list.get(i).getStt();
            row[1] = list.get(i).getMasp();
            row[2] = list.get(i).getTensp();
            row[3] = list.get(i).getGianhap();
            row[4] = list.get(i).getSoluong();
            row[5] = list.get(i).getNgayveString();
            model.addRow(row);
        }
    }
    
    public void showItem(int index) {
        lbSTT.setText(Integer.toString(getNhaphangList().get(index).getStt()));
        txtMasp.setText(Integer.toString(getNhaphangList().get(index).getMasp()));
        txtTensp.setText(getNhaphangList().get(index).getTensp());
        txtGianhap.setText(Float.toString(getNhaphangList().get(index).getGianhap()));
        txtSoluong.setText(Integer.toString(getNhaphangList().get(index).getSoluong()));
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(getNhaphangList().get(index).getNgayveString());
            txtDate.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_nhaphang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMasp = new javax.swing.JTextField();
        txtGianhap = new javax.swing.JTextField();
        txtTensp = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtDate = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        lbSTT = new javax.swing.JLabel();
        btnIn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtdate1 = new javax.swing.JTextField();
        btnXuat = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jtable_nhaphang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá nhập", "Số lượng", "Ngày về"
            }
        ));
        jtable_nhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_nhaphangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtable_nhaphang);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\back.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Danh sách hàng nhập về ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Mã sản phẩm");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Tên sản phẩm");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Số lượng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Ngày về");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Giá nhập");

        txtGianhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGianhapActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        txtDate.setDateFormatString("dd-MM-yyyy");

        jButton4.setText("Tìm");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        lbSTT.setBackground(new java.awt.Color(255, 255, 204));
        lbSTT.setForeground(new java.awt.Color(0, 0, 255));
        lbSTT.setText("STT");

        btnIn.setText(" In HD nhập hàng");
        btnIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInMouseClicked(evt);
            }
        });

        jButton5.setText("Tìm");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtdate1.setText("Nhập tháng");

        btnXuat.setText("Xuất hàng");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        jButton6.setText("In HD xuất hàng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 585, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnXuat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton5)
                        .addGap(256, 256, 256))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIn)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(btnIn))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuat)
                        .addComponent(jButton6))
                    .addComponent(jButton5))
                .addGap(0, 27, Short.MAX_VALUE))
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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setVisible(false);
        new MenuForm().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtGianhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGianhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGianhapActionPerformed

    private void jtable_nhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_nhaphangMouseClicked
        int index = jtable_nhaphang.getSelectedRow();
        showItem(index);
    }//GEN-LAST:event_jtable_nhaphangMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM nhaphang WHERE stt='"+lbSTT.getText()+"'");
            ps.executeUpdate();
            show_jtable_Nhaphang();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
    }//GEN-LAST:event_jButton3MouseClicked

    public  boolean  checkInput(){
        if(     txtTensp.getText()==null||
                txtGianhap.getText() == null||
                txtSoluong.getText() == null||
                txtDate.getDate()==null){
            return false;
        }
        return true;
    }
    
    
    // lấy số lượng sản phẩm từ bảng nhập hàng
//    public int getSoluong(){
//        int x=0;
//        try {
//            Connection con = getConnection();
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM nhaphang WHERE ma_sp = '"+txtMasp.getText()+"'");
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                x= rs.getInt("so_luong");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     return x;
//    }
    
    // kiểm tra xem sản phẩm đó đã có trong bảng sản phẩm chưa
    public boolean checkSP(){
        int maSP = Integer.parseInt(txtMasp.getText()); 
        int count=0;
        ArrayList<Integer> lists = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sanpham");
            while(rs.next()){  
                lists.add(rs.getInt("ma_sp"));
            }
            for(Integer list : lists){
                if (maSP == list) {
                    count++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // ton tai masp
        if (count != 0) {
            return true;
        }
        return false;
    }
    
    // nếu đã có thì update số lượng sản phẩm trong bảng sản phẩm
    public void updateSoluong(){
        int soluongNhap = Integer.parseInt(txtSoluong.getText());
        
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM sanpham WHERE ma_sp = '"+txtMasp.getText()+"'");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    PreparedStatement ps2 = con.prepareStatement("UPDATE sanpham SET so_luong = '"+(soluongNhap+rs.getInt("so_luong"))+"' WHERE ma_sp = '"+txtMasp.getText()+"'");
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update thành công!!!");
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    // nếu chưa thì thêm vào
    public void insertSP(){
        
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO sanpham(ma_sp,ten_sp,so_luong,ngay_nhap,gia_ban,image) VALUES(?,?,?,?,?,?)");
                ps.setString(1, txtMasp.getText());
                ps.setString(2, txtTensp.getText());
                ps.setString(3, txtSoluong.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateFormat.format(txtDate.getDate());
                ps.setString(4, date);
                ps.setString(5, "000");
                ps.setString(6, "1");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Đã insert vào sanpham");
                
            } catch (SQLException ex) {
                Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (checkInput()) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO nhaphang(ma_sp,ten_sp,gia_nhap,so_luong,ngay_ve) VALUES(?,?,?,?,?)");
                ps.setString(1, txtMasp.getText());
                ps.setString(2, txtTensp.getText());
                ps.setString(3, txtGianhap.getText());
                ps.setString(4, txtSoluong.getText());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateFormat.format(txtDate.getDate());
                ps.setString(5, date);
                
                ps.executeUpdate();
                show_jtable_Nhaphang();
                JOptionPane.showMessageDialog(null, "Xong");
                
//                if (checkSP()==false) {
//                    insertSP();
//                }else if(checkSP() == true){
//                    updateSoluong();
//                }
    
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin");
        }
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE nhaphang SET ten_sp=?, gia_nhap=?, so_luong=?, ngay_ve=? WHERE stt='"+lbSTT.getText()+"'");
            ps.setString(1, txtTensp.getText());
            ps.setString(2, txtGianhap.getText());
            ps.setString(3, txtSoluong.getText());
           
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String addDate = dateFormat.format(txtDate.getDate());
            ps.setString(4, addDate);
            ps.executeUpdate();
            show_jtable_Nhaphang();
            JOptionPane.showMessageDialog(null, "Xong");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
    }//GEN-LAST:event_jButton2MouseClicked

    // tim kiém
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        Nhaphang nhaphang;
        ArrayList<Nhaphang> list = new ArrayList<Nhaphang>();
        if(!txtMasp.getText().equals("")){
            try {
                
                Connection con = getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM nhaphang WHERE ma_sp = '"+txtMasp.getText()+"'");
                
                while (rs.next()) {                    
                    nhaphang = new Nhaphang(rs.getInt("stt"),rs.getInt("ma_sp"), rs.getString("ten_sp"), rs.getFloat("gia_nhap"), rs.getInt("so_luong"), rs.getString("ngay_ve"));
                    list.add(nhaphang);
                    
                    DefaultTableModel model = (DefaultTableModel) jtable_nhaphang.getModel();
        
                    model.setRowCount(0);
                    Object[] row = new Object[6];
                    for(int i=0; i<list.size();i++){
                        row[0] = list.get(i).getStt();
                        row[1] = list.get(i).getMasp();
                        row[2] = list.get(i).getTensp();
                        row[3] = list.get(i).getGianhap();
                        row[4] = list.get(i).getSoluong();
                        row[5] = list.get(i).getNgayveString();
                        model.addRow(row);
                    }
                }
                
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                JOptionPane.showMessageDialog(null, "khong tim thay");
            }
        }
        
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void btnInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInMouseClicked
        if (txtMasp.getText() == null || txtTensp.getText() ==null|| txtGianhap.getText()==null||txtSoluong.getText()==null || txtDate.getDate() == null){
            JOptionPane.showMessageDialog(null, "Dữ liệu trống");
        }else{
            TruyenHdNhaphang hdxuat = new TruyenHdNhaphang();
        hdxuat.setMasp(txtMasp.getText());
        hdxuat.setTensp(txtTensp.getText());
        hdxuat.setGianhap(txtGianhap.getText());
        hdxuat.setSoluong(txtSoluong.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String addDate = dateFormat.format(txtDate.getDate());
        hdxuat.setNgayve(addDate);
        new InHDNhaphang().setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnInMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        String Mon = "-"+txtdate1.getText()+"-";
        Nhaphang nhaphang;
        ArrayList<Nhaphang> list = new ArrayList<Nhaphang>();
        try {
            Connection con =getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nhaphang WHERE ngay_ve LIKE '%"+Mon+"%'");
            while(rs.next()){
                nhaphang = new Nhaphang(rs.getInt("stt"),rs.getInt("ma_sp"), rs.getString("ten_sp"), rs.getFloat("gia_nhap"), rs.getInt("so_luong"), rs.getString("ngay_ve"));
                list.add(nhaphang);
                
                DefaultTableModel model = (DefaultTableModel) jtable_nhaphang.getModel();
                model.setRowCount(0);
                Object[] row = new Object[6];
                    for(int i=0; i<list.size();i++){
                        row[0] = list.get(i).getStt();
                        row[1] = list.get(i).getMasp();
                        row[2] = list.get(i).getTensp();
                        row[3] = list.get(i).getGianhap();
                        row[4] = list.get(i).getSoluong();
                        row[5] = list.get(i).getNgayveString();
                        model.addRow(row);
                    }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());     
        }
        
    }//GEN-LAST:event_jButton5MouseClicked

    public boolean updateSoluongSanPham() throws SQLException{
        int numNew = Integer.parseInt(txtSoluong.getText());
        int numOld = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM nhaphang WHERE stt='"+lbSTT.getText()+"'");            
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            numOld = Integer.parseInt( rs.getString("so_luong"));
        }
       
        if ((numOld- numNew) >= 0) {
            PreparedStatement ps2 = con.prepareStatement("UPDATE nhaphang SET so_luong = '"+(numOld-numNew)+"' WHERE stt='"+lbSTT.getText()+"'");
            ps2.executeUpdate();
            return true;
        
        }else if((numOld - numNew) < 0){
            return false;
        }
        return false;
    }
    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        try {
            if (updateSoluongSanPham()) {
                if (checkSP()==false) {
                    insertSP();
                }else if(checkSP() == true){
                    updateSoluong();
                }
                show_jtable_Nhaphang();
            }else{
                JOptionPane.showMessageDialog(null, "Số lượng sản phẩm trong cửa hàng không đủ\n Vui lòng xem lại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnXuatActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (txtMasp.getText() == null || txtTensp.getText() ==null|| txtGianhap.getText()==null||txtSoluong.getText()==null || txtDate.getDate() == null){
            JOptionPane.showMessageDialog(null, "Dữ liệu trống");
        }else{
        TruyenHdNhaphang hdxuat = new TruyenHdNhaphang();
        hdxuat.setMasp(txtMasp.getText());
        hdxuat.setTensp(txtTensp.getText());
        hdxuat.setGianhap(txtGianhap.getText());
        hdxuat.setSoluong(txtSoluong.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String addDate = dateFormat.format(txtDate.getDate());
        hdxuat.setNgayve(addDate);
        new InHDXuathang().setVisible(true);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(NhapHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnXuat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtable_nhaphang;
    private javax.swing.JLabel lbSTT;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtGianhap;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTensp;
    private javax.swing.JTextField txtdate1;
    // End of variables declaration//GEN-END:variables
}
