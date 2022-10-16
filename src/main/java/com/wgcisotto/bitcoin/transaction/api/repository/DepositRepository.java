package com.wgcisotto.bitcoin.transaction.api.repository;

import com.wgcisotto.bitcoin.transaction.api.domain.Deposit;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends MongoRepository<Deposit, String> {

    List<Deposit> findAllByAddressAndValidTrue(String address);

    @Aggregation(pipeline = { "{$match: {valid: true }}", "{$group: { _id: '', total: {$min: '$amount' }}}" })
    double findSmallestDeposit();

    @Aggregation(pipeline = { "{$match: {valid: true }}", "{$group: { _id: '', total: {$max: $amount }}}" })
    double findLargestDeposit();

    List<Deposit> findByKnowCustomerFalse();
}
