/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Qhuy
 */
public class ChuyenXe {
    private int  maChuyenXe;
    private int maXe;
    private String ngayXuatPhat;
    private int giaVe;
    private String diemDi;
    private String diemDen;

    public ChuyenXe() {
    }

    public ChuyenXe(int maChuyenXe , int maXe, String ngayXuatPhat, int giaVe, String diemDi, String diemDen) {
        this.maChuyenXe = maChuyenXe;
        this.maXe = maXe;
        this.ngayXuatPhat = ngayXuatPhat;
        this.giaVe = giaVe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
    }
    public ChuyenXe( int maXe, String ngayXuatPhat, int giaVe, String diemDi, String diemDen) {
        this.maXe = maXe;
        this.ngayXuatPhat = ngayXuatPhat;
        this.giaVe = giaVe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
    }
    
    

//    public ChuyenDi(int maXe, String diemDi, String diemDen){
//        this.maXe = maXe;
//        this.diemDi = diemDi;
//        this.diemDen = diemDen;
//    }
//    
    /**
     * @return the maChuyenXeString
     */
    public int getMaChuyenXe() {
        return maChuyenXe;
    }

    /**
     * @param maChuyenXe the maChuyenXeInt to set
     */
    public void setMaChuyenXe(int maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    /**
     * @return the maXe
     */
    public int getMaXe() {
        return maXe;
    }

    /**
     * @param maXe the maXe to set
     */
    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    /**
     * @return the ngayXuatPhat
     */
    public String getNgayXuatPhat() {
        return ngayXuatPhat;
    }

    /**
     * @param ngayXuatPhat the ngayXuatPhat to set
     */
    public void setNgayXuatPhat(String ngayXuatPhat) {
        this.ngayXuatPhat = ngayXuatPhat;
    }

    /**
     * @return the giaVe
     */
    public int getGiaVe() {
        return giaVe;
    }

    /**
     * @param giaVe the giaVe to set
     */
    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    /**
     * @return the diemDi
     */
    public String getDiemDi() {
        return diemDi;
    }

    /**
     * @param diemDi the diemDi to set
     */
    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    /**
     * @return the diemDen
     */
    public String getDiemDen() {
        return diemDen;
    }

    /**
     * @param diemDen the diemDen to set
     */
    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    
    
}
