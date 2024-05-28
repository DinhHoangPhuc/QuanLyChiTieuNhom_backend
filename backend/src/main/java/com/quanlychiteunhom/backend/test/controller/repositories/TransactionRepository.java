package com.quanlychiteunhom.backend.test.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quanlychiteunhom.backend.test.controller.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}