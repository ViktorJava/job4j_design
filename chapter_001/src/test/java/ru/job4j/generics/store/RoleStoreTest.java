package ru.job4j.generics.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Тесты поставщика ролей.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 29.01.2021
 */
public class RoleStoreTest {
    Store<Role> roleStore = new RoleStore();

    @Test
    public void whenFindById() {
        Role[] roles = new Role[]{
                new Role("001"),
                new Role("002"),
                new Role("003"),
        };
        roleStore.add(roles[0]);
        roleStore.add(roles[1]);
        roleStore.add(roles[2]);
        assertThat(roleStore.findById("001"), is(roles[0]));
    }

    @Test
    public void whenFindByIdFail() {
        roleStore.add(new Role("001"));
        assertThat(roleStore.findById("004"), nullValue());
    }

    @Test
    public void whenReplace() {
        roleStore.add(new Role("001"));
        roleStore.add(new Role("002"));
        roleStore.add(new Role("003"));
        Role newUser = new Role("new");
        assertThat(roleStore.replace("003", newUser), is(true));
        assertThat(roleStore.findById("new"), is(newUser));
    }

    @Test
    public void whenDelete() {
        roleStore.add(new Role("001"));
        roleStore.add(new Role("002"));
        roleStore.add(new Role("003"));
        assertThat(roleStore.delete("001"), is(true));
        assertThat(roleStore.findById("001"), nullValue());
    }

    @Test
    public void whenDelFail() {
        roleStore.add(new Role("001"));
        roleStore.add(new Role("002"));
        assertThat(roleStore.delete("003"), is(false));
    }
}
