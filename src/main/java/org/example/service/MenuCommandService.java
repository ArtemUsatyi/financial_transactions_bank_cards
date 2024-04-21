package org.example.service;

import org.example.BankCard;

import java.util.List;
import java.util.Scanner;

public class MenuCommandService {
    private static final Scanner scanner = new Scanner(System.in);
    static int command;

    public static void printMenuCommand(List<BankCard> cardList) {
        do {
            System.out.println("""
                    C какой банковской картой Вы хотите работать? Введите цифру от 1 до 4:
                    1 - Простая дебитовая карта
                    2 - Премиальная дебитовая карта
                    3 - Простая кредитная карта
                    4 - Премиальная кредитная карта""");

            command = scanner.nextInt();
            switch (command) {
                case (1) -> optionCommand(cardList.get(0));
                case (2) -> optionCommand(cardList.get(1));
                case (3) -> optionCommand(cardList.get(2));
                case (4) -> optionCommand(cardList.get(5));
                default -> System.out.println("Команда не найдена");
            }

            System.out.println("""
                    Желаете продолжить работу с данной картой?
                    1 - да
                    2 - нет""");
            command = scanner.nextInt();
        } while (command != 2);
    }

    public static void optionCommand(BankCard bankCard) {
        do {
            System.out.println("""
                    Выберите команду для карты:
                    1 - Пополнить баланс
                    2 - Совершить оплату
                    3 - Получить информацию о балансе карты
                    4 - Получить полную информацию о карте""");

            command = scanner.nextInt();
            switch (command) {
                case (1) -> {
                    System.out.println("Введите сумму для пополнения:");
                    command = scanner.nextInt();
                    bankCard.topUpAccount((long) command);
                }
                case (2) -> {
                    System.out.println("Введите сумму для оплаты покупки:");
                    command = scanner.nextInt();
                    bankCard.payAccount((long) command);
                }
                case (3) -> System.out.println(bankCard.getInfoAccount());
                case (4) -> System.out.println(bankCard.getInfoAccountAll());
                default -> System.out.println("Команда не найдена");
            }

            System.out.println("""
                    Желаете продолжить работу с данной картой?
                    1 - да
                    2 - нет""");
            command = scanner.nextInt();
        } while (command != 2);
    }
}
