package com.quanlychiteunhom.backend.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quanlychiteunhom.backend.entities.Thu;

public interface ThuRepo extends JpaRepository<Thu, Integer>{
    @Query(value = "SELECT thu.ngay_thu as ngay_thu, SUM(thu.so_tien) as tong_thu FROM lich_su_thu thu WHERE thu.quy_id = :nhomId AND thu.ngay_thu >= :startOfWeek AND thu.ngay_thu < :endOfWeek GROUP BY DATE(thu.ngay_thu)", nativeQuery = true)
    List<Object[]> thongKeThuTuan(@Param("nhomId") int nhomId,
                                    @Param("startOfWeek") LocalDate startOfWeek,
                                    @Param("endOfWeek") LocalDate endOfWeek);

    @Query("""
    SELECT WEEK(thu.ngayThu) as tuan, SUM(thu.soTien) as tong_thu
    FROM Thu thu
    WHERE thu.quy.id = :nhomId AND MONTH(thu.ngayThu) = :month AND YEAR(thu.ngayThu) = :year 
    GROUP BY WEEK(thu.ngayThu)
    """)
    List<Object[]> thongKeThuTuanTrongThang(@Param("nhomId") int nhomId,
                                            @Param("month") int month,
                                            @Param("year") int year);
}
