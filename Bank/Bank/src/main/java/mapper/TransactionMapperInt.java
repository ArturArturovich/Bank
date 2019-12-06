package mapper;

import entities.TransactionEntity;
import model.Transaction;

import java.util.List;

public interface TransactionMapperInt {

    public TransactionEntity mapDtoToBo(Transaction input);
    public Transaction mapBotoDto(TransactionEntity input);

    TransactionEntity mapDtoBo(Transaction input);

    public List<Transaction> mapListBoToListDto(List<TransactionEntity> transactions);

    void save(TransactionEntity transactionEntity);

}



