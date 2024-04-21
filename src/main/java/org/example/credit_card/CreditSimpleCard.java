package org.example.credit_card;

import static org.example.constance.ConstanceApplication.LIMIT_CREDIT_SIMPLE;

public class CreditSimpleCard extends CreditCard {
    private long bankAccount;
    private long bankCreditLimitAccount = LIMIT_CREDIT_SIMPLE;
    private final Short cashbackValueSimple = 2;
    private final Short cashbackValueMax = 4;
    private final Short bonusAccountAccrual = 2;

    @Override
    public void topUpAccount(Long amount) {
        Long cashbackAmount = amount;
        if (bankCreditLimitAccount < LIMIT_CREDIT_SIMPLE) {
            long differentLimitMoney = LIMIT_CREDIT_SIMPLE - bankCreditLimitAccount;
            if (differentLimitMoney <= amount) {
                bankCreditLimitAccount = LIMIT_CREDIT_SIMPLE;
                amount -= differentLimitMoney;
                bankAccount += amount;
            } else {
                bankCreditLimitAccount += amount;
            }
        } else bankAccount += amount;
        System.out.println("Средства зачислены на счет");
        accountAccrualForTopUp(cashbackAmount);
    }

    @Override
    public void payAccount(Long amount) {
        if (bankAccount >= amount) {
            bankAccount -= amount;
            cashbackForPay(amount);
            System.out.println("Платеж успешно завершен");
        } else if (bankCreditLimitAccount + bankAccount >= amount) {
            cashbackForPay(amount);
            amount -= bankAccount;
            bankAccount = 0;
            bankCreditLimitAccount -= amount;
            System.out.println("Платеж успешно завершен");
        } else System.out.println("Платеж не прошел, недостаточно средств на карте");
    }

    @Override
    public String getInfoAccount() {
        return "Текущий банковский счет - " + bankAccount + "\n";
    }

    @Override
    public String getInfoAccountAll() {
        return String.format("Общая информация о аккаунте:\nТекущий банковский счет - %s\nКредитный лимит счета - %s\nПростой кешбэк - %s\nМаксимальный кешбэк - %s\nБонусы за пополнение карты - %s\n",
                bankAccount, bankCreditLimitAccount, cashbackValueSimple, cashbackValueMax, bonusAccountAccrual);
    }

    private void accountAccrualForTopUp(Long amount) {
        if (amount >= 3000) {
            this.bankAccount += bonusAccountAccrual;
            System.out.println("Бонус за пополнение зачислен, в размере -" + bonusAccountAccrual);
        }
    }

    private void cashbackForPay(Long amount) {
        if (amount > 100 && amount < 5000) {
            long cashback = amount / 100;
            bankAccount += cashback * cashbackValueSimple;
            System.out.println("Зачислен кешбек - " + cashback * cashbackValueSimple);
        } else if (amount >= 5000) {
            long cashback = amount / 100;
            bankAccount += cashback * cashbackValueMax;
            System.out.println("Зачислен максимальный кешбек - " + cashback * cashbackValueMax);
        }
    }
}
