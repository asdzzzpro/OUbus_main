/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author XGEAR
 */
public class ThemChuyenDiService {
    public void themChuyenDi(ChuyenXe q) throws SQLException{
        try(Connection conn = JdbcUtils.getConn()){
            conn.setAutoCommit(false);
            PreparedStatement stm1 = conn.prepareStatement("INSERT INTO chuyenxe(maChuyenXe,maXe,ngayXuatPhat,giaVe,diemDi,diemDen) VALUES(?,?,?,?,?,?)");
            stm1.setInt(1,q.getMaChuyenXe());
            stm1.setInt(2, q.getMaXe());
            stm1.setString(3, q.getNgayXuatPhat());
            stm1.setInt(4, q.getGiaVe());
            stm1.setString(5, q.getDiemDi());
            stm1.setString(6, q.getDiemDen());
            
//            stm1.executeUpdate();
             stm1.executeUpdate();
            
            conn.commit();
        }
            
    }
}
