package com.misiontic.AccountMS.controllers;
import com.misiontic.AccountMS.repositories.AccountRepository;
import com.misiontic.AccountMS.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
}
