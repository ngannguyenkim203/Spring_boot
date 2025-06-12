package com.example.finalproject.services;

import com.example.finalproject.entities.BacSiEntity;
import com.example.finalproject.entities.KhoaEntity;
import com.example.finalproject.repositories.BacSiRepository;
import com.example.finalproject.repositories.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;

    public List<KhoaEntity> getAllKhoa() {
        return khoaRepository.findAll();
    }
}
