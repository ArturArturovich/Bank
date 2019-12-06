package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ACCOUNT")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ACCOUNT_ID", unique=true, nullable=false, precision=22)
    private Integer id;

    private Double balance;
    private Integer accountNumber;

    @OneToMany(mappedBy="account",fetch=FetchType.LAZY)
    private List<TransactionEntity> transactions;


    public AccountEntity(Double balance){
        this.balance = balance;
        this.transactions = new ArrayList<TransactionEntity>();
    }
    public AccountEntity(){
        this.balance = 0D;
        this.transactions = new ArrayList<TransactionEntity>();
    }
    public AccountEntity(Integer accountNumber, Double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<TransactionEntity>();
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
    public List<TransactionEntity> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
    public Integer getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

}
