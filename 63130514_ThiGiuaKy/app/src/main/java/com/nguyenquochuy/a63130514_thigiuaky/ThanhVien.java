package com.nguyenquochuy.a63130514_thigiuaky;

public class ThanhVien {
    private String tenTV;
    private String anh;
    private String quequan;

    public ThanhVien(String tenTV, String anh, String quequan) {
        this.tenTV = tenTV;
        this.anh = anh;
        this.quequan = quequan;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}
