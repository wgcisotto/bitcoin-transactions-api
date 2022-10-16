package com.wgcisotto.bitcoin.transaction.api.service;

import com.wgcisotto.bitcoin.transaction.api.domain.Deposit;
import com.wgcisotto.bitcoin.transaction.api.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositRepository repository;

    @Override
    public List<Deposit> depositsOfUserAddress(String address) {
        return repository.findAllByAddressAndValidTrue(address);
    }

    public List<Deposit> unknownDeposits(){
        return repository.findByKnowCustomerFalse();
    }
    @Override
    public double smallestDeposit() {
        return repository.findSmallestDeposit();
    }

    @Override
    public double largestDeposit() {
        return repository.findLargestDeposit();
    }
}
