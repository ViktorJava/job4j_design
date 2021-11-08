package ru.job4j.ocp.violation.vehicle;

import java.security.InvalidParameterException;

/**
 * Основной класс который управляет транспортным средством.
 * При добавлении операций (разворот, поворот влево и т.д.)
 * необходимо менять класс VehicleActions метод actions.
 * <p>
 * Код не закрыт от изменений и соответственно не совместим с OCP.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.11.2021
 */
public class VehicleActions {
    public void actions(Actions actions) {
        if (actions == null) {
            throw new InvalidParameterException("Invalid Parameter");
        }

        if (actions instanceof Moves) {
            System.out.println(new Moves().moves());
        } else if (actions instanceof Stopped) {
            System.out.println(new Stopped().stopped());
        }
    }
}
