package com.J7_Plus.Website.repository;

import com.J7_Plus.Website.model.NhanVien;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Override
    Page<NhanVien> findAll(Pageable pageable);

    @Query("Select nv From NhanVien nv Where nv.MaNhanVien like :maNhanVien")
    NhanVien finByMa(@Param("maNhanVien") String maNhanVien);
    @Query("Select nv From NhanVien nv Where nv.Email like :email")
    NhanVien finByEmail(@Param("email") String email);
    @Query("Select nv From NhanVien nv Where nv.Sdt like :sdt")
    NhanVien finBysdt(@Param("sdt") String sdt);
    @Query("Select nv From NhanVien nv Where nv.cmnd like :cmnd")
    NhanVien finBycmnd(@Param("cmnd") String cmnd);
    @Query("Select nv From NhanVien nv Where nv.ChucVu.MaChucVu = :chucVu")
   List<NhanVien>findByChucVu(Integer chucVu);
    @Query("Select nv From NhanVien nv Where nv.TrangThai = :trangThai")
    List<NhanVien>findBytt(Integer trangThai);
    @Query("SELECT nv FROM NhanVien nv WHERE nv.MaNhanVien LIKE :keyword OR nv.Ten LIKE :keyword OR nv.Sdt like :keyword or nv.Email like :keyword")
    List<NhanVien> timKiem(@Param("keyword") String keyword);
   @Query("Select nv From NhanVien  nv WHERE nv.NgaySinh between :startDate and :endDate")
    List<NhanVien> findngaysinh(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
   @Modifying
    @Query(value = "Update NhanVien set TrangThai=1 where Id=?",nativeQuery = true)
    void deleteById(UUID id);
   @Query(value = "Select*from NhanVien n where n.TrangThai=0",nativeQuery = true)
    List<NhanVien>getAll();
}
