package ru.job4j.io.find;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.log4j.UsageLog4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

/**
 * <h2>Поиск файлов по критерию.</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 14.04.2021
 */
public class Finder {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String... args) {
        //try {
            ArgsParser argsParser = ArgsParser.of(args);
        System.out.println(argsParser.get("-d"));
        System.out.println(argsParser.get("-n"));
        System.out.println(argsParser.get("-t"));
        System.out.println(argsParser.get("-o"));
            //Predicate<Path> condition = new Predicate<Path>()


            //List<Path> result = search(start, condition);
        //} catch (IOException e) {
        //    LOG.error(e.getMessage(), e);
        //}
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        Search searcher = new Search(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
