package org.example.debit_card;

public class DebitPremiumCard extends DebitCard {
    private long bankAccount;
    private final Short cashbackValueSimple = 2;
    private final Short cashbackValueMax = 2;
    private final Short bonusAccountAccrual = 2;

    @Override
    public void topUpAccount(Long amount) {
        this.bankAccount = bankAccount + amount;
        accountAccrualForTopUp(amount);
    }

    @Override
    public String payAccount(Long amount) {
        if (bankAccount >= amount) {
            bankAccount -= amount;
            cashbackForPay(amount);
            return "Платеж успешно завершен";
        } else return "Платеж не прошел, недостаточно средств на карте";
    }

    @Override
    public String getInfoAccount() {
        return "Текущий банковский счет - " + bankAccount + "\n";
    }

    @Override
    public String getInfoAccountAll() {
        return String.format("Общая информация о аккаунте:\nТекущий банковский счет - %s\nПростой кешбэк - %s\nМаксимальный кешбэк - %s\nБонусы карты - %s\n",
                bankAccount, cashbackValueSimple, cashbackValueMax, bonusAccountAccrual);
    }

    private void accountAccrualForTopUp(Long amount) {
        if (amount >= 3000) {
            this.bankAccount += bonusAccountAccrual;
        }
    }

    private void cashbackForPay(Long amount) {
        if (amount > 100 && amount < 5000) {
            long cashback = amount / 100;
            bankAccount += cashback * cashbackValueSimple;
        } else if (amount >= 5000) {
            long cashback = amount / 100;
            bankAccount += cashback * cashbackValueMax;
        }
    }
}
