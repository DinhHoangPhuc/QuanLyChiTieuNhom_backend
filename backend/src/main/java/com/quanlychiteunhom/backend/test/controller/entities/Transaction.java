package com.quanlychiteunhom.backend.test.controller.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

    public Transaction() {
    }

    public Transaction(double amount, Date date, String note, String image) {
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.image = image;
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "note")
    private String note;

    @Column(name = "image")
    private String image;
}