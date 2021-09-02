package ru.job4j.gc;

/**
 * Класс моделирующий срабатывание GC.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 8/30/2021
 */
public class UserDemo {
    private static final long KB = 1024;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("======= Environment state =======");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) {
        User userIvanov = new User(1, "Ivan", "Ivanov", 33);
        User userPetrov = new User(257, "Petro", "Petrov", 39);
        userIvanov = null;
        userPetrov = null;
        info();
        System.gc();
    }
}
