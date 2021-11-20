package com.misiontic.AccountMS.repositories;
import com.misiontic.AccountMS.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> getByUsernameOrigin(String usernameOrigin);
    List<Transaction> getByUsernameDestiny(String usernameDestiny);
}
