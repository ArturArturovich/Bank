package com.example.Bank.model;


import java.math.BigDecimal;
import java.util.Date;


public class Operation {
    private Integer id;
    private BigDecimal amount;
    private Date date;


    public Operation(BigDecimal amount) {
        this.amount = amount;
        this.date = new Date();
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
