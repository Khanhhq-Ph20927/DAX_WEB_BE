package com.J7_Plus.Website.controller;

import com.dax.j7_plus.demo.model.LoaiDichVu;
import com.dax.j7_plus.demo.service.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Admin/loaidichvu")
public class LoaiDichVuController {
    @Autowired
    private LoaiDichVuService loaiDichVuService;

    @GetMapping("/index")
    public List<LoaiDichVu> Show() {
        List<LoaiDichVu> list = loaiDichVuService.getAll();
        return list;
    }
    @GetMapping("/index/search_ten/{ten}/{number}")
    public Page<LoaiDichVu> searchTen(@PathVariable("ten")String ten, @PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5
//                , Sort.by("ngayTao").descending()
        );
        return loaiDichVuService.findAllTen(ten,pageable);
    }

    @GetMapping("/index/page/{number}")
    public Page<LoaiDichVu> Page(@PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5
//                , Sort.by("ngayTao").descending()
        );
        Page<LoaiDichVu> page = loaiDichVuService.page(pageable);
        return page;
    }

    @PostMapping("/add")
    public String add(@RequestBody LoaiDichVu loaiDichVu) {
        loaiDichVu.setNgayTao(LocalDateTime.now());
        loaiDichVuService.save(loaiDichVu);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public LoaiDichVu update(@PathVariable Integer id, @RequestBody LoaiDichVu loaiDichVu) {
        LoaiDichVu ldv = loaiDichVuService.detail(id);
        ldv.setNgaySua(LocalDateTime.now());
        ldv.setTen(loaiDichVu.getTen());
        loaiDichVuService.save(ldv);
        return loaiDichVuService.detail(id);
    }

    @GetMapping("/detail/{id}")
    public LoaiDichVu detail(@PathVariable Integer id) {
        return loaiDichVuService.detail(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        loaiDichVuService.delete(id);
        return "Deleted...";
    }
}
