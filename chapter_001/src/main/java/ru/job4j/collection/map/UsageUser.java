package ru.job4j.collection.map;

import java.util.*;

/**
 * При добавлении двух разных объектов в мапу, методом put()
 * происходит расчёт хэш-значения ключа, нативным методом hashCode() класса Object.
 * Далее, для равномерного распределения по бакетам, происходит подмешивание
 * старших бит в область младших и затем рассчитывается индекс бакета.
 *
 * Так-как в моём случае, в мапу отправляю два разных объекта,
 * соответственно хэш-коды разные и они попали в разные бакеты
 * не вызывая при этом метод equals() потому как не было коллизий.
 *<pre>
 * hashCode user1 = 2093176254 -> 1111100 11000011 01010101 10111110
 * hashCode user2 = 1854731462 -> 1101110 10001100 11110100 11000110
 *</pre>
 * Согласно задания, я не переопределял метод hashCode() и в результате получается,
 * что у меня объекты разные, при том, что по содержимому они одинаковые.
 * Мои два объекта, добавленные в мапу, попадут в разные бакеты.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.02.2021
 */
public class UsageUser {
    public static void main(String[] args) {
        User user1 = new User("Viktor", 1,
                new GregorianCalendar(1979, Calendar.AUGUST, 25));
        User user2 = new User("Viktor", 1,
                new GregorianCalendar(1979, Calendar.AUGUST, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        //System.out.println(System.identityHashCode(user1));
        //Возвращаем идентификационный хэш-код
        //который рассчитывается default реализаций метода hashCode()
        //даже если метод переопределён.
    }
}
