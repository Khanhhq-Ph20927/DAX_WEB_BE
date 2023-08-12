package com.J7_Plus.Website.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="NhaCungCap")
@Getter
@Setter
public class NhaCungCap {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name="Ten")
    private String Ten;
    @Column(name="ThanhPho")
    private String ThanhPho;
    @Column(name="QuocGia")
    private String QuocGia;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="NgayTao")
    private LocalDate NgayTao;
    @Column(name="NgaySua")
    private LocalDate NgaySua;
}
