package com.quanlychiteunhom.backend.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.ThuRequest;
import com.quanlychiteunhom.backend.dto.ThuThangStats;
import com.quanlychiteunhom.backend.dto.ThuTuanStats;
import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.entities.Thu;
import com.quanlychiteunhom.backend.repositories.NhomRepo;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.repositories.ThuRepo;

@Service
public class ThuService {

    @Autowired
    private NhomRepo nhomRepo;

    @Autowired
    private ThuRepo thuRepo;

    @Autowired
    private QuyRepo quyRepo;

    public ResponseEntity<?> addThu(ThuRequest thuRequest) {
        try {
            Quy quy = quyRepo.findById(thuRequest.getNhomId())
                                .orElseThrow(() -> new RuntimeException("Quy khong ton tai"));
            quy.setSoTienHT(quy.getSoTienHT() + thuRequest.getSoTien());
            quyRepo.save(quy);
            Thu thu = new Thu();
            thu.setSoTien(thuRequest.getSoTien());
            thu.setMoTa(thuRequest.getMoTa());
            thu.setNgayThu(thuRequest.getNgayThu());
            thu.setQuy(quy);
            return new ResponseEntity<>(thuRepo.save(thu), HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    public ResponseEntity<?> thongKeThuTuan(int nhomId) {
        try {
            LocalDate now = LocalDate.now();
            LocalDate startOfWeek = now.with(DayOfWeek.MONDAY);
            LocalDate endOfWeek = now.with(DayOfWeek.SUNDAY);

            List<Object[]> thongKeThuTuan = thuRepo.thongKeThuTuan(nhomId, startOfWeek, endOfWeek);
            List<ThuTuanStats> thuTuanStats = thongKeThuTuan.stream()
                    .map(result -> {
                        Timestamp ngayThu = (Timestamp) result[0];
                        LocalDate ngay = ngayThu.toLocalDateTime().toLocalDate();
                        return new ThuTuanStats(ngay, (BigDecimal) result[1]);
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(thuTuanStats);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    public ResponseEntity<?> thongKeThuTuanTrongThang(int nhomId) {
        try {
            LocalDate now = LocalDate.now();
            int month = now.getMonthValue();
            int year = now.getYear();

            List<Object[]> thongKeThuTuan = thuRepo.thongKeThuTuanTrongThang(nhomId, month, year);
            List<ThuThangStats> thuTuanStats = thongKeThuTuan.stream()
                    .map(result -> {
                        int tuan = (int) result[0];
                        Long tongThu = (Long) result[1];
                        return new ThuThangStats(tuan, tongThu);
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(thuTuanStats);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

}
