package org.example.abstract_class;

import org.example.abstract_class.BankCard;

public class CreditCard extends BankCard {
    @Override
    public void topUpAccount(Long amount) {
    }

    @Override
    public void payAccount(Long amount) {

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
