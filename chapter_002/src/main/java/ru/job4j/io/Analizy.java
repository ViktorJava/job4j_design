package ru.job4j.io;

import java.io.*;

/**
 * <h2>Анализ доступности сервера.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.03.2021
 */
public class Analizy {
    private boolean flag = true;
    StringBuilder sb = new StringBuilder();

    /**
     * Метод должен находить диапазоны, когда сервер не работал.
     * Сервер не работал. если status = 400 или 500.
     * Диапазоном считается последовательность статусов 400 и 500
     *
     * @param source Имя файла лога.
     * @param target Имя файла после анализа.
     */
    public void unavailable(String source, String target) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(source));
            in.lines().forEach(line -> {
                if ((line.startsWith("500") || line.startsWith("400")) && flag) {
                    flag = false;
                    sb.append(line.substring(4)).append("-");
                }
                if ((line.startsWith("200") || line.startsWith("300")) && !flag) {
                    flag = true;
                    sb.append(line.substring(4))
                      .append(";")
                      .append(System.lineSeparator());
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sav(target);
    }

    /**
     * Метод записывает результаты анализа в файл.
     *
     * @param target Имя файла.
     */
    private void sav(String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
