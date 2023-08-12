package com.J7_Plus.Website.repository;

import com.J7_Plus.Website.model.NhaCungCap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap,Integer> {
}
