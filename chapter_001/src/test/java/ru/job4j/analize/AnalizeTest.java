package ru.job4j.analize;

import org.junit.Test;
import ru.job4j.analize.Analize.Info;
import ru.job4j.analize.Analize.User;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты анализатора статистики по коллекциям.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 04.03.2021
 */
public class AnalizeTest {

    @Test
    public void whenDeleted() {
        List<User> previous = List.of(
                new User(1, "a"),
                new User(2, "b")
        );
        List<User> current = List.of(new User(1, "a"));
        Info res = new Analize().diff(previous, current);
        assertThat(res.deleted, is(1));
    }

    @Test
    public void whenChangesAndAddition() {
        List<User> previous = List.of(
                new User(1, "a"),
                new User(2, "b")
        );
        List<User> current = List.of(
                new User(1, "a"),
                new User(2, "c"),
                new User(3, "d")
        );
        Info res = new Analize().diff(previous, current);
        assertThat(res.changed, is(1));
        assertThat(res.added, is(1));
    }

    @Test
    public void whenAddition() {
        List<User> previous = List.of(new User(1, "a"));
        List<User> current = List.of(new User(1, "c"),
                new User(2, "b")
        );
        Info res = new Analize().diff(previous, current);
        assertThat(res.added, is(1));
    }
}
