package com.quanlychiteunhom.backend.test.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.test.controller.entities.Transaction;
import com.quanlychiteunhom.backend.test.controller.repositories.TransactionRepository;
import com.quanlychiteunhom.backend.test.controller.request.TransactionRequest;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<List<Transaction>> getAllTransactions() {
        try {
            List<Transaction> transactions = transactionRepository.findAll();
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Transaction> addTransaction(TransactionRequest request) {
        try {
            Transaction transaction = new Transaction();
            transaction.setAmount(request.getAmount());
            transaction.setDate(request.getDate());
            transaction.setNote(request.getNote());
            transaction.setImage(request.getImage());
            transactionRepository.save(transaction);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}