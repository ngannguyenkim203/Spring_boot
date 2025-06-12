package com.example.finalproject.controllers;

import com.example.finalproject.entities.BacSiEntity;
import com.example.finalproject.entities.BenhNhanEntity;
import com.example.finalproject.entities.KhoaEntity;
import com.example.finalproject.services.BacSiService;
import com.example.finalproject.services.BenhNhanService;
import com.example.finalproject.services.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BenhNhanController {
    @Autowired
    private BenhNhanService benhNhanService;
    @Autowired
    private BacSiService bacSiService;
    @Autowired
    private KhoaService khoaService;

    @GetMapping("/addLichHen")
    public String getListBenhNhan(Model model) {
        List<BenhNhanEntity> benhNhanEntityList = benhNhanService.getAllBenhNhan();
        List<BacSiEntity> bacSiEntityList = bacSiService.getAllBacSi();
        List<KhoaEntity> khoaEntityList = khoaService.getAllKhoa();
        model.addAttribute("benhnhans", benhNhanEntityList);
        model.addAttribute("bacsis", bacSiEntityList);
        model.addAttribute("khoas", khoaEntityList);
        return "addLichHen";
    }

//    @GetMapping("/listLichHen")
//    public String getListBNandBSandNgayHen(Model model) {
//        List<BenhNhanEntity> benhNhanEntityList = benhNhanService.getAllBenhNhan();
//        List<BacSiEntity> bacSiEntityList = bacSiService.getAllBacSi();
//        List<KhoaEntity> khoaEntityList = khoaService.getAllKhoa();
//        model.addAttribute("benhnhans", benhNhanEntityList);
//        model.addAttribute("bacsis", bacSiEntityList);
//        model.addAttribute("khoas", khoaEntityList);
//        return "listLichHen";
//    }
}
