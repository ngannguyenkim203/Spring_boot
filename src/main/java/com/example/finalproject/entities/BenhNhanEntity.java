package com.example.finalproject.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BENHNHAN")
public class BenhNhanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBN")
    private Long maBN;

    @Column(name = "HoTen", columnDefinition = "varchar(255)", nullable = false)
    private String hoTen;

    @Column(name = "NgaySinh", nullable = false)
    private Date ngaySinh;

    @Column(name = "GioiTinh", nullable = false)
    private Integer gioiTinh;

    @Column(name = "DiaChi", columnDefinition = "varchar(255)", nullable = false)
    private String diaChi;

    @Column(name = "SDT", columnDefinition = "varchar(10)", nullable = false)
    private String sdt;

    @OneToMany(mappedBy = "benhNhan", fetch = FetchType.LAZY)
    private List<LichHenEntity> danhSachBN;

    public BenhNhanEntity() {

    }

    public BenhNhanEntity(Long maBN, String hoTen, Date ngaySinh, Integer gioiTinh, String diaChi, String sdt) {
        this.maBN = maBN;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Long getMaBN() {
        return maBN;
    }

    public void setMaBN(Long maBN) {
        this.maBN = maBN;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "BenhNhanEntity{" +
                "maBN=" + maBN +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
