package ru.job4j.cache;

import java.util.Scanner;

/**
 * Реализация кеша на SoftReference [#1592]
 * Функционал:
 * - указать кэшируемую директорию
 * - загрузить содержимое файла в кэш
 * - получить содержимое файла из кэша
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 9/21/2021
 */
public class Emulator {
    public static void main(String[] args) {
        boolean exit = true;
        DirFileCache dirFileCache = null;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[1] Указываем директорию");
            System.out.println("[2] Загружаем файл");
            System.out.println("[3] Выход");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    System.out.println("Введите директорию: ");
                    String dir = scanner.nextLine();
                    dirFileCache = new DirFileCache(dir);
                    break;
                case "2":
                    if (dirFileCache != null) {
                        System.out.println("Введите имя файла: ");
                        String fileName = scanner.nextLine();
                        System.out.println(dirFileCache.get(fileName));
                    }
                    break;
                case "3":
                    exit = false;
                    break;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }
        } while (exit);
    }
}
