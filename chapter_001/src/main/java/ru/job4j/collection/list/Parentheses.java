package ru.job4j.collection.list;

import java.util.Stack;

/**
 * Открытые и закрытые скобки.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/22/2021
 */
public class Parentheses {
    /**
     * Метод проверки корректности открытых и закрытых скобок.
     * Например: ()(()((()))) - true, ()) - false
     *
     * @param data Скобки в виде массива символов.
     * @return true в случае корректных скобок, иначе false.
     */
    public static boolean valid(char[] data) {
        Stack<Character> s = new Stack<>();
        for (char c: data) {
            if (c == '(') {
                s.push(c);
            } else if (!s.empty()) {
                s.pop();
            }
        }
        return s.empty();
    }
}
