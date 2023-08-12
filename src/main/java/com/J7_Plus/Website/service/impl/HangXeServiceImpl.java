package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.HangXe;
import com.J7_Plus.Website.repository.HangXeRepository;
import com.J7_Plus.Website.service.HangXeService;

import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HangXeServiceImpl implements HangXeService {
    @Autowired
    HangXeRepository hangXeRepository;
    @Override
    public List<HangXe> getAll() {
        return hangXeRepository.findAll();
    }

    @Override
    public void insert(HangXe hangXe) {
     hangXeRepository.save(hangXe);
    }

    @Override
    public Optional<HangXe> detail(Integer id) {
        return hangXeRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
    hangXeRepository.deleteById(id);
    }
}
