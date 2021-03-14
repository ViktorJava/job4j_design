package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * <h2>Анализ доступности сервера.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.03.2021
 */
public class Analizy {

    /**
     * Метод должен находить диапазоны, когда сервер не работал.
     * Сервер не работал. если status = 400 или 500.
     * Диапазон считается последовательность статусов 400 и 500
     *
     * @param source Имя файла лога.
     * @param target Имя файла после анализа.
     */
    public void unavailable(String source, String target) {
        //TODO : Code here.
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
