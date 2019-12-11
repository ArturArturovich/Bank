package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class Account {

    private Integer id;
    private Double balance;
    private List<Transaction> transactions;
    private Integer accountNumber;

    public Account(Double balance){
        this.balance = balance;
        this.transactions = new ArrayList<Transaction>();
    }
    public Account(){
        this.balance = 0D;
        this.transactions = new ArrayList<Transaction>();
    }
    public Account(Integer accountNumber, Double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<Transaction>();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public Integer getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
}
