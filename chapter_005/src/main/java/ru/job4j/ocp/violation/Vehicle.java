package ru.job4j.ocp.violation;

/**
 * При наследовании этого класса, потомок получает состояние предка:
 * может получиться, что у корабля будут колёса.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.11.2021
 */
public class Vehicle {
    private int wheels;

    public void run() {
        System.out.println("Вперёд...");
    }
}

class Ship extends Vehicle {
    //Корабль получил колёса.
}
