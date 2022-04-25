/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.JdbcUtils;
import com.mycompany.conf.Utils;
import com.mycompany.pojo.ChuyenXe;
import com.mycompany.pojo.VeXe;
import com.mycompany.services.ChuyenDiService;
import com.mycompany.services.VeXeService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Qhuy
 */
public class FXMLBookController implements Initializable {
    @FXML
    private TextField txtTimKiem;
    @FXML
    private TextField txtTenVe;
    @FXML
    private TextField txtMaChuyen;
    @FXML
    private TextField txtMaGhe;
    @FXML
    private TextField txtMaNV;
    @FXML
    private TextField txtTenKH;
    @FXML
    private TextField txtSdt;
    @FXML
    private DatePicker txtNgayDat;
    @FXML
    private TableView<ChuyenXe> tbcacChuyenDi;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.loadTableView();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.loadTableData(null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtTimKiem.textProperty().addListener(evt -> {            
            try {
                this.loadTableData(this.txtTimKiem.getText());
            } catch (SQLException ex) {
                Logger.getLogger(FXMLBookController.class.getName()).log(Level.SEVERE, null, ex);
            }            
        });
        
    }    
    

    
    public void themVe(ActionEvent event) throws SQLException{
//        Connection conn = JdbcUtils.getConn();
//        PreparedStatement ps1 = conn.prepareStatement("Select * from ghe");        
//        ResultSet rs = ps1.executeQuery();
//        while (rs.next()) {            
//            if(this.txtMaGhe.getText().equals(rs.getString("maGhe"))){
//                Utils.showBox("Ghế đã đặt!", Alert.AlertType.WARNING).show();
//            }else{
//                this.test();
////                ps1.setInt(0, 0);
//                Statement stm = conn.createStatement();
//                stm.executeUpdate("update ghe set tinhTrangGhe=0 where maGhe= '" +txtMaGhe.getText()+"'");
//            }
//        }
        String sql = "INSERT INTO vexe (tenVe,maChuyenXe,maGhe,maNV,tenKH,sdtKH,ngayDatVe) values(?,?,?,?,?,?,?)";
        Connection conn = JdbcUtils.getConn();
        try{
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtTenVe.getText());
            ps.setString(2, txtMaChuyen.getText());
            ps.setString(3, txtMaGhe.getText());
            ps.setString(4, txtMaNV.getText());
            ps.setString(5, txtTenKH.getText());
            ps.setString(6, txtSdt.getText());
            ps.setString(7, txtNgayDat.getEditor().getText());
            ps.executeUpdate();
            conn.commit();
            Utils.showBox("Them ve thanh cong", Alert.AlertType.INFORMATION).show();
        }catch(Exception ex){
            Utils.showBox("Khong the them ve moi", Alert.AlertType.WARNING).show();
        }
        
        
        
    }
    
    
    public void suaVe(ActionEvent event) throws IOException, SQLException{
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("FXMLChinhSua.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.show();
        
    }
    private void loadTableView() throws SQLException{
            TableColumn colId = new TableColumn("Mã Chuyến");
            colId.setCellValueFactory(new PropertyValueFactory("maChuyenXe"));
            
            TableColumn colNgayXuatPhat = new TableColumn("Ngày Xuất Phát");
            colNgayXuatPhat.setCellValueFactory(new PropertyValueFactory("ngayXuatPhat"));
            colNgayXuatPhat.setPrefWidth(80);
            
            TableColumn colGiaVe = new TableColumn("Giá Vé");
            colGiaVe.setCellValueFactory(new PropertyValueFactory("giaVe"));
            colGiaVe.setPrefWidth(80);
            
            TableColumn colDiemDi = new TableColumn("Điểm Đi");
            colDiemDi.setCellValueFactory(new PropertyValueFactory("diemDi"));
            colDiemDi.setPrefWidth(80);

            TableColumn colDiemDen = new TableColumn("Điểm Đến");
            colDiemDen.setCellValueFactory(new PropertyValueFactory("diemDen"));
            colDiemDen.setPrefWidth(80);    
            this.tbcacChuyenDi.getColumns().addAll(colId, colDiemDi, colDiemDen, colGiaVe, colNgayXuatPhat); 
           
         }   
    
    private void loadTableData(String kw) throws SQLException{
        ChuyenDiService s = new ChuyenDiService();
        this.tbcacChuyenDi.setItems(FXCollections.observableArrayList(s.getChuyenXe(kw) ));
    }
//    private void loadColumns(){
////        tbVeXe.setEditable(true);
//        TableColumn col1 = new TableColumn("Ten Ve");
//        col1.setCellValueFactory(new PropertyValueFactory<>("tenVe"));
//        
//        TableColumn col2 = new TableColumn("Ma Chuyen Xe");
//        col2.setCellValueFactory(new PropertyValueFactory<>("maChuyenXe"));
//        
//        TableColumn col3 = new TableColumn("Ma Ghe");
//        col3.setCellValueFactory(new PropertyValueFactory<>("maGhe"));
//        
//        TableColumn col4 = new TableColumn("Ten KH");
//        col4.setCellValueFactory(new PropertyValueFactory<>("tenKH"));
//        
//        TableColumn col5 = new TableColumn("SDT");
//        col5.setCellValueFactory(new PropertyValueFactory<>("sdtKH"));
//        
//        TableColumn col6 = new TableColumn("Ngay Dat");
//        col6.setCellValueFactory(new PropertyValueFactory<>("ngayDatVe"));
//        
//        TableColumn col7 = new TableColumn();
////        col7.setPrefWidth(50);
//        col7.setCellFactory(p -> {
//            
//            Button btn = new Button("Xoa");
//            btn.setOnAction((ac ->{
//                Alert confirm = VeXeService.getBox("Huy ve xe nay ?", Alert.AlertType.CONFIRMATION);
//                confirm.setContentText("Ban co chac muon huy ve xe nay?");
//                confirm.showAndWait().ifPresent(ch -> {
//                    if(ch == ButtonType.OK){
//                        TableCell tc = (TableCell)((Button)ac.getSource()).getParent();
//                        
//                        VeXe v = (VeXe)tc.getTableRow().getItem();
////                        System.out.println("test");
//                        
//                        try {
//                            VeXeService.xoaVe(v.getMaVe());
////                            System.out.println("test");
//                            this.tbVeXe.getItems().clear();
//                            this.tbVeXe.setItems(FXCollections.observableList(VeXeService.getListVeXe("")));
//                            VeXeService.getBox("Xoa thanh cong", Alert.AlertType.INFORMATION).show();
//                        } catch (SQLException ex) {
//                            VeXeService.getBox("Xoa that bai", Alert.AlertType.ERROR).show();
//                        }
//                            
//                            
//                        
//                    }
//                });
//            }));
//            TableCell cell = new TableCell();
//            cell.setGraphic(btn);
//            return cell;
//        });
//        
////        TableColumn col8 = new TableColumn();
////        col8.setCellFactory(p -> {
////            Button btn1 = new Button("Xuat");
////            
////            return null;
////        });
//        //        this.btnUpdate.setVisible(false);
////             // Select row on Tableview
////        this.tbdepartm.setRowFactory(et -> {
////            TableRow row = new TableRow();
////            row.setOnMouseClicked(r -> {
////                this.btnUpdate. setVisible(true);
////                Department d = (Department) this.tbdepartm.getSelectionModel().getSelectedItem();
////                 this.txtid.setText(String.valueOf(d.getId()));
////                 this.txtname.setText(String.valueOf(d.getName()));
////                 this.txtaddress.setText(String.valueOf(d.getAddress()));
////                 this.txtphone.setText(String.valueOf(d.getPhone()));
////            });
////        return row;
////        });
//        
//
//               
//        this.tbVeXe.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
//        
//        
//    }
//    
//    public void loadData(String kw) throws SQLException{
//        VeXeService s = new VeXeService();
//        this.tbVeXe.setItems(FXCollections.observableList(s.getListVeXe(kw)));
//    }
//    public void loadData1(String kw) throws SQLException{
//        VeXeService s = new VeXeService();
//        this.tbVeXe.setItems(FXCollections.observableList(s.getListVeXe()));
//    }
}
