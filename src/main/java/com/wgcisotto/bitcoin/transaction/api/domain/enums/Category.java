package com.wgcisotto.bitcoin.transaction.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
public enum Category {

    /**
     * The transaction category.
     *
     * "send"       - Transactions sent.
     * "receive"    - Non-coinbase transactions received.
     * "generate"   - Coinbase transactions received with more than 100 confirmations.
     * "immature"   - Coinbase transactions received with 100 or fewer confirmations.
     * "orphan"     - Orphaned coinbase transactions received.
     *
     * ref: <a href="https://developer.bitcoin.org/reference/rpc/listsinceblock.html"> listsinceblock </a>
     */

    RECEIVE("receive"),
    SEND("send"),
    GENERATE("generate"),
    IMMATURE("immature"),
    ORPHAN("orphan");

    private String typeName;

    public static Category fromName(String typeName){
        return Stream.of(Category.values())
                .filter(category -> category.typeName.equals(typeName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}