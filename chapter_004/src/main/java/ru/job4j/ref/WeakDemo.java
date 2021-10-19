package ru.job4j.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Поведение GC относительно слабых ссылок на объекты.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/20/2021
 */
@SuppressWarnings("deprecation")
public class WeakDemo {
    public static void main(String[] args) throws InterruptedException {
        //example1();
        //example2();
        example3();
    }

    /**
     * Метод создаёт объект с сильной ссылкой. Далее создаём слабую ссылку
     * на этот объект.  При занулении сильной ссылки,
     * происходит удаление объекта.
     *
     * @throws InterruptedException Возможное исключение.
     */
    private static void example1() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() {
                System.out.println("Removed");
            }
        };
        WeakReference<Object> weak = new WeakReference<>(object);
        object = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(weak.get());
    }

    /**
     * Создаётся сильная ссылка на список объектов со слабыми ссылками. Вызываем
     * GC и он удаляет объекты со слабыми ссылками, несмотря на то, что на них
     * ещё осталась живая сильная ссылка.
     *
     * @throws InterruptedException Possible exception.
     */
    private static void example2() throws InterruptedException {
        List<WeakReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(new WeakReference<>(new Object() {
                @Override
                protected void finalize() {
                    System.out.println("Removed!");
                }
            }));
        }
        System.gc();
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * Очередь ссылок.
     * На объект ссылаются две ссылки, сильная и слабая.
     * После удаления сильной, слабая автоматически удаляется.
     * До объекта можно достучаться через очередь ссылок.
     *
     * @throws InterruptedException Возможное исключение.
     */
    private static void example3() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() {
                System.out.println("Removed");
            }
        };
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weak = new WeakReference<>(object, queue);
        object = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("from link " + weak.get());
        System.out.println("from queue " + queue.poll());
    }
}
