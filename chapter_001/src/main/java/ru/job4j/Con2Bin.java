package ru.job4j;

/**
 * Конвертация числа в десятичной системе исчисления в число в двоичной
 * системе исчисления.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.02.2021
 */
public class Con2Bin {
    /**
     * Метод конвертации двух числе.
     *
     * @param num Десятичное число.
     * @return Двоичное число.
     */

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(binary(2093176254));
        System.out.println(binary(1854731462));
    }
}
