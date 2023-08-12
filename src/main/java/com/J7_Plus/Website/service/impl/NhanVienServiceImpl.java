package com.J7_Plus.Website.service.impl;

import com.J7_Plus.Website.model.NhanVien;
import com.J7_Plus.Website.repository.NhanVienRepository;
import com.J7_Plus.Website.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
@Autowired
NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public void insert(NhanVien nhanVien) {
    nhanVienRepository.save(nhanVien);
    }

    @Override
    public Optional<NhanVien> detail(UUID Id) {
        return nhanVienRepository.findById(Id);
    }

    @Override
    public void delete(UUID Id) {
        nhanVienRepository.deleteById(Id);
    }

    @Override
    public Page<NhanVien> phanTrang(Pageable nv) {
        return nhanVienRepository.findAll(nv);
    }

    @Override
    public NhanVien finbyma(String maNhanVien) {
        return nhanVienRepository.finByMa(maNhanVien);
    }


    @Override
    public NhanVien findbyemail(String email) {
        return nhanVienRepository.finByEmail(email);
    }

    @Override
    public NhanVien findbysdt(String sdt) {
        return nhanVienRepository.finBysdt(sdt);
    }

    @Override
    public NhanVien findbycmnd(String cmnd) {
        return nhanVienRepository.finBycmnd(cmnd);
    }

    @Override
    public List<NhanVien> findbychucvu(Integer chucVu) {
        List<NhanVien>list=nhanVienRepository.findByChucVu(chucVu);
        return list;
    }

    @Override
    public List<NhanVien> findbytt(Integer trangThai) {
       List<NhanVien>list=nhanVienRepository.findBytt(trangThai);
        return list;
    }

    @Override
    public List<NhanVien> timkiemnv(String keyword) {
        return nhanVienRepository.timKiem(keyword);
    }

    @Override
    public List<NhanVien> khoangns(Date startDate, Date endDate) {
        return nhanVienRepository.findngaysinh(startDate,endDate);
    }


}
