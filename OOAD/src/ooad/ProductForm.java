package ooad;


import java.io.File;
import java.io.FileInputStream;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class ProductForm extends javax.swing.JFrame {

  
    public ProductForm() {
        initComponents();
        setLocationRelativeTo(null);
        Show_product_jtable();
    }

    public Connection getConnection(){
        Connection con =null;
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/store","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    
    public boolean checkinput(){
        if(txtNameProduct.getText() == null ||
           txtNumber.getText() == null ||
           txtDate2.getDate() == null ||
           txtGiaBan.getText() == null){
           return false;
        }else{
            try {
//                Integer.parseInt(txtNumber.getText());
//                Float.parseFloat(txtGiaNhap.getText());
//                Float.parseFloat(txtGiaBan.getText());
                return true;
                
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    
    String ImgPath = null;
    
    public ImageIcon ResizeImage(String imagePath, byte [] pic){
        ImageIcon myImage = null;
        if(imagePath != null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(jLbImg.getWidth(), jLbImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    

    // lay dư lieu tu CSDL do vao Arrlist
    public ArrayList<Product> getProducList(){
        ArrayList<Product> productList = new ArrayList<Product>();
        Connection con = getConnection();
        String query = "SELECT * FROM sanpham";
        
        Statement st;
        ResultSet rs;
        try {
            st=con.createStatement();
            rs= st.executeQuery(query);
            Product product;
            while(rs.next()){
                product = new Product(rs.getInt("ma_sp"), rs.getString("ten_sp"), rs.getInt("so_luong"), rs.getString("ngay_nhap"), Float.parseFloat(rs.getString("gia_ban")),rs.getBytes("image"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }
    
    // show len jtable
    public void Show_product_jtable(){
        ArrayList<Product> list = getProducList();
        DefaultTableModel model = (DefaultTableModel) jTable_product.getModel();
        //clear jtable content
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0; i< list.size(); i++){
            row[0] =list.get(i).getMaSP();
            row[1] =list.get(i).getTenSP();
            row[2] =list.get(i).getSoLuong();
            row[3] =list.get(i).getNgayNhap();
            
            row[4] =list.get(i).getGiaBan();
            model.addRow(row);
        }
    }
    
    public void show_item(int index){
        txtID.setText(Integer.toString(getProducList().get(index).getMaSP()));
        txtNameProduct.setText(getProducList().get(index).getTenSP());
        txtNumber.setText(Integer.toString(getProducList().get(index).getMaSP()));
        
         try {
            Date addDate = null;
            addDate  = new SimpleDateFormat("dd-MM-yyyy").parse((String)getProducList().get(index).getNgayNhap());
            txtDate2.setDate(addDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtGiaBan.setText(Float.toString(getProducList().get(index).getGiaBan()));
        jLbImg.setIcon(ResizeImage(null, getProducList().get(index).getImage()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_product = new javax.swing.JTable();
        txtGiaBan = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtNameProduct = new javax.swing.JTextField();
        jLbImg = new javax.swing.JLabel();
        btnChooseIMG = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDate2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Mã hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Tên hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Ngày nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Số lượng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Giá bán");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Ảnh");

        jTable_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên hàng", "Số lượng", "Ngày nhập", "Giá bán"
            }
        ));
        jTable_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_product);

        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        jLbImg.setBackground(new java.awt.Color(255, 255, 255));
        jLbImg.setOpaque(true);

        btnChooseIMG.setBackground(new java.awt.Color(153, 255, 255));
        btnChooseIMG.setText("Upload");
        btnChooseIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseIMGActionPerformed(evt);
            }
        });

        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 255, 204));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\left123.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 255, 204));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\rightxxx.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(153, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\rightx.png")); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(153, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\left.png")); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 0));
        jLabel10.setText("Danh sách sản phẩm");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Netbean\\Codejava\\OOAD\\icon\\back.png")); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        txtDate2.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnChooseIMG)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnInsert)
                        .addGap(26, 26, 26)
                        .addComponent(btnUpdate)
                        .addGap(28, 28, 28)
                        .addComponent(btnDelete)
                        .addGap(108, 108, 108)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(txtDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnChooseIMG))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsert)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseIMGActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLbImg.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }else{
            System.out.println("No file selected");
        }
    }//GEN-LAST:event_btnChooseIMGActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if(checkinput() && ImgPath != null){
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO sanpham(ma_sp, ten_sp, so_luong, ngay_nhap, gia_ban, image) VALUES(?,?,?,?,?,?)");
                
                ps.setString(1, txtID.getText());
                ps.setString(2, txtNameProduct.getText());
                ps.setString(3, txtNumber.getText());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String addDate = dateFormat.format(txtDate2.getDate());
                ps.setString(4, addDate);
                
                
                ps.setString(5, txtGiaBan.getText());
                
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(6, img);
                
                ps.executeUpdate();
                
                Show_product_jtable();
                JOptionPane.showMessageDialog(null, "Xong");
                
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());}
            
        }else{
            JOptionPane.showMessageDialog(null, "Vui long dien du thong tin");
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void jTable_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productMouseClicked
        int index = jTable_product.getSelectedRow();
        show_item(index);
    }//GEN-LAST:event_jTable_productMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
            
        if(checkinput()&& txtID.getText() != null){
            Connection con = getConnection();
            String UpdateQuery = null;
            PreparedStatement ps= null;
            
            if(ImgPath == null){
                try {
                    UpdateQuery = "UPDATE sanpham SET ten_sp=?, so_luong = ?, ngay_nhap=?, gia_ban=? WHERE ma_sp=?";
                    ps= con.prepareStatement(UpdateQuery);
            
                   
                    ps.setString(1, txtNameProduct.getText());
                    ps.setString(2, txtNumber.getText());
                
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String addDate = dateFormat.format(txtDate2.getDate());
                    ps.setString(3, addDate);
                
                    
                    ps.setString(4, txtGiaBan.getText());
                    
                    ps.setInt(5, Integer.parseInt(txtID.getText()));
                    ps.executeUpdate();
                
                    Show_product_jtable();
                    JOptionPane.showMessageDialog(null, "Xong");
                } catch (Exception ex) {
                    Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    UpdateQuery = "UPDATE sanpham SET ten_sp=?, so_luong = ?, ngay_nhap=?, gia_ban=?, image=?  WHERE ma_sp=?";
                    ps= con.prepareStatement(UpdateQuery);
            
                    
                    ps.setString(1, txtNameProduct.getText());
                    ps.setString(2, txtNumber.getText());
                
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String addDate = dateFormat.format(txtDate2.getDate());
                    ps.setString(3, addDate);
         
                    ps.setString(4, txtGiaBan.getText());
                
                    InputStream img = new FileInputStream(new File(ImgPath));
                    ps.setBlob(5, img);
                    
                    ps.setInt(6, Integer.parseInt(txtID.getText()));
                
                    ps.executeUpdate();
                
                    Show_product_jtable();
                    JOptionPane.showMessageDialog(null, "Xong");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "One of morefields are empty or wrong");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(! txtID.getText().equals("")){
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM sanpham WHERE ma_sp=?");
                int id = Integer.parseInt(txtID.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_product_jtable();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (SQLException ex) {
                Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    int pos=0;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        pos=0;
        show_item(pos);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        pos = getProducList().size() -1;
        show_item(pos);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       pos--;
       if(pos>getProducList().size()){
           pos= getProducList().size()-1;
       }
        show_item(pos);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pos++;
        if(pos<0){
            pos=0;
        }
        show_item(pos);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setVisible(false);
        new MenuForm().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        ArrayList<Product> productslist = new ArrayList<Product>();
        Product product;
        Connection con = getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sanpham WHERE ma_sp = '"+txtID.getText()+"'");
            while (rs.next()) {
                
                product = new Product(rs.getInt("ma_sp"), rs.getString("ten_sp"), rs.getInt("so_luong"), rs.getString("ngay_nhap"), Float.parseFloat(rs.getString("gia_ban")),rs.getBytes("image"));
                productslist.add(product);
                
                DefaultTableModel model = (DefaultTableModel) jTable_product.getModel();
                model.setRowCount(0);
                    Object[] row = new Object[5];
        
                    for(int i=0; i<productslist.size();i++){
                        row[0] = productslist.get(i).getMaSP();
                        row[1] = productslist.get(i).getTenSP();
                        row[2] = productslist.get(i).getSoLuong();
                        row[3] = productslist.get(i).getNgayNhap();
                        row[4] = productslist.get(i).getGiaBan();
                        model.addRow(row);
                    }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

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
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseIMG;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_product;
    private com.toedter.calendar.JDateChooser txtDate2;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
