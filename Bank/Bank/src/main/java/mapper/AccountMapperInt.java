package mapper;

import entities.AccountEntity;
import model.Account;
import model.Transaction;

public interface AccountMapperInt {

    static void saveAccountAndTransaction(Account account, Transaction transaction) {
    }

    public AccountEntity mapDtoToBo(Account input);


}
