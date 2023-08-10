package com.J7_Plus.Website.repository;

import com.J7_Plus.Website.model.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, UUID> {
    @Override
    Page<DichVu> findAll(Pageable pageable);

    @Query("select dv from DichVu dv where dv.ten like %?1%")
    Page<DichVu> findAllTen(String ten, Pageable pageable);


    @Query("select dv from DichVu dv ,LoaiDichVu ldv where dv.loaiDV.id =ldv.id and ldv.id = ?1")
    Page<DichVu> findAllLoaiDV(Integer id, Pageable pageable);

}
