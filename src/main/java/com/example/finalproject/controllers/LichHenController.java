package com.example.finalproject.controllers;

import com.example.finalproject.entities.*;
import com.example.finalproject.repositories.BacSiRepository;
import com.example.finalproject.repositories.BenhNhanRepository;
import com.example.finalproject.repositories.KhoaRepository;
import com.example.finalproject.services.BacSiService;
import com.example.finalproject.services.BenhNhanService;
import com.example.finalproject.services.KhoaService;
import com.example.finalproject.services.LichHenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@Controller
public class LichHenController {
    @Autowired
    private LichHenService lichHenService;
    @Autowired
    private BenhNhanService benhNhanService;
    @Autowired
    private BacSiService bacSiService;

    @GetMapping("/listLichHen")
    public String getListLichHen(@RequestParam(defaultValue = "0") int page, Model model) {
        List<BenhNhanEntity> benhNhanEntityList = benhNhanService.getAllBenhNhan();
        List<BacSiEntity> bacSiEntityList = bacSiService.getAllBacSi();
        model.addAttribute("benhnhans", benhNhanEntityList);
        model.addAttribute("bacsis", bacSiEntityList);

        // Gọi phân trang lịch hẹn
        Page<LichHenEntity> lichHenPage = lichHenService.getLichHenPage(PageRequest.of(page, 5)); // mỗi trang 10 lịch hẹn

        //Gửi dữ liệu lên view không có phân trang
//        List<LichHenEntity> lichHenEntityList = lichHenService.getAllLichHen();
//        System.out.println(">>> Số lịch hẹn: " + lichHenEntityList.size());
//        model.addAttribute("dsLichHen", lichHenEntityList);

        // Gửi dữ liệu đã phân trang
        model.addAttribute("dsLichHen", lichHenPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", lichHenPage.getTotalPages());

        return "listLichHen";
    }

    @PostMapping("/saveLichHen")
    public String saveLichHen (@ModelAttribute("lichHenEntity") LichHenEntity lichHenEntity,
                               Model model
                               ) {
        //Kiểm tra ngày hẹn không phải là ngày quá khứ
        try {
            LocalDate ngayHen = LocalDate.parse(lichHenEntity.getNgayHen(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (ngayHen.isBefore(LocalDate.now())) {
                model.addAttribute("error", "Ngày hẹn không được là ngày trong quá khứ");
                return "addLichHen";
            }
        } catch (DateTimeParseException e) {
//            return "Định dạng ngày hẹn không hợp lệ (đúng định dạng yyyy-MM-dd).";
        }

        //Kiểm tra trùng lịch (nếu cần)
        boolean trung = lichHenService.existsByBacSiAndNgayHenAndGioHen(
                lichHenEntity.getBacSi().getMaBS(),
                lichHenEntity.getNgayHen(),
                lichHenEntity.getGioHen()
        );
        if (trung) {
            model.addAttribute("error", "Bác sĩ đã có lịch hẹn vào thời gian này");
            return "addLichHen";
        }
        lichHenService.save(lichHenEntity);
        return "redirect: /listLichHen";
    }

//    @DeleteMapping("")
//    public String deleteLichHen(@RequestParam(defaultValue = "0") int id) {
//        return
//    }
}
