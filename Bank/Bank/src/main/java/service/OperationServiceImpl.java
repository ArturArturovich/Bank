package service;

import mapper.AccountMapper;
import mapper.AccountMapperInt;
import model.Account;
import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AccountRepo;
import util.Constants;
import util.FunctionalException;
import util.TransactionType;

import java.util.List;

public class OperationServiceImpl implements OperationService {

    @Autowired
    AccountRepo AccountRepo;

    @Autowired
    AccountMapper AccountMapper;

//    Реализация сервиса для создания новой учетной записи
    public void create(Account account) {
        AccountRepo.save(AccountMapper.mapDtoToBo(account));
    }


    public void put(Account account, Double putAmount) {
        account.setBalance(account.getBalance() + putAmount);


        Transaction transaction = new Transaction(TransactionType.PUT, putAmount);
        account.getTransactions().add(transaction);

        AccountMapperInt.saveAccountAndTransaction(account, transaction);
    }

//    Реализация услуги по снятию со счета действительной суммы
    public void withdraw(Account account, Double withdrawAmount) throws FunctionalException {

        if (account.getBalance() < withdrawAmount)
            throw new FunctionalException(Constants.INSUFFICIENT_BALANCE);

        account.setBalance(account.getBalance() - withdrawAmount);


        Transaction transaction = new Transaction(TransactionType.WITHDRAW, withdrawAmount);
        account.getTransactions().add(transaction);

        AccountRepo.saveAccountAndTransaction(account, transaction);
    }

//    Реализация услуги по переводу со счета на счет действительной суммы
    public void transfer(Account accountPayer, Account accountPayee, Double transfertAmount) throws FunctionalException {

        if (accountPayer.getBalance() < transfertAmount)
            throw new FunctionalException(Constants.INSUFFICIENT_BALANCE);

        accountPayer.setBalance(accountPayer.getBalance() - transfertAmount);
        accountPayee.setBalance(accountPayee.getBalance() + transfertAmount);


        Transaction transaction = new Transaction(accountPayer.getAccountNumber(), accountPayee.getAccountNumber(), TransactionType.TRANSFER, transfertAmount);
        accountPayer.getTransactions().add(transaction);
        accountPayee.getTransactions().add(transaction);

        AccountRepo.saveAccountAndTransaction(accountPayer, transaction);

    }

//    Реализация сервиса для запроса истории транзакций банковского счета
//    public List<Transaction> getTransactionsHistory(Account account) {
//        return AccountRepo.getTransactionsHistory(account);
//    }
}

