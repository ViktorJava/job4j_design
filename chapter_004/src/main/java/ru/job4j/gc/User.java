package ru.job4j.gc;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 8/30/2021
 */
public class User {
    int id;
    String firstName;
    String lastName;
    int age;

    public User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() {
        System.out.printf("Removed: %d %s%n", id, lastName);
    }
}
