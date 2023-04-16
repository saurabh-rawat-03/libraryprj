/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.GridLayout;
import java.sql.*;
import java.util.*;
import javax.swing.*;


class swing extends JFrame{
    JLabel lbID, lbluname, lblpswd;
        JTextField txtID, txtname, txtpswd;
        JButton btnInser, btnUpdate, btnDelete, btnClear;
        
        swing(){
            lbID = new JLabel("Enter ID: ", SwingConstants.LEFT);
            lbluname = new JLabel("Enter Username: ", SwingConstants.LEFT);
            lblpswd = new JLabel("Password: ", SwingConstants.LEFT);
            txtID = new JTextField("",5);
            txtname = new JTextField("",5);
            txtpswd = new JTextField("",5);
            
            btnInser = new JButton("Insert");
            btnUpdate = new JButton("Update");
            btnDelete = new JButton("Delete");
            btnClear = new JButton("Clear");
            setLayout(new GridLayout(10, 4));          
            setSize(500,500);
            setVisible(true);
            add(lbID);
            add(txtID);
            add(txtname);
            add(lbluname);
            add(txtname);
            add(lblpswd);
            add(txtpswd);
            add(btnInser);
            add(btnUpdate);
            add(btnDelete);
            add(btnClear);
            btnInser.addActionListener(e -> {
                
                int id = Integer.parseInt(txtID.getText());
                String name = txtname.getText();
                String pswd = txtpswd.getText();
                try{
                       
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryprj", "root", "1910");
                    String sql = "insert into loginlibr(id, name, password) values(?,?,?)";
                    String sql1 = "select * from loginlibr";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt2 = conn.prepareStatement(sql1);
                    pstmt.setInt(1, id);
                    pstmt.setString(2,name);
                    pstmt.setString(3, pswd);
                    int i = pstmt.executeUpdate();
                    if(i==1){
                        System.out.println("Data Inserted...");
                    }else{
                        System.out.println("Error inserting data...");
                    }
                    ResultSet rs = pstmt2.executeQuery();
                    while(rs.next()){
                        int uid= rs.getInt("id");
                        String uname = rs.getString("name");
                        String upswd = rs.getString("password");

                        System.out.println("ID: "+uid);
                        System.out.println("Name: "+uname);
                        System.out.println("Password: "+upswd);
                    }
                }catch(SQLException ex){
                    System.out.println("ERROR...." + ex);
                }

            });
            
            btnUpdate.addActionListener(e -> {
                int id = Integer.parseInt(txtID.getText());
                String pswd = txtpswd.getText();

                try{
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryprj", "root", "1910");
                    String sql = "update loginlibr set password=? where id=?";
                    String sql1 = "select * from loginlibr";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt2 = conn.prepareStatement(sql1);
                    pstmt.setString(1, pswd);
                    pstmt.setInt(2,id);

                    int i = pstmt.executeUpdate();
                    if(i==1){
                        System.out.println("Data Updated...");
                    }else{
                        System.out.println("Error Updated data...");
                    }
                    ResultSet rs = pstmt2.executeQuery();
                    while(rs.next()){
                        int uid= rs.getInt("id");
                        String uname = rs.getString("name");
                        String upswd = rs.getString("password");

                        System.out.println("ID: "+uid);
                        System.out.println("Name: "+uname);
                        System.out.println("Password: "+upswd);
                    }
                }catch(SQLException ex){
                    System.out.println("ERROR...." + ex);
                }

                    
            });
            btnDelete.addActionListener(e -> {
                
                int id = Integer.parseInt(txtID.getText());

                try{
                               
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryprj", "root", "1910");
                    String sql = "delete from loginlibr where id=?";
                    String sql1 = "select * from loginlibr";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt2 = conn.prepareStatement(sql1);

                    pstmt.setInt(1,id);

                    int i = pstmt.executeUpdate();
                    if(i==1){
                        System.out.println("Data Deleted...");
                    }else{
                        System.out.println("Error Deleting data...");
                    }
                    ResultSet rs = pstmt2.executeQuery();
                    while(rs.next()){
                        int uid= rs.getInt("id");
                        String uname = rs.getString("name");
                        String upswd = rs.getString("password");

                        System.out.println("ID: "+uid);
                        System.out.println("Name: "+uname);
                        System.out.println("Password: "+upswd);
                    }
                }catch(SQLException ex){
                    System.out.println("ERROR...." + ex);
                }

                    
            });

            btnClear.addActionListener(e -> {
                    txtID.setText("");
                    txtname.setText("");
                    txtpswd.setText("");
            });


        }
}
public class file{
    public static void main(String[] args) {
        new swing();
    }  
}
