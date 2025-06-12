package com.example.finalproject.services;

import com.example.finalproject.entities.BacSiEntity;
import com.example.finalproject.entities.BenhNhanEntity;
import com.example.finalproject.entities.KhoaEntity;
import com.example.finalproject.entities.LichHenEntity;
import com.example.finalproject.repositories.BacSiRepository;
import com.example.finalproject.repositories.BenhNhanRepository;
import com.example.finalproject.repositories.KhoaRepository;
import com.example.finalproject.repositories.LichHenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LichHenService {
    @Autowired
    private LichHenRepository lichHenRepository;

    @Autowired
    private BenhNhanRepository benhNhanRepository;
    @Autowired
    private BacSiRepository bacSiRepository;
    @Autowired
    private KhoaRepository khoaRepository;

    public List<LichHenEntity> getAllLichHen() {

        return lichHenRepository.findAll();
    }

    public LichHenEntity save(LichHenEntity lichHenEntity) {
        BenhNhanEntity benhNhan = benhNhanRepository.findById(lichHenEntity.getBenhNhan().getMaBN()).orElse(null);
        BacSiEntity bacSi = bacSiRepository.findById(lichHenEntity.getBacSi().getMaBS()).orElse(null);
        KhoaEntity khoa = khoaRepository.findById(lichHenEntity.getKhoa().getMaKhoa()).orElse(null);

        LichHenEntity lichHen = new LichHenEntity();
        lichHen.setBenhNhan(benhNhan);
        lichHen.setBacSi(bacSi);
        lichHen.setKhoa(khoa);
        lichHen.setNgayHen(lichHenEntity.getNgayHen());
        lichHen.setGioHen(lichHenEntity.getGioHen());
        lichHen.setTrieuChung(lichHenEntity.getTrieuChung());
        return lichHenRepository.save(lichHenEntity);
    }

    public boolean existsByBacSiAndNgayHenAndGioHen (Long maBS, String ngayHen, String gioHen){
        return lichHenRepository.existsByBacSi_MaBSAndNgayHenAndGioHen(maBS, ngayHen, gioHen);
    }

    public Page<LichHenEntity> getLichHenPage(Pageable pageable) {
        return lichHenRepository.findAll(pageable);
    }

    public void deleteLichHenById(Long id) {
        lichHenRepository.deleteById(id);
    }
}
