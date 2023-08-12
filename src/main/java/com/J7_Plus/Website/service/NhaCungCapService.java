package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.NhaCungCap;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhaCungCapService {
    List<NhaCungCap> getAll();
    void insert(NhaCungCap nhaCungCap);
    Optional<NhaCungCap> detail(Integer id);
    void delete(Integer Id);
}
