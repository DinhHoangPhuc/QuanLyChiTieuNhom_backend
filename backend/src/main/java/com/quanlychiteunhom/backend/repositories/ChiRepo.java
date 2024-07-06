package com.quanlychiteunhom.backend.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quanlychiteunhom.backend.entities.Chi;

public interface ChiRepo extends JpaRepository<Chi, Integer>{

    @Query(value = "SELECT chi.ngay_chi as ngay_chi, SUM(chi.so_tien) as tong_chi FROM lich_su_chi chi WHERE chi.nhom_id = :nhomId AND chi.ngay_chi >= :startOfWeek AND chi.ngay_chi < :endOfWeek GROUP BY DATE(chi.ngay_chi)", nativeQuery = true)
    List<Object[]> thongKeChiTuan(@Param("nhomId") int nhomId, @Param("startOfWeek") LocalDate startOfWeek, @Param("endOfWeek") LocalDate endOfWeek);

    @Query("""
    SELECT WEEK(chi.ngayChi) as tuan, SUM(chi.soTien) as tong_chi 
    FROM Chi chi 
    WHERE chi.quy.nhom.id = :nhomId AND MONTH(chi.ngayChi) = 10 AND YEAR(chi.ngayChi) = 2024 
    GROUP BY WEEK(chi.ngayChi)
    """)
    List<Object[]> thongKeChiTuanTrongThang(@Param("nhomId") int nhomId);
}
