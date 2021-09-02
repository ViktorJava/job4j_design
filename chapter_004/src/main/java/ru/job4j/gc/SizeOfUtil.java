package ru.job4j.gc;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.Collection;

/**
 * Измерение занимаемого объектом объёма heap памяти.
 * Применение com.carrotsearch.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 8/30/2021
 */
public class SizeOfUtil {
    public enum SizeEnum {
        B {
            @Override
            public double getFromByteSize(long byteSize) {
                return byteSize;
            }
        },
        K {
            @Override
            public double getFromByteSize(long byteSize) {
                return byteSize * 1.0 / 1024;
            }
        },
        M {
            @Override
            public double getFromByteSize(long byteSize) {
                return byteSize * 1.0 / 1024 / 1024;
            }
        },
        G {
            @Override
            public double getFromByteSize(long byteSize) {
                return byteSize * 1.0 / 1024 / 1024 / 1024;
            }
        };

        public abstract double getFromByteSize(long byteSize);
    }

    public static double getObjectSize(Object o, SizeEnum sizeEnum) {
        long byteSize;
        if (o instanceof Collection<?>) {
            byteSize = RamUsageEstimator.sizeOfAll(o);
        } else {
            byteSize = RamUsageEstimator.sizeOf(o);
        }
        return sizeEnum.getFromByteSize(byteSize);
    }

    public static void main(String[] args) {
        User userIvanov = new User(1, "Ivan", "Ivanov", 33);
        User userPetrov = new User(257, "Petro", "Petrov", 39);
        System.out.println(getObjectSize(userPetrov, SizeEnum.B));
        System.out.println(getObjectSize(userIvanov, SizeEnum.B));
    }
}
