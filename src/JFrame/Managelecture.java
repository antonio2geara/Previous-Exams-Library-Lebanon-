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
public class Managelecture extends javax.swing.JFrame {

    /**
     * Creates new form ManagePrevious
     */
    
    String lectureid, chapter1, length, dateAdded ,coursename, professorid;
    DefaultTableModel model;
    public Managelecture() {
        initComponents();
        setLecturesDetailsToTable();
    }
     
    public void setLecturesDetailsToTable() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM LECTURE");
             
             while(rs.next()) {
            String lectureID = rs.getString("lectureID");
            String chapter  = rs.getString("chapter");
            String lenght  = rs.getString("lenght");
            String dateadded = rs.getString("dateadded");
            String courseName = rs.getString("courseName");
            String professorID = rs.getString("professorID");
            
            Object [] obj = {lectureID,chapter,lenght,dateadded,courseName,professorID};
            model =(DefaultTableModel) tbl_lecturedetails.getModel();
            model.addRow(obj);
             }
        }catch (Exception e){
          e.printStackTrace();
            
        }
    }
    //add universities
      public boolean addlecture(){
      boolean isAdded = false;
      lectureid = txt_lecture.getText();
      chapter1=  txt_chapter.getText();
      length = txt_length.getText();
      dateAdded = txt_date.getText();
      coursename= txt_course.getText();
      professorid = txt_professor.getText();
      
      try {
          
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
          String sql = "Insert into LECTURE VALUES(?,?,?,?,?,?)";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, lectureid);
          pst.setString(2, chapter1);
          pst.setString(3,length );
          pst.setString(4, dateAdded );
          pst.setString(5,coursename);
          pst.setString(5,professorid);       
         
          
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
     
      public boolean updatelecture() {
      boolean isUpdated = false;
      lectureid = txt_lecture.getText();
      chapter1=  txt_chapter.getText();
      length = txt_length.getText();
      dateAdded = txt_date.getText();
      coursename= txt_course.getText();
      professorid = txt_professor.getText();
      try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
          String sql = "UPDATE LECTURE SET chapter = ?,lenght = ?, dateadded = ?, courseName = ? WHERE lectureID = ? ";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, chapter1);
          pst.setString(2, length);
          pst.setString(3, dateAdded);
          pst.setString(4,coursename);
          pst.setString(5, lectureid ); 
          pst.setString(6, professorid ); 
          
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
      
      public boolean deletelecture() {
          boolean isdeleted = false;
          lectureid = txt_lecture.getText();
           try {
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_msj","root","G1e2a3r4++-098");
          String sql = "DELETE FROM LECTURE WHERE lectureID = ? ";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1,lectureid );
          
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
         DefaultTableModel model = (DefaultTableModel) tbl_lecturedetails.getModel();
         model.setRowCount(0);
     }
     
      public void search(String str) {
        
       model= (DefaultTableModel)tbl_lecturedetails.getModel();
       TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
       tbl_lecturedetails.setRowSorter(trs);
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
        txt_lecture = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_chapter = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_length = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_date = new app.bolivia.swing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_course = new app.bolivia.swing.JCTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_professor = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_lecturedetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
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
        jLabel3.setText("Enter Lecture");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 200, -1));

        txt_lecture.setBackground(new java.awt.Color(102, 102, 255));
        txt_lecture.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_lecture.setToolTipText("");
        txt_lecture.setPlaceholder("Enter Lecture");
        txt_lecture.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_lectureFocusLost(evt);
            }
        });
        txt_lecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lectureActionPerformed(evt);
            }
        });
        jPanel1.add(txt_lecture, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Chapter");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 200, -1));

        txt_chapter.setBackground(new java.awt.Color(102, 102, 255));
        txt_chapter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_chapter.setToolTipText("");
        txt_chapter.setPlaceholder("Enter Chapter");
        txt_chapter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_chapterFocusLost(evt);
            }
        });
        txt_chapter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chapterActionPerformed(evt);
            }
        });
        jPanel1.add(txt_chapter, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 200, -1));

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

        txt_length.setBackground(new java.awt.Color(102, 102, 255));
        txt_length.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_length.setToolTipText("");
        txt_length.setPlaceholder("Enter Length");
        txt_length.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_lengthFocusLost(evt);
            }
        });
        txt_length.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lengthActionPerformed(evt);
            }
        });
        jPanel1.add(txt_length, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel21.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Enter Length");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 200, -1));

        txt_date.setBackground(new java.awt.Color(102, 102, 255));
        txt_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_date.setToolTipText("");
        txt_date.setPlaceholder("Enter Date");
        txt_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dateFocusLost(evt);
            }
        });
        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });
        jPanel1.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        jLabel23.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Enter date");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 200, -1));

        jLabel24.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Enter Course");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 200, -1));

        txt_course.setBackground(new java.awt.Color(102, 102, 255));
        txt_course.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_course.setToolTipText("");
        txt_course.setPlaceholder("Enter Course");
        txt_course.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_courseFocusLost(evt);
            }
        });
        txt_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseActionPerformed(evt);
            }
        });
        jPanel1.add(txt_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jLabel25.setFont(new java.awt.Font("Swis721 BlkCn BT", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Enter Professor");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 200, -1));

        txt_professor.setBackground(new java.awt.Color(102, 102, 255));
        txt_professor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_professor.setToolTipText("");
        txt_professor.setPlaceholder("Enter ProfessorID");
        txt_professor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_professorFocusLost(evt);
            }
        });
        txt_professor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_professorActionPerformed(evt);
            }
        });
        jPanel1.add(txt_professor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 1000));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_lecturedetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lecture", "Chapter", "Length", "Date", "Course", "Professor"
            }
        ));
        tbl_lecturedetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lecturedetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_lecturedetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 900, 230));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Manage Lectures");
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setText("Search Lecture");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 260, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Enter Search String");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 200, -1));

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

    private void txt_lectureFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_lectureFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lectureFocusLost

    private void txt_lectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lectureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lectureActionPerformed

    private void txt_chapterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_chapterFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chapterFocusLost

    private void txt_chapterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chapterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chapterActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(deletelecture()== true) {
          JOptionPane.showMessageDialog(this, "Lecture deleted"); 
          clearTable();
          setLecturesDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Lecture Deletion Failure");
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      
        if(addlecture()== true) {
          JOptionPane.showMessageDialog(this, "Lecture Added"); 
          clearTable();
          setLecturesDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Lecture Addition Failure");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        
       if(updatelecture()== true) {
          JOptionPane.showMessageDialog(this, "Lecture Updated"); 
          clearTable();
          setLecturesDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Lecture Update Failure");
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

    private void tbl_lecturedetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lecturedetailsMouseClicked
       
        int rowNo= tbl_lecturedetails.getSelectedRow();
        TableModel model = tbl_lecturedetails.getModel();
        
        txt_lecture.setText(model.getValueAt(rowNo, 0).toString());
        txt_chapter.setText(model.getValueAt(rowNo, 1).toString());
        txt_length.setText(model.getValueAt(rowNo, 2).toString());
        txt_date.setText(model.getValueAt(rowNo, 3).toString());
        txt_course.setText(model.getValueAt(rowNo, 4).toString());
        txt_professor.setText(model.getValueAt(rowNo, 5).toString());
    }//GEN-LAST:event_tbl_lecturedetailsMouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void txt_lengthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_lengthFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lengthFocusLost

    private void txt_lengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lengthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lengthActionPerformed

    private void txt_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateFocusLost

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void txt_courseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_courseFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseFocusLost

    private void txt_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        String searchString = txt_search.getText();
        search(searchString);
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_professorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_professorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_professorFocusLost

    private void txt_professorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_professorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_professorActionPerformed

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
            java.util.logging.Logger.getLogger(Managelecture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Managelecture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Managelecture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Managelecture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Managelecture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private rojeru_san.complementos.RSTableMetro tbl_lecturedetails;
    private app.bolivia.swing.JCTextField txt_chapter;
    private app.bolivia.swing.JCTextField txt_course;
    private app.bolivia.swing.JCTextField txt_date;
    private app.bolivia.swing.JCTextField txt_lecture;
    private app.bolivia.swing.JCTextField txt_length;
    private app.bolivia.swing.JCTextField txt_professor;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
