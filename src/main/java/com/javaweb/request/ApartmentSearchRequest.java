package com.javaweb.request;


public class ApartmentSearchRequest {
    private String tenCanHo;
    private Integer soPhongNgu;
    private String trangThai;

    // Getters and Setters
    public String getTenCanHo() {
        return tenCanHo;
    }

    public void setTenCanHo(String tenCanHo) {
        this.tenCanHo = tenCanHo;
    }

    public Integer getSoPhongNgu() {
        return soPhongNgu;
    }

    public void setSoPhongNgu(Integer soPhongNgu) {
        this.soPhongNgu = soPhongNgu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}