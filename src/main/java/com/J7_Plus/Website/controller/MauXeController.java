package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.MauXe;
import com.J7_Plus.Website.service.MauXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/mau-xe")
public class MauXeController {
    @Autowired
    private MauXeService mauXeService;

    @GetMapping("/index")
    public List<MauXe> index() {
        List<MauXe> list = mauXeService.getAll();
        return list;
    }

    @PostMapping("/create")
    public String create(@RequestBody MauXe mauXe) {
        mauXe.setNgayTao(LocalDate.now());
        mauXeService.insert(mauXe);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public MauXe update(@PathVariable("id") UUID id, @RequestBody MauXe mauXe) {
        MauXe cp = mauXeService.detail(id).get();
        cp.setTen(mauXe.getTen());
        cp.setHopSo(mauXe.getHopSo());
        cp.setHangXe(mauXe.getHangXe());
        cp.setDungTichXiLanh(mauXe.getDungTichXiLanh());
        cp.setNamSanXuat(mauXe.getNamSanXuat());
        cp.setKichThuocTongThe(mauXe.getKichThuocTongThe());
        cp.setMauSac(mauXe.getMauSac());
        cp.setNgayTao(mauXe.getNgayTao());
        cp.setNgaySua(LocalDate.now());
        mauXeService.insert(cp);
        return mauXeService.detail(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        mauXeService.delete(id);
        return "Deleted...";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<MauXe> getById(@PathVariable UUID id){
        Optional<MauXe> nhaCungCap=mauXeService.detail(id);
        if(nhaCungCap.isPresent()){
            return new ResponseEntity<>(nhaCungCap.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
