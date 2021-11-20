package com.misiontic.AccountMS.controllers;
import com.misiontic.AccountMS.exceptions.AccountNotFoundException;
import com.misiontic.AccountMS.repositories.AccountRepository;
import com.misiontic.AccountMS.models.Account;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {
    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/accounts/{username}")
    public Account getAccount(@PathVariable String username){
        return this.repository.findById(username)
                .orElseThrow(() -> new AccountNotFoundException("La cuenta no existe"));
    }

    @PostMapping("/accounts")
    public Account newAccount(@RequestBody  Account account){
        return this.repository.save(account);
    }

    @DeleteMapping("/accounts/{username}")
    public void deleteAccount(@PathVariable String username){
        repository.deleteById(username);
    }

    @PutMapping("/accounts/{username}")
    public Account updateAccount(@PathVariable  String username, @RequestBody Account new_account){
        Account old_account = repository.findById(username).orElse(null);
        // ESTO ACTUALIZA EL OBJETO DE JAVA
        old_account.setLastChange(new_account.getLastChange());
        old_account.setBalance(new_account.getBalance());
        // ESTO SÍ ACTUALIZA LA BASE DE DATOS
        return repository.save(old_account);
    }


}
