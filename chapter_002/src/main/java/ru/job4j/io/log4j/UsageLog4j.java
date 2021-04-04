package ru.job4j.io.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 04.04.2021
 */
public class UsageLog4j {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
