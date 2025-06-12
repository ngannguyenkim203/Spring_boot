package com.example.finalproject.controllers;

import com.example.finalproject.entities.BacSiEntity;
import com.example.finalproject.services.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BacSiController {
    @Autowired
    private BacSiService bacSiService;

//    @GetMapping("/addLichHen")
//    public String getListBacSi(Model model) {
//        List<BacSiEntity> bacSiEntityList = bacSiService.getAllBacSi();
//        model.addAttribute("bacsis", bacSiEntityList);
//        return "addLichHen";
//    }
}
