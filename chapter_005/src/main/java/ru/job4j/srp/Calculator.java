package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Нарушение принципов SRP.
 * <p>
 * Калькулятор жизни.
 * Каждый метод, класс, объект должны иметь одну ответственность,
 * в моём случае, я в одном классе и считаю и вывожу результаты на экран и
 * делаю опрос клавиатуры, при том, что полностью отсутствуют абстракции.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 05.11.2021
 */
public class Calculator {
    public static void main(String[] args) {
        Date date = new Date();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "E dd.MM.yyyy 'и время: 'k:mm"
        );
        System.out.println("Сколько вам лет?");
        int age = sc.nextInt();

        int months = age * 12;
        int weeks = age * 52;
        int days = age * 365;
        int hours = days * 24;
        int minutes = hours * 60;

        System.out.println("Сегодня :" + simpleDateFormat.format(date));
        System.out.print("Вы прожили жизнь за : ");
        System.out.println(months + " месяцев.");
        System.out.println("другими словами " + weeks + " недель.");
        System.out.println("или, около " + days + " дней");
        System.out.println("или " + hours + " часов.");
        System.out.println("а точнее " + minutes + " минут.");
        System.out.println("Жизнь коротка, наслаждайтесь :) ");
    }
}
