[Перейти на домашнюю страницу](../README.md)

# Блок 3 - SQL, JDBC.
> Изученные темы в процессе прохождения блока.

## 0. Настройка PostgreSQL. 
* Теория. **pgAdmin**, **psql**, **IDEA**: подключение к **DB**. Создание **DB** и подключение к созданной **DB**.
## 1. Create Update Insert
* [Что такое база данных.](https://github.com/ViktorJava/job4j_design/issues/61) Cоздание базы данных магазина автомобилей. Заполнение базы данных, обновление данных, чтение данных, удаление данных.
* Связи между таблицами. Практическая отработка навыков в отношениях между сущнойстями: **many-to-one и one-to-many, many-to-many, one-to-one.**
* [Схема прав, пользователи и роли.](https://github.com/ViktorJava/job4j_design/issues/61) Создание **sql** скриптов.

## 1. Query.
* **Select**. Извлечение данных из таблицы. Фильтрация, операторы сравнения, оператор сравнения строк **LIKE**, логические операторы **AND, OR**, работа с датами, упорядочивание выборки **ORDER BY**, выборка уникальных элементов **SELECT DISTINCT**, выборка определенного числа элементов **LIMIT**.

* [Inner join и альясы.](https://github.com/ViktorJava/job4j_design/issues/63) Создать две таблицы и связь между ними. Написать 3 запроса с **inner join** с использованием альясов.
* [Группировка и агрегатные функции.](https://github.com/ViktorJava/job4j_design/issues/64) Даны две таблицы: **devices** и **people**. Заполнить таблицы данными и далее выбирать данные по разным критериям (вывести для каждого человека среднюю цену его устройств).
* [Фильтры.](https://github.com/ViktorJava/job4j_design/issues/65) Склад продуктов. Создать 2 таблицы: продукты и тип продуктов. Далее с помощью запросов выбирать продукты по различным критериям (написать запрос, который выводит самый дорогой продукт).
## 2. Outer join.
* [Join](https://github.com/ViktorJava/job4j_design/issues/66). Даны две сущности, представленные в таблицах **departments** и **emploees**. Отношение **one-to-many**. Применяя различные **join** выбрать данные из таблиц (используя **left join** найти департаменты, у которых нет работников) 
* [Хранилище машин](https://github.com/ViktorJava/job4j_design/issues/67). Создать структуры данных: детали машин и машины. Вывести список всех машин и все привязанные к ним детали и так далее.
## 3. JDBC
* [Подключение к БД](https://github.com/ViktorJava/job4j_design/issues/68). Подключение **dependency**. Работа с **properties** файлами.
* [Statement](https://github.com/ViktorJava/job4j_design/issues/70). Реализовать методы:
    1) `createTable()` – создает пустую таблицу без столбцов с указанным именем;
    2) `dropTable()` – удаляет таблицу по указанному имени;
    3) `addColumn()` – добавляет столбец в таблицу;
    4) `dropColumn()` – удаляет столбец из таблицы;
    5) `renameColumn()` – переименовывает столбец.
* **PrepareStatement**. Применение на прктике, операций:  **INSERT, SELECT, UPDATE, DELETE** и методов: `execute()`, `executeUpdate()`, `executeQuery()`. Получение **id** вставленного элемента.
* [Sql схема для проекта Tracker](https://github.com/ViktorJava/job4j_tracker/issues/3). Проект учёта заявок. Создание схемы.
* [Трекер SQL](https://github.com/ViktorJava/job4j_tracker/issues/4). Перевод проекта из **Memory storage** в **SQL Storage**.
* [Загрузка базы спамеров](https://github.com/ViktorJava/job4j_design/issues/74). Создание базы данных для спамеров.
* [Liquibase. Интеграционные тесты. Proxy](https://github.com/ViktorJava/job4j_tracker/issues/5). Конфигурирование **Maven**. Интеграционные тесты со схемой **ConnectionRollback**.
* [Travis CI и PostgreSQL](https://github.com/ViktorJava/job4j_tracker/issues/6).
## 4. Проект. Агрегатор Java вакансий
* [Техническое задание](https://github.com/ViktorJava/Job4j_grabber/issues/1). Система запускается по расписанию. Период запуска указывается в настройках - **app.properties**. Первый сайт будет **sql.ru**. В нем есть раздел **job**. Программа должна считывать все вакансии относящиеся к **Java** и записывать их в базу. Доступ к интерфейсу будет через **REST API**.
* [Quartz](https://github.com/ViktorJava/job4j_grabber/issues/2). Выполнение действий с периодичностью. Подключение, конфигурирование, создание задачи, создание расписания. Задача выполняется через триггер. Загрузка задачи и триггера в планировщик.
* [Job c параметрами](https://github.com/ViktorJava/job4j_grabber/issues/3). Открыть и закрывать соединение с базой накладно. Чтобы этого избежать коннект к базе будет создаваться при старте. Объект коннект будет передаваться в **Job**. **Quartz** создает объект **Job**, каждый раз при выполнении работы.
* [Парсинг HTML страницы](https://github.com/ViktorJava/job4j_grabber/issues/4). Подключение **jsoup**. Парсинг необходимой информации с сайта: https://www.sql.ru/forum/job-offers
* [Преобразование даты](https://github.com/ViktorJava/job4j_grabber/issues/5). Преобразование даты из формата `String` в дату.
* [Парсинг https://www.sql.ru/forum/job-offers/3](https://github.com/ViktorJava/job4j_grabber/issues/6). Парсинг заданного количества страниц сайта.
* [Модель данных - Post](https://github.com/ViktorJava/job4j_grabber/issues/7). Создание модели данных.
* [Загрузка деталей поста](https://github.com/ViktorJava/job4j_grabber/issues/8). Создание метода загрузки деталей объявления.
* [SqlRuParse](https://github.com/ViktorJava/job4j_grabber/issues/10). Создание интерфейса описывающего парсинг сайта.
* [Архитектура проекта](https://github.com/ViktorJava/job4j_grabber/issues/11). Опишем наш проект с позиции архитектуры: модель данных, хранилище, извлечение данных с сайта, периодический запуск.
* [Схема таблицы Post](https://github.com/ViktorJava/job4j_grabber/issues/12). Создаём `sql schema` для проекта агрегатор.
* [PsqlStore](https://github.com/ViktorJava/job4j_grabber/issues/13). Реализуем интерфейс **Store** в классе **PsqlStore**. Пишем интерфейс **Store**: 
    1) `void save(Post post);`
    2) `List<Post> getAll();`
    3) `Post findById(String id);`
    
* [Grabber](https://github.com/ViktorJava/job4j_grabber/issues/14). Cоединим отдельные части в целое приложение.
* [Web](https://github.com/ViktorJava/job4j_grabber/issues/15). Прикрутим сервер к нашему грабберу.


## 5. Контрольные вопросы. SQL. JDBC.
1. Что такое первичный ключ?
2. Что такое внешний ключ?
3. Что такое нормализация БД?
4. Что такое денормализация БД? Для чего она нужна?
5. Что такое кластерный и некластерный индекс?
6. Какие типы соединений (**join**) таблиц существуют? В чем их разница?
7. Что такое **SQL** курсор?
8. Опишите шаги по созданию и использованию курсора?
10. Что такое транзакция?
11. Что такое триггер? (Какие типы триггеров вы знаете?)
12. В чем разница между **WHERE** и **HAVING**?
13. Что такое подзапрос (**sub-query**)?
14. Что такое **union**?
15. Что такое **group by**
17. Что такое хранимые процедуры?
18. Что такое **view**(Представление)?
19. Опишите процесс создания запроса через **JDBC**.
20. Для чего используется конструкция **try-with-resources**.

### 5.1. SQL Select by company.
* [С целью, закрепления полученных знаний, необходимо выполнить задание.](https://github.com/ViktorJava/job4j_design/issues/75).

### 5.2. Доп. задание.
* [По результатам проверки знаний, ментором, наверняка будет предложено выполнить техническое задание.]()

## 6. Дополнительная литература
В качестве дополнительной литературы используется:
 
1. **Head First SQL**, Линн Бейли
2. Официальная документация по **Postgresql** https://www.postgresql.org/docs/. Русский вариант - postgrespro.ru https://postgrespro.ru/docs/
3. **JDBC и SQL:** а) **Java** промышленное программирование - И. Н. Блинов, В. С. Романчик. Глава 20 **JDBC** (стр. 479) 

## Лицензия

[MIT. Free Software!](https://github.com/ViktorJava/job4j/tree/master/LICENSE)

---

[Перейти на домашнюю страницу](../README.md)
