package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.MauXe;
import com.J7_Plus.Website.repository.MauXeRepository;
import com.J7_Plus.Website.service.MauXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauXeServiceImpl implements MauXeService {
   @Autowired
   MauXeRepository mauXeRepository;
    @Override
    public List<MauXe> getAll() {
        return mauXeRepository.findAll();
    }

    @Override
    public void insert(MauXe mauXe) {
   mauXeRepository.save(mauXe);
    }

    @Override
    public Optional<MauXe> detail(UUID id) {
        return mauXeRepository.findById(id);
    }

    @Override
    public void delete(UUID Id) {
   mauXeRepository.deleteById(Id);
    }
}
