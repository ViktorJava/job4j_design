package ru.job4j.jdbc.phonebook;

import java.io.Serializable;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.05.2021
 */
public class Entity implements Serializable, Cloneable {
    public int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
