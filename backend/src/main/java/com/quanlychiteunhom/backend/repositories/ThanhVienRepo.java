package com.quanlychiteunhom.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.entities.ThanhVien;

public interface ThanhVienRepo extends JpaRepository<ThanhVien, Integer>{
    List<ThanhVien> findByNhomId(int nhomId);

    @Query("SELECT n FROM Nhom n JOIN n.thanhVien tv WHERE tv.nguoiDung.id = ?1")
    List<Nhom> findByNguoiDung(int nguoiDungId);

}
