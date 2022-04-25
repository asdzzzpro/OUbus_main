/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.conf.Utils;
import static com.mycompany.fxticketsale.FXMLChinhSuaController.id;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Qhuy
 */
public class FXMLXuatController implements Initializable {
@FXML
    private Label txtdiemDi;
    @FXML
    private Label txtdiemDen;
    @FXML
    private Label txtNgayDat;
    @FXML
    private Label txtNgayKhoiHanh;
    @FXML
    private Label txtGhe;
    @FXML
    private Label txtGiaVe;
    @FXML
    private Label txtHoTen;
    @FXML
    private Label txtSDT;
    @FXML
    private Label txtNV;
    @FXML 
    private Label txtIn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            xuatVe(id);
            System.out.println(id);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(FXMLXuatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void xuatVe(int kw) throws SQLException{
        Connection conn = JdbcUtils.getConn();
        String sql2 = "SELECT diemDi,diemDen,ngayDatVe,ngayXuatPhat,tenGhe,giaVe,tenKH,sdtKH,tenNV from oubus.vexe "
                + "join chuyenxe on vexe.maChuyenXe=chuyenxe.maChuyenXe\n" +
                    "join nhanvien on vexe.maNV=nhanvien.maNV\n" +
                    "join ghe on vexe.maGhe=ghe.maGhe where maVe=?";
        PreparedStatement ps = conn.prepareStatement(sql2);
        if (kw == 0 )
            Utils.showBox("Khong tim thay ve", Alert.AlertType.WARNING);
        ps.setInt(1, kw);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            this.txtdiemDi.setText(rs.getString("diemDi"));
            this.txtdiemDen.setText(rs.getString("diemDen"));
            this.txtNgayDat.setText(rs.getString("ngayDatVe"));
            this.txtNgayKhoiHanh.setText(rs.getString("ngayXuatPhat"));
            this.txtGhe.setText(rs.getString("tenGhe"));
            this.txtGiaVe.setText(rs.getString("giaVe"));
            this.txtHoTen.setText(rs.getString("tenKH"));
            this.txtSDT.setText(rs.getString("sdtKH"));
            this.txtNV.setText(rs.getString("tenNV"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.txtIn.setText(dtf.format(now));
        }
    }
    public void banVe(ActionEvent event) throws SQLException{
        try (Connection conn = JdbcUtils.getConn()){
            PreparedStatement ps = conn.prepareStatement("UPDATE oubus.vexe SET tinhTrangVe='đã bán' WHERE maVe=?");
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
//            System.out.println("test");
            Utils.showBox("Đã bán vé", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            Utils.showBox("Error", Alert.AlertType.WARNING).show();
        }
    }
}
