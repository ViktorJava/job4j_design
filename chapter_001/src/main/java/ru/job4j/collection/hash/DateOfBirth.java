package ru.job4j.collection.hash;

/**
 * Модель класса описывающего дату рождения.
 * В классе переопределяется метод {@code hashCode}
 * согласно рекомендациям Джошуа Блох из книги
 * Effective Java, third edition (глава 3)
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 25.02.2021
 */
public final class DateOfBirth {
    private final int day;
    private final int month;
    private final int year;

    /**
     * Конструктор.
     *
     * @param day   День рождения.
     * @param month Месяц рождения.
     * @param year  Год рождения.
     */
    public DateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(day);
        result = 31 * result + Integer.hashCode(month);
        result = 31 * result + Integer.hashCode(year);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DateOfBirth that = (DateOfBirth) o;
        return day == that.day && month == that.month && year == that.year;
    }
}
