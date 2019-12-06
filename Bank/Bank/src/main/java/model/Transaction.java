package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.TransactionType;

import java.util.Date;


public class Transaction {
    private Integer id;
    private Double amount;
    private TransactionType type;
    private Integer accountNumberFrom;
    private Integer accountNumberTo;
    private Date date;

    public Transaction(Integer accountNumberFrom, Integer accountNumberTo, TransactionType type,
                       double amount) {
        this.amount = amount;
        this.type = type;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
        this.date = new Date();
    }

    public Transaction(TransactionType type, Double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public Transaction() {

    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(Integer accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public Integer getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(Integer accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
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
