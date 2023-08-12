package com.J7_Plus.Website.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="NhanVien")
@Getter
@Setter
@Data
public class NhanVien {
@Id
        @Column(name="Id")
        @GeneratedValue(strategy = GenerationType.AUTO)
private UUID Id;
@Column(name="MaNhanVien")
private String MaNhanVien;
@Column(name="Ho")
   private String Ho;
@Column(name="Ten")
   private String Ten;
@Column(name="NgayTao")
   private LocalDate NgayTao;
@Column(name="SDT")
   private String Sdt;
@Column(name="Email")
   private String Email;
@Column(name="DiaChi")
   private String DiaChi;
@Column(name="NgaySua")
   private LocalDate NgaySua;
@Column(name="TrangThai")
   private Integer TrangThai;
@Column(name="NgaySinh")
private Date NgaySinh;
@Column(name="MatKhau")
private String MatKhau;
@Column(name="cmnd")
private String cmnd;
@ManyToOne
    @JoinColumn(name="ChucVu")
    private ChucVu ChucVu;
@Column(name="image")
    private String image;
}
