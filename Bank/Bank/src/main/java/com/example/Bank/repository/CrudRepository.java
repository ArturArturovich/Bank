package com.example.Bank.repository;



import com.example.Bank.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;

public interface CrudRepository extends JpaRepository<Operation, BigDecimal> {


}
