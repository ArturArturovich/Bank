package rest;

import model.Account;
import model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.OperationService;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationsController {

    public static final Logger logger = LoggerFactory.getLogger(OperationsController.class);


    @Autowired
    OperationService operationService;

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Account account) {
        logger.info("Account Creation");
        OperationService.create(account);
        logger.info("Account Creation Done");
    }

    //    Веб-сервис rest для снятия указанной суммы денег со
//	  своего счета
    @RequestMapping(
            value = "/withdraw",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void withdraw(@RequestBody Account account, Double withdrawAmount) {
        OperationService.withdraw(account, withdrawAmount);
    }

    //    Веб-сервис rest для пополнения указанной суммы денег на свой
//	   счет
    @RequestMapping(
            value = "/putmoney",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void put(@RequestBody Account account, Double putAmount) {
        OperationService.put(account, putAmount);
    }


    //    Веб-сервис rest для перевода указанной суммы денег с одного
//	  банковскогой счета  на другой
    @RequestMapping(
            value = "/transfermoney",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transfer(@RequestBody Account accountPayer, @RequestBody Account accountPayee, Double transfertAmount) {
        OperationService.transfer(accountPayer, accountPayee, transfertAmount);
    }

//    @RequestMapping(
//            value="/transactionsHistory",
//            method=RequestMethod.GET,
//            produces=MediaType.APPLICATION_JSON_VALUE)
//    public List<Transaction> getTransactionsHistory(Account account)  {
//
//        return OperationService.getTransactionsHistory(account) ;
//    }
}