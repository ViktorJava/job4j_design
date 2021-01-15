package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h2>0. Что такое обобщенные типы (generics) [#438904]</h2>
 * Добавить 3 модели данных, которые образуют иерархию наследования:
 * {@link Animal} -> {@link Predator} -> {@link Tiger}
 * Написать код использующий модели.
 * @implNote
 * <li>1-ый метод - работает без ограничений, т.е. в него можно передавать
 * коллекцию, которая хранит любые типы.
 * <li>2-ой метод - должен иметь ограничение сверху и
 * ограничиваться классом {@link Predator}.
 * <li>3-ий метод - должен иметь ограничение снизу и
 * ограничиваться классом {@link Predator}.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.01.2021
 */
public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("Animal", 12000));
        second.add(new Predator("Predator", 120));
        third.add(new Tiger("Tiger", 6));

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
    }

    /**
     * <h2>WildCard.</h2>
     * Метод - работает без ограничений, т.е. в него можно передавать
     * коллекцию, которая хранит любые типы.
     *
     * @param list Список данных любого типа.
     */
    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * <h2>Bounded WildCard.</h2>
     * Метод - должен иметь ограничение сверху и
     * ограничиваться классом {@link Predator}.
     *
     * @param list Список данных.
     */
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * <h2>Lower bounded WildCard</h2>
     * Метод - должен иметь ограничение снизу и
     * ограничиваться классом {@link Predator}.
     *
     * @param list Список данных.
     */
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}
