package com.J7_Plus.Website.service;



import com.J7_Plus.Website.model.HangXe;

import java.util.List;
import java.util.Optional;

public interface HangXeService {
    List<HangXe> getAll();
    void insert(HangXe hangXe);
    Optional<HangXe> detail(Integer id);
    void delete(Integer id);
}
