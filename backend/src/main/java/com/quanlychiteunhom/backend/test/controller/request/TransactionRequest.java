package com.quanlychiteunhom.backend.test.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionRequest {
    private double amount;
    private Date date;
    private String note;
    private String image;
}