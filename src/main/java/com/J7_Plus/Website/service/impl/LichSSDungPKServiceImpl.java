package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.LichSuSuDungPhuKien;
import com.J7_Plus.Website.repository.LichSuSuDungPhuKienRepository;
import com.J7_Plus.Website.service.LichSSDungPKService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LichSSDungPKServiceImpl implements LichSSDungPKService {
@Autowired
LichSuSuDungPhuKienRepository lichSuSuDungPhuKienRepository;

    @Override
    public List<LichSuSuDungPhuKien> getAll() {
        return lichSuSuDungPhuKienRepository.findAll();
    }

    @Override
    public void insert(LichSuSuDungPhuKien lichSuSuDungPhuKien) {
     lichSuSuDungPhuKienRepository.save(lichSuSuDungPhuKien);
    }

    @Override
    public Optional<LichSuSuDungPhuKien> detail(UUID Id) {
        return lichSuSuDungPhuKienRepository.findById(Id);
    }

    @Override
    public void delete(UUID Id) {
   lichSuSuDungPhuKienRepository.deleteById(Id);
    }
}
