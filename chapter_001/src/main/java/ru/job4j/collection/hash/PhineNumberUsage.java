package ru.job4j.collection.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Как переопределяют метод hashCode.</h2>
 * На данном примере, я отрабатывал переопределение {@code hashCode}.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 25.02.2021
 */
public class PhineNumberUsage {
    public static void main(String[] args) {
        Map<DateOfBirth, String> hashMap = new HashMap<>();
        DateOfBirth person = new DateOfBirth(22, 8, 1979);
        DateOfBirth humanoid = new DateOfBirth(22, 8, 1979);
        hashMap.put(person, "Viktor");
        hashMap.put(humanoid, "Android");
        System.out.println(person.hashCode());
        System.out.println(humanoid.hashCode());
        System.out.println(hashMap.size());
    }
}
