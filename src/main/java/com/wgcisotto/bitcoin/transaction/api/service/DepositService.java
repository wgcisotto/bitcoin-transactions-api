package com.wgcisotto.bitcoin.transaction.api.service;

import com.wgcisotto.bitcoin.transaction.api.domain.Deposit;

import java.util.List;

public interface DepositService {

    List<Deposit> depositsOfUserAddress(String address);

    List<Deposit> unknownDeposits();

    double smallestDeposit();
    double largestDeposit();

}
