package com.J7_Plus.Website.repository;

import com.J7_Plus.Website.model.LoaiDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu, Integer> {
    @Override
    Page<LoaiDichVu> findAll(Pageable pageable);

    @Query("select ldv from LoaiDichVu ldv where ldv.ten like %?1%")
    Page<LoaiDichVu> findAllTen(String ten, Pageable pageable);
}
