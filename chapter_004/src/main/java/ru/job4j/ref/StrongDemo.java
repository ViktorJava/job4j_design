package ru.job4j.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Поведение GC относительно сильных ссылок на объекты.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/20/2021
 */

public class StrongDemo {

    public static void main(String[] args) throws InterruptedException {
        //example1();
        //example2();
        example3();
    }

    /**
     * Метод создаёт сильную ссылку на массив объектов.
     * Массив заполняется сильными ссылками на объекты
     * с переопределённым методом. После зануления сильных ссылок на объекты
     * расположенные в массиве, работает GC и удаляет объекты освобождая heap.
     *
     * @throws InterruptedException Possible exception.
     */
    private static void example1() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object() {
                @Override
                protected void finalize() {
                    System.out.println("Object removed!");
                }
            };
            for (int j = 0; j < objects.length; j++) {
                objects[i] = null;
            }
            System.gc();
            TimeUnit.SECONDS.sleep(5);
        }
    }

    /**
     * Метод создаёт сильную ссылку на массив объектов.
     * Массив заполняется сильными ссылками на объекты с переопределённым
     * методом finalize. После того как в массиве зануляются сильные ссылки,
     * работает GC и удаляет объекты с занулёнными ссылками.
     *
     * @throws InterruptedException possible exception.
     */
    private static void example2() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            Object object = new Object() {
                final Object innerObject = new Object() {
                    @Override
                    protected void finalize() {
                        System.out.println("Remove inner object!");
                    }
                };
            };
            objects[i] = object;
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * Метод бесконечно добавляет в список, сильные ссылки на объекты
     * типа String, пока не закончиться heap.
     */
    private static void example3() {
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add(String.valueOf(System.currentTimeMillis()));
        }
    }
}
