package com.J7_Plus.Website.controller;

import com.J7_Plus.Website.model.MauSac;
import com.J7_Plus.Website.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/index")
    public List<MauSac> index() {
        List<MauSac> list = mauSacService.getAll();
        return list;
    }

    @PostMapping("/create")
    public String create(@RequestBody MauSac mauSac) {
        mauSac.setNgayTao(LocalDate.now());
        mauSacService.insert(mauSac);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public MauSac update(@PathVariable("id") Integer id, @RequestBody MauSac mauSac) {
        MauSac cp = mauSacService.detail(id).get();
        cp.setTen(mauSac.getTen());
        cp.setNgayTao(mauSac.getNgayTao());
        cp.setNgaySua(mauSac.getNgaySua());
        mauSacService.insert(cp);
        return mauSacService.detail(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        mauSacService.delete(id);
        return "Deleted...";
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<MauSac> getById(@PathVariable Integer id){
        Optional<MauSac> mauSac=mauSacService.detail(id);
        if(mauSac.isPresent()){
            return new ResponseEntity<>(mauSac.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
