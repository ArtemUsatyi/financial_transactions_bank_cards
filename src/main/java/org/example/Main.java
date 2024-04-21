package org.example;

import org.example.credit_card.CreditPremiumCard;
import org.example.credit_card.CreditSimpleCard;
import org.example.debit_card.DebitPremiumCard;
import org.example.debit_card.DebitSimpleCard;
import org.example.service.MenuCommandService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CreditPremiumCard creditPremiumCard = new CreditPremiumCard();
        CreditSimpleCard creditSimpleCard = new CreditSimpleCard();

        DebitSimpleCard debitSimpleCard = new DebitSimpleCard();
        DebitPremiumCard debitPremiumCard = new DebitPremiumCard();

        List<BankCard> cardList = new ArrayList<>();
        cardList.add(debitSimpleCard);
        cardList.add(debitPremiumCard);
        cardList.add(creditSimpleCard);
        cardList.add(creditPremiumCard);

        MenuCommandService.printMenuCommand(cardList);
    }
}