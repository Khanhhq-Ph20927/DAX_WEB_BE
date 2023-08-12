package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.NhaCungCap;
import com.J7_Plus.Website.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@CrossOrigin("*")
@RestController
@RequestMapping("/nha-cung-cap")
public class NhaCungCapController {
    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping("/index")
    public List<NhaCungCap> index() {
        List<NhaCungCap> list = nhaCungCapService.getAll();
        return list;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody NhaCungCap nhaCungCap) {
        if(nhaCungCap.getTen()==null||nhaCungCap.getTen().isEmpty()){
          return ResponseEntity.badRequest().body("Tên Không được để trống");
        }
        if(nhaCungCap.getDiaChi()==null||nhaCungCap.getDiaChi().isEmpty()){
           return ResponseEntity.badRequest().body("Địa Chỉ không được để trống");
        }
        if(nhaCungCap.getThanhPho()==null||nhaCungCap.getThanhPho().isEmpty()){
           return ResponseEntity.badRequest().body("Thành Phố Không được để trống");
        }
        if(nhaCungCap.getQuocGia()==null||nhaCungCap.getQuocGia().isEmpty()){
           return ResponseEntity.badRequest().body("Quốc Gia không được để trống");
        }
        nhaCungCap.setNgayTao(LocalDate.now());
        nhaCungCapService.insert(nhaCungCap);
        return ResponseEntity.ok("Nhà Cung Cấp đã được tạo thành công.");
    }

    @PutMapping("/update/{id}")
    public NhaCungCap update(@PathVariable("id") Integer id, @RequestBody NhaCungCap nhaCungCap) {
        NhaCungCap cp = nhaCungCapService.detail(id).get();
        cp.setTen(nhaCungCap.getTen());
        cp.setDiaChi(nhaCungCap.getDiaChi());
        cp.setQuocGia(nhaCungCap.getQuocGia());
        cp.setThanhPho(nhaCungCap.getThanhPho());
        cp.setNgayTao(nhaCungCap.getNgayTao());
        cp.setNgaySua(LocalDate.now());
        nhaCungCapService.insert(cp);
        return nhaCungCapService.detail(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        nhaCungCapService.delete(id);
        return "Deleted...";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<NhaCungCap> getById(@PathVariable Integer id){
        Optional<NhaCungCap> nhaCungCap=nhaCungCapService.detail(id);
        if(nhaCungCap.isPresent()){
            return new ResponseEntity<>(nhaCungCap.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
