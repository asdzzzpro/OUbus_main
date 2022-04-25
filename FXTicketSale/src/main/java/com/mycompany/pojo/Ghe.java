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
public class Ghe {
    private int maGhe;
    private String tenGhe;
    private int tinhTrangGhe;
    private int maXe;

    public Ghe() {
    }

    public Ghe(int maGhe, String tenGhe, int tinhTrangGhe, int maXe) {
        this.maGhe = maGhe;
        this.tenGhe = tenGhe;
        this.tinhTrangGhe = tinhTrangGhe;
        this.maXe = maXe;
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
     * @return the tenGhe
     */
    public String getTenGhe() {
        return tenGhe;
    }

    /**
     * @param tenGhe the tenGhe to set
     */
    public void setTenGhe(String tenGhe) {
        this.tenGhe = tenGhe;
    }

    /**
     * @return the tinhTrangGhe
     */
    public int getTinhTrangGhe() {
        return tinhTrangGhe;
    }

    /**
     * @param tinhTrangGhe the tinhTrangGhe to set
     */
    public void setTinhTrangGhe(int tinhTrangGhe) {
        this.tinhTrangGhe = tinhTrangGhe;
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
}
