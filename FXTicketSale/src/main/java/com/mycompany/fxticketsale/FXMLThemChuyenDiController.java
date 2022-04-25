/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.Utils;
import com.mycompany.pojo.ChuyenXe;
import com.mycompany.services.ChuyenDiService;
import com.mycompany.services.ThemChuyenDiService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import com.mycompany.fxticketsale.FXMLAdminController;

/**
 * FXML Controller class
 *
 * @author XGEAR
 */
public class FXMLThemChuyenDiController implements Initializable {
    @FXML private TextField maChuyenXe;
    @FXML private TextField txtDiemDi;
    @FXML private TextField textDiemDen;
    @FXML private TextField maXe;
    @FXML private TextField ngayXuatPhat;
    @FXML private TextField giaVe;
   
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void themChuyenDi(ActionEvent event) throws SQLException{
        ChuyenXe c = new ChuyenXe(Integer.parseInt(this.maChuyenXe.getText()),Integer.parseInt(this.maXe.getText()),this.ngayXuatPhat.getText(),Integer.parseInt(this.giaVe.getText()), this.txtDiemDi.getText(),this.textDiemDen.getText());
        ThemChuyenDiService s = new ThemChuyenDiService();
        try {
            s.themChuyenDi(c);
            Utils.getBox("thêm chuyến đi thành công !!!", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            Utils.getBox("thêm chuyến đi thất bại !!!", Alert.AlertType.WARNING).show();
            this.txtDiemDi.clear();
            this.textDiemDen.clear();
        }
      
    }
    
}
