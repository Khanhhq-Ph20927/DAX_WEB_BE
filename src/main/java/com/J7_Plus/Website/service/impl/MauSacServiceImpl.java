package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.MauSac;
import com.J7_Plus.Website.repository.MauSacRepository;
import com.J7_Plus.Website.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public void insert(MauSac mauSac) {
     mauSacRepository.save(mauSac);
    }

    @Override
    public Optional<MauSac> detail(Integer id) {
        return mauSacRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        mauSacRepository.deleteById(id);
    }
}
