package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.LichSuSuDungPhuKien;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LichSSDungPKService {
    List<LichSuSuDungPhuKien>getAll();
    void insert(LichSuSuDungPhuKien lichSuSuDungPhuKien);
    Optional<LichSuSuDungPhuKien> detail(UUID Id);
    void delete(UUID Id);
}
