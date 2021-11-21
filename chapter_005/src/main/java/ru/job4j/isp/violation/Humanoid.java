package ru.job4j.isp.violation;

/**
 * Интерфейс человекоподобного существа прибывшего на Землю с другой планеты.
 * Теоретически, не все гуманоиды спят и уже тем более не у всех есть кровь.
 * А некоторые гуманоиды возможно летают.
 *
 * Поэтому, будет правильнее, разделить гуманоидов на теплокровных, летающих,
 * прямоходящих.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.11.2021
 */
public interface Humanoid {
    void doWork();

    boolean walk();

    boolean doSleep();

    String getBloodGroup();
}
