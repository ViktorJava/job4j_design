package ru.job4j.ocp.violation.vehicle;

/**
 * Транспортное средство остановлено.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.11.2021
 */
public class Stopped implements Actions {
    public String stopped() {
        return "Stopped...";
    }
}
