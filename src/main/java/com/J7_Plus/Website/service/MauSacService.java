package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.MauSac;


import java.util.List;
import java.util.Optional;

public interface MauSacService {
    List<MauSac> getAll();
    void insert(MauSac mauSac);
    Optional<MauSac> detail(Integer id);
    void delete(Integer id);
}
