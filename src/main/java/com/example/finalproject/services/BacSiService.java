package com.example.finalproject.services;

import com.example.finalproject.entities.BacSiEntity;
import com.example.finalproject.repositories.BacSiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacSiService {
    @Autowired
    private BacSiRepository bacSiRepository;

    public List<BacSiEntity> getAllBacSi() {
        return bacSiRepository.findAll();
    }
}
