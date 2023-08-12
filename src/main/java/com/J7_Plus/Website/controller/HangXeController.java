package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.HangXe;
import com.J7_Plus.Website.service.HangXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/hang-xe")
public class HangXeController {
    @Autowired
    HangXeService hangXeService;

    @GetMapping("/index")
    public List<HangXe> index() {
        List<HangXe> list = hangXeService.getAll();
        return list;
    }

    @PostMapping("/create")
    public String create(@RequestBody HangXe hangXe) {
        hangXe.setNgayTao(LocalDate.now());
        hangXeService.insert(hangXe);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public HangXe update(@PathVariable("id") Integer id, @RequestBody HangXe hangXe) {
        HangXe cp = hangXeService.detail(id).get();
        cp.setTen(hangXe.getTen());
        cp.setQuocGia(hangXe.getQuocGia());
        cp.setNgayTao(hangXe.getNgayTao());
        cp.setNgaySua(LocalDate.now());
        hangXeService.insert(cp);
        return hangXeService.detail(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        hangXeService.delete(id);
        return "Deleted...";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<HangXe> getById(@PathVariable Integer id){
        Optional<HangXe> mauSac=hangXeService.detail(id);
        if(mauSac.isPresent()){
            return new ResponseEntity<>(mauSac.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
