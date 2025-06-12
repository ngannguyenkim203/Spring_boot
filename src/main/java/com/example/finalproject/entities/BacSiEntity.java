package com.example.finalproject.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BACSI")
public class BacSiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBS")
    private Long maBS;

    @Column(name = "HoTen", columnDefinition = "varchar(255)")
    private String hoTen;

    @Column(name = "ChuyenKhoa", columnDefinition = "varchar(50)")
    private String chuyenKhoa;

    @Column(name = "SDT", columnDefinition = "varchar(10)", nullable = false)
    private String sdt;

    @OneToMany(mappedBy = "bacSi", fetch = FetchType.LAZY)
    private List<LichHenEntity> danhSachBS;

    public BacSiEntity() {
    }

    public Long getMaBS() {
        return maBS;
    }

    public void setMaBS(Long maBS) {
        this.maBS = maBS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public BacSiEntity(Long maBS, String hoTen, String chuyenKhoa, String sdt) {
        this.maBS = maBS;
        this.hoTen = hoTen;
        this.chuyenKhoa = chuyenKhoa;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "BacSiEntity{" +
                "maBS=" + maBS +
                ", hoTen='" + hoTen + '\'' +
                ", chuyenKhoa='" + chuyenKhoa + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
