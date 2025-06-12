package com.example.finalproject.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "KHOA")
public class KhoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhoa")
    private Long maKhoa;

    @Column(name = "TenKhoa", columnDefinition = "varchar(50)")
    private String tenKhoa;

    @Column(name = "MoTa", columnDefinition = "varchar(255)")
    private String moTa;

    @OneToMany(mappedBy = "khoa", fetch = FetchType.LAZY)
    private List<LichHenEntity> danhSachKhoa;

    public KhoaEntity() {
    }

    public KhoaEntity(Long maKhoa, String tenKhoa, String moTa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.moTa = moTa;
    }

    public Long getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(Long maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "KhoaEntity{" +
                "maKhoa=" + maKhoa +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}
