/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxticketsale;

import com.mycompany.conf.Utils;
import com.mycompany.conf.JdbcUtils;
import com.mycompany.pojo.ChuyenXe;
import com.mycompany.services.ChuyenDiService;
import com.mycompany.services.UpdateChuyenXeService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
 * @author XGEAR
 */
public class FXMLAdminController implements Initializable {
    @FXML private TableView<ChuyenXe> tbcacChuyenDi;
    @FXML private TextField maChuyenXe;
    @FXML private TextField maXe;
    @FXML private TextField ngayXuatPhat;
    @FXML private TextField giaVe;
    @FXML private TextField diemDi;
    @FXML private TextField diemDen;
    @FXML private Button updatebtn;
    @FXML private TextField timkiembtn;
//    @FXML private TableColumn<ChuyenXe, Integer> idColumn;
//    @FXML private TableColumn<ChuyenXe, String> diemDiColumn;
//    @FXML private TableColumn<ChuyenXe, String> diemDenColumn;
//    @FXML private TextField keywords;
   
//    ObservableList<ChuyenXe> oblist = FXCollections.observableArrayList();
    
    
     @FXML
    void themchuyendi(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLThemChuyenDi.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLWelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        try {
            this.loadTableData();
            this.timkiem(null);
            timkiembtn.textProperty().addListener((evt) ->{
                this.timkiem(timkiembtn.getText());
            });
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            this.loadTableView();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        this.updatebtn.setVisible(false);
        this.tbcacChuyenDi.setRowFactory(et -> {
                TableRow row = new TableRow();
                row.setOnMouseClicked(r ->{
                    this.updatebtn.setVisible(true);
                    ChuyenXe d = (ChuyenXe)this.tbcacChuyenDi.getSelectionModel().getSelectedItem();
                    this.maChuyenXe.setText(String.valueOf(d.getMaChuyenXe()));
                    this.maXe.setText(String.valueOf(d.getMaXe()));
                    this.giaVe.setText(String.valueOf(d.getGiaVe()));
                    this.diemDi.setText(String.valueOf(d.getDiemDi()));
                    this.diemDen.setText(String.valueOf(d.getDiemDen()));
                    this.ngayXuatPhat.setText(String.valueOf(d.getNgayXuatPhat()));
              
                });
            return row;    
            });
}
    
    public void updateChuyenXeHandler(ActionEvent event) throws SQLException{
            ChuyenXe c = new ChuyenXe(Integer.parseInt(this.maChuyenXe.getText()),Integer.parseInt(this.maXe.getText()),this.ngayXuatPhat.getText(),Integer.parseInt(this.giaVe.getText()), this.diemDi.getText(),this.diemDen.getText());
             UpdateChuyenXeService s = new UpdateChuyenXeService();
             s.capNhatChuyenDi(c);
            try {
            s.capNhatChuyenDi(c);
            Utils.getBox("C???p nh???t th??nh c??ng!", Alert.AlertType.INFORMATION).show();
            this.loadTableData();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Utils.getBox("C???p nh???t th???t b???i!", Alert.AlertType.WARNING).show();
        }        
    }
    
    

    private void loadTableView() throws SQLException{
        
            TableColumn colMaChuyenXe = new TableColumn("M?? Chuy???n ??i");
            colMaChuyenXe.setCellValueFactory(new PropertyValueFactory("maChuyenXe"));
            
            TableColumn colMaXe = new TableColumn("M?? Xe");
            colMaXe.setCellValueFactory(new PropertyValueFactory("maXe"));

            
            TableColumn colNgayXuatPhat = new TableColumn("Ng??y Xu???t Ph??t");
            colNgayXuatPhat.setCellValueFactory(new PropertyValueFactory("ngayXuatPhat"));
            
            TableColumn colGiaVe = new TableColumn("Gi?? V??");
            colGiaVe.setCellValueFactory(new PropertyValueFactory("giaVe"));
            
            TableColumn colDiemDi = new TableColumn("??i???m ??i");
            colDiemDi.setCellValueFactory(new PropertyValueFactory("diemDi"));

            TableColumn colDiemDen = new TableColumn("??i???m ?????n");
            colDiemDen.setCellValueFactory(new PropertyValueFactory("diemDen"));
            
            TableColumn coldelete = new TableColumn();
            coldelete.setCellFactory(p -> {
                
                Button btn = new Button("X??a");
              
                btn.setOnAction(et ->{
                    Alert confirm = ChuyenDiService.getAlertInfo("B???n C?? Mu???n X??a Chuy???n ??i N??y Kh??ng?", Alert.AlertType.CONFIRMATION);
                    confirm.setContentText("B???n c?? mu???n x??a chuy???n ??i n??y kh??ng?");
                    confirm.showAndWait().ifPresent(res ->{
                       if(res == ButtonType.OK){
                           TableCell cl = (TableCell)((Button)et.getSource()).getParent();
                           ChuyenXe c = (ChuyenXe)cl.getTableRow().getItem();
                           try {
                               ChuyenDiService.deleteChuyenDi(c.getMaChuyenXe());
                               this.tbcacChuyenDi.getItems().clear();
                                this.tbcacChuyenDi.setItems(FXCollections.observableArrayList(ChuyenDiService.getChuyenXe("")));     
                              ChuyenDiService.getAlertInfo("X??a Chuy???n ??i Th??nh C??ng ", Alert.AlertType.INFORMATION).show();
                           } catch (SQLException ex) {
                                ChuyenDiService.getAlertInfo("X??a Chuy???n ??i Th???t B???i  " +ex.getMessage(), Alert.AlertType.INFORMATION).show();
                               
                           }
                       }
                    });
                    
                
                });
                TableCell cell = new TableCell();
                cell.setGraphic(btn);
                return cell;
            });
            
            this.loadTableData();
            this.tbcacChuyenDi.getColumns().addAll(colMaChuyenXe,colMaXe,colNgayXuatPhat, colGiaVe, colDiemDi, colDiemDen, coldelete); 
           
         }   
    
    private void loadTableData() throws SQLException{
        ChuyenDiService s = new ChuyenDiService();
        this.tbcacChuyenDi.setItems(FXCollections.observableList(s.getCacChuyenDi()));
    }
    
    private void timkiem(String kw){
    ChuyenDiService s = new ChuyenDiService();
        try {
            this.tbcacChuyenDi.setItems(FXCollections.observableArrayList(s.getChuyenDis(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
     public void  reload(ActionEvent event) throws SQLException{
         this.loadTableData();
     }
  
}
