package com.example.Bank;


import com.example.Bank.model.Operation;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


public class OperationTest {

    @Test
    public void getOperations() throws Exception{
        Operation operation = new Operation(new BigDecimal(10000.00));
        operation.setAmount(new BigDecimal(5000.00));

        List<Operation> allOperations = Collections.singletonList(operation);

    }


}
