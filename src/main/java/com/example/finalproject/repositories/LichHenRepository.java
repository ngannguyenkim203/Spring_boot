package com.example.finalproject.repositories;

import com.example.finalproject.entities.LichHenEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LichHenRepository extends JpaRepository<LichHenEntity, Long> {
    boolean existsByBacSi_MaBSAndNgayHenAndGioHen(Long maBS, String ngayHen, String gioHen);
    Page<LichHenEntity> findAll(Pageable pageable);
}
