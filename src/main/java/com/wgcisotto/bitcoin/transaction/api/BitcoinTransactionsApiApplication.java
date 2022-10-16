package com.wgcisotto.bitcoin.transaction.api;

import com.wgcisotto.bitcoin.transaction.api.domain.Customer;
import com.wgcisotto.bitcoin.transaction.api.domain.Deposit;
import com.wgcisotto.bitcoin.transaction.api.domain.enums.Category;
import com.wgcisotto.bitcoin.transaction.api.repository.CustomerRepository;
import com.wgcisotto.bitcoin.transaction.api.service.DepositService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class BitcoinTransactionsApiApplication {

	private static final List<String > customers = Arrays.asList(
			"mvd6qFeVkqH6MNAS2Y2cLifbdaX5XUkbZJ",
			"mmFFG4jqAtw9MoCC88hw5FNfreQWuEHADp",
			"mzzg8fvHXydKs8j9D2a8t7KpSXpGgAnk4n",
			"2N1SP7r92ZZJvYKG2oNtzPwYnzw62up7mTo",
			"mutrAf4usv3HKNdpLwVD4ow2oLArL6Rez8",
			"miTHhiX3iFhVnAEecLjybxvV5g8mKYTtnM",
			"mvcyJMiAcSXKAEsQxbW9TYZ369rsMG6rVV"
			);
	private static DepositService depositService;
	private static CustomerRepository customerRepository;

	@Autowired
	public void setDepositService(DepositService depositService) {
		this.depositService = depositService;
	}

	@Autowired
	public void setCustomersRepository(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BitcoinTransactionsApiApplication.class, args);
		customers.forEach(customerAddress -> {
			Customer customer = customerRepository.findByAddress(customerAddress);
			List<Deposit> deposits = depositService.depositsOfUserAddress(customer.getAddress());
			double totalSent = deposits.stream().filter(deposit -> Category.SEND.equals(deposit.getCategory())).mapToDouble(Deposit::getAmount).sum();
			List<Deposit> depositsReceived = deposits.stream().filter(deposit -> !Category.SEND.equals(deposit.getCategory())).collect(Collectors.toList());
			double totalReceived = depositsReceived.stream().mapToDouble(Deposit::getAmount).sum();
			double credit = totalReceived - totalSent;
			log.info("Deposited for {}: count={} sum={}", customer.getName(), depositsReceived.size(), credit);
		});
		List<Deposit> deposits = depositService.unknownDeposits();
		log.info("Deposited without reference: count={} sum={}", deposits.size(), deposits.stream().mapToDouble(Deposit::getAmount).sum());
		log.info("Smallest valid deposit: {}", depositService.smallestDeposit());
		log.info("Largest valid deposit: {}", depositService.largestDeposit());
	}
}
