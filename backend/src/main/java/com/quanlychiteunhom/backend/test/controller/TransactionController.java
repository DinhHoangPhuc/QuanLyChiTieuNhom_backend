package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.entities.Transaction;
import com.quanlychiteunhom.backend.test.controller.request.TransactionRequest;
import com.quanlychiteunhom.backend.test.controller.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/income")
    public ResponseEntity<Transaction> addIncome(@RequestBody TransactionRequest request) {
        return transactionService.addTransaction(request);
    }

    @PostMapping("/expense")
    public ResponseEntity<Transaction> addExpense(@RequestBody TransactionRequest request) {
        return transactionService.addTransaction(request);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}