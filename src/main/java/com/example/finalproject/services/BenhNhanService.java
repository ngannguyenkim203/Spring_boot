package com.example.finalproject.services;

import com.example.finalproject.entities.BacSiEntity;
import com.example.finalproject.entities.BenhNhanEntity;
import com.example.finalproject.repositories.BacSiRepository;
import com.example.finalproject.repositories.BenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhNhanService {
    @Autowired
    private BenhNhanRepository benhNhanRepository;
//    private BacSiRepository bacSiRepository;

    public List<BenhNhanEntity> getAllBenhNhan() {
        return benhNhanRepository.findAll();
    }

//    public List<BacSiEntity> getAllBacSi() {
//        return bacSiRepository.findAll();
//    }
}
