package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.ChiTietPhuTung;
import com.J7_Plus.Website.service.ChiTietPhuTungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@CrossOrigin("*")
@RestController
@RequestMapping("/chitiet-phutung")
public class ChiTietPhuKienController {
    @Autowired
    private ChiTietPhuTungService chiTietPhuTungService;

    @GetMapping("/index")
    public List<ChiTietPhuTung> index() {
        List<ChiTietPhuTung> list = chiTietPhuTungService.getAll();
        return list;
    }

    @PostMapping("/create")
    public String create(@RequestBody ChiTietPhuTung chiTietPhuTung) {
        chiTietPhuTung.setNgayTao(LocalDate.now());
        chiTietPhuTungService.insert(chiTietPhuTung);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public ChiTietPhuTung update(@PathVariable("id") UUID id, @RequestBody ChiTietPhuTung chiTietPhuTung) {
        ChiTietPhuTung cp = chiTietPhuTungService.detail(id).get();
        cp.setSoLuong(chiTietPhuTung.getSoLuong());
        cp.setNgayTao(chiTietPhuTung.getNgayTao());
        cp.setPhuKien(chiTietPhuTung.getPhuKien());
        cp.setMauXe(chiTietPhuTung.getMauXe());
        cp.setNgaySua(LocalDate.now());
        chiTietPhuTungService.insert(cp);
        return chiTietPhuTungService.detail(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        chiTietPhuTungService.delete(id);
        return "Deleted...";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ChiTietPhuTung> getById(@PathVariable UUID id){
        Optional<ChiTietPhuTung> ct=chiTietPhuTungService.detail(id);
        if(ct.isPresent()){
            return new ResponseEntity<>(ct.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
