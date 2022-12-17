/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lenovo
 */
public class ManageUniversity extends javax.swing.JFrame {

    /**
     * Creates new form ManagePrevious
     */
    
    String universityiD, phone_number, city1, street1 ,building1, box1;
    DefaultTableModel model;
    public ManageUniversity() {
        initComponents();
        setUniversityDetailsToTable();
    }
     
    public void setUniversityDetailsToTable() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM UNIVERSITY");
             
             while(rs.next()) {
            String universityID = rs.getString("universityID");
            String phonenumber  = rs.getString("phonenumber");
            String city  = rs.getString("city");
            String building = rs.getString("building");
            String street = rs.getString("street");
            String box = rs.getString("box");
            
            Object [] obj = {universityID,phonenumber,city,building,street,box};
            model =(DefaultTableModel) tbl_unversitydetails.getModel();
            model.addRow(obj);
             }
        }catch (Exception e){
          e.printStackTrace();
            
        }
    }
    //add universities
      public boolean adduniversity(){
      boolean isAdded = false;
      universityiD = txt_university.getText();
      phone_number =  txt_universityphonenumber.getText();
      city1 = txt_universitycity.getText();
      building1 = txt_campus.getText();
      street1 = txt_street.getText();
      box1 = txt_pobox.getText();
      
      try {
          
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
          String sql = "Insert into UNIVERSITY VALUES(?,?,?,?,?,?)";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, universityiD);
          pst.setString(2, phone_number);
          pst.setString(3, city1);
          pst.setString(4, building1);
          pst.setString(5,street1);
          pst.setString(6, box1);       
         
          
          int rowCount = pst.executeUpdate();
          if (rowCount > 0) {
              isAdded = true;
          }else {
              isAdded = false;
          }
          
      }catch (Exception e){
          e.printStackTrace();
      }
         return isAdded;
     }
     
      public boolean updateUniversity() {
      boolean isUpdated = false;
      universityiD = txt_university.getText();
      phone_number =  txt_universityphonenumber.getText();
      city1 = txt_universitycity.getText();
      building1 = txt_campus.getText();
      street1 = txt_street.getText();
      box1 = txt_pobox.getText();
      
      try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
          String sql = "UPDATE UNIVERSITY SET phonenumber = ?, city= ?,building = ?, street = ?, box = ? WHERE universityiD = ? ";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, phone_number);
          pst.setString(2, city1);
          pst.setString(3, building1);
          pst.setString(4,street1);
          pst.setString(5, box1); 
          pst.setString(6, universityiD);
          
           int rowCount = pst.executeUpdate();
          if (rowCount > 0) {
              isUpdated = true;
          }else {
              isUpdated = false;
          }
      }catch (Exception e){
        e.printStackTrace();  
      }
        return isUpdated;
      }
      
      //Method to delete universities
      
      public boolean deleteUniversity() {
          boolean isdeleted = false;
          universityiD = txt_university.getText();
           try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
          String sql = "DELETE FROM UNIVERSITY WHERE universityiD = ? ";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1,universityiD );
          
          int rowCount = pst.executeUpdate();
          if(rowCount > 0) {
              isdeleted = true;
          }else{
              isdeleted= false;
          }
      }catch (Exception e){
          e.printStackTrace();
      }
        return isdeleted;
      }
     //Clear table
     
     public void clearTable() {
         DefaultTableModel model = (DefaultTableModel) tbl_unversitydetails.getModel();
         model.setRowCount(0);
     }
     
     public void search(String str) {
        
       model= (DefaultTableModel)tbl_unversitydetails.getModel();
       TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
       tbl_unversitydetails.setRowSorter(trs);
       trs.setRowFilter(RowFilter.regexFilter(str));
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_university = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_universitycity = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_universityphonenumber = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_campus = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_pobox = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_street = new app.bolivia.swing.JCTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_unversitydetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/idea.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel10.setText("BACK");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jLabel3.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter University");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 50));

        txt_university.setBackground(new java.awt.Color(102, 102, 255));
        txt_university.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_university.setToolTipText("");
        txt_university.setPlaceholder("Enter University");
        txt_university.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_universityFocusLost(evt);
            }
        });
        txt_university.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_universityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_university, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter City");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        txt_universitycity.setBackground(new java.awt.Color(102, 102, 255));
        txt_universitycity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_universitycity.setToolTipText("");
        txt_universitycity.setPlaceholder("Enter City");
        txt_universitycity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_universitycityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_universitycity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Phone Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 200, -1));

        txt_universityphonenumber.setBackground(new java.awt.Color(102, 102, 255));
        txt_universityphonenumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_universityphonenumber.setToolTipText("");
        txt_universityphonenumber.setPlaceholder("Enter Phone Number");
        txt_universityphonenumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_universityphonenumberFocusLost(evt);
            }
        });
        txt_universityphonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_universityphonenumberActionPerformed(evt);
            }
        });
        jPanel1.add(txt_universityphonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 200, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 50, 30));

        txt_campus.setBackground(new java.awt.Color(102, 102, 255));
        txt_campus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_campus.setToolTipText("");
        txt_campus.setPlaceholder("Enter Campus");
        txt_campus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_campusActionPerformed(evt);
            }
        });
        jPanel1.add(txt_campus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jLabel18.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Enter Campus");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 200, -1));

        jLabel7.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Box");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 200, -1));

        txt_pobox.setBackground(new java.awt.Color(102, 102, 255));
        txt_pobox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_pobox.setToolTipText("");
        txt_pobox.setPlaceholder("Enter P.O.BOX");
        txt_pobox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_poboxFocusLost(evt);
            }
        });
        txt_pobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_poboxActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(251, 51, 51));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, 120, 80));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(251, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 120, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(251, 51, 51));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 120, 80));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel5.setText("BACK");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel19.setText("BACK");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel22.setText("BACK");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, 40));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        txt_street.setBackground(new java.awt.Color(102, 102, 255));
        txt_street.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_street.setToolTipText("");
        txt_street.setPlaceholder("Enter Street");
        txt_street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_streetActionPerformed(evt);
            }
        });
        jPanel1.add(txt_street, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 210, -1));

        jLabel20.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Enter Street");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 1000));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_unversitydetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Univeristy", "Phone Number", "City", "Campus", "Street", "PO box"
            }
        ));
        tbl_unversitydetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_unversitydetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_unversitydetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 900, 230));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Manage Universities");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 380, 70));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 420, 5));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel21.setText("Search University");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 280, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setText("Enter Search String");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 200, -1));

        jPanel27.setBackground(new java.awt.Color(0, 0, 0));

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 680, 290, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1200, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_universityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_universityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_universityFocusLost

    private void txt_universityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_universityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_universityActionPerformed

    private void txt_universitycityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_universitycityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_universitycityActionPerformed

    private void txt_universityphonenumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_universityphonenumberFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_universityphonenumberFocusLost

    private void txt_universityphonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_universityphonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_universityphonenumberActionPerformed

    private void txt_campusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_campusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_campusActionPerformed

    private void txt_poboxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_poboxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poboxFocusLost

    private void txt_poboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_poboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poboxActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(deleteUniversity()== true) {
          JOptionPane.showMessageDialog(this, "University deleted"); 
          clearTable();
          setUniversityDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "University Deletion Failure");
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      
        if(adduniversity()== true) {
          JOptionPane.showMessageDialog(this, "University Added"); 
          clearTable();
          setUniversityDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "University Addition Failure");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        
       if(updateUniversity()== true) {
          JOptionPane.showMessageDialog(this, "University Updated"); 
          clearTable();
          setUniversityDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "University Update Failure");
        } 
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void tbl_unversitydetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_unversitydetailsMouseClicked
       
        int rowNo= tbl_unversitydetails.getSelectedRow();
        TableModel model = tbl_unversitydetails.getModel();
        
        txt_university.setText(model.getValueAt(rowNo, 0).toString());
        txt_universityphonenumber.setText(model.getValueAt(rowNo, 1).toString());
        txt_universitycity.setText(model.getValueAt(rowNo, 2).toString());
        txt_campus.setText(model.getValueAt(rowNo, 3).toString());
        txt_street.setText(model.getValueAt(rowNo, 4).toString());
        txt_pobox.setText(model.getValueAt(rowNo, 5).toString());
    }//GEN-LAST:event_tbl_unversitydetailsMouseClicked

    private void txt_streetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_streetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_streetActionPerformed

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        String searchString = txt_search.getText();
        search(searchString);
    }//GEN-LAST:event_txt_searchKeyReleased

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
            java.util.logging.Logger.getLogger(ManageUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUniversity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUniversity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_unversitydetails;
    private app.bolivia.swing.JCTextField txt_campus;
    private app.bolivia.swing.JCTextField txt_pobox;
    private javax.swing.JTextField txt_search;
    private app.bolivia.swing.JCTextField txt_street;
    private app.bolivia.swing.JCTextField txt_university;
    private app.bolivia.swing.JCTextField txt_universitycity;
    private app.bolivia.swing.JCTextField txt_universityphonenumber;
    // End of variables declaration//GEN-END:variables
}
