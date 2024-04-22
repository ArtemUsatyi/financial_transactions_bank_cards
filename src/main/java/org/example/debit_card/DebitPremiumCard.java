package org.example.debit_card;

import org.example.abstract_class.DebitCard;

public class DebitPremiumCard extends DebitCard {
    private long bankAccount;
    private final Short cashbackValueSimple = 2;
    private final Short cashbackValueMax = 2;
    private final Short bonusAccountAccrual = 2;

    @Override
    public void topUpAccount(Long amount) {
        this.bankAccount = bankAccount + amount;
        System.out.println("Средства зачислены на счет");
        accountAccrualForTopUp(amount);
    }

    @Override
    public void payAccount(Long amount) {
        if (bankAccount >= amount) {
            bankAccount -= amount;
            cashbackForPay(amount);
            System.out.println("Платеж успешно завершен");
        } else System.out.println("Платеж не прошел, недостаточно средств на карте");
    }

    @Override
    public String getInfoAccount() {
        return "Текущий банковский счет - " + bankAccount + "\n";
    }

    @Override
    public String getInfoAccountAll() {
        return String.format("Общая информация о аккаунте:\nТекущий банковский счет - %s\nПростой кешбэк - %s\nМаксимальный кешбэк - %s\nБонусы за пополнение карты - %s\n",
                bankAccount, cashbackValueSimple, cashbackValueMax, bonusAccountAccrual);
    }

    private void accountAccrualForTopUp(Long amount) {
        if (amount >= 3000) {
            this.bankAccount += bonusAccountAccrual;
            System.out.println("Бонус за пополнение зачислен, в размере -" + bonusAccountAccrual);
        }
    }

    private void cashbackForPay(Long amount) {
        if (amount > 100 && amount < 10000) {
            long cashback = amount / 100;
            bankAccount += cashback * cashbackValueSimple;
            System.out.println("Зачислен кешбек - " + cashback * cashbackValueSimple);
        } else if (amount >= 10000) {
            long cashback = amount / 100;
            bankAccount += cashback * cashbackValueMax;
            System.out.println("Зачислен максимальный кешбек - " + cashback * cashbackValueMax);
        }
    }
}
