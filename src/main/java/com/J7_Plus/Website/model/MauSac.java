package com.J7_Plus.Website.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="MauSac")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer Id;
    @Column(name="Ten")
    private String Ten;
    @Column(name="NgayTao")
    private LocalDate NgayTao;
    @Column(name="NgaySua")
    private LocalDate NgaySua;
}
