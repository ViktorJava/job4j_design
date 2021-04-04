package ru.job4j.io.log4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Пример класса, работы с библиотекой логирования slf4j.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 04.04.2021
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        double cash = 100.5;
        boolean probability = true;
        char index = 'A';
        long ln = 92237;
        short sh = 32767;
        byte by = 127;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("available : {} thousand dollars.", cash);
        LOG.debug("probability : {}, index : {}.", probability, index);
        LOG.debug("long : {}, short {}, byte {}.", ln, sh, by);
    }
}
