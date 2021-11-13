package ru.job4j.lsp.phone;

/**
 * Подкласс супер-класса Subscriber в котором нарушен принцип LSP, а именно
 * контракт инвариантов. В результате возможно не валидное состояние данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class SomeOperatorSubscriber extends Subscriber {

    public SomeOperatorSubscriber(PhoneNumber phoneNumber) {
        super(phoneNumber);
    }

    /**
     * Сетер телефонного номера. Забыли сделать проверку.
     * Возможно не валидное состояние. Нарушение контракта инвариантов.
     *
     * @param phoneNumber Объект типа PhoneNumber.
     */
    @Override
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
