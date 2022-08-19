package com.example.bookshop.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SanPham")

public class SanPham {
    @PrimaryKey(autoGenerate = true)
    private int maSP;
    private int anhSP;
    private String tenSP;
    private int giaSP;
    private String moTaSP;

    public SanPham() {
    }

    public SanPham(int maSP, int anhSP, String tenSP, int giaSP, String moTaSP) {
        this.maSP = maSP;
        this.anhSP = anhSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.moTaSP = moTaSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(int anhSP) {
        this.anhSP = anhSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public String getMoTaSP() {
        return moTaSP;
    }

    public void setMoTaSP(String moTaSP) {
        this.moTaSP = moTaSP;
    }
}
