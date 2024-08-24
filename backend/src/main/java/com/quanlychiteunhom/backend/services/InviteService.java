package com.quanlychiteunhom.backend.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.ResourceNotFoundException;
import com.quanlychiteunhom.backend.dto.InviteRequest;
import com.quanlychiteunhom.backend.entities.NguoiDung;
import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.repositories.InviteRepo;
import com.quanlychiteunhom.backend.repositories.NguoiDungRepo;
import com.quanlychiteunhom.backend.repositories.NhomRepo;

@Service
public class InviteService {

    @Autowired
    private InviteRepo inviteRepository;

    @Autowired
    private NhomRepo nhomRepo;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    public String createInvite(InviteRequest inviteRequest) {
        Nhom nhom = nhomRepo.findById(inviteRequest.getNhomId())
                            .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhóm !"));

        NguoiDung nguoiDung = nguoiDungRepo.findByUsername(inviteRequest.getInviter_username())
                            .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người dùng !"));
        

        if(checkUserIsMemberOfGroup(nhom, nguoiDung.getId())) {
            throw new ResourceNotFoundException("Người dùng không phải là thành viên nhóm !");
        }

        return null;
    }
    
    private boolean checkUserIsMemberOfGroup(Nhom nhom, int userId) {
        return nhom.getThanhVien()
                    .stream()
                    .anyMatch(thanhVien -> thanhVien.getId() == userId);
    }

    private String generateInviteCode() {
        return "INVITE_CODE";
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
