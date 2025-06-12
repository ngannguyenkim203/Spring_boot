package com.example.finalproject.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LICHHEN")
public class LichHenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLH")
    private Long maLH;

    @Column(name = "NgayHen")
    private String ngayHen;

    @Column(name = "GioHen")
    private String gioHen;

    @Column(name = "TrieuChung", columnDefinition = "varchar(255)")
    private String trieuChung;

    @Column(name = "KetQuaKham", columnDefinition = "varchar(255)")
    private String ketQuaKham;

    @ManyToOne
    @JoinColumn(name = "maBN")
    private BenhNhanEntity benhNhan;

    @ManyToOne
    @JoinColumn(name = "maBS")
    private BacSiEntity bacSi;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private KhoaEntity khoa;

    public Long getMaLH() {
        return maLH;
    }

    public void setMaLH(Long maLH) {
        this.maLH = maLH;
    }

    public String getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(String ngayHen) {
        this.ngayHen = ngayHen;
    }

    public String getGioHen() {
        return gioHen;
    }

    public void setGioHen(String gioHen) {
        this.gioHen = gioHen;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getKetQuaKham() {
        return ketQuaKham;
    }

    public void setKetQuaKham(String ketQuaKham) {
        this.ketQuaKham = ketQuaKham;
    }

    public BenhNhanEntity getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhanEntity benhNhan) {
        this.benhNhan = benhNhan;
    }

    public BacSiEntity getBacSi() {
        return bacSi;
    }

    public void setBacSi(BacSiEntity bacSi) {
        this.bacSi = bacSi;
    }

    public KhoaEntity getKhoa() {
        return khoa;
    }

    public void setKhoa(KhoaEntity khoa) {
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "LichHenEntity{" +
                "maLH=" + maLH +
                ", ngayHen=" + ngayHen +
                ", gioHen='" + gioHen + '\'' +
                ", trieuChung='" + trieuChung + '\'' +
                ", ketQuaKham='" + ketQuaKham + '\'' +
                ", benhNhanEntity=" + benhNhan +
                ", bacSiEntity=" + bacSi +
                ", khoaEntity=" + khoa +
                '}';
    }
}
