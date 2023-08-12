package com.J7_Plus.Website.service;

import com.J7_Plus.Website.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();
    void insert(NhanVien nhanVien);
    Optional<NhanVien> detail(UUID Id);
    void delete(UUID Id);
    Page<NhanVien> phanTrang(Pageable nv);

    NhanVien finbyma(String maNhanVien);
    NhanVien findbyemail(String email);
    NhanVien findbysdt(String sdt);
    NhanVien findbycmnd(String cmnd);
    List<NhanVien>findbychucvu(Integer chucVu);
    List<NhanVien>findbytt(Integer trangThai);
   List<NhanVien>timkiemnv(String keyword);
   List<NhanVien>khoangns(Date startDate,Date endDate);
}
