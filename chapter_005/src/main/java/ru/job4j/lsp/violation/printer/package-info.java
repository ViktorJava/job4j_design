/**
 * Принцип LSP.
 * <p>
 * Нарушение контракта инвариантов.
 * Все условия базового класса-также должны быть сохранены и в подклассе.
 * В данном случае, в подклассе SuperPrinter утеряны условия проверяющие
 * наличие бумаги в принтере. В результате принтер печатает без бумаги
 * как настоящий супер-принтер.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 12.11.2021
 */
package ru.job4j.lsp.violation.printer;