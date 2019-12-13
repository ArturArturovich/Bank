package com.example.Bank.entities;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="TRANSACTION_ID", unique=true, nullable=false, precision=22)
    private Integer id;

    private BigDecimal amount;
    private Date date;



    public TransactionEntity(BigDecimal amount) {
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
