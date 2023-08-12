package com.J7_Plus.Website.model;

import javax.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="PhuKien")
public class PhuKien {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name="MaPhuKien")
    private String MaPhuKien;
    @Column(name="TenPhuKien")
    private String TenPhuKien;
    @Column(name="Gia")
    private Double Gia;
    @Column(name="SoLuongTon")
    private Integer SoLuongTon;
    @Column(name="NgayTao")
    private LocalDate NgayTao;
    @Column(name="NgaySua")
    private LocalDate NgaySua;
    @ManyToOne
    @JoinColumn(name="IdNhaCungCap")
    private NhaCungCap NhaCungCap;
    @Column(name="TrangThai")
    private Integer TrangThai;
    @Column(name="image")
    private String image;
}
