### Рассказать и продемонстрировать как переопределяют метод hashCode.

Несколько требований, которыми нужно руководствоваться, при переопределении `hashCode()`:

* При переопределении `equals()` необходимо всегда переопределять `hashCode()`
* Переопределенный `hashCode()` должен всегда давать одинаковый хэш для равных объектов.


Для примера, напишу простой класс **DateOfBirth**:
```
package ru.job4j;
public final class DateOfBirth {
    private final int day;
    private final int month;
    private final int year;
 
    public DateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    //TODO Здесь буду переопределять hashCode()
}
```

Чтобы написать корректный метод `hashCode()` нужно преследовать цель, чтобы метод разбрасывал объекты  равномерно по всему диапазону значений `int`. Для этого существуют отработанные рецепты переопределения `hashCode()`:

1. Объявляем переменную целого типа и инициализируем ее хэш-кодом первого значащего поля нашего объекта. Так как у меня в классе, поле **day** типа `int`, я использую метод `int hashCode(int value)` из класса `Integer`.

```
int result = Integer.hashCode(day);
```

2. Для остальных полей, тоже вычисляем хэш-код и объединяем полученные коды полей, с кодом из пункта 1 который храниться в переменной `result`. Объединить коды методом сложения чисел. 

```
result = 31 * result + Integer.hashCode(month);
result = 31 * result + Integer.hashCode(year);
```

> Умножение на 31 делает хэш-код зависящим от порядка полей и дает лучший код. Это число является нечетным простым числом и это важно.

```
@Override
public int hashCode() {
    int result = Integer.hashCode(day);
    result = 31 * result + Integer.hashCode(month);
    result = 31 * result + Integer.hashCode(year);
    return result;
}
```
Мы получили быстрый метод который хорошо разбрасывает объекты и при этом даёт равные хэш-коды одинаковым объектам.

Можно воспользоваться расчетом кода с помощью реализации на платформе **Java**.

У нас в классе `Objects` есть метод `hashCode()` который принимает на вход массив объектов типа `Object`. Соответственно можно подать на вход этому методу свои поля.

```
@Override
public int hashCode() {
    return Objects.hash(day, month, year);
}
```

Конец.
 
