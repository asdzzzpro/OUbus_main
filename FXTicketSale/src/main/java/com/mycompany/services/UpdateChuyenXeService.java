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
public class UpdateChuyenXeService {
     public void capNhatChuyenDi(ChuyenXe d ) throws SQLException{
          try(Connection conn = JdbcUtils.getConn()){
            conn.setAutoCommit(false);
            PreparedStatement stm = conn.prepareStatement(" UPDATE chuyenxe SET maXe = ?, ngayXuatPhat = ? , giaVe = ? , diemDi = ?, diemDen = ? WHERE maChuyenXe = ?");
            stm.setInt(1, d.getMaXe());
            stm.setString(2, d.getNgayXuatPhat());
            stm.setInt(3, d.getGiaVe());
            stm.setString(4, d.getDiemDi());
            stm.setString(5, d.getDiemDen());
            stm.setInt(6, d.getMaChuyenXe());
            stm.executeUpdate();
            conn.commit();
          }
     }
          
}
