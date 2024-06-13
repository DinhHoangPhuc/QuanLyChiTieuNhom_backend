package com.quanlychiteunhom.backend.services;

import com.quanlychiteunhom.backend.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TinhTienImpl implements TinhTienService {

    @Autowired
    private QuyRepo quyRepository;

    @Autowired
    private ThanhVienRepo thanhVienRepository;

    @Override
    public Map<String, Double> tinhTienChiaDeu(int nhomId) {
        Optional<Quy> quyOptional = quyRepository.findById(nhomId);
        if (!quyOptional.isPresent()) {
            throw new ResourceNotFoundException("Không tìm thấy quỹ của nhóm với ID: " + nhomId);
        }

        Quy quy = quyOptional.get();
        List<ThanhVien> thanhViens = thanhVienRepository.findByNhomId(nhomId);

        if (thanhViens.isEmpty()) {
            throw new IllegalStateException("Nhóm không có thành viên.");
        }
        Map<String, Double> tienThanhVien = Map.of(
                "tienThanhVien", (double) quy.getSoTienHT() / thanhViens.size()
        );
        return tienThanhVien;
    }
    @Override
    public Map<String, Double> soTienHienTai(int nhomId) {
        Optional<Quy> quyOptional = quyRepository.findById(nhomId);
        if (!quyOptional.isPresent()) {
            throw new ResourceNotFoundException("Không tìm thấy quỹ của nhóm với ID: " + nhomId);
        }

        Quy quy = quyOptional.get();
        Map<String, Double> tienThanhVien = Map.of(
                "soTienHienTai", (double) quy.getSoTienHT()
        );
        return tienThanhVien;
    }
}
