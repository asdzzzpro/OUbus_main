/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

/**
 *
 * @author Qhuy
 */
public class VeXe {
    private int maVe;
    private String tenVe;
    private String maChuyenXe;
    private int maGhe;
    private String tenKH;
    private String sdtKH;
    private String ngayDatVe;
    private int maNV;

    public VeXe() {
    }

    public VeXe(String tenVe, String maChuyenXe, int maGhe, String tenKH, String sdtKH, String ngayDatVe, int maNV) {
        this.tenVe = tenVe;
        this.maChuyenXe = maChuyenXe;
        this.maGhe = maGhe;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.ngayDatVe = ngayDatVe;
        this.maNV = maNV;
    }

    public VeXe(int maVe, String tenVe, String maChuyenXe, int maGhe, String tenKH, String sdtKH, String ngayDatVe, int maNV) {
        this.maVe = maVe;
        this.tenVe = tenVe;
        this.maChuyenXe = maChuyenXe;
        this.maGhe = maGhe;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.ngayDatVe = ngayDatVe;
        this.maNV = maNV;
    }

    
    
    

    /**
     * @return the maVe
     */
    public int getMaVe() {
        return maVe;
    }

    /**
     * @param maVe the maVe to set
     */
    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    /**
     * @return the tenVe
     */
    public String getTenVe() {
        return tenVe;
    }

    /**
     * @param tenVe the tenVe to set
     */
    public void setTenVe(String tenVe) {
        this.tenVe = tenVe;
    }

    /**
     * @return the maChuyenXe
     */
    public String getMaChuyenXe() {
        return maChuyenXe;
    }

    /**
     * @param maChuyenXe the maChuyenXe to set
     */
    public void setMaChuyenXe(String maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    /**
     * @return the maGhe
     */
    public int getMaGhe() {
        return maGhe;
    }

    /**
     * @param maGhe the maGhe to set
     */
    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    /**
     * @return the tenKH
     */
    public String getTenKH() {
        return tenKH;
    }

    /**
     * @param tenKH the tenKH to set
     */
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    /**
     * @return the sdtKH
     */
    public String getSdtKH() {
        return sdtKH;
    }

    /**
     * @param sdtKH the sdtKH to set
     */
    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    /**
     * @return the ngayDatVe
     */
    public String getNgayDatVe() {
        return ngayDatVe;
    }

    /**
     * @param ngayDatVe the ngayDatVe to set
     */
    public void setNgayDatVe(String ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

}
