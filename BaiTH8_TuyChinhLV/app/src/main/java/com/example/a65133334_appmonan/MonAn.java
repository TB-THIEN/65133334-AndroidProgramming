package com.example.a65133334_appmonan;

public class MonAn {
    private String monAn;
    private double donGia;
    private String moTa;
    private int idAnhMinhHoa;

    public MonAn(String monAn, double donGia, String moTa, int idAnhMinhHoa) {
        this.monAn = monAn;
        this.idAnhMinhHoa = idAnhMinhHoa;
        this.moTa = moTa;
        this.donGia = donGia;
    }

    public String getMonAn() {
        return monAn;
    }

    public void setMonAn(String monAn) {
        this.monAn = monAn;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdAnhMinhHoa() {
        return idAnhMinhHoa;
    }

    public void setIdAnhMinhHoa(int idAnhMinhHoa) {
        this.idAnhMinhHoa = idAnhMinhHoa;
    }
}
