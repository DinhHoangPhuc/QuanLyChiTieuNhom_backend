package com.quanlychiteunhom.backend.test.controller.services;

import java.util.List;

import com.quanlychiteunhom.backend.test.controller.request.ChiRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanlychiteunhom.backend.test.controller.entities.Chi;
import com.quanlychiteunhom.backend.test.controller.repositories.ChiRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChiService {
    @Autowired
    private ChiRepo chiRepo;

    public ResponseEntity <List<Chi>> getChi()
    {
        try{
            List<Chi> chi = chiRepo.findAll();
            return new ResponseEntity<>(chi, HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public ResponseEntity<Chi> addChi(ChiRequest chi)
    {
        try{
            Chi _chi = new Chi();
            _chi.setId(chi.getId());
            _chi.setSoTien(chi.getSoTien());
            _chi.setNgayChi(chi.getNgayChi());
            _chi.setMoTa(chi.getMoTa());
            _chi.setNhomId(chi.getNhomId());
            return new ResponseEntity<>(_chi, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteByID(Long id) {
        try {
            if (chiRepo.existsById(id)) {
                chiRepo.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
