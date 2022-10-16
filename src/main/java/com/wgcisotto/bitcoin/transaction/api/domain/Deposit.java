package com.wgcisotto.bitcoin.transaction.api.domain;

import com.wgcisotto.bitcoin.transaction.api.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "deposit")
public class Deposit {
    @Id
    private String id;
    private String address;
    private String customerIdentification;
    private Category category;
    private double amount;
    private int confirmations;
    private boolean valid;
    private boolean knowCustomer;
}
