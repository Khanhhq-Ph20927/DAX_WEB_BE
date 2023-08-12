package com.J7_Plus.Website.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="MauXe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MauXe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private UUID Id;
    @Column(name="Ten")
    private String Ten;
    @Column(name="NamSanXuat")
    private Integer NamSanXuat;
    @Column(name="HopSo")
    private String HopSo;
    @Column(name="DungTichXiLanh")
    private Float DungTichXiLanh;
    @Column(name="KichThuocTongThe")
    private Integer KichThuocTongThe;
    @Column(name="NgayTao")
    private LocalDate NgayTao;
    @Column(name="NgaySua")
    private LocalDate NgaySua;
    @ManyToOne
    @JoinColumn(name="IdHangXe")
    private HangXe HangXe;
    @ManyToOne
    @JoinColumn(name="IdMauSac")
    private MauSac MauSac;
}
