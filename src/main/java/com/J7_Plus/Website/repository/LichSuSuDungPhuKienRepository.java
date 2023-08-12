package com.J7_Plus.Website.repository;


import com.J7_Plus.Website.model.LichSuSuDungPhuKien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LichSuSuDungPhuKienRepository extends JpaRepository<LichSuSuDungPhuKien, UUID> {
}
