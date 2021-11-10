package ru.job4j.lsp.office;

import java.time.LocalDate;
import java.time.Month;

/**
 * Второй контракт LSP.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
public class SecondRule {
    public static void main(String[] args) {
        WorkDays workDays = new WorkDays();
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 1), 8);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 2), 7);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 3), 6);

        CountingRoom countingRoom = new ShopCountingRoom(3 * 8, 68);
        System.out.println(countingRoom.pay(workDays));
    }
}
