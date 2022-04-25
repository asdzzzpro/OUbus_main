/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.Utils;
import com.mycompany.services.DangNhapAdminService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XGEAR
 */
public class FXMLDangNhap2Controller implements Initializable {
    @FXML private TextField username;
    @FXML private TextField password;
    
    
    @FXML
    public void handle (ActionEvent event) throws SQLException {
        String us = username.getText(); // lấy giá trị trong text field
        String pw = password.getText();
        DangNhapAdminService d = new DangNhapAdminService();
        int kq = d.dangNhapAdmin(us, pw); // truyền 2 tham số
        if(kq!=1)
            Utils.showBox("fail!", Alert.AlertType.ERROR).show(); //hiện ra box thông báo "Đăng nhập k thành công"
        if(kq ==1)
             try {
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLAdmin.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception ex) {                     
                System.out.println(ex.getMessage());
            }

    }
    public void exit (ActionEvent event) throws SQLException {
        Platform.exit();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
