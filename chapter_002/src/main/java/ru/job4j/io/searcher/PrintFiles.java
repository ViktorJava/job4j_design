package ru.job4j.io.searcher;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Это специальный класс, в котором инкапсулируется вся логика обхода дерева файлов.
 * Поместил сюда всю логику поиска файлов по определённому предикату.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.03.2021
 */
public class PrintFiles implements FileVisitor<Path> {
    List<Path> paths;
    Predicate<Path> condition;

    /**
     * Конструктор.
     *
     * @param condition Предикат разыскиваемых файлов.
     */
    public PrintFiles(Predicate<Path> condition) {
        this.paths = new ArrayList<>();
        this.condition = condition;
    }

    /**
     * Гетер.
     *
     * @return Список файлов.
     */
    public List<Path> getPaths() {
        return paths;
    }

    /**
     * Здесь мы и описываем что нужно делать с каждым файлом в каждой директории.
     *
     * @param file  Ссылка на файл.
     * @param attrs Основные атрибуты просматриваемого файла.
     * @return Продолжаем обход дерева CONTINUE.
     * @throws IOException При возникновении IO исключений.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
            paths.add(file);
        }
        return CONTINUE;
    }

    /**
     * Вызывается после посещения всех записей в каталоге.
     *
     * @param dir   Ссылка на каталог.
     * @param attrs Основные атрибуты файла.
     * @return Результат посещения.
     * @throws IOException При возникновении IO исключений.
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    /**
     * Вызывается, когда к файлу невозможно получить доступ.
     *
     * @param file Ссылка на файл.
     * @param exc  Исключение ввода-вывода, препятствовавшее посещению файла.
     * @return Результат посещения.
     * @throws IOException При возникновении IO исключений.
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    /**
     * Вызывается для каталога после посещения записей в каталоге
     * и всех их потомках. Этот метод также вызывается,
     * когда итерация каталога завершается преждевременно.
     *
     * @param dir Ссылка на каталог.
     * @param exc null если итерация каталога завершилась без ошибок;
     *            в противном случае исключение ввода-вывода,
     *            которое привело к преждевременному завершению
     *            итерации каталога.
     * @return Результат посещения.
     * @throws IOException При возникновении IO исключений.
     */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}
