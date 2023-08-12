package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.ChiTietPhuTung;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietPhuTungService {
    List<ChiTietPhuTung> getAll();
    void insert(ChiTietPhuTung chiTietPhuTung);
    Optional<ChiTietPhuTung> detail(UUID id);
    void delete(UUID id);
}
