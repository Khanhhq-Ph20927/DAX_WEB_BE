package com.J7_Plus.Website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DichVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DichVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "DonGia")
    private BigDecimal donGia;
    //IdPhuKien
    //IdLoaiDichVu
    @ManyToOne
    @JoinColumn(name = "IdLoaiDichVu")
    private LoaiDichVu loaiDV;
    @Column(name = "NgayTao")
    private LocalDateTime NgayTao;
    @Column(name = "NgaySua")
    private LocalDateTime NgaySua;

}
