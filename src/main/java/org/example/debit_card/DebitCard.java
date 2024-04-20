package org.example.debit_card;

import org.example.BankCard;

public class DebitCard extends BankCard {
    @Override
    public void topUpAccount(Long amount) {
    }

    @Override
    public String payAccount(Long amount) {
        return null;
    }

    @Override
    public String getInfoAccount() {
        return null;
    }

    @Override
    public String getInfoAccountAll() {
        return null;
    }
}
