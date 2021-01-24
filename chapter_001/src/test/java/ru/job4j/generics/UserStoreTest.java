package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 25.01.2021
 */
public class UserStoreTest {
    @Test
    public void test() {
        UserStore userStore = new UserStore();
        User[] users = new User[]{
                new User("user-1"),
                new User("user-2"),
                new User("user-3"),
        };
        userStore.add(users[0]);
        userStore.add(users[1]);
        userStore.add(users[2]);
        assertThat(userStore.findById("user-3"), is(users[2]));
    }
}