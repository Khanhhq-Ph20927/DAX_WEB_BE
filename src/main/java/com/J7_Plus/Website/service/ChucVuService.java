package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.ChucVu;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();
    void insert(ChucVu chucVu);
    Optional<ChucVu> getById(Integer maChucVu);
    void delete(Integer maChucVu);
}
