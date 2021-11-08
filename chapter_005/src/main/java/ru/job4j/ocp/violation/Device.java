package ru.job4j.ocp.violation;

/**
 * Неправильно спроектирован класс:
 * есть поведение которое может не соответствовать объекту.
 * Не все электронные устройства с экраном. Некоторые устройства без экрана.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.11.2021
 */
public class Device {
    public void screen() {
        System.out.println("Screen on");
    }
}
