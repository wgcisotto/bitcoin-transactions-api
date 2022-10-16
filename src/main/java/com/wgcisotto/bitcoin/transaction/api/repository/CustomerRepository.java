package com.wgcisotto.bitcoin.transaction.api.repository;

import com.wgcisotto.bitcoin.transaction.api.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByAddress(String address);

}
