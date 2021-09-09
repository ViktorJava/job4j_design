package ru.job4j.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс предназначен для заполнения памяти, с целю мониторинга
 * срабатывания GC.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/8/2021
 */
public class GCTypeDemo2 {
    private static Map<String, String> sContainer = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Start of program!");
        String stringWithPrefix = "stringWithPrefix";

        // Load Java Heap with 3 M java.lang.String instances
        for (int i = 0; i < 3000000; i++) {
            String newString = stringWithPrefix + i;
            sContainer.put(newString, newString);
        }
        System.out.println("MAP size: " + sContainer.size());

        // Explicit GC!
        System.gc();

        // Remove 2 M out of 3 M
        for (int i = 0; i < 2000000; i++) {
            String newString = stringWithPrefix + i;
            sContainer.remove(newString);
        }

        System.out.println("MAP size: " + sContainer.size());
        System.out.println("End of program!");
    }
}
