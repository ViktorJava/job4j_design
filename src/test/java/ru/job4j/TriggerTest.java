package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 03.01.2021
 */
public class TriggerTest {
    @Test
    public void test() {
        Assert.assertEquals(1, new Trigger().someLogic());
    }
}