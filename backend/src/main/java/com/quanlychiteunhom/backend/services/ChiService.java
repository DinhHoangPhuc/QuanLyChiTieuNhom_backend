package com.quanlychiteunhom.backend.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.ChiRequest;
import com.quanlychiteunhom.backend.dto.ChiThangStats;
import com.quanlychiteunhom.backend.dto.ChiTuanStats;
import com.quanlychiteunhom.backend.entities.Chi;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.repositories.ChiRepo;
import com.quanlychiteunhom.backend.repositories.QuyRepo;

@Service
public class ChiService {

    @Autowired
    private ChiRepo chiRepo;

    @Autowired
    private QuyRepo quyRepo;

    public ResponseEntity<?> addChi(ChiRequest chiRequest) {
        try {
            Quy quy = quyRepo.findById(chiRequest.getNhomId()).get();
            if(chiRequest.getSoTien() > quy.getSoTienHT()){
                throw new RuntimeException("Số tiền chi vượt quá số tiền hiện tại trong quỹ");
            }
            quy.setSoTienHT(quy.getSoTienHT() - chiRequest.getSoTien());
            quyRepo.save(quy);

            Chi chi = new Chi();
            chi.setSoTien(chiRequest.getSoTien());
            chi.setNgayChi(chiRequest.getNgayChi());
            chi.setMoTa(chiRequest.getMoTa());

            quyRepo.findById(chiRequest.getNhomId()).ifPresentOrElse(q -> {
                chi.setQuy(quy);
                chiRepo.save(chi);
            }, () -> {
                throw new RuntimeException("Không tìm thấy nhóm chi");
            });

            return new ResponseEntity<>(chi, org.springframework.http.HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> response = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    public ResponseEntity<?> thongKeChiTuan(int nhomId) {
        try {
            LocalDate now = LocalDate.now();
            LocalDate startOfWeek = now.with(DayOfWeek.MONDAY);
            LocalDate endOfWeek = now.with(DayOfWeek.SUNDAY).plusDays(1); // add 1 to include Sunday

            List<Object[]> results = chiRepo.thongKeChiTuan(nhomId, startOfWeek, endOfWeek);
            List<ChiTuanStats> chiTuanStats = results.stream()
                .map(result -> {
                    Timestamp timestamp = (Timestamp) result[0];
                    LocalDate date = timestamp.toLocalDateTime().toLocalDate();
                    return new ChiTuanStats(date, (BigDecimal) result[1]);
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(chiTuanStats);
        } catch (Exception e) {
            Map<String, String> response = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    public ResponseEntity<?> thongKeChiTuanTrongThang(int nhomId) {
        try {
            LocalDate now = LocalDate.now();
            int month = now.getMonthValue();
            int year = now.getYear();
            List<Object[]> results = chiRepo.thongKeChiTuanTrongThang(nhomId, month, year);
            List<ChiThangStats> chiTuanStats = results.stream()
                .map(result -> new ChiThangStats((Integer) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    
            return ResponseEntity.ok(chiTuanStats);
        } catch (Exception e) {
            Map<String, String> response = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
