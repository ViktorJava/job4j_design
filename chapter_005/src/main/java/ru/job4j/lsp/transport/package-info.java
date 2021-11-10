/**
 * Контракты LSP
 * 1. Предусловия (Preconditions) не могут быть усилены в подклассе
 * Предусловие - это условие, которое проверяет корректность аргументов
 * конструктора или метода.
 * <p>
 * Допустим у нас есть класс автотранспорта.
 * Пусть теперь есть наследник - автобус. Предположим ему нужно больше топлива,
 * чтобы сдвинуться с места.
 * <p>
 * От AutoTransport мы ожидаем, что машина сдвинется, но нет.
 * Автобус не сдвигается, т.к. в нем усилено предусловие. Ожидаем мы одно
 * поведение, а получаем другое.
 * Чтобы сдвинуть автобус на придётся дописать доп. условие, чтобы проверить
 * является ли транспорт автобусом. Далее уже скормить ему больше топлива.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 10.11.2021
 */
package ru.job4j.lsp.transport;