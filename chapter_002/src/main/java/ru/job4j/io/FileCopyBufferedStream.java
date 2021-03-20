package ru.job4j.io;

import java.io.*;

/**
 * Класс демонстрирует пример использования операций буферного потока ввода-вывода.
 * Применяется побайтовая работа с потоком данных на примере чтения и записи файла.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 20.03.2021
 */
public class FileCopyBufferedStream {
    public static void main(String[] args) {
        String inFileStr = "./data/java.bin";
        String outFileStr = "./data/java.png";
        long startTime, elapsedTime;  // для скоростного benchmarking

        // Проверка длинны файла.
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {
            startTime = System.nanoTime();
            int byteRead;
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is "
                    + (elapsedTime / 1000000.0) + " msec");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
