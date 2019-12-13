package com.example.Bank.service;





import com.example.Bank.model.Operation;


import java.util.List;

public interface OperationService {


    void save(Operation operation);


    List<Operation> getAll();

}
