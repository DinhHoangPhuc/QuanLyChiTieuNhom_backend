package com.quanlychiteunhom.backend.services;

import com.quanlychiteunhom.backend.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;

import java.util.List;
import java.util.Optional;

@Service
public class QuyServiceImpl implements QuyServiceChiaDeu {

    @Autowired
    private QuyRepo quyRepository;

    @Autowired
    private ThanhVienRepo thanhVienRepository;

    @Override
    public double tinhTienChiaDeu(int nhomId) {
        Optional<Quy> quyOptional = quyRepository.findById(nhomId);
        if (!quyOptional.isPresent()) {
            throw new ResourceNotFoundException("Không tìm thấy quỹ của nhóm với ID: " + nhomId);
        }

        Quy quy = quyOptional.get();
        List<ThanhVien> thanhViens = thanhVienRepository.findByNhomId(nhomId);

        if (thanhViens.isEmpty()) {
            throw new IllegalStateException("Nhóm không có thành viên.");
        }

        return (double) quy.getSoTienHienTai() / thanhViens.size();
    }
    @Override
    public double soTienHienTai(int nhomId) {
        Optional<Quy> quyOptional = quyRepository.findById(nhomId);
        if (!quyOptional.isPresent()) {
            throw new ResourceNotFoundException("Không tìm thấy quỹ của nhóm với ID: " + nhomId);
        }

        Quy quy = quyOptional.get();
        return (double) quy.getSoTienHienTai();
    }
}
