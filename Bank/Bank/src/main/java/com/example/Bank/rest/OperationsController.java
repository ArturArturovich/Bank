package com.example.Bank.rest;



import com.example.Bank.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Bank.service.OperationService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/client/transactions")
public class OperationsController {


    @Autowired
    OperationService operationService;


    @RequestMapping(value = "/transfer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operation> updateTransaction(@RequestBody @Valid Operation operation){
        HttpHeaders headers = new HttpHeaders();

        if (operation == null){
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
        this.operationService.save(operation);

        return new ResponseEntity<>(operation, headers, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/put", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operation> saveTransaction(@RequestBody @Valid Operation operation){
        HttpHeaders headers = new HttpHeaders();

        if(operation == null) {
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
        this.operationService.save(operation);

        return new ResponseEntity<>(operation, headers, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operation> deleteTransaction(@RequestBody @Valid Operation operation){
        HttpHeaders headers = new HttpHeaders();

        if(operation == null) {
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
        this.operationService.save(operation);

        return new ResponseEntity<>(operation, headers, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Operation>> getAllOperations(){
      List<Operation> operations = this.operationService.getAll();

      if (operations.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<>(operations, HttpStatus.OK);
  }


}






















//    @RequestMapping(
//            value = "/create",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void create(@RequestBody Account account) {
//        logger.info("Account Creation");
//        TransactionService.create(account);
//        logger.info("Account Creation Done");
//    }
//
//    //    Веб-сервис com.example.Bank.rest для снятия указанной суммы денег со
////	  своего счета
//    @RequestMapping(
//            value = "/withdraw",
//            method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void withdraw(@RequestBody Account account, Double withdrawAmount) {
//        TransactionService.withdraw(account, withdrawAmount);
//    }
//
//    //    Веб-сервис com.example.Bank.rest для пополнения указанной суммы денег на свой
////	   счет
//    @RequestMapping(
//            value = "/putmoney",
//            method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void put(@RequestBody Account account, Double putAmount) {
//        TransactionService.put(account, putAmount);
//    }
//
//
//    //    Веб-сервис com.example.Bank.rest для перевода указанной суммы денег с одного
////	  банковскогой счета  на другой
//    @RequestMapping(
//            value = "/transfermoney",
//            method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void transfer(@RequestBody Account accountPayer, @RequestBody Account accountPayee, Double transfertAmount) {
//        TransactionService.transfer(accountPayer, accountPayee, transfertAmount);
//    }
//
////    @RequestMapping(
////            value="/transactionsHistory",
////            method=RequestMethod.GET,
////            produces=MediaType.APPLICATION_JSON_VALUE)
////    public List<Transaction> getTransactionsHistory(Account account)  {
////
////        return OperationService.getTransactionsHistory(account) ;
////    }
//}