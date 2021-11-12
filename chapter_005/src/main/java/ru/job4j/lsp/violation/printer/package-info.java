/**
 * Нарушение принципа LSP.
 * <p>
 * Согласно LSP, при наследовании класса PrinterStar от Printer, результат
 * работы должен оставаться неизменным.
 * В первом случае я получаю на консоли число 10, что и следовало ожидать.
 * Во втором случае я получаю 10 звёздочек в ряд. Это нарушение LSP.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
package ru.job4j.lsp.violation.printer;