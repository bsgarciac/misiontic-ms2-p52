package com.misiontic.AccountMS.controllers;
import com.misiontic.AccountMS.models.Transaction;
import com.misiontic.AccountMS.repositories.AccountRepository;
import com.misiontic.AccountMS.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return transactionRepository.getByUsernameOrigin(usernameOrigin);
    }
    @PostMapping("/transaction/")
    Transaction newTransaction(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

}
