package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.ChucVu;
import com.J7_Plus.Website.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin("*")
@RestController
@RequestMapping("chuc-vu")
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;
    @GetMapping("/index")
    public List<ChucVu> index(Model model){
        List<ChucVu> list=chucVuService.getAll();
        return list;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ChucVu chucVu){
        if(chucVu.getTenChucVu()==null||chucVu.getTenChucVu().isEmpty()){
           return ResponseEntity.badRequest().body("Tên Không được để trống");
        }
        chucVu.setNgayTao(LocalDate.now());
        chucVuService.insert(chucVu);
        return ResponseEntity.ok("Chức vụ đã được tạo thành công.");
    }
    @PutMapping("/update/{maChucVu}")
    public ChucVu update(@PathVariable("maChucVu") Integer maChucVu, @RequestBody ChucVu chucVu) {
        ChucVu cp = chucVuService.getById(maChucVu).get();
        cp.setTenChucVu(chucVu.getTenChucVu());
        cp.setNgayTao(chucVu.getNgayTao());
        cp.setNgaySua(LocalDate.now());
        chucVuService.insert(cp);
        return chucVuService.getById(maChucVu).get();
    }
    @DeleteMapping("/delete/{maChucVu}")
    public String delete(@PathVariable Integer maChucVu){
        chucVuService.delete(maChucVu);
        return "redirect:/chuc-vu/index";
    }
    @GetMapping("/getById/{maChucVu}")
    public ResponseEntity<ChucVu> getById(@PathVariable Integer maChucVu){
        Optional<ChucVu> chucVu=chucVuService.getById(maChucVu);
        if(chucVu.isPresent()){
            return new ResponseEntity<>(chucVu.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
