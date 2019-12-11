package service;

import model.Account;
import model.Transaction;


import java.util.List;

public interface OperationService {


    static void create(Account account) {

    }

    static void withdraw(Account account, Double withdrawAmount) {

    }

    static void transfer(Account accountPayer, Account accountPayee, Double amount) {

    }

    static void put(Account account, Double putAmount){

    }


//    static void List<Transaction> getTransactionHistory(Account account);
}
