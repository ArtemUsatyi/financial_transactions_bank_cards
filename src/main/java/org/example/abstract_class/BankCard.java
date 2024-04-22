package org.example.abstract_class;

public abstract class BankCard {
    public abstract void topUpAccount(Long amount);

    public abstract void payAccount(Long amount);

    public abstract String getInfoAccount();

    public abstract String getInfoAccountAll();
}
