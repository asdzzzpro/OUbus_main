/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.VeXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author Qhuy
 */
public class VeXeService {
    public static Alert getBox(String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(content);
        return alert;
    }
    public static List<VeXe> getListVeXe(String kw) throws SQLException {
        
        List<VeXe> listVX = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn();) {
            PreparedStatement ps = conn.prepareStatement("select * from vexe WHERE tenKH like concat('%', ?, '%') OR sdtKH like concat('%', ?, '%')");
            
            if (kw == null)
               kw = "";
           ps.setString(1, kw);
           ps.setString(2, kw);
           ResultSet rs = ps.executeQuery();

            while (rs.next()) {
//                listVX.add(new VeXe(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(5))));
            }
        } catch (Exception e) {
            System.out.println("Cannot Connect" + e.getMessage());
        }
        return listVX;
    }
    
    public static void xoaVe(int maVe) throws SQLException{
        
        Connection conn = JdbcUtils.getConn();
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("DELETE FROM vexe WHERE maVe = ?");
//        PreparedStatement ps1 = conn.prepareStatement()
        ps.setInt(1, maVe);
        ps.execute();
        conn.commit();
        
    }
}
