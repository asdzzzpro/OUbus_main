/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.conf.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Qhuy
 */
public class DangNhapNhanVienService {
    public Integer dangNhapNhanVien(String us, String pw) throws SQLException {
         try (Connection conn = JdbcUtils.getConn()) { 
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM nhanvien");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) { //
               if(rs.getString("username").equals(us) && rs.getString("password").equals(pw))
                   
               {
                   Utils.showBox("successful!", Alert.AlertType.INFORMATION).show(); 
//                   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDangNhap.fxml"));
//                   Parent root1 = (Parent) fxmlLoader.load();
//                   Stage stage = new Stage();
//                   stage.setScene(new Scene(root1));
//                   stage.close();
                   return 1;
               }
               
               else 
                   Utils.showBox("K đúng tài khoản hoặc mật khẩu", Alert.AlertType.WARNING).show();
                   return -1;
               
            }   
        }
        catch(Exception e) { // ngoại lệ
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
