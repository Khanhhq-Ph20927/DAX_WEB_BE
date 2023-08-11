package com.J7_Plus.Website.controller;


import com.J7_Plus.Website.model.DichVu;
import com.J7_Plus.Website.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Admin/dichvu")
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;
    @GetMapping("/index")
    public List<DichVu> Show() {
        return dichVuService.getAll();
    }
    @GetMapping("/index/page/{number}")
    public Page<DichVu> Page(@PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5);
        return dichVuService.page(pageable);
    }

    @GetMapping("/index/pagination/{offset}/{pageSize}")
    public Page<DichVu> Pagination(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize) {
        return dichVuService.Pagination(offset,pageSize);
    }
    @GetMapping("/index/search_ten/{ten}/{number}")
    public Page<DichVu> searchTen(@PathVariable("ten")String ten,@PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5
//                , Sort.by("ngayTao").descending()
        );
        return dichVuService.findAllTen(ten,pageable);
    }

    @GetMapping("/index/search_loai/{loaiDV}/{number}")
    public Page<DichVu> searchLDV(@PathVariable("loaiDV")int loaiDV,@PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5);
        return dichVuService.findAllLoaiDV(loaiDV,pageable);
    }
    @GetMapping("/index/search/{ten}/{loaiDV}/{number}")
    public Page<DichVu> search(@PathVariable("ten")String ten,@PathVariable("loaiDV")int loaiDV,@PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5);
        return dichVuService.page(pageable);
    }

    @GetMapping("/index/sort/{field}/{number}")
    public Page<DichVu> Sort(@PathVariable("field") String field,@PathVariable("number") int number) {
        Pageable pageable = PageRequest.of(number, 5).withSort(Sort.by(Sort.Direction.DESC,field));
        return dichVuService.findAllSort(field,pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<String> Add(@RequestBody DichVu dichVu) {
        if (dichVu.getTen()==null||dichVu.getTen().isEmpty()){
            return  ResponseEntity.badRequest().body("Tên trống");
        }else if(dichVu.getTen().length()>50){
            return  ResponseEntity.badRequest().body("Tên quá ký tự cho phép");
        }else{
            dichVu.setNgayTao(LocalDateTime.now());
            dichVuService.save(dichVu);
            return ResponseEntity.ok("Add thành công");
        }

    }

    @GetMapping("/detail/{id}")
    public DichVu detail(@PathVariable(value = "id") UUID id) {
        return dichVuService.detail(id);
    }

    @PutMapping("/update/{id}")
    public DichVu update(@PathVariable(value = "id") UUID id, @RequestBody DichVu dichVu) {
        DichVu dv = dichVuService.detail(id);
        dv.setTen(dichVu.getTen());
        dv.setDonGia(dichVu.getDonGia());
        dv.setLoaiDV(dichVu.getLoaiDV());
        dv.setNgaySua(LocalDateTime.now());
        dichVuService.save(dv);
        return dichVuService.detail(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        dichVuService.delete(id);
        return "Deleted...";
    }
}
