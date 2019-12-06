package mapper;

import entities.AccountEntity;
import model.Account;

public class AccountMapper implements AccountMapperInt  {
    @Override
    public AccountEntity mapDtoToBo(Account input) {
        AccountEntity output = new AccountEntity();
        output.setId(input.getId());
        output.setBalance(input.getBalance());
        output.setAccountNumber(input.getAccountNumber());
        return output;
    }

}
