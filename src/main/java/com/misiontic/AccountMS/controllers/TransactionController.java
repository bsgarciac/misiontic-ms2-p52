package com.misiontic.AccountMS.controllers;
import com.misiontic.AccountMS.exceptions.AccountNotFoundException;
import com.misiontic.AccountMS.models.Account;
import com.misiontic.AccountMS.models.Transaction;
import com.misiontic.AccountMS.repositories.AccountRepository;
import com.misiontic.AccountMS.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/transactions/{usernameOrigin}")
    List<Transaction> getTransactionByUsernameOrigin(@PathVariable String usernameOrigin){
        List<Transaction> transactionsOrigin =
                transactionRepository.getByUsernameOrigin(usernameOrigin);
        List<Transaction> transactionsDestinity =
                transactionRepository.getByUsernameDestiny(usernameOrigin);
        List<Transaction> transactions = Stream.concat(transactionsOrigin.stream(),
                transactionsDestinity.stream()).collect(Collectors.toList());
        return transactions;
    }
    @PostMapping("/transaction/")
    Transaction newTransaction(@RequestBody Transaction transaction){
        Account accountDestiny = accountRepository.findById(transaction.getUsernameDestiny()).orElse(null);
        Account accountOrigin = accountRepository.findById(transaction.getUsernameOrigin()).orElse(null);
        if(accountOrigin == null || accountDestiny == null){
            throw new AccountNotFoundException("La cuenta origen o la cuenta destino no existen");
        }
        accountDestiny.setBalance(accountDestiny.getBalance() + transaction.getValue());
        accountOrigin.setBalance(accountOrigin.getBalance() - transaction.getValue());
        accountRepository.save(accountDestiny);
        accountRepository.save(accountOrigin);
        return transactionRepository.save(transaction);
    }

}
