/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.Utils;
import com.mycompany.services.DangNhapNhanVienService;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Qhuy
 */
public class FXMLDangNhapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    
    
    @FXML
    public void handle (ActionEvent event) throws SQLException {
        String us = username.getText(); // lấy giá trị trong text field
        String pw = password.getText();
        DangNhapNhanVienService d = new DangNhapNhanVienService();
        int kq = d.dangNhapNhanVien(us, pw); // truyền 2 tham số
        if(kq!=1)
//            Utils.showBox("fail!", Alert.AlertType.ERROR).show(); //hiện ra box thông báo "Đăng nhập k thành công"
            System.out.println("test");
        if(kq ==1)
             try {                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLBook.fxml"));
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
