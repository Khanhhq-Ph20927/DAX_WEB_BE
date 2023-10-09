package com.J7_Plus.Website.service.impl;


import com.J7_Plus.Website.model.DichVu;
import com.J7_Plus.Website.repository.DichVuRepository;
import com.J7_Plus.Website.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    private DichVuRepository dichVuRepository;
    @Override
    public List<DichVu> getAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public Page<DichVu> page(Pageable pageable) {
        return dichVuRepository.findAll(pageable);
    }

    @Override
    public void save(DichVu dichVu) {
        dichVu.setNgayTao(LocalDateTime.now());
        dichVuRepository.save(dichVu);
    }

    @Override
    public DichVu update(UUID Id, DichVu dichVu) {
        DichVu dv = dichVuRepository.findById(Id).get();
        dv.setTen(dichVu.getTen());
        dv.setDonGia(dichVu.getDonGia());
        dv.setLoaiDV(dichVu.getLoaiDV());
        dv.setNgaySua(LocalDateTime.now());
        return dichVuRepository.save(dv);
    }

    @Override
    public DichVu detail(UUID Id) {
        return dichVuRepository.findById(Id).get();
    }

    @Override
    public void delete(UUID Id) {
        dichVuRepository.deleteById(Id);
    }

    @Override
    public Page<DichVu> findAllTen(String ten, Pageable pageable) {
        return dichVuRepository.findAllTen(ten,pageable);
    }

    @Override
    public Page<DichVu> findAllLoaiDV(Integer id, Pageable pageable) {
        return dichVuRepository.findAllLoaiDV(id, pageable);
    }

    @Override
    public Page<DichVu> findAllSort(String field, Pageable pageable) {
        return dichVuRepository.findAll(pageable);
    }


    @Override
    public Page<DichVu> Pagination(int offset, int pageSize) {
        return dichVuRepository.findAll(PageRequest.of(offset,pageSize));
    }

}
