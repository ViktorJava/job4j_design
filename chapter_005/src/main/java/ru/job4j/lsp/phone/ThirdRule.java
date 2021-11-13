package ru.job4j.lsp.phone;

/**
 * Демонстрируется нарушение состояние объекта потомка,
 * потому, что в нем не соблюдено условие предка. Код -1 проходит,
 * хотя не должен.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class ThirdRule {
    public static void main(String[] args) {
        Subscriber subscriber = new SomeOperatorSubscriber(
                new PhoneNumber(+1, 111, 111_111_111)
        );
        subscriber.setPhoneNumber(
                new PhoneNumber(-1, 111, 111_111_111)
        );
    }
}
