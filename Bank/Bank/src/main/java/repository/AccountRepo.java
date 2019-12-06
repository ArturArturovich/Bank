package repository;

import entities.AccountEntity;
import entities.TransactionEntity;
import mapper.AccountMapper;
import mapper.TransactionMapper;
import mapper.TransactionMapperInt;
import model.Account;
import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value="accountRepo")
public class AccountRepo extends OperationRepo<AccountEntity> implements AccountRepository {

    public AccountRepo() {
        super(AccountEntity.class);
    }

    @Autowired
    AccountMapper AccountMapper;

    @Autowired
    TransactionMapperInt TransactionMapperInt ;
    @Autowired
    TransactionMapper TransactionMapper;

    @Override
    @Transactional
    public void saveAccountAndTransaction(Account account, Transaction transaction) {
        AccountEntity accountBo = AccountMapper.mapDtoToBo(account);
        update(accountBo);

        TransactionEntity transactionEntity = TransactionMapper.mapDtoToBo(transaction);
        transactionEntity.setAccount(account);
        TransactionMapperInt.save(transactionEntity);
    }

    @Override
    @Transactional
    public List<Transaction> getTransactionsHistory(Account account) {
        AccountEntity accountEntity = findByPk(account.getId());
        return TransactionMapper.mapListBoToListDto(accountEntity.getTransactions());
    }

}

