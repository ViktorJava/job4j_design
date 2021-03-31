package ru.job4j.io.encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Пример работы с кодировкой файлов.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 31.03.2021
 */
public class UsageEncoding {
    /**
     * Метод буферного чтения файла с заданной кодировкой.
     *
     * @param path Путь и имя файла.
     * @return Строки считанные в файле.
     */

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try (
                BufferedReader br = new BufferedReader(new FileReader(path, Charset
                        .forName("WINDOWS-1251")))) {
            int data;
            while ((data = br.read()) > 0) {
                builder.append((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * Метод буферной записи в файл с заданной кодировкой.
     *
     * @param path Путь и имя файла.
     * @param data Данные записываемые в файл.
     */
    public void writeDataInFile(String path, String data) {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(path, Charset
                        .forName("WINDOWS-1251"), true))) {
            bw.write(data + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "C:\\projects\\job4j_design\\chapter_002\\data\\text.txt";
        UsageEncoding ue = new UsageEncoding();
        List<String> strings = List.of(
                "Новая строка 1",
                "Новая строка 2"
        );

        for (String str: strings) {
            ue.writeDataInFile(path, str);
        }
        String s = ue.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);

    }
}
