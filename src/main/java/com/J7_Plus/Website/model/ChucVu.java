package com.J7_Plus.Website.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="ChucVu")
public class ChucVu {
    @Id
    @Column(name="MaChucVu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MaChucVu;
    @Column(name="TenChucVu")
    private String TenChucVu;
    @Column(name="NgayTao")
    private LocalDate NgayTao;
    @Column(name="NgaySua")
    private LocalDate NgaySua;
}
