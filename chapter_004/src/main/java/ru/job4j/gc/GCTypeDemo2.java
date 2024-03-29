package ru.job4j.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс предназначен для заполнения памяти, с целю мониторинга
 * срабатывания GC.
 * <blockquote><pre>
 * Load Java Heap with 3 M java.lang.String instances
 * for (int i = 0; i{@literal <} 3000000; i++) {
 * Explicit GC!
 * System.gc();
 * Remove 2 M out of 3 M
 * for (int i = 0; i{@literal <} 2000000; i++)
 * </pre></blockquote>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/8/2021
 */
public class GCTypeDemo2 {
    private static final Map<String, String> CONTAINER = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Start of program!");
        String stringWithPrefix = "stringWithPrefix";

        for (int i = 0; i < 3000000; i++) {
            String newString = stringWithPrefix + i;
            CONTAINER.put(newString, newString);
        }
        System.out.println("MAP size: " + CONTAINER.size());

        System.gc();

        for (int i = 0; i < 2000000; i++) {
            String newString = stringWithPrefix + i;
            CONTAINER.remove(newString);
        }

        System.out.println("MAP size: " + CONTAINER.size());
        System.out.println("End of program!");
    }
}
