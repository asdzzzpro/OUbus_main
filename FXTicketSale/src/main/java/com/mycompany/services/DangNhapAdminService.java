/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.conf.Utils;
import com.mycompany.conf.JdbcUtils;
import com.mycompany.fxticketsale.FXMLWelcomeController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author XGEAR
 */
public class DangNhapAdminService {
    public Integer dangNhapAdmin(String us, String pw) throws SQLException {
         try (Connection conn = JdbcUtils.getConn()) { 
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM admin");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) { //
               if(us.equals(rs.getString("username")) && rs.getString("password").equals(pw))
                   
               {
                   Utils.getBox("successful!", Alert.AlertType.INFORMATION).show(); 
                   return 1;
               }
               
               else 
                   return -1;
               
            }   
        }
        catch(Exception e) { // ngoại lệ
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
