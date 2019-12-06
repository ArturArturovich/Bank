package mapper;

import entities.TransactionEntity;
import model.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TransactionMapper implements TransactionMapperInt {
    @Override
    public TransactionEntity mapDtoBo(Transaction input) {
        ModelMapper modelMapper = new ModelMapper();
        TransactionEntity output = modelMapper.map(input, TransactionEntity.class);
        return output;
    }

    @Override
    public List<Transaction> mapListBoToListDto(List<TransactionEntity> transactions){
        List<Transaction> output = new ArrayList<Transaction>();
        for (TransactionEntity tr : transactions) {
            Transaction transactionDto = mapBotoDto(tr);
            output.add(transactionDto);
        }
        return output;
    }

    @Override
    public void save(TransactionEntity transactionEntity) {

    }


    @Override
    public TransactionEntity mapDtoToBo(Transaction input) {
        return null;
    }

    public Transaction mapBotoDto(TransactionEntity input) {
        ModelMapper modelMapper = new ModelMapper();
        Transaction output = modelMapper.map(input, Transaction.class);
        return output;
    }


}



