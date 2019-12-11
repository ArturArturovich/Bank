package repository;

import entities.TransactionEntity;
import model.Account;
import model.Transaction;

import java.util.List;

public interface TransactionRepository extends OperationRepository<TransactionEntity> {

    public void saveAccountAndTransaction(Account account,Transaction transaction);

    public List<Transaction> getTransactionsHistory(Account account);
}
