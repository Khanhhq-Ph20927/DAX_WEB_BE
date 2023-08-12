package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.LichSuSuDungPhuKien;
import com.J7_Plus.Website.service.LichSSDungPKService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/lich-su-phu-kien")
public class LichSuSuDungPhuKienController {
    @Autowired
    LichSSDungPKService lichSSDungPKService;
    @GetMapping("/index")
    public List<LichSuSuDungPhuKien> index(){
        List<LichSuSuDungPhuKien>list=lichSSDungPKService.getAll();
        return list;
    }
    @PostMapping("/insert")
    public String insert(@RequestBody LichSuSuDungPhuKien lichSuSuDungPhuKien){
        lichSSDungPKService.insert(lichSuSuDungPhuKien);
        return "redirect:/lich-su-phu-kien/index";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<LichSuSuDungPhuKien> getById(@PathVariable("id")UUID id){
        Optional<LichSuSuDungPhuKien> lichSuSuDungPhuKien=lichSSDungPKService.detail(id);
        if(lichSuSuDungPhuKien.isPresent()){
            return new ResponseEntity<>(lichSuSuDungPhuKien.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public LichSuSuDungPhuKien update(@PathVariable("id") UUID id, @RequestBody LichSuSuDungPhuKien lichSuSuDungPhuKien){
        LichSuSuDungPhuKien ls=lichSSDungPKService.detail(id).get();
        ls.setSoPhuKien(lichSuSuDungPhuKien.getSoPhuKien());
        ls.setPhuKien(lichSuSuDungPhuKien.getPhuKien());
        ls.setNgayTao(lichSuSuDungPhuKien.getNgayTao());
        ls.setNgaySua(lichSuSuDungPhuKien.getNgaySua());
        lichSSDungPKService.insert(ls);
        return lichSSDungPKService.detail(id).get();
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        lichSSDungPKService.delete(id);
        return "redirect:/lich-su-phu-kien/index";
    }
}
