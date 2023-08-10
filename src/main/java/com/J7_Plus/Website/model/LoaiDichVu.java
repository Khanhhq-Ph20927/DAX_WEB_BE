package com.J7_Plus.Website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LoaiDichVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoaiDichVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "NgayTao")
    private LocalDateTime NgayTao;
    @Column(name = "NgaySua")
    private LocalDateTime NgaySua;
}
