package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.ChucVu;
import com.J7_Plus.Website.repository.ChucVuRepository;
import com.J7_Plus.Website.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChucVuServiceImpl implements ChucVuService {
@Autowired
ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public void insert(ChucVu chucVu) {
chucVuRepository.save(chucVu);
    }

    @Override
    public Optional<ChucVu> getById(Integer maChucVu) {
        return chucVuRepository.findById(maChucVu);
    }

    @Override
    public void delete(Integer maChucVu) {
chucVuRepository.deleteById(maChucVu);
    }
}
