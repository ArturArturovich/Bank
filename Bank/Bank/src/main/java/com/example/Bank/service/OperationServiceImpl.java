package com.example.Bank.service;


import com.example.Bank.model.Operation;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Bank.repository.CrudRepository;

import java.util.List;


@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    CrudRepository crudRepository;


    @Override
    public void save(Operation operation) {

    }

    @Override
    public List<Operation> getAll() {
        return crudRepository.findAll();
    }
}

