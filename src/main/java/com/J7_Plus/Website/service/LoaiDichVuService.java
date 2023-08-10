package com.J7_Plus.Website.service;

import com.dax.j7_plus.demo.model.LoaiDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoaiDichVuService {
    List<LoaiDichVu> getAll();

    Page<LoaiDichVu> page(Pageable pageable);

    void save(LoaiDichVu loaiDichVu);

    LoaiDichVu detail(Integer Id);

    void delete(Integer Id);

    Page<LoaiDichVu> findAllTen(String ten, Pageable pageable);
//
//    Page<LoaiDichVu> findAllSort(String field);

    Page<LoaiDichVu> Pagination(int offset,int pageSize);
}
