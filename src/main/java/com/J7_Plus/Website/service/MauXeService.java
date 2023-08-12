package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.MauXe;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MauXeService {
    List<MauXe> getAll();
    void insert(MauXe mauXe);
    Optional<MauXe> detail(UUID id);
    void delete(UUID Id);
}
