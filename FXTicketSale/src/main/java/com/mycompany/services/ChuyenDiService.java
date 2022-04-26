    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author XGEAR
 */
public class ChuyenDiService {
    public List<ChuyenXe> getCacChuyenDi() throws SQLException{
        List<ChuyenXe> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM  chuyenxe");
            while (rs.next()){
               
                ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"), rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
            
                results.add(c);
            }
        }
        return results;
    }

     public List<ChuyenXe> getChuyenDis(String kw) throws SQLException{
         try(Connection conn = JdbcUtils.getConn()){
         PreparedStatement stm = conn.prepareStatement("SELECT  * FROM chuyenxe WHERE diemDi like concat('%', ? , '%')");
         if(kw == null)
             kw = "";
         stm.setString(1, kw);
         ResultSet rs = stm.executeQuery();
         List<ChuyenXe> chuyenxe = new ArrayList<>();
         while (rs.next()){
             ChuyenXe k = new ChuyenXe(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
             chuyenxe.add(k);
         }
          return chuyenxe ;
        }    
    }

     public static void deleteChuyenDi(int MaChuyenXe) throws SQLException {
       String sql = "DELETE FROM chuyenxe WHERE maChuyenXe=?";
       Connection conn = JdbcUtils.getConn();
       conn.setAutoCommit(false);
       
       PreparedStatement stm = conn.prepareStatement(sql);
       stm.setInt(1, MaChuyenXe);
       stm.executeUpdate();
       
       conn.commit();
     
   }
     public static void themChuyenDi(ChuyenXe q) throws SQLException{
        try(Connection conn = JdbcUtils.getConn()){
            conn.setAutoCommit(false);
            PreparedStatement stm1 = conn.prepareStatement("INSERT INTO chuyenxe(maChuyenXe,maXe,ngayXuatPhat,giaVe,diemDi,diemDen) VALUES(?,?,?,?,?,?)");
            stm1.setInt(1,q.getMaChuyenXe());
            stm1.setInt(2, q.getMaXe());
            stm1.setString(3, q.getNgayXuatPhat());
            stm1.setInt(4, q.getGiaVe());
            stm1.setString(5, q.getDiemDi());
            stm1.setString(6, q.getDiemDen());
            stm1.executeUpdate();
            conn.commit();
        }
            
    }
     
     public static  Alert getAlertInfo(String content , Alert.AlertType type){
         Alert a = new Alert(type);
         a.setContentText(content);
         return a;
  
     }
 public static List<ChuyenXe> getChuyenXe(String kw) throws SQLException {
        List<ChuyenXe> chuyendi = new ArrayList<>();
        
        try (Connection conn = JdbcUtils.getConn()){
           String sql = " SELECT * FROM chuyenxe";
           if (kw != null && !kw.isEmpty())
               sql += " WHERE diemDi like concat('%', ? , '%')";
           PreparedStatement stm = conn.prepareStatement(sql);
           if(kw != null && !kw.isEmpty())
               stm.setString(1, kw);
           ResultSet rs = stm.executeQuery();
           while (rs.next()){
               ChuyenXe c = new ChuyenXe(rs.getInt("maChuyenXe"),rs.getInt("maXe"), rs.getString("ngayXuatPhat"),rs.getInt("giaVe"), rs.getString("diemDi"),rs.getString("diemDen"));
               chuyendi.add(c);
           }        
       }
        return chuyendi;
        
    }
          
    
}
    

