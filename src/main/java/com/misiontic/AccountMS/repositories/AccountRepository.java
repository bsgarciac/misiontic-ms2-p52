package com.misiontic.AccountMS.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.misiontic.AccountMS.models.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

}
