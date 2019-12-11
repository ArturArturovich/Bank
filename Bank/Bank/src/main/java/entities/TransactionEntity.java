package entities;

import model.Account;
import util.TransactionType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="TRANSACTION_ID", unique=true, nullable=false, precision=22)
    private Integer id;

    private Double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private Integer accountNumberFrom;
    private Integer accountNumberTo;
    private Date date;

    //bi-directional many-to-one association to Client
    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID", nullable=false)
    private Account account;

    public TransactionEntity(Integer accountNumberFrom, Integer accountNumberTo, TransactionType type,
                         double amount) {
        this.amount = amount;
        this.type = type;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
        this.date = new Date();
    }

    public TransactionEntity(TransactionType type, Double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



}
