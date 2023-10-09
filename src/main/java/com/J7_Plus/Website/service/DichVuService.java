package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DichVuService {
    List<DichVu> getAll();

    Page<DichVu> page(Pageable pageable);

    void save(DichVu dichVu);

    DichVu update(UUID Id, DichVu dichVu);

    DichVu detail(UUID Id);

    void delete(UUID Id);

    Page<DichVu> findAllTen(String ten, Pageable pageable);

    ;

    Page<DichVu> findAllLoaiDV(Integer id, Pageable pageable);

    Page<DichVu> findAllSort(String field, Pageable pageable);

    Page<DichVu> Pagination(int offset, int pageSize);
}
