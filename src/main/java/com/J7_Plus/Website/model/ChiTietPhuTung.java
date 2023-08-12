package com.J7_Plus.Website.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="ChiTietPhuTung")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietPhuTung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private UUID Id;
    @Column(name="SoLuong")
    private Integer SoLuong;
    @ManyToOne
    @JoinColumn(name="IdPhuKien")
    private PhuKien PhuKien;
    @ManyToOne
    @JoinColumn(name="IdMauXe")
    private MauXe MauXe;
    @Column(name="NgayTao")
    private LocalDate NgayTao;
    @Column(name="NgaySua")
    private LocalDate NgaySua;
}
