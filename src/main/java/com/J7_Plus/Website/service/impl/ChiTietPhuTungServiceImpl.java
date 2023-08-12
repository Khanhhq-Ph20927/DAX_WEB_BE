package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.ChiTietPhuTung;
import com.J7_Plus.Website.repository.ChiTietPhuTungRepository;
import com.J7_Plus.Website.service.ChiTietPhuTungService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietPhuTungServiceImpl implements ChiTietPhuTungService {
    @Autowired
    ChiTietPhuTungRepository chiTietPhuTungRepository;


    @Override
    public List<ChiTietPhuTung> getAll() {
        return chiTietPhuTungRepository.findAll();
    }

    @Override
    public void insert(ChiTietPhuTung chiTietPhuTung) {
       chiTietPhuTungRepository.save(chiTietPhuTung);
    }

    @Override
    public Optional<ChiTietPhuTung> detail(UUID id) {
        return chiTietPhuTungRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
     chiTietPhuTungRepository.deleteById(id);
    }
}
