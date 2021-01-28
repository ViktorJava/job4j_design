package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

/**
 * Тесты поставщика пользователей.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 25.01.2021
 */
public class UserStoreTest {
    Store<User> userStore = new UserStore();

    @Test
    public void whenFindById() {
        User[] users = new User[]{
                new User("001"),
                new User("002"),
                new User("003"),
        };
        userStore.add(users[0]);
        userStore.add(users[1]);
        userStore.add(users[2]);
        assertThat(userStore.findById("001"), is(users[0]));
    }

    @Test
    public void whenFindByIdFail() {
        userStore.add(new User("001"));
        assertThat(userStore.findById("004"), nullValue());
    }

    @Test
    public void whenReplace() {
        userStore.add(new User("001"));
        userStore.add(new User("002"));
        userStore.add(new User("003"));
        User newUser = new User("new");
        assertThat(userStore.replace("003", newUser), is(true));
        assertThat(userStore.findById("new"), is(newUser));
    }

    @Test
    public void whenDelete() {
        userStore.add(new User("001"));
        userStore.add(new User("002"));
        userStore.add(new User("003"));
        assertThat(userStore.delete("001"), is(true));
        assertThat(userStore.findById("001"), nullValue());
    }

    @Test
    public void whenDelFail() {
        userStore.add(new User("001"));
        userStore.add(new User("002"));
        assertThat(userStore.delete("003"), is(false));
    }
}
