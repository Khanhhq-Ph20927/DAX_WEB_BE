package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.LoaiDichVu;
import com.J7_Plus.Website.repository.LoaiDichVuRepository;
import com.J7_Plus.Website.service.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoaiDichVuServiceImpl implements LoaiDichVuService {
   @Autowired
   private LoaiDichVuRepository loaiDichVuRepository;
    @Override
    public List<LoaiDichVu> getAll() {
        return loaiDichVuRepository.findAll();
    }

    @Override
    public Page<LoaiDichVu> page(Pageable pageable) {
        return loaiDichVuRepository.findAll(pageable);
    }

    @Override
    public void save(LoaiDichVu loaiDichVu) {
        loaiDichVuRepository.save(loaiDichVu);
    }

    @Override
    public LoaiDichVu detail(Integer Id) {
        return loaiDichVuRepository.findById(Id).get();
    }

    @Override
    public void delete(Integer Id) {
        loaiDichVuRepository.deleteById(Id);
    }

    @Override
    public Page<LoaiDichVu> findAllTen(String ten, Pageable pageable) {
        return loaiDichVuRepository.findAllTen(ten,pageable);
    }

    @Override
    public Page<LoaiDichVu> Pagination(int offset, int pageSize) {
        return null;
    }
}
