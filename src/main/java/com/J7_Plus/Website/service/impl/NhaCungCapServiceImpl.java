package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.NhaCungCap;
import com.J7_Plus.Website.repository.NhaCungCapRepository;
import com.J7_Plus.Website.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
    @Autowired
    NhaCungCapRepository nhaCungCapRepository;

    @Override
    public List<NhaCungCap> getAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public void insert(NhaCungCap nhaCungCap) {
nhaCungCapRepository.save(nhaCungCap);
    }

    @Override
    public Optional<NhaCungCap> detail(Integer id) {
        return nhaCungCapRepository.findById(id);
    }

    @Override
    public void delete(Integer Id) {
     nhaCungCapRepository.deleteById(Id);
    }
}
