package org.example.credit_card;

public class CreditSimpleCard extends CreditCard {
    private long bankAccount;
    private long bankCreditLimitAccount = 10000;
    private final Short cashbackValueSimple = 1;
    private final Short cashbackValueMax = 3;
    private final Short bonusAccountAccrual = 2;

    @Override
    public void topUpAccount(Long amount) {
        if (bankCreditLimitAccount < 10000) {
            long differentLimitMoney = 10000 - bankCreditLimitAccount;
            if (differentLimitMoney <= amount) {
                bankCreditLimitAccount = 10000;
                amount -= differentLimitMoney;
                bankAccount += amount;
            } else {
                bankCreditLimitAccount += amount;
            }
        } else bankAccount +=amount;
        accountAccrualForTopUp(amount);
    }

    @Override
    public String payAccount(Long amount) {
        if (bankAccount >= amount) {
            bankAccount -= amount;
            cashbackForPay(amount);
            return "Платеж успешно завершен";
        } else if (bankCreditLimitAccount + bankAccount >= amount) {
            amount -= bankAccount;
            bankAccount = 0;
            bankCreditLimitAccount -= amount;
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
        return String.format("Общая информация о аккаунте:\nТекущий банковский счет - %s\nКредитный лимит счета - %s\nПростой кешбэк - %s\nМаксимальный кешбэк - %s\nБонусы карты - %s\n",
                bankAccount, bankCreditLimitAccount, cashbackValueSimple, cashbackValueMax, bonusAccountAccrual);
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
