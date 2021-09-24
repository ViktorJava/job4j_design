package ru.job4j.ref;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Поведение GC относительно безопасных ссылок на объекты.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/20/2021
 */
public class SoftDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        //example1();
        //example2();
        //example3();
        example4();
    }

    /**
     * несмотря на то, что мы зануляем сильную ссылку,
     * на объект остается безопасная ссылки,
     * а это значит объект будет удален только при нехватке памяти.
     */
    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    /**
     * Метод добавляет в список безопасные ссылки на объекты
     * с переопределённым методом finalize и полем типа String. Срабатывает GC
     * и фиксируем количество выживших объектов после дефицита
     * heap и срабатывания GC.
     */
    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 13_000_000; i++) {
            objects.add(new SoftReference<>(new Object() {
                final String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref: objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    /**
     * Упрощенный вариант предыдущего метода.
     *
     * @throws InterruptedException possible exception.
     */
    private static void example3() throws InterruptedException {
        List<SoftReference<String>> strings = new ArrayList<>();
        for (int i = 0; i < 30_000_000; i++) {
            strings.add(new SoftReference<>(
                    String.valueOf(System.currentTimeMillis())));
        }
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        int live = 0;
        for (SoftReference<String> s: strings) {
            String ref = s.get();
            if (ref != null) {
                live++;
            }
        }
        System.out.println(live);
    }

    /**
     * Пример того, как нужно безопасно работать с SoftReference.
     *
     * @throws IOException possible exception.
     */
    private static void example4() throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("logFile.log"));
        SoftReference<String> softReference = new SoftReference<>(br.readLine());
        String data = softReference.get();
        if (data != null) {
            //работаем с данными файла.
            System.out.println(data);
        }
    }
}
