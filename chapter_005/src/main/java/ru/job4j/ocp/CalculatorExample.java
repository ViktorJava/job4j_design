package ru.job4j.ocp;

import java.util.function.BiFunction;

/**
 * Класс демонстрирует пример того, как можно писать код не нарушая принцип OCP
 * и как нельзя.
 * <p>
 * При необходимости добавить операции в калькулятор SimpleCalculator,
 * необходимо изменить клас, добавив ExtendsCalculator,
 * что нежелательно и является нарушением принципа OCP.
 * <p>
 * В классе AbstractCalculator для добавления других операций, необходимо
 * передать соответствующую лямбду на вход метода  calculate. Код закрыт от
 * изменений и открыт к расширению.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.11.2021
 */
public class CalculatorExample {
    /**
     * Пример простого калькулятора сложения двух чисел. При необходимости
     * добавить возможность например деления двух чисел, нарушится принцип OCP,
     * по причине открытости кода к изменениям.
     */
    public static class SimpleCalculator {
        /**
         * Метод сложения двух чисел.
         *
         * @param a Первое число.
         * @param b Второе число.
         * @return Результат сложения двух чисел.
         */
        public int sum(int a, int b) {
            return a + b;
        }
    }

    /**
     * Пример расширения функционала калькулятора через наследование и
     * соответственно нарушая принцип OCP. Код является открытым к изменениям.
     */
    public static class ExtendsCalculator extends SimpleCalculator {
        /**
         * Метод умножения двух чисел.
         *
         * @param a Первое число.
         * @param b Второе число.
         * @return Результат умножения двух чисел.
         */
        public int multi(int a, int b) {
            return a * b;
        }
    }

    /**
     * Универсальный калькулятор закрыт к изменениям и открыт к расширению.
     *
     * @param <T> Тип операндов.
     */
    public static class AbstractCalculator<T> {
        /**
         * Метод калькулятора.
         *
         * @param function Лямбда выражение выполняемой операции над двумя
         *                 числами типа T.
         * @param first    Первое число.
         * @param second   Второе число.
         * @return Результат применения лямбды операции к двум числам.
         */
        public T calculate(BiFunction<T, T, T> function, T first, T second) {
            return function.apply(first, second);
        }
    }
}
