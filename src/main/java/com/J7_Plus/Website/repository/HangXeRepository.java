package com.J7_Plus.Website.repository;

import com.J7_Plus.Website.model.HangXe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangXeRepository extends JpaRepository<HangXe,Integer> {
}
